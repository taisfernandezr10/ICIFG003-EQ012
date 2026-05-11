import { Injectable, signal, inject } from '@angular/core';
import { PersonaService } from './persona.service';
import { Persona } from '../models/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaStore {
  
  private service = inject(PersonaService);
  
  // Manejo de estado con Signals
  personas = signal<Persona[]>([]);
  loading = signal(false);
  error = signal<string | null>(null);
  selected = signal<Persona | null>(null);
  
  // Cargar lista de personas
  load() {
    this.loading.set(true);
    this.service.getAll().subscribe({
      next: data => {
        this.personas.set(data);
        this.loading.set(false);
      },
      error: err => {
        this.error.set('Error cargando personas');
        this.loading.set(false);
      }
    });
  }
  
  // Seleccionar una persona para editarla
  select(persona: Persona) {
    this.selected.set(persona);
  }
  
  // Limpiar el formulario
  clearSelection() {
    this.selected.set(null);
  }
  
  // Agregar una persona nueva y actualizar la lista en vivo
  add(persona: Persona) {
    this.service.create(persona).subscribe({
      next: p => this.personas.update(list => [...list, p])
    });
  }
  
  // Editar una persona y actualizar la lista
  update(persona: Persona) {
    this.service.update(persona).subscribe(updated => {
      this.personas.update(list =>
        list.map(p => p.id === updated.id ? updated : p)
      );
      this.clearSelection();
    });
  }
  
  // Eliminar y sacar de la lista visual
  delete(id: number) {
    this.service.delete(id).subscribe({
      next: () => {
        this.personas.update(list =>
          list.filter(p => p.id !== id)
        );
      }
    });
  }
}