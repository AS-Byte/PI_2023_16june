import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../Services/user.service';
import { TokenStorageService } from '../auth-helper/token-storage.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-account-update',
  templateUrl: './account-update.component.html',
  styleUrls: ['./account-update.component.css'],
})
export class AccountUpdateComponent implements OnInit {
  user: any;
  selectedImage!: File;
  successMessage = '';
  errorMessage = '';
  constructor(
    private router: Router,
    private userService: UserService,
    private tokenStorage: TokenStorageService,private spinner: NgxSpinnerService,private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.getConnectedUser();
  }

  getConnectedUser() {
    this.spinner.show()
    this.userService
      .getCurrentUser(String(sessionStorage.getItem('auth-user')))
      .subscribe(
        (response) => {
          this.user = response;
          this.spinner.hide()
        },
        (error) => {
          console.log(error);
          this.spinner.hide()
        }
      );
  }

  updateConnectedUser() {
    const formData = new FormData();
    formData.append('firstname', this.user.firstname);
    formData.append('lastname', this.user.lastname);
    formData.append('email', this.user.email);
    formData.append('image', this.selectedImage);
    formData.append('address', this.user.address);
    formData.append('profession', this.user.profession);
    formData.append('num', this.user.num);
    formData.append('birthdate', this.user.birthdate);

    this.userService.updateCurrentUser(formData).subscribe(
      (response) => {
        this.errorMessage = 'user updated successfuly';
        this.toastr.success('Update account!', 'success !');
        this.getConnectedUser()
        this.spinner.hide()
      },
      (error) => {
        if(error.status=='200')
        {
          this.toastr.success('Update account!', 'success !');
        }else
        this.toastr.error('Update account!', 'error !');
      }
    );
  }
  onImageChange(event: any) {
    this.selectedImage = event.target.files[0];
  }
}
