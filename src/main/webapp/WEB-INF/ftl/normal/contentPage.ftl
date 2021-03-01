<html>
<head>
    <#include "../common.ftl">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/css/contentPage.css">
    <title>跳转页面</title>
</head>

<body>
<#--如果是单页，直接跳转-->
<#if (menuInfo.pageType)?default("1") == "1">
    <script>window.location.href= "../${(menuInfo.menuUrl)?default('')}?menucd=${(menuInfo.menuCd)?default('')}";</script>
<#--如果不是单页，需要进行拼接-->
<#else>
    <li id="li_demo" style="display: none;">tab标题</li>
    <div id="content_demo" style="display: none;"></div>
    <div>
       <ul id="title_list" style="padding-inline-start: 0;"></ul>
    </div>
    <div id="content_list" style="width:100%; height:calc( 100% - 50px);"></div>
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