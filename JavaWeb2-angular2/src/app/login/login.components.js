"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var login_user_1 = require("../models/login/login.user");
var LoginComponent = (function () {
    function LoginComponent(router) {
        this.router = router;
        /*------ 语言切换 start ------*/
        //初始化默认语言
        this.defaultLangue = { display: '中文', value: 'CN' };
        //defaultLangue = {display:'请选择',value:'-1'};//默认空或请选择个人推荐这种写法
        //语言列表显示
        this.langues = [
            //{display:'请选择',value:'-1'},//默认空或请选择个人推荐这种写法
            { display: '中文', value: 'CN' },
            { display: '英文', value: 'EN' }
        ];
        /*------ 语言切换 end ------*/
        /*------ 用户登录 start ------*/
        //用到[()]双向绑定需要初始化
        this.user = new login_user_1.LoginUser();
    }
    LoginComponent.prototype.ngOnInit = function () { };
    //语言选择事件
    LoginComponent.prototype.langueChange = function (langueChoseEvent) {
        var languesArray = this.langues;
        for (var i in languesArray) {
            var each = languesArray[i];
            if (each.value == langueChoseEvent) {
                console.log("你选择的语言为：" + each.display);
                break;
            }
        }
    };
    LoginComponent.prototype.login = function () {
        console.log(this.user);
        this.router.navigate(['home'] /*,{queryParams:{'myKey':100}}*/); //<a [routerLink]="['home']" [queryParams]="{'myKey':100}" >Home</a>
    };
    return LoginComponent;
}());
LoginComponent = __decorate([
    core_1.Component({
        selector: 'web-app',
        templateUrl: 'app/login/login.html',
        styleUrls: ['app/login/login.css']
    })
], LoginComponent);
exports.LoginComponent = LoginComponent;
//# sourceMappingURL=login.components.js.map