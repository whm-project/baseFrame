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
    </div>
    <#--菜单树-->
    <div class="zTreeDemoBackground left">
        <ul id="menu_ztree" class="ztree"></ul>
    </div>
</div>
<#--增改信息-->
<div style="float: left; width: 50%; margin: 15px;">
    <form id="infoForm">
        <h2 id="infoTitle"></h2>
        <input type="hidden" id="menuId" name="menuId" value=""/><br /><br />
        <ul>
            <li>
                名称：<input type="text" id="menuNm" name="menuNm" value="" placeholder="请输入名称" />
            </li>
            <li>
                代码：<input type="text" id="menuCd" name="menuCd" value="" placeholder="请输入代码" oninput="checkMenuCd()"/>
            </li>
            <li>
                菜单类型：
                <select id="menuType" name="menuType" onchange="menuTypeOrPageTypeChange()">
                    <option value="1">模块</option>
                    <option value="2">页面</option>
                    <option value="3">按钮</option>
                </select>
            </li>
            <li id="pageTypeLi" style="display: none">
                页面类型：
                <select id="pageType" name="pageType" onchange="menuTypeOrPageTypeChange()">
                    <option value="1">单页</option>
                    <option value="2">多页</option>
                </select>
            </li>
            <li id="btnPositionLi" style="display: none">
                按钮位置：
                <select id="btnPosition" name="btnPosition">
                    <option value="1">按钮栏</option>
                    <option value="2">操作栏</option>
                </select>
            </li>
            <li id="menuUrlLi" style="display: none">
                <span>页面url：</span><input type="text" id="menuUrl" name="menuUrl" value="" placeholder="请输入页面url" />
            </li>
            <li id="btnOperationLi" style="display: none">
                按钮方法：<input type="text" id="menuOther1" name="menuOther1" value="" placeholder="请输入按钮方法" />
            </li>
            <li>
                上级菜单：<input type="text" id="supMenuCd" name="supMenuCd" value="" placeholder="请选择上级菜单" />
                <span style="display: none;">TODO 上级菜单不能是自己和自己的子节点，只能是模块或页面</span>
            </li>
            <li>
                排序字段：<input type="number" id="menuOrder" name="menuOrder" value="" placeholder="请输入排序字段" />
            </li>
            <li>
                默认图标：<input type="text" id="menuOther2" name="menuOther2" value="" placeholder="请输入默认图表地址" />
            </li>
            <li id="openIconLi">
                展开图标：<input type="text" id="menuOther3" name="menuOther3" value="" placeholder="请输入展开图标地址" />
            </li>
            <li id="baseBtnLi" style="display: none;">
                基础按钮：
                <select id="menuOther4" name="menuOther4" onchange="baseBtnChange()">
                    <option value="0">否</option>
                    <option value="1">是</option>
                </select>
            </li>
            <li>
                <input type="button" value="submit" onclick="subInfo()" />
            </li>
        </ul>
    </form>
</div>

<script src="${basePath}/static/third/ztree/js/jquery.ztree.core.js" type="text/javascript"></script>
<script src="${basePath}/static/third/ztree/js/jquery.ztree.excheck.js" type="text/javascript"></script>
<script src="${basePath}/static/third/ztree/js/jquery.ztree.exedit.js" type="text/javascript"></script>
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/common/ztreeCommon.js" type="text/javascript"></script>
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/menu/menu_manager.js" type="text/javascript"></script>
</body>
</html>