import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
// 1. Importa esto:
import { UpperCasePipe } from '@angular/common'; 

@Component({
  selector: 'app-root',
  standalone: true, // Asegúrate de que diga esto
  imports: [RouterOutlet, UpperCasePipe], // 2. Agrégalo aquí
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('fronted');
}