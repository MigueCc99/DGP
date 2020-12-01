import { Router } from 'express';

import { sociosController } from '../controllers/sociosController';

class SociosRoutes {

    public router: Router = Router();

    constructor() {
        this.config();
    }

    public config(): void {
        this.router.get('/', sociosController.list);
        this.router.get('/:id', sociosController.getOne);
        this.router.post('/', sociosController.create);
        this.router.delete('/:id', sociosController.delete);
        this.router.put('/:id', sociosController.update);//updat
        this.router.get('/:id/actividades', sociosController.getActividades);
        this.router.get('/:id/objetivos', sociosController.getObjetivos);
    }

}

const sociosRoutes = new SociosRoutes();
export default sociosRoutes.router;