import { Request, Response } from 'express';

import pool from '../database'

class LoginController {

    
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

export const loginController = new LoginController();