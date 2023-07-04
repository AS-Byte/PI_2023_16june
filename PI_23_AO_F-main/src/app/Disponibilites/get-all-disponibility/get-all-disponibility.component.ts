import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AnnonceModel } from 'src/app/Models/annonce/AnnonceModel';
import { DisponibilityModel } from 'src/app/Models/disponibility/DisponibilityModel';
import { DisponibilityService } from 'src/app/Services/disponibility.service';

@Component({
  selector: 'app-get-all-disponibility',
  templateUrl: './get-all-disponibility.component.html',
  styleUrls: ['./get-all-disponibility.component.css']
})
export class GetAllDisponibilityComponent implements OnInit {

  list!:DisponibilityModel[];
  disponible:DisponibilityModel=new DisponibilityModel();

annonce:AnnonceModel=new AnnonceModel();

  constructor( private disponibleservice:DisponibilityService, private router:Router) { }

  ngOnInit(): void {

this.disponibleservice.getAll().subscribe(

(data:DisponibilityModel[])=>{this.list=data;
console.log ( this.list);}

);


  }



  update(id:any){
    this.router.navigate(['/admin/updateDisponibility/'+id]);
    
       }



       delete(id:any){
      
        this.disponibleservice.DeleteDisponibility(id).subscribe(
     
         ()=>{this.disponibleservice.getAll().subscribe((data:DisponibilityModel[])=>
               this.list=data);},
               (error)=>{alert(id+'inexistant!!');}
               
     
            );
           
           }

           afficherOneDisponibility(id:any){

           this.disponibleservice.getDisponibilityById(id).subscribe(

           (data:DisponibilityModel)=>{this.disponible=data;
          console.log (this.disponible);
          this.annonce=this.disponible.annonce;
        
        
        }

           );


           }



}
