import {
  Component,
  OnInit,
  inject,
  signal
} from '@angular/core';

import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';

import { HttpClient } from '@angular/common/http';

import { MatriculaService }
from '../../services/matricula.service';

import { Matricula }
from '../../models/matricula.model';

@Component({
  selector: 'app-matriculas-page',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './matriculas-page.html',
  styleUrl: './matriculas-page.css',
})
export class MatriculasPage
implements OnInit {

  private http = inject(HttpClient);

  private matriculaService =
    inject(MatriculaService);

  alumnos = signal<any[]>([]);

  cursos = signal<any[]>([]);

  personas = signal<any[]>([]);

  matriculas = signal<any[]>([]);

  cargando = signal(true);

  nuevaMatricula = signal<Matricula>({
    alumnoId: 0,
    cursoId: 0,
    sostenedorId: 0,
    apoderadoTitularId: 0,
    apoderadoSuplenteId: 0,
    anioAcademico: 2026,
    fechaMatricula: '',
    estado: 'ACTIVA'
  });

  ngOnInit(): void {

    this.cargarDatos();

  }

  cargarDatos(): void {

    this.http
      .get<any[]>(
        'http://localhost:8212/api/v1/alumnos'
      )
      .subscribe({

        next: (data) => {

          this.alumnos.set(data);

        }

      });

    this.http
      .get<any[]>(
        'http://localhost:8212/api/v1/cursos'
      )
      .subscribe({

        next: (data) => {

          this.cursos.set(data);

        }

      });

    this.http
      .get<any[]>(
        'http://localhost:8212/api/v1/personas'
      )
      .subscribe({

        next: (data) => {

          this.personas.set(data);

        }

      });

    this.http
      .get<any[]>(
        'http://localhost:8212/api/v1/matriculas'
      )
      .subscribe({

        next: (data) => {

          this.matriculas.set(data);

          this.cargando.set(false);

        }

      });

  }

  guardarMatricula(): void {

    this.nuevaMatricula.update(m => ({
      ...m,
      fechaMatricula:
        new Date()
          .toISOString()
          .split('T')[0]
    }));

    this.matriculaService
      .guardarMatricula(
        this.nuevaMatricula()
      )
      .subscribe({

        next: (response) => {

          console.log(response);

          alert(
            'Matrícula registrada correctamente'
          );

          this.matriculas.update(lista => [
            ...lista,
            response
          ]);

        },

        error: (error) => {

          console.error(error);

          alert(
            error.error.message ||
            error.error ||
            'Error al registrar matrícula'
          );
        }
            

      });

  }

}