import { Component, OnInit } from '@angular/core';
import { ContratService } from '../Services/contrat.service';
import { ContratModel } from '../Models/contrat/ContratModel';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
 
  
  constructor() { }

  ngOnInit(): void {
    
  }

}
