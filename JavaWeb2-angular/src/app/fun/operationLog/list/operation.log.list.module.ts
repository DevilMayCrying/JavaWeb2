import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {OperationLogListComponent} from './operation.log.list.component';

@NgModule({
  imports: [CommonModule, RouterModule, FormsModule],
  declarations:[OperationLogListComponent],
  exports:[OperationLogListComponent]
})

export class OperationLogListModule {

}
