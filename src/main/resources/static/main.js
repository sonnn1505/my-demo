var app = angular.module("BranchManagement", []);
 
// Controller Part
app.controller("BranchController", function($scope, $http) {
 
 
    $scope.branchs = [];
    $scope.branchForm = {
        id: 1,
        maKhuVuc: "",
        tenKhuVuc: "",
        maChiNhanh:"",
        tenChiNhanh:"",
        maPhongGD:"",
        tenPhongGD:"",
        diaChi:"",
        maSoThue:"",
        soDKKD:"",
        ngayCap:"",
        noiCap:"",
        soDienThoai:"",
        soFax:"",
        tinhThanh:"",
    };
 
    // Now load the data from server
    _refreshBranchData();
    // Private Method  
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/branch
    function _refreshBranchData() {
        $http({
            method: 'GET',
            url: '/branchLimit/0&10'
        }).then(
            function(res) { // success
                $scope.branchs = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
});// End Controller Part