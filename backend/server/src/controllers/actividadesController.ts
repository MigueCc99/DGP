import { Request, Response } from 'express';

import pool from '../database'
import { Feedback } from '../models/feedback';

class ActividadesController {

    public async list (req: Request, res: Response): Promise<void> {
        await pool.query('SELECT * FROM actividades', function(err, result, fields) {
            if (err) throw err;
            res.json(result);
        });
    }

    public async getOne (req: Request, res: Response): Promise<void> {
        const id = req.params.id;
        await pool.query('SELECT * FROM actividades WHERE id=?',[id], function(err, result, fields) {
            if (err) throw err;
            if (result.length > 0) {
                return res.json(result[0]);
            }
            res.status(404).json({message: "La actividad no existe"});
        });
    }

    public async getFeedback (req: Request, res: Response): Promise<void> {
        const id = req.params.id;   
        var feedback : Feedback = new Feedback();
        feedback.id_actividad = parseInt(id);

        var query = "SELECT feedback.id_actividad,"
        + " (SELECT COUNT(*) FROM actividad_asignada_socio WHERE id_actividad=feedback.id_actividad AND es_util IS NOT NULL)   as votos ,"
        + " (SELECT COUNT(*) FROM actividad_asignada_socio WHERE id_actividad=feedback.id_actividad AND es_util=1)  as utiles,"
        + " (SELECT COUNT(*) FROM actividad_asignada_socio WHERE id_actividad=feedback.id_actividad AND es_dificil=1)  as dificiles,"
        + " (SELECT COUNT(*) FROM actividad_asignada_socio WHERE id_actividad=feedback.id_actividad AND es_gustado=1)  as gustados "
        + " FROM (SELECT DISTINCT id_actividad FROM actividad_asignada_socio WHERE id_actividad=?) feedback";

        await pool.query( query, [id], (err, result, fields) => {
                if (err) throw err;
                return res.json(result[0]);
            }
        )
    }

    public async getVotosFeedback(req: Request, res: Response): Promise<void> {
        const id = req.params.id;   
        
    }

    public async create (req: Request, res: Response): Promise<void> {
        await pool.query('INSERT INTO actividades set ?', [req.body]);
        res.json({message: 'Actividad creada'});
    }

    public async delete (req: Request, res: Response): Promise<void> {
        const {id} = req.params;
        await pool.query('DELETE FROM actividades WHERE id=?',[id]);
        res.json({message: "La actividad fue eliminada"});
    }

    public async update (req: Request, res: Response): Promise<void> {
        const {id} = req.params;
        await pool.query('UPDATE actividades set ? WHERE id=?',[req.body, id]);
        res.json({message: "La actividad fue actualizada"});
    }

    public async getObjetivosDeActividad (req: Request, res: Response): Promise<void> {
        const id = req.params.id;
        await pool.query('SELECT * FROM objetivos WHERE id in (SELECT id_objetivo FROM actividad_pertenece_objetivo WHERE id_actividad=?)',[id], function(err, result, fields) {
            if (err) throw err;
            res.json(result);
        });
    }

}

export const actividadesController = new ActividadesController();