<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

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

<script type="text/javascript">
    let isEnd = false;

    $(function(){
        $(window).scroll(function(){
            let $window = $(this);
            let scrollTop = $window.scrollTop();
            let windowHeight = $window.height();
            let documentHeight = $(document).height();

            console.log("documentHeight:" + documentHeight + " | scrollTop:" + scrollTop + " | windowHeight: " + windowHeight );

            // scrollbar의 thumb가 바닥 전 30px까지 도달 하면 리스트를 가져온다.
            if( scrollTop + windowHeight + 30 > documentHeight ){
                fetchList();
            }
        })
        fetchList();
    })

    let fetchList = function(){
        if(isEnd == true){
            return;
        }

        // 방명록 리스트를 가져올 때 시작 번호
        // renderList 함수에서 html 코드를 보면 <li> 태그에 data-no 속성이 있는 것을 알 수 있다.
        // ajax에서는 data- 속성의 값을 가져오기 위해 data() 함수를 제공.
        let startNo = $("#list-guestbook li").last().data("no") || 0;
        $.ajax({
            url:"/guestbook/api/guestbook/list?no=" + startNo ,
            type: "GET",
            dataType: "json",
            success: function(result){
                // 컨트롤러에서 가져온 방명록 리스트는 result.data에 담겨오도록 했다.
                // 남은 데이터가 5개 이하일 경우 무한 스크롤 종료
                let length = result.data.length;
                if( length < 5 ){
                    isEnd = true;
                }
                $.each(result.data, function(index, vo){
                    renderList(false, vo);
                })
            }
        });
    }

    let renderList = function(mode, vo){
        // 리스트 html을 정의
        let html = "<li data-no='"+ vo.no +"'>" +
            "<strong>"+ vo.name +"</strong>" +
            "<p>"+ vo.content.replace(/\n/gi, "<br>") +"</p>" +
            "<strong></strong>" +
            "<a href='#' data-no='"+ vo.no +"'>삭제</a>" +
            "</li>"

        if( mode ){
            $("#list-guestbook").prepend(html);
        }
        else{
            $("#list-guestbook").append(html);
        }
    }
</script>
