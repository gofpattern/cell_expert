<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<portlet2:defineObjects />
<portlet:defineObjects />
<script type="text/javascript"></script>
<title>Timesheet System</title>
<jsp:include page="header.jsp" />

</head>
<body class="">

<div class="bg">

<div id="content" class="content loggedin">

<div class="container ">

</div>
</div>
</div>
<ul class="breadcrumb">
  <li><a href="..">Home</a> <span class="divider">/</span></li>
  <li class="active">Timesheets</li>
</ul>

<form class="form form-horizontal" action="{{ url_for('enter_timesheet') }}" method=post>
	{{ wtf.form_errors(form, "only") }}

	{{ wtf.horizontal_field(form.employee) }}
	
	<label class="control-label" for="work">Work</label>
	<div class="controls"><table><tr>
	
		<td style="padding:0px 25px">{{ subfield }}</td>
	
	</tr>
	<tr>
	
		<td style="text-align:center">{{ subfield.label }}</td>
	
	</tr></table></div>
	
	
	
	<div class="form-actions">
		<button name="action_save" type="submit" class="btn btn-primary">Save changes</button>
	</div>
</form>

<script src="{{ url_for('static', filename='js/jquery.min.js') }}"></script>
<script src="{{ url_for('static', filename='js/bootstrap-datepicker.js') }}"></script>
<script src="{{ url_for('static', filename='js/bootstrap-typeahead.js') }}"></script>
<script type="text/javascript">
    $(document).ready(function() {
		var employees = {{ employees|safe }};
		console.log(employees);
        $('#date').datepicker({format: 'yyyy-mm-dd'});
        var now = new Date();
        $('#date').datepicker('setValue', now);
        $('#employee').typeahead({source: employees, items:5});
    });
</script>




</body>
</html>