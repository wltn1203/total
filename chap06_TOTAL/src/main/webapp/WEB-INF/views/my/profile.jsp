<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.bt {
	padding: 3pt;
	width: 50px;
}
</style>
<div align="center">
	<h3>프로필관리</h3>
	<div>
		<p>
			<img id="pre" src="/" alt="기본이미지" style="width: 200; height: 200" />
		</p>
		<form action="/my/profile" method="post" enctype="multipart/form-data">
			<input id="profile" type="file" name="profile" style="display: none"/>
			<input type="text" name="nick"/>
			<button type="submit" class="bt">적용</button>
			<button type="button" class="bt">취소</button>
		</form>
	</div>
</div>
<script>
	document.getElementById("pre").onclick=function() {
		document.getElementById("profile").click();
	}
</script>
