"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.indexController = void 0;
class IndexController {
    index(req, res) {
        res.send(res.json({ text: 'API is in /api/vale' }));
    }
}
exports.indexController = new IndexController();
