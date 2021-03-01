//ztree设置
var setting = {
    view: {
        selectedMulti: true,
        fontCss: getFontCss
    },
    data: {
        key: {
            name:"menuNmLx",
            title:"menuCd"
        },
        simpleData: {
            enable: true,
            idKey: "menuCd",
            pIdKey: "supMenuCd"
        }
    },
    check: {
        enable: true,
        chkboxType: { "Y": "p", "N": "s" }
    },
    callback: {
        onCheck: zTreeOnCheck
    }
};

//初始化
var zTree;
$(function(){
    $.ajax({
        type:"get",
        async: false,
        url:basePath + "/" + baseOrgCd + "/sysUsermenu/getUserMenuList",
        data:{"baseBtn": "0"},
        success:function(res){
            $.fn.zTree.init($("#menu_ztree"), setting, res);
            zTree = $.fn.zTree.getZTreeObj("menu_ztree");
        }
    })
});

//更新节点，使查询出来的节点高亮
function searchNode() {
    var nodeList = zTree.getNodesByFilter(getNodeFilter);
    //清空原选中节点样式
    clearFontCss("highlight");
    //设置新选中节点样式
    if(nodeList.length <= 0){
        alert("未找到相关数据！");
    }else{
        setFontCss(nodeList, "highlight");
    }
}

//查找节点【根据name和code】
function getNodeFilter(node) {
    var search_name = $("#name").val();
    var search_code = $("#code").val();

    var resultAry;
    if(search_name.length > 0 && search_code.length > 0){
        resultAry = (node.menuNm.indexOf(search_name)>-1 && node.menuCd.indexOf(search_code)>-1);
    }else if(search_name.length > 0){
        resultAry = node.menuNm.indexOf(search_name)>-1;
    }else if(search_code.length > 0){
        resultAry = node.menuCd.indexOf(search_code)>-1;
    }else{
        return ;
    }
    return resultAry;
}

//设置节点图标
function setNodeIcon(node){
    if(node.isParent){
        if(node.menuOther2 != null && node.menuOther2 != ""
            && node.menuOther3 != null && node.menuOther3 != ""){
            node.iconClose = node.menuOther2;
            node.iconOpen = node.menuOther3;
        }
        else if(node.menuOther2 != null && node.menuOther2 != ""){
            node.icon = node.menuOther2;
        }
    }else{
        if(node.menuOther2 != null && node.menuOther2 != ""){
            node.icon = node.menuOther2;
        }
    }
    zTree.updateNode(node);
}

//选中节点回调函数
function zTreeOnCheck(event, treeId, treeNode){
    //基础按钮取消选中
    if(!treeNode.checked && treeNode.menuOther4 == "1" && treeNode.menuType == "3"){
        //如果父级节点选中，提示基础按钮不能取消选中
        if(treeNode.getParentNode().checked){
            alert("基础按钮不能取消选中！");
            treeNode.checked = true;
        }
    }
}


//获取选中的节点
function getNenu(){
    var nodes = zTree.getNodesByParam("checked", true, null);
    window.parent.handle_checked_node(nodes);
    return;
}

//设置默认选中节点
function set_defaultchecked(default_ary){
    for(var i=0; i<default_ary.length; i++){
        var default_menuCd = default_ary[i];
        var n =zTree.getNodeByParam("menuCd", default_menuCd, null);
        if(n != null){
            zTree.checkNode(n, true, false);
        }
    }
}

//设置取消选中节点
function set_cancelchecked(default_ary){
    for(var i=0; i<default_ary.length; i++){
        var default_menuCd = default_ary[i];
        var n =zTree.getNodeByParam("menuCd", default_menuCd, null);
        if(n != null){
            zTree.checkNode(n, false, false, false);
        }
    }
}