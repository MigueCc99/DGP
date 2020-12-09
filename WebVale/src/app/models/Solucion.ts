export class Solucion implements Object{
    id_actividad: number;
    id_socio: number;
    solucion_texto: string;
    multimedia_solucion: string;
    multimedia_mime: string;
    aceptada: boolean;
    a_repetir: boolean;
    es_util: boolean;
    es_gustado: boolean;
    es_dificil: boolean;
    comentario: string;

    constructor() {
        this.id_actividad = 0;
        this.id_socio = 0;
        this.solucion_texto = "";
        this.multimedia_solucion = "";
        this.multimedia_mime = "";
        this.a_repetir = false;
        this.aceptada = false;
        this.es_util = false;
        this.es_gustado = false;
        this.es_dificil = false;
        this.comentario = "";
    }
}   