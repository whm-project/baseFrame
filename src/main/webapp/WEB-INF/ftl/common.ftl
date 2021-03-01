<#global _b=springMacroRequestContext.getContextUrl("")>
<#global basePath=request.contextPath />

<script src="${basePath}/static/third/js/jquery.min.js"></script>
<script>
    var baseOrgCd = "${prefix_orgCd?default("")}";
    var basePath = "${basePath?default("")}";
    <#--var current_userCd = $(window.parent.document).find("#current_userCd").attr("value");-->
    <#--if(typeof(current_userCd)!= "undefined" && current_userCd!='${Session["userCd"]?default("")}') {-->
    <#--window.parent.location.reload();-->
    <#--}-->
    $(function(){
        $.ajaxSetup({
            complete: function(xhr,status) {
                var sessionStatus = xhr.getResponseHeader('sessionstatus');
                if(sessionStatus == 'timeout') {
                    var top = getTopWinow();
                    top.location.href = basePath+'/';
                }
                var permissionStatus = xhr.getResponseHeader('permissionStatus');
                if(permissionStatus == 'authorityError') {
                    alert("您没有权限！");
                    return;
                }
            }
        });
    });


    function getTopWinow(){
        var p = window;
        while(p != p.parent){
            p = p.parent;
        }
        return p;
    }

    var currentMenuCd = "${RequestParameters.menucd?default('')}";
</script>
