import { Component, signal } from '@angular/core';

import { Router, RouterOutlet }
from '@angular/router';

import { UpperCasePipe }
from '@angular/common';

@Component({
  selector: 'app-root',

  standalone: true,

  imports: [
    RouterOutlet,
    UpperCasePipe
  ],

  templateUrl: './app.html',

  styleUrl: './app.css'
})

export class App {

  protected readonly title =
    signal('fronted');

  constructor(
    public router: Router
  ) {}

}