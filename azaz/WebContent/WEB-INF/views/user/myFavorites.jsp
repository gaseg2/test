<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="dto" items="${list}">
${dto.num}<a href="content.do?num=${dto.num}"> ${dto.writer}</a><br/>
</c:forEach> 
    
    <input type="button" value="내가 쓴 글" onclick="javascript:window.location='myWrite.do'"><br/><br/>