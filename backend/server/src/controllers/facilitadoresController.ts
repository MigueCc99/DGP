import { Request, Response } from 'express';

import pool from '../database'

class FacilitadoresController {

    //recuperar datos de todos los facilitadores
    public async list(req: Request, res: Response): Promise<void> {
        await pool.query('SELECT * FROM facilitadores', function (err, result, fields) {
            if (err) throw err;
            res.json(result);
        });
    }

    //recuperar datos de un facilitador 
    public async getOne(req: Request, res: Response): Promise<any> {
        const { correo } = req.params; 
        await pool.query('SELECT * FROM facilitadores WHERE correo=?', [correo], function (err, result, fields){
            if (err) throw err;
            if (result.length > 0) {
                return res.json(result[0]);
            }
            res.status(404).json({ message: "El facilitador no existe" });
        });
    }

    //Crear un facilitador
    public async create(req: Request, res: Response): Promise<void> {
        await pool.query('INSERT INTO facilitadores set ?', [req.body]);
        res.json({ message: 'Facilitador creado' });
    }

    //Borrar un facilitador
    public async delete(req: Request, res: Response): Promise<void> {
        const correo = req.params;
        await pool.query('DELETE FROM facilitadores WHERE correo=?', [correo], function (err, result, fields) {
            if (err) throw err;
            res.json({ message: "El facilitador fue eliminado" });
        });
    }

//Para cambiar contraseña
    public async update(req: Request, res: Response): Promise<void> {
        const correo = req.params;
        await pool.query('UPDATE facilitadores set ? WHERE correo=?', [req.body, correo], function (err, result, fields) {
            if (err) throw err;
            res.json({ message: "El facilitador fue actualizado" });
        });
    }
}

export const facilitadoresController = new FacilitadoresController();