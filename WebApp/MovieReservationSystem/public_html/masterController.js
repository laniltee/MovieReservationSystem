/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module("movieApp", []);

app.controller("masterController", function ($scope, $http) {
    
    if(sessionStorage.getItem("loggedUser") == null){
        alert("Please log in to see this page");
        window.location.href = "login.html";
    }

    var baseApi = "http://localhost:28000/api/";
    var paymentService = "http://localhost:28001/api/";
    var mobilePaymentService = "http://localhost:28003/api/";

    var jsonHeaderObject = {headers: {'Content-Type': 'application/json'}};
    var loggedUser = sessionStorage.getItem("loggedUser");
    var paymentQuote = {};
    var reservationObject = {};

    //Scope variables for front end;
    $scope.allMovies = [];
    $scope.allTheatres = [];
    $scope.allSnacks = [];
    $scope.myReservations = [];
    $scope.specificMovies = ["Select A Theatre First"];
    $scope.mainFormValidated = true;
    $scope.testVal = "Movie System";
    $scope.formSelector = "BASIC";
    $scope.priceRequestOk = false;
    $scope.totalPrice = 0;
    $scope.showPaymentSelector = false;
    $scope.mobilePayment = false;
    $scope.cardPayment = false;
    $scope.showCardProcess = {
        process: false,
        status: "WAIT",
        message: "none"
    };
    $scope.showMobileProcess = {
        process: false,
        status: "WAIT",
        message: "none"
    };


    //Eager loading of stuff
    $http.get(baseApi + "movies").then(function (response) {
        $scope.allMovies = response.data;
    });

    $http.get(baseApi + "theatres").then(function (response) {
        $scope.allTheatres = response.data;
    });

    $http.get(baseApi + "snacks").then(function (response) {
        $scope.allSnacks = response.data;
    });

    $http.get(baseApi + "reservations/" + loggedUser).then(function (response) {
        $scope.myReservations = response.data;
    });

    //Master functions
    $scope.getMoviesByTheatre = function () {
        var selectefTheatre = $scope.theatreIN;
        var comboBox = document.getElementById("theatreSelect");
        selectefTheatre = comboBox.options[comboBox.selectedIndex].value;
        console.log(selectefTheatre);
        $http.get(baseApi + "theatres/movies/" + selectefTheatre).then(function (response) {
            $scope.specificMovies = response.data;
        });
    };

    $scope.mockReservation = function () {

        var newObject = {
            theatre: $scope.theatreIN,
            movie: $scope.movieIN,
            seats: parseInt($scope.seatsIN),
            snack: $scope.snackIN,
            cafe: parseInt($scope.cafeIN),
            user: loggedUser
        };

        if (newObject.theatre == null || newObject.movie == null || newObject.snack == null || isNaN(newObject.seats) || isNaN(newObject.cafe)) {
            $scope.mainFormValidated = false;
        } else {
            reservationObject = newObject;
            $scope.mainFormValidated = true;
        }
        console.log(newObject);

        if ($scope.mainFormValidated) {

            var priceRequest = {
                "theatreCode": newObject.theatre,
                "snackCode": newObject.snack,
                "seats": newObject.seats
            };

            $http.post(baseApi + "price", priceRequest, jsonHeaderObject).then(function (response) {
                console.log(response.data);
                $scope.totalPrice = response.data.total;
                $scope.priceRequestOk = true;
                $scope.showPaymentSelector = true;
                paymentQuote = response.data;
            }, function () {

            });
        }

    };

    $scope.payCard = function () {

        $scope.showCardProcess.message = "Please Wait :)";
        $scope.showCardProcess.process = true;
        $scope.showCardProcess.status = "Processing .. ..";

        var payReq = {
            "creditCardNo": $scope.ccNoIN,
            "cvc": parseInt($scope.cvcNoIN),
            "username": loggedUser,
            "ownername": $scope.holderIN,
            "amount": parseInt(paymentQuote.total)
        };

        console.log(payReq);

        if (payReq.creditCardNo == null || payReq.ownername == null || isNaN(payReq.cvc)) {
            $scope.showCardProcess.message = "There are errors in your input :(";
            $scope.showCardProcess.process = true;
            $scope.showCardProcess.status = "Error .. ..";
        } else {
            $http.post(paymentService + "payment", payReq, jsonHeaderObject).then(function (response) {
                console.log(response.data);
                $scope.showCardProcess.message = response.data.message;
                $scope.showCardProcess.process = true;
                $scope.showCardProcess.status = response.data.status;

                if (response.data.status == true) {
                    $http.post(baseApi + "reservations", JSON.stringify(reservationObject), jsonHeaderObject).then(function (response) {
                        console.log("response success");
                        console.log(response.data);
                    }, function (response) {
                        console.log("response.data failed");
                    }).finally(function () {

                    });
                }


            }, function (response) {
                console.log(response.data);
                $scope.showCardProcess.message = response.data.message;
                $scope.showCardProcess.process = true;
                $scope.showCardProcess.status = response.data.status;
            });
        }


    };

    $scope.payDialog = function () {
        var payReq = {
            "username": loggedUser,
            "pin": parseInt($scope.pinNoIN),
            "mobileNo": $scope.dialogIN,
            "amount": parseInt(paymentQuote.total)
        };
        console.log(payReq);
        console.log(paymentQuote);
        if (payReq.mobileNo == null || isNaN(payReq.pin)) {
            console.log("error input")
        } else {
            $http.post(mobilePaymentService + "payment", payReq, jsonHeaderObject).then(function (response) {
                console.log("mobile payment api call ok");
                console.log(response.data);
                $scope.showMobileProcess.message = response.data.message;
                $scope.showMobileProcess.status = response.data.status;
                $scope.showMobileProcess.process = "DONE";
                if (response.data.status == true) {
                    $http.post(baseApi + "reservations", JSON.stringify(reservationObject), jsonHeaderObject).then(function (response) {
                        console.log("response success");
                        console.log(response.data);
                    }, function (response) {
                        console.log("response.data failed");
                    }).finally(function () {

                    });
                }
            }, function (response) {
                console.log("mobile payment api call failed");
            });
        }

    };
});


