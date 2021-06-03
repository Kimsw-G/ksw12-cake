<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/user/login" method="post" id="wrapper">
    <input type="text" id="id" name="u_id" placeholder="아이디" value="kimsw">
    <input type="password" id="password" name="u_pw" placeholder="비밀번호" value="3445"><br>
    <button type="submit" id="login" form="wrapper">로그인</button>
    <%-- 후에 구글, 네이버 로그인 기능 구현해주기 --%>
</form>