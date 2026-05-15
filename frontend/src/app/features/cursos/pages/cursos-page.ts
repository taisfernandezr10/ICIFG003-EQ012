import {
  Component,
  OnInit,
  inject,
  signal
} from '@angular/core';

import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { CursoService } from '../../../core/services/curso.service';

import { Curso } from '../../../core/models/curso.model';

@Component({
  selector: 'app-cursos-page',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './cursos-page.html',
  styleUrl: './cursos-page.css'
})
export class CursosPage implements OnInit {

  private cursoService =
    inject(CursoService);

  cursos = signal<Curso[]>([]);

  cargando = signal(true);

  mostrarFormulario = signal(false);

  modoEdicion = signal(false);

  cursoEditandoId = signal<number | null>(null);

  nuevoCurso = signal<Curso>({
    nombreCurso: '',
    nivel: '',
    anioAcademico: 2026
  });

  ngOnInit(): void {

    this.obtenerCursos();

  }

  obtenerCursos(): void {

    this.cursoService
      .obtenerCursos()
      .subscribe({

        next: (data) => {

          this.cursos.set(data);

          this.cargando.set(false);

        },

        error: (error: any) => {

          console.error(error);

          this.cargando.set(false);

        }

      });

  }

  abrirFormulario(): void {

    this.mostrarFormulario.set(true);

  }

  cerrarFormulario(): void {

    this.resetFormulario();

  }

  guardarCurso(): void {

    if (
      !this.nuevoCurso().nombreCurso ||
      !this.nuevoCurso().nivel ||
      !this.nuevoCurso().anioAcademico
    ) {

      alert(
        'Todos los campos son obligatorios'
      );

      return;

    }

    if (this.modoEdicion()) {

      this.actualizarCurso();

      return;

    }

    this.cursoService
      .guardarCurso(this.nuevoCurso())
      .subscribe({

        next: (cursoGuardado) => {

          this.cursos.update(lista => [
             ...lista,
            cursoGuardado
        ]);

        this.resetFormulario();

        setTimeout(() => {

            alert(
             'Curso registrado correctamente'
            );

        }, 200);

        },

        error: (error: any) => {

          console.error(error);

          alert(
            'Error al registrar curso'
          );

        }

      });

  }

  editarCurso(curso: Curso): void {

    this.modoEdicion.set(true);

    this.cursoEditandoId.set(curso.id!);

    this.nuevoCurso.set({
      ...curso
    });

    this.mostrarFormulario.set(true);

  }

  actualizarCurso(): void {

    this.cursoService
      .actualizarCurso(
        this.cursoEditandoId()!,
        this.nuevoCurso()
      )
      .subscribe({

        next: (cursoActualizado) => {

            this.cursos.update(lista =>
                lista.map(c =>
                 c.id === cursoActualizado.id
                     ? cursoActualizado
                    : c
                )
            );

             this.resetFormulario();

            setTimeout(() => {

                alert(
                    'Curso actualizado correctamente'
                );

            }, 200);

        },

        error: (error: any) => {

          console.error(error);

        }

      });

  }

  eliminarCurso(id: number): void {

    const confirmar = confirm(
      '¿Eliminar curso?'
    );

    if (!confirmar) return;

    this.cursoService
        .eliminarCurso(id)
        .subscribe({

             next: () => {

                this.obtenerCursos();

                setTimeout(() => {

                    alert(
                        'Curso eliminado correctamente'
                    );

                }, 200);

     },

            error: (error: any) => {

                console.error(error);

                this.obtenerCursos();

                 alert(
                    'No se puede eliminar el curso porque tiene alumnos o matrículas asociadas'
                );

            }

        });

  }

  resetFormulario(): void {

    this.nuevoCurso.set({
      nombreCurso: '',
      nivel: '',
      anioAcademico: 2026
    });

    this.modoEdicion.set(false);

    this.cursoEditandoId.set(null);

    this.mostrarFormulario.set(false);

  }

}