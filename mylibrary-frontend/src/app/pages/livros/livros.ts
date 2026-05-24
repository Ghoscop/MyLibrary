import {Component, OnInit, inject, ChangeDetectorRef} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Livro } from '../../models/Livro';
import { Categoria } from '../../models/categoria';
import { LivroService } from '../../services/livro';
import { CategoriaService } from '../../services/categoria';

@Component({
  selector: 'app-livros',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './livros.html',
  styleUrl: './livros.css'
})
export class Livros implements OnInit {

  private livroService = inject(LivroService);
  private categoriaService = inject(CategoriaService);
  private cdr = inject(ChangeDetectorRef);

  mensagemErro = '';
  mensagemSucesso = '';
  livros: Livro[] = [];
  categorias: Categoria[] = [];

  novoLivro: Livro = {
    titulo: '',
    autor: '',
    categoria: {
      id: 0
    }
  };

  termoBusca = '';

  ngOnInit(): void {
    this.carregarLivros();
    this.carregarCategorias();
  }

  carregarLivros(): void {
    this.livroService.findAll().subscribe({
      next: (dados) => {
        this.livros = dados;
        this.cdr.detectChanges();
      }
    });
  }

  carregarCategorias(): void {
    this.categoriaService.findAll().subscribe({
      next: (dados) => {
        this.categorias = dados;
        this.cdr.detectChanges();
      }
    });
  }

  criarLivro(): void {

    this.mensagemErro = '';
    this.mensagemSucesso = '';

    this.livroService.criar(this.novoLivro).subscribe({

      next: () => {

        this.mensagemSucesso = 'Livro cadastrado com sucesso!';

        this.novoLivro = {
          titulo: '',
          autor: '',
          categoria: {
            id: 0
          }
        };

        this.carregarLivros();
      },

      error: (erro) => {

        this.mensagemErro =
          erro?.error?.mensagem ||
          'Erro ao cadastrar livro.';

        this.cdr.detectChanges();
      }
    });
  }

  excluirLivro(id: number): void {
    const confirmar = confirm('Tem certeza que deseja excluir este livro?');

    if (!confirmar) {
      return;
    }

    this.livroService.excluir(id).subscribe({
      next: () => {
        this.mensagemSucesso = 'Livro excluído com sucesso!';
        this.carregarLivros();
      }
    });
  }

  buscarLivro(): void {
    const texto = this.termoBusca.trim();

    if (!texto) {
      this.carregarLivros();
      return;
    }

    this.livroService.buscar(texto).subscribe({
      next: (dados) => {
        this.livros = dados;
        this.cdr.detectChanges();
      },
      error: (erro) => {
        console.error('Erro ao buscar livros:', erro);
      }
    });
  }
}
