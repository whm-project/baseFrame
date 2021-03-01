<!doctype html>
<html>

<head>
    <#include "../common.ftl">
    <meta charset="utf-8">
    <title>${prefix_orgNm?default('后台')}管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/css/x-admin.css" media="all">
</head>

<body>
<div class="x-body">
    <div class="pd-20">
        <table  class="layui-table" lay-skin="line">
            <tbody>
            <tr>
                <th  width="80">用户代码：</th>
                <td id="userCd"></td>
            </tr>
            <tr>
                <th>用户名称：</th>
                <td id="userNm"></td>
            </tr>
            <tr>
                <th>用户手机号：</th>
                <td id="userTel"></td>
            </tr>
            <tr>
                <th>用户性别：</th>
                <td id="userSex"></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script src="./lib/layui/layui.js" charset="utf-8">
</script>
<script src="./js/x-layui.js" charset="utf-8">
</script>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form()
                ,layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function(value){
                if(value.length < 5){
                    return '昵称至少得5个字符啊';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
        });

        console.log(parent);
        //监听提交
        form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
        });


    });
</script>

</body>

</html>