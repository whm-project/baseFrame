//初始化多页标题
function initTabTitle(superMenuCd) {
    //获取单页列表
    $.ajax({
        type:"get",
        url: basePath + "/" + baseOrgCd + "/sysMenu/menuList",
        data:{supMenuCd: superMenuCd},
        success: function (menuList) {
            //获取成功
            if(menuList.code == "0"){
                var first_cd = "";
                for(var i=0; i<menuList.data.length; i++){
                    //只要页面类型
                    if(menuList.data[i].menuType == "2"){
                        //添加标题
                        var title_item = $("#li_demo").clone(false);
                        //设置新节点的id
                        title_item.attr("id", menuList.data[i].menuCd+"_title");
                        //设置新节点的显示内容
                        title_item.html(menuList.data[i].menuNm);
                        //添加事件
                        title_item.attr('onclick', 'show_content("'+menuList.data[i].menuCd+'")');
                        //添加到节点
                        title_item.show();
                        title_item.appendTo( $("#title_list"));

                        //添加内容
                        var content_item = $("#content_demo").clone(false);
                        //设置新节点的id
                        content_item.attr("id", menuList.data[i].menuCd+"_content");
                        //设置新节点的显示内容
                        content_item.html("<iframe src='" + basePath + "/" + baseOrgCd + "/frame/showMenuPage?menuCd=" + menuList.data[i].menuCd+"'></iframe>");
                        //添加到节点
                        content_item.appendTo( $("#content_list"));

                        if(first_cd == ""){
                            first_cd = menuList.data[i].menuCd;
                        }
                    }
                }

                //默认显示第一个
                if(first_cd != ""){
                    show_content(first_cd);
                }
            }
        }
    })
}

//显示指定内容
function show_content(menuCd){
    $("#content_list").children().hide();
    $("#"+menuCd+"_content").show();

    //点击选中的切换颜色
}