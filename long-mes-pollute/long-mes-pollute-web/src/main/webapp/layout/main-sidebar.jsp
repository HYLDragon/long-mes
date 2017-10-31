<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/24
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/jslib/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${sessionInfo.name}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线 </a>
            </div>
        </div>
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="搜索...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">导航菜单</li>

            <%--<li class="header">标签</li>--%>
            <%--<li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>--%>
            <%--<li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>--%>
            <%--<li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>--%>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

<script type="text/javascript">
    <%--登录--%>
    function loginFun() {


        <%--$.post('${pageContext.request.contextPath}/loginController/login', function(result) {--%>
            <%--if (result.success) {--%>
                <%--menu(basePath+"/resourceController/tree")--%>
                <%--&lt;%&ndash;loadPage("${pageContext.request.contextPath}/resourceController/tree");&ndash;%&gt;--%>
            <%--} else {--%>

            <%--}--%>
        <%--}, "JSON");--%>

        $.when( $.post('${pageContext.request.contextPath}/loginController/login', function(result) {
            if (result.success) {
                menu(basePath+"/resourceController/tree");
            } else {

            }
        }, "JSON")).done(function () {
            addClick();
        });

    }
    //  为菜单添加click事件
    function addClick() {


        $(".sidebar-menu").find("li:not(.header,.treeview)").each(function () {
            console.log($(this).find("a"));
            $(this).find("a").on('click',function (event) {
                console.log("thisxxxxx :"+this);
                var url=$(this).attr("data-url");
                loadPage(basePath+url);
            })
        });
    }
</script>

<script type="text/javascript">

    $(function () {
        basePath=$("#basePath").val();
        console.log("basePath: "+basePath);
        loginFun();

    });
</script>