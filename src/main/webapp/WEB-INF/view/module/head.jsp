<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--메인 이미지 위치--%>
<div id="headWrapper">
<div id="logoWrapper">
    <a href="/main/stores">
        <img id="logo" src="/img/cakeLogo.png">
    </a>
</div>

<%--searchbar 위치--%>
<div id="searchWrapper">
    <form id="search" method="get" action="/main/stores">
        <input id="searchInput" type="text" name="search">
        <button type="submit" id="searchButton">
            <img id="searchIcon" src="/img/searchIcon.png">
        </button>
    </form>
</div>
<%--로그인, 회원가입--%>
<c:if test="${not isLogin}">
    <div id="userWrapper">
        <a href="/user/login" id="login">로그인</a>
        <a href="/user/join" id="join">회원가입</a>
    </div>
</c:if>
<c:if test="${isLogin}">
    <div id="userWrapper">
        <a href="/user/logout" id="logout">로그아웃</a>
    </div>
</c:if>
</div>

