import { RoleModel } from "../role/RoleModel"


export class UserModel {
  idUser!:number
  nom!:string
  prenom!:string
  adresse!:string
  email!:string
  profession!:string
  password!:string
  numTelephone!:number
  dateNaissance!:Date
  dateInscription!:Date
  role!:RoleModel
  
  
 }
 
    
    