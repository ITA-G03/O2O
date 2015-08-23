function Item(itemJson){
    this.id=itemJson.id;
    this.itemName=itemJson.itemName;
}
Item.prototype.id="";
Item.prototype.itemName="";
Item.prototype.toValueArray=function(){
    var itemValueArray=[];
    itemValueArray.push(this.id);
    itemValueArray.push(this.itemName);
    itemValueArray.push(buildOperationButtonGroup(this.id,this.itemName));
    return itemValueArray;
};

function buildOperationButtonGroup(itemId,itemName){
    //var updateButton=$("<button></button>").attr("id","updateButton"+foodId).addClass("btn").addClass("btn-primary").on("click",updateFood(foodId)).serialize();
    var updateButton="<button class='btn btn-primary btn-sm' id='updateButton"+itemId+"' onclick='openUpdateFoodModal(\""+itemId+"\",\""+itemName+"\")'>Update<//button>";
    var deleteButton="<button class='btn btn-danger btn-sm'  id='deleteButton"+itemId+"' onclick='openDeleteFoodModal(\""+itemId+"\")'>Delete<//button>";
    return updateButton+deleteButton;
}



//To Get URL Param
(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
})(jQuery);

//noinspection JSUnusedGlobalSymbols
function setNeedUpdateItemData(itemId,itemName) {
    $("#originItemId").val(itemId);
    $("#updateItemId").val(itemId);
    $("#updateItemName").val(itemName);
    console.log("Set Item Name:"+itemName);
    $("#updateItemForm").attr("action","/item/update/"+itemId);
}
//noinspection JSUnusedGlobalSymbols
function openUpdateFoodModal(itemId,itemName){
    $("#updateItemTriggerButton").click();
    setNeedUpdateItemData(itemId,itemName);
}

//noinspection JSUnusedGlobalSymbols
function openDeleteFoodModal(itemId){
    console.log("itemId:"+itemId);
    $("#deleteItemTriggerButton").click();
    $("#deleteItemId").val(itemId);
    console.log("准备删东西哇:"+$("#deleteItemId").val());
}

function deleteItem(){
    var deleteItemId=$("#deleteItemId").val();
    console.log("Delete Item Id:"+deleteItemId);
    location.href="/item/delete/"+deleteItemId;
}




function setItemData(response) {
    var itemJsonArray=JSON.parse(response);
    var valueSet=[];
    itemJsonArray.forEach(function(e){
        var item=new Item(e);
        valueSet.push(item.toValueArray());
    });

    $("#itemDataTable").DataTable({
        "data":valueSet,
        "columns":[
            {"title":"ItemId"},
            {"title":"ItemName"},
            {"title":"Operation"}
        ],
        "pagingType":"full_numbers"

    })
}
function loadItemList() {
    $.ajax({
        url:'/item/list/all',
        method:'get',
        cache:false,
        success:function(response){
            console.log(response);
            setItemData(response);
        },
        error:function(){

        }
    });
}


function initListeners(){
    $("#deleteItemButton").click(deleteItem);
}

$(function(){
    initListeners();
    loadItemList()
});