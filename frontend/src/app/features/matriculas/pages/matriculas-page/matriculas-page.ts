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
from '../../../../core/services/matricula.service';

import { Matricula }
from '../../../../core/models/matricula.model';

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

  apoderados = signal<any[]>([]);

  matriculas = signal<any[]>([]);

  cargando = signal(true);

  busquedaAlumno = signal('');

  modoEdicion = signal(false);

  matriculaEditandoId =
    signal<number | null>(null);

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
    

    // CURSOS

    this.http
      .get<any[]>(
        'http://localhost:8212/api/v1/cursos'
      )
      .subscribe({

        next: (data) => {

          this.cursos.set(data);

        }

      });

    // PERSONAS

    this.http
      .get<any[]>(
        'http://localhost:8212/api/v1/personas'
      )
      .subscribe({

        next: (data) => {

          // SOLO ESTUDIANTES

          const estudiantes =
            data.filter(
              p => p.rol === 'ESTUDIANTE'
            );

          // TODOS MENOS ESTUDIANTES

          const apoderados =
            data.filter(
              p => p.rol !== 'ESTUDIANTE'
            );

          this.alumnos.set(estudiantes);

          this.apoderados.set(apoderados);

        },

        error: (error) => {

          console.error(error);

        }

      });

    // MATRICULAS

    this.http
      .get<any[]>(
        'http://localhost:8212/api/v1/matriculas'
      )
      .subscribe({

        next: (data) => {

          this.matriculas.set(data);

          this.cargando.set(false);

        },

        error: (error) => {

          console.error(error);

          this.cargando.set(false);

        }

      });

  }

  matriculasFiltradas() {

  return this.matriculas().filter(m =>

    `${m.alumno.nombre}
     ${m.alumno.apellidoPaterno}`

      .toLowerCase()

      .includes(
        this.busquedaAlumno()
          .toLowerCase()
      )

  );

}

  guardarMatricula(): void {
    if (this.modoEdicion()) {

      this.actualizarMatricula();

       return;

    }

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

          this.http
            .get<any[]>(
             'http://localhost:8212/api/v1/matriculas'
           )
          .subscribe({

            next: (data) => {

              this.matriculas.set(data);

          }
       });



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

  actualizarMatricula(): void {

  this.matriculaService
    .actualizarMatricula(
      this.matriculaEditandoId()!,
      this.nuevaMatricula()
    )
    .subscribe({

      next: () => {

        this.http
          .get<any[]>(
            'http://localhost:8212/api/v1/matriculas'
          )
          .subscribe({

            next: (data) => {

              this.matriculas.set(data);

              this.modoEdicion.set(false);

              this.matriculaEditandoId.set(null);

              this.nuevaMatricula.set({

                alumnoId: 0,
                cursoId: 0,
                sostenedorId: 0,
                apoderadoTitularId: 0,
                apoderadoSuplenteId: 0,
                anioAcademico: 2026,
                fechaMatricula: '',
                estado: 'ACTIVA'

              });

              setTimeout(() => {

                alert(
                  'Matrícula actualizada correctamente'
                );

              }, 200);

            }

          });

      },

      error: (error: any) => {

        console.error(error);

        alert(
          'No se pudo actualizar la matrícula'
        );

      }

    });

}

  editarMatricula(matricula: any): void {

    this.modoEdicion.set(true);

    this.matriculaEditandoId.set(
      matricula.id
    );

    this.nuevaMatricula.set({

      alumnoId:
        matricula.alumno.id,

      cursoId:
        matricula.curso.id,

      sostenedorId:
        matricula.sostenedor.id,

      apoderadoTitularId:
       matricula.apoderadoTitular.id,

      apoderadoSuplenteId:
        matricula.apoderadoSuplente.id,

      anioAcademico:
        matricula.anioAcademico,

      fechaMatricula:
        matricula.fechaMatricula,

     estado:
        matricula.estado

  });

}

  eliminarMatricula(id: number): void {

  const confirmar = confirm(
    '¿Eliminar matrícula?'
  );

  if (!confirmar) return;

  this.matriculaService
    .eliminarMatricula(id)
    .subscribe({

      next: () => {

  this.http
    .get<any[]>(
      'http://localhost:8212/api/v1/matriculas'
    )
    .subscribe({

      next: (data) => {

        this.matriculas.set(data);

        setTimeout(() => {

          alert(
            'Matrícula eliminada correctamente'
          );

        }, 200);

      }

    });

},

      error: (error: any) => {

        console.error(error);

        alert(
          'No se pudo eliminar la matrícula'
        );

      }

    });

}

  

}