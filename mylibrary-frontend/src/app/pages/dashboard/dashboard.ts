import {Component, OnInit, inject, ChangeDetectorRef} from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardData } from '../../models/Dashboard';
import { DashboardService } from '../../services/dashboard';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class DashboardComponent implements OnInit {

  private service = inject(DashboardService);
  private cdr = inject(ChangeDetectorRef);

  dashboard?: DashboardData;

  ngOnInit(): void {
    this.carregarDashboard();
  }

  carregarDashboard(): void {
    this.service.buscarEstatisticas().subscribe({
      next: (dados) => {
        this.dashboard = dados;
        this.cdr.detectChanges();
      },
      error: (erro) => {
        console.error('Erro ao carregar dashboard:', erro);
      }
    });
  }
}
