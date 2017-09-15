<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.bt {
	padding: 3pt;
	width: 50px;
}
</style>
<div align="center">
		<h3>프로필관리</h3>
		<div style="height: 200px; width: 200px;">
		<c:choose>
		<c:when test="${!empty rst }">
			<img id="pre" src="/profiles/${data.URI }" alt="기본이미지" style="width: 100%; height: 100%" />
		</c:when>
		<c:otherwise>
			<img id="pre" src="/" alt="기본이미지" style="width: 100%; height: 100%" />
		</c:otherwise>	
		</c:choose>
		</div>
		<div style="margin-top: 20px;">
			<form action="/my/profile" method="post"
				enctype="multipart/form-data" style="display: block;">
				<input id="profile" type="file" name="profile" style="display: none" />
				<button type="submit" class="bt">적용</button>
				<button type="button" class="bt" onclick="javascript:location.reload()">취소</button>
			</form>
		</div>
	</div>
</div>
<script>
	document.getElementById("pre").onclick = function() {
		document.getElementById("profile").click();
	}
	document.getElementById("profile").onchange = function() {
		// console.log(this.files[0]);
		// console.log("변경발생");
		var reader = new FileReader();
		reader.onload = function(e) {
			// console.log(e.target.result);
			document.getElementById("pre").src = e.target.result;
		}
		reader.readAsDataURL(this.files[0]);
	}
	
	
</script>


