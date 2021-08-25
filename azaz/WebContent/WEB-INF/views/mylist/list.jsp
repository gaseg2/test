<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>즐겨찾기</h1>

<c:forEach var="dto" items="${list}">
<a href="/azaz/user/myWrite.do?writer=${dto.name}">${dto.name}</a><button type="button" onclick="location.href='/azaz/mylist/deletelist.do?name=${dto.name}&my_id=${sessionScope.memId}'">삭제</button><br/>
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
        <a href="/azaz/mylist/list.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/azaz/mylist/list.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/azaz/mylist/list.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>