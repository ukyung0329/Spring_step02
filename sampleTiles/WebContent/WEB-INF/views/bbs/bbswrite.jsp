<%@page import="bit.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Object ologin = session.getAttribute("login");
MemberDto mem = null;
mem = (MemberDto)ologin;
%>

<h2>글쓰기</h2>

<div class="center">

<form action="bbswriteAf.do" method="post"> 

<table border="1">
<col width="200"><col width="500">

<tr>
	<td>아이디</td>
	<td>
		<input type="text" name="id" readonly="readonly" size="50" 
			value="${login.id }"> 	
	</td>
</tr>
<tr>
	<td>제목</td>
	<td>
		<input type="text" name="title" size="50">
	</td>
</tr>
<tr>
	<td>내용</td>
	<td>
		<textarea rows="10" cols="50" name="content"></textarea>
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="글쓰기">
	</td>
</tr>

</table>

</form>

</div>

