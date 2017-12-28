
$(function() {
	// 触发事件获取数据并分页(防抖)
	$('#btnClick').click(function() {
	    debounce(getCurrGroupUsers, null, 350, [1, 10]);
	});
})

var getCurrGroupUsers = function(currPage, pageSize) {
    var curr = curr || 1;
    var pageSize = pageSize || 10;
    // 请求后台数据
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8030/girls/queryAllGirls',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
            currPage: curr,
            pageSize: pageSize,
        }),
        dataType: 'json'
    }).error(function(err) {
        console.log(err);
    }).success(function(data) {
        // do something...
    	var htm = '';
    	$.each(data.girlsList, function(index, item) {
    		htm += "<tr>" +
    					"<td>"+ item.id +"</td>" +
    					"<td>"+ item.age +"</td>" +
    					"<td>"+ item.cup +"</td>" +
    					"<td>"+ item.name +"</td>" +
    					"<td>"+ item.grade +"</td>" +
    				"</tr>";
    	})
    	$('#girlsData table tbody').html(htm);
        // 调用分页函数, data.totalPage 是数查询据库后返回的总页数
    	var params = [curr, pageSize, data.allRecords, data.totalPage, getCurrGroupUsers];
        pagingHandler.apply(null, params);
    });
}

var pagingHandler = function(curr, pageSize, allRecords, totalPage, callBack) {
	console.log("arguments[2]= "+ arguments[3]);
	layui.use(['laypage'], function() {
		layui.laypage.render({
	    	elem: 'pageCont',
	        curr: curr || 1,
	        count: allRecords,
	        pages: totalPage,
	        limit: 10,
	        limits: [10, 20, 30],
	        groups: 3,
	        theme: '#666',
	        skip: true,
	        layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
	        jump: function(_, first) {
	            // _ 包含了当前分页的所有参数
	            console.dir(_); //得到当前页，以便向服务端请求对应页的数据。
	            console.log(_.curr); //得到每页显示的条数
	            if (!first) {
	                callBack(_.curr, pageSize);
	            }
	        }
	    });
	})
}

// 防多次操作函数
var debounce = function(fn, context, delay, param) {
    clearTimeout(fn.timer);
    fn.timer = setTimeout(function() {
        if(Object.prototype.toString.call(param) === '[object Array]') {
            fn.apply(context, param);
        } else {
            fn.call(context, param);
        }
    }, delay || 400);
}
