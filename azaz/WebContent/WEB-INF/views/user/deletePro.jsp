<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<c:if test="${check == 1}">
		<form method="post" action="loginForm.do" >
			<script>
			alert("회원정보가 삭제되었습니다.");
			window.location="loginForm.do";
			</script>
			<input type="submit" value="확인">
		</form>
	</c:if>
	
	<c:if test="${check != 1}">
		<script> 
			alert("비밀번호가 맞지 않습니다.");
			history.go(-1);
		</script>
	</c:if>

