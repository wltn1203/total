<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<h1 align="center"><a href = "/index">1st Story</a></h1>
	<img src="/images/qorudghkaus.png" style="border-radius: 10%;"/>
	<p id="alt">
	
	</p>
</div>
<script>
	var ws = new WebSocket("ws://192.168.10.75/ws/login");
	ws.onmessage = function(e) {
		var obj = JSON.parse(e.data);
		window.alert(obj.sender+"님 으로부터 메시지가 도착하였습니다.");
	}

</script>