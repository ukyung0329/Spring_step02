<%@page import="bit.com.a.dto.MemberDto"%>
<%@page import="bit.com.a.dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>상세 글 보기</h2>

<%
BbsDto bbs = (BbsDto)request.getAttribute("bbs");
%>

<%
Object ologin = session.getAttribute("login");
MemberDto mem = (MemberDto)ologin;
%>

<div class="center">

<table border="2">
<col width="200"><col width="500">

<tr>
	<td>작성자</td>
	<td><%=bbs.getId() %> </td>
</tr>
<tr>
	<td>제목</td>
	<td><%=bbs.getTitle() %> </td>
</tr>
<tr>
	<td>작성일</td>
	<td><%=bbs.getWdate() %> </td>
</tr>
<tr>
	<td>조회수</td>
	<td><%=bbs.getReadcount() %> </td>
</tr>
<tr>
	<td>정보</td>
	<td><%=bbs.getRef()%>-<%=bbs.getStep()%>-<%=bbs.getDepth()%> </td>
</tr>

<tr>
<td>내용</td>
<td>
<textarea rows="10" cols="50" 
name="content"><%=bbs.getContent() %>
</textarea>
</td>
</tr>
</table>

<button type="button" onclick="answerbbs('<%=bbs.getSeq() %>')">답글</button> 

</div>

<a href='bbslist.do'>글 목록</a>






