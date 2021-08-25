<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	del = confirm('삭제하시겠습니까?');
	if(del){
		window.location='/azaz/mylist/deletelistPro.do?name=${name}&my_id=${sessionScope.memId}'
	}else{
		history.go(-1);
	}
</script>