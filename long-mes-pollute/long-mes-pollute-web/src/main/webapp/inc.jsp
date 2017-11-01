<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%--<!-- jQuery 3 将其放在incss.jsp中-->--%>
<%--<script src="${basePath}/jslib/bower_components/jquery/dist/jquery.min.js"></script>--%>
<!-- jQuery UI 1.11.4 -->
<script src="${basePath}/jslib/bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>

<!-- Morris.js charts -->
<script src="${basePath}/jslib/bower_components/raphael/raphael.min.js"></script>
<script src="${basePath}/jslib/bower_components/morris.js/morris.min.js"></script>
<!-- Sparkline -->
<script src="${basePath}/jslib/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="${basePath}/jslib/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${basePath}/jslib/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="${basePath}/jslib/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="${basePath}/jslib/bower_components/moment/min/moment.min.js"></script>
<script src="${basePath}/jslib/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="${basePath}/jslib/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="${basePath}/jslib/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="${basePath}/jslib/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${basePath}/jslib/bower_components/fastclick/lib/fastclick.js"></script>

<!-- iCheck -->
<script src="${basePath}/jslib/plugins/iCheck/icheck.min.js"></script>
<!-- DataTables -->
<script src="${basePath}/jslib/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${basePath}/jslib/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

<script src="${basePath}/jslib/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes(首页初使化时需要) -->
<script src="${basePath}/jslib/dist/js/demo.js"></script>
