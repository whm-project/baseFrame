//设置按钮
setBtnDiv("searchDiv");
var operationBtn = getOperationDivBtn();

//查询
function searchInfo(){
    $.ajax({
        type:"get",
        url:basePath + "/" + baseOrgCd + "/sysUser/pageUser",
        data:{
            "orgCd": $("#cd").val(),
            "userNm":$("#name").val(),
            "userCd": $("#code").val(),
            "pageNumber":$("#pageNumber").val(),
            "order": "userStatus desc",
            "all_flag":all_flag
        },
        success:function(ref){
            if(ref.code == "0"){
                $("#dataTable").html("<tr>" +
                    "<th>用户代码</th>" +
                    "<th>用户名称</th>" +
                    "<th>用户手机号</th>" +
                    "<th>用户性别</th>" +
                    "<th>用户状态</th>" +
                    "<th>组织机构</th>" +
                    "<th>操作</th>\n" +
                    "</tr>"
                );
                var dataList = ref.data;
                for(var i=0; i<dataList.length; i++){
                    var item = dataList[i];

                    var trHtmlStr =
                        "<tr>" +
                        "   <td>"+dataList[i].userCd+"</td>" +
                        "   <td>"+dataList[i].userNm+"</td>" +
                        "   <td>"+dataList[i].userTel+"</td>" +
                        "   <td>"+dataList[i].userSex+"</td>" +
                        "   <td>"+dataList[i].userStatus+"</td>" +
                        "   <td>"+dataList[i].orgCd+"</td>";
                    trHtmlStr += "<td>";
                    for(var j=0; j<operationBtn.length; j++){
                        trHtmlStr += " <input type='button' value='" + operationBtn[j].menuNm + "' onclick='"+ operationBtn[j].menuOther1 +"'/>";
                    }
                    trHtmlStr +=
                        " <input type='button' value='编辑' onclick='editInfo(\""+dataList[i].userId+"\")'/>" +
                        "<input type='button' value='权限' onclick='userMenu(\""+dataList[i].userCd+"\")'/>" +
                        "<input type='button' value='角色' onclick='userRole(\""+dataList[i].userCd+"\")'/>" +
                        "<input type='button' value='删除' onclick='delInfo(\""+dataList[i].userId+"\")'/>";
                    trHtmlStr +="</td>";

                    trHtmlStr += "</tr>";

                    $("#dataTable").append(trHtmlStr);
                }
            }
        }
    })
}

//编辑
function editInfo(id){
    $.ajax({
        type:"post",
        url:basePath + "/" + baseOrgCd + "/sysUser/getUser",
        data:{"userId":id},
        success:function(ref){
            if(ref.state == "1"){
                $("#userId").val(ref.data.userId);
                $("#userNm").val(ref.data.userNm);
                $("#userCd").val(ref.data.userCd);
                $("#userTel").val(ref.data.userTel);
                $("#userSex").find("option[value='"+ref.data.userSex+"']").prop("selected",true);
                $("#userStatus").find("option[value='"+ref.data.userStatus+"']").prop("selected",true);
                $("#addDiv").show();
            }
            else{
                alert(ref.msg);
            }
        }
    })
}

//新增
function addInfo(){
    $("#userId").val("");
    $("#userNm").val("");
    $("#userCd").val("");
    $("#userTel").val("");
    $("#userSex").find("option[value='1']").prop("selected",true);
    $("#userStatus").find("option[value='1']").prop("selected",true);
    $("#addDiv").show();
}

//验证用户code唯一性
function checkUserCd(){
    $.ajax({
        type:"get",
        url: basePath + "/" + baseOrgCd + "/sysUser/checkUserCd",
        data:{userCd: $("#userCd").val(), userId:$("#userId").val()},
        success: function(checkResult) {
            if (checkResult.state == 0) {
                alert($("#userCd").val() + checkResult.msg);
                $("#userCd").focus();
            }
        }
    })
}

//提交增改用户
function subInfo(){
    //如果有用户编号，要进行的是修改
    if($("#userId").val().length > 0){
        $.ajax({
            type:"post",
            url:basePath + "/" + baseOrgCd + "/sysUser/updateUser",
            data:$("#infoForm").serialize(),
            success:function(ref){
                if(ref.state == 1){
                    alert("保存成功！");
                }
                else{
                    alert("保存失败！");
                }
                $("#addDiv").hide();

                //刷新页面
                searchInfo();
            }
        })
    }
    //如果没有用户编号，要进行的是新增
    else{
        $.ajax({
            type:"post",
            url:basePath + "/" + baseOrgCd + "/sysUser/createUser",
            data:$("#infoForm").serialize(),
            success:function(ref){
                if(ref.state == 1){
                    alert("保存成功！");
                    $("#addDiv").hide();
                }
                else{
                    alert("保存失败！");
                    $("#addDiv").hide();
                }

                //刷新页面
                searchInfo();
            }
        })
    }
}

//删除
function delInfo(userId){
    if(confirm("确定删除该用户吗？")){
        $.ajax({
            type:"get",
            url:basePath + "/" + baseOrgCd + "/sysUser/deleteUser",
            data:{"userId": userId},
            success:function(ref){
                if(ref.state == "1"){
                    alert("删除成功！");
                    //刷新页面
                    searchInfo();
                }else{
                    alert("删除失败！");
                }
            }
        })
    }
}

//设置权限
var set_menu_usercd = "";
function userMenu(userCd){
    set_menu_usercd = userCd;
    $("#menu_multiple").attr("src", basePath + "/" + baseOrgCd + "/sysMenu/show_multiple");
    $("#menu_multiple").show();

    //设置默认选中节点
    get_defaultChecked(userCd);
}

//选择角色
function userRole(userCd){
    $("#role_multiple").attr("src", basePath + "/" + baseOrgCd + "/sysRole/select");
    $("#role_multiple").show();
}

//设置权限树中默认选中节点
function get_defaultChecked(userCd){
    $.ajax({
        type:"get",
        url:basePath + "/" + baseOrgCd + "/sysUsermenu/getUserMenuList",
        data:{"userCd": userCd},
        success:function(ref){
            //只要menucd
            var menucd_ary = new Array();
            for(var i=0; i<ref.length; i++){
                menucd_ary.push(ref[i].menuCd);
            }

            //调用子iframe的设置选中方法
            setTimeout(function(){
                $('#menu_multiple')[0].contentWindow.set_defaultchecked(menucd_ary);
            }, 300);
        }
    })
}

//iframe页点击确定后获得已选中节点，并存入用户权限关联表
function handle_checked_node(nodes){
    //设置权限cd集合
    var menuCdAry = new Array();
    for(var i=0; i<nodes.length; i++){
        menuCdAry.push(nodes[i].menuCd);
    }

    //如果信息缺失，不提交
    if(set_menu_usercd==""){
        alert("用户信息缺失，请检查！");
        return ;
    }

    //关闭设置权限窗口
    $("#menu_multiple").hide();

    //保存用户权限关联
    $.ajax({
        type:"get",
        url:basePath + "/" + baseOrgCd + "/sysUsermenu/save_userMenu",
        data:{"menuCdAry": menuCdAry.toString(), "userCd": set_menu_usercd},
        success:function(ref){
            if(ref.state == "1"){
                alert("保存成功！");
            }else{
                alert(ref.msg);
            }
        }
    })
}

//设置树节点是否选中
function setRoleMenuChecked(roleCd, checked_status){
    $.ajax({
        type:"get",
        url:basePath + "/" + baseOrgCd + "/sysRolemenu/getRoleMenuList",
        data:{"roleCd": roleCd},
        success:function(ref){
            //只要menucd
            var menucd_ary = new Array();
            for(var i=0; i<ref.length; i++){
                menucd_ary.push(ref[i].menuCd);
            }

            //调用子iframe的设置选中方法
            if(checked_status){
                setTimeout(function(){
                    $('#menu_multiple')[0].contentWindow.set_defaultchecked(menucd_ary);
                }, 300);
            }else{
                setTimeout(function(){
                    $('#menu_multiple')[0].contentWindow.set_cancelchecked(menucd_ary);
                }, 300);
            }
        }
    })
}

//根据角色传来的cd获取相关的权限
function getRoleMenu(roleCd, nodeStatus, checked_cdAry){
    //如果是选中，增加选中的权限
    if(nodeStatus){
        setRoleMenuChecked(roleCd, true);
    }

    //如果是取消选中，先取消掉该角色相关的权限，在设置其他选中角色有的权限
    else{
        //取消角色的权限取消选中
        setRoleMenuChecked(roleCd, false);

        //遍历选中的角色，选中节点
        setTimeout(function(){
            for(var i=0; i<checked_cdAry.length; i++){
                setRoleMenuChecked(checked_cdAry[i], true);
            }
        }, 100);
    }
}

// todo 获取开关的选中与否，放到全局变量
var all_flag = false;
function all_user(){
    //如果之前是当前组织机构用户，需要刷新
    if(!all_flag){
        all_flag = true;
        searchInfo();
    }
}

function org_user(){
    //如果之前是所有能管理用户，需要刷新
    if(all_flag){
        all_flag = false;
        searchInfo();
    }
}