// init_click();
setMenuList("root", "menu_list", "demo_menu_item");

/**
 * 根据上级菜单编码获取菜单集合，在指定节点显示
 */
function setMenuList(supMenuCd, parentId, cloneId) {
    //获取菜单列表
    $.ajax({
        type:"get",
        url: basePath + "/" + baseOrgCd + "/sysMenu/menuList",
        async: false,
        data:{supMenuCd: supMenuCd},
        success: function (menuList) {
            //获取成功
            if(menuList.code == "0"){

                //拼接菜单字符串
                var level_menu_html = "";
                for(var i=0; i<menuList.data.length; i++){
                    //已有这个节点，不再添加
                    if(typeof($("#"+menuList.data[i].menuCd).attr("id")) !="undefined"){
                        continue;
                    }

                    //如果是按钮菜单，不显示
                    if(menuList.data[i].menuType != "3"){
                        var menu_item = $("#"+cloneId).clone(false);
                        //设置新节点的id
                        menu_item.attr('id', menuList.data[i].menuCd);
                        //设置新节点的显示内容
                        menu_item.find("cite").html(menuList.data[i].menuNm);

                        //如果是页面，直接跳转
                        if(menuList.data[i].menuType == "2"){
                            menu_item.find("a").attr('_href', basePath + "/" + baseOrgCd + "/frame/showMenuPage?menuCd=" + menuList.data[i].menuCd);
                        }

                        //设置显示
                        menu_item.removeAttr("style");

                        //添加到节点
                        menu_item.appendTo( $("#"+parentId));

                        //如果有下级，添加这个节点的下级
                        if(menuList.data[i].menuIsparent == "1" && menuList.data[i].menuType == "1"){
                            /**
                             * TODO 添加加载子节点加载的按钮
                             */

                            //设置子菜单的ul的id
                            menu_item.find("dl").attr("id", "secondLevel_menu_list_"+menuList.data[i].menuCd);

                            //加载下级
                            setMenuList(menuList.data[i].menuCd, "secondLevel_menu_list_"+menuList.data[i].menuCd, "demo_secondLevel_menu_item");
                        }
                    }
                }
            }
        }
    })
}

/**
 * 设置展开收缩效果样式
 */
function init_click(){
    // nav收缩展开
    $('#menu_list').on('click','.layui-nav-item>a',function(){
        if (!$('.nav').hasClass('nav-mini')) {
            if ($(this).next().css('display') == "none") {
                //展开未展开
                $('.layui-nav-item').children('dl').slideUp(300);
                $(this).next('dl').slideDown(300);
                $(this).parent('li').addClass('nav-show').siblings('li').removeClass('nav-show');
            }else{
                //收缩已展开
                $(this).next('dl').slideUp(300);
                $('.layui-nav-item.nav-show').removeClass('nav-show');
            }
        }
    });

    // mini_nav 鼠标移动上去时，设置展开高度
    $('#menu_list').on('mouseover','.layui-nav-item',function(){
        if ($('.nav').hasClass('nav-mini')) {
            var bodyHeight = document.body.offsetHeight;
            var ulTop = $(this).offset().top;
            var ulHeight = bodyHeight - ulTop - 10;

            //如果高度比距离上边的还大，在上边显示
            if(ulHeight < ulTop){
                ulHeight = Number(document.body.offsetHeight) - 10;
                $(this).find('ul').attr("style", "max-height:"+ ulHeight +"px; bottom:0px;");
            }else{
                $(this).find('ul').attr("style", "max-height:"+ ulHeight +"px; top:"+ulTop+"px;");
            }
        }
    });

    // 标志点击样式
    $('#menu_list').on('click','.nav-item>ul>li',function(){
        $('.nav-item>ul>li').css('background','none');
        $(this).css('background','rgb(245, 247, 250)');
    });

    //nav-mini切换
    $('#mini').on('click',function(){
        if (!$('.nav').hasClass('nav-mini')) {
            $('.nav').addClass('nav-mini');
            $('.nav-item.nav-show').removeClass('nav-show');
            $('.nav-item').children('ul').removeAttr('style');

            //设置菜单栏的滚动条
            $('.nav>ul').css("overflow-y", "hidden");
            $("#title_svg_shousuo").hide();
            $("#pro_title").hide();
            $('.nav>ul').css("overflow-y", "auto");
            $("#title_svg_zhankai").show();

            //设置布局
            changeMenuWidth("50px");
        }else{
            $('.nav').removeClass('nav-mini');

            //设置菜单栏的滚动条
            $('.nav>ul').css("overflow-y", "hidden");
            $("#title_svg_zhankai").hide();
            $('.nav>ul').css("overflow-y", "auto");
            $("#title_svg_shousuo").show();
            $("#pro_title").show();

            //设置布局
            changeMenuWidth("220px");
        }
    });
}