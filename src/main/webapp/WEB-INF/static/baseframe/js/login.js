/初始化页面/
$(function () {
    changeCode('codeImg');
})

//验证码图片点击事件
function changeCode(eleId) {
    $("#"+eleId).attr('src', basePath + "/" + baseOrgCd + "/login/getCode?timestamp=" + (new Date()).valueOf());
}

//验证
function checkUser(formId){
    var loginName = $("#loginName").val();
    var password = $("#password").val();
    var code = $("#code").val();
    if(loginName == null || typeof(loginName) == "undefined" || loginName==""){
        alert("登录名必填");
        $("#loginName").fource();
        return ;
    }
    if(password == null || typeof(password) == "undefined" || password==""){
        alert("密码必填");
        return ;
    }
    if(code == null || typeof(code) == "undefined" || code==""){
        alert("验证码必填");
        return ;
    }

    //请求后台登录
    ajaxLogin(formId);
}

//回车请求
$(document).ready(function(){
    $(document).keydown(function(e){
        var curKey = e.which;
        if(curKey == 13){
            checkUser("loginForm");
        }
    });
});

//请求后台登录
function ajaxLogin(formId){
    $.ajax({
        type:"post",
        url: basePath + "/" + baseOrgCd + "/login/userLogin",
        data:$("#"+formId).serialize(),
        success:function(checkResult){
            if(checkResult.state == 1){
                var pageUrl = window.location.href;
                //如果是登录页，进主页
                if(pageUrl.indexOf("login") != -1){
                    window.location.href = basePath + "/" + baseOrgCd + "/frame";
                }
                //如果不是登录页，reload页面
                else{
                    window.location.reload();
                }
            }
            else{
                alert(checkResult.msg);
                changeCode('codeImg');
            }
        }
    })
}