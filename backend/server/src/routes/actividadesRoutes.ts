import { Router } from 'express';

import { actividadesController } from '../controllers/actividadesController';

class ActividadesRoutes {

    public router: Router = Router();

    constructor() {
        this.config();
    }

    public config(): void {
        this.router.get('/', actividadesController.list);
        this.router.get('/:id', actividadesController.getOne);
        this.router.post('/', actividadesController.create);
        this.router.delete('/:id', actividadesController.delete);
        this.router.put('/:id', actividadesController.update);//updat
        this.router.get('/:id/objetivos', actividadesController.getObjetivosDeActividad);  
    }

}

const actividadesRoutes = new ActividadesRoutes();
export default actividadesRoutes.router;