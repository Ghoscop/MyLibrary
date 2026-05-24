export interface Livro {
  id?: number;
  titulo: string;
  autor: string;
  status?: 'DISPONIVEL' | 'EMPRESTADO';
  categoriaId?: number;
  categoriaNome?: string;
  categoria?: {
    id: number;
  };
}
