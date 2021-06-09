<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 여기에 가게 이름 및 가게 메뉴--%>
<%-- 소개 메뉴 리뷰 주문--%>
<div>
    ${store.s_name}
</div>

<%--여기 나중에 ajax나 react로 하자--%>
<div>
    <a href="#">소개</a>
    <a href="#">메뉴</a>
    <a href="#">리뷰</a>
    <a href="#">주문</a>
</div>
<c:choose>
    <c:when test="true">
        <jsp:include page=""/>
    </c:when>
    <c:when test="false">
        <jsp:include page=""/>
    </c:when>
    <c:when test="false">
        <jsp:include page=""/>
    </c:when>
    <c:when test="false">
        <jsp:include page=""/>
    </c:when>
</c:choose>