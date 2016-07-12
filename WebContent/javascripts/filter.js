/**
 * 
 */

$(document).ready(function() {
	$('#submit').click(function(event) {
		if ( ( $("#studentId").val() == null || $("#studentId").val() == "") 
				|| ( $("#typeAssgn").val()== null || $("#typeAssgn").val() == "")
				|| ( $("#assgnName").val()== null || $("#assgnName").val() == "")
				|| ( $("#date").val()== null || $("#date").val() == "")
				|| ( $("#grade").val()== null || $("#grade").val() == "")){
			alert("Enter all values")
			event.preventDefault();
			return;
			
		}
	});
	$('#datepicker').datepicker();
	$( "#draggable" ).draggable();
	$( "#resizable" ).resizable();
	$( "#accordion" ).accordion();
    function hexFromRGB(r, g, b) {
        var hex = [
          r.toString( 16 ),
          g.toString( 16 ),
          b.toString( 16 )
        ];
        $.each( hex, function( nr, val ) {
          if ( val.length === 1 ) {
            hex[ nr ] = "0" + val;
          }
        });
        return hex.join( "" ).toUpperCase();
      }
      function refreshSwatch() {
        var red = $( "#red" ).slider( "value" ),
          green = $( "#green" ).slider( "value" ),
          blue = $( "#blue" ).slider( "value" ),
          hex = hexFromRGB( red, green, blue );
        $( "#swatch" ).css( "background-color", "#" + hex );
        $( "#body" ).css( "background-color", "#" + hex );
      }
   
      $( "#red, #green, #blue" ).slider({
        orientation: "horizontal",
        range: "min",
        max: 255,
        value: 127,
        slide: refreshSwatch,
        change: refreshSwatch
      });
      $( "#red" ).slider( "value", 255 );
      $( "#green" ).slider( "value", 140 );
      $( "#blue" ).slider( "value", 60 );
	/*$('#date').datepicker({
	    format: 'mm-dd-yyyy'
	});*/
	/* $("#date1").datepicker({
	      changeMonth: true,//this option for allowing user to select month
	      changeYear: true //this option for allowing user to select from year range
	    });*/
	$('#average').click(function(event) {
		alert("in")
		if ( ( $("#student").val() == null || $("#student").val() == "") 
				&& ( $("#type").val()== null || $("#type").val() == "")){
			
			alert("Enter either a Student ID or type of Assignment or both.")
			return;
		}
		var dataString ='student='+ $("#student").val()+ '&type=' + $("#type").val();
		$.ajax({
			type : "POST",
			url : "Average",
            data: dataString,
			success : function(data) {
				window.location = 'http://localhost:8080/ClassAssist/Welcome.jsp';
			}
		});

	});
	$('#assignments').click(function(event) {
		var dataString ='student='+ $("#student").val()+ '&type=' + $("#type").val();;
		//alert(dataString);
		$.ajax({
			type : "POST",
			url : "Assignments",
            data: dataString,
			success : function(data) {
				window.location = 'http://localhost:8080/ClassAssist/Welcome.jsp';
			}
		});

	});
	$('#highLow').click(function(event) {
		if ($("#type").val()== null || $("#type").val() == "") {
			alert("Type of Assignment not specified.")
			return;
		}
		var dataString ='student='+ $("#student").val()+ '&type=' + $("#type").val();;
		$.ajax({
			type : "POST",
			url : "HighLowScore",
            data: dataString,
			success : function(data) {
				window.location = 'http://localhost:8080/ClassAssist/Welcome.jsp';
			}
		});

	});
});
