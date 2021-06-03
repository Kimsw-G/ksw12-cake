<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="/user/join" method="post" id="wrapper">
    errMsg : ${errMsg}
    <strong>아이디</strong>
    <input type="text" placeholder="아이디" name="u_id" id="id" required>
    <%-- <button>중복체크</button> --%>
    <strong>비밀번호</strong>
    <input type="password" placeholder="비밀번호" name="u_pw" id="pw"required><br>
    <input type="password" placeholder="비밀번호 체크" name="u_pwck" id="pwck"required><br>
    <strong>이름</strong>
    <input type="text" placeholder="이름" name="u_name" id="name" maxlength="3" required><br>
    <input type="text" placeholder="사장님인증키" name="authKey" id="authKey">
    <input type="submit" value="회원가입">
</form>