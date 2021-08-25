<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>비밀번호 찾기</h1>

<form method="get" action="searchPwPro.do">
		
		ID : <input type="text" name="id" /><br/>
		휴대번호 : 	<input type="text" name="phone" /><br/>

		<input type="submit"  value="비밀번호 찾기" />
		<input type="button" value="뒤로가기" onclick="javascript:window.location='loginForm.do'">

</form>