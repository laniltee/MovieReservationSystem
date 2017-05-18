/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module("movieApp", []);

app.controller("masterController", function ($scope, $http) {

    var baseApi = "http://localhost:8080/api/";
    var jsonHeaderObject = {headers: {'Content-Type': 'application/json'}};
    var loggedUser = "ajith";

    //Scope variables for front end;
    $scope.allMovies = [];
    $scope.allTheatres = [];
    $scope.allSnacks = [];
    $scope.myReservations = []
    $scope.specificMovies = ["Select A Theatre First"];
    $scope.mainFormValidated = true;
    $scope.testVal = "Movie System";
    $scope.formSelector = "BASIC";

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
            $scope.mainFormValidated = true;
        }
        console.log(newObject);

        if ($scope.mainFormValidated) {
            $http.post(baseApi + "reservations", JSON.stringify(newObject), jsonHeaderObject).then(function (response) {
                console.log("response success");
                console.log(response.data);
            }, function (response) {
                console.log("response.data failed");
            }).finally(function () {

            });
        }

    };
});


