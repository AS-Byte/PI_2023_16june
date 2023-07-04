import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../Services/user.service';
import { NgxSpinnerService } from 'ngx-spinner';
@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  errorMessage = '';
  errorMessageRegister= '';
  succesMessageRegister=''
  forgetForm: any = {
    email: '',
  };
  constructor(private router:Router,private userService:UserService,private spinner: NgxSpinnerService) { }

  ngOnInit(): void {}
  onSubmit(forgetForm: any) {
    this.spinner.show()
    console.log(forgetForm)
    this.userService.forgotPassword(forgetForm.email).subscribe(
      (response:any) => {
        this.errorMessageRegister = '';
        this.succesMessageRegister = 'reset password message sent . please check you email';
        // Handle successful registration response
        this.spinner.hide()
      },
      (error) => {
        console.log(error)
        console.log(error)
        if(error.status=200){
          this.errorMessageRegister = '';
          this.succesMessageRegister = 'Password reset sent . Please check you email';
          this.spinner.hide()
        }else
        this.errorMessageRegister = 'Invalid email / sever problem. Please try again.';
        this.spinner.hide()
        // Handle registration error
      }
    );
  }
}
