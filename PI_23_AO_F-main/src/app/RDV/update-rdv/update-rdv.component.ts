import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RdvModel } from 'src/app/Models/rdv/RdvModel';
import { UserModel } from 'src/app/Models/user/UserModel';
import { RDVService } from 'src/app/Services/rdv.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-update-rdv',
  templateUrl: './update-rdv.component.html',
  styleUrls: ['./update-rdv.component.css']
})
export class UpdateRdvComponent implements OnInit {


ident!:any;
rdv:RdvModel=new RdvModel();
visitor:UserModel=new UserModel();

  constructor(private rdvservice:RDVService,private router:Router,private ar:ActivatedRoute,private userservice:UserService) { }

  ngOnInit(): void {


    this.ident=this.ar.snapshot.params['id'];
    this.rdvservice.getRDVById(this.ident).subscribe((data:RdvModel)=>{this.rdv=data;
      this.visitor=this.rdv.visiteur;
      console.log(this.visitor);
  
    });

/*this.userservice.getUserById(this.rdv.visiteur.idUser).subscribe(

  (data1:UserModel)=>{this.visitor=data1;
    console.log(this.visitor);
  }
);*/

    console.log(this.ident);

  }



  update(data:RdvModel){
    return this.rdvservice.updateRDV(data).subscribe(
      ()=>{this.router.navigate(['/allRdvs/']);}
    );
    console.log(data);
    }
    

}
