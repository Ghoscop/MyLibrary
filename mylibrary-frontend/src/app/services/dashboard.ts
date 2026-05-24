import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DashboardData } from '../models/Dashboard';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  private http = inject(HttpClient);
  private api = 'http://localhost:8080/api/dashboard';

  buscarEstatisticas(): Observable<DashboardData> {
    return this.http.get<DashboardData>(this.api);
  }
}
