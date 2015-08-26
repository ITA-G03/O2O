$(function() {
    $.post("../business/food/list",function(data) {
    	alert("............");
    		var tbody="";
    		for(var i=0;i<data.length;i++) {
    			var trs="<tr>";
    			trs+="<td id='foodid'>"+data[i].foodId+"</td>";
    			trs+="<td id='foodname'>"+data[i].foodName+"</td>";
    				var result;
    				$.ajax({
    					   url: "../getphoto",
    				       async: false,
    				        type: "GET",
    				       data: { picture:data[i].picture  },
    				       success: function (courseDT4) {
    				           result = courseDT4.message;
    				}	
    				});	
    			trs+="<td><image src='data:image/jpg;base64,"+result+"' width='200',height='100'/></td>"
    			
    			trs+="<td id='price'>"+data[i].price+"</td>";
    			trs+="<td><button type='button' class='btn btn-primary'  data-toggle='modal' data-target='#myModal' name='update'>update</button>&nbsp<button type='button' class='btn btn-warning' name='delete' onclick='return confirm()'>delete</button></td>";
    			trs+="</tr>"
    			tbody+=trs;
    		}
    		$("tbody").append(tbody);
    		
    		$("button[name=delete]").on("click",function() {
    			var ttr=$(this).parent().parent();
    			var foodId = $(this).parent().parent().children().eq(0).text();
    			$.get("../deletefood",{foodId:foodId},function(data) {
    				if(data.status=='1') {
    					ttr.remove();
    				}
    				
    			});	
    		});
    		
    		
    		$("button[name=update]").on("click",function() {
    			
    			var bbu=this.parentNode.parentNode;
    			var bbs = $(bbu).children();
    			$("#myModal").find("input[name=name]").val(bbs.eq(1).text());
    			$("#myModal").find("input[name=price]").val(bbs.eq(4).text());
    			$("#myModal").find("input[name=type]").val("Main course");
    			$("#myModal").find("button[name=save]").on("click",function() {
    				var f_this = bbu;
    				var foodid = bbs.eq(0).text();
    				var foodname =$("#myModal").find("input[name=name]").val();
    				var foodprice = $("#myModal").find("input[name=price]").val();
    				$.get("../updatefoodok",{foodid:foodid,foodname:foodname,foodprice:foodprice},function(data) {
    					var ff_this = f_this;
    					$(ff_this).find("#foodname").text(data.name);
    					$(ff_this).find("#price").text(data.price);
    					$(ff_this).find("#status").text("未审核");
    					$("#myModal").modal('hide');
    				});
    				
    				
    			});
    			
    			});
    			
    			
    		});
    	});
 