import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
})
export class UserListComponent implements OnInit {
  public imageSrc!: string;
  userList: any;

  settings = {
    actions: { add: false, edit: true, delete: true, position: 'right' },
    columns: {
      image: {
        title: 'image',
        editable: false,
        addable: false,
        filter: false,
        type: 'html',
        valuePrepareFunction: (picture: string) => {
          return `<img width="100px" src="data:image/jpeg;base64,${picture}" />`;
        },
      },
      firstname: {
        title: 'firstname',
      },
      lastname: {
        title: 'lastname ',
      },
      email: {
        title: 'email ',
        editable: false,
      },
   
      role: {
        title: 'role ',
        editable: true,
        addable: true,
        editor: {
          type: 'list',
          config: {
            selectText: 'ADMIN',
            list: [
              { value: 'ADMIN', title: 'ADMIN' },
              { value: 'CLIENT', title: 'CLIENT' },
            ],
          },
        },
      },
    },
    delete: {
      confirmDelete: true,
      deleteButtonContent:
        ' <i class="nb-plus icon-ng2-table">Revoke Token</i>', // Updated delete button content
      cancelButtonContent: '<i class="nb-plus icon-ng2-table">Revoke Token</i>',
    },

    edit: {
      confirmSave: true,
      editButtonContent:
        '<i class="nb-edit icon-ng2-table"   > Update User </i>',
      saveButtonContent: '<i class="nb-checkmark icon-ng2-table" >Save  </i>',
      cancelButtonContent: '<i class="nb-close icon-ng2-table">Cancel </i>',
    },
    add: {
      confirmCreate: true,
      addButtonContent: '<i class="nb-plus icon-ng2-table"></i>',
      createButtonContent: '<i class="nb-checkmark icon-ng2-table"></i>',
      cancelButtonContent: '<i class="nb-close icon-ng2-table" ></i>',
    },
  };
  data: any;

  constructor(
    private userService: UserService,
    private spinner: NgxSpinnerService,private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.spinner.show();
    this.findAllUsers();
    this.dataTracking();
  }

  arrayBufferToBase64(buffer: ArrayBuffer) {
    const uintArray = new Uint8Array(buffer);
    const numberArray = Array.from(uintArray);
    const binary = String.fromCharCode.apply(null, numberArray);
    return btoa(binary);
  }

  findAllUsers(): void {
    this.userService.userList().subscribe(
      (response: any) => {
        console.log(response);
        this.userList = response;
        setTimeout(() => {
          /** spinner ends after 5 seconds */
          this.spinner.hide();
        }, 1000);
        this.imageSrc = 'data:image/jpeg;base64,' + response[0].image;
        console.log('image is ', this.imageSrc);
        // Handle successful registration response
      },
      () => {
        // Handle registration error
      }
    );
  }

  dataTracking(): void {
    this.userService.dataTracking().subscribe(
      (response: any) => {
        console.log(response);
        this.data = response;
      },
      () => {
        // Handle registration error
      }
    );
  }

  onDeleteConfirm(event: { action: any; data: any }) {
    console.log('event :', event);
    const formData = new FormData();
    formData.append('id', event.data.id);
    console.log('id is : ', event.data.id);
    this.userService.userRestrict(event.data.id).subscribe(
      (response: any) => {
        console.log(response);

        // Handle successful registration response
      },
      () => {
        // Handle registration error
      }
    );
  }

  updateUser(event: any) {
    console.log(event);
    const formData = new FormData();
    formData.append('email', event.newData.email);
    formData.append('firstname', event.newData.firstname);
    formData.append('lastname', event.newData.lastname);
    formData.append('role', event.newData.role);
    this.userService.updateCurrentUser(formData).subscribe(
      (response) => {
         this.toastr.success('Update account!', 'success !');
        event.confirm.resolve(event.source.data);
        console.log(response);
        this.ngOnInit();
      },
      (error) => {
        this.ngOnInit();
        event.confirm.resolve(event.source.data);
      }
    );
  }
}
