import { Request, Response } from 'express';

import pool from '../database'

class LoginController {

    
    public async getUser (req: Request, res: Response): Promise<any> {
        const { correo } = req.params;
        const { password } = req.params;
        await pool.query('SELECT correo FROM facilitadores WHERE correo = ? and contrasena = ?', [correo, password], function(err, result, fields) {
            if (err) throw err;
            if (result.length > 0) {
                console.log(result);
                return res.json(result);
            }else{
                return res.json(0);
            }
        });
    }

}

export const loginController = new LoginController();