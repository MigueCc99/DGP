"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const sociosController_1 = require("../controllers/sociosController");
class SociosRoutes {
    constructor() {
        this.router = express_1.Router();
        this.config();
    }
    config() {
        this.router.get('/', sociosController_1.sociosController.list);
        this.router.get('/:id', sociosController_1.sociosController.getOne);
        this.router.post('/', sociosController_1.sociosController.create);
        this.router.delete('/:id', sociosController_1.sociosController.delete);
        this.router.put('/:id', sociosController_1.sociosController.update); //updat
        this.router.get('/:id/actividades', sociosController_1.sociosController.getActividades);
        this.router.get('/:id/actividades/solucion/:actividad', sociosController_1.sociosController.getActividad);
        this.router.put('/:id/actividades/solucion/:actividad', sociosController_1.sociosController.updateSolucion);
        this.router.get('/:id/objetivos', sociosController_1.sociosController.getObjetivos);
        this.router.get('/:id/actividades/entregadas', sociosController_1.sociosController.getActividadesEntregadas);
        this.router.get('/:id/actividades/no-aceptadas', sociosController_1.sociosController.getActividadesPendientesCorregir);
        this.router.get('/:id/actividades/no-entregadas', sociosController_1.sociosController.getActividadesSinEntregar);
        this.router.get('/login/:contrasena', sociosController_1.sociosController.getSocio);
    }
}
const sociosRoutes = new SociosRoutes();
exports.default = sociosRoutes.router;
