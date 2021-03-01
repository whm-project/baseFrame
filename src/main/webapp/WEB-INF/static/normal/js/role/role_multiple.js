//查询
function searchInfo(){
    $.ajax({
        type:"get",
        url:basePath + "/" + baseOrgCd + "/sysRole/pageRole",
        data:{"roleNm":$("#name").val(), "roleCd": $("#code").val(), "pageNumber":$("#pageNumber").val()},
        success:function(ref){
            if(ref.code == "0"){
                $("#dataTable").html("<tr>" +
                    "<th><input type='checkbox' id='all_checked' /></th>" +
                    "<th>角色名称</th>" +
                    "<th>角色代码</th>" +
                    "<th>备注</th>" +
                    "</tr>"
                );
                var dataList = ref.data;
                for(var i=0; i<dataList.length; i++){
                    $("#dataTable").append("" +
                        "<tr>" +
                        "   <td><input type='checkbox' name='role_checked' value='"+dataList[i].roleCd+"' onclick='changeChecked(this)' /></td>" +
                        "   <td>"+dataList[i].roleNm+"</td>" +
                        "   <td>"+dataList[i].roleCd+"</td>" +
                        "   <td>"+dataList[i].nt+"</td>" +
                        "</tr>"
                    );
                }
            }
        }
    })
}

//复选框选择状态修改
function changeChecked(roleNode){
    var checked_cd = new Array();
    var checked_ele = document.getElementsByName("role_checked");
    for(var i=0; i<checked_ele.length; i++){
        if(checked_ele[i].checked){
            checked_cd.push(checked_ele[i].value);
        }
    }
    window.parent.getRoleMenu(roleNode.value, roleNode.checked, checked_cd);
}