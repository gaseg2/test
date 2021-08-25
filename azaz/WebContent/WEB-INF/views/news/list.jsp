<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 검색기능
<form action="/azaz/board/searchList.do">
	<select name="col">
		<option value="id">아이디</option>
		<option value="title">제목</option>
		<option value="content">내용</option>
	</select>
	<input type="text" name="search">
	<input type="submit" value="검색">
</form> 
-->

<h1>azaz_news</h1>

<c:forEach var="dto" items="${list}">
<a href="/azaz/news/content.do?num=${dto.num}"> ${dto.news_title}</a> ${dto.news_time}<br/><br/>
</c:forEach>

<input type="button" value="메인페이지" onclick="javascript:window.location='/azaz/user/main.do'"><br/><br/>

<c:if test="${count > 0}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if> 
          
   <c:if test="${startPage > 10}">
        <a href="/azaz/news/list.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/azaz/news/list.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/azaz/news/list.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>