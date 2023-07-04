import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ContratModel } from 'src/app/Models/contrat/ContratModel';
import { ContratService } from 'src/app/Services/contrat.service';

@Component({
  selector: 'app-update-contrat',
  templateUrl: './update-contrat.component.html',
  styleUrls: ['./update-contrat.component.css']
})
export class UpdateContratComponent implements OnInit {

  
  ident!:any;
 
  contrat!:any;
  
  constructor(private contratservice:ContratService,private router:Router,private ar:ActivatedRoute ) { }

  ngOnInit(): void {

 
 this.ident=this.ar.snapshot.params['id'];
this.contratservice.getContratById(this.ident).subscribe((data)=>{this.contrat=data});
console.log(this.ident);
  }

  update(data:ContratModel){
    return this.contratservice.updateContrat(data).subscribe(
      ()=>{this.router.navigate(['/allContrats/']);}
    );
    console.log(data);
    }
    

}
