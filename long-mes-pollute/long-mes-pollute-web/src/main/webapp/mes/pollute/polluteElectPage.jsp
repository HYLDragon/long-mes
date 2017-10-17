<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/21
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <jsp:include page="../../inc.jsp"></jsp:include>
    <jsp:include page="../../inccss.jsp"></jsp:include>
    <jsp:include page="../../incjs.jsp"></jsp:include>
    <style type="text/css">
        <%--flot--%>
        .demo-placeholder {
            height: 220px
        }
        .row{
            margin-top: 10px;
        }
        /*iCheck样式*/
        ul.to_do {
            padding: 0
        }
        ul.to_do li {
            background: #f3f3f3;
            border-radius: 3px;
            position: relative;
            padding: 7px;
            margin-bottom: 5px;
            list-style: none
        }
        ul.to_do p {
            margin: 0
        }
        /*iCheck样式*/


    </style>
    <title>电力记录</title>
    <script type="text/javascript">
        //init_flot_chart

        var randNum = function() {
            return (Math.floor(Math.random() * (1 + 40 - 20))) + 20;
        };
        function gd(year, month, day) {
            return new Date(year, month - 1, day).getTime();
        }

        function init_flot_chart(){

            if( typeof ($.plot) === 'undefined'){ return; }
            console.log('init_flot_chart');

            var arr_data1 = [
                [gd(2017, 1, 1), 17],
                [gd(2017, 1, 2), 74],
                [gd(2017, 1, 3), 6],
                [gd(2017, 1, 4), 39],
                [gd(2017, 1, 5), 20],
                [gd(2017, 1, 6), 85],
                [gd(2017, 1, 7), 7],
                [gd(2017, 1, 8), 19],
                [gd(2017, 1, 9), 25],
                [gd(2017, 1, 10), 74],
                [gd(2017, 1, 11), 6],
                [gd(2017, 1, 12), 39],
                [gd(2017, 1, 13), 20],
                [gd(2017, 1, 14), 85],
                [gd(2017, 1, 15), 25],
                [gd(2017, 1, 16), 55],
            ];

            var arr_data2 = [
                [gd(2017, 1, 1), 82],
                [gd(2017, 1, 2), 23],
                [gd(2017, 1, 3), 66],
                [gd(2017, 1, 4), 9],
                [gd(2017, 1, 5), 119],
                [gd(2017, 1, 6), 6],
                [gd(2017, 1, 7), 9],
                [gd(2017, 1, 8), 12],
                [gd(2017, 1, 9), 30]
            ];

            var chart_plot_01_settings = {
                series: {
                    lines: {
                        show: false,
                        fill: true
                    },
                    splines: {
                        show: true,
                        tension: 0.4,
                        lineWidth: 1,
                        fill: 0.4
                    },
                    points: {
                        radius: 0,
                        show: true
                    },
                    shadowSize: 2
                },
                grid: {
                    verticalLines: true,
                    hoverable: true,
                    clickable: true,
                    tickColor: "#d5d5d5",
                    borderWidth: 1,
                    color: '#fff'
                },
                colors: ["rgba(38, 185, 154, 0.38)", "rgba(3, 88, 106, 0.38)"],
                xaxis: {
                    tickColor: "rgba(51, 51, 51, 0.06)",
                    mode: "time",
                    tickSize: [1, "day"],
                    //tickLength: 10,
                    axisLabel: "Date",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 10,
                    color:"rgba(169, 68, 66, 0.8)",
                    timeformat: "%m/%d"
                },
                legend: {
                    color:"rgba(169, 68, 66, 0.8)",
                    backgroundColor:"rgba(230, 230, 230, 0.8)"
                },
                yaxis: {
                    ticks: 8,
                    tickColor: "rgba(51, 51, 51, 0.06)",
                },
                tooltip: true
            };

            if ($("#chart_plot_01").length){
                $.plot( $("#chart_plot_01"), [ arr_data1 ],  chart_plot_01_settings );
//                $.plot( $("#chart_plot_01"), [ {data:arr_data1,label:"本月"}, {data:arr_data2,label:"上月"} ],
//                    chart_plot_01_settings );
//                $.plot( $("#chart_plot_01"), [ {data:arr_data1,label:"本月"} ],
//                    chart_plot_01_settings );
            }
            
//            https://github.com/flot/flot/blob/master/API.md
        }
        
        $(function () {
            $("<div id='tooltip'></div>").css({
                position: "absolute",
                display: "none",
                border: "1px solid #fdd",
                padding: "2px",
                "background-color": "#fee",
                opacity: 0.80
            }).appendTo("body");

            $("#chart_plot_01").bind("plothover", function (event, pos, item) {
                if ($("#enablePosition:checked").length > 0) {
                    //将字符串转换成数字
                    var str = "(" +  new Date(pos.x.toFixed(2)*1).format("yyyy-MM-dd") + ", " + pos.y.toFixed(2) + ")";
                    $("#hoverdata").text(str);
                }

                if ($("#enableTooltip:checked").length > 0) {
                    if (item) {
                        var x = item.datapoint[0].toFixed(2),
                            y = item.datapoint[1].toFixed(2);

                        $("#tooltip").html(item.series.label + " " + new Date(x*1).format("yyyy-MM-dd") + "  " + y)
                            .css({top: item.pageY+5, left: item.pageX+5})
                            .fadeIn(200);
                    } else {
                        $("#tooltip").hide();
                    }
                }
            });
        });

    </script>

    <%--float 标准写法--%>
    <script type="text/javascript">
        var init_bar_flot=function () {
            var data = [ ["1月", 10], ["2月", 8], ["3月", 40], ["4月", 13], ["5月", 17], ["6月", 9],["7月", 10], ["8月", 3],
                ["9月",
                    4], ["10月", 13], ["11月", 12], ["12月", 9] ];

            $.plot("#bar_flot", [ data ], {
                series: {
                    bars: {
                        show: true,
                        barWidth: 0.6,
                        align: "center"
                    }
                },
                xaxis: {
                    mode: "categories",
                    tickLength: 0
                }
            });
        };

        $(function() {
            init_bar_flot();

        });


    </script>

    <%--iCheck--%>
    <script type="text/javascript">
        $(function(){
            if ($("input.flat")[0]) {
                $(document).ready(function () {
                    $('input.flat').iCheck({
                        checkboxClass: 'icheckbox_flat-green',
                        radioClass: 'iradio_flat-green'
                    });
                });
            }
        });
    </script>

    <script>
        $(function () {
            init_flot_chart();
        });
    </script>
    <%--对easyui的一些控件添加一些事件--%>
    <script type="text/javascript">
        <%--
        $(target).combo("setText","");
        --%>
        $(function () {
            var buttons = $.extend([], $.fn.datebox.defaults.buttons);
            buttons.splice(1, 0, {
                text: '确定',
                handler: function(target){
                    //console.log(target);
                    var calendar=$(target).datetimebox("calendar");
                    var date=calendar.calendar("options").current;
                    var spinner=$(target).datetimebox("spinner");

                    var hour="0"+spinner.timespinner("getHours");
                    var minute="0"+spinner.timespinner("getMinutes");
                    var seconds="0"+spinner.timespinner("getSeconds");
                    var hhmmss=hour.right(2)+":"+minute.right(2)+":"+seconds.right(2);
//                    $(target).combo("setText",new Date(date).format("yyyy-MM-dd")+" "+hhmmss);
                    $(target).combo("setText",new Date(date).format("yyyy-MM-dd"));
                    $(target).combo("hidePanel");

                    alert("一切正常再做一些事");

                }
            });
            $('#dayFlot').datebox({
                buttons: buttons
            });
        });
    </script>
</head>
<body>
    <div id="main-col" class="container-fluid">
        <div class="row">
            <div class="col-md-9 col-sm-9">
                <div id="chart_plot_01" class="demo-placeholder"></div>
            </div>
            <div class="col-md-3 col-sm-3">
                <ul class="to_do">
                    <li>
                        <p><input type="checkbox" id="enablePosition" checked="checked" class="flat"> 显示鼠标所在位置<span
                                id="hoverdata">(时间,
                            用电量)</span></p>
                    </li>
                    <li>
                        <p><input type="checkbox" id="enableTooltip" checked="checked" class="flat"> 是否提示数值</p>
                    </li>
                    <li>
                        <p><input id="dayFlot" class="easyui-datetimebox" style="width:100%"></p>
                    </li>
              </ul>
            </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-9 col-sm-9">
                <div id="bar_flot" class="demo-placeholder"></div>
            </div>
            <div class="col-md-3 col-sm-3"></div>
        </div>
    </div>
</body>
</html>
