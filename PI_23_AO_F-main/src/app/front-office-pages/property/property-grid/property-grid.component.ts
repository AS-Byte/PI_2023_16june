import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RdvModel } from 'src/app/Models/rdv/RdvModel';
import { RDVService } from 'src/app/Services/rdv.service';




@Component({
  selector: 'app-property-grid',
  templateUrl: './property-grid.component.html',
  styleUrls: ['./property-grid.component.css']
})
export class PropertyGridComponent implements OnInit {

  rdv:RdvModel=new RdvModel();
  mailSignataire!:any;
  mail:string="";
  constructor(private rdvservice:RDVService,private router:Router) { }

  ngOnInit(): void {
    this.mailSignataire=sessionStorage.getItem('email')
  }

  addRDV(f:any){
    
    this.rdvservice.addRdvEtAffecterSignataire(this.mailSignataire,this.rdv).subscribe(
    ()=>{this.router.navigate(['/allRdvsCl/']);}
    
    
        );}
  
}
