<!doctype html>
<html>
<head>
    <#include "../../common.ftl">
    <title>菜单</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${basePath}/static/third/ztree/css/demo.css" type="text/css">
    <link rel="stylesheet" href="${basePath}/static/third/ztree/css/metroStyle/metroStyle.css" type="text/css">
</head>
<body>

<div style="float: left; width: 40%">
    <#--树查询条件-->
    <div name="searchDiv">
        名称：<input id="name" id="name"><br>
        code：<input id="code" id="code">
        <input type="button" value="search" onclick="searchNode()">
        <input id="getNode_btn" type="button" value="确定" onclick="getNenu()">
    </div>
    <#--菜单树-->
    <div class="zTreeDemoBackground left">
        <ul id="menu_ztree" class="ztree"></ul>
    </div>
</div>

<script src="${basePath}/static/third/ztree/js/jquery.ztree.core.js" type="text/javascript"></script>
<script src="${basePath}/static/third/ztree/js/jquery.ztree.excheck.js" type="text/javascript"></script>
<script src="${basePath}/static/third/ztree/js/jquery.ztree.exedit.js" type="text/javascript"></script>
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/common/ztreeCommon.js" type="text/javascript"></script>
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/menu/menu_manager_multiple.js" type="text/javascript"></script>
</body>
</html>