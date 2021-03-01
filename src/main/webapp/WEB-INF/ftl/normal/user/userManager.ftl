<html>
<head>
    <#include "../../common.ftl">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>用户管理</title>
</head>

<body>
    <#-- 搜索栏 -->
    <div id="searchDiv">
        <abbr id="search_orgCd">
            组织机构编码：
            <input type="text" id="cd" name="cd" value="${prefix_orgCd?default('')}" placeholder="请输入组织机构编码" />
        </abbr>
        <abbr>
            名称：
            <input id="name" id="name" value="" placeholder="请输入用户名称" />
        </abbr>
        <abbr>
            code：
            <input id="code" id="code" value="" placeholder="请输入用户编码" />
        </abbr>
        <input type="button" value="search" onclick="searchInfo()">
        <input type="button" value="add" onclick="addInfo()">
        <#--TODO 做成开关样式 -->
        <input type="button" value="含子集" onclick="all_user()">
        <input type="button" value="不含子集" onclick="org_user()">
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
            <input type="hidden" id="userId" name="userId" value=""/>
            <ul>
                <li>
                    名称：<input type="text" id="userNm" name="userNm" value="" placeholder="请输入用户名称" />
                </li>
                <li>
                    代码：<input type="text" id="userCd" name="userCd" value="" placeholder="请输入用户代码" oninput="checkUserCd()"/>
                </li>
                <li>
                    手机号：<input type="text" id="userTel" name="userTel" value="" placeholder="请输入用户手机号" />
                </li>
                <li>
                    用户性别：
                    <select id="userSex" name="userSex">
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                </li>
                <li>
                    用户状态：
                    <select id="userStatus" name="userStatus">
                        <option value="1">正常</option>
                        <option value="0">停用</option>
                        <option value="-1">已删除</option>
                    </select>
                </li>
                <li>
                    <input type="button" value="submit" onclick="subInfo()" />
                </li>
            </ul>
        </form>
    </div>

    <#--设置权限栏-->
    <iframe id="menu_multiple" src="" style="width: 600px; height: 600px; display: none;"></iframe>
    <#--选择角色-->
    <iframe id="role_multiple" src="" style="width: 600px; height: 600px; display: none;"></iframe>

<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/common/addBtn.js" type="text/javascript"></script>
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/user/user_manager.js" type="text/javascript"></script>
</body>
</html>