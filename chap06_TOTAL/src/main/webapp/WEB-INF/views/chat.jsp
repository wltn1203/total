<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
p {
	padding: 2px;
	padding-left: 5px;
	margin: 0px;
}
</style>
<div align="center" style="margin: 10px;">
	<h3>
		OPEN CHAT<span id="cnt"></span>
	</h3>
	<div
		style="width: 80%; height: 70%; background-color: #D5D5D5; font-size: 10pt;"
		align="left" id="log"></div>
	<input type="text" id="f"
		style="width: 80%; margin-top: 5px; padding: 4px" />
</div>
<script>
	document.getElementById("f").onchange = function() {
		if (this.value.length != 0) {
			ws.send(this.value);
			this.value = "";
		}
	}
	var ws = new WebSocket("ws://192.168.10.75/ws/chat");
	ws.onmessage = function(e) {
		console.log(e.data);	// e.data    (WebSocketHandler 에서 전송하는 JSON형태의 string)
		var obj =JSON.parse(e.data);
		document.getElementById("cnt").innerHTML = "("+obj.cnt+")";
		switch(obj.mode) {
		case "join" :
			var m1 = "<p><b>"+ obj.user+"가 입장하였습니다.</b></p>";
			document.getElementById("log").innerHTML += m1;
			break;
		case "chat" :
			var m2 = "<p><b>"+ obj.sender+"</b> : " +obj.msg +"</p>";
			document.getElementById("log").innerHTML += m2;
			break;
		case "exit" :
			var m3 = "<p><b>"+ obj.user+"가 퇴장하였습니다.</b></p>";
			document.getElementById("log").innerHTML += m3;
		}
	}
	ws.onopen = function(e) {
		document.getElementById("log").innerHTML += "<p><b>[오픈채팅 서버 접속 성공]</b></p>";
		document.getElementById("log").innerHTML += "<p>즐거운채팅되십시요.</p>";
	}
	ws.onerror = function(e) {
		if (window.confirm("채팅서버 접속 실패\n다시 접속하시겠습니까?")) {
			ws = new WebSocket("ws://192.168.10.75/ws/chat");
		}
	}
</script>