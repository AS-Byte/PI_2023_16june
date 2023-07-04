import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';
import { TokenStorageService } from 'src/app/user/auth-helper/token-storage.service';

@Component({
  selector: 'app-header-back',
  templateUrl: './header-back.component.html',
  styleUrls: ['./header-back.component.css']
})
export class HeaderBackComponent implements OnInit {
  user: any;
  constructor(private router:Router,private userService:UserService,private tokenStorageService:TokenStorageService) { }

  ngOnInit(): void {
    this.getConnectedUser()
  }

  logout() {
    this.tokenStorageService.signOut();
    this.router.navigate(['/login']);

  }

  getConnectedUser()
  {

    this.userService.getCurrentUser(String(sessionStorage.getItem('auth-user'))).subscribe(
      response => {
        this.user=response
        console.log(this.user)
       console.log(response)
      },
      error => {
        console.log(error)
      }
    );
  }
}
