import { Injectable, inject } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Matricula } from '../models/matricula.model';

@Injectable({
  providedIn: 'root'
})
export class MatriculaService {

  private http = inject(HttpClient);

  private API_URL =
    'http://localhost:8212/api/v1/matriculas';

  guardarMatricula(
    matricula: Matricula
  ): Observable<any> {

    return this.http.post(
      this.API_URL,
      matricula
    );

  }

  eliminarMatricula(
  id: number
): Observable<any> {

  return this.http.delete(
    `${this.API_URL}/${id}`,
    {
      responseType: 'text'
    }
  );

}

actualizarMatricula(
  id: number,
  matricula: any
): Observable<any> {

  return this.http.put(
    `${this.API_URL}/${id}`,
    matricula
  );

}

}