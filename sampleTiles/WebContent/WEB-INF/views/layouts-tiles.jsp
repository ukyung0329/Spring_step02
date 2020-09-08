<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 화면 배치용 jsp -->
<table width="100%" height="100%">

<tr align="center" style="background-image: url('./image/kaws04.png'); background-size: 100% 100%;" >		<!-- header -->
	<td height="900px" colspan="3">
		<tiles:insertAttribute name="header"/>
	</td>
</tr>

<tr align="center" style="background-color: black;color: white;">		<!-- header -->
	<td height="100px" colspan="3">
		<tiles:insertAttribute name="navi"/>
	</td>
</tr>

<tr>					<!-- menu, main -->
	<td width="20%" height="700px;" align="left" valign="top" >
		<tiles:insertAttribute name="menu"/> 
	</td>
	<td>
		<tiles:insertAttribute name="content"/>
	</td>
	<td width="15%" align="center">
		<tiles:insertAttribute name="empty"/>
	</td>
</tr>

<tr align="center" style="background-color: black;color: white;">		<!-- footer -->
	<td height="200px" colspan="3">
		<tiles:insertAttribute name="footer"/>
	</td>
</tr>

</table>




</body>
</html>











