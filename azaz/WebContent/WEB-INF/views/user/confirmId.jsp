<%@ page contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:if test="${check == 1}">

<table>
	<tr> 
		<td>${id}이미 사용중인 아이디입니다.</td>
	</tr>
</table>

<form name="checkForm" method="post" action="confirmId.do">

<table>
	<tr>
		<td> 
	       	다른 아이디를 선택하세요.<p>
			<input type="text" name="id"> 
			<input type="submit" value="ID중복확인">
		</td>
	</tr>
</table>
</form>

</c:if> 

<c:if test="${check != 1}">

<table>
	<tr> 
		<td> 
			<p>입력하신 ${id} 는 사용하실 수 있는 ID입니다. </p>
			<input type="button" value="닫기" onclick="setid()">
		</td>
	</tr>
</table>

</c:if> 

<script language="javascript">

<!--
	function setid()
	{		
		opener.document.userinput.id.value="${id}";
		self.close();
	}
-->

</script>
