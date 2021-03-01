<html>
<head>
    <title>test</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
</head>

<body style="width:98%; margin-left: 1%;">
    <div style="float:left; width:100%;">
    	<div style="width:100%; text-align:center; margin-top:3px;"><font>${title?default('')}</font></div>
		
		<#if trInfo?? && (trInfo?size > 0) >
        <table style="width:100%; text-align:center; margin-top:12px;">

			<#list trInfo as trItem>
				<tr>
					<#list trItem as tdItem>
						<td style="border:#CCC solid 1px">${tdItem?default('')}</td>
					</#list>
				</tr>
			</#list>

        </table>
		</#if>
		
    </div>
	
	<#if imgPathList?? && (imgPathList?size > 0) >
		<#list imgPathList as imgPath>
			<img style="float:left; width:100%; height:60mm; margin-top: 20px;" src="${imgPath?default('')}"/>
		</#list>
	</#if>
</body>

</html>