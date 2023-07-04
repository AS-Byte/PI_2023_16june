import { UserModel } from "../user/UserModel"

export class RdvModel {

  idRDV!:number
  dateRDV!:Date
  dureeRDV!:number 
  contenuFeedback!:string
  noteVisite!:number
  typeFeedback!:string
  visiteur!:UserModel

 }
