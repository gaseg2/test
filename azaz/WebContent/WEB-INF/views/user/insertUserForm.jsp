<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script language="JavaScript">
    
    function checkIt() {
        var userinput = eval("document.userinput");
        
        for (i = 0; i < userinput.id.value.length; i++) {
            chid = userinput.id.value.charAt(i)
            if (!(chid >= '0' && chid <= '9') && !(chid >= 'a' && chid <= 'z')&&!(chid >= 'A' && chid <= 'Z')) {
                alert("아이디는 대소문자, 숫자만 입력가능합니다.")
                userinput.id.focus()
                userinput.id.select()
                return false;
            }
        }

    	if (userinput.id.value.length<4 || userinput.id.value.length>12) {
    	        alert("아이디를 4~12자까지 입력해주세요.")
    	        userinput.id.focus()
    	        userinput.id.select()
    	        return false;
    	    }
    	
    	for (i = 0; i < userinput.pw.value.length; i++) {
    	       chpw = userinput.pw.value.charAt(i)
    	        if (!(chpw >= '0' && chpw <= '9') && !(chpw >= 'a' && chpw <= 'z')&&!(chpw >= 'A' && chpw <= 'Z')) {
    	            alert("비밀번호는 대소문자, 숫자만 입력이가능합니다.")
    	            userinput.pw.focus()
    	            userinput.pw.select()
    	            return false;
    	        }
    	    }
            if(!userinput.id.value) {
                alert("ID를 입력하세요");
                return false;
            }
            
            if(!userinput.pw.value ) {
                alert("비밀번호를 입력하세요");
                return false;
            }
            if(userinput.pw.value != userinput.pw2.value)
            {
                alert("비밀번호를 동일하게 입력하세요");
                return false;
            }
    }


    // 아이디 중복 여부를 판단
    function openConfirmid(userinput) {
        // 아이디를 입력했는지 검사
        if (userinput.id.value == "") {
            alert("아이디를 입력하세요");
            return;
        }
        // url과 사용자 입력 id를 조합합니다.
        url = "confirmId.do?id="+userinput.id.value ;
        
        // 새로운 윈도우를 엽니다.
        open(url, "confirm",  "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300, height=200");
    }
    
    function ajaxConfirmid(userinput){
    	$.ajax({
			url:"confirmId2.do",    
			data:{id:$("#id").val()},	//id가 id인 곳의 값을 id에 파라미터로 전송하겟다.
			success:function(result){
				//html() - html 태그를 적용할 수 있다.
				//text() - 텍스트 내용 그대로 출력
				//append() - 기존의 내용에 계속 추가된다.
				if(result == '1'){
					$("#confirm").html("<font color=red>사용불가</font>");
					alert("존재하는 아이디 입니다.");
					var input = document.getElementById("id");
					input.value = "";
				}else{
					$("#confirm").html("<font color=green>사용가능</font>");
				}
			}
    	});
    }
    
    
</script>


<form method="post" action="insertUserPro.do" name="userinput" onSubmit="return checkIt()">

	
	
	<input type = "hidden" name = "join" value = "1" />
	<input type = "hidden" name = "rating" value = "1" />
		
	ID : <input type="text" name="id" id="id"/>
	<input type="button" name="confirm_id" value="ID중복확인" OnClick="ajaxConfirmid(this.form)">
	<label id="confirm"></label><br /> <!-- 사용불가 사용가능 글 쓰는 곳 -->
	
	
	
	PW : <input type="password" name="pw" /><br />
	PW 재확인 : <input type="password" name="pw2" /><br />
	이름 : <input type="text" name="name" /><br />
	전화번호 : 	<input type="text" name="phone" /><br />
	
	<jsp:include page="/include/address.jsp"/>
				<tr>
					<td align="right">주소</td>
					<td colspan="2"><input type="text" id="sample4_postcode" placeholder="우편번호" autocomplete=”off” name="address">
					 <input	type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2">
					<input type="text" id="sample4_roadAddress"	placeholder="도로명주소"  autocomplete=”off” name="address">
					<input type="text" id="sample4_jibunAddress" placeholder="지번주소"  autocomplete=”off” name="address">
					<input	type="text" id="sample4_extraAddress" placeholder="참고항목"  autocomplete=”off”> 
					<span id="guide" display: none"> </span><br/>

	<input type="submit" name="confirm" value="전송" />
	<input type="button" value="판매자회원가입" onclick="javascript:window.location='insertUserForm2.do'">
	<input type="button" value="취소" onclick="javascript:window.location='loginForm.do'">
	
</form>
	
	
	