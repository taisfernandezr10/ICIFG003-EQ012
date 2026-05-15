import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Curso } from '../models/curso.model';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  private http = inject(HttpClient);

  private API_URL =
    'http://localhost:8212/api/v1/cursos';

  obtenerCursos(): Observable<Curso[]> {

    return this.http.get<Curso[]>(
      this.API_URL
    );

  }

  guardarCurso(
    curso: Curso
  ): Observable<Curso> {

    return this.http.post<Curso>(
      this.API_URL,
      curso
    );

  }

  actualizarCurso(
    id: number,
    curso: Curso
  ): Observable<Curso> {

    return this.http.put<Curso>(
      `${this.API_URL}/${id}`,
      curso
    );

  }

  eliminarCurso(
    id: number
): Observable<any> {

  return this.http.delete(
    `${this.API_URL}/${id}`,
    {
      responseType: 'text'
    }
  );

}

}