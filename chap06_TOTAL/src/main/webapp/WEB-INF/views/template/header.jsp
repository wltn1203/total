<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<h1 align="center"><a href = "/index">1st Story</a></h1>
	<p id="alt">
	
	</p>
</div>
<script>
	var ws = new WebSocket("ws://192.168.10.75/ws/alert");
	ws.onmessage = function(e) {
		document.getElementById("alt").innerHTML = e.data;
	}

</script>