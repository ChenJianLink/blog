<%--
  Created by IntelliJ IDEA.
  User: chenjian
  Date: 19-2-12
  Time: 下午12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="data_list">
    <div class="data_list_title">
        <img src="${pageContext.request.contextPath}/static/images/visiter.png"/>
        访客记录
    </div>
    <div style="padding-top: 10px;text-align: center">地球仪</div>
    <div style="padding-top: 10px;text-align: center">
        <script type="text/javascript"
                src="//ra.revolvermaps.com/0/0/1.js?i=0hng51tsgj2&amp;s=350&amp;m=7&amp;v=false&amp;r=false&amp;b=000000&amp;n=false&amp;c=ff0000"
                async="async"></script>
    </div>
    <div style="padding-top: 10px;text-align: center">世界地图:</div>
    <div style="padding-top: 10px;text-align: center;">
        <a href="https://www.revolvermaps.com/livestats/0xe1xtqrsrz/" target="_blank"><img
                src="//ra.revolvermaps.com/h/m/a/7/ff0000/256/0/0xe1xtqrsrz.png" width="512" height="256" alt="Map"
                style="border:0;"></a>
    </div>
    <div style="padding-top: 10px;text-align: center;">详细的访客信息请点击世界地图</div>
</div>


