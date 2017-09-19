<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	p{padding: 5px;margin: 2px;	}
</style>
<div align="center" style="margin: 10px;">
	<h3 id="r">OPEN CHAT</h3>
	<div style="width: 80%; height:70%; background-color: #D5D5D5; font-size: 10pt; overflow-y: scroll; word-break: break-all" align="left" id="log">
	</div>
	<input type="text" id="f" style="width: 80%; margin-top:5px; padding: 4px" />
</div>
<script>
	document.getElementById("f").onchange=function(){
		if(this.value.length!=0) {
			ws.send(this.value);
			this.value="";
		}
	}

	var ws = new WebSocket("ws://192.168.10.75/ws/chat");
	ws.onopen=function(e) {
		document.getElementById("log").innerHTML += "<p><b>[오픈채팅 서버 접속 성공]</b></p>";
	}
	ws.onerror=function(e) {
		if(window.confirm("채팅서버 접속 실패\n다시 접속하시겠습니까?")) {
			ws =new WebSocket("ws://192.168.10.75/ws/chat");
		}
	}
	
	
	ws.onmessage = function(e) {
		var data = JSON.parse(e.data);
			document.getElementById("log").innerHTML += "["+data.sender+"] : "+data.msg+"<br/>";
			document.getElementById("log").scrollTop = 
				document.getElementById("log").scrollHeight;
	}
	

</script>