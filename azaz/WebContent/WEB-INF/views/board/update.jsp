<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="updatePro.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${dto.num}">
	제목:<input type="text" name="title" value="${dto.title}"><br/>
	
	
	
	
	사진:<input type="file" name="imgs"><br/>
	<input type="hidden" name="img" value="${dto.img}">
	내용:<textarea rows="6" cols="70" name="content">${dto.content}</textarea><br/>
	<input type="submit" value="yes"><br/>
	
	
</form>