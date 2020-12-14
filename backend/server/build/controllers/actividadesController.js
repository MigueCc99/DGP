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
const feedback_1 = require("../models/feedback");
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
    getFeedback(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params.id;
            var feedback = new feedback_1.Feedback();
            feedback.id_actividad = parseInt(id);
            var query = "SELECT feedback.id_actividad,"
                + " (SELECT COUNT(*) FROM actividad_asignada_socio WHERE id_actividad=feedback.id_actividad AND es_util IS NOT NULL)   as votos ,"
                + " (SELECT COUNT(*) FROM actividad_asignada_socio WHERE id_actividad=feedback.id_actividad AND es_util=1)  as utiles,"
                + " (SELECT COUNT(*) FROM actividad_asignada_socio WHERE id_actividad=feedback.id_actividad AND es_dificil=1)  as dificiles,"
                + " (SELECT COUNT(*) FROM actividad_asignada_socio WHERE id_actividad=feedback.id_actividad AND es_gustado=1)  as gustados "
                + " FROM (SELECT DISTINCT id_actividad FROM actividad_asignada_socio WHERE id_actividad=?) feedback";
            yield database_1.default.query(query, [id], (err, result, fields) => {
                if (err)
                    throw err;
                return res.json(result[0]);
            });
        });
    }
    getVotosFeedback(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params.id;
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
            const { id } = req.params;
            yield database_1.default.query('DELETE FROM actividades WHERE id=?', [id]);
            res.json({ message: "La actividad fue eliminada" });
        });
    }
    update(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const { id } = req.params;
            yield database_1.default.query('UPDATE actividades set ? WHERE id=?', [req.body, id]);
            res.json({ message: "La actividad fue actualizada" });
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
