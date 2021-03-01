<!doctype html>
<html>
<head>
    <#include "../../common.ftl">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${basePath}/static/third/ztree/css/demo.css" type="text/css">
    <link rel="stylesheet" href="${basePath}/static/third/ztree/css/metroStyle/metroStyle.css" type="text/css">
    <title>组织机构</title>
</head>

<body>
    <div style="float: left; width: 40%">
        <#--树查询条件-->
        <div name="searchDiv">
            名称：<input id="name" id="name"><br>
            code：<input id="code" id="code">
            <input type="button" value="search" onclick="searchNode()">
        </div>
        <#--组织机构树-->
        <div class="zTreeDemoBackground left">
            <ul id="org_ztree" class="ztree"></ul>
        </div>
    </div>
    <#--增改信息-->
    <div style="float: left; width: 50%; margin: 15px;">
        <form id="infoForm">
            <h2 id="infoTitle"></h2>
            <input type="hidden" id="orgId" name="orgId" value=""/>
            <ul>
                <li>
                    名称：<input type="text" id="orgNm" name="orgNm" value="" placeholder="请输入组织机构名称" />
                </li>
                <li>
                    代码：<input type="text" id="orgCd" name="orgCd" value="" placeholder="请输入组织机构代码" oninput="checkOrgCd()"/>
                </li>
                <li>
                    类型：
                    <select id="orgType" name="orgType">
                        <option value="1">公司</option>
                        <option value="2">部门</option>
                    </select>
                </li>
                <li>
                    状态：
                    <select id="orgStatus" name="orgStatus">
                        <option value="1">正常</option>
                        <option value="0">已停用</option>
                        <option value="-1">已删除</option>
                    </select>
                </li>
                <li>
                    首页显示：<input type="text" id="orgWelcome" name="orgWelcome" value="" placeholder="请输入组织机构首页地址" />
                </li>
                <li>
                    使用布局库：
                    <select id="orgLayoutlib" name="orgLayoutlib">
                    </select>
                </li>
                <li>
                    使用样式库：
                    <select id="orgStylelib" name="orgStylelib">
                    </select>
                </li>
                <li>
                    排序字段：<input type="number" id="orgOrder" name="orgOrder" value="" placeholder="请输入组织机构排序字段" />
                </li>
                <li>
                    所属组织机构：
                    <input type="text" id="engManCd" name="engManCd" value="" placeholder="请选择所属组织机构" />
                </li>
                <li>
                    登录背景图：
                    <input type="text" id="loginBgimg" name="loginBgimg" value="" />
                </li>
                <li>
                    <input type="button" value="submit" onclick="subInfo()" />
                </li>
            </ul>

            <#--简称：<input type="text" name="orgShnm" value="" placeholder="请输入组织机构简称" /><br /><br />-->
            <#--联系人：<input type="text" name="contact" value="" placeholder="请输入组织机构联系人" /><br /><br />-->
            <#--联系电话：<input type="text" name="phone" value="" placeholder="请输入组织机构联系电话" /><br /><br />-->
            <#--邮箱：<input type="text" name="eMail" value="" placeholder="请输入组织架构邮箱" /><br /><br />-->
            <#--行政区划：<input type="text" id="adCd" name="adCd" value="" placeholder="请输入组织机构行政区划" /><br /><br />-->
            <#--地址：<input type="text" name="addr" value="" placeholder="请输入组织机构地址" /><br /><br />-->
            <#--办公室电话：<input type="text" name="tel" value="" placeholder="请输入组织机构办公室电话" /><br /><br />-->
            <#--传真号码：<input type="text" name="fax" value="" placeholder="请输入组织机构传真号码" /><br /><br />-->
            <#--备注：<input type="text" name="nt" value="" placeholder="请输入组织机构备注" /><br /><br />-->
            <#--主要业务内容：<input type="text" name="majBus" value="" placeholder="请输入组织机构主要业务内容" /><br /><br />-->
            <#--图片地址：<input type="text" name="orgImg" value="" placeholder="请输入组织机构图片地址" /><br /><br />-->
        </form>
    </div>

    <script src="${basePath}/static/third/ztree/js/jquery.ztree.core.js" type="text/javascript"></script>
    <script src="${basePath}/static/third/ztree/js/jquery.ztree.excheck.js" type="text/javascript"></script>
    <script src="${basePath}/static/third/ztree/js/jquery.ztree.exedit.js" type="text/javascript"></script>
    <script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/common/ztreeCommon.js" type="text/javascript"></script>
    <script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/org/org_manager.js" type="text/javascript"></script>
</body>
</html>