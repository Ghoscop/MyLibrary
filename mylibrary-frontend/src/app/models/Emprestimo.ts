export interface Emprestimo {
  id?: number;
  livroId?: number;
  tituloLivro?: string;
  livro?: {
    id: number;
  };
  nomePessoa: string;
  telefone: string;
  dataEmprestimo?: string;
  dataDevolucaoPrevista: string;
  dataDevolucaoEfetiva?: string;
}
