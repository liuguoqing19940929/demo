/**
 * 列表基本增删查改方法
 * @author Administrator
 */
        //新增方法，page弹出页面，w页面宽度，h页面高度
        function add(page,w,h) {
            
            mini.open({
                url: bootPATH + "../subpage/popupMenu/"+page,
                title: "新增", width:w, height:h,
                onload: function () {
                    var iframe = this.getIFrameEl();
                    var data = { action: "new"};
                    iframe.contentWindow.SetData(data);
                },
                ondestroy: function (action) {
                    grid.reload();
                }
            });
        }
		//修改方法，page弹出页面，w页面宽度，h页面高度
        function edit(page,w,h) {
         
            var row = grid.getSelected();
            if (row) {
                mini.open({
                    url: bootPATH + "../subpage/popupMenu/"+page,
                    title: "修改信息", width:w, height: h,
                    onload: function () {
                        var iframe = this.getIFrameEl();
                        var data = { action: "edit", id: row.id };
                        iframe.contentWindow.SetData(data);                    
                    },
                    ondestroy: function (action) {
                        grid.reload();                      
                    }
                });             
            } else {
                alert("请选中一条记录");
            }
            
        }
        function remove(table) {
            
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
                if (confirm("确定删除选中记录？")) {
                    var ids = [];
                    for (var i = 0, l = rows.length; i < l; i++) {
                        var r = rows[i];
                        ids.push(r.id);
                    }
                    var id = ids.join(',');
                    grid.loading("操作中，请稍后......");
                    $.ajax({
                        url: "Basedelete?table="+table+"&data="+id,
                        success: function (text) {
                            grid.reload();
                        },
                        error: function () {
                        }
                    });
                }
            } else {
                alert("请选中一条记录");
            }
        }
		//查看方法，page弹出页面,w页面宽度，h页面高度
		function view(page,w,h) {
         
            var row = grid.getSelected();
            if (row) {
                mini.open({
                    url: bootPATH + "../subpage/popupMenu/"+page,
                    title: "查看信息", width: w, height: h,
                    onload: function () {
                        var iframe = this.getIFrameEl();
                        var data = { action: "check", id: row.id };
                        iframe.contentWindow.SetData(data);                    
                    },
                    ondestroy: function (action) {
                        grid.reload();                      
                    }
                });             
            } else {
                alert("请选中一条记录");
            }
            
        }