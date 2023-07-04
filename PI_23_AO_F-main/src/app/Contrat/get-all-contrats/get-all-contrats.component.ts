import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ContratModel } from 'src/app/Models/contrat/ContratModel';
import { UserModel } from 'src/app/Models/user/UserModel';
import { ContratService } from 'src/app/Services/contrat.service';

@Component({
  selector: 'app-get-all-contrats',
  templateUrl: './get-all-contrats.component.html',
  styleUrls: ['./get-all-contrats.component.css']
})
export class GetAllContratsComponent implements OnInit {
  list!:ContratModel[];
  //ident!:any;

  
  contrat:ContratModel=new ContratModel();
  signataire:UserModel=new UserModel();
  
  
  
  constructor(private contratService:ContratService,private router:Router) { 
    
  }

  ngOnInit(): void {
    
    
    this.contratService.getAll().subscribe((data:ContratModel[])=>
    { ( this.list=data);
     
      //console.log(this.list);
    } );  

    }



    afficherOneContrat(id:any){
      console.log(id);
      this.contratService.getContratById(id).subscribe(
      
        (data1:ContratModel)=>{this.contrat=data1;
          console.log(this.contrat);
  
          this.signataire=this.contrat.signataire;
          console.log(this.signataire);
        
        }
      );

      }

   update(id:any){
this.router.navigate(['/admin/updateContrat/'+id]);

   }


  delete(id:any){
      
   this.contratService.DeleteContrat(id).subscribe(

    ()=>{this.contratService.getAll().subscribe((data:ContratModel[])=>
          this.list=data);},
          (error)=>{alert(id+'inexistant!!');}
          

       );
      
      }





      
      
  }
        











    
  


