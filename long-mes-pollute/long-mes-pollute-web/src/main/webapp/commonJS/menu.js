
function fn(data, pid) {
    var result = [];
    var temp;
    for (var i = 0; i < data.length; i++) {
        if (data[i].pid == pid) {
            var obj = {
                'text': data[i].text,
                'id': data[i].id,
                'iconCls':data[i].iconCls,
                'pid':data[i].pid,
                'url':data[i].attributes.url
            };

            temp = fn(data, data[i].id);
            if (temp.length > 0) {
                obj.children = temp;
            }
            result.push(obj);
        }
    }
    return result;
}
//
// "iconCls":"plugin",
//     "id":"xtgl",
//     "state":"open",
//     "text":"系统管理"


//menu_list为json数据
//parent为要组合成html的容器
//fa fa-share
function showall(menu_list, parent) {
    for (var menu in menu_list) {
        //如果有子节点，则遍历该子节点
        if (menu_list[menu].children!=undefined && menu_list[menu].children.length > 0) {
            //创建一个子节点li
            var li = $('<li class="treeview"></li>');

            var a=$('<a href="#">\n'+
                '<i class="fa fa-share"></i> <span>'+menu_list[menu].text+'</span>\n'+
                // '<i class="'+menu_list[menu].iconCls+'"></i> <span>'+menu_list[menu].text+'</span>\n'+
                ' <span class="pull-right-container">\n'+
                '<i class="fa fa-angle-left pull-right"></i>\n'+
                '</span></a>');

            li.append(a);
            //将li的文本设置好，并马上添加一个空白的ul子节点，并且将这个li添加到父亲节点中
            $(li).append('<ul class="treeview-menu"></ul>').appendTo(parent);
            //将空白的ul作为下一个递归遍历的父亲节点传入
            showall(menu_list[menu].children, $(li).children().eq(1));
        }
        //如果该节点没有子节点，则直接将该节点li以及文本创建好直接添加到父亲节点中
        else {
            $('<li><a href="#" data-url="'+menu_list[menu].url+'"><i class="fa fa-share"></i><span>'+menu_list[menu].text+'</span></a></li>').appendTo(parent);
            // $('<li><a href="#" data-url="'+menu_list[menu].url+'"><i class="'+menu_list[menu].iconCls+'"></i><span>'+menu_list[menu].text+'</span></a></li>').appendTo(parent);

        }
    }
}

var menu=function (url) {
    jQuery.ajax({
        type: 'get',
        async: true,
        url: url,
        dataType: 'json',
        //contentType : 'application/json',
        success: function (data, status) {
            //在此解析数据
            var jsonData=[];
            $.each(data,function (index,item) {
                if (item.pid==undefined ){
                    var p=item;
                    item.url=item.attributes.url;
                    var j=fn(data,item.id);
                    p.children=j;
                    jsonData.push(p);
                }
            });
            console.log(jsonData);
            showall(jsonData,$("ul.sidebar-menu"));
        },
        error: function (err, err1, err2) {
            console.log("ajaxPost发生异常，请仔细检查请求url是否正确，如下面错误信息中出现success，则表示csrftoken更新，请忽略");
            if (err1 == "parsererror") {//csrf异常
                var responseBody = err.responseText;
                if (responseBody) {
                    responseBody = "{'retData':" + responseBody;
                    var resJson = eval('(' + responseBody + ')');
                    // jQuery("#csrftoken").val(resJson.csrf.CSRFToken);
                    this.success(resJson.retData, 200);
                }

                return;
            }
        }
    });
};
