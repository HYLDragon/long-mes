
//使用jquery(所以得加载jquery之后才能使用)
var menu=function (url) {
    $.ajax({ url: "${pageContext.request.contextPath}/json/test2.json",
        type: "GET",
        context: document.body, // 当响应对应的状态码时，执行对应的回调函数
        dataType: "json", // 返回JSON格式的数据
        async: false, // 同步请求，发送请求后浏览器将被锁定，只有等到该请求完成(无论成功或失败)后，用户才能操作，js代码才会继续执行
        statusCode: {
            404: function() {
                alert( "找不到页面" );
            },
            200: function(){
                alert("请求成功");
            }
        },
        success: function(data, textStatus, jqXHR){
            // 假设返回的字符串数据为{ "name": "CodePlayer", age: 20 }
            // jQuery已帮我们将该JSON字符串转换为对应的JS对象，可以直接使用
            //在此解析数据

            //第一步:将所有顶级目录显示


            //第二步:所有的子级目录

        },
        // 请求失败时执行
         error: function(jqXHR, textStatus, errorMsg){
        // jqXHR 是经过jQuery封装的XMLHttpRequest对象
        // textStatus 可能为： null、"timeout"、"error"、"abort"或"parsererror"
        // errorMsg 可能为： "Not Found"、"Internal Server Error"等
        alert("请求失败：" + errorMsg);
    }
    });
};
