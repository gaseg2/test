<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>로그인</h1>
<form method="post" action="loginPro.do">
  
	ID : <input type="text" name="id"><br />
	PW : <input type="password" name="pw"><br/><br />
	<input type=submit value="로그인"> 
      	
	<input type="button" value="회원가입" onclick="javascript:window.location='insertUserForm.do'"><br /><br />
	<input type="button" value="ID 찾기" onclick="javascript:window.location='searchId.do'">
	<input type="button" value="PW 찾기" onclick="javascript:window.location='searchPw.do'">

</form>
