"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const facilitadoresController_1 = require("../controllers/facilitadoresController");
class FacilitadoresRoutes {
    constructor() {
        this.router = express_1.Router();
        this.config();
    }
    config() {
        this.router.get('/', facilitadoresController_1.facilitadoresController.list);
        this.router.get('/:correo', facilitadoresController_1.facilitadoresController.getOne);
        this.router.post('/', facilitadoresController_1.facilitadoresController.create);
        this.router.delete('/:correo', facilitadoresController_1.facilitadoresController.delete);
        this.router.put('/:correo', facilitadoresController_1.facilitadoresController.update);
    }
}
const facilitadoresRoutes = new FacilitadoresRoutes();
exports.default = facilitadoresRoutes.router;
