<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="/css/head.css">
    <link rel="stylesheet" href="/css/stores.css">
    <script defer src="/js/errorControl.js"></script>
</head>
<body>
    <input id="errCode" type="hidden" value="${errCode}">
    <jsp:include page="./module/head.jsp"/>

    <jsp:include page=".${page}.jsp"/>

    <jsp:include page="./module/foot.jsp"/>
</body>
</html>