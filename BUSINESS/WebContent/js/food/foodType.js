
$(function () {
		$("#myModal").find("button[name=save]").on("click",function() {
			var foodTypeName = $("#myModal").find("input[name=type]").val();
				$.post("../action/food/type/create",{foodTypeName:foodTypeName},function(data) {
					$("#myModal").modal('hide');
				});	
		});
	
		$("button[name=delete]").on("click",function() {
			$('#myModal2').modal('show')
			$("#myModal2").find("#t").children().remove();
			$.post("../business/food/type",function(data) {
				for(var i=0;i<data.length;i++) {
					var trs="<tr>";
					trs+="<td id='foodTypeId'>"+data[i].foodTypeId+"</td>";
					trs+="<td id='foodTypeName'>"+data[i].foodTypeName+"</td>";
					trs+="<td><button type='button' name='delete' >delete</button></td>";
					trs+="</tr>"
				    $("#myModal2").find("#t").append(trs);	
					
					$("#myModal2").find("button[name=delete]").on("click",function() {
						var tts =$(this).parent().parent();
						var foodTypeId = $(tts).children().eq(0).text();
						$.post("../action/food/type/delete",{foodTypeId:foodTypeId},function(data) {
								tts.remove();
						})	
					});
				}
				});	
			
			
			
			
		})
		
});