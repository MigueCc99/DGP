export class Feedback implements Object{
    id_actividad: number;
    es_util: number;
    es_gustado: number;
    es_dificil: number;
    votados: number;

    constructor() {
        this.id_actividad = 0;
        this.es_util = 0;
        this.es_gustado = 0;
        this.es_dificil = 0;
        this.votados = 0;
    }
}   