import { Routes } from '@angular/router';

import { Dashboard } from './pages/dashboard/dashboard';
import { Categorias } from './pages/categorias/categorias';
import { Livros } from './pages/livros/livros';
import { Emprestimos } from './pages/emprestimos/emprestimos';

export const routes: Routes = [
  { path: '', component: Dashboard},
  { path: 'categorias', component: Categorias },
  { path: 'livros', component: Livros },
  { path: 'emprestimos', component: Emprestimos }
];
