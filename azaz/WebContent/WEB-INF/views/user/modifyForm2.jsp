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
       
-->
</script>


<form method="post" action="modifyPro2.do" name="userinput" onsubmit="return checkIt()">

	ID : ${c.id}<br/>
	<input type="hidden" name="id" value="${c.id}" />
	
	PW : <input type="password" name="pw" value="${c.pw}"><br/>
      
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
		전화번호 : <input type="text" name="phone" value="${c.phone}">	<br/>
	</c:if>

	<c:if test="${c.bank_num == null}">
		<input type="text" name="bank_num">
	</c:if>
	
	<c:if test="${c.bank_num != null}">
		계좌번호 : <input type="text" name="bank_num" value="${c.bank_num}"><br/>
	</c:if>
		
	<c:if test="${c.business_sellnum == null}">
		<input type="text" name="business_sellnum">
	</c:if>
		
	<c:if test="${c.business_sellnum != null}">
		판매점 연락처<input type="text" name="business_sellnum" value="${c.business_sellnum}"><br/>	
	</c:if>
		
	<c:if test="${c.business_holder == null}">
		<input type="text" name="business_holder">
	</c:if>
		
	<c:if test="${c.business_holder != null}">
		예금주 : <input type="text" name="business_holder" value="${c.business_holder}"><br/>
	</c:if>
		
	<c:if test="${c.business_name == null}">
		<input type="text" name="business_name">
	</c:if>
		
	<c:if test="${c.business_name != null}">
		사업자명 : <input type="text" name="business_name" value="${c.business_name}"><br/>
	</c:if>
		
	<c:if test="${c.business_person == null}">
		<input type="text" name="business_person">
	</c:if>
		
	<c:if test="${c.business_person != null}">
		대표자명 : <input type="text" name="business_person" value="${c.business_person}"><br/>
	</c:if>
		
	<c:if test="${c.business_num == null}">
		<input type="text" name="business_num">
	</c:if>
		
	<c:if test="${c.business_num != null}">
		사업자 번호 : <input type="text" name="business_num" value="${c.business_num}"><br/>
	</c:if>
		
	<input type="submit" name="modify" value="수   정" >
	<input type="button" value="취  소" onclick="javascript:window.location='main.do'">      

</form>
