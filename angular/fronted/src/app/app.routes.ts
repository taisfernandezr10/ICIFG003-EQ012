import { Routes } from '@angular/router';

export const routes: Routes = [

  {
    path: '',
    loadComponent: () =>
      import('./features/landing/landing/landing')
        .then(m => m.Landing)
  },

  {
    path: 'login',
    loadComponent: () =>
      import('./features/login/login/login')
        .then(m => m.Login)
  },

  {
    path: 'dashboard',
    loadComponent: () =>
      import('./features/dashboard/dashboard/dashboard')
        .then(m => m.Dashboard)
  },

  {
    path: 'personas',
    loadChildren: () =>
      import('./features/personas/persona.routes')
        .then(m => m.PERSONA_ROUTES)
  },

  {
  path: 'matriculas',

  loadComponent: () =>

    import(
      './features/matriculas/pages/matriculas-page/matriculas-page'
    ).then(m => m.MatriculasPage)
  },  
 
  {
    path: '**',
    redirectTo: ''
  }

];