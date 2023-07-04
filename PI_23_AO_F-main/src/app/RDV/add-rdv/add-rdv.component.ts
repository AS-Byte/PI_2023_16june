import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RdvModel } from 'src/app/Models/rdv/RdvModel';
import { RDVService } from 'src/app/Services/rdv.service';

@Component({
  selector: 'app-add-rdv',
  templateUrl: './add-rdv.component.html',
  styleUrls: ['./add-rdv.component.css']
})
export class AddRdvComponent implements OnInit {

  rdv:RdvModel=new RdvModel();
  mailSignataire!:any;


  constructor(private rdvservice:RDVService,private router:Router) { }

  ngOnInit(): void {





  }
  ajouterRdv(f:any){
    this.rdvservice.addRdvEtAffecterSignataire(this.mailSignataire,this.rdv).subscribe(
()=>{this.router.navigate(['/allDisponibility/']);}


    );

  }

}
