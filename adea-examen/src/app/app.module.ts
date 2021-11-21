import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

//FORMULARIOS REACTIVOS
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

//ANGULAR module
import { MaterializeModule } from './shared/materialize.module';

//PETICIONES HTTP
import {HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { LoginComponent } from './components/login/login.component';
import { ResetComponent } from './components/reset/reset.component';
import { HomeComponent } from './components/home/home.component';
import { ErrorViewComponent } from './shared/error-view/error-view.component';

import { ErrorDialogService } from './core/service/error-dialog.service';
import { InterceptorService } from './core/service/interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ResetComponent,
    HomeComponent,
    ErrorViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MaterializeModule
  ],
  providers:[
    {
      provide: HTTP_INTERCEPTORS,
      useClass: InterceptorService,
      multi:true
    },
    ErrorDialogService
  ],
  bootstrap: [AppComponent],
  entryComponents:[
    ErrorViewComponent
  ]
})
export class AppModule { }
