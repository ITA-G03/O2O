$(function() {
	$.post("../business/food/type",function(data) {
		var tbody="";
		for(var i=0;i<data.length;i++) {
			var str="<option value=";
			str+=data[i].foodTypeId+">";
			str+=data[i].foodTypeName;
			str+="</option>";
			tbody+=str;
		}
		$("select").append(tbody);
	});

});