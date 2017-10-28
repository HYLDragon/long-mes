<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/24
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>首页</title>
    <%--<base href="<%=basePath%>">--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="inccss.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue layout-boxed sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
    <%--隐藏basePath值--%>
    <input id="basePath" type="hidden" value="${pageContext.request.contextPath}" /><%--隐藏basePath值--%>
    <jsp:include page="/layout/main-header.jsp"></jsp:include>

    <!-- =============================================== -->
    <!-- Left side column. contains the sidebar -->
    <jsp:include page="layout/main-sidebar.jsp"></jsp:include>
    <!-- =============================================== -->
    <!-- Content Wrapper. Contains page content -->
    <%--<jsp:include page="layout/content-wrapper.jsp"></jsp:include>--%>


    <div  id="mainDiv" class="content-wrapper">

    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="layout/main-footer.jsp"></jsp:include>
    <!-- Control Sidebar -->
    <jsp:include page="layout/control-sidebar.jsp"></jsp:include>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<script type="text/javascript">
    var basePath="";
</script>


<jsp:include page="inc.jsp"></jsp:include>

</body>
</html>


<script type="text/javascript">
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
<script type="text/javascript">
    $(function () {
        basePath=$("#basePath").value;
    });


    $(function(){
        loadPage("http://localhost:8080/testController/homePage");
    });
</script>

<%--改boxed为fixed--%>
<script type="text/javascript">
    $(function () {
        console.log("jquery : " + $.fn.jquery);
    });

//为何有时行有时不行，是因为loadPage的时候，文档已加载完毕，这个时候执行ready中的函数
    // ，没有找到#btn 这个节点，导致点击无反应
//    $(document).ready(function(){
//        $("#btn").mousedown(function(){
//            console.log("点击");
//            menu("http://localhost:8080/json/test2.json");
//        });
//    });
    
    function fixed() {
        $("body").removeClass("layout-boxed").addClass("fixed");
    }
</script>
<%--http://www.cnblogs.com/hxhbluestar/archive/2011/11/17/2252009.htm--%>

