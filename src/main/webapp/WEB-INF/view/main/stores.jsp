<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%-- 스크롤 방식 사진 회전 --%>
<div>

</div>


<div id="storesWrapper">
<%--wrapper--%>
<div id="stores">
<c:forEach begin="1" end="5">
<%--  <div id="storesLine">--%>
  <%--4줄씩 infinity or 3줄씩 infinity--%>
  <c:forEach begin="1" end="3">
    <jsp:include page="store.jsp">
      <jsp:param name="" value=""/>
    </jsp:include>
  </c:forEach>
</c:forEach>
<%--  </div>--%>
</div>
</div>

