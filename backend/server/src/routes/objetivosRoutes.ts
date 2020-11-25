import { Router } from 'express';

import { objetivosController } from '../controllers/objetivosController';

class ObjetivosRoutes {

    public router: Router = Router();

    constructor() {
        this.config();
    }

    public config(): void {
        this.router.get('/', objetivosController.list);
        this.router.get('/:id', objetivosController.getOne);
        this.router.post('/', objetivosController.create);
        this.router.delete('/:id', objetivosController.delete);
        this.router.put('/:id', objetivosController.update);//updat
    }

}

const objetivosRoutes = new ObjetivosRoutes();
export default objetivosRoutes.router;