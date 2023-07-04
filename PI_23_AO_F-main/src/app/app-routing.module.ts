import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GetAllContratsComponent } from './Contrat/get-all-contrats/get-all-contrats.component';
import { AddContratComponent } from './Contrat/add-contrat/add-contrat.component';
import { UpdateContratComponent } from './Contrat/update-contrat/update-contrat.component';
import { ContactComponent } from './front-office-pages/contact/contact.component';
import { PropertyGridComponent } from './front-office-pages/property/property-grid/property-grid.component';
import { PropertySingleComponent } from './front-office-pages/property/property-single/property-single.component';
import { BlogGridComponent } from './front-office-pages/blog/blog-grid/blog-grid.component';
import { BlogSingleComponent } from './front-office-pages/blog/blog-single/blog-single.component';
import { AboutComponent } from './front-office-pages/about/about.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HomeComponent } from './front-office-pages/home/home.component';
import { OwnerComponent } from './front-office-pages/owner/owner/owner.component';
import { OwnerSingleComponent } from './front-office-pages/owner/owner-single/owner-single.component';
import { LoginComponent } from './user/login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { GetOneContratComponent } from './Contrat/get-one-contrat/get-one-contrat.component';
import { DeleteContratComponent } from './Contrat/delete-contrat/delete-contrat.component';
import { GetAllTranchesComponent } from './Tranche/get-all-tranches/get-all-tranches.component';
import { GetOneTrancheComponent } from './Tranche/get-one-tranche/get-one-tranche.component';
import { UpdateTrancheComponent } from './Tranche/update-tranche/update-tranche.component';
import { AddTrancheComponent } from './Tranche/add-tranche/add-tranche.component';
import { GetAllRdvsComponent } from './RDV/get-all-rdvs/get-all-rdvs.component';
import { AddRdvComponent } from './RDV/add-rdv/add-rdv.component';
import { UpdateRdvComponent } from './RDV/update-rdv/update-rdv.component';
import { GetOneRdvComponent } from './RDV/get-one-rdv/get-one-rdv.component';
import { GetAllDisponibilityComponent } from './Disponibilites/get-all-disponibility/get-all-disponibility.component';
import { AddDisponibilityComponent } from './Disponibilites/add-disponibility/add-disponibility.component';
import { UpdateDisponibilityComponent } from './Disponibilites/update-disponibility/update-disponibility.component';
import { GetOneDisponibilityComponent } from './Disponibilites/get-one-disponibility/get-one-disponibility.component';
import { AlltemplateComponent } from './front-office/alltemplate/alltemplate.component';
import { AlltemplateBackComponent } from './back-office/alltemplate-back/alltemplate-back.component';
import { CompteClientComponent } from './front-office-pages/compte-client/compte-client.component';
import { UserListComponent } from './user/user-list/user-list/user-list.component';
import { ForgotPasswordComponent } from './user/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './user/reset-password/reset-password.component';
import { AccountUpdateComponent } from './user/account-update/account-update.component';
import { AuthGuard } from './user/auth-helper/auth.guard';
import { SessionComponent } from './user/session/session.component';
const routes: Routes = [
  {path:'', component:AlltemplateComponent,
    children:[
        { path: '', component: HomeComponent },
        { path: 'about', component: AboutComponent },
        { path: 'blog', component: BlogGridComponent },
        { path: 'blog-single', component: BlogSingleComponent },
        { path: 'contact', component: ContactComponent },
        { path: 'property', component: PropertyGridComponent },
        { path: 'property-single', component: PropertySingleComponent },
        { path: 'owner', component: OwnerComponent },
        { path: 'owner-single', component: OwnerSingleComponent },
        {path: 'contact', component: ContactComponent },
        {path:'addContratCl',component:AddContratComponent},
        {path:'updateContratCl/:id',component:UpdateContratComponent},
        {path:'addRdvCl',component:AddRdvComponent},
        {path:'updateRdvCl/:id',component:UpdateRdvComponent},
        {path:'addDisponibilityCl',component:AddDisponibilityComponent},
        {path:'updateDisponibilityCl/:id',component:UpdateDisponibilityComponent},
        {path:'myAccountCl',component:CompteClientComponent},
        {path:'allRdvsCl',component:GetAllRdvsComponent},
      ] },

  {path:'admin', component:AlltemplateBackComponent,
    children:[
        {path:'allContrats',component:GetAllContratsComponent},
        {path:'addContrat',component:AddContratComponent},
        {path:'updateContrat/:id',component:UpdateContratComponent},
        {path:'getOneContrat/:id',component:GetOneContratComponent},
        {path:'deleteContrat/:id',component:DeleteContratComponent},
        {path:'allTranches',component:GetAllTranchesComponent},
        {path:'getOneTranche',component:GetOneTrancheComponent},
        {path:'updateTranche/:id',component:UpdateTrancheComponent},
        {path:'addTranche',component:AddTrancheComponent},
        {path:'allRdvs',component:GetAllRdvsComponent},
        {path:'addRdv',component:AddRdvComponent},
        {path:'updateRdv/:id',component:UpdateRdvComponent},
        {path:'getOneRdv/:id',component:GetOneRdvComponent},
        {path:'allDisponibility',component:GetAllDisponibilityComponent},
        {path:'addDisponibility',component:AddDisponibilityComponent},
        {path:'updateDisponibility/:id',component:UpdateDisponibilityComponent},
        {path:'getOneDisponibility/:id',component:GetOneDisponibilityComponent},
        {path:'user-list',component:UserListComponent, canActivate: [AuthGuard]},
        {path:'account-update',component:AccountUpdateComponent, canActivate: [AuthGuard] },
        {path:'session',component:SessionComponent, canActivate: [AuthGuard] }
      ] },
    { path: 'login', component: LoginComponent },
    { path: 'forgot', component: ForgotPasswordComponent },
    { path:'reset-password', component: ResetPasswordComponent },
    { path: 'dashboard', component: DashboardComponent },
    { path: '**', component: PageNotFoundComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AuthGuard]
})
export class AppRoutingModule { }
