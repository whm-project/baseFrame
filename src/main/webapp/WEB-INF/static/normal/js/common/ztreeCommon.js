//清空节点样式
function clearFontCss(styleStr){
    //获取原来高亮的节点，使节点不再高亮
    var ylNodeList = zTree.getNodesByParam(styleStr, true, null);
    for( var i=0; i<ylNodeList.length; i++) {
        ylNodeList[i][styleStr] = false;
        zTree.updateNode(ylNodeList[i]);
    }
}

//设置节点样式
function setFontCss(nodeList, styleStr){
    //更新节点，使查询出来的节点高亮
    for( var i=0; i<nodeList.length; i++) {
        nodeList[i][styleStr] = true;
        zTree.updateNode(nodeList[i]);
    }
}

//设置节点样式
function getFontCss(treeId, treeNode) {
    var resultObj;
    if(treeNode.highlight){
        resultObj = {color:"#A60000", "font-weight":"bold"};
    }
    else if(treeNode.stopstop){
        resultObj = {color:"#ccc", "font-weight":"normal"};
    }else {
        resultObj = {color:"#333", "font-weight":"normal"};
    }
    return resultObj;
}