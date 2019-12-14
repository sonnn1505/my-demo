var app = angular.module("BranchManagement", ['ngRoute', 'ui.grid', 'ui.grid.edit', 'ui.grid.pagination', 'ui.grid.autoResize', 'ui.grid.expandable', 'ui.grid.selection', 'ui.grid.pinning', 'ui.bootstrap']);
 
// Controller Part
app.controller("BranchController", function($scope, $filter, $window, $http, $log, $interval, $uibModal) {
	init();
	function init() {    
        //Pagination varibles      
        var paginationOptions = {    
            pageNumber: 1,    
            pageSize: 10,    
            sort: {    
                columnName: 'id',    
                isAscending: false,    
            }    
        };    
        $scope.currentPage = 1;    
        $scope.pageSize = paginationOptions.pageSize;    
        //end here      
        $scope.loadData = function() {
        	//api
            //employeeService.getEmployeeWithPaging(paginationOptions.pageNumber, paginationOptions.pageSize, null, paginationOptions.sort)
            
             // data
		    $http({
		        method: 'GET',
		        url: '/branch',
		        { params: { PageNumber:PageNumber,  
		        	PageSize:PageSize
		        	//OrderBy:OrderBy,  
		        	//SortDirection:SortDirection
		        }}
		    }).then(function(result) {    
                $scope.gridOptions.totalItems = result.data[0].TotalCount;    
                $scope.totalPage = Math.ceil($scope.gridOptions.totalItems / $scope.pageSize);    
                $scope.gridOptions.data = result.data;    
                console.log($scope.Employees);    
            }, function(error) {    
                $window.alert('Oops! Something went wrong while fetching employee data.');    
            });    
        };    
        $scope.loadData();    
        $scope.gridOptions = {    
            enableRowSelection: true,    
            selectionRowHeaderWidth: 35,    
            enableRowHeaderSelection: false,    
            //Added for custom paging      
            paginationPageSizes: [$scope.pageSize, $scope.pageSize * 2, $scope.pageSize * 3],    
            paginationPageSize: paginationOptions.pageSize,    
            useExternalPagination: true, // custom      
            useExternalSorting: true, // custom      
            useExternalFiltering: true, // custom      
            enableSorting: true,    
            columnDefs: [{    
                name: 'Edit',    
                field: 'id',    
                width: '10%',    
                enableColumnMenu: false,    
                cellTemplate: '<button title="Edit" class="btn btn-xs btn-primary fa fa-edit" ng-click="grid.appScope.editEmployee(row)">Edit </button>',    
                width: 50,    
                pinnedLeft: false,    
                enableHiding: false,    
                exporterSuppressExport: true,    
                enableSorting: false,    
                enableFiltering: false    
            }, {    
                name: 'Mã khu vực',    
                field: 'maKhuVuc',    
                headerCellClass: 'tablesorter-header-inner',    
                enableFiltering: true,    
                enableCellEdit: true,    
            }, {    
                name: 'Tên khu vực',    
                field: 'tenKhuVuc',    
                headerCellClass: 'tablesorter-header-inner',    
                enableFiltering: true,    
                enableCellEdit: true,    
            }, {    
                name: 'Mã Chi nhánh',    
                field: 'maChiNhanh',    
                headerCellClass: 'tablesorter-header-inner',    
                enableFiltering: true,    
                enableCellEdit: true,    
            }, {    
                name: 'Tên chi nhánh',    
                field: 'tenChiNhanh',    
                enableCellEdit: false,    
                headerCellClass: 'tablesorter-header-inner',    
                enableFiltering: true    
            }, {    
                name: 'Mã phòng GD',    
                field: 'maPhongGD',    
                enableCellEdit: false,    
                headerCellClass: 'tablesorter-header-inner',    
                enableFiltering: true    
            }, {    
                name: 'Tên Phòng GD',    
                field: 'tenPhongGD',    
                enableCellEdit: false,    
                headerCellClass: 'tablesorter-header-inner',    
                enableFiltering: true    
            }, {    
                name: 'Địa chỉ',    
                field: 'diaChi',    
                width: '20%',    
                enableCellEdit: false,    
                headerCellClass: 'tablesorter-header-inner',    
                enableFiltering: true    
            }],    
            //This code used for export grid data in csv file      
            enableGridMenu: true,    
            enableSelectAll: true,    
            exporterMenuPdf: false,    
            enableFiltering: true,    
            exporterCsvFilename: 'EmployeeList_' + $filter('date')(new Date(), 'MM/dd/yyyy') + '.csv',    
            exporterCsvLinkElement: angular.element(document.querySelectorAll(".custom-csv-link-location")),    
            onRegisterApi: function(gridApi) {    
                $scope.gridApi = gridApi;    
                gridApi.selection.on.rowSelectionChanged($scope, function(row) {    
                    var msg = 'row selected ' + row.isSelected;    
                    $log.log(msg);    
                    console.log(msg);    
                    //$window.alert(msg);      
                });    
                gridApi.selection.on.rowSelectionChangedBatch($scope, function(rows) {    
                    var msg = 'rows changed ' + rows.length;    
                    $log.log(msg);    
                    // $window.alert(msg);      
                    console.log(msg);    
                });    
                //Added for custom paging      
                gridApi.pagination.on.paginationChanged($scope, function(newPage, pageSize) {    
                    paginationOptions.pageNumber = newPage;    
                    paginationOptions.pageSize = pageSize;    
                    $scope.pageSize = pageSize;    
                    $scope.currentPage = newPage;    
                    $scope.totalPage = Math.ceil($scope.gridOptions.totalItems / $scope.pageSize);    
                    $scope.loadData();    
                });    
                //custom sort      
                $scope.gridApi.core.on.sortChanged($scope, function(grid, sortColumns) {    
                    if (sortColumns.length == 0) {    
                        paginationOptions.sort = null;    
                    } else {    
                        paginationOptions.sort = sortColumns[0].sort.direction;    
                    }    
                    $scope.loadData();    
                });    
            },    
            //end here      
            //data for grid      
            // data: 'employees'      
        };    
    }// end function init
	
	
	
}

//this example uses Angular 1. cellTemplates doesn't make sense with any other framework
agGrid.initialiseAgGridWithAngular1(angular);
var module = angular.module('example', ['agGrid']);

module.controller('exampleCtrl', function($scope, $http) {

    var columnDefs = [
       /* {headerName: 'Useless', width: 100, template: '<span style="font-weight: bold;">BLAH</span>'},
        {headerName: 'Athlete', width: 150, template: '<span style="font-weight: bold;" ng-bind="data.athlete"></span>'},
        {headerName: 'Age', width: 90, template: '<span style="font-weight: bold;" ng-bind="data.age"></span>'},
        {headerName: 'Country', field: 'country', width: 120},
        {headerName: 'Year', field: 'year', width: 90},
        {headerName: 'Date', field: 'date', width: 110},
        {headerName: 'Sport', field: 'sport', width: 110},
        {headerName: 'Gold', field: 'gold', width: 100},
        {headerName: 'Silver', field: 'silver', width: 100},
        {headerName: 'Bronze', field: 'bronze', width: 100},
        {headerName: 'Total', field: 'total', width: 100}*/
    	{headerName: 'Mã khu vực', field: 'maKhuVuc', width: 110},
        {headerName: 'Tên Khu vực', field: 'tenKhuVuc', width: 100},
        {headerName: 'Địa chỉ', field: 'diaChi', width: 100},
    ];

    $scope.gridOptions = {
        // we are using angular in the templates
        angularCompileRows: true,
        columnDefs: columnDefs,
        rowData: null
    };
    // data
    $http({
        method: 'GET',
        url: '/branch'
    }).then(
        function(res) { // success
        	$scope.gridOptions.api.setRowData(res.data);
        },
        function(res) { // error
            console.log("Error: " + res.status + " : " + res.data);
        }
    );
    
    //
});

