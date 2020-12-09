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
exports.sociosController = void 0;
const database_1 = __importDefault(require("../database"));
class SociosController {
    list(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            yield database_1.default.query('SELECT * FROM socios', function (err, result, fields) {
                if (err)
                    throw err;
                res.json(result);
            });
        });
    }
    getOne(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params.id;
            yield database_1.default.query('SELECT * FROM socios WHERE id=?', [id], function (err, result, fields) {
                if (err)
                    throw err;
                if (result.length > 0) {
                    return res.json(result[0]);
                }
                res.status(404).json({ message: "El socio no existe" });
            });
        });
    }
    create(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            yield database_1.default.query('INSERT INTO socios set ?', [req.body]);
            res.json({ message: 'Socio creado' });
        });
    }
    delete(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params;
            yield database_1.default.query('DELETE FROM socios WHERE id=?', [id], function (err, result, fields) {
                if (err)
                    throw err;
                res.json({ message: "El socio fue eliminado" });
            });
        });
    }
    update(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params;
            yield database_1.default.query('UPDATE socios set ? WHERE id=?', [req.body, id], function (err, result, fields) {
                if (err)
                    throw err;
                res.json({ message: "El socio fue actualizado" });
            });
        });
    }
    getActividades(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params.id;
            yield database_1.default.query('SELECT * FROM actividades WHERE id in (SELECT id_actividad FROM actividad_asignada_socio WHERE id_socio=?)', [id], function (err, result, fields) {
                if (err)
                    throw err;
                res.json(result);
            });
        });
    }
    getActividad(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params.id;
            const actividad = req.params.actividad;
            yield database_1.default.query('SELECT * FROM actividad_asignada_socio WHERE id_socio=? AND id_actividad=?', [id, actividad], function (err, result, fields) {
                if (err)
                    throw err;
                if (result.length > 0) {
                    return res.json(result[0]);
                }
                res.status(404).json({ message: "La solucion no existe" });
            });
        });
    }
    getActividadesPendientesCorregir(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params.id;
            yield database_1.default.query('SELECT * FROM actividades WHERE id in (SELECT id_actividad FROM actividad_asignada_socio WHERE id_socio=? AND (multimedia_solucion IS NOT NULL OR solucion_texto IS NOT NULL) AND aceptada=false)', [id], function (err, result, fields) {
                if (err)
                    throw err;
                res.json(result);
            });
        });
    }
    getActividadesEntregadas(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params.id;
            yield database_1.default.query('SELECT * FROM actividades WHERE id in (SELECT id_actividad FROM actividad_asignada_socio WHERE id_socio=? AND aceptada=false AND (multimedia_solucion IS NOT NULL OR solucion_texto IS NOT NULL))', [id], function (err, result, fields) {
                if (err)
                    throw err;
                res.json(result);
            });
        });
    }
    getActividadesSinEntregar(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params.id;
            yield database_1.default.query('SELECT * FROM actividades WHERE id in (SELECT id_actividad FROM actividad_asignada_socio WHERE id_socio=? AND solucion_texto IS NULL AND multimedia_solucion IS NULL)', [id], function (err, result, fields) {
                if (err)
                    throw err;
                res.json(result);
            });
        });
    }
    getObjetivos(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const id = req.params.id;
            yield database_1.default.query('SELECT DISTINCT * FROM objetivos WHERE id in (SELECT id_objetivo FROM actividad_pertenece_objetivo WHERE id_actividad IN (SELECT id_actividad FROM actividad_asignada_socio WHERE id_socio=?))', [id], function (err, result, fields) {
                if (err)
                    throw err;
                res.json(result);
            });
        });
    }
    getSocio(req, res) {
        return __awaiter(this, void 0, void 0, function* () {
            const contrasena = req.params.contrasena;
            yield database_1.default.query('SELECT * FROM socios WHERE contrasena=?', [contrasena], function (err, result, fields) {
                if (err)
                    throw err;
                if (result.length > 0) {
                    return res.json(result[0]);
                }
                res.status(404).json({ message: "El socio no existe" });
            });
        });
    }
}
exports.sociosController = new SociosController();
