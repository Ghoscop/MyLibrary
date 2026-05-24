import {Component, OnInit, inject, ChangeDetectorRef} from '@angular/core';
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

  atrasados: Emprestimo[] = [];
  livros: Livro[] = [];
  emprestimos: Emprestimo[] = [];
  mensagemErro = '';
  mensagemSucesso = '';

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
    this.carregarAtrasados();
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

  carregarAtrasados(): void {
    this.emprestimoService
      .atrasados()
      .subscribe({
        next: (dados) => {
          this.atrasados = dados;
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
    this.mensagemSucesso = '';

    if (
      !this.novoEmprestimo.livro?.id ||
      this.novoEmprestimo.livro.id === 0 ||
      !this.novoEmprestimo.nomePessoa?.trim() ||
      !this.novoEmprestimo.telefone?.trim() ||
      !this.novoEmprestimo.dataDevolucaoPrevista
    ) {

      this.mensagemErro =
        'Preencha todos os campos do empréstimo.';

      this.cdr.detectChanges();
      return;
    }

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

          this.mensagemSucesso = 'Emprestimo realizado com sucesso!';
          this.carregarLivros();
          this.carregarEmprestimos();
          this.carregarAtrasados();
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

    const confirmar = confirm('Tem certeza que deseja devolver este livro?');

    if (!confirmar) {
      return;
    }

    this.emprestimoService
      .devolver(id)
      .subscribe({

        next: () => {
          this.mensagemSucesso = 'Livro devolvido com sucesso!';
          this.carregarLivros();
          this.carregarEmprestimos();
          this.carregarAtrasados();
        }
      });
  }
}
