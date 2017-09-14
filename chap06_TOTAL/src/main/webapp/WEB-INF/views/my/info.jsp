<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="center" style="line-height: 25px;">
	<h2>
		검색결과 :
		${auth.ID }'s INFO
	</h2>
	<table style="width: 50%;">
		<tr>
			<td>
				<div>
					<h3>프로필사진</h3>
					<p>
						<img src="${img }"
							style="border-radius: 100%; width: 150px; height: 150px;" />
					</p>
				</div>
			</td>
			<td>
				<div>
					<h3>세부정보</h3>
					<p>
						<b>NAME</b><br />
						${one.name eq null ? '미설정' : one.name }
					</p>
					<p>
						<b>GENDER</b><br />
						${one.gender eq null ? '미설정' : one.gender }
					</p>
					<p>
						<b>BIRTH</b><br />
						${one.birth eq null ? '미설정' : one.birth }
					</p>
					<p>
						<b>ADDRESS</b><br />
						${one.address eq null ? '미설정' : one.address }
					</p>
					<a href="/friend/friends.jsp?target=${one.id }"><button type="submit">친구추가</button></a>
					<a href="/my/drop.jsp"><button type="button">쪽지전송</button></a>
				</div>
			</td>
		</tr>
	</table>
</div>