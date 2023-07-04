import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { trancheModel } from '../Models/tranche/trancheModel';

@Injectable({
  providedIn: 'root'
})
export class TrancheService {

  constructor(private http :HttpClient) { }


  getAllTranches(){
    return this.http.get<trancheModel[]>("http://localhost:8080/immobilier/getAllTranches/");
  }



 addTrancheetAffecteraContrat(idContrat:any,tranche:trancheModel){

  return this.http.post<trancheModel>("http://localhost:8080/immobilier/addTrancheAffecterToContrat/"+idContrat,tranche);
 }


 getTrancheById(id:any){
  return this.http.get<trancheModel>("http://localhost:8080/immobilier/getTrancheById/"+id);

 }



 updateTranche(tranche:trancheModel)
{
return this.http.put<trancheModel>("http://localhost:8080/immobilier/updateTranche/",tranche);

}



DeleteTrancheById(id:any){
  return this.http.delete("http://localhost:8080/immobilier/deleteTrancheById/"+id);
}

}
