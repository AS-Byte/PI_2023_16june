import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AnnonceModel } from 'src/app/Models/annonce/AnnonceModel';
import { ContratModel } from 'src/app/Models/contrat/ContratModel';
import { DisponibilityModel } from 'src/app/Models/disponibility/DisponibilityModel';
import { AnnonceService } from 'src/app/Services/annonce.service';
import { DisponibilityService } from 'src/app/Services/disponibility.service';

@Component({
  selector: 'app-update-disponibility',
  templateUrl: './update-disponibility.component.html',
  styleUrls: ['./update-disponibility.component.css']
})
export class UpdateDisponibilityComponent implements OnInit {


  ident!:any;
  disponible:DisponibilityModel=new DisponibilityModel();
  annonce:AnnonceModel=new AnnonceModel();
  annonceslist!:AnnonceModel[];

  constructor(private disponibleservice:DisponibilityService,private router:Router,private ar:ActivatedRoute,private annonceservice:AnnonceService) { }

  ngOnInit(): void {

    this.ident=this.ar.snapshot.params['id'];
    console.log(this.ident);

this.disponibleservice.getDisponibilityById(this.ident).subscribe(

  (data:DisponibilityModel)=>{this.disponible=data;
    console.log(this.disponible);
  this.annonce=this.disponible.annonce;
  console.log(this.annonce);
}
);

this.annonceservice.getAll().subscribe(
  (data1:AnnonceModel[])=>{this.annonceslist=data1;
    console.log(this.annonceslist);
  }
);


  }



  update(data:DisponibilityModel){
    return this.disponibleservice.updateDisponibility(data).subscribe(
      ()=>{this.router.navigate(['/allDisponibility/']);}
    );
    console.log(data);
    }

}
