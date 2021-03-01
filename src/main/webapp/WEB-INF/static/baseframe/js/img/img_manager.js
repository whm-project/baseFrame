//选择图片后预览
function preview(file, previewEleId){
    if (file.files && file.files[0]){
        var reader = new FileReader();
        reader.onload = function(evt){
            $("#"+previewEleId).html('<img src="' + evt.target.result + '" width="95px" height="50px" />');
        }
        reader.readAsDataURL(file.files[0]);
    }else{
        $("#"+previewEleId).html('<div style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>');
    }
}

//切换tab标签
$(".main-page .nav div").mouseenter(function () {
    var $this = $(this);
    var index = $this.index();
}).mouseleave(function () {
    var $this = $(this);
    var index = $this.index();
}).click(function () {
    var $this = $(this);
    var index = $this.index();
    var l = -(index * 800);
    $(".main-page .nav div").removeClass("on");
    $(".main-page .nav div").eq(index).addClass("on");
    $(".main-page .content .con-ggh:eq(0)").stop().animate({ "margin-top": l }, 500);
});