/**
 * 
 */

$(document).ready(function() {

	$('#average').click(function(event) {
		var dataString ='student='+ $("#student").val()+ '&type=' + $("#type").val();;
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
