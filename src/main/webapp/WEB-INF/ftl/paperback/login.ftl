<html>
<head>
    <#include "../common.ftl">
    <title>${(prefix_orgNm)?default("")}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/css/login.css">
    <style>
        .log {
            width:100%;
            height:100%;
            <#if prefix_org.loginBgimg?default("")?length lte 0>
                background:url(${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/images/login/bg.jpg) center bottom;
            <#else>
                background:url(${prefix_org.loginBgimg}) center bottom;
            </#if>
        }
    </style>
</head>

<body>
    <div class="log">
        <div class="logn">
            <h1>${(prefix_orgNm)?default("")}</h1>

            <form id="loginForm" name="loginForm" class="logn">
                <div class="login_layer">
                    <div class="login_factor">
                        <font>用户名：</font>
                        <input id="loginName" name="loginName" type="text" value="">
                    </div>

                    <div class="login_factor">
                        <font>密<i></i>码：</font>
                        <input id="password" name="password" type="password" value="">
                    </div>

                    <div class="login_factor">
                        <font>验证码：</font>
                        <input class="yzm" id="code" name="code" value=""/>
                        <img class="yzmImg" id="codeImg" title="点击更换验证码" onclick="changeCode('codeImg')"/>
                    </div>

                    <div class="login_factor_button">
                        <input id="sub_btn" class="btn" type="button" value="登录" onclick="checkUser('loginForm')"/>
                    </div>

                </div>
            </form>
        </div>
    </div>

    <script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/login.js" type="text/javascript"></script>
</body>
</html>