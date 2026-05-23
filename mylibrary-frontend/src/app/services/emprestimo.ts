import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Emprestimo } from '../models/Emprestimo';

@Injectable({
  providedIn: 'root'
})
export class EmprestimoService {

  private http = inject(HttpClient);
  private api = 'http://localhost:8080/api/emprestimos';

  findAll(): Observable<Emprestimo[]> {
    return this.http.get<Emprestimo[]>(this.api);
  }

  ativos(): Observable<Emprestimo[]> {
    return this.http.get<Emprestimo[]>(`${this.api}/ativos`);
  }

  atrasados(): Observable<Emprestimo[]> {
    return this.http.get<Emprestimo[]>(`${this.api}/atrasados`);
  }

  emprestar(emprestimo: Emprestimo): Observable<Emprestimo> {
    return this.http.post<Emprestimo>(`${this.api}/emprestar`, emprestimo);
  }

  devolver(id: number): Observable<Emprestimo> {
    return this.http.post<Emprestimo>(`${this.api}/${id}/devolver`, {});
  }
}
