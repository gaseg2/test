<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form>
제목 ${dto.title} <br/>
아이디 ${dto.id} <br/>
작성자 <a href="/azaz/user/myWrite.do"> ${dto.writer}</a>
<input type="button" value="즐겨찾기" onclick="window.location='/azaz/mylist/listInsert.do?name=${dto.id}&my_id=${sessionScope.memId}&mnum=${dto.num}'"><br/>
<input type="button" value="업체위치" onclick="window.location='/azaz/user/azazMap.do?id=${dto.id}'"><br/>
사진 <img src="/azaz/img/${dto.img}"><br/>

내용 ${dto.content} <br/>
조회수 ${dto.readcount}<br/>


<input type="button" value="뒤로가기" onclick="javascript:window.location='list.do'"><br/><br/>

<c:if test="${sessionScope.memId == dto.id}">
	<button type="button" onclick="location.href='/azaz/sell/update.do?num=${dto.num}'">수정</button>
	<button type="button" onclick="location.href='/azaz/sell/delete.do?num=${dto.num}'">삭제</button>
</c:if>

</form>

<c:forEach items="${reply}" var="reply">
      	
        <p>
        작성자 : ${reply.id}<br />
        작성 날짜 :  <fmt:formatDate value="${reply.reg}" pattern="yyyy-MM-dd" />
        </p>
		
        <p>${reply.rcontent}</p>
        
		<c:if test="${sessionScope.memId == reply.id}">
	       <input type="button" value="수정" onclick="window.location='replyUpdate.do?re_no=${reply.re_no}&num=${dto.num}'"> 
	       <input type="button" value="삭제" onclick="window.location='replydelete.do?re_no=${reply.re_no}&num=${dto.num}'">
		</c:if>   
    </c:forEach>
    
    
    
<form action="replyinsert.do" method="post">    
 	<input type="text" id="rcontent" name="rcontent">
 	<input type="hidden" id="id" name="id" value="${sessionScope.memId}">
 	<input type="hidden" id="num" name="num" value="${dto.num}">
	
        <input type="submit" value="댓글 달기">
</form>
