"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const loginControllers_1 = require("../controllers/loginControllers");
class LoginRoutes {
    constructor() {
        this.router = express_1.Router();
        this.config();
    }
    config() {
        this.router.get('/login/:correo/:password', loginControllers_1.loginController.getUser);
    }
}
const loginRoutes = new LoginRoutes();
exports.default = loginRoutes.router;
