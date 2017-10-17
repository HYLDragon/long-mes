<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/8
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
    $(function () {
        $("#pg").propertygrid({
            url:'${pageContext.request.contextPath}/careController/propertyGrid',
            showGroup:true,
            scrollbarSize:0
        })
    });
</script>
<div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12 col-sm-12">
                <table id="pg"></table>
            </div>
        </div>
        <%--<div class="row">--%>
            <%--<div class="col-md-6 col-sm-6">--%>

            <%--</div>--%>
        <%--</div>--%>
    </div>
</div>
