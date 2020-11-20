import { Request, Response } from 'express';

class IndexController {
    
    public index (req: Request,res: Response) {
        res.send(res.json({text: 'API is in /api/vale'}));
    }
}

export const indexController = new IndexController();