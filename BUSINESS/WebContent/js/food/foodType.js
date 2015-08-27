
$(function () {
		$("#myModal").find("button[name=save]").on("click",function() {
			var foodTypeName = $("#myModal").find("input[name=type]").val();
				$.post("../action/food/type/create",{foodTypeName:foodTypeName},function(data) {
					$("#myModal").modal('hide');
				});	
		});
	
		$("button[name=look]").on("click",function() {
			$('#myModal2').modal('show')
			$("#myModal2").find("#t").children().remove();
			$.post("../business/food/type",function(data) {
				for(var i=0;i<data.length;i++) {
					var trs="<tr>";
					trs+="<td id='foodTypeId'>"+data[i].foodTypeId+"</td>";
					trs+="<td id='foodTypeName'>"+data[i].foodTypeName+"</td>";
					trs+="<td><button type='button' name='deleteType' >delete</button></td>";
					trs+="</tr>"
				    $("#myModal2").find("#t").append(trs);		
				}
				$("button[name=deleteType]").on("click",function() {
					var ttr = $(this).parent().parent();
					var foodTypeId = $(ttr).children().eq(0).text();
					alert(foodTypeId);
					$.post('../action/food/type/find',{foodTypeId:foodTypeId},function(data) {
						var _this = ttr;
						if(data.status=="success") {
							$("#deleteMessage").text("It is not allowed to delete!");
						}else {
							$.post("../action/food/type/delete",{foodTypeId:foodTypeId},function(data){
								var _tthis=ttr;
								if(data.status="success") {
									_tthis.remove();	
								}
								
							})
						}
						
						
					});
					
				})
				});		
		})
		
});