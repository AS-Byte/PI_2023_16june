import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContratModel } from 'src/app/Models/contrat/ContratModel';
import { trancheModel } from 'src/app/Models/tranche/trancheModel';
import { ContratService } from 'src/app/Services/contrat.service';
import { TrancheService } from 'src/app/Services/tranche.service';

@Component({
  selector: 'app-add-tranche',
  templateUrl: './add-tranche.component.html',
  styleUrls: ['./add-tranche.component.css']
})
export class AddTrancheComponent implements OnInit {



  tranche:trancheModel=new trancheModel();
  idContrat!:number;
  contratslist!:ContratModel[];
  constructor(private trancheservice:TrancheService,private router:Router,private contratservice:ContratService) { }

  ngOnInit(): void {
this.contratservice.getAll().subscribe(

(data1:ContratModel[])=>{this.contratslist=data1;
console.log(this.contratslist);}

);

  }

  ajouterTranche(f:any){
    this.idContrat=f.contrat.idContrat;
    

   
   this.trancheservice.addTrancheetAffecteraContrat(this.idContrat,this.tranche).subscribe(

    ()=>{      
         this.router.navigate(['/allTranches/']);
  
         //console.log (this.tranche);
        
        }
  
  );
      
  }

}
