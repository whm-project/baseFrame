<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/style/${(prefix_orgStyleLib)?default('normal')}/css/flexInfo.css">
	<title>无标题文档</title>
</head>

<body>
<div id="main">
  <div class="content">
    <div id="menu_div" class="menuDiv_mini">
    </div>
    <div id="content_div" class="modularDiv_mini">
        <!-- menu operation btn -->
	    <div id="menu_state_btn" class="menubtn_zhankai" onclick="menuMini()"></div>
        
        <!-- top -->
		<div class="topl"></div>
		<div class="logol">
			<div class="logor">
    			<div class="logom">项目名</div>
		    </div>
		</div>
		<div class="topr"></div>

		<!-- mid top -->
		<div class="midt">
			<div class="midtl">
		    	<div class="midtlr">
        			<div class="midtlm"></div>
		        </div>
		    </div>
		    <div class="midtm"></div>
		    <div class="midtr">
		    	<div class="midtrr">
		        	<div class="midtrm"></div>
		        </div>
		    </div>
		</div>
        
		<!-- mid foot -->
		<div class="midf">
        	<iframe id="coverIFrame" src=""></iframe>	
        </div>
    </div>
  </div>
</div>

<script src="${basePath}/static/third/js/jquery-1.8.2.min.js"></script>
<script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/flexInfo.js"></script>
</body>
</html>
