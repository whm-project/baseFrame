<#--菜单容器-->
<ul id="menu_list" class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side"></ul>

<#--一级菜单单项示例-->
<li  id="demo_menu_item" class="layui-nav-item" style="display: none;">
    <a class="javascript:;" href="javascript:;">
        <i class="layui-icon iconfont" style="top: 3px;">&#xe65c;</i>
        <cite>栏目管理</cite>
        <#--<span class="layui-nav-more"></span>-->
    </a>
    <dl id="secondLevel_menu_list" class="layui-nav-child">
    </dl>
</li>

<#--二级菜单示例，复制后放到该放的位置-->
<dd id="demo_secondLevel_menu_item" style="display:none;">
    <a href="javascript:;" _href='javascript:;'>
        <cite>栏目列表</cite>
    </a>
</dd>

<#--引用js-->
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/nav.js"></script>