<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
      <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
     <meta http-equiv="Pragma" content="no-cache"/>
     <meta http-equiv="Expires" content="0"/>
  <title> Admin Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <title>Restaurant Guide</title>
	<style>
	body {
    background-color: #eeeeee;
    font-family: 'Segoe UI';
    padding-top: 20px;
    font-size: 15px;
    margin: auto;
    width: 960px;
}

#mapregion {
    height: 500px;
    width: 500px;
    position: relative;
    margin: auto;
    border: 1px solid black;
    display: none;
}

#distance-details {
    margin: auto;
    text-align: center;
    padding: 5px;
    background-color: #147efb;
    color: white;
    display: none;
}
	</style>
	
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
    <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript" src="http://oauth.googlecode.com/svn/code/javascript/oauth.js"></script>
    <script type="text/javascript" src="http://oauth.googlecode.com/svn/code/javascript/sha1.js"></script>
    <script type="text/javascript">
	
	
// User's Location
var userLat, userLon;


/*
    Called when the page is loaded
*/
$(document).ready(function () {

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(getLocation, displayError);
    } else {
        $("#mapregion").html("<br>Location is not supported on this browser");
    }
});


// Invoked in case of error in getting location
function displayError(error) {
    var $displayRegion = $("#mapregion");
    switch (error.code) {
        case error.PERMISSION_DENIED:
            $displayRegion.html("<br>User denied request for Location");
            break;
        case error.POSITION_UNAVAILABLE:
            $displayRegion.html("<br>Location information unavailable");
            break;
        case error.TIMEOUT:
            $displayRegion.html("<br>Request to get Location timed out");
            break;
        case error.UNKNOWN_ERROR:
            $displayRegion.html("<br>Unknown error");
            break;
        default:
            break;
    }
}


/*
 * Gets the current location
 */
function getLocation(location) {
    userLat = location.coords.latitude;
    userLon = location.coords.longitude;

    // Puts map on the page
    putMapOnPage();
}


/*
 * Creates a region for Map and displays the direction from current location
 * to the business
 */
function putMapOnPage() {

    // Google Directions service objects
    var directionsDisplay = new google.maps.DirectionsRenderer();
    var directionsService = new google.maps.DirectionsService();


    // The region on the page that will be populated with the map
    var $mapRegion = $("#mapregion");

    // Location of the business
    var businessLat = 42.388861;
    var businessLon = -71.106423;

    // Create LatLon object for business location
    var businessLatLon = new google.maps.LatLng(businessLat, businessLon);

    // Create LatLon object for user's current location
    var userLatLon = new google.maps.LatLng(userLat, userLon);


    // Options for Google Map
    var mapOptions = {
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        mapTypeControl: false,
        navigationControlOptions: { style: google.maps.NavigationControlStyle.SMALL },
        center: businessLatLon,
        zoom: 14
    }

    // Map object that will be used to display the map
    var map = new google.maps.Map($mapRegion[0], mapOptions);

    directionsDisplay.setMap(map);

    // Using directions for WALKING
    var request = {
        origin: userLatLon, // From user's locatiopn
        destination: businessLatLon, // To business location
        travelMode: google.maps.TravelMode.WALKING // Walking directions
    };

    // Requests the route from origin to destination
    directionsService.route(request, function (response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
            var dist = response.routes[0].legs[0].distance.text;
            var duration = response.routes[0].legs[0].duration.text;
            var html = "<p>Distance from current location: <b>" + dist + "</b></p>";
            $("#distance-details").append($(html));
        }
    });

    // Unhide the map on the page
    $mapRegion.css("display", "block");

    // Unhide the distance details on map
    $("#distance-details").css("display", "block");
	}



	
	
	</script>
</head>
<body>
<div class="container" >
<%@ include file="HomeHeader.jsp" %>
	<h2 style="padding-top:15px;"><center>Map to reach restaurant</center></h2>
    <div id="mapregion"></div>
    <br />
    <div id="distance-details"></div>
    
    </div>
</body>
</html>

