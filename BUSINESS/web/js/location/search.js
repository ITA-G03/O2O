//refactor version

/*Object define*/
//Model Area
function Area(id,areaId,area,cityId){
    this.id=id;
    this.areaId=areaId;
    this.area=area;
    this.cityId=cityId;
}

Area.prototype.id="";
Area.prototype.areaId="";
Area.prototype.area="";
Area.prototype.cityId="";



//DataStructure HashMap<String,List<Area>>
function HashMap(){
    this.data={};//the data is map
}

HashMap.prototype.data={};
HashMap.prototype.put=function(jsonString){
    var queryResult=JSON.parse(jsonString);
    var queryKey=queryResult['query'];//key
    var queryDataList=queryResult['dataList'];//data need to convert to List<Area>
    var areaList=[];
    for(var key in queryDataList){
        //noinspection JSUnfilteredForInLoop
        var value=queryDataList[key];
        var newId=value.id;
        var newAreaId=value.areaId;
        var newArea=value.area;
        var newCityId=value.cityId;
        var area=new Area(newId,newAreaId,newArea,newCityId);
        areaList.push(area);
    }
    this.data[queryKey]=areaList;
};
HashMap.prototype.containsKey=function(queryKey){
    var value=this.data[queryKey];
    return !(value == undefined || value.length == 0);
};
HashMap.prototype.showResult=function(queryKey,appendElementId,dropdownListElementId){
    //1.获取绝对位置
    var queryInputArea=document.getElementById(appendElementId);
    var top=queryInputArea.offsetTop;
    var left=queryInputArea.offsetLeft;
    var width=queryInputArea.offsetWidth;
    var height=queryInputArea.offsetHeight;

    //2.构造下拉列表
    var autoCompleteDropDownDiv=document.createElement("div");
    autoCompleteDropDownDiv.id=dropdownListElementId;
    autoCompleteDropDownDiv.style.top=((top+height)+"px");
    autoCompleteDropDownDiv.style.left=(left+"px");
    autoCompleteDropDownDiv.style.width=(width+"px");
    autoCompleteDropDownDiv.style.maxHeight=("400px");
    autoCompleteDropDownDiv.style.position="absolute";
    autoCompleteDropDownDiv.style.zIndex="10";
    autoCompleteDropDownDiv.style.border="1px solid #ccc";
    autoCompleteDropDownDiv.style.borderRadius="4px";
    autoCompleteDropDownDiv.style.overflow="auto";
    autoCompleteDropDownDiv.style.background="white";


    //3.
    var queryUL=document.createElement("ul");
    queryUL.style.padding="0";
    queryUL.style.listStyle="none";

    var areaList=this.data[queryKey];
    for(var i in areaList){
        //noinspection JSUnfilteredForInLoop
        var area=areaList[i];
        var areaInfo=document.createElement("li");
        areaInfo.value=area.id;
        areaInfo.innerHTML=(area.area+","+area.cityId+","+area.areaId);
        queryUL.appendChild(areaInfo);
    }
    autoCompleteDropDownDiv.appendChild(queryUL);
    queryInputArea.appendChild(autoCompleteDropDownDiv);

};
HashMap.prototype.clearResult=function(dropdownListElementId){
    var resultDropDownList=document.getElementById(dropdownListElementId);
    if(resultDropDownList){
        resultDropDownList.remove();
    }
};
/*Object Define End*/





//判断全是否中文
function isChinese(word) {
    var re=/[^\u4e00-\u9fa5]/;
    return !re.test(word);

}

//序列化中文编码成Unicode
function doubleEncode(query){
    var encodedQuery=encodeURI(query);
    return encodeURI(encodedQuery);
}

function doubleDecode(query){
    var decodedQuery=decodeURI(query);
    return decodeURIComponent(decodedQuery);
}







//匿名入口函数 相当于过程化代码的入口 但是将原本的全局变量在函数中声明 则不会污染到windows的全局对象
(function(){
    var cacheMap=new HashMap();
    var inputAreaElementId="query";
    var queryContainerId="queryContainer";
    var dropDownListElementId="resultDropDownList";
    var queryInputArea=document.getElementById(inputAreaElementId);
    queryInputArea.onkeyup=function(){
        var query=document.getElementById(inputAreaElementId).value;
        if(query.length>=1&&isChinese(query)){
            cacheMap.clearResult(dropDownListElementId);
            if(cacheMap.containsKey(query)){
                cacheMap.showResult(query,queryContainerId,dropDownListElementId);
            }
            else{
                var queryRequest=new XMLHttpRequest();
                queryRequest.open("GET","search?keyword="+doubleEncode(query));
                queryRequest.send();
                queryRequest.onreadystatechange=function(){
                    if(queryRequest.readyState==4){
                        var resultJsonString=queryRequest.responseText;
                        resultJsonString=doubleDecode(resultJsonString);
                        console.log(resultJsonString);
                        cacheMap.put(resultJsonString);
                        cacheMap.showResult(query,queryContainerId,dropDownListElementId);
                    }
                };
            }
        }
    };

})();

