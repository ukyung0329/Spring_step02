<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
th{
	background-color: gray;
	color: white;
	border: solid black 1px;
}
</style>

<div align="center" style="overflow:scroll; height:450px; overflow-x: hidden">

<table border="1" style="border-collapse: collapse;">
<col width="70"><col width="600"><col width="150"><col width="150">

<tr>
	<th>번호</th><th>제목</th><th>작성일</th><th>작성자</th>
</tr>

<c:if test="${empty bbslist }">
	<tr>
		<td colspan="4">작성된 글이 없습니다</td>
	</tr>
</c:if>

<c:forEach items="${bbslist }" var="bbs" varStatus="vs">
	<tr>
		<th>${vs.count }</th>

		<td class="seqclick" seq=${bbs.seq }>
			${bbs.title }
		</td>
		
		<td>${bbs.wdate }</td>
		<td>${bbs.id }</td>	
	</tr>
</c:forEach>
</table>
</div>
<br>
<div align="center">

<select id="choice">
	<option value="sel">선택</option>
	<option value="title">제목</option>
	<option value="writer">작성자</option>
	<option value="content">내용</option>
</select>

<input type="text" id="search" value="">
<button onclick="searchBbs()">검색</button>

</div>

<script>
$(document).ready(function(){

	$(".seqclick").click(function(){
	//	alert('click');
	//	alert( $(this).attr("seq") );
		location.href = "bbsdetail.do?seq=" + $(this).attr("seq");
	});	

	$(".seqclick").mouseover(function() {		
		$(this).css("background", "#e0e0e0");
	});
	$(".seqclick").mouseout(function() {
		$(this).css("background", "#ffffff");
	});	
});

function searchBbs() {
	var choice = document.getElementById("choice").value;
	var word = $("#search").val();
	if(word == ""){
		document.getElementById("choice").value = 'sel';
	}	
	location.href = "bbsSearchList.do?searchWord=" + word + "&choice=" + choice;	
}


</script>


