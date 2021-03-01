/**初始化页面**/
$(function () {
    //设置首页地址
    setCoverIFrameUrl();
});

/**
 * 改变菜单栏宽度
 * @param menu_width
 */
function changeMenuWidth(menu_width){
    if(document.getElementsByClassName("menuDiv").item(0).style.width != menu_width){
        document.getElementsByClassName("menuDiv").item(0).style.width = menu_width;
        document.getElementsByClassName("modularDiv").item(0).style.width = "calc( 100% - "+menu_width+" )";
    }
}

/**
 * 设置首页地址
 */
function setCoverIFrameUrl(){
    $.ajax({
        type:"post",
        url: basePath + "/" + baseOrgCd + "/sysOrg/getOrgInfo",
        success: function (res) {
            $("#coverIFrame").attr("src", res.data.orgWelcome);
        }
    })
}

//打开页面
var currentMenuCd = "";
function openPage(menuCd){
    //切换菜单
    if(currentMenuCd != menuCd){
        document.getElementById("coverIFrame").src = basePath + "/" + baseOrgCd + "/frame/showMenuPage?menuCd=" + menuCd;
        currentMenuCd = menuCd;
    }
    //阻止冒泡
    var event = window.event;
    event.stopPropagation();
}