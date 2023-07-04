import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/user/auth-helper/token-storage.service';

@Component({
  selector: 'app-side-bar-back',
  templateUrl: './side-bar-back.component.html',
  styleUrls: ['./side-bar-back.component.css']
})
export class SideBarBackComponent implements OnInit {
  isAdmin: boolean;

  constructor(private tokenStorageService: TokenStorageService) {
    this.isAdmin = tokenStorageService.isAdmin();
  }

  ngOnInit(): void {
  }

}
