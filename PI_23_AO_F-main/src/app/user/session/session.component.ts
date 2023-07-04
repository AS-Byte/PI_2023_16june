import { Component, OnInit } from '@angular/core';
import { UserService } from '../../Services/user.service';
import { DatePipe } from '@angular/common';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrls: ['./session.component.css'],
})
export class SessionComponent implements OnInit {
  view: [number, number] = [600, 300];

  colorScheme = 'cool';
  showXAxis = true;
  showYAxis = true;
  showLegend = false;
  showXAxisLabel = true;
  showYAxisLabel = true;
  xAxisLabel = 'Token status';
  yAxisLabel = 'Count';

  sessionList: any;
  chartData: any[] | undefined;
  chartData2: any[] | undefined;
  gradient: boolean = true;

  showLabels: boolean = true;
  isDoughnut: boolean = false;

  settings = {
    actions: { add: true, edit: true, delete: true, position: 'right' },
    columns: {
      userEmail: {
        title: 'user_email ',
      },
      token: {
        title: 'token',
        editable: false,
        addable: false,
        valuePrepareFunction: (cell: string) => {
          // Trim the token to 10 characters
          return cell.length > 20 ? cell.substring(80, 100) + '...' : cell;
        },
      },
      revoked: {
        title: 'revoked ',
      },
      expired: {
        title: 'expired ',
      },
      issueAt: {
        title: 'issue date ',
        valuePrepareFunction: (date: string | number | Date) => {
          return this.datePipe.transform(date, 'yyyy-MM-dd HH:mm:ss');
        },
      },
      expiration: {
        title: 'expiration date ',
        valuePrepareFunction: (date: string | number | Date) => {
          return this.datePipe.transform(date, 'yyyy-MM-dd HH:mm:ss');
        },
      },
      userId: {
        title: 'user_id ',
      },
    },
    delete: {
      confirmDelete: true,
      deleteButtonContent: ' <i class="nb-plus icon-ng2-table">Delete </i>', // Updated delete button content
      cancelButtonContent: '<i class="nb-plus icon-ng2-table">Delete </i>',
    },

    edit: {
      confirmSave: true,
      editButtonContent: '<i class="nb-edit icon-ng2-table"   ></i>',
      saveButtonContent: '<i class="nb-checkmark icon-ng2-table" ></i>',
      cancelButtonContent: '<i class="nb-close icon-ng2-table"></i>',
    },
    add: {
      confirmCreate: true,
      addButtonContent: '<i class="nb-plus icon-ng2-table"></i>',
      createButtonContent: '<i class="nb-checkmark icon-ng2-table"></i>',
      cancelButtonContent: '<i class="nb-close icon-ng2-table" ></i>',
    },
    pager: {
      display: true,
      perPage: 10,
    },
  };
  data: any;
  constructor(
    private userService: UserService,
    private datePipe: DatePipe,
    private spinner: NgxSpinnerService
  ) {}

  ngOnInit(): void {
    this.spinner.show();
    this.findAllSession();
    this.dataTracking();
  }
  findAllSession(): void {
    this.userService.sessionList().subscribe(
      (response: any) => {
        console.log(response);
        this.sessionList = response;
        setTimeout(() => {
          /** spinner ends after 5 seconds */
          this.spinner.hide();
        }, 1000);
        // Handle successful registration response
      },
      () => {
        // Handle registration error
      }
    );
  }

  deleteToken(event: any) {
    console.log(event, 'event');
    this.userService.deleteToken(event.data.id).subscribe(
      (response: any) => {
        console.log(response);
        this.ngOnInit();
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

        this.chartData = [
          {
            name: 'admin',
            value: this.data['user_role_admin'],
          },
          {
            name: 'client',
            value: this.data['user_role_client'],
          },
          {
            name: 'visitor',
            value: 0,
          },
        ];

        this.chartData2 = [
          { name: 'Total token', value: this.data['token_number'] },
          { name: 'Expired token', value: this.data['revoked_token'] },
          { name: 'Revoke token', value: this.data['expired_token'] },
        ];
      },
      () => {
        // Handle registration error
      }
    );
  }
}
