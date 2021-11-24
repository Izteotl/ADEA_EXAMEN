import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ResetService } from './reset.service';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css']
})
export class ResetComponent implements OnInit {

  user: String = "";

  form: FormGroup = new FormGroup({
    
  }) ;
  resetInvalid:boolean = false;

  constructor(
    private   fb            : FormBuilder,
    private   router        : Router,
    protected resetService  : ResetService
  ) { }

  ngOnInit() {
    const tokenID = sessionStorage.getItem('tokenID');
    this.user   = sessionStorage.getItem('username');
    if( !tokenID ){
      this.router.navigateByUrl('/login');
    }
    this.form = this.fb.group({
      newPassword : ['',Validators.required],
      confirPassword : ['',Validators.required]
    });
  }

  onSubmit(){
    if( this.form.invalid ){

    }else{
      console.log(this.form.value.newPassword);
      const dataUser =  {
        username: this.user,
        newPassword: btoa(this.form.value.newPassword)
      };

      if(this.form.value.newPassword === this.form.value.confirPassword){
        this.resetService.postReset(dataUser).subscribe( res => {
          console.log('onSubmit() => postLogin() => SUCCESS ');
          console.log( res );
          this.router.navigateByUrl('/home');
        }, err => {
          console.log('onSubmit() => postLogin() => FAIL ');
          console.log( err );
        });
      }else{
        this.resetInvalid = true;
      }
    }
  }

}
