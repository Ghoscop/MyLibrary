import {
  Component,
  OnInit,
  inject,
  ChangeDetectorRef
} from '@angular/core';

import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { Livro } from '../../models/Livro';
import { Emprestimo } from '../../models/Emprestimo';

import { LivroService } from '../../services/livro';
import { EmprestimoService } from '../../services/emprestimo';

@Component({
  selector: 'app-emprestimos',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './emprestimos.html',
  styleUrl: './emprestimos.css'
})
export class Emprestimos implements OnInit {

  private livroService = inject(LivroService);
  private emprestimoService = inject(EmprestimoService);
  private cdr = inject(ChangeDetectorRef);

  livros: Livro[] = [];
  emprestimos: Emprestimo[] = [];

  mensagemErro = '';

  novoEmprestimo: Emprestimo = {
    livro: {
      id: 0
    },
    nomePessoa: '',
    telefone: '',
    dataDevolucaoPrevista: ''
  };

  ngOnInit(): void {
    this.carregarLivros();
    this.carregarEmprestimos();
  }

  carregarLivros(): void {

    this.livroService
      .filtrarPorStatus('DISPONIVEL')
      .subscribe({

        next: (dados) => {
          this.livros = dados;
          this.cdr.detectChanges();
        }
      });
  }

  carregarEmprestimos(): void {

    this.emprestimoService
      .ativos()
      .subscribe({

        next: (dados) => {
          this.emprestimos = dados;
          this.cdr.detectChanges();
        }
      });
  }

  emprestarLivro(): void {

    this.mensagemErro = '';

    this.emprestimoService
      .emprestar(this.novoEmprestimo)
      .subscribe({

        next: () => {

          this.novoEmprestimo = {
            livro: {
              id: 0
            },
            nomePessoa: '',
            telefone: '',
            dataDevolucaoPrevista: ''
          };

          this.carregarLivros();
          this.carregarEmprestimos();
        },

        error: (erro) => {

          this.mensagemErro =
            erro?.error?.mensagem ||
            'Erro ao realizar empréstimo.';

          this.cdr.detectChanges();
        }
      });
  }

  devolverLivro(id: number): void {

    this.emprestimoService
      .devolver(id)
      .subscribe({

        next: () => {
          this.carregarLivros();
          this.carregarEmprestimos();
        }
      });
  }
}
