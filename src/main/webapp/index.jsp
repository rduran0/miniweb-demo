<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/styles.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/nvd3/1.8.1/nv.d3.min.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.9/angular.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.6/d3.min.js" charset="utf-8"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/nvd3/1.8.1/nv.d3.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-nvd3/1.0.8/angular-nvd3.min.js"></script>
<!-- Controllers -->
<script src="<%=request.getContextPath() %>/resources/js/mainController.js"></script>
<title>Miniweb - Rule of Law Showcase</title>
</head>
<body ng-app="miniweb" ng-controller="mainController">
<div class="mainContainer">
	<div class="upperControls">
		<h1>Estado de Derecho</h1>
		<div id="countryListContainer">
			<select ng-model="selCountry" ng-change="loadCountry(selCountry.countryCode)"
			ng-options="country.name for country in countries"></select>
			<button ng-click="loadCountry(selCountry.countryCode)">Factores del pais</button>
			<button ng-click="loadCountryRecords(selCountry.countryCode)">{{buttonAction}}</button>
		</div>
	</div>
	<div>
		<p>Evaluacion de factores 2015</p>
		<nvd3 options="options" data="data"></nvd3>
	</div>
	<div class="lowerControls">
		<button ng-click="loadAllScores()">Comparacion de todos los paises</button>
		<nvd3 options="options2" data="data2"></nvd3>
	</div>
</div>
</body>
</html>