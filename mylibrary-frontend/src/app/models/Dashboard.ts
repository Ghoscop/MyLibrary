import { Emprestimo } from './Emprestimo';

export interface DashboardData {
  totalLivros: number;
  livrosDisponiveis: number;
  livrosEmprestados: number;
  emprestimosAtivos: number;
  ultimosEmprestimos: Emprestimo[];
}
