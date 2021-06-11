<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%-- 스크롤 방식 사진 회전 --%>
<div>

</div>


<div id="storesWrapper">
<%--wrapper--%>
<div id="stores">
<c:forEach items="${storeList}" var="store">
    <a href="/main/store?s_pk=${store.s_pk}">
        <div id="store">
                <%--    사진 넣을 공간    --%>
            <img id="storeImg" src="/img/${store.s_pk}/main.jpg">
                <%--    텍스트(#태그 등) 넣을 공간--%>
            <div id="storeText">
                    ${store.s_name}<br>
                    ${store.s_ctnt}
            </div>
        </div>
    </a>
</c:forEach>
</div>
</div>

