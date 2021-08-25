<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- <script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		// 추천버튼 클릭시(추천 추가 또는 추천 제거)
		$("#rec_update").click(function(){
			$.ajax({
				url: "RecUpdate.do",
                type: "POST",
                data: {
                    no: $("#num").val(),
                    id: '${sessionScope.memId}'
                },
                success: function () {
			        recCount();
                },
			})
		})
		
		// 게시글 추천수
	    function recCount() {
			$.ajax({
				url: "RecCount.do",
                type: "POST",
                data: {
                    no: $("#num").val()
                },
                success: function (count) {
                	$(".rec_count").html(count);
                },
			})
	    };
	    recCount(); // 처음 시작했을 때 실행되도록 해당 함수 호출
	    
		 // 로그인 클릭
	    $("#newLogin").click(function(){
			var ww=400;    //띄울 창의 넓이
			var wh=250;    //띄울 창의 높이
			
			// 중앙 좌표
			var top=(screen.availHeight-wh)/2;
			var left=(screen.availWidth-ww)/2;
			// 새창 띄움
			javascript:window.location='/azaz/user/loginForm.do'
	    });
	})
</script> -->


<form>
<H3>제목 : ${dto.news_title}</H3> 조회수 ${dto.readcount}<br/><br/>
내용 : ${dto.news_writing} <br/>


<input type="button" value="뒤로가기" onclick="javascript:window.location='list.do'"><br/><br/>
</form>



<%-- 		<!-- 추천 기능 -->
		<div>
			<div class="w3-border w3-center w3-padding">
				<c:if test="${ sessionScope.memId == null }">
					추천 기능은 <button type="button" id="newLogin"><b class="w3-text-blue">로그인</b></button> 후 사용 가능합니다.<br />
					<i class="fa fa-heart" style="font-size:16px;color:red"></i>
					&nbsp;<span class="rec_count"></span>					
				</c:if>
				<c:if test="${ sessionScope.memId != null }">
					<button class="w3-button w3-black w3-round" id="rec_update">
						<i class="fa fa-heart" style="font-size:16px;color:red"></i>
						&nbsp;<span class="rec_count"></span>
					</button> 
				</c:if>
			</div>
		</div> --%>









<!-- 댓글 -->

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
