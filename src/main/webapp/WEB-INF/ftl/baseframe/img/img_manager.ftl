<html>
<head>
    <#include "../../common.ftl">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/css/img/img_manager.css">
    <link rel="stylesheet" href="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/css/img/fileUpload.css">
    <title>图片管理</title>
</head>

<body>
    <div class="main-page">
        <div class="left">
            <div class="nav-back"></div>
            <div class="nav">
                <div class="on">登录背景</div>
                <div>机构图标</div>
                <div>菜单图标</div>
            </div>
        </div>
        <div class="right">
            <div class="content">

                <#--登录背景图-->
                <div class="con-ggh">
                    <div class="zcinfo fl">
                        <form enctype="multipart/form-data" action="${basePath}/${prefix_orgCd}/sysImg/saveImg" method="post">
                            <input type="hidden" name="imgType" value="1">
                            <br />
                            <input type="file" id="login_bgImg" name="img" value="" onchange="preview(this, 'login_bgImg_preview')">
                            <div id="login_bgImg_preview"></div>
                            <br />
                            名称：<input type="text" name="imgName" value="">
                            <br />
                            备注：<input type="text" name="imgRemarks" value="">
                            <br />
                            <input type="submit" value="上传">
                        </form>
                        <div class="box">

                        </div>
                    </div>
                </div>

                <#--机构图标-->
                <div class="con-ggh">
                    <div class="zcinfo fl">
                        <form enctype="multipart/form-data" action="${basePath}/${prefix_orgCd}/sysImg/saveImg" method="post">
                            <input type="hidden" name="imgType" value="2">
                            <br />
                            <input type="file" id="org_img" name="img" value="" onchange="preview(this, 'org_img_preview')">
                            <div id="org_img_preview"></div>
                            <br />
                            名称：<input type="text" name="imgName" value="">
                            <br />
                            备注：<input type="text" name="imgRemarks" value="">
                            <br />
                            <input type="submit" value="上传">
                        </form>
                        <div class="box">

                        </div>
                    </div>
                </div>

                <#--菜单图标-->
                <div class="con-ggh">
                    <div class="zcinfo fl">
                        <form enctype="multipart/form-data" action="${basePath}/${prefix_orgCd}/sysImg/saveImg" method="post">
                            <input type="hidden" name="imgType" value="3">
                            <br />
                            <input type="file" id="org_img" name="img" value="" onchange="preview(this, 'org_img_preview')">
                            <div id="org_img_preview"></div>
                            <br />
                            名称：<input type="text" name="imgName" value="">
                            <br />
                            备注：<input type="text" name="imgRemarks" value="">
                            <br />
                            <input type="submit" value="上传">
                        </form>
                        <div class="box">

                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="clear"></div>
    </div>

    <script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/img/img_manager.js" type="text/javascript"></script>
</body>
</html>