import { Router } from 'express';

import { loginController } from '../controllers/loginControllers';

class LoginRoutes {

    public router: Router = Router();

    constructor() {
        this.config();
    }

    public config(): void {
        this.router.get('/login/:user/:password',loginController.getUser);
    }

}

const loginRoutes = new LoginRoutes();
export default loginRoutes.router;