import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AnnonceModel } from '../Models/annonce/AnnonceModel';

@Injectable({
  providedIn: 'root'
})
export class AnnonceService {

  constructor(private http:HttpClient) { }


  getAll(){
    return this.http.get<AnnonceModel[]>("http://localhost:8080/immobilier/getAllAnnonces")
  }
  getAnnonceById(id:any){
    return this.http.get<AnnonceModel>("http://localhost:8080/immobilier/getAnnonceById/"+id);
  
   }



}
