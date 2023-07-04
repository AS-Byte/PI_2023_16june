import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { trancheModel } from 'src/app/Models/tranche/trancheModel';
import { TrancheService } from 'src/app/Services/tranche.service';

@Component({
  selector: 'app-get-one-tranche',
  templateUrl: './get-one-tranche.component.html',
  styleUrls: ['./get-one-tranche.component.css']
})
export class GetOneTrancheComponent implements OnInit {


  idSearch!:any;
  tranche:trancheModel=new trancheModel();


  constructor(private trancheservice:TrancheService,private router:Router) { }

  ngOnInit(): void {
    
    
  }


  afficherTranche(){
    console.log(this.idSearch)
this.trancheservice.getTrancheById(this.idSearch).subscribe(

   (data:trancheModel)=>{this.tranche=data;} );


  }


  update(id:any){

    this.router.navigate(['/updateTranche/'+id]);


  }
}
