

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coach Home</title>
<%@ include file="commonhead.jsp"%>
<link href="css/style.css" rel="stylesheet" type="text/css">
<!-- 
<script type="text/javascript">
var status=false;
	function view() {
		v=document.getElementById("eventname").value;
	
		alert(v);
		if(v!="" ||v!=null){
			status=true;
		}
		
	}
</script>

<body onload="return view()">
/**
	<%//String eventname = (String) session.getAttribute("eventname");
			//Cookie cookies[] = request.getCookies();
			//String value = null;
			//for (Cookie c : cookies) {
				//String key = c.getName();
				//if (key.equals("eventname")) {
					//value = c.getValue();%>
	<input type="hidden" id="eventname" value="">
	<%//}
			//}%>
**/
 -->
</head>
<body>
	<%@ include file="mainHeader.jsp"%>
	<%@ include file="coachMenu.jsp"%>
	<h1 style="text-align: center;">Coach Home</h1>
</body>
</html>