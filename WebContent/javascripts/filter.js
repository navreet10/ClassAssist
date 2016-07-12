/**
 * 
 */

$(document).ready(function() {

	$('#average').click(function(event) {
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
