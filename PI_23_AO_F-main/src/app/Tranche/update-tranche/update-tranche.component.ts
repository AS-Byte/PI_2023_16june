import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ContratModel } from 'src/app/Models/contrat/ContratModel';
import { trancheModel } from 'src/app/Models/tranche/trancheModel';
import { ContratService } from 'src/app/Services/contrat.service';
import { TrancheService } from 'src/app/Services/tranche.service';

@Component({
  selector: 'app-update-tranche',
  templateUrl: './update-tranche.component.html',
  styleUrls: ['./update-tranche.component.css']
})
export class UpdateTrancheComponent implements OnInit {

  ident!:any;
 
  tranche:trancheModel=new trancheModel();
  contract:ContratModel=new ContratModel();
  contratslist!:ContratModel[];

  constructor(private router:Router,private ar:ActivatedRoute,private trancheservice:TrancheService ,private contratservice:ContratService) { }



  ngOnInit(): void {

    this.ident=this.ar.snapshot.params['id'];
    console.log(this.ident);

   this.trancheservice.getTrancheById(this.ident).subscribe(
    (data)=>{this.tranche=data;
      console.log(this.tranche);
      
    this.contract.idContrat=this.tranche.contrat.idContrat;
    console.log("contrat de tranche selectionnée");

    console.log(this.contract.idContrat);
  }    
   );



   this.contratservice.getAll().subscribe(

    (data1:ContratModel[])=>{this.contratslist=data1;
    console.log(this.contratslist);}    
    );

   

  }

  
    update(data:trancheModel){
      return this.trancheservice.updateTranche(data).subscribe(
        ()=>{this.router.navigate(['/allTranches/']);}
      );
      console.log(data);
      }
      








}
