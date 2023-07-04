import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContratModel } from 'src/app/Models/contrat/ContratModel';
import { UserModel } from 'src/app/Models/user/UserModel';
import { ContratService } from 'src/app/Services/contrat.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-add-contrat',
  templateUrl: './add-contrat.component.html',
  styleUrls: ['./add-contrat.component.css']
})
export class AddContratComponent implements OnInit {

   contrat:ContratModel=new ContratModel();
   mailSignataire!:any;
   

   
  constructor(private contratService:ContratService,private router:Router) { }

  ngOnInit(): void {
    this.mailSignataire=sessionStorage.getItem('email')
    
  }

  ajouter(f:any){
  

    this.contratService.addContratEtAffecterSignataire(this.mailSignataire,this.contrat).subscribe(
()=>{this.router.navigate(['/allContrats/']);}

    );
  }

    
  }
   
    

  

  


