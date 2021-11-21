import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
 
  loginInvalid:boolean = false;
  form: FormGroup = new FormGroup({
    
  }) ;

  constructor(
    private   fb            : FormBuilder,
    private   router        : Router,
    protected loginService  : LoginService
  ) { }

  ngOnInit() {
    this.form = this.fb.group({
      username : ['',Validators.required],
      password : ['',Validators.required]
    });
  }

  onSubmit(){
    if( this.form.invalid ){

    }else{
      const dataUser =  {
        username: this.form.value.username,
        password: btoa(this.form.value.password)
      };
      console.log(dataUser);
      this.loginService.postLogin(dataUser).subscribe( res => {
        console.log('onSubmit() => postLogin() => SUCCESS ');
        console.log( res );
        sessionStorage.setItem("tokenID",res.jwt);
        sessionStorage.setItem("username",this.form.value.username);
        let reset = res.userExpired;
        console.log(reset);
        if(reset){
          this.router.navigateByUrl('/reset');
        }else{
          this.router.navigateByUrl('/home');
        }
      }, err => {
        console.log('onSubmit() => postLogin() => FAIL ');
        console.log( err );
      });
    }
  }


}
