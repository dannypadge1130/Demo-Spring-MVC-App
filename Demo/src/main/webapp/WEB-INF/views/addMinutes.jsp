<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
	<title>Add Minutes Page</title>	
</head>
<body>
<h1>Add Minutes</h1>

Language : <a href="?language=en">English</a> | <a href="?language=es">Spanish</a>

<form:form commandName="exercise">
	<table>
		<tr>
			<td><spring:message code="goal.text"/></td>
			<td><form:input path="minutes"/></td>
			<td>
				<form:select path="activity" id="activities"></form:select>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="Enter Exercise"/>
			</td>
		</tr>
	</table>
</form:form>

<h1>Our goal for the day is: ${goal.minutes}</h1>

</body>

<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.11.2.js"></script>

<script type="text/javascript">
	$(document).ready(
		function() {
			$.getJSON('<spring:url value="activities.json"/>', {
				ajax : 'true'
			}, function(data){
				var html = '<option value="">--Please select one--</option>';
				var len = data.length;
				for(var i = 0; i<len; i++) {
					html += '<option value="' + data[i].description + '">' + data[i].description + '</option>';
				}
				html += '</option>';
				
				$('#activities').html(html);
			});
		}		
	);
</script>

</html>
