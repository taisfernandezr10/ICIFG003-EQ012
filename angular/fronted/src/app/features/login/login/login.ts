import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  username = signal('');
  password = signal('');

  mensajeError = signal('');
  cargando = signal(false);

  constructor(
    private http: HttpClient,
    private router: Router
  ) {}

  iniciarSesion() {

    this.mensajeError.set('');
    this.cargando.set(true);

    const body = {
      username: this.username(),
      password: this.password()
    };

    this.http.post(
      'http://localhost:8212/login',
      body,
      { responseType: 'text' }
    ).subscribe({

      next: (response) => {

        console.log(response);

        this.cargando.set(false);

        this.router.navigate(['/dashboard']);
      },

      error: (error) => {

        console.error(error);

        this.cargando.set(false);

        this.mensajeError.set(
          error.error || 'Error al iniciar sesión'
        );
      }

    });

  }

}
