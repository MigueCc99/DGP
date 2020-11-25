import { Router } from 'express';

import { facilitadoresController} from '../controllers/facilitadoresController';

class FacilitadoresRoutes {

    public router: Router = Router();

    constructor() {
        this.config();
    }

    public config(): void {
        this.router.get('/', facilitadoresController.list);
        this.router.get('/:correo', facilitadoresController.getOne); 
        this.router.post('/', facilitadoresController.create);
        this.router.delete('/:correo', facilitadoresController.delete)
        this.router.put('/:correo', facilitadoresController.update);
       
    }
}

const facilitadoresRoutes = new FacilitadoresRoutes();
export default facilitadoresRoutes.router;