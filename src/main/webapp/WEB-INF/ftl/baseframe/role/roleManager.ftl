<!doctype html>
<html>
<head>
    <#include "../../common.ftl">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>角色管理</title>
</head>

<body>
    <#-- 搜索栏 -->
    <div id="searchDiv">
        名称：<input id="name" id="name">
        code：<input id="code" id="code">
        <input type="button" value="search" onclick="searchInfo()">
        <input type="button" value="add" onclick="addInfo()">
    </div>

    <#-- 数据栏 -->
    <div id="dataDiv">
        <table id="dataTable" border="1">
        </table>
        < &nbsp;&nbsp;&nbsp;&nbsp; 第<input type="text" id="pageNumber" style="width: 30px;" value="1" />页 &nbsp;&nbsp;&nbsp;&nbsp; >
    </div>

    <#-- 新增 -->
    <div id="addDiv" style="display: none">
        <form id="infoForm">
            <input type="hidden" id="roleId" name="roleId" value=""/>
            <ul>
                <li>
                    名称：<input type="text" id="roleNm" name="roleNm" value="" placeholder="请输入角色名称" />
                </li>
                <li>
                    代码：<input type="text" id="roleCd" name="roleCd" value="" placeholder="请输入角色代码" oninput="checkRoleCd()"/>
                </li>
                <li>
                    排序字段：<input type="number" id="roleOrder" name="roleOrder" value="" placeholder="请输入角色排序字段" />
                </li>
                <li>
                    备注：
                    <textarea id="nt" name="nt" value="" placeholder="请输入备注" ></textarea>
                </li>
                <li>
                    <input type="button" value="submit" onclick="subInfo()" />
                </li>
            </ul>
        </form>
    </div>

    <#--设置权限栏-->
    <iframe id="menu_multiple" src="" style="width: 900px; height: 600px; display: none;"></iframe>

<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/role/role_manager.js" type="text/javascript"></script>
</body>
</html>