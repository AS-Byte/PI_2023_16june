import { UserModel } from "../user/UserModel"



export class ContratModel {
    idContrat!:number
    dateDebut!:Date
    dateFin!:Date
    montant!:number
    commission!:number
    montantMensuel!:number
    modalitePayement!:string
    typeContrat!:string
    etatContrat!:string
    signataire!:UserModel
    archive!:boolean
    bank!:string
   
 }
