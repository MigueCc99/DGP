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
exports.actividadesController = void 0;
const database_1 = __importDefault(require("../database"));
class ActividadesController {
    list(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            yield database_1.default.query('SELECT * FROM actividades', function (err, result, fields) {
                if (err)
                    throw err;
                res.json(result);
            });
        });
    }
    getOne(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params.id;
            yield database_1.default.query('SELECT * FROM actividades WHERE id=?', [id], function (err, result, fields) {
                if (err)
                    throw err;
                if (result.length > 0) {
                    return res.json(result[0]);
                }
                res.status(404).json({ message: "La actividad no existe" });
            });
        });
    }
    create(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            yield database_1.default.query('INSERT INTO actividades set ?', [req.body]);
            res.json({ message: 'Actividad creada' });
        });
    }
    delete(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params;
            yield database_1.default.query('DELETE FROM actividades WHERE id=?', [id], function (err, result, fields) {
                if (err)
                    throw err;
                res.json({ message: "La actividad fue eliminada" });
            });
        });
    }
    update(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params;
            yield database_1.default.query('UPDATE actividades set ? WHERE id=?', [req.body, id], function (err, result, fields) {
                if (err)
                    throw err;
                res.json({ message: "La actividad fue actualizada" });
            });
        });
    }
    getObjetivosDeActividad(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params.id;
            yield database_1.default.query('SELECT * FROM objetivos WHERE id in (SELECT id_objetivo FROM actividad_pertenece_objetivo WHERE id_actividad=?)', [id], function (err, result, fields) {
                if (err)
                    throw err;
                res.json(result);
            });
        });
    }
}
exports.actividadesController = new ActividadesController();
