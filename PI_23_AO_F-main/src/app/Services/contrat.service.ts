import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ContratModel } from '../Models/contrat/ContratModel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContratService {

  constructor(private http :HttpClient) { }

  getAll(){
    return this.http.get<ContratModel[]>("http://localhost:8080/immobilier/getAllContrats/")
  }
 addContratEtAffecterSignataire(email:any,Contrat:ContratModel){

  return this.http.post<ContratModel>("http://localhost:8080/immobilier/addContratEtAffecterSignataire/"+email,Contrat);
 }
 getContratById(id:any){
  return this.http.get<ContratModel>("http://localhost:8080/immobilier/getContratById/"+id);

 }
 updateContrat(contrat:ContratModel)
{
return this.http.put<ContratModel>("http://localhost:8080/immobilier/updateContrat/",contrat);

}
DeleteContrat(id:any){
  return this.http.delete("http://localhost:8080/immobilier/deleteContratById/"+id);
}




}
