import {
  Component,
  OnInit,
  inject,
  signal
} from '@angular/core';

import { CommonModule } from '@angular/common';

import { HttpClient }
from '@angular/common/http';

@Component({
  selector: 'app-familias-page',

  standalone: true,

  imports: [
    CommonModule
  ],

  templateUrl: './familias-page.html',

  styleUrl: './familias-page.css',
})

export class FamiliasPage
implements OnInit {

  private http =
    inject(HttpClient);

  familias =
    signal<any[]>([]);

  cargando =
    signal(true);

  ngOnInit(): void {

    this.obtenerFamilias();

  }

  obtenerFamilias(): void {

    this.http
      .get<any[]>(
        'http://localhost:8212/api/v1/matriculas'
      )
      .subscribe({

        next: (data) => {

          this.familias.set(data);

          this.cargando.set(false);

        },

        error: (error) => {

          console.error(error);

          this.cargando.set(false);

        }

      });

  }

}