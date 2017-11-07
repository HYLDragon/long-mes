<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/3
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="../../inccss.jsp"></jsp:include>


<%--内容头(页面头部)--%>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Dashboard
        <small>Control panel</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">
    <!-- Main row -->
    <div class="row">
        <!-- Left col -->
        <section class="col-lg-12 connectedSortable">

            <!-- Table test -->
            <div class="box box-primary">
                <div class="box-header">
                    <i class="ion ion-clipboard"></i>

                    <h3 class="box-title">Table test</h3>

                    <div class="box-tools pull-right">
                        右边的buttons
                    </div>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <!-- See dist/js/pages/dashboard.js to activate the todoList plugin -->
                    <div class="domab">
                        <div style="float:right;">
                            <label>
                                模糊查询：
                                <input type="text" class="dsearch" placeholder="" aria-controls="example"></label>
                        </div>

                        <button id="button" style="float:left;">删除选中的行</button>
                        <div style="float:left; position:relative; z-index:9999;height:100%;">
                            <button class="showcol">列段显示/隐藏</button>
                            <ul class="showul"
                                style=" list-style:none;display:none; position:absolute; left:80px; top:10px; background:#FFFFFF; border:1px solid #ccc; width:200px;">
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="2"/>
                                    编号
                                </li>
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="3"/>
                                    名称
                                </li>
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="4"/>
                                    创建时间
                                </li>
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="5"/>
                                    保养类型ID
                                </li>
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="6"/>
                                    最后修改时间
                                </li>
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="7"/>
                                    保养类型ID
                                </li>
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="8"/>
                                    保养类型名称
                                </li>
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="9"/>
                                    保养详细说明
                                </li>

                            </ul>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                    <div id="div-table-container">
                        <table id="example" class="table table-striped table-hover" >

                        </table>
                    </div>
                </div>
                <!-- /.box-body -->
                <div class="box-footer clearfix no-border">
                    <button type="button" class="btn btn-default pull-right"><i class="fa fa-plus"></i> Add item</button>
                </div>
            </div>
            <!-- /.box -->

        </section>
        <!-- /.Left col -->
        <!-- right col (We are only adding the ID to make the widgets sortable)-->
        <!-- right col -->
    </div>
    <!-- /.row (main row) -->

</section>
<!-- /.content -->

<jsp:include page="../../inc.jsp"></jsp:include>

<script src="${basePath}/js/care-manage.js"></script>