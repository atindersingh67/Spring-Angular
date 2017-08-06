<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<title>Employee</title>


<!--**********************************External Js******************************** -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<!--**********************************External Js ******************************** -->

<!--**********************************Internal Js ******************************** -->
<script type="text/javascript" src="js/app/app.js"></script>
<script type="text/javascript" src="js/controller/EmployeeController.js"></script>
<script type="text/javascript" src="js/service/employeService.js"></script>
<script type="text/javascript" src="js/directive/common-directive.js"></script>
<!--**********************************Internal Js ******************************** -->


<!--********************************** CSS******************************** -->
 <link rel="stylesheet" href="css/style.css"> 
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!--**********************************  CSS******************************** -->


</head>
<body  ng-app="myApp" ng-controller="EmployeeController as emp">
<confirm-dialogue  del-name="emp.delName"  del-fn="emp.deleteEmployeeConfirm(emp.delId)"></confirm-dialogue>
<loading val="emp.loading"></loading>
		<nav class="navbar navbar-inverse" style="border-radius: 0px;">
		<div class="container">

			<div class="navbar-header"></div>
			<ul class="nav navbar-nav">
				<li><a href="#">Contact Us</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="/logout">Log Out <span
						class="glyphicon glyphicon-off"></span></a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="panel panel-info ">
			<div class="panel-heading">Employee Detail</div>
			<div class="panel-body">
				<form class="form-horizontal" name="empForm" novalidate>
					<div class="form-group" ng-class="{ 'has-error' : empForm.name.$invalid && !empForm.name.$pristine }">
						<label class="col-sm-4 control-label">Name</label>
						<div class="col-sm-5">
							<input type="text"  name="name" class="form-control" placeholder="Name" ng-model="emp.employee.name" required>
							  <p ng-show="empForm.name.$invalid && !empForm.name.$pristine" class="help-block">Name is required.</p>
						</div>
					</div>
					<div class="form-group" ng-class="{ 'has-error' : empForm.email.$invalid && !empForm.email.$pristine }">
						<label class="col-sm-4 control-label">Email</label>
						<div class="col-sm-5">
							<input type="email" class="form-control" name="email" placeholder="Email" ng-model="emp.employee.email">
							  <p ng-show="empForm.email.$invalid && !empForm.email.$pristine" class="help-block">Enter a valid email.</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Address</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" placeholder="Address" ng-model="emp.employee.address">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-5">
							<button type="button" ng-disabled="empForm.$invalid" class="btn btn-info" ng-click="emp.saveEmployee()">Save</button>
							<button type="button" ng-if="emp.employee.id!=''" class="btn btn-info" ng-click="emp.setupData()">Reset</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
		<table class="table table-striped">
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Email</th>
						<th class="hidden-xs">Address</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
					<tr ng-repeat="employe in emp.employees">
						<td >{{$index+1}}</td>
						<td>{{employe.name}}</td>
						<td>{{employe.email}}</td>
						<td class="hidden-xs">{{employe.address}}</td>
						<td><span class="glyphicon glyphicon-edit" aria-hidden="true" ng-click="emp.editEmployee(employe,$index)"></span></td>
						<td><span class="glyphicon glyphicon-trash" aria-hidden="true" ng-click="emp.deleteEmployee(employe,$index)"></span></td>
					</tr>
				
				</table>
<nav class="navbar navbar-inverse  " style="border-radius: 0px;">
		<div class="container">
		<div class="text-center " style="padding-top: 15px;"><small style="color: #9d9d9d">Powered By Atinder</small></div>
		</div>
	</nav>
	
</body>
</html>