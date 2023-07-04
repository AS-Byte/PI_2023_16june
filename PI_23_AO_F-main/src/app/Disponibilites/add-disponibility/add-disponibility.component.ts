import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AnnonceModel } from 'src/app/Models/annonce/AnnonceModel';
import { DisponibilityModel } from 'src/app/Models/disponibility/DisponibilityModel';
import { AnnonceService } from 'src/app/Services/annonce.service';
import { DisponibilityService } from 'src/app/Services/disponibility.service';

@Component({
  selector: 'app-add-disponibility',
  templateUrl: './add-disponibility.component.html',
  styleUrls: ['./add-disponibility.component.css']
})
export class AddDisponibilityComponent implements OnInit {


 disponible:DisponibilityModel=new DisponibilityModel();

annonceslist!:AnnonceModel[];
    id!:any;
    

  constructor(private disponibleservice:DisponibilityService, private annonceservice:AnnonceService, private router:Router) { }

  ngOnInit(): void {
    this.annonceservice.getAll().subscribe(
(data:AnnonceModel[])=>{this.annonceslist=data;
console.log(this.annonceslist);}


    );

    console.log(this.id);

  }


  ajouterDisponible(f:any){

    this.id=f.annonce.idAnnonce;


    this.disponibleservice.addDisponibilityEtAffecterToAnnonce(this.id,this.disponible).subscribe(
()=>{
  console.log(this.id);
  this.router.navigate(['/allDisponibility/']);}


    );

  }


}
