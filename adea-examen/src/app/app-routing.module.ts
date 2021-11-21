import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { ResetComponent } from './components/reset/reset.component';
import { HomeComponent } from './components/home/home.component';


const routes: Routes = [
  { path:'login' , component : LoginComponent, pathMatch: 'full'},
  { path:'reset' , component : ResetComponent, pathMatch: 'full'},
  { path:'home'  , component : HomeComponent , pathMatch: 'full'},
  { path: '', redirectTo: 'login', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
