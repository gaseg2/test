<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	${sessionScope.memId}
	<c:if test="${c.rating == 1}">
		<br/><input type="button" value="프로필" onclick="javascript:window.location='modifyForm.do'"><br/><br/>
    	<input type="button" value="업체즐겨찾기" onclick="javascript:window.location='/azaz/mylist/list.do'"><br/><br/>
	</c:if>
	
	<c:if test="${c.rating == 2}">
		<input type="button" value="판매자프로필" onclick="javascript:window.location='modifyForm2.do'"><br/><br/>
		<input type="button" value="내가 쓴 글" onclick="javascript:window.location='myWrite.do'"><br/><br/>
	</c:if>
	
	
    <input type="button" value="회원탈퇴" onclick="javascript:window.location='deleteForm.do'">
    
    