import { Component, OnInit, Inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';

import { UserService } from '../user.service';
import { IUser } from '../iuser';
import { Globals, BaseNewComponent, PickerDialogService, ErrorService } from 'src/app/common/shared';
import { GlobalPermissionService } from 'src/app/core/global-permission.service';

@Component({
  selector: 'app-user-new',
  templateUrl: './user-new.component.html',
  styleUrls: ['./user-new.component.scss'],
})
export class UserNewComponent extends BaseNewComponent<IUser> implements OnInit {
  title: string = 'New User';
  constructor(
    public formBuilder: FormBuilder,
    public router: Router,
    public route: ActivatedRoute,
    public dialog: MatDialog,
    public dialogRef: MatDialogRef<UserNewComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public global: Globals,
    public pickerDialogService: PickerDialogService,
    public userService: UserService,
    public errorService: ErrorService,
    public globalPermissionService: GlobalPermissionService
  ) {
    super(formBuilder, router, route, dialog, dialogRef, data, global, pickerDialogService, userService, errorService);
  }

  ngOnInit() {
    this.entityName = 'User';
    this.setAssociations();
    super.ngOnInit();
    this.setForm();
    this.checkPassedData();
    this.setPickerSearchListener();
  }

  setForm() {
    this.itemForm = this.formBuilder.group({
      emailAddress: ['', Validators.required],
      firstName: ['', Validators.required],
      isActive: [false, Validators.required],
      isEmailConfirmed: [false],
      lastName: ['', Validators.required],
      password: ['', Validators.required],
      phoneNumber: [''],
      userName: ['', Validators.required],
      confirmPassword: ['', Validators.required],
    });

    this.fields = [
      {
        name: 'emailAddress',
        label: 'email Address',
        isRequired: true,
        isAutoGenerated: false,
        type: 'string',
      },
      {
        name: 'firstName',
        label: 'first Name',
        isRequired: true,
        isAutoGenerated: false,
        type: 'string',
      },
      {
        name: 'id',
        label: 'id',
        isRequired: true,
        isAutoGenerated: true,
        type: 'number',
      },
      {
        name: 'isActive',
        label: 'is Active',
        isRequired: true,
        isAutoGenerated: false,
        type: 'boolean',
      },
      {
        name: 'isEmailConfirmed',
        label: 'is Email Confirmed',
        isRequired: false,
        isAutoGenerated: false,
        type: 'boolean',
      },
      {
        name: 'lastName',
        label: 'last Name',
        isRequired: true,
        isAutoGenerated: false,
        type: 'string',
      },
      {
        name: 'password',
        label: 'password',
        isRequired: true,
        isAutoGenerated: false,
        type: 'string',
      },
      {
        name: 'phoneNumber',
        label: 'phone Number',
        isRequired: false,
        isAutoGenerated: false,
        type: 'string',
      },
      {
        name: 'userName',
        label: 'user Name',
        isRequired: true,
        isAutoGenerated: false,
        type: 'string',
      },
    ];
  }

  setAssociations() {
    this.associations = [];
    this.parentAssociations = this.associations.filter((association) => {
      return !association.isParent;
    });
  }

  onSubmit() {
    let user = this.itemForm.getRawValue();
    super.onSubmit(user);
  }
}
