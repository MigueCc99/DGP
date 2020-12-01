export class Socio implements Object{
    id: number;
    nombre: string;
    apellidos: string;
    contrasena?: string;
    nacimiento?: string;
    toggle?: boolean;

    constructor() {
        this.id = 0;
        this.nombre = "";
        this.apellidos = "";
        this.toggle=false;
    }
}   