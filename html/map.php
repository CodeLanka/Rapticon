<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Map</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <script src="http://maps.googleapis.com/maps/api/js"></script>
  <style>
      #bookShop, #proceed{
      background-color: #111;
      border: 2px solid #fff;
      border-radius: 3px;
      box-shadow: 0 2px 6px rgba(0,0,0,.3);
      cursor: pointer;
      float: left;
      margin-bottom: 22px;
      text-align: center;
      height:35px;
      width:150px;
      
    }
    #bookShopText, #proceedText{
      color: rgb(255,255,255);
      font-family: Roboto,Arial,sans-serif;
      font-size: 18px;
      line-height: 25px;
      padding-left: 5px;
      padding-right: 5px;
    }
    
    #proceed {
      margin-left: 50px;
    }
  </style>
  <script>
  var check;
  var map;
  var markers = [];
  var gLocation; //geo location of the customer
  var labels ='Taxi';
  var marker1;
  var marker2;
  var directionsDisplay;
  function CenterControl(controlDiv, map, center) {
    // We set up a variable for this since we're adding event listeners later.
    var control = this;

    // Set the center property upon construction
    control.center_ = center;
    controlDiv.style.clear = 'both';

    // Set CSS for the control border
    var bookShop = document.createElement('div');
    bookShop.id = 'bookShop';
    bookShop.title = 'Click to book a Taxi';
    controlDiv.appendChild(bookShop);

    // Set CSS for the control interior
    var bookShopText = document.createElement('div');
    bookShopText.id = 'bookShopText';
    bookShopText.innerHTML = 'Find Nearest';
    bookShop.appendChild(bookShopText);

    // Set CSS for the setCenter control border
    var proceed = document.createElement('div');
    proceed.id = 'proceed';
    proceed.title = 'Click to see driver bids';
    controlDiv.appendChild(proceed);

    // Set CSS for the control interior
    var proceedText = document.createElement('div');
    proceedText.id = 'proceedText';
    proceedText.innerHTML = 'Proceed';
    proceed.appendChild(proceedText);

    // Set up the click event listener for 'Center Map': Set the center of the map
    // to the current center of the control.
    bookShop.addEventListener('click', function() {
    calcRoute(marker1.getPosition().lat(),marker1.getPosition().lng(),marker2.getPosition().lat(),marker2.getPosition().lng());
    if(check=="true"){
        window.location.assign('hireInfo.php?startLat='+marker1.getPosition().lat()+'&startLong='+marker1.getPosition().lng()+'&endLat='+marker2.getPosition().lat()+'&endLong='+marker2.getPosition().lng()+'&distanceKm='+distanceKm+'&distanceM='+distanceM+'&durationHrs='+durationHrs+'&durationMins='+durationMins);
    }
    else{
      alert("Please select markers properly!!!");
    }
  });

  // Set up the click event listener for 'Set Center': Set the center of the
  // control to the current center of the map.
  proceed.addEventListener('click', function() {
    window.location.assign('seeBids.php');
  });
}
  function initialize() {
  directionsDisplay = new google.maps.DirectionsRenderer({
    polylineOptions: {
      strokeColor: "purple"
    },
    preserveViewport: true
  });
    directionsDisplay.setMap(map);
    var mapProp = {
    center:new google.maps.LatLng(6.933279, 79.849905),
    zoom:10,
    mapTypeId:google.maps.MapTypeId.ROADMAP
    };
    map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
    var centerControlDiv = document.createElement('div');
    var centerControl = new CenterControl(centerControlDiv, map, new google.maps.LatLng(6.933279, 79.849905));
    centerControlDiv.index = 10;
    centerControlDiv.style['padding-top'] = '10px';
    map.controls[google.maps.ControlPosition.TOP_CENTER].push(centerControlDiv);
    marker1 = new google.maps.Marker({
      position: new google.maps.LatLng(6.913279, 79.899905),
      map: map,
      draggable: false
      });
    marker2 = new google.maps.Marker({
      position: new google.maps.LatLng(6.935279, 80.245905),
      map: map,
      draggable: false
      });
    marker3 = new google.maps.Marker({
      position: new google.maps.LatLng(6.913779, 80.297905),
      map: map,
      draggable: false
      });
    marker4 = new google.maps.Marker({
      position: new google.maps.LatLng(6.733579, 79.999505),
      map: map,
      draggable: false
      });
      google.maps.event.addListener(marker2, 'click', function() { map.setZoom(15);
        map.setCenter(marker2.getPosition()); 
      } );
      google.maps.event.addListener(marker1, 'click', function() { map.setZoom(15);
        map.setCenter(marker1.getPosition()); 
      } );
      markers.push(marker1);
      markers.push(marker2);
      google.maps.event.addListener(marker3, 'click', function() { map.setZoom(15);
        map.setCenter(marker3.getPosition()); 
      } );
      google.maps.event.addListener(marker4, 'click', function() { map.setZoom(15);
        map.setCenter(marker4.getPosition()); 
      } );
      markers.push(marker3);
      markers.push(marker4);

  }
  google.maps.event.addDomListener(window, 'load', initialize);
  </script>
   </head>

  <body>
  <div id="googleMap" style="width:1300px;height:550px; margin:auto; border: 5px solid #73AD21; padding: 15px;"></div>
  

  </body>
</html>
