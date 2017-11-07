$(function (){
	var $wrapper = $('#div-table-container');//遮罩
	var $_table = $('#example');
	
	var table = $_table.dataTable($.extend(true,{},CONSTANT.DATA_TABLES.DEFAULT_OPTION, {
		ajax : function(data, callback, settings) {//ajax配置为function,手动调用异步查询
			//手动控制遮罩
			$wrapper.spinModal();
			//封装请求参数
			var param = userManage.getQueryCondition(data);
			$.ajax({
		            type: "GET",
		            url: basePath+"/careController/dataTable",
		            cache : false,	//禁用缓存
		            data: param,	//传入已封装的参数
		            dataType: "json",
		            success: function(result) {
		            	//setTimeout仅为测试遮罩效果
		            	setTimeout(function(){
		            		//异常判断与处理
		            		if (result.errorCode) {
		            			// $.dialog.alert("查询失败。错误码："+result.errorCode);
		            			console.log("查询失败。错误码："+result.errorCode);
		            			return;
							}
		            		
		            		//封装返回数据，这里仅演示了修改属性名
		            		var returnData = {};
			            	returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
			            	returnData.recordsTotal = result.recordsTotal;
			            	returnData.recordsFiltered = result.recordsFiltered;//后台不实现过滤功能，每次查询均视作全部结果
			            	returnData.data = result.data;
			            	//关闭遮罩
			            	$wrapper.spinModal(false);
			            	//调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
			            	//此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
			            	callback(returnData);
		            	},100);
		            },
		            error: function(XMLHttpRequest, textStatus, errorThrown) {
		                // $.dialog.alert("查询失败");
		                $wrapper.spinModal(false);
		            }
		        });
		},
        columns: [
            CONSTANT.DATA_TABLES.COLUMN.LINENO,
            CONSTANT.DATA_TABLES.COLUMN.CHECKBOX,
            {
            	className : "ellipsis",	//文字过长时用省略号显示，CSS实现
            	data: "id",
                "title":"编号",
            	render : CONSTANT.DATA_TABLES.RENDER.ELLIPSIS,//会显示省略号的列，需要用title属性实现划过时显示全部文本的效果
            },
            {
            	className : "ellipsis",	
            	data: "name",
                "title":"名称",
            	render : CONSTANT.DATA_TABLES.RENDER.ELLIPSIS,
            	//固定列宽，但至少留下一个活动列不要固定宽度，让表格自行调整。不要将所有列都指定列宽，否则页面伸缩时所有列都会随之按比例伸缩。
				//切记设置table样式为table-layout:fixed; 否则列宽不会强制为指定宽度，也不会出现省略号。
                "defaultContent":""
            },
			{
				data : "createdatetime",
                "title":"创建时间",
                "defaultContent":""
			},
			{
				data : "modifydatetime",
                "title":"最后修改时间",
                "defaultContent":""
			},
            {
                "data": "careTypeId",
                "title":"保养类型ID",
                "defaultContent":""
            },
            {
                "data": "careTypeName",
                "title":"保养类型名称",
                "defaultContent":""
            },
            {
                "data": "remark",
                "title":"保养详细说明",
                "defaultContent":""
            },
			{
				className : "td-operation",
				data: null,
                "title":"操作",
				defaultContent:"",
				orderable : false,
				width : "120px",
                render: function(data, type, row) {
                    var str = '';
                    str += fs('<a type="button" onclick="del(\'{0}\');">删除</a>',row.name);
                    str += '&nbsp;';
                    str += fs('<a type="button" onclick="add(\'{0}\');">添加</a>',row.name);
                    return str;
                }
			}
        ],
        "createdRow": function ( row, data, index ) {
            // //行渲染回调,在这里可以对该行dom元素进行任何操作
            // //给当前行加样式
            // if (data.role) {
        		// $(row).addClass("info");
            // }
            // //给当前行某列加样式
            // $('td', row).eq(3).addClass(data.status?"text-success":"text-error");
            // //不使用render，改用jquery文档操作呈现单元格
            // var $btnEdit = $('<button type="button" class="btn btn-small btn-primary btn-edit">修改</button>');
            // var $btnDel = $('<button type="button" class="btn btn-small btn-danger btn-del">删除</button>');
            // $('td', row).eq(5).append($btnEdit).append($btnDel);
            
        },
        "drawCallback": function( settings ) {
        	//渲染完毕后的回调
        	// //清空全选状态
            // $(":checkbox[name='cb-check-all']",$wrapper).prop('checked', false);
        	// //默认选中第一行
        	// $("tbody tr",$table).eq(0).click();
        }
	})).api();//此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象

    table.on('draw.dt',function() {
        table.column(0, {
            search: 'applied',
            order: 'applied'
        }).nodes().each(function(cell, i) {
            //i 从0开始，所以这里先加1
            i = i+1;
            //服务器模式下获取分页信息，使用 DT 提供的 API 直接获取分页信息
            var page = table.page.info();
            //当前第几页，从0开始
            var pageno = page.page;
            //每页数据
            var length = page.length;
            //行号等于 页数*每页数据长度+行号
            var columnIndex = (i+pageno*length);
            cell.innerHTML = columnIndex;
        });
    });
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

var userManage = {
	currentItem : null,
	fuzzySearch : true,
	getQueryCondition : function(data) {
		var param = {};
		//组装排序参数
		if (data.order&&data.order.length&&data.order[0]) {
			switch (data.order[0].column) {
			case 1:
				param.orderColumn = "name";
				break;
			case 2:
				param.orderColumn = "createdatetime";
				break;
			case 3:
				param.orderColumn = "modifydatetime";
				break;
			case 4:
				param.orderColumn = "careTypeName";
				break;
			default:
				param.orderColumn = "name";
				break;
			}
			param.orderDir = data.order[0].dir;
		}
		//组装查询参数
		// param.fuzzySearch = userManage.fuzzySearch;
		// if (userManage.fuzzySearch) {
		// 	param.fuzzy = $("#fuzzy-search").val();
		// }else{
		// 	param.name = $("#name-search").val();
		// 	param.position = $("#position-search").val();
		// 	param.office = $("#office-search").val();
		// 	param.extn = $("#extn-search").val();
		// 	param.status = $("#status-search").val();
		// 	param.role = $("#role-search").val();
		// }
        param.name = $("#name-search").val();
        param.createdatetime = $("#position-search").val();
        param.modifydatetime = $("#office-search").val();
        param.careTypeName = $("#extn-search").val();

		//组装分页参数
		param.startIndex = data.start;
		param.pageSize = data.length;

		param.draw = data.draw;

		return param;
	}
};
var del=function (id) {
    console.log("xxxx"+id);
};

var add=function (id) {
    console.log("addddddd"+id);
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