import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../Services/user.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css'],
})
export class ResetPasswordComponent implements OnInit {
  errorMessage = '';
  errorMessageRegister = '';
  succesMessageRegister = '';
  password!: string;
  confirmPassword!: string;
  token!: string;
  message!: string;
  resetForm: any = {
    password: '',
  };

  errorMessagePassword = '';

  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private spinner: NgxSpinnerService,
    private toastr: ToastrService
  ) {
    this.route.queryParams.subscribe((params) => {
      this.token = params['token'];
    });
  }

  ngOnInit(): void {}

  onSubmit(resetForm: any) {
    this.spinner.show();
    this.userService.resetPassword(this.token, resetForm.password).subscribe(
      (response: any) => {
        this.succesMessageRegister = 'Password reset successfully';
        // Handle successful registration response
        this.spinner.hide();
      },
      (error) => {
        console.log(error);
        if ((error.status = 200)) {
          this.toastr.success('Password reset successfully', 'success !');
          this.spinner.hide();
        } else {
          this.toastr.error(
            'Invalid email / sever problem. Please try again.',
            'Error !'
          );
          // Handle registration error
          this.spinner.hide();
        }
      }
    );
  }
}
