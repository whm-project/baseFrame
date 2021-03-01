<!doctype html>
<html>
<head>
  <#include "../common.ftl">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>${prefix_orgNm?default('系统')}登录</title>
  <link rel="stylesheet" href="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/css/login.css">
  <script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/lib/layui/layui.js" charset="utf-8"></script>
</head>
<body class="login-bg">

    <div class="login">
        <div class="message">${prefix_orgNm?default('系统')}登录</div>
        <div id="darkbannerwrap"></div>   
        <form id="loginForm" name="loginForm" class="layui-form" >
            <input id="loginName" name="loginName" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input id="password" name="password" name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input id="code" name="code" lay-verify="required" placeholder="验证码"  type="text" class="layui-input" style="width: 65%; margin-right: 3%; float:left;">
            <img id="codeImg" title="点击更换验证码" style="vertical-align: middle; border-radius: 2%; width: 30%; margin-top: 5px;" onclick="changeCode('codeImg')"/>
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="button" onclick="checkUser('loginForm')">
            <hr class="hr20" >
        </form>
    </div>
    <script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/login.js" type="text/javascript"></script>
    <!-- 底部结束 -->
    
</body>
</html>