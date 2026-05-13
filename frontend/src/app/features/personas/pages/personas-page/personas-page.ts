import {
  Component,
  OnInit,
  inject,
  signal
} from '@angular/core';

import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { PersonaService } from '../../../../core/services/persona.service';
import { Persona } from '../../../../core/models/persona.model';

@Component({
  selector: 'app-personas-page',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './personas-page.html',
  styleUrl: './personas-page.css',
})
export class PersonasPage implements OnInit {

  private personaService =
    inject(PersonaService);

  personas = signal<Persona[]>([]);

  cargando = signal(true);

  mostrarFormulario = signal(false);

  modoEdicion = signal(false);

  personaEditandoId = signal<number | null>(null);

  nuevaPersona = signal<Persona>({
    rut: '',
    nombre: '',
    apellidoPaterno: '',
    apellidoMaterno: '',
    direccion: '',
    rol: ''
  });

  ngOnInit(): void {

    this.obtenerPersonas();

  }

  obtenerPersonas(): void {

    this.personaService
      .obtenerPersonas()
      .subscribe({

        next: (data) => {

          this.personas.set(data);

          this.cargando.set(false);

        },

        error: (error) => {

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

  guardarPersona(): void {

    if (this.modoEdicion()) {

      this.actualizarPersona();

      return;

    }

    this.personaService
      .guardarPersona(this.nuevaPersona())
      .subscribe({

        next: (personaGuardada) => {
          alert('Persona registrada correctamente');

          this.personas.update(lista => [
            ...lista,
            personaGuardada
          ]);

          this.resetFormulario();

        },

        error: (error) => {

          console.error(error);

        }

      });

  }

  editarPersona(persona: Persona): void {

    this.modoEdicion.set(true);

    this.personaEditandoId.set(
      persona.id!
    );

    this.nuevaPersona.set({
      ...persona
    });

    this.mostrarFormulario.set(true);

  }

  actualizarPersona(): void {

    this.personaService
      .actualizarPersona(
        this.personaEditandoId()!,
        this.nuevaPersona()
      )
      .subscribe({

        next: (personaActualizada) => {
          alert('Persona actualizada correctamente');

          this.personas.update(lista =>
            lista.map(p =>
              p.id === personaActualizada.id
                ? personaActualizada
                : p
            )
          );

          this.resetFormulario();

        },

        error: (error) => {

          console.error(error);

        }

      });

  }

  eliminarPersona(id: number): void {

    const confirmar =
      confirm('¿Estás seguro de eliminar esta persona?');

    if (!confirmar) return;

    this.personaService
      .eliminarPersona(id)
      .subscribe({

        next: () => {
          alert('Persona eliminada correctamente');

          this.personas.update(lista =>
            lista.filter(p => p.id !== id)
          );

        },

        error: (error) => {

          console.error(error);

          alert(
            'No se puede eliminar esta persona porque está asociada a una matrícula.'
          );

}

      });

  }

  resetFormulario(): void {

    this.nuevaPersona.set({
      rut: '',
      nombre: '',
      apellidoPaterno: '',
      apellidoMaterno: '',
      direccion: '',
      rol: ''
    });

    this.modoEdicion.set(false);

    this.personaEditandoId.set(null);

    this.mostrarFormulario.set(false);

  }

}