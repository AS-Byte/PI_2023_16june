import { CategorieModel } from "../categoriemodel/CategorieModel"
import { ContratModel } from "../contrat/ContratModel"
import { DisponibilityModel } from "../disponibility/DisponibilityModel"
import { RdvModel } from "../rdv/RdvModel"
import { UserModel } from "../user/UserModel"

export class AnnonceModel {

  idAnnonce!:number
  adresseAnnonce!:string
  superficie!:number   
  dateAnnonce!:Date
  description!:string
  typeAnnonce!:string
  annonceur!:UserModel
  listRDVs!:RdvModel[]
  category!:CategorieModel
  contratList!:ContratModel[]  
  disponibilityList!:DisponibilityModel[]

 }