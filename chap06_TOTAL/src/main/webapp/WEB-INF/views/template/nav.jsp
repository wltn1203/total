<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="right">
	<c:choose>
		<c:when test="${empty auth }">
			<a href="/login">Login</a> | 
			<a href="/join">Join</a>
		</c:when> 
		<c:otherwise>
			<p>
			<b>${auth.ID } <i>(${auth.NAME })</i> || LOG ON</b>
			</p>
			<p>
			<a href="/my/info">Info</a> |
			<a href="/my/profile">Profile</a>
			</p>
		</c:otherwise>
	</c:choose>
</div>