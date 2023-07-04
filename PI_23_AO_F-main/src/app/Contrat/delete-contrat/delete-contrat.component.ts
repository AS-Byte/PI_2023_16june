import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ContratModel } from 'src/app/Models/contrat/ContratModel';
import { ContratService } from 'src/app/Services/contrat.service';

@Component({
  selector: 'app-delete-contrat',
  templateUrl: './delete-contrat.component.html',
  styleUrls: ['./delete-contrat.component.css']
})
export class DeleteContratComponent implements OnInit {
  id!:any;
  list!:ContratModel[];
  constructor(private ar:ActivatedRoute,private contratService:ContratService,private router:Router) { }

  ngOnInit(): void {

   
  /*this.id=this.ar.snapshot.params['id'];

  console.log(this.id);
  if (confirm("Etes-vous sûr de supprimer l'element?"))
  {
      this.contratService.DeleteContrat(this.id);
      
        
          this.router.navigate(['/allContrats/']);
         
          //alert("l'element est supprimé avec succès!")
        }*/
     
           
         
   }
   
  }
          
