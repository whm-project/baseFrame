//初始化多页标题
function initTabTitle(superMenuCd) {
    //获取单页列表
    $.ajax({
        type:"get",
        url: basePath + "/" + baseOrgCd + "/sysMenu/menuList",
        async:false,
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
                        title_item.attr('onclick', 'add_content("'+menuList.data[i].menuCd+'")');
                        //添加到节点
                        title_item.removeAttr("style");
                        title_item.appendTo( $("#title_list"));

                        //默认显示第一个tab
                        if(first_cd == ""){
                            first_cd = menuList.data[i].menuCd;
                        }
                    }
                }

                //默认显示第一个
                if(first_cd != ""){
                    add_content(first_cd);
                }
            }
        }
    })
}

//第一次点击添加对应的内容
function add_content(menuCd){
    //添加内容
    var content_item = $("#content_demo").clone(false);
    //设置新节点的id
    content_item.attr("id", menuCd+"_content");
    //设置新节点的显示内容
    content_item.html("<iframe src='" + basePath + "/" + baseOrgCd + "/frame/showMenuPage?menuCd=" + menuCd+"'style='width: 100%;height: 100%;border: 0;'></iframe>");
    //添加到节点
    content_item.removeAttr("style");
    content_item.appendTo( $("#content_list"));

    //显示刚添加的内容
    show_content(menuCd);

    //设置这个节点在点击就是切换显示
    $("#" + menuCd + "_title").attr('onclick', 'show_content("'+menuCd+'")');
}

//第二次点击显示指定内容
function show_content(menuCd){
    $("#title_list").children().removeClass("layui-this");
    $("#content_list").children().removeClass("layui-show");
    $("#"+menuCd+"_title").addClass("layui-this");
    $("#"+menuCd+"_content").addClass("layui-show");
}