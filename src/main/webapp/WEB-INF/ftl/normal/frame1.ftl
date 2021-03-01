<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">
    <title>布局</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/css/frame.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/css/nav.css">
</head>

<body>
<div id="main">
    <#--<div class="header">B</div>-->
    <div class="content">
        <div class="menuDiv">
            <#include "nav.ftl">
        </div>
        <div class="modularDiv">
            <iframe id="coverIFrame" style="width: 100%; height: calc(100% - 5px); border: none; margin: 0; padding: 0;"></iframe>
        </div>
    </div>
</div>

<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/frame.js"></script>
</body>
</html>