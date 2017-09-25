<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
</style>
<h3>JQuery 연습#2</h3>
아래 선택된 항목에 따라 총 상품금액을 계산해서 출력하는 script 설정
<hr />
<div>
	<h3>삼성노트북 코어 i5</h3>
	판매가 : 656,000 <hr/>
	옵션 :
	<ul style="list-style: none;">
		<li><input type="checkbox" class="opt" data="24000" />RAM 추가 (+24,000)</li>
		<li><input type="checkbox" class="opt" data="34000" />HDD추가 (+34,000)</li>
		<li><input type="checkbox" class="opt" data="22000" />외장그래픽카드추가 (+22,000)</li>
		<li><input type="checkbox" class="opt" data="42000" />OS포함 (+42,000)</li>
	</ul>
	<hr />
	수량 :
	<button>-</button>
	<input type="number" style="width: 50px;" value="1" min="1" />
	<button>+</button>
	<hr />
</div>
<div id="tot">전체 상품 총액 : 656,000</div>
<script>
	$(".opt").change(function(){
		// console.log(parseInt($(this).attr("data")));
		for(var i=0; i< $(".opt").length; i++){
			if($(".opt").eq(i).prop("checked")){
				$("#tot").html() + parseInt($(".opt").eq(i).attr("data"));
			};
		};
	});

</script>








