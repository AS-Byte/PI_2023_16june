import { Component, OnInit } from '@angular/core';
import { RdvModel } from 'src/app/Models/rdv/RdvModel';

import { RDVService } from 'src/app/Services/rdv.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-compte-client',
  templateUrl: './compte-client.component.html',
  styleUrls: ['./compte-client.component.css']
})
export class CompteClientComponent implements OnInit {
 mail!:any;
rdvlist!:RdvModel[];


  constructor(private rdvservice:RDVService) { }

  ngOnInit(): void {
    this.mail=sessionStorage.getItem('email');
  }



  myRDV(){
this.rdvservice.getRdvByEmail(this.mail).subscribe(

(data:RdvModel[])=>{this.rdvlist=data;
console.log(this.rdvlist);}

);


  }



}
