"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const valeControllers_1 = require("../controllers/valeControllers");
class ValeRoutes {
    constructor() {
        this.router = express_1.Router();
        this.config();
    }
    config() {
        this.router.get('/', valeControllers_1.valeController.list);
        this.router.get('/:id', valeControllers_1.valeController.getOne);
        this.router.post('/', valeControllers_1.valeController.create);
        this.router.delete('/:id', valeControllers_1.valeController.delete);
        this.router.put('/:id', valeControllers_1.valeController.update); //update
        this.router.get('/login/:user/:password', valeControllers_1.valeController.getUser);
    }
}
const valeRoutes = new ValeRoutes();
exports.default = valeRoutes.router;
