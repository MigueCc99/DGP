import { Request, Response } from 'express';

import pool from '../database'

class ValeController {

    public async list (req: Request, res: Response): Promise<void> {
        await pool.query('SELECT * FROM objetivos', function(err, result, fields) {
            if (err) throw err;
            res.json(result);
        });
    }

    public async getOne (req: Request, res: Response): Promise<void> {
        const id = req.params.id;
        await pool.query('SELECT * FROM objetivos WHERE id=?',[id], function(err, result, fields) {
            if (err) throw err;
            if (result.length > 0) {
                return res.json(result[0]);
            }
            res.status(404).json({message: "El Objetivo no existe"});
        });
    }

    public async create (req: Request, res: Response): Promise<void> {
        await pool.query('INSERT INTO objetivos set ?', [req.body]);
        res.json({message: 'Objetivo creado'});
    }

    public async delete (req: Request, res: Response): Promise<void> {
        const id = req.params;
        await pool.query('DELETE FROM objetivos WHERE id=?',[id], function(err, result, fields) {
            if (err) throw err;
            res.json({message: "El Objetivo fue eliminado"});
        });
    }

    public async update (req: Request, res: Response): Promise<void> {
        const id = req.params;
        await pool.query('UPDATE objetivos set ? WHERE id=?',[req.body, id], function(err, result, fields) {
            if (err) throw err;
            res.json({message: "El Objetivo fue actualizado"});
        });
    }

    public async getUser (req: Request, res: Response): Promise<any> {
        const { user } = req.params;
        const { password } = req.params;
        await pool.query('SELECT username FROM users WHERE username = ? and password = ?', [user, password], function(err, result, fields) {
            if (err) throw err;
            if (result.length > 0) {
                return res.json(1);
            }else{
                return res.json(0);
            }
        });
    }

}

export const valeController = new ValeController();