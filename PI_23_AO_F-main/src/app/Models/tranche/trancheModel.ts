import { ContratModel } from "../contrat/ContratModel"




export class trancheModel {
  idTranche!:number
  dateEcheance!:Date
  etatPayement!:boolean
  montantEcheance!:number
  referencePayement!:number
  description!:string
  banque!:string  
  modePayement!:string
  contrat!:ContratModel 
  
  
  
 }