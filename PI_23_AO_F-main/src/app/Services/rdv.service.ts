import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RdvModel } from '../Models/rdv/RdvModel';

@Injectable({
  providedIn: 'root'
})
export class RDVService {

  constructor(private http:HttpClient) { }



    getAll(){
      return this.http.get<RdvModel[]>("http://localhost:8080/immobilier/getAllRDV");
    }

    
    getRdvByEmail(email:any){
      return this.http.get<RdvModel[]>("http://localhost:8080/immobilier/getRdvsByEmailVisiteur/"+email);
    }


   addRdvEtAffecterSignataire(email:any,rdv:RdvModel){
  
    return this.http.post<RdvModel>("http://localhost:8080/immobilier/addRDVEtAffecterVisiteur/"+email,rdv);
   }


   getRDVById(id:any){
    return this.http.get<RdvModel>("http://localhost:8080/immobilier/getRDVById/"+id);
  
   }


   updateRDV(rdv:RdvModel)
  {
  return this.http.put<RdvModel>("http://localhost:8080/immobilier/updateRDV/",rdv);
  

  }


  DeleteRDV(id:any){
    return this.http.delete("http://localhost:8080/immobilier/deleteRDVById/"+id);
  }
  
  


  
}
