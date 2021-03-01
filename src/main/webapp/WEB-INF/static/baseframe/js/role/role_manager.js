//查询
function searchInfo(){
    $.ajax({
        type:"get",
        url:basePath + "/" + baseOrgCd + "/sysRole/pageRole",
        data:{"roleNm":$("#name").val(), "roleCd": $("#code").val(), "pageNumber":$("#pageNumber").val()},
        success:function(ref){
            if(ref.code == "0"){
                $("#dataTable").html("<tr>" +
                    "<th>角色名称</th>" +
                    "<th>角色代码</th>" +
                    "<th>备注</th>" +
                    "<th>操作</th>\n" +
                    "</tr>"
                );
                var dataList = ref.data;
                for(var i=0; i<dataList.length; i++){
                    $("#dataTable").append("" +
                        "<tr>" +
                        "   <td>"+dataList[i].roleNm+"</td>" +
                        "   <td>"+dataList[i].roleCd+"</td>" +
                        "   <td>"+dataList[i].nt+"</td>" +
                        "   <td>" +
                        "       <input type='button' value='编辑' onclick='editInfo(\""+dataList[i].roleId+"\")'/>" +
                        "       <input type='button' value='权限' onclick='roleMenu(\""+dataList[i].roleCd+"\")'/>" +
                        "       <input type='button' value='删除' onclick='delInfo(\""+dataList[i].roleId+"\")'/>" +
                        "   </td>" +
                        "</tr>"
                    );
                }
            }
        }
    })
}

//编辑
function editInfo(id){
    $.ajax({
        type:"post",
        url:basePath + "/" + baseOrgCd + "/sysRole/getRole",
        data:{"roleId":id},
        success:function(ref){
            if(ref.state == "1"){
                $("#roleId").val(ref.data.roleId);
                $("#roleNm").val(ref.data.roleNm);
                $("#roleCd").val(ref.data.roleCd);
                $("#roleOrder").val(ref.data.roleOrder);
                $("#nt").text(ref.data.nt);
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
    $("#roleId").val("");
    $("#roleNm").val("");
    $("#roleCd").val("");
    $("#roleOrder").val("10");
    $("#nt").text("");
    $("#addDiv").show();
}

//验证角色code唯一性
function checkRoleCd(){
    $.ajax({
        type:"get",
        url: basePath + "/" + baseOrgCd + "/sysRole/checkRoleCd",
        data:{roleCd: $("#roleCd").val(), roleId:$("#roleId").val()},
        success: function(checkResult) {
            if (checkResult.state == 0) {
                alert($("#roleCd").val() + checkResult.msg);
                $("#roleCd").focus();
            }
        }
    })
}

//提交增改角色
function subInfo(){
    //如果有角色编号，要进行的是修改
    if($("#roleId").val().length > 0){
        $.ajax({
            type:"post",
            url:basePath + "/" + baseOrgCd + "/sysRole/updateRole",
            data:$("#infoForm").serialize(),
            success:function(ref){
                alert("保存成功！");
                $("#addDiv").hide();

                //刷新页面
                searchInfo();
            }
        })
    }
    //如果没有组织机构编号，要进行的是新增
    else{
        $.ajax({
            type:"post",
            url:basePath + "/" + baseOrgCd + "/sysRole/createRole",
            data:$("#infoForm").serialize(),
            success:function(ref){
                alert("保存成功！");
                $("#addDiv").hide();

                //刷新页面
                searchInfo();
            }
        })
    }
}

//删除
function delInfo(roleId){
    if(confirm("确定删除该角色吗？")){
        $.ajax({
            type:"get",
            url:basePath + "/" + baseOrgCd + "/sysRole/deleteRole",
            data:{"roleId": roleId},
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
var set_menu_rolecd = "";
function roleMenu(roleCd){
    set_menu_rolecd = roleCd;
    $("#menu_multiple").attr("src", basePath + "/" + baseOrgCd + "/sysMenu/show_multiple");
    $("#menu_multiple").show();

    //设置默认选中节点
    get_defaultChecked(roleCd);
}

//设置权限树中默认选中节点
function get_defaultChecked(roleCd){
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
            setTimeout(function(){
                $('#menu_multiple')[0].contentWindow.set_defaultchecked(menucd_ary);
            }, 300);
        }
    })
}

//iframe页点击确定后获得已选中节点，并存入角色权限关联表
function handle_checked_node(nodes){
    //设置权限cd集合
    var menuCdAry = new Array();
    for(var i=0; i<nodes.length; i++){
        menuCdAry.push(nodes[i].menuCd);
    }

    //如果信息缺失，不提交
    if(set_menu_rolecd==""){
        alert("角色信息缺失，请检查！");
        return ;
    }

    //关闭设置权限窗口
    $("#menu_multiple").hide();

    //保存角色权限关联
    $.ajax({
        type:"get",
        url:basePath + "/" + baseOrgCd + "/sysRolemenu/save_roleMenu",
        data:{"menuCdAry": menuCdAry.toString(), "roleCd": set_menu_rolecd},
        success:function(ref){
            if(ref.state == "1"){
                alert("保存成功！");
            }else{
                alert(ref.msg);
            }
        }
    })
}