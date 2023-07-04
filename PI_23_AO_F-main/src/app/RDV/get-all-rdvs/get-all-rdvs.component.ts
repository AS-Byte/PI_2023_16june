import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RdvModel } from 'src/app/Models/rdv/RdvModel';
import { UserModel } from 'src/app/Models/user/UserModel';
import { RDVService } from 'src/app/Services/rdv.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-get-all-rdvs',
  templateUrl: './get-all-rdvs.component.html',
  styleUrls: ['./get-all-rdvs.component.css']
})

export class GetAllRdvsComponent implements OnInit {



  listRdvs!:RdvModel[];
  rdv:RdvModel=new RdvModel();
 visiteur:UserModel=new UserModel();

  constructor(private rdvservice:RDVService,private router:Router,private userservice:UserService) { }

  ngOnInit(): void {

this.rdvservice.getAll().subscribe(

  (data:RdvModel[])=>{this.listRdvs=data;
  console.log(this.listRdvs);}
);

  }



  afficherOneRDV(id:any){
this.rdvservice.getRDVById(id).subscribe(

  (data:RdvModel)=>{this.rdv=data;
  
;}
);

  }

  updateRDV(id:any){

    this.router.navigate(['/admin/updateRdv/'+id]);

  }


  deleteRDV(id:any){
    this.rdvservice.DeleteRDV(id).subscribe(
      ()=>{this.router.navigate(['/admin/allRdvs/']);}    
            
      
      );

  }




  annuler(){
    this.router.navigate(['/allRdvs/']);
   }

}
