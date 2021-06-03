<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--메인 이미지 위치--%>
<img id="logo" src="/img/cakeLogo.png">

<%--searchbar 위치--%>

<div id="search">
    <input id="searchInput" type="text" name="search">
    <img id="searchIcon" src="/img/searchIcon.png">
</div>

<%--로그인, 회원가입--%>
<c:if test="${not isLogin}">
    <div>
        <a href="/user/login" id="login">로그인</a>
        <a href="/user/join" id="join">회원가입</a>
    </div>
</c:if>

