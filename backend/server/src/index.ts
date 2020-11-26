import express, { Application, json } from "express";
import morgan from 'morgan';
import cors from 'cors';

import indexRoutes from './routes/indexRoutes'
import loginRoutes from './routes/LoginRoutes'
import objetivosRoutes from './routes/objetivosRoutes'
import facilitadoresRoutes from './routes/facilitadoresRoutes'
import actividadesRoutes from './routes/actividadesRoutes'
import sociosRoutes from './routes/sociosRoutes'

class Server {

    public app: Application;

    constructor() {
        this.app = express();
        this.config();
        this.routes();
    }

    config() : void {
        this.app.set('port', process.env.PORT || 3000);
        this.app.use(morgan('dev'));
        this.app.use(cors());
        this.app.use(express.json());
    }

    routes() : void {
        this.app.use('/',indexRoutes);
        this.app.use('/api/vale/',loginRoutes);
        this.app.use('/api/vale/objetivos/',objetivosRoutes);
        this.app.use('/api/vale/facilitadores/',facilitadoresRoutes);
        this.app.use('/api/vale/actividades/', actividadesRoutes);
        this.app.use('/api/vale/socios/', sociosRoutes);
    }

    start() : void {
        this.app.listen(this.app.get('port'), () => {
            console.log('Server on port ', this.app.get('port'));
        });
    }

}

const server = new Server();
server.start();