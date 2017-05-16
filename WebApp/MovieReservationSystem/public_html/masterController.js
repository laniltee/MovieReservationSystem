/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module("movieApp", []);

app.controller("masterController", function ($scope, $http) {

    $scope.testVal = "Movie System";
    var baseApi = "http://localhost:8080/api/";

    //Scope variables for front end;
    $scope.allMovies = [];
    $scope.allTheatres = [];
    $scope.allSnacks = [];
    $scope.specificMovies = ["Select A Theatre First"];

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

    //Master functions
    $scope.getMoviesByTheatre = function () {
        var selectefTheatre = $scope.theatreIN;
        $http.get(baseApi + "movies/" + selectefTheatre).then(function (response) {
            $scope.specificMovies = response.data;
        });
    };
});


