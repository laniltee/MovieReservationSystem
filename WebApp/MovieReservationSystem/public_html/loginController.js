
var app = angular.module('loginApp', []);
app.controller('authenticationController', function ($scope, $http, $window) {

    $scope.username = "";
    $scope.password = "";

    $scope.loading = false;

    sessionStorage.removeItem("loggedUser");

    var jsonHeaderObject = {headers: {'Content-Type': 'application/json'}};

    $scope.loggedUser = "";

    var loginServiceUrl = "http://localhost:28009/api/authenticate";

    $scope.validateLogin = function () {

        $scope.loading = true;

        var requestingUser = {
            username: $scope.username,
            password: $scope.password
        };
//        $http.post("/validate_login", requestingUser, jsonHeaderObject).then(function (response) {
//            if (response.data.status === true) {
//                sessionStorage.setItem("loggedUser", response.data.user);
//                $scope.loggedUser = response.data.user;
//                loggedUser = response.data.user;
//                $window.location.href = "/#";
//            } else {
//                if ($scope.password == "123") {
//                    sessionStorage.setItem("loggedUser", $scope.username);
//                    $window.location.href = "/#";
//                } else {
//                    alert("At least try to use the default password :P")
//                }
//            }
//        }, function (response) {
//
//        });
        $http.post(loginServiceUrl, requestingUser, jsonHeaderObject).then(function (response) {
            sessionStorage.setItem("loggedUser", $scope.username);
            $scope.loggedUser = $scope.username;
            loggedUser = $scope.username;
            $window.location.href = "index.html";
            alert("Login Succesful !");
        }, function (response) {
//            if ($scope.password == "123") {
//                sessionStorage.setItem("loggedUser", $scope.username);
//                $window.location.href = "/#";
//            } else {
//                alert("At least try to use the default password :P");
//            }
            alert("Username or password is incorrect !");
        }).finally(function () {
            $scope.loading = false;
        });
    };
});