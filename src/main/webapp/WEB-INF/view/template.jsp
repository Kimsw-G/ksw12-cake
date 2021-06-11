<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="/css/head.css">
    <link rel="stylesheet" href="/css/stores.css">
    <link rel="stylesheet" href="/css/store.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer">
    <script defer src="/js/errorControl.js"></script>
</head>
<body>
    <input id="errCode" type="hidden" value="${errCode}">
    <jsp:include page="./module/head.jsp"/>

    <jsp:include page=".${page}.jsp"/>

    <jsp:include page="./module/foot.jsp"/>
</body>
</html>