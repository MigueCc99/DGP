export class Actividad implements Object{
    id: number;
    nombre: string;
    descripcion?: string;
    imagen?: string;
    multimedia?: string;

    constructor() {
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
        this.imagen="";
        this.multimedia = "";
    }
}   