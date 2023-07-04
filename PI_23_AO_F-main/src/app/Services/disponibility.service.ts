import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DisponibilityModel } from '../Models/disponibility/DisponibilityModel';

@Injectable({
  providedIn: 'root'
})
export class DisponibilityService {

  constructor(private http:HttpClient) { }





  getAll(){
    return this.http.get<DisponibilityModel[]>("http://localhost:8080/immobilier/getAllDisponibilities");
  }
 addDisponibilityEtAffecterToAnnonce(id:any,disponibility:DisponibilityModel){

  return this.http.post<DisponibilityModel>("http://localhost:8080/immobilier/addDisponibility/"+id,disponibility);
 }
 getDisponibilityById(id:any){
  return this.http.get<DisponibilityModel>("http://localhost:8080/immobilier/getDisponibilityById/"+id);

 }
 updateDisponibility(disponibility:DisponibilityModel)
{
return this.http.put<DisponibilityModel>("http://localhost:8080/immobilier/updateDisponibility/",disponibility);

}
DeleteDisponibility(id:any){
  return this.http.delete("http://localhost:8080/immobilier/deleteDisponibilityById/"+id);
}


}
