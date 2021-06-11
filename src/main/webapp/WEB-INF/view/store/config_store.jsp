<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="myStore">
  <form method="post" action="./mystore" enctype="multipart/form-data">
    가게이름<input type="text" placeholder="가게이름" name="s_name" value="${storeInfo.s_name}"><br>
    가게위치<input type="text" placeholder="가게위치" name="s_loc" value="${storeInfo.s_loc}"><br>
    오픈시간<input type="text" placeholder="오픈시간" name="s_time" value="${storeInfo.s_time}"><br>
    가게소개<input type="text" placeholder="가게소개" name="s_ctnt" value="${storeInfo.s_ctnt}"><br>
    가게사진<input type="file" accept="image/*" id="file-input">
<%--    여기에 이미지가 뿅 하고 나옴--%>
    <div class="result"></div>
    <img class="cropped" src="" alt="">
    <input type="hidden" name="u_pk" value="${u_pk}">
    <input type="submit" value="등록하기">
  </form>
</div>

<script defer src="/js/config_store.js"></script>
