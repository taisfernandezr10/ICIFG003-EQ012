import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Persona } from '../models/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private http = inject(HttpClient);

  private API_URL =
    'http://localhost:8212/api/v1/personas';

  obtenerPersonas(): Observable<Persona[]> {

    return this.http.get<Persona[]>(
      this.API_URL
    );

  }

  guardarPersona(
    persona: Persona
  ): Observable<Persona> {

    return this.http.post<Persona>(
      this.API_URL,
      persona
    );

  }

  eliminarPersona(id: number): Observable<any> {

    return this.http.delete(
      `${this.API_URL}/${id}`
    );
  }

  actualizarPersona(
    id: number,
    persona: Persona
  ): Observable<Persona> {

    return this.http.put<Persona>(
      `${this.API_URL}/${id}`,
      persona
    );
  }
  
}