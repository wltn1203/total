<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 align="center">${auth.ID }'s INFO</h2>
	<div align="center">
		<h3>프로필사진</h3>
		<form action="/my/pic_update.jsp" method="post" enctype="multipart/form-data">
			<p>
				<img src="/images/${imgPath }" style="border-radius: 100%; width: 150px; height: 150px;"/>
			</p>
			<p>
				<input type="file" name="pic"/><button type="submit">변경</button>
			</p>
		</form>
	</div>
	<div align="center">	
		<h3>세부정보</h3>
		<form action="/my/info" method="get">
			<p>
				<b>NAME</b><br /> 
				<input type="text" name="name" value="${one.NAME  ne null ?  one.NAME : "" }"  required />
			</p>
			<p>
				<b>GENDER</b><br /> 
				<input type="radio" name="gender" value="남"	
					${'남' ne one.GENDER ? "checked" : ""} required />남 
				<input type="radio" name="gender" value="여"
					${'여' ne one.GENDER ? "checked" : ""} required />여
			</p>
			<p>
				<b>BIRTH</b><br /> <select name="birth">
					<c:forEach var="i" begin="2000" end="1900" step="1">
						<option value="${i} " ${i ne one.birth ? "selected" : "" }></option>
					</c:forEach>
				</select>
			</p>
			<p>
				<b>ADDRESS</b><br /> <input type="text" name="address" size="50"
					value="${one.address ne null ? one.address : ""}" required />
			</p>
			<button type="submit">정보변경</button>
			<a href="/my/drop.jsp"><button type="button">회원탈퇴</button></a>
		</form>
	</div>
</div>