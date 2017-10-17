<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/18
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
    function addTab(params) {
        var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:98%;"></iframe>';
        var t = $('#pollutePage_tabs');
        var opts = {
            title : params.title,
            closable : true,
            iconCls : params.iconCls,
            content : iframe,
            border : false,
            fit : true
        };
        if (t.tabs('exists', opts.title)) {
            t.tabs('select', opts.title);
            parent.$.messager.progress('close');
        } else {
            t.tabs('add', opts);
        }
    }
</script>

<script type="text/javascript">
    <%--先取消掉progress--%>
    $(function () {
        parent.$.messager.progress('close');
    });

</script>
<%--操作本页面--%>
<script type="text/javascript">
    $(function () {
        var $pollutePage_layout=$('#pollutePage_layout');
        $pollutePage_layout.find('li').each(function () {
            var $li=$(this);
            $li.click(function () {
//                console.log($li);
//                console.log($li.find('a').attr('_href'));
                addTab({
                    url:'${pageContext.request.contextPath}'+$li.find('a').attr('_href'),
                    title:$li.find('a').text(),
                    iconCls:''
                });
            });
        });
    });
</script>

<div id="pollutePage_layout" class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'west',title:'除臭菜单',split:true" style="width:170px;">
        <ul class="nav nav-pills  nav-stacked"> <%--<li role="presentation"><a _href="#1">首页</a></li>--%>
            <li role="presentation"><a _href="/polluteController/polluteElectPage">电表记录</a></li>
            <%--<li role="presentation"><a _href="/polluteController/polluteVpPage">VP香片更换记录</a></li>--%>
            <%--<li role="presentation"><a _href="/polluteController/polluteFanPage">风机机油添加记录</a></li>--%>
            <%--<li role="presentation"><a _href="/polluteController/polluteStrainerPage">除尘设备滤网更换记录</a></li>--%>
            <%--<li role="presentation"><a _href="/polluteController/polluteUvPage">UV前置滤网更换记录</a></li>--%>

            <li role="presentation"><a _href="/polluteController/polluteCarePage">保养记录</a></li>
        </ul>
    </div>
    <div data-options="region:'center',title:'主面板'" style="padding:5px;background:#eee;">
        <div id="pollutePage_tabs" class="easyui-tabs" data-options="fit:true,border:false">

        </div>
    </div>
</div>

