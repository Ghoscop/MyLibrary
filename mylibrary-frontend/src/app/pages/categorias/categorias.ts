import {Component, OnInit, inject} from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule} from '@angular/common';

import { Categoria } from '../../models/categoria';
import { CategoriaService } from '../../services/categoria';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-categorias',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './categorias.html',
  styleUrl: './categorias.css',
})
export class Categorias implements OnInit{

  private service: CategoriaService = inject(CategoriaService);

  categorias: Categoria[] = [];

  novaCategoria: Categoria = {
    nome: '',
    descricao: ''
  };

  ngOnInit(): void {
    this.carregarCategorias();
  }

  carregarCategorias(): void {
    this.service.findAll().subscribe({
      next: (dados) => {
        this.categorias = dados;
      }
    });
  }


  criarCategoria(): void {

    this.service.criar(this.novaCategoria).subscribe({
      next: () => {

        this.novaCategoria = {
          nome: '',
          descricao: ''
        };

        this.carregarCategorias();
      }
    });
  }

  excluirCategoria(id: number): void {
    this.service.excluir(id).subscribe({
      next: () => {
        this.carregarCategorias();
      }
    });
  }

}
