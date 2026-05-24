import { Routes } from '@angular/router';

import { DashboardComponent } from './pages/dashboard/dashboard';
import { Categorias } from './pages/categorias/categorias';
import { Livros } from './pages/livros/livros';
import { Emprestimos } from './pages/emprestimos/emprestimos';

export const routes: Routes = [
  { path: '', component: DashboardComponent},
  { path: 'categorias', component: Categorias },
  { path: 'livros', component: Livros },
  { path: 'emprestimos', component: Emprestimos }
];
