<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/25
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
    $(function () {
       $.messager.progress('close');

        $('#form').form({
            url : '${pageContext.request.contextPath}/careController/add',
            onSubmit : function() {
//                editor.sync();
                $.messager.progress({
                    title : '提示',
                    text : '数据处理中，请稍后....'
                });
                var isValid = $(this).form('validate');
                if (!isValid) {
                    $.messager.progress('close');
                }
                return isValid;
            },
            success : function(result) {
                $.messager.progress('close');
                result = $.parseJSON(result);
                if (result.success) {
                    $.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
                    $.modalDialog.handler.dialog('close');
                } else {
                    $.messager.alert('错误', result.msg, 'error');
                }
            }
        });
    });
</script>
<div class="container-fluid">
    <div class="row" style="width: 98%;">
        <form class="form-horizontal" id="form" method="post">
            <div class="form-group" style="margin-top: 10px">
                <label for="inputId" class="col-sm-3 control-label">编号</label>
                <div class="col-sm-8">
                    <input type="text" name="id" class="form-control" value="${care.id}" readonly="readonly"
                           id="inputId">
                </div>
            </div>
            <div class="form-group">
                <label for="inputNamel3" class="col-sm-3 control-label">名称</label>
                <div class="col-sm-8">
                    <input type="text" name="name" class="form-control" id="inputNamel3">
                </div>
            </div>
            <div class="form-group">
                <label for="inputRemark3" class="col-sm-3 control-label">详细说明</label>
                <div class="col-sm-8">
                    <input type="text" name="remark" class="form-control" id="inputRemark3">
                </div>
            </div>
            <div class="form-group">
                <label for="inputCareType" class="col-sm-3 control-label">保养类型</label>
                <div class="col-sm-8">
                    <%--<input type="text" class="form-control" id="inputCareType">--%>
                        <select name="careTypeId" id="inputCareType" class="easyui-combobox"
                                data-options="width:170,height:29,editable:false,panelHeight:'auto'">
                            <option value=""></option>
                            <c:forEach items="${careTypeList}" var="careType">
                                <option
                                        value="${careType.id}">${careType.name}</option>
                            </c:forEach>
                        </select>
                </div>
            </div>
        </form>
    </div>
</div>
