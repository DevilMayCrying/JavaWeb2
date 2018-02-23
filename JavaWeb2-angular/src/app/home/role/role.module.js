"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
var core_1 = require("@angular/core");
var common_1 = require("@angular/common");
var router_1 = require("@angular/router");
var role_list_module_1 = require("./list/role.list.module");
var role_component_1 = require("./role.component");
var role_add_module_1 = require("./add/role.add.module");
var role_detail_module_1 = require("./detail/role.detail.module");
var role_modify_module_1 = require("./modify/role.modify.module");
var role_menu_assignment_module_1 = require("./menuAssignment/role.menu.assignment.module");
var RoleModule = /** @class */ (function () {
    function RoleModule() {
    }
    RoleModule = __decorate([
        core_1.NgModule({
            imports: [common_1.CommonModule, router_1.RouterModule, role_list_module_1.RoleListModule, role_add_module_1.RoleAddModule, role_detail_module_1.RoleDetailModule, role_modify_module_1.RoleModifyModule, role_menu_assignment_module_1.RoleMenuAssignmentModule],
            declarations: [role_component_1.RoleComponent],
            exports: [role_component_1.RoleComponent]
        })
    ], RoleModule);
    return RoleModule;
}());
exports.RoleModule = RoleModule;
//# sourceMappingURL=role.module.js.map