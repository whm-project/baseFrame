//ztree设置
var setting = {
    view: {
        addHoverDom: addHoverDom,
        removeHoverDom: removeHoverDom,
        selectedMulti: false,
        fontCss: getFontCss
    },
    data: {
        key: {
            name:"menuNmLx",
            title:"menuCd"
        }
    },
    async: {
        enable: true,
        url: basePath + "/" + baseOrgCd + "/sysMenu/getChildMenu",
        autoParam:["menuCd=pcd"],
        dataFilter: ajaxDataFilter
    },
    callback: {
        onAsyncError: onAsyncError
    }
};

//初始化
var zTree;
$(function(){
    var treeObj = $("#menu_ztree");
    $.fn.zTree.init(treeObj, setting);
    zTree = $.fn.zTree.getZTreeObj("menu_ztree");
});

//加载失败
function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
    alert("加载失败，请重试！");
}

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

//异步请求完，添加节点时，先进行过滤，并根据是都自己设置了图标显示图标
function ajaxDataFilter(treeId, parentNode, childNodes){
    if (!childNodes) return null;
    for (var i=0; i<childNodes.length; i++) {
        //设置是否是父级节点
        if(childNodes[i].menuIsparent == "1"){
            childNodes[i].isParent = true;
        }else{
            childNodes[i].isParent = false
        }

        //设置节点图标
        setNodeIcon(childNodes[i]);
    }
    return childNodes;
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

//添加鼠标移动上去的样式
function addHoverDom(treeId, treeNode) {
    var sObj = $("#" + treeNode.tId + "_span");
    if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0 || $("#editBtn_"+treeNode.tId).length>0 || $("#removeBtn_"+treeNode.tId).length>0) return;

    //新增
    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='add node' onfocus='this.blur();'></span>";
    //编辑
    var editStr = "<span class='button edit' id='editBtn_" + treeNode.tId + "' title='edit node' onfocus='this.blur();'></span>";
    //删除
    var removeStr = "<span class='button remove' id='removeBtn_" + treeNode.tId + "' title='remove node' onfocus='this.blur();'></span>";

    //追加按钮
    //根节点只有新增按钮
    if(treeNode.level == 0){
        sObj.after(addStr);
    }
    //按钮类型只有编辑和删除按钮
    else if (treeNode.menuType==3){
        sObj.after(removeStr).after(editStr);
    }
    //其他节点有新增、编辑、删除按钮
    else{
        sObj.after(removeStr).after(editStr).after(addStr);
    }

    //新增绑定操作
    var btn_add = $("#addBtn_"+treeNode.tId);
    if (btn_add) btn_add.bind("click", function(){
        addTreeNode(treeNode)
        return false;
    });

    //编辑绑定操作
    var btn_edit = $("#editBtn_"+treeNode.tId);
    if(btn_edit) btn_edit.bind("click", function(){
        editTreeNode(treeNode)
    });

    //移除绑定操作
    var btn_remove = $("#removeBtn_"+treeNode.tId);
    if(btn_remove) btn_remove.bind("click", function(){
        removeTreeNode(treeNode)
    });
};

//添加鼠标移出的样式
function removeHoverDom(treeId, treeNode) {
    //有新增按钮，取消绑定
    if($("#addBtn_"+treeNode.tId).length > 0){
        $("#addBtn_"+treeNode.tId).unbind().remove();
    }
    //有编辑按钮，取消绑定
    if($("#editBtn_"+treeNode.tId).length > 0){
        $("#editBtn_"+treeNode.tId).unbind().remove();
    }
    //有删除按钮，取消绑定
    if($("#removeBtn_"+treeNode.tId).length > 0){
        $("#removeBtn_"+treeNode.tId).unbind().remove();
    }
};

//添加节点
function addTreeNode(parentNode){
    $("#menuId").val("");
    $("#menuNm").val("");
    $("#menuCd").val("");
    $("#menuType").find("option[value='1']").prop("selected",true);
    $("#pageType").find("option[value='1']").prop("selected",true);
    $("#btnPosition").find("option[value='1']").prop("selected",true);
    $("#menuUrl").val("");
    $("#menuOther1").val("");
    $("#menuOther2").val("");
    $("#menuOther3").val("");
    $("#menuOther4").find("option[value='0']").prop("selected",true);
    $("#supMenuCd").val(parentNode.menuCd);
    $("#menuOrder").val("10");
    addInfoByParentType(parentNode.menuType, parentNode.pageType);
}

//新增根据父级类型【root、模块、页面（单|多）设置新增显示内容
function addInfoByParentType(menuType, pageType){
    $("#menuType").find("option").show();
    $("#pageType").find("option").show();
    $("#btnPosition").find("option").show();

    //如果父级是模块，新增时菜单类型没有按钮，默认选中菜单类型是页面，页面类型是单页
    if(menuType == 1){
        $("#menuType").find("option[value='3']").hide();
        $("#menuType").find("option[value='2']").prop("selected",true);
        $("#pageType").find("option[value='1']").prop("selected",true);
    }
    //如果父级是页面，新增时菜单类型没有模块
    else if(menuType == 2){
        $("#menuType").find("option[value='1']").hide();
        //如果是单页，新增时菜单类型没有页面，默认菜单类型是按钮
        if(pageType == 1){
            $("#menuType").find("option[value='2']").hide();
            $("#menuType").find("option[value='3']").prop("selected",true);
        }
        //如果是多页，新增时菜单类型没有按钮，默认选中菜单类型是页面，页面类型是单页
        if(pageType == 2){
            $("#menuType").find("option[value='3']").hide();
            $("#menuType").find("option[value='2']").prop("selected",true);
            $("#pageType").find("option[value='1']").prop("selected",true);
        }
    }
    //如果父级是root
    else{
        $("#menuType").find("option[value='1']").prop("selected",true);
        $("#pageType").find("option[value='1']").prop("selected",true);
        $("#btnPosition").find("option[value='1']").prop("selected",true);
    }
    menuTypeOrPageTypeChange();
}

//点击节点
function zTreeOnClick(event, treeId, treeNode){
    if(treeNode.menuCd != "root"){
        editTreeNode(treeNode);
    }
}

//编辑节点
function editTreeNode(treeNode) {
    $("#menuId").val(treeNode.menuId);
    $("#menuNm").val(treeNode.menuNm);
    $("#menuCd").val(treeNode.menuCd);
    $("#menuType").find("option[value='"+treeNode.menuType+"']").prop("selected",true);
    $("#pageType").find("option[value='"+treeNode.pageType+"']").prop("selected",true);
    $("#btnPosition").find("option[value='"+treeNode.btnPosition+"']").prop("selected",true);
    $("#menuUrl").val(treeNode.menuUrl);
    $("#menuOther1").val(treeNode.menuOther1);
    $("#menuOther2").val(treeNode.menuOther2);
    $("#menuOther3").val(treeNode.menuOther3);
    $("#menuOther4").find("option[value='"+treeNode.menuOther4+"']").prop("selected",true);
    $("#supMenuCd").val(treeNode.supMenuCd);
    if(treeNode.menuOrder == "" || treeNode.menuOrder == null || typeof (treeNode.menuOrder) == "undefined"){
        $("#menuOrder").val("10");
    }else{
        $("#menuOrder").val(treeNode.menuOrder);
    }
    menuTypeOrPageTypeChange();
}

//删除节点
function removeTreeNode(treeNode){
    //如果是root节点，不能删除
    if(treeNode.menuCd == "root"){
        alert("根节点不能进行此操作！");
    }
    //不是root节点，提示判断是不是有子节点，如果有，confirm
    else if(treeNode.isParent){
        var msg = "要删除的节点是父节点，如果删除将连同子节点一起删掉。\n\n请确认！";
        if(confirm(msg)){
            //调用后台接口，设置为删除状态
            ajaxDelNode(treeNode.menuCd);
        }
    }
    //不是根节点
    else{
        if(confirm("是否确定删除？")){
            //调用后台接口，设置为删除状态
            ajaxDelNode(treeNode.menuCd);
        }
    }
}

//ajax调用接口删除节点
function ajaxDelNode(menuCd){
    $.ajax({
        type:"post",
        url: basePath + "/" + baseOrgCd + "/sysMenu/delMenu",
        data:{menuCd: menuCd},
        success:function(checkResult){
            if(checkResult.state == 1){
                var delNodeList = zTree.getNodesByParamFuzzy("menuIndex", menuCd, null);
                for(var i=0; i<delNodeList.length; i++){
                    zTree.removeNode(delNodeList[i]);

                    //更新父节点信息
                    var parentNode =  zTree.getNodesByParam("menuCd", delNodeList[i].supMenuCd, null)[0];
                    parentNodeUpdate_maintain(zTree, parentNode);
                }
                alert("删除成功！");
            }
            else{
                alert(checkResult.msg);
            }
        }
    })
}

//验证菜单code唯一性
function checkMenuCd(){
    $.ajax({
        type:"get",
        url: basePath + "/" + baseOrgCd + "/sysMenu/checkMenuCd",
        data:{menuCd: $("#menuCd").val(), menuId:$("#menuId").val()},
        success:function(checkResult){
            if(checkResult.state == 0){
                alert($("#menuCd").val()+checkResult.msg);
                $("#menuCd").focus();
            }
        }
    })
}

//提交增改菜单
function subInfo(){
    //如果是新增的是按钮，需要进行提示
    if($("#menuType").val() == 3){
        var baseBtnVal = $("#menuOther4").val();
        if(baseBtnVal == 0){
            if(!confirm("该按钮将设置为非基础按钮，请在用户模块设置谁拥有这个权限！")){
                return ;
            }
        }else{
            if(!confirm("该按钮将设置为基础按钮，所有用户都会拥有这个权限！")){
                return ;
            }
        }
    }
    //如果不是按钮，基础按钮值改为0
    else{
        $("#menuOther4").find("option[value='0']").prop("selected",true);
    }

    //如果有菜单编号，要进行的是修改
    if($("#menuId").val().length > 0){
        $.ajax({
            type:"post",
            url:basePath + "/" + baseOrgCd + "/sysMenu/updateMenu",
            data:$("#infoForm").serialize(),
            success:function(ref){
                alert("保存成功！");

                //如果这次更新了上级组织机构
                var newSupMenuCd = ref.data.newSupMenuCd;
                var oldSupMenuCd = ref.data.oldSupMenuCd;
                if(newSupMenuCd != oldSupMenuCd){
                    //重新加载上次的上级组织机构
                    var oldParentNode = zTree.getNodesByParam("menuCd", oldSupMenuCd, null)[0];
                    //更新父节点信息
                    parentNodeUpdate_maintain(zTree, oldParentNode);
                }

                //需重新加载这次的上级组织机构
                var parentNode = zTree.getNodesByParam("menuCd", newSupMenuCd, null)[0];
                //更新父节点信息
                parentNodeUpdate_increment(zTree, parentNode);
            }
        })
    }
    //如果没有菜单编号，要进行的是新增
    else{
        $.ajax({
            type:"post",
            url:basePath + "/" + baseOrgCd + "/sysMenu/createMenu",
            data:$("#infoForm").serialize(),
            success:function(ref){
                alert("保存成功！");

                //父节点信息
                var parentNode = zTree.getNodesByParam("menuCd", $("#supMenuCd").val(), null)[0];
                //更新父节点信息
                parentNodeUpdate_increment(zTree, parentNode);
            }
        })
    }
}

//更新父节点信息，增量
function parentNodeUpdate_increment(ztree, parentNode){
    parentNode.isParent = true;

    //设置父节点图标
    setNodeIcon(parentNode);

    //刷新父节点的子节点
    ztree.reAsyncChildNodesPromise(parentNode, "refresh", false);
}

//更新父节点信息，维护
function parentNodeUpdate_maintain(ztree, parentNode) {
    //判断父节点下有没有子节点
    var childNodes = ztree.getNodesByParam("supMenuCd", parentNode.menuCd, null);
    if (childNodes.length > 0) {
        parentNode.isParent = true;
    } else {
        parentNode.isParent = false;
    }

    //设置父节点图标
    setNodeIcon(parentNode);

    //刷新父节点的子节点
    ztree.reAsyncChildNodesPromise(parentNode, "refresh", false);
}

//修改菜单类型后
function menuTypeOrPageTypeChange(){
    //菜单类型
    var menuTypeVal = $("#menuType").val();
    //页面类型
    var pageTypeVal = $("#pageType").val();
    //url标题
    $("#menuUrlLi span").html("页面url：");

    //模块类型
    if(menuTypeVal == "1"){
        $("#pageTypeLi").hide();
        $("#btnPositionLi").hide();
        $("#menuUrlLi").hide();
        $("#btnOperationLi").hide();
        $("#openIconLi").show();

        $("#menuOther4").find("option[value='0']").prop("selected",true);
        $("#baseBtnLi").hide();
    }
    //页面类型
    if(menuTypeVal == "2"){
        $("#btnPositionLi").hide();
        $("#btnOperationLi").hide();
        $("#pageTypeLi").show();
        $("#menuUrlLi").show();

        $("#menuOther4").find("option[value='0']").prop("selected",true);
        $("#baseBtnLi").hide();

        //单页类型
        if(pageTypeVal == "1"){
            $("#menuUrlLi").show();
            $("#openIconLi").hide();
        }
        //多页类型
        if(pageTypeVal == "2"){
            $("#menuUrlLi").hide();
            $("#openIconLi").show();
        }
    }
    //按钮类型
    if(menuTypeVal == "3"){
        $("#pageTypeLi").hide();
        $("#menuUrlLi").show();
        $("#menuUrlLi span").html("限制url：");
        $("#btnPositionLi").show();
        $("#btnOperationLi").show();
        $("#openIconLi").hide();
        $("#baseBtnLi").show();
    }
}