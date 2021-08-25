<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${c.pw == null}">
	<script>
		alert("정보가 옳지 않습니다.");
		history.go(-1);
	</script>
</c:if>

<c:if test="${c.pw != null}">
	<script>
		alert("비밀번호: ${c.pw}");
		window.location="loginForm.do";
	</script>
</c:if>