export interface Matricula {

  id?: number;

  alumnoId: number;

  cursoId: number;

  sostenedorId: number;

  apoderadoTitularId: number;

  apoderadoSuplenteId?: number;

  anioAcademico: number;

  fechaMatricula: string;

  estado: string;

}