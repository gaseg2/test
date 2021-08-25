<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>회원정보수정</title>


<script language="JavaScript">
   <!-- 
    function checkIt() {
        var userinput = eval("document.userinput");
               
        if(!userinput.PW.value ) {
            alert("비밀번호를 입력하세요");
            return false;
        }
        if(userinput.PW.value != userinput.PW2.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
            return false;
        }
       
        if(!userinput.name.value) {
            alert("사용자 이름을 입력하세요");
            return false;
        }
        if(!userinput.address.value  || !userinput.address2.value )
        {
            alert("주민등록번호를 입력하세요");
            return false;
        }
    }
-->
</script>


<form method="post" action="modifyPro.do" name="userinput" onsubmit="return checkIt()">

	ID : ${c.id}<br/>
	<input type="hidden" name="id" value="${c.id}" />
	
	PW : <input type="password" name="pw" value="${c.pw}"><br/>
	
	이름 : <input type="text" name="name" value="${c.name}"><br/>
      

	<c:if test="${c.address == null}">
		<input type="text" name="address">
	</c:if>
		
	<c:if test="${c.address != null}">
		주소 : <input type="text" name="address"value="${c.address}"><br/>
	</c:if>
      
	<c:if test="${c.phone == null}">
		<input type="text" name="phone">
	</c:if>
		
	<c:if test="${c.phone != null}">
		전화번호 : <input type="text" name="phone" value="${c.phone}"><br/>	
	</c:if>
		
       <input type="submit" name="modify" value="수   정" >
       <input type="button" value="취  소" onclick="javascript:window.location='main.do'">      
</form>
