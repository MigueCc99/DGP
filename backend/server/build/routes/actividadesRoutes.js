"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const actividadesController_1 = require("../controllers/actividadesController");
class ActividadesRoutes {
    constructor() {
        this.router = express_1.Router();
        this.config();
    }
    config() {
        this.router.get('/', actividadesController_1.actividadesController.list);
        this.router.get('/:id', actividadesController_1.actividadesController.getOne);
        this.router.post('/', actividadesController_1.actividadesController.create);
        this.router.delete('/:id', actividadesController_1.actividadesController.delete);
        this.router.put('/:id', actividadesController_1.actividadesController.update); //updat
        this.router.get('/:id/objetivos', actividadesController_1.actividadesController.getObjetivosDeActividad);
        this.router.get('/:id/feedback', actividadesController_1.actividadesController.getFeedback);
    }
}
const actividadesRoutes = new ActividadesRoutes();
exports.default = actividadesRoutes.router;
