<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
input, button {
	width: 100%;
	padding: 5px;
	font-family: 맑은 고딕;
}

b {
	font-size: 12pt;
}
</style>
<div align="center">
	<div style="width: 380px;" align="left">
		<h3>Join HUB</h3>
		<h4>The BestWay to Study Software</h4>
		<h3 style="margin-top: 50px;">CREATE YOUR ACCOUNT</h3>
		<c:if test="${!empty temp }">
			<b style="color: red">join failed..</b>
		</c:if>
		<form action="/join" method="post" autocomplete="off">
			<p>
				<b>ID</b><br /> <input type="text" name="id" required id="id" /><br />
				<span id="chk_rst"></span>
			</p>
			<p>
				<b>PASS</b><br /> <input type="password" name="pass" required />
			</p>
			<p>
				<b>EMAIL</b><br /> <input id="email" type="email" name="email"
					required />
			</p>
			<p>
				<button id="auth" type="button">C O N F I R M</button>
			</p>
			<p id="auth_view" style="display: none;">
				<b>AUTHORIZED KEY</b> <small id="left"
					style="color: red; font-weight: bold"></small><br /> <input
					id="email" type="email" name="email" required /><br/>
					<button id="abt" type="button">인증하기</button>
			</p>
			<button id="sbt" type="submit" disabled>C R E A T E</button>
		</form>
	</div>
</div>
<script>
	var tot;
	var time;
	document.getElementById("auth").onclick = function() {
		if (document.getElementById("email").value.length != 0) {
			var e = document.getElementById("email").value;
			var param = "target="+e;
			var xhr = new XMLHttpRequest();
			xhr.open("post", "/join/auth", true);
		//	xhr.send(param);
			xhr.send(e);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4) {
					window.alert(e + "\n로 인증키가 발송되었습니다.");
					document.getElementById("auth").style.display = "none";
					document.getElementById("auth_view").style.display = "";
					tot = 180;
					time = setInterval(limit, 1000);
				}
			}
		}
	}

	var limit = function() {
		var m = Math.floor(tot / 60);
		var s = tot % 60;
		console.log(m + "/" + s);
		document.getElementById("left").innerHTML = m + ":"
				+ (s < 10 ? "0" + s : s);
		tot--;
		console.log(tot);
		if(tot<0) {
			window.alert("인증시간이 초과되었습니다.");
			clearInterval(time);
			document.getElementById("auth").style.display = "";
			document.getElementById("auth_view").style.display = "none";
		}
	}
</script>





