<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--여기에서 메뉴 리스트들을 보여준다--%>

<div >
    <c:forEach items="${menuInfo}" var="menu">
        <div>
        ${menu.m_ctnt}
        </div>
        <c:forEach items="${menu.mp_pictures}" var="picture">
            <img src="/img/${menu.s_pk}/${menu.m_pk}/${picture.mp_picture}">
        </c:forEach>
    </c:forEach>
    <table>
        <tr>
            <th></th>
        </tr>
        <tr>
            <td><input type="text" name="m_ctnt"></td>
            <td><input type="file" name="files" accept="image/*" id="file-input" multiple></td>
        </tr>
    </table>
    <div id="plus">
        <i class="fas fa-plus-circle"></i>
    </div>
</div>