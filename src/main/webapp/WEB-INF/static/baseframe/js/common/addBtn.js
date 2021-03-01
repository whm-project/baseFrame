//初始化权限菜单【currentMenuCd】

//设置按钮栏
function setBtnDiv(btnDivId){
    //基础按钮
    $.ajax({
        type:"post",
        url:basePath + "/" + baseOrgCd + "/sysMenu/getChildMenu",
        data:{"pcd":currentMenuCd, "mtp":3, "isBaseBtn": "1", "btp":"1", "pageNumber":0, "pageSize":0},
        success:function(ref){
            for(var i=0; i<ref.length; i++){
                // $("#"+btnDivId).append('<input type="button" value="'+ref[i].menuNm+'" onclick="'+ref[i].menuOther1+'">');
                $("#"+btnDivId).append('<button id="btn_add" type="button" class="btn btn-default" onclick="' + ref[i].menuOther1 + '">' + ref[i].menuNm + '</button> ');
            }
        }
    });

    //权限按钮
    $.ajax({
        type:"get",
        url:basePath + "/" + baseOrgCd + "/sysUsermenu/getUserMenuList",
        data:{"supMenuCd":currentMenuCd, "menuType":3, "baseBtn":"0", "btnPosition":"1", "pageNumber":0, "pageSize":0},
        success:function(ref){
            for(var i=0; i<ref.length; i++){
                // $("#"+btnDivId).append('<input type="button" value="'+ref[i].menuNm+'" onclick="'+ref[i].menuOther1+'">');
                $("#"+btnDivId).append('<button id="btn_add" type="button" class="btn btn-default" onclick="' + ref[i].menuOther1 + '">' + ref[i].menuNm + '</button> ');
            }
        }
    });
}

//获取操作栏按钮集合
function getOperationDivBtn(){
    var operationBtnAry = new Array();
    //基础按钮
    $.ajax({
        type:"post",
        async: false,
        url:basePath + "/" + baseOrgCd + "/sysMenu/getChildMenu",
        data:{"pcd":currentMenuCd, "mtp":3, "isBaseBtn": "1", "btp":"2", "pageNumber":0, "pageSize":0},
        success:function(ref){
            if(ref.length > 0){
                operationBtnAry = operationBtnAry.concat(ref);
            }
        }
    });

    //权限按钮
    $.ajax({
        type:"get",
        async: false,
        url:basePath + "/" + baseOrgCd + "/sysUsermenu/getUserMenuList",
        data:{"supMenuCd":currentMenuCd, "menuType":3, "baseBtn":"0", "btnPosition":"2", "pageNumber":0, "pageSize":0},
        success:function(ref){
            if(ref.length > 0){
                operationBtnAry = operationBtnAry.concat(ref);
            }
        }
    });

    return operationBtnAry;
}