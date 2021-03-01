<!doctype html>
<html>
<head>
    <#include "../../common.ftl">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>角色选择</title>
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

<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/role/role_multiple.js" type="text/javascript"></script>
</body>
</html>