"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const objetivosController_1 = require("../controllers/objetivosController");
class ObjetivosRoutes {
    constructor() {
        this.router = express_1.Router();
        this.config();
    }
    config() {
        this.router.get('/', objetivosController_1.objetivosController.list);
        this.router.get('/:id', objetivosController_1.objetivosController.getOne);
        this.router.post('/', objetivosController_1.objetivosController.create);
        this.router.delete('/:id', objetivosController_1.objetivosController.delete);
        this.router.put('/:id', objetivosController_1.objetivosController.update); //updat
        this.router.get('/actividad/:id', objetivosController_1.objetivosController.getObjetivosDeActividad);
    }
}
const objetivosRoutes = new ObjetivosRoutes();
exports.default = objetivosRoutes.router;
