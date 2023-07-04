import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ContratModel } from 'src/app/Models/contrat/ContratModel';
import { trancheModel } from 'src/app/Models/tranche/trancheModel';
import { ContratService } from 'src/app/Services/contrat.service';
import { TrancheService } from 'src/app/Services/tranche.service';

@Component({
  selector: 'app-get-all-tranches',
  templateUrl: './get-all-tranches.component.html',
  styleUrls: ['./get-all-tranches.component.css']
})
export class GetAllTranchesComponent implements OnInit {
  listTranches!:trancheModel[];
  ident!:any;
contratslist!:ContratModel[];
tranche:trancheModel=new trancheModel();
contrat:ContratModel=new ContratModel();

  constructor(private trancheService:TrancheService,private router:Router,private contratservice:ContratService) { }

  ngOnInit(): void {

    this.trancheService.getAllTranches().subscribe(

      (data:trancheModel[])=>{this.listTranches=data;

        console.log("all tranches below");
        console.log(this.listTranches);
      
      }
    );   
  
  }
  


  afficherOneTranche(id:any){
    console.log(id);
    this.trancheService.getTrancheById(id).subscribe(
    
      (data1:trancheModel)=>{this.tranche=data1;
        console.log(this.tranche);

        this.contrat=this.tranche.contrat;
        console.log(this.contrat);
      
      }
    );
    
           }
      
  
  update(id:any){
    this.router.navigate(['/admin/updateTranche/'+id]);
    
       }
            
       deleteTranche(id:any){
       this.trancheService.DeleteTrancheById(id).subscribe(
       ()=>{this.router.navigate(['/allTranches/']);}    
             
       
       );
        

       }



       annuler(){
        this.router.navigate(['/allTranches/']);
       }

}
