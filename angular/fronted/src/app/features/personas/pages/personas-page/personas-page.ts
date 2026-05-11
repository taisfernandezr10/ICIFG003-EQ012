import {
  Component,
  OnInit,
  inject,
  signal
} from '@angular/core';

import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { PersonaService } from '../../services/persona.service';
import { Persona } from '../../models/persona.model';

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

  nuevaPersona = signal<Persona>({
    rut: '',
    nombre: '',
    apellidoPaterno: '',
    apellidoMaterno: '',
    direccion: ''
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

    this.mostrarFormulario.set(false);

  }

  guardarPersona(): void {

    this.personaService
      .guardarPersona(this.nuevaPersona())
      .subscribe({

        next: (personaGuardada) => {

          this.personas.update(lista => [
            ...lista,
            personaGuardada
          ]);

          this.nuevaPersona.set({
            rut: '',
            nombre: '',
            apellidoPaterno: '',
            apellidoMaterno: '',
            direccion: ''
          });

          this.mostrarFormulario.set(false);

        },

        error: (error) => {

          console.error(error);

        }

      });

  }

}