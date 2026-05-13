import { Component } from '@angular/core';

import { RouterLink, Router }
from '@angular/router';

import { FormsModule }
from '@angular/forms';

@Component({
  selector: 'app-landing',

  standalone: true,

  imports: [
    RouterLink,
    FormsModule
  ],

  templateUrl: './landing.html',

  styleUrl: './landing.css'
})

export class Landing {

  username = '';

  password = '';

  constructor(
    private router: Router
  ) {}

  login(): void {

    if (
      this.username === 'admin' &&
      this.password === '1234'
    ) {

      this.router.navigate([
        '/dashboard'
      ]);

    } else {

      alert(
        'Credenciales incorrectas'
      );

    }

  }

}