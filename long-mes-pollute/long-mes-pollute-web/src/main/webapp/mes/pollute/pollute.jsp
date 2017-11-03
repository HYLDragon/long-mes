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
                                    服务器名称
                                </li>
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="3"/>
                                    IP
                                </li>
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="4"/>
                                    CPU/内存
                                </li>
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="5"/>
                                    数据盘大小
                                </li>
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="6"/>
                                    操作系统
                                </li>
                                <li>
                                    <input type="checkbox" class="toggle-vis" data-column="7"/>
                                    状态
                                </li>
                            </ul>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                    <div>
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
<script type="text/javascript">

    //删除方法

    //  function del(id, name) {
    //      console.log("id,name"+id+" : "+name);
    //      $.ajax({
    //          url: "del.action",
    //          //在后台接受id这个参数
    //
    //          data: {
    //              id: id
    //          },
    //          success: function(data) {
    //              if (data.flag) {
    //                  //如果后台删除成功，则刷新表格，并提示用户删除成功
    //                  //保留分页信息
    //                  table.ajax.reload(null, false);
    //                  alert(name + data.msg);
    //              }
    //          }
    //      });
    //  }



    var del=function (id) {
        console.log("xxxx"+id);
    };

    var add=function (id) {
        console.log("xxxx"+id);
    };


    /**
     * @author
     *
     * 增加formatString功能
     *
     * 使用方法：fs('字符串{0}字符串{1}字符串','第一个变量','第二个变量');
     *
     * @returns 格式化后的字符串
     */
    var fs = function(str) {
        for ( var i = 0; i < arguments.length - 1; i++) {
            str = str.replace("{" + i + "}", arguments[i + 1]);
        }
        return str;
    };


    $(function () {

        var table = $('#example').DataTable({
            "dom": '<"top"f>rt<"bottom"lip><"clear">',//dom定位
            "dom": 'tiprl',//自定义显示项
            //"dom":'<"domab"f>',
//            "scrollY": "220px",//dt高度
            "ajax": "${pageContext.request.contextPath}/careController/dataTable",
            "serverSide": true,
            "columns":[
                {
                    "data": null,"width":"30",//此列不绑定数据源，用来显示序号
                    "title":"序号"
                },
                {
                    "data": null,width:"30" ,//此列不绑定数据源，用来显示选中框
                    "title":"<input type='checkbox' id='checkall' />"
                },
                {
                    "data": "id",
                    "title":"编号"
                },
                {
                    "data": "name",
                    "title":"名称"
                },
                {
                    "data": "createdatetime",
                    "title":"创建时间"
                },
                {
                    "data": "modifydatetime",
                    "title":"最后修改时间"
                },
                {
                    "data": "careTypeId",
                    "title":"保养类型ID"
                },
                {
                    "data": "careTypeName",
                    "title":"保养类型名称"
                },
                {
                    "data": "remark",
                    "title":"保养详细说明"
                },
                {
                    "data": null,
                    "title":"操作"
                }],
            "lengthMenu": [
                [8, 6, 8, -1],
                [4, 6, 8, "All"]
            ],//每页显示条数设置
            "lengthChange": false,//是否允许用户自定义显示数量
            "bPaginate": true, //翻页功能
            "bFilter": false, //列筛序功能
            "searching": true,//本地搜索
            "ordering": true, //排序功能
            "Info": true,//页脚信息
            "autoWidth": false,//自动宽度
            "oLanguage": {//国际语言转化
                "oAria": {
                    "sSortAscending": " - click/return to sort ascending",
                    "sSortDescending": " - click/return to sort descending"
                },
                "sLengthMenu": "显示 _MENU_ 记录",
                "sZeroRecords": "对不起，查询不到任何相关数据",
                "sEmptyTable": "未有相关数据",
                "sLoadingRecords": "正在加载数据-请等待...",
                "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
                "sInfoEmpty": "当前显示0到0条，共0条记录",
                "sInfoFiltered": "（数据库中共为 _MAX_ 条记录）",
                "sProcessing": "<img src='../resources/user_share/row_details/select2-spinner.gif'/> 正在加载数据...",
                "sSearch": "模糊查询：",
                "sUrl": "",
                //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": " 上一页 ",
                    "sNext": " 下一页 ",
                    "sLast": " 尾页 "
                }
            },
            "columnDefs": [
                {
                    "searchable": false,
                    "orderable": false,
                    "targets": 0
                },
                {
                    //   指定第一列，从0开始，0表示第一列，1表示第二列……
                    "searchable": false,
                    "orderable": false,
                    targets: 1,
                    render: function(data, type, row) {
                        return  '<input type="checkbox" name="checkList">';
                    }
                },//第一列与第二列禁止排序
                {
                    //   指定第最后一列

                    targets: 8,
                    "searchable": false,
                    "orderable": false,
                    render: function(data, type, row) {
                        var str = '';
                        str += fs('<a type="button" onclick="del(\'{0}\');">删除</a>',row.name);
                        str += '&nbsp;';
                        str += fs('<a type="button" onclick="add(\'{0}\');">添加</a>',row.name);
                        return str;
                    }
                }
            ],
            "order": [
                [0, null]
            ],//第一列排序图标改为默认
        });

        table.on('order.dt search.dt',
            function() {
                table.column(0, {
                    search: 'applied',
                    order: 'applied'
                }).nodes().each(function(cell, i) {
                    cell.innerHTML = i + 1;
                });
            }).draw();
        //自定义搜索
        $('.dsearch').on('keyup click', function () {
            var tsval = $(".dsearch").val()
            table.search(tsval, false, false).draw();
        });

        //checkbox全选
        $("#checkAll").on("click", function () {
            if ($(this).prop("checked") === true) {
                $("input[name='checkList']").prop("checked", $(this).prop("checked"));
                $('#example tbody tr').addClass('selected');
            } else {
                $("input[name='checkList']").prop("checked", false);
                $('#example tbody tr').removeClass('selected');
            }
        });

        //显示隐藏列
        $('.toggle-vis').on('change', function (e) {
            e.preventDefault();
            console.log($(this).attr('data-column'));
            var column = table.column($(this).attr('data-column'));
            column.visible(!column.visible());
        });

        //删除选中行
        $('#example tbody').on('click', 'tr input[name="checkList"]', function () {
            var $tr = $(this).parents('tr');
            $tr.toggleClass('selected');
            var $tmp = $('[name=checkList]:checkbox');
            $('#checkAll').prop('checked', $tmp.length == $tmp.filter(':checked').length);

        });

        $('#button').click(function () {
//            console.log(table.row('.selected').node());
//            console.log(table.row('.selected').data());//获得整行的数据
//            console.log(table.row('.selected').data().name);//获得整行的数据中的一列值
            table.row('.selected').remove().draw(false);
        });

        $('.showcol').click(function () {
            $('.showul').toggle();

        });
    });

</script>