//ztree设置
var setting = {
    view: {
        addHoverDom: addHoverDom,
        removeHoverDom: removeHoverDom,
        selectedMulti: false,
        fontCss: getFontCss,
        addDiyDom: addDiyDom
    },
    data: {
        key: {
            name:"orgNm",
            title:"orgCd"
        }
    },
    async: {
        enable: true,
        url: basePath + "/" + baseOrgCd + "/sysOrg/getChildOrg",
        autoParam:["orgCd=pcd"],
        dataFilter: ajaxDataFilter
    },
    callback: {
        onAsyncError: onAsyncError
    }
};

//初始化
var zTree;
$(function(){
    var treeObj = $("#org_ztree");
    $.fn.zTree.init(treeObj, setting);
    zTree = $.fn.zTree.getZTreeObj("org_ztree");
});

//在节点上固定显示自定义控件
function addDiyDom(treeId, treeNode) {
    var spaceWidth = 5;
    var switchObj = $("#" + treeNode.tId + "_switch"), icoObj = $("#" + treeNode.tId + "_ico");
    switchObj.remove();
    icoObj.before(switchObj);

    if (treeNode.level > 1) {
        var spaceStr = "<span style='display: inline-block;width:" + (spaceWidth * treeNode.level)+ "px'></span>";
        switchObj.before(spaceStr);
    }
}

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
        resultAry = (node.orgNm.indexOf(search_name)>-1 && node.orgCd.indexOf(search_code)>-1);
    }else if(search_name.length > 0){
        resultAry = node.orgNm.indexOf(search_name)>-1;
    }else if(search_code.length > 0){
        resultAry = node.orgCd.indexOf(search_code)>-1;
    }else{
        return ;
    }
    return resultAry;
}

//异步请求完，添加节点时，先进行过滤
function ajaxDataFilter(treeId, parentNode, childNodes){
    if (!childNodes) return null;
    for (var i=0; i<childNodes.length; i++) {
        //设置是否是父级节点
        if(childNodes[i].orgIsparent == "1"){
            childNodes[i].isParent = true;
        }else{
            childNodes[i].isParent = false;
        }

        if(childNodes[i].orgStatus == 0){
            childNodes[i].stopstop = true;
        }
        if(childNodes[i].orgStatus == -1){
            childNodes.remove(i);
            i--;
        }
    }
    return childNodes;
}

//添加鼠标移动上去的样式
function addHoverDom(treeId, treeNode) {
    var sObj = $("#" + treeNode.tId + "_span");
    if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0 || $("#editBtn_"+treeNode.tId).length>0 || $("#removeBtn_"+treeNode.tId).length>0) return;

    //新增
    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='add node' onfocus='this.blur();'></span>";
    //编辑
    var editStr = "<span class='button edit' id='editBtn_" + treeNode.tId + "' title='edit node' onfocus='this.blur();'></span>";
    //停用
    var stopStr = "<span class='button icon-stop' id='stopBtn_" + treeNode.tId + "' title='stop node' onfocus='this.blur();'></span>";
    //启用
    var beginStr = "<span class='button icon-stop' id='beginBtn_" + treeNode.tId + "' title='begin node' onfocus='this.blur();'></span>";
    //删除
    var removeStr = "<span class='button remove' id='removeBtn_" + treeNode.tId + "' title='remove node' onfocus='this.blur();'></span>";

    //追加按钮
    if(treeNode.level == 0){
        sObj.after(addStr);
    }else{
        if(treeNode.orgStatus == 1){
            sObj.after(removeStr).after(stopStr).after(editStr).after(addStr);
        }else{
            sObj.after(removeStr).after(beginStr).after(editStr).after(addStr);
        }
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

    //停用绑定操作
    var btn_stop = $("#stopBtn_"+treeNode.tId);
    if(btn_stop) btn_stop.bind("click", function(){
        stopTreeNode(treeNode)
    });

    //启用绑定操作
    var btn_begin = $("#beginBtn_"+treeNode.tId);
    if(btn_begin) btn_begin.bind("click", function(){
        beginTreeNode(treeNode)
    });

    //移除绑定操作
    var btn_remove = $("#removeBtn_"+treeNode.tId);
    if(btn_remove) btn_remove.bind("click", function(){
        removeTreeNode(treeNode)
    });
};

//添加鼠标移出的样式
function removeHoverDom(treeId, treeNode) {
    $("#addBtn_"+treeNode.tId).unbind().remove();
    $("#editBtn_"+treeNode.tId).unbind().remove();
    $("#beginBtn_"+treeNode.tId).unbind().remove();
    $("#stopBtn_"+treeNode.tId).unbind().remove();
    $("#removeBtn_"+treeNode.tId).unbind().remove();
};

//添加节点
function addTreeNode(parentNode){
    //TODO 设置右边内容
    $("#orgId").val("");
    $("#orgNm").val("");
    $("#orgCd").val("");
    $("#orgType").find("option[value='1']").prop("selected",true);
    $("#orgStatus").find("option[value='1']").prop("selected",true);
    $("#orgWelcome").val("");
    $("#orgOrder").val(10);
    $("#engManCd").val(parentNode.orgCd);
    $("#loginBgimg").val("");
}

//点击节点
function zTreeOnClick(event, treeId, treeNode){
    if(treeNode.orgCd != "root"){
        editTreeNode(treeNode);
    }
}

//编辑节点
function editTreeNode(treeNode) {
    $("#orgId").val(treeNode.orgId);
    $("#orgNm").val(treeNode.orgNm);
    $("#orgCd").val(treeNode.orgCd);
    if(treeNode.adCd == "" || treeNode.adCd == null || typeof (treeNode.adCd) == "undefined"){
        $("#adCd").val("");
    }else{
        $("#adCd").val(treeNode.adCd);
    }
    if(treeNode.orgOrder == "" || treeNode.orgOrder == null || typeof (treeNode.orgOrder) == "undefined"){
        $("#orgOrder").val("10");
    }else{
        $("#orgOrder").val(treeNode.orgOrder);
    }
    $("#orgType").find("option[value='"+treeNode.orgType+"']").prop("selected",true);
    $("#orgStatus").find("option[value='"+treeNode.orgStatus+"']").prop("selected",true);
    $("#orgWelcome").val(treeNode.orgWelcome);
    $("#orgOrder").val(treeNode.orgOrder);
    $("#engManCd").val(treeNode.engManCd);
    $("#orgStylelib").find("option[value='"+treeNode.orgStylelib+"']").prop("selected",true);
    $("#orgLayoutlib").find("option[value='"+treeNode.orgLayoutlib+"']").prop("selected",true);
    $("#loginBgimg").val(treeNode.loginBgimg);
}

//更新父节点信息，增量
function parentNodeUpdate_increment(ztree, parentNode){
    parentNode.isParent = true;

    //刷新父节点的子节点
    ztree.reAsyncChildNodesPromise(parentNode, "refresh", false);
}

//更新父节点信息，维护
function parentNodeUpdate_maintain(ztree, parentNode) {
    //判断父节点下有没有子节点
    var childNodes = ztree.getNodesByParam("engManCd", parentNode.orgCd, null);
    if (childNodes.length > 0) {
        parentNode.isParent = true;
    } else {
        parentNode.isParent = false;
    }

    //刷新父节点的子节点
    ztree.reAsyncChildNodesPromise(parentNode, "refresh", false);
}

//启用
function beginTreeNode(treeNode){
    //如果是root节点，不能删除
    if(treeNode.orgCd == "root"){
        alert("根节点不能进行此操作！");
    }
    //不是root节点，
    else{
        //判断该节点的父级节点是不是停用状态
        var parentCd = treeNode.engManCd;
        var parentNode = zTree.getNodesByParam("orgCd", parentCd, null);
        //如果父节点是停用状态，则子节点不能启用
        if(parentNode[0].orgStatus == "0"){
            alert("父节点是停用状态，当前节点无法启用！");
            return false;
        }
        else{
            //提示判断是不是有子节点，如果有，confirm
            if(treeNode.isParent){
                var msg = "是否启用该节点？子节点不会一同启用。";
                if(confirm(msg)){
                    ajaxBegin(treeNode.orgCd);
                }
            }
            //不是根节点
            else{
                if(confirm("是否确定启用？")){
                    //调用后台接口，设置为启用状态
                    ajaxBegin(treeNode.orgCd);
                }
            }
        }
    }
}

//启用节点
function ajaxBegin(orgCd){
    $.ajax({
        type:"post",
        url: basePath + "/" + baseOrgCd + "/sysOrg/useOrg",
        data:{orgCd: orgCd},
        success:function(checkResult){
            if(checkResult.state == 1){
                //使启用的节点不再是灰色
                var beginNodeList = zTree.getNodesByParam("orgCd", orgCd, null);
                for(var i=0; i<beginNodeList.length; i++){
                    beginNodeList[i].stopstop = false;
                    beginNodeList[i].orgStatus = 1;
                    zTree.updateNode(beginNodeList[i]);
                }
                alert("启用成功！");
            }
            else{
                alert(checkResult.msg);
            }
        }
    })
}

//停用
function stopTreeNode(treeNode){
    //如果是root节点，不能删除
    if(treeNode.orgCd == "root"){
        alert("根节点不能进行此操作！");
        return ;
    }
    //如果当前节点已经是停用状态
    if(treeNode.orgStatus == 0){
        alert("当前节点已经是停用状态！");
        return;
    }
    //如果有有子节点
    if(treeNode.isParent){
        var msg = "要停用的节点是父节点，如果停用将连同子节点一起停用。\n\n请确认！";
        if(confirm(msg)){
            ajaxStopNode(treeNode.orgCd);
        }
    }
    //不是根节点
    else{
        if(confirm("是否确定停用？")){
            ajaxStopNode(treeNode.orgCd);
        }
    }
}

//ajax调用接口停用节点
function ajaxStopNode(orgCd){
    $.ajax({
        type:"post",
        url: basePath + "/" + baseOrgCd + "/sysOrg/stopOrg",
        data:{orgCd: orgCd},
        success:function(checkResult){
            if(checkResult.state == 1){
                //使停用的节点变灰
                var stopNodeList = zTree.getNodesByParamFuzzy("orgIndex", orgCd, null);
                for(var i=0; i<stopNodeList.length; i++){
                    stopNodeList[i].stopstop = true;
                    stopNodeList[i].orgStatus = 0;
                    zTree.updateNode(stopNodeList[i]);
                }
                alert("停用成功！");
            }
            else{
                alert(checkResult.msg);
            }
        }
    })
}

//删除节点
function removeTreeNode(treeNode){
    //如果是root节点，不能删除
    if(treeNode.orgCd == "root"){
        alert("根节点不能进行此操作！");
    }
    //不是root节点，提示判断是不是有子节点，如果有，confirm
    else if(treeNode.isParent){
        var msg = "要删除的节点是父节点，如果删除将连同子节点一起删掉。\n\n请确认！";
        if(confirm(msg)){
            //调用后台接口，设置为删除状态
            ajaxDelNode(treeNode.orgCd);
        }
    }
    //不是根节点
    else{
        if(confirm("是否确定删除？")){
            //调用后台接口，设置为删除状态
            ajaxDelNode(treeNode.orgCd);
        }
    }
}

//ajax调用接口删除节点
function ajaxDelNode(orgCd){
    $.ajax({
        type:"post",
        url: basePath + "/" + baseOrgCd + "/sysOrg/delOrg",
        data:{orgCd: orgCd},
        success:function(checkResult){
            if(checkResult.state == 1){
                //移除删除的节点
                var delNodeList = zTree.getNodesByParamFuzzy("orgIndex", orgCd, null);
                for(var i=0; i<delNodeList.length; i++){
                    zTree.removeNode(delNodeList[i]);

                    //更新父节点信息
                    var parentNode =  zTree.getNodesByParam("orgCd", delNodeList[i].engManCd, null)[0];
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

//验证组织机构code唯一性
function checkOrgCd(){
    $.ajax({
        type:"get",
        url: basePath + "/" + baseOrgCd + "/sysOrg/checkOrgCd",
        data:{orgCd: $("#orgCd").val(), orgId:$("#orgId").val()},
        success:function(checkResult){
            if(checkResult.state == 0){
                alert($("#orgCd").val()+checkResult.msg);
                $("#orgCd").focus();
            }
        }
    })
}

//提交增改组织机构
function subInfo(){
    //如果有组织机构编号，要进行的是修改
    if($("#orgId").val().length > 0){
        $.ajax({
            type:"post",
            url:basePath + "/" + baseOrgCd + "/sysOrg/updateOrg",
            data:$("#infoForm").serialize(),
            success:function(ref){
                alert("保存成功！");

                //如果这次更新了上级组织机构
                var newEngManCd = ref.data.newEngManCd;
                var oldEngManCd = ref.data.oldEngManCd;
                if(newEngManCd != oldEngManCd){
                    //重新加载上次的上级组织机构
                    var oldParentNode =  zTree.getNodesByParam("orgCd", oldEngManCd, null)[0];
                    //更新父节点信息
                    parentNodeUpdate_maintain(zTree, oldParentNode);
                }

                //需重新加载这次的上级组织机构
                var parentNode =  zTree.getNodesByParam("orgCd", newEngManCd, null)[0];
                //更新父节点信息
                parentNodeUpdate_increment(zTree, parentNode);
            }
        })
    }
    //如果没有组织机构编号，要进行的是新增
    else{
        $.ajax({
            type:"post",
            url:basePath + "/" + baseOrgCd + "/sysOrg/createOrg",
            data:$("#infoForm").serialize(),
            success:function(ref){
                alert("保存成功！");

                //父节点信息
                var parentNode =  zTree.getNodesByParam("orgCd", $("#engManCd").val(), null)[0];
                //更新父节点信息
                parentNodeUpdate_increment(zTree, parentNode);
            }
        })
    }

    //设置上级组织机构【组织机构不能是自己和自己的子节点】
    function setEngManCd(){
        
    }
}