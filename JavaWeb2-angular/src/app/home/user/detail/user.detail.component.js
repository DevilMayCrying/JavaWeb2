"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
var core_1 = require("@angular/core");
var HttpRequestUrl_1 = require("../../../constant/HttpRequestUrl");
var user_detail_1 = require("../../../models/user/user.detail");
var UserDetailComponent = /** @class */ (function () {
    function UserDetailComponent(router, activatedRoute, httpService, sessionService) {
        this.router = router;
        this.activatedRoute = activatedRoute;
        this.httpService = httpService;
        this.sessionService = sessionService;
        this.userId = activatedRoute.snapshot.queryParams['userId'];
    }
    //初始化
    UserDetailComponent.prototype.ngOnInit = function () {
        this.userDetail = new user_detail_1.UserDetail();
        this.detail(); //详情
    };
    //返回
    UserDetailComponent.prototype.back = function () {
        this.router.navigate(['../list'], { relativeTo: this.activatedRoute });
    };
    //详情
    UserDetailComponent.prototype.detail = function () {
        var _this = this;
        this.httpService.getJsonData(HttpRequestUrl_1.HttpRequestUrl.getPath(HttpRequestUrl_1.HttpRequestUrl.SYS_USER_DETAIL + '/' + this.userId, true), this.sessionService.getHeadToken()).subscribe(function (result) {
            var getResult = result;
            if (getResult.code == 200) {
                var data = getResult.data;
                if (data != null) {
                    _this.userDetail.userName = data.userName;
                    _this.userDetail.personName = data.personName;
                    _this.userDetail.email = data.email;
                    _this.userDetail.phone = data.phone;
                    _this.userDetail.remark = data.remark;
                }
            }
            else {
                _this.router.navigate(['login']);
            }
        }, function (error) {
            _this.router.navigate(['login']);
        });
    };
    UserDetailComponent = __decorate([
        core_1.Component({
            selector: 'user-detail',
            templateUrl: './user.detail.html',
            styleUrls: ['./user.detail.scss']
        })
    ], UserDetailComponent);
    return UserDetailComponent;
}());
exports.UserDetailComponent = UserDetailComponent;
//# sourceMappingURL=user.detail.component.js.map