<html>
<head>
    <#include "../common.ftl">
    <title>${prefix_orgNm?default('后台')}管理系统</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/css/x-admin.css" media="all">
</head>

<body>
<#--如果是单页，直接跳转-->
<#if (menuInfo.pageType)?default("1") == "1">
    <script>window.location.href= "../${(menuInfo.menuUrl)?default('')}?menucd=${(menuInfo.menuCd)?default('')}";</script>
<#--如果不是单页，需要进行拼接-->
<#else>
    <div>
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief" style="margin: 0">
            <ul id="title_list" class="layui-tab-title"></ul>
            <div id="content_list" class="layui-tab-content" style="height: 80%"></div>
        </div>
    </div>

    <li id="li_demo" style="display: none;">tab标题</li>
    <div id="content_demo" class="layui-tab-item" style="display: none;"></div>
</#if>

<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/contentPage.js" type="text/javascript"></script>
<script>
    //初始化
    $(function(){
        initTabTitle("${(menuInfo.menuCd)?default('')}");
    });
</script>
</body>
</html>