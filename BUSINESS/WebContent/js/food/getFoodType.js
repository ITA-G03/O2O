$(function() {
	$.post("../business/food/type",function(data) {
		var tbody="";
		
			var str="<option value=";
			str+=data.foodTypeId+">";
			str+=data.foodTypeName;
			str+="</option>";
			tbody+=str;
		
		alert(tbody);
		$("select").append(tbody);
	});

});