<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/24
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<c:set var="basePath" value="${pageContext.request.contextPath}"/>--%>
<%

    String path = request.getContextPath();
    String base=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    System.out.println(base);
%>

<html>
<head>
    <title>首页</title>
    <%--<base href="<%=basePath%>">--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="inccss.jsp"></jsp:include>
    <script type="text/javascript">
        var basePath="";
    </script>
</head>
<body class="hold-transition skin-blue layout-boxed sidebar-mini">

<%--隐藏basePath值--%>
<input id="basePath" type="hidden" value="<%=base%>" /><%--隐藏basePath值--%>
<!-- Site wrapper -->
<div class="wrapper">

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


</body>
</html>

<script type="text/javascript">

</script>


<jsp:include page="inc.jsp"></jsp:include>
<%-- iCheck样式 --%>
<script type="text/javascript">
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>


<%--改boxed为fixed--%>
<script type="text/javascript">
    function fixed() {
        $("body").removeClass("layout-boxed").addClass("fixed");
    }
</script>


