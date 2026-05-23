import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Livro } from '../models/Livro';


@Injectable({
  providedIn: 'root',
})
export class LivroService {

  private http = inject(HttpClient);
  private api = 'http://localhost:8080/api/livros';

  findAll(): Observable<Livro[]> {
    return this.http.get<Livro[]>(this.api);
  }

  criar(livro: Livro): Observable<Livro> {
    return this.http.post<Livro>(this.api, livro);
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.api}/${id}`);
  }

  buscar(texto: string): Observable<Livro[]> {
    return this.http.get<Livro[]>(
      `${this.api}/buscar?texto=${encodeURIComponent(texto)}`
    );
  }

  filtrarPorStatus(status: string): Observable<Livro[]> {
    return this.http.get<Livro[]>(`${this.api}/status/${status}`);
  }

  filtrarPorCategoria(categoriaId: number): Observable<Livro[]> {
    return this.http.get<Livro[]>(`${this.api}/categoria/${categoriaId}`);
  }

}
