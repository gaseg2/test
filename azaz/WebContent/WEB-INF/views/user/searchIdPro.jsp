<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:if test="${c.id == null}">
	<script>
		alert("가입된 아이디가 없습니다.");
		history.go(-1);
	</script>
</c:if>

<c:if test="${c.id != null}">
	<script>
		alert("아이디: ${c.id}");
		history.go(-1);
	</script>
</c:if>


