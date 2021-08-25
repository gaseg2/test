<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="insertPro.do" method="post" enctype="multipart/form-data">
	제목<input type="text" name="title"><br/>
	종류<select name="kind">
	<option value="">선택</option>
	<option value="1">농산품</option>
	<option value="2">수산품</option>
	<option value="3">축산</option>
	</select> <br/>
	
	<input type="hidden" id="id" name="id" value="${sessionScope.memId}">
	<input type="hidden" id="writer" name="writer" value="${c.business_name}">
	
	사진<input type="file" name="imgs"><br/>
	내용<textarea rows="6" cols="70" name="content"></textarea><br/>
	<input type="submit" value="yes"><br/>
	
	
</form>