import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ContratModel } from 'src/app/Models/contrat/ContratModel';
import { ContratService } from 'src/app/Services/contrat.service';

@Component({
  selector: 'app-get-one-contrat',
  templateUrl: './get-one-contrat.component.html',
  styleUrls: ['./get-one-contrat.component.css']
})
export class GetOneContratComponent implements OnInit {
  ident!:any;
  contrat!:any;
  list!:ContratModel[];
  //contrat!:ContratModel;
  
  //contrat:ContratModel=new ContratModel(" ","",);

  constructor(private ar:ActivatedRoute,private contratService:ContratService) { }

  ngOnInit(): void {
    console.log('data');

this.ident=this.ar.snapshot.params['id'];
this.contratService.getContratById(this.ident).subscribe((data)=>{this.contrat=data});


console.log(this.ident);
console.log(this.contrat);
//---------------------------
/*this.ident=this.ar.snapshot.params['id'];
//this.idUser=1;
this.contratService.getAll().subscribe((data:ContratModel[])=>
      this.list=data);
      console.log(this.list);
     this.contrat= this.list.find((c)=>{c.idContrat===this.ident});
     console.log(this.contrat);*/




  }

}
