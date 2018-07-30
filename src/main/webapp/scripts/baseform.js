/**
 * 表单公用方法
 * @author Administrator
 */
  //保存方法，table为表名
        function SaveData() {
            var o = form.getData(true);  //getData()返回对象，true参数一定要有，否则日期字符串传输会出现差错，       
			 form.validate();
            if (form.isValid() == false) return;
			var json = mini.encode(o);
            $.ajax({
                url: saveURL,
                data: {table:maintable,data: json },
				type:"POST",
                cache: false,
                success: function (text) {
                    CloseWindow("save");
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                    CloseWindow();
                }
            });
        }

        ////////////////////
        //标准方法接口定义，用来初始化表单数据
        function SetData(data) {
            if (data.action == "edit") {
                //跨页面传递的数据对象，克隆后才可以安全使用
                data = mini.clone(data);
                $.ajax({
                    url: editUrl,
                    cache: false,
					data:{table:maintable,data:data.id},
					type:"POST",
                    success: function (text) {//text为对象
                        form.setData(text);//ajxa返回text为js对象，这里设置表单数据
                        form.setChanged(false);//表单加载完处理表单数据函数
						formhandler(text);//处理数据函数
                    }
                });
            }
			
			else if(data.action=="new"){
				var o = {"id":"0"};
				form.setData(o);
				buildhandler();//新建时候用于带数据的函数
			}
			else if(data.action=="check"){
				data = mini.clone(data);
                $.ajax({
                    url: checkUrl,
                    cache: false,
					data:{table:maintable,data:data.id},
					type:"POST",
                    success: function (text) {
                        form.setData(text);
                        //form.setEnabled(false);//如果动作方式为check，设置表单为只读
                        labelModel();
                        formhandler(text);//表单加载完处理表单数据函数
						mini.getbyName("submit").disable ();

                    }
                });
			}
        }

        function GetData() {
            var o = form.getData();
            return o;
        }
        function CloseWindow(action) {            
            if (action == "close" && form.isChanged()) {
                if (confirm("数据被修改了，是否先保存？")) {
                    return false;
                }
            }
            if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
            else window.close();            
        }

        //设置表单为只读
        function labelModel() {
            var fields = form.getFields();                
            for (var i = 0, l = fields.length; i < l; i++) {
                var c = fields[i];
                if (c.setReadOnly) c.setReadOnly(true);     //只读
                if (c.setIsValid) c.setIsValid(true);      //去除错误提示
                if (c.addCls) c.addCls("asLabel");          //增加asLabel外观
            }
        }
