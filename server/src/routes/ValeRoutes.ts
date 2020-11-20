import { Router } from 'express';

import { valeController } from '../controllers/valeControllers';

class ValeRoutes {

    public router: Router = Router();

    constructor() {
        this.config();
    }

    public config(): void {
        this.router.get('/', valeController.list);
        this.router.get('/:id', valeController.getOne);
        this.router.post('/', valeController.create);
        this.router.delete('/:id', valeController.delete);
        this.router.put('/:id', valeController.update);//update
    }

}

const valeRoutes = new ValeRoutes();
export default valeRoutes.router;