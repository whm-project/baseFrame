<!doctype html>
<html>
<head>
  <#include "../common.ftl">
  <meta charset="utf-8">
  <title>${prefix_orgNm?default('后台')}管理系统</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="format-detection" content="telephone=no">

  <link rel="shortcut icon" href="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/favicon.ico" type="image/x-icon" />
  <link rel="stylesheet" href="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/css/x-admin.css" media="all">
</head>
<style>
  .show_list{display: block;}
  .hide_lits{display: none;}
</style>

<body>
<div class="layui-layout layui-layout-admin">

  <#--header-->
  <div class="layui-header header header-demo">
    <div class="layui-main">
      <div class="admin-logo-box">
        <a class="logo" href="" title="logo">${prefix_orgNm?default('后台管理系统')}</a>
        <div class="larry-side-menu">
            <#--折叠按钮菜单-->
          <i class=" layui-icon iconfont" aria-hidden="true">&#xe83c;</i>
        </div>
      </div>
      <#--日期及个人信息-->
      <ul class="layui-nav" lay-filter="">
        <li class="layui-nav-item" id="time" style="margin-right: 50px;font-size: 20px;color: #2fb9d4;font-family: 'yjsz'"></li>
        <li class="layui-nav-item"> <a href="javascript:;">${userNm?default('游客')}</a>
          <dl class="layui-nav-child">
            <!-- 二级菜单 -->
            <dd><a href="javascript:;" onclick="member_show('${userNm?default('游客')}','showCustomPage?pageStr=user/view?userCd=${userCd?default('')}','10001','360','400')">个人信息</a></dd>
            <dd><a href="">修改密码</a></dd>
            <dd><a href="javascript:;" onclick="logout()">退出</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>

  <!--左侧导航区域-->
  <div class="layui-side layui-bg-black x-side show_list" style="left:0px;" id="table1">
    <div style="height: 130px; width: 220px; ">
      <a class="img" title="我的头像" style="display: block;width: 80px;height: 80px;margin: 10px auto 10px;">
        <img src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/images/tx.jpg" class="userAvatar" style="display: block;width: 100%;height: 100%;border-radius: 50%;-webkit-border-radius: 50%;-moz-border-radius: 50%;border: 4px solid #44576b;box-sizing: border-box;">
      </a>
      <p style=" display: block;width: 100%;height: 25px;color: #ffffff;text-align: center;font-size: 12px;white-space: nowrap;line-height: 25px;overflow: hidden;">
        你好, 欢迎回来！
      </p>
    </div>
    <div class="layui-side-scroll">
      <#include "nav.ftl">
    </div>
  </div>

  <#--内容-->
  <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true" style="left: 220px;border-left: solid 2px #2299ee;">
    <ul class="layui-tab-title">
      <li class="layui-this">首页 <i class="layui-icon layui-unselect layui-tab-close">ဆ</i> </li>
    </ul>
    <div class="layui-tab-content site-demo site-demo-body" style="padding: 10px 20px;">
      <div class="layui-tab-item layui-show">
        <iframe id="coverIFrame" frameborder="0" src="" class="x-iframe"></iframe>
      </div>
    </div>
  </div>
  <div class="site-mobile-shade"> </div>

</div>

<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/x-admin.js"></script>
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/x-layui.js" charset="utf-8"></script>
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/x-logout.js" charset="utf-8"></script>
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/frame.js" charset="utf-8"></script>

<script>
    layui.use(['laydate','element','laypage','layer'], function(){
        $ = layui.jquery;//jquery
        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层
        //以上模块根据需要引入

    });

    function member_show(title,url,id,w,h){
      x_admin_show(title,url,w,h);
    }
</script>
</body>
</html>