<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty login }">	<!-- login이 되었을 때 -->

${login.id }님 안녕하세요
<table border="1">
<col width="200">
<tr>
	<td>
		<a href="bbslist.do">글 목록</a>
	</td>
</tr>
<tr>
	<td>
		<a href="bbswrite.do">글 추가</a>
	</td>
</tr>
</table>

</c:if>



<c:if test="${empty login }">		<!-- login이 되지 않았을 때 -->

<form action="loginAf.do" method="post">

<table border="1">
<tr>
	<td>아이디</td>
	<td>
		<input type="text" name="id" size="20">
	</td>
</tr>
<tr>
	<td>패스워드</td>
	<td>
		<input type="password" name="pwd" size="20">
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="log-in">
	</td>
</tr>
</table>
</form>

<a href="regi.do">회원가입</a>

</c:if>

















