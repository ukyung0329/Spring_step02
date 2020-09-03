<%@page import="bit.com.a.dto.MyClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.js"></script> 
</head>
<body>

<h3>hello</h3>

<!-- 1번 : HelloController  -->
<%
	MyClass cls = (MyClass)request.getAttribute("mycls");
%>
number:<%=cls.getNumber() %><br>
name:<%=cls.getName() %><br>

<br><br>

<!-- EL tag 사용  -->
number:${mycls.number }<br>
name:${mycls.name }<br>





<!--2번 -->
<form action="move.do">
<input type="submit" value="move">
</form>
<br><br>




<!-- 3번  -->
아이디:<input type="text" id="checkid"><br>
<br>
<button type="button" id="_check" onclick="idcheck()">id check</button>


<script type="text/javascript">
function idcheck(){

	$.ajax({
			url:"./idcheck.do",
			type:"get",
			//data:"id="+$("#checkid").val(),
			data:{ id:$("#checkid").val()},
			success:function( data ){
				alert('success');
				alert(data);
			},
			error:function(){
				alert('error');
			}
		});
	
}

</script>
<br><br>









<!-- 4번 : 여러명의데이터 -->
<!-- 
	Json(jsp) -> Object(-map)(controller) -> json(-String)(jsp)
 -->
이름:<input type="text" id="_name" value="홍길동"><br>
전화:<input type="text" id="_phone" value="123-4567"><br>
이메일:<input type="text" id="_email" value="hgd@naver.com"><br>
생년월일:<input type="text" id="_birth" value="2001/11/23"><br>
<button type="button" id="account">회원가입</button>

<script type="text/javascript">
$("#account").click(function() {
	//alert('account');

	//Json으로 묶어 -> Controller 로 받음
	// 그 후 Controller에서 Map 으로 받음 

	let human = {
		name:$("#_name").val(),
		tel:$("#_phone").val(),
		email:$("#_email").val(),
		birth:$("#_birth").val()
	};

	$.ajax({
		url:"./account.do",
		type:'post',
		dataType:'json',
		data:human,
		async:true,
		success:function( resp ){
			//alert('success');
			alert(resp.message);	//내가보낸 메세지입니
			alert(resp.name);		//정수동 
		},
		error:function(){
			alert('error');
		}


	});
		
	
});
</script>




<!-- 5번 : 한명의 데이터  -->
<!-- 
	Json(jsp) -> Object(controller) -> Json(jsp)
 -->
<br><br>

이름:<input type="text" id="name1" value="육"><br>
전화:<input type="text" id="phone1" value="111-6666"><br>
이메일:<input type="text" id="email1" value="aaa@naver.com"><br>
생년월일:<input type="text" id="birth1" value="2020-09-01"><br>
<button type="button" id="account1">회원가입</button>

<script type="text/javascript">
$("#account1").on("click",function(){
	//alert('account1');

	let data = {};

	data["name"] = $("#name1").val();
	data['tel'] = $("#phone1").val();
	data['email'] = $("#email1").val();

	let birth = $("#birth1").val();	//날짜인 경우에
	data["birth"] = birth.replace(/-/g, "");		//날짜가 2020-12-26이렇게 쓰여있어야 -> 20201226으로 토큰삭제
	//alert(data["birth"]);

	$.ajax({
		url:"updateUser.do",
		type:"post",
		datatype:'json',
		data:JSON.stringify(data),		//Json을 문자열로 변경 JSON.stringify(str) <-> parse
		contentType:'application/json',
		success:function(resp){
			alert('success');
			alert(resp.message);	//내가보낸 메세지2 
			alert(resp.test);		//리멥 
		},
		error:function(){
			alert('error');
		}
	});
		
});

</script>






<!-- 연습문제 -->
<!--
	입력: number, name
	받아서 Json으로 보내면 
	
	controller에서 받아서 list (3개데이터) 로 보내고 web에서 확인하기 
 -->
<br><br>
숫자입력 : <input type="text" id="num">
이름입력 : <input type="text" id="name">
<button type="button" id="_pass">제출</button>
<br>
<script type="text/javascript">
$("#_pass").click(function() {
	alert('gg');
	let data = {};

	data["name"] = $("#name").val();
	data["number"] = $("#num").val();
	
	
	$a.jax({
		url:"pass.do",
		type:"post",
		data:{ number:$("#num".val(), name:$("#name").val())}
		success: function(list){
			alert('success');
			alert(JSON.stringify(list));
		},
		error:function(){
			alert('error');
		}
	});
});

</script>


</body>
</html>








