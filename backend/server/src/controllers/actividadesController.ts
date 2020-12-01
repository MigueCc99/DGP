import { Request, Response } from 'express';

import pool from '../database'

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

    public async create (req: Request, res: Response): Promise<void> {
        await pool.query('INSERT INTO actividades set ?', [req.body]);
        res.json({message: 'Actividad creada'});
    }

    public async delete (req: Request, res: Response): Promise<void> {
        const id = req.params;
        await pool.query('DELETE FROM actividades WHERE id=?',[id], function(err, result, fields) {
            if (err) throw err;
            res.json({message: "La actividad fue eliminada"});
        });
    }

    public async update (req: Request, res: Response): Promise<void> {
        const id = req.params;
        await pool.query('UPDATE actividades set ? WHERE id=?',[req.body, id], function(err, result, fields) {
            if (err) throw err;
            res.json({message: "La actividad fue actualizada"});
        });
    }

    public async getActividadesAsignadasASocio (req: Request, res: Response): Promise<void> {
        const id = req.params.id;
        await pool.query('SELECT * FROM actividades WHERE id in (SELECT id_actividad FROM actividad_asignada_socio WHERE id_socio=?)',[id], function(err, result, fields) {
            if (err) throw err;
            res.json(result);
        });
    }

    public async getActividadesDeObjetivo (req: Request, res: Response): Promise<void> {
        const id = req.params.id;
        await pool.query('SELECT * FROM actividades WHERE id in (SELECT id_actividad FROM actividad_pertenece_objetivo WHERE id_objetivo=?)',[id], function(err, result, fields) {
            if (err) throw err;
            res.json(result);
        });
    }

}

export const actividadesController = new ActividadesController();