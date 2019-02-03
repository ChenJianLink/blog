<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<script type="text/javascript">
    function checkData() {
        var query = document.getElementById("query").value.trim();
        if (query == null || query == "") {
            alert("请输入您要查询的关键字！");
            return false;
        } else {
            return true;
        }
    }
</script>
<div class="row">
    <div class="col-md-12" style="padding-top: 10px">
        <nav class="navbar" style="background-color: rgba(192,192,192, 0.7);border-color: rgba(192,192,192, 1)">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.html"><font
                            color="black"><strong>首页</strong></font></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"
                     style="background-color: rgba(255,255,255,0)">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/blogger/aboutMe.html"><font
                                color="black" size="3"><strong>关于Master</strong></font></a></li>
                    </ul>
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/message/leavemessages.html"><font
                                color="black" size="3"><strong>游客留言</strong></font></a></li>
                    </ul>
                    <form action="${pageContext.request.contextPath}/blog/query.html" class="navbar-form navbar-right"
                          role="search" method="post" onsubmit="return checkData()">
                        <div class="form-group">
                            <input type="text" id="query" name="query" value="${query }" class="form-control"
                                   placeholder="请输入要查询的关键字...">
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>
</div>