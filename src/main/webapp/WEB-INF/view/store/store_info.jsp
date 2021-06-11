<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="store_info_wrapper">
    <div id="store_info_img">
        <div id="img_1" style="background-image: url('/img/${store.s_pk}/main.jpg') ">
        </div>
        <div id="img_2">
            <div id="img_2_1">
                <div>

                </div>
                <div>

                </div>
                <div>

                </div>
            </div>
            <div id="img_2_2">

            </div>
        </div>
    </div>
    <div id="store_info_ctnt">
        <div>${store.s_name}</div>
        <div>${store.s_loc}</div>
        <div>${store.s_time}</div>
        <div>${store.s_ctnt}</div>
    </div>
</div>