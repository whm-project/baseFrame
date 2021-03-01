<!doctype html>
<html>
<head>
    <#include "../../common.ftl">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>用户管理</title>
    <link href="${basePath}/static/third/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" />
    <link href="${basePath}/static/third/bootstrap/bootstrap-table-master/dist/bootstrap-table.css" rel="stylesheet" />
    <link href="${basePath}/static/third/bootstrap/bootstrap-table-master/dist/extensions/fixed-columns/bootstrap-table-fixed-columns.css" rel="stylesheet" />
</head>

<body>
<div>

    <#-- 搜索栏 -->
    <form class="form-inline float-left" id="searchDiv">
        <div class="form-group">
            组织机构编码：<input type="text" id="cd" name="cd" value="${prefix_orgCd?default('')}" placeholder="请输入组织机构编码" class="form-control" />
        </div>

        <div class="form-group">
            用户名称：<input type="text" id="name" name="name" value="" placeholder="请输入用户名称" class="form-control" />
        </div>

        <div class="form-group">
            用户编码：<input type="text" id="code" name="code" value="" placeholder="请输入用户编码" class="form-control" />
        </div>

    </form>

    <!-- 表格 -->
    <table id="dataTable"></table>

</div>

<#-- 新增 -->
<div class="modal fade" id="addDiv" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <form id="infoForm">
        <input type="hidden" id="userId" name="userId" value=""/>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">增改用户</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input type="text" id="m_id" hidden="hidden">
                    <div class="form-group">
                        <label class="control-label" for="m_username">用户名称：</label>
                        <input type="text" class="form-control" id="userNm" name="userNm" placeholder="请输入用户名称">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="m_username">用户代码：</label>
                        <input type="text" class="form-control" id="userCd" name="userCd" placeholder="请输入用户代码" oninput="checkUserCd()">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="m_email">用户手机号：</label>
                        <input type="text" class="form-control" id="userTel" name="userTel" placeholder="请输入用户手机号">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="m_truename">用户性别：</label>
                        <select id="userSex" name="userSex" class="selectpicker">
                            <option value="1">男</option>
                            <option value="2">女</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="m_truename">用户状态：</label>
                        <select id="userStatus" name="userStatus">
                            <option value="1">正常</option>
                            <option value="0">停用</option>
                            <option value="-1">已删除</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="subInfo()">提交</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </form>
</div>

<#--设置权限栏-->
<iframe id="menu_multiple" src="" style="width: 600px; height: 600px; display: none;"></iframe>
<#--选择角色-->
<iframe id="role_multiple" src="" style="width: 600px; height: 600px; display: none;"></iframe>

<script src="${basePath}/static/third/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="${basePath}/static/third/bootstrap/bootstrap-table-master/dist/bootstrap-table.js"></script>
<script src="${basePath}/static/third/bootstrap/bootstrap-table-master/dist/extensions/multiple-sort/bootstrap-table-multiple-sort.js"></script>
<script src="${basePath}/static/third/bootstrap/bootstrap-table-master/dist/extensions/fixed-columns/bootstrap-table-fixed-columns.js"></script>
<script src="${basePath}/static/third/bootstrap/bootstrap-table-master/dist/extensions/editable/bootstrap-table-editable.js"></script>
<script src="${basePath}/static/third/bootstrap/bootstrap-table-master/dist/locale/bootstrap-table-zh-CN.js"></script>
<!-- 页面Js文件的引用 -->
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/common/addBtn.js" type="text/javascript"></script>
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/user/user_manager.js" type="text/javascript"></script>


</body>
</html>