//Global for display
var countryList;
var rawData;
var countryManagementList;
var currentChartData;
var factorsNames;
var BUTTON_ACTION_1 = "Comparacion anual";
var BUTTON_ACTION_2 = "Grafica anterior";
//Angular app (e.g. Controllers)
angular.module("miniweb", ['nvd3'])
.controller("mainController", function($scope, $http) {
	$scope.countries = null;
	var factorGraph = true;

	//Initialize the first char.
	var options1 = {
            chart: {
                type: 'discreteBarChart',
                height: 450,
                x: function(d){return d.label;},
                y: function(d){return d.value;},
                showValues: true,
                valueFormat: function(d){ return d3.format(',.4f')(d); },
                dispatch: {
                  tooltipShow: function(e){ console.log('! tooltip SHOW !')},
                  tooltipHide: function(e){console.log('! tooltip HIDE !')},
                  beforeUpdate: function(e){ console.log('! before UPDATE !')}
                },
                discretebar: {
                  dispatch: {
                    //chartClick: function(e) {console.log("! chart Click !")},
                    elementClick: function(e) {console.log("Clicck!!!")},
                    elementDblClick: function(e) {console.log("! element Double Click !")},
                    elementMouseout: function(e) {console.log("! element Mouseout !")},
                    elementMouseover: function(e) {console.log("! element Mouseover !")}
                  }
                },
                callback: function(e){console.log('! callback !')}
            }
        };

    var options2 = {
            chart: {
                type: 'multiBarChart',
                height: 450,
                margin : {
                    top: 20,
                    right: 20,
                    bottom: 45,
                    left: 45
                },
                clipEdge: true,
                duration: 500,
                stacked: false,
                xAxis: {
                    axisLabel: 'Factores',
                    showMaxMin: false,
                    tickFormat: function(d){
                        return factorsNames[d];//d3.format(',f')(d);
                    }
                },
                yAxis: {
                    axisLabel: 'Puntuajes',
                    axisLabelDistance: -20,
                    tickFormat: function(d){
                        return d3.format(',.1f')(d);
                    }
                }
            }
        };

    var options3 = {
            chart: {
                type: 'multiBarChart',
                height: 450,
                margin : {
                    top: 20,
                    right: 20,
                    bottom: 45,
                    left: 45
                },
                clipEdge: true,
                duration: 500,
                stacked: false,
                xAxis: {
                    axisLabel: 'Puntajes Generales',
                    showMaxMin: false,
                    tickFormat: function(d){
                        return countryList[d].name;//factorsNames[d];//d3.format(',f')(d);
                    }
                },
                yAxis: {
                    axisLabel: 'Puntuaje',
                    axisLabelDistance: -20,
                    tickFormat: function(d){
                        return d3.format(',.1f')(d);
                    }
                }
            }
        };

	//First request for the country list to display
	//TODO might become later a map....might not.....
	$http({
		method: 'GET',
		url: 'http://localhost:8080/miniweb-demo/countries/all'
	}).then(function successCallback(response) {
		
		if(response.status == 200) {
			//woot, our request was heared and answered!!!
			$scope.countries = countryList = response.data;
			$scope.buttonAction = BUTTON_ACTION_1;
			$scope.selCountry = $scope.countries[0];
			$scope.loadCountry($scope.countries[0].countryCode);
		}

	}, function errorCallback(response) {
		//Meh, let everyone know what might happened
		if(response.status == 404) {
			//For some reason the url can not be found. Check tomcar or maven.
			//who knows.....
		}
	});

	//Update methods

	$scope.loadCountry = function(id) {
		console.log(id);
		factorGraph = true;

		$http({
			method: 'GET',
			url: 'http://localhost:8080/miniweb-demo/country/' + id + '/factors'
		}).then(function successCallback(response) {
			$scope.buttonAction = BUTTON_ACTION_1;

			if(response.status == 200) {
				//Good, it was processed
				var arrangedData;
				var factors = response.data.factors;

				factorsNames = new Array();

				for(var i = 0; i < factors.length; i++) {
					factorsNames.push(factors[i].label);
				}

				console.log(factorsNames);

				$scope.options = options1;
				$scope.data = [{
					key: "Something isnt?",
					values: factors
				}];
			}
		}, function errorCallback(response) {
			
			if(response.status == 404) {
				//If for some reason it was not found....then send a console message for
				//developers to notice
			}
		});
	}

	$scope.loadCountryRecords = function(id) {
		console.log(id);

		if(!factorGraph) {
			this.loadCountry(id);
			return;
		}

		$http({
			method: 'GET',
			url: 'http://localhost:8080/miniweb-demo/country/' + id + '/factors/time'
		}).then(function successCallback(response) {
			//Something good happened
			$scope.buttonAction = BUTTON_ACTION_2;
			factorGraph = false;

			if(response.status == 200) {
				//GOOD it was processed again
				var years = response.data.timeFactors;

				var dataAr = new Array();

				for(var i = 0; i < years.length; i++) {
					//
					var values = new Array();
					var factors = years[i].factors;

					console.log(factors);

					for(var j = 0; j < factors.length; j++) {
						//values.push(new Array(j, factors[j].value));
						values.push({"x" : j, "y" : factors[j].value});
					}

					dataAr.push({"key" : years[i].year, "values" : values});
				}

				console.log(dataAr);

				$scope.options = options2;
				$scope.data = dataAr;
			}

		}, function errorCallback(response) {
			//OPPSS!!!!
		});
	}

    $scope.loadAllScores = function() {
    	factorGraph = false;
    	$scope.buttonAction = BUTTON_ACTION_1;

    	$http({
    		method: 'GET',
    		url: 'http://localhost:8080/miniweb-demo/score/all'
    	}).then(function successCallback(response) {
    		//Check the success code
    		if(response.status == 200) {
    			//Correct
    			//Format the scores
    			var countryScores = response.data;
    			var dataAr = new Array();

    			console.log(countryScores);

    			for(var i = 0; i < countryScores[0].scores.length; i++) {
    				var scores = countryScores[i].scores;
    				var values = new Array();

    				for(var j = 0; j < countryScores.length; j++) {
    					values.push({"x" : j, "y" : countryScores[j].scores[i].score});
    				}

    				dataAr.push({"key" : countryScores[0].scores[i].year, "values" : values});
    			}

    			$scope.options = options3;
    			$scope.data = dataAr;
    		}
    	}, function errorCallback(response) {
    		//check what happened.
    	});
    }
});