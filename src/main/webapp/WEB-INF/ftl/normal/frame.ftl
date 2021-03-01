<!DOCTYPE html>
<html>
<head>
    <#include "../common.ftl">
    <title>布局</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link rel="stylesheet" href="${basePath}/static/third/element-ui/lib/theme-chalk/index.css">
    <script src="${basePath}/static/third/vue/js/vue@2.6.11.min.js"></script>
    <script src="${basePath}/static/third/element-ui/lib/index.js"></script>

    <style>
        .el-header, .el-footer {
            background-color: #f3f3fb;
            color: #333;
            text-align: center;
            /*line-height: 60px;*/
        }
        .el-aside {
            background-color: #D3DCE6;
            color: #333;
            text-align: center;
            /*line-height: 700px;*/
        }
        .el-main {
            background-color: #E9EEF3;
            color: #333;
            text-align: center;
        }
        body > .el-container {
            margin-bottom: 40px;
        }
    </style>
</head>

<body>
<div id="app">
    <div style="margin-bottom: 20px;">
        <el-button size="small" @click="addTab(editableTabsValue)">
            add tab
        </el-button>
    </div>
<#--    <el-tabs v-model="editableTabsValue" type="card" closable @tab-remove="removeTab">-->
<#--        <el-tab-pane v-for="(item, index) in editableTabs" :key="item.name" :label="item.title" :name="item.name">-->
<#--            {{item.content}}-->
<#--        </el-tab-pane>-->
<#--    </el-tabs>-->
    <el-container>
        <el-aside width="200px">
            <el-row class="tac">

                <el-col :span="24">
                    <el-menu
                            default-active="2"
                            class="el-menu-vertical-demo"
                            @open="handleOpen"
                            @close="handleClose"
                            background-color="#545c64"
                            text-color="#fff"
                            active-text-color="#ffd04b">
                        <el-submenu index="1">
                            <template slot="title">
                                <i class="el-icon-location"></i>
                                <span>导航一</span>
                            </template>
                            <el-menu-item-group>
                                <template slot="title">分组一</template>
                                <el-menu-item index="1-1" @click="addTab(editableTabsValue)">选项1</el-menu-item>
                                <el-menu-item index="1-2" @click="addTab(editableTabsValue)">选项2</el-menu-item>
                            </el-menu-item-group>
                            <el-menu-item-group title="分组2">
                                <el-menu-item index="1-3">选项3</el-menu-item>
                            </el-menu-item-group>
                            <el-submenu index="1-4">
                                <template slot="title">选项4</template>
                                <el-menu-item index="1-4-1">选项1</el-menu-item>
                            </el-submenu>
                        </el-submenu>
                        <el-menu-item index="2">
                            <i class="el-icon-menu"></i>
                            <span slot="title">导航二</span>
                        </el-menu-item>
                        <el-menu-item index="3" disabled>
                            <i class="el-icon-document"></i>
                            <span slot="title">导航三</span>
                        </el-menu-item>
                        <el-menu-item index="4">
                            <i class="el-icon-setting"></i>
                            <span slot="title">导航四</span>
                        </el-menu-item>
                    </el-menu>
                </el-col>

            </el-row>

        </el-aside>




        <el-container>
            <el-header>
                <el-tabs v-model="editableTabsValue" type="card" closable @tab-remove="removeTab">
                    <el-tab-pane v-for="(item, index) in editableTabs" :key="item.name" :label="item.title" :name="item.name">
                        {{item.content}}
                    </el-tab-pane>
                </el-tabs>
            </el-header>
            <el-main>Main</el-main>
        </el-container>
    </el-container>

</div>

<script>
    var Main = {
        data() {
            return {
                editableTabsValue: '2',
                editableTabs: [{
                    title: 'Tab 1',
                    name: '1',
                    content: 'Tab 1 content'
                }, {
                    title: 'Tab 2',
                    name: '2',
                    content: 'Tab 2 content'
                }],
                tabIndex: 2
            }
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            addTab(targetName) {
                let newTabName = ++this.tabIndex + '';
                this.editableTabs.push({
                    title: 'New Tab',
                    name: newTabName,
                    content: 'New Tab content'
                });
                this.editableTabsValue = newTabName;
            },

            removeTab(targetName) {
                let tabs = this.editableTabs;
                let activeName = this.editableTabsValue;
                if (activeName === targetName) {
                    tabs.forEach((tab, index) => {
                        if (tab.name === targetName) {
                        let nextTab = tabs[index + 1] || tabs[index - 1];
                        if (nextTab) {
                            activeName = nextTab.name;
                        }
                    }
                });
                }
                this.editableTabsValue = activeName;
                this.editableTabs = tabs.filter(tab => tab.name !== targetName);
            }



        }
    }
    var Ctor = Vue.extend(Main)
    new Ctor().$mount('#app')
</script>
</body>
</html>