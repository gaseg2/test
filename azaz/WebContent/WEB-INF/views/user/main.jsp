<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<h1>main 페이지</h1>
	${sessionScope.memId} 님이 방문하셨습니다.<br/><br/>
	
    <input type="button" value="myPage" onclick="javascript:window.location='myPage.do'"><br/><br/>

	<input type="button" value="판매 게시판" onclick="javascript:window.location='/azaz/sell/list.do'"><br/><br/>
	<input type="button" value="리뷰게시" onclick="javascript:window.location='/azaz/board/list.do'"><br/><br/>
	<input type="button" value="식품뉴스" onclick="javascript:window.location='/azaz/news/list.do'"><br/><br/>
	
	<c:if test="${c.rating == 2}">
		<input type="button" value="글쓰기" onclick="javascript:window.location='/azaz/sell/insert.do'"><br/><br/>
	</c:if>
	
	
	<form  method="post" action="logout.do"><br/>
    <input type="submit"  value="로그아웃">
    
    </form>
    <c:forEach var="dto" items="${list}">
		<a href="/azaz/sell/content.do?num=${dto.num}"> ${dto.title}</a>${dto.writer} ${dto.id} <fmt:formatDate value="${dto.reg}" pattern="yyyy-MM-dd" /><br/>
	</c:forEach>
	