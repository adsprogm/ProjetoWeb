<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.com.fabricadeprogramador.model.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<%
  Object msg = request.getAttribute("msg");
  if(msg!=null){
	  String msgStr = (String)msg;
	  out.print(msg);
  }
  
  %>
</div>

	<form method="post" action="cliente">
		E-mail: <input type="text" value="" name="email" /> <input
			type="submit" value="save" />
	
	
	<!-- usando JSTL -JavaServer Pages Standard Template Library-->
	<table>
	<c:forEach items="${lista}" var="cli">
	<td>
	<c:out value="${cli.email}"></c:out>
	</td>
	</c:forEach>
	</table>
	
	</form>
</body>
</html>