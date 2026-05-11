export interface Persona {
    id?: number; // Es opcional (?) porque al crear una nueva persona, el ID lo generará PostgreSQL
    rut: string;
    nombre: string;
    apellidoPaterno: string;
    apellidoMaterno: string;
    direccion: string;
}