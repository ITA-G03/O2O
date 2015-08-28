$(function() {
    $.post("../business/food/list",function(data) {
    		var tbody="";
    		for(var i=0;i<data.length;i++) {
    			var trs="<tr>";
    			trs+="<td id='foodid'>"+data[i].foodId+"</td>";
    			trs+="<td id='foodname'>"+data[i].foodName+"</td>";
    			
    			var result;
				$.ajax({
					   url: "../action/food/getsalevolume",
				       async: false,
				        type: "post",
				       data: { foodId:data[i].foodId  },
				       success: function (courseDT4) {
				           result = courseDT4.status;
				}	
				});	
    			
    			
    			trs+="<td><image src='../image/view/"+data[i].foodPictureId+"' width='200',height='100'/></td>";
    			trs+="<td id='price'>"+data[i].price+"</td>";
    			trs+="<td id='type'>"+data[i].foodType.foodTypeName+"</td>";
    			trs+="<td>"+result+"</td>";
    			trs+="<td><button type='button' class='btn btn-primary'  data-toggle='modal' data-target='#myModal3' name='update'>update</button>&nbsp<button type='button' class='btn btn-warning' name='deleteFood' onclick='return confirm('Delete Sure?')'>delete</button></td>";
    			trs+="</tr>"
    			tbody+=trs;
    		}
    		$("tbody").append(tbody);
    		
    		$("button[name=deleteFood]").on("click",function() {
    			var ttr=$(this).parent().parent();
    			var foodId = $(this).parent().parent().children().eq(0).text();
    			
    			$.post("../action/food/getsalevolume",{foodId:foodId},function(data) {
    				
    				if(data.status!='0')
    				    $("#infromMessage").modal('show');
    				else {
    					$.post("../action/food/delete",{foodId:foodId},function(data) {
    					     if(data.status=='success') {
    					     ttr.remove();
    					     }
    					     
    					     });
    					
    					
    				}	
    				
    			})
    			
    			
    			
    			
    		});
    		
    		$("button[name=update]").on("click",function() {
    			var bbu=this.parentNode.parentNode;
    			var bbs = $(bbu).children();
    			$("#myModal3").find("input[name=name]").val(bbs.eq(1).text());
    			$("#myModal3").find("input[name=price]").val(bbs.eq(3).text());
    			$("#myModal3").find("input[name=type]").val(bbs.eq(4).text());
    			$("#myModal3").find("button[name=saveFood]").on("click",function() {
    				var f_this = bbu;
    				var foodId = bbs.eq(0).text();
    				var foodName =$("#myModal3").find("input[name=name]").val();
    				var price = $("#myModal3").find("input[name=price]").val();
    				$.post("../action/food/update",{foodId:foodId,foodName:foodName,price:price},function(data) {
    					var ff_this = f_this;
    					if(data.status="success") {
    						$(ff_this).find("#foodname").text(foodName);
        					$(ff_this).find("#price").text(price);	
    					}
    					$("#myModal3").modal('hide');
    				});
    				
    				
    			});
    			
    			});
    			
    			
    		});
    	});
 