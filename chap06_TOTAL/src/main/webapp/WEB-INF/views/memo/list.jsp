<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 로그인 관련 입력 폼만 구축 -->
<style>
	th {
		border-bottom: 1px solid;
		text-align: left;
	}
	th, td {
		padding: 10px;
	}
</style>
<div align="center" style="line-height: 35px">
	<h2>쪽지함</h2>
	<p>
		<b>${auth.ID }</b>님에게  총 <b></b> 개의 쪽지가 있습니다.
	</p>
	<form action="/memo/delete.jsp">
		<table style="width: 80%">
			<thead>
				<tr>
					<th style="width: 5%"><input type="checkbox" onchange="javascript:allck()" id="all"/></th>
					<script>
					function allck(objs) {
						var objs = document.getElementsByClassName("allcheck");
							for(var i=0; i<objs.length; i++) {
								objs[i].checked = true;
							}
						document.getElementById("all").innerHTML = "";
							all = [];
						}
					//=================================================================
					</script>
					<th style="width: 20%">보낸사람</th>
					<th style="width: 75%">메모내용</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3"><button type="submit">삭제</button></td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>
