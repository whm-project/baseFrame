    <script src="//at.alicdn.com/t/font_1458747_8rgomsdr78n.js"></script>
    <style>
        .icon {
            width: 1em; height: 1em;
            vertical-align: -0.15em;
            fill: currentColor;
            overflow: hidden;
        }
    </style>
    <#--二级菜单示例，复制后放到该放的位置-->
    <li id="demo_secondLevel_menu_item" style="display:none;"><a href='javascript:;'><span>兴庆区</span></a></li>

    <#--菜单-->
    <div class="nav nav-mini">
        <div class="nav-top">
            <div id="mini" class="menu_title_container">
                <div id="pro_title" class="menu_title" style="display: none;">菜单列表</div>
                <svg id="title_svg_shousuo" class="icon" aria-hidden="true" style="display: none;">
                    <use xlink:href="#icon-shousuo_zuo"></use>
                </svg>
                <svg id="title_svg_zhankai" class="icon" aria-hidden="true">
                    <use xlink:href="#icon-zhankai_you"></use>
                </svg>
            </div>
        </div>
        <ul id="menu_list">

            <#--一级菜单单项示例-->
            <li id="demo_menu_item" class='nav-item' style="display: none;">
                <a href='javascript:;'>
                    <i class='my-icon nav-icon icon_1'></i>
                    <span>银川市</span>
                    <i class='my-icon nav-more'></i>
                </a>
                <ul id="secondLevel_menu_list"></ul>
            </li>
        </ul>
    </div>

    <script src="${basePath}/static/${(prefix_orgLayoutLib)?default('normal')}/js/nav.js"></script>