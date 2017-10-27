<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- jQuery 3 -->
<script src="${basePath}/jslib/bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="${basePath}/jslib/bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="${basePath}/jslib/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
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
<!-- AdminLTE App -->
<script src="${basePath}/jslib/dist/js/adminlte.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="${basePath}/jslib/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${basePath}/jslib/dist/js/demo.js"></script>
<!-- iCheck -->
<script src="${basePath}/jslib/plugins/iCheck/icheck.min.js"></script>

<script src="${basePath}/commonJS/base.js"></script>
<script src="${basePath}/commonJS/menu.js"></script>
<script src="${basePath}/commonJS/image.js"></script>

<!-- ChartJS -->
<%--<script src="${pageContext.request.contextPath}/jslib/bower_components/Chart.js/Chart.js"></script>--%>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<%--<script src="${pageContext.request.contextPath}/jslib/dist/js/pages/dashboard2.js"></script>--%>