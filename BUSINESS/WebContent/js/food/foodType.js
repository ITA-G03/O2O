
$(function () {
	$("button[name=addFood]").on("click",function() {
		$("#myModal").find("button[name=save]").on("click",function() {
			var foodType = $("#myModal").find("input[name=type]").val();
			if(foodType!="") {
				
				$.post("",{foodType:foodType},function(data) {
					alert("..........");
					$("#myModal").find("input[name=type]").val("");
					$("#myModal").modal('hide');
				});
				
			}
			
		
		});		
	})
	
	
	
	$("button[name=delete]").on("click",function() {
		
		$.post("",function(data) {
			for(var i=0;i<data.length;i++) {
				var trs="<tr>";
				trs+="<td id='id'>"+data[i].id+"</td>";
				trs+="<td id='name'>"+data[i].foodType+"</td>";
				trs+="<td><button type='button' name='delete' >delete</button></td>";
				trs+="</tr>"
			    $("#myModal2").find("#t").append(trs);
				
				$("#myModal2").find("button[name=delete]").on("click",function() {
					var tts =$(this).parent().parent();
					var id = $(tts).children().eq(0).text();
					$.post("deletefoodtype",{id:id},function(data) {
						if(data=='1') {
							tts.remove();
						}
						
					})
					
					
				});
			}
				
		});
		
		
	})

	
});