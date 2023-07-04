import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../Services/user.service';
import { LoginModel } from '../../Models/user/LoginModel';
import { RegisterModel } from '../../Models/user/RegisterModel';
import { TokenStorageService } from '../auth-helper/token-storage.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  selectedImage!: File;

  loginForm: LoginModel = {
    email: '',
    password: '',
  };

  registerForm: RegisterModel = {
    firstname: '',
    lastname: '',
    email: '',
    password: '',
    role: 'ADMIN',
  };

  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  errorMessageRegister = '';
  succesMessageRegister = '';
  roles: any;
  isAdmin: any;

  constructor(
    private router: Router,
    private userService: UserService,
    private tokenStorage: TokenStorageService,
    private spinner: NgxSpinnerService,private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }
  register(request: RegisterModel): void {
    this.spinner.show();
    const formValue = request;
    const formData = new FormData();
    formData.append('firstname', formValue.firstname);
    formData.append('lastname', formValue.lastname);
    formData.append('email', formValue.email);
    formData.append('password', formValue.password);
    formData.append('role', formValue.role);
    formData.append('image', this.selectedImage);
    console.log('request', request);

    this.userService.register(formData).subscribe(
      (response: any) => {
        console.log(response);

        this.toastr.success('Account created . please check you email!', 'success !');
        // Handle successful registration response
        this.spinner.hide();
      },
      (error) => {
        // Handle authentication error
        if ((error.status = 200)) {
          this.toastr.success('Account created . please check you email!', 'success !');
          this.spinner.hide();
        } else
        {this.spinner.hide();
          this.toastr.error('Account not created . please check you credential!', 'Error !');

      }
        // Handle registration error
      }
    );
  }
  authenticate(request: LoginModel): void {
    this.spinner.show();
    this.userService.authenticate(request).subscribe(
      (response: any) => {
        console.log(response);
        this.tokenStorage.saveToken(response.access_token);
        this.tokenStorage.saveUser(response.auth_user);
        this.tokenStorage.saveUserRole(response.auth_user_role);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.toastr.success('valid credentials. Please try again.', 'Success !');
        //     this.roles = this.tokenStorage.getUser().roles;
        this.redirectLogin();
        // Handle successful authentication response
      },
      (error) => {
          this.toastr.error('Invalid credentials. Please try again.', 'Error !');
      }
    );
    this.spinner.hide();
  }
  redirectLogin() {
    this.isAdmin = this.tokenStorage.isAdmin();
    if (this.isAdmin) {
      this.router.navigate(['/admin']);
    } else this.router.navigate(['/']);
  }
  onImageChange(event: any) {
    this.selectedImage = event.target.files[0];
  }
}
