"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.facilitadoresController = void 0;
const database_1 = __importDefault(require("../database"));
class FacilitadoresController {
    //recuperar datos de todos los facilitadores
    list(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            yield database_1.default.query('SELECT * FROM facilitadores', function (err, result, fields) {
                if (err)
                    throw err;
                res.json(result);
            });
        });
    }
    //recuperar datos de un facilitador 
    getOne(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const { correo } = req.params;
            yield database_1.default.query('SELECT * FROM facilitadores WHERE correo=?', [correo], function (err, result, fields) {
                if (err)
                    throw err;
                if (result.length > 0) {
                    return res.json(result[0]);
                }
                res.status(404).json({ message: "El facilitador no existe" });
            });
        });
    }
    //Crear un facilitador
    create(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            yield database_1.default.query('INSERT INTO facilitadores set ?', [req.body]);
            res.json({ message: 'Facilitador creado' });
        });
    }
    //Borrar un facilitador
    delete(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const { correo } = req.params;
            yield database_1.default.query('DELETE FROM facilitadores WHERE correo=?', [correo], function (err, result, fields) {
                if (err)
                    throw err;
                res.json({ message: "El facilitador fue eliminado" });
            });
        });
    }
    //Para cambiar contraseña
    update(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const { correo } = req.params;
            yield database_1.default.query('UPDATE facilitadores set ? WHERE correo=?', [req.body, correo], function (err, result, fields) {
                if (err)
                    throw err;
                res.json({ message: "El facilitador fue actualizado" });
            });
        });
    }
}
exports.facilitadoresController = new FacilitadoresController();
