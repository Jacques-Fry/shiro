<template>
  <div class>
    <Layout :left-width="80">
      <div class="layout-title" slot="layout-one-title">
        <MainTabBar />
      </div>
      <div class="layout-left" slot="layout-one-left">
        <MainNavBar />
      </div>
      <div class="layout-right" slot="layout-one-right">
        <div class="layout-right-breadcrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item v-for="(item,index) in BreadcrumbList" :Key="'BreadcrumbList'+index" :to="{ path: item.url }">{{item.name}}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <router-view class="layout-right-page" />
      </div>
      <div class="layout-foot" slot="layout-one-foot">© 最终解释权归花落泪知雨所有</div>
    </Layout>
  </div>
</template>
<script>
import Layout from "components/common/layout/LayoutOne";

import MainTabBar from "components/content/tabbar/MainTabBar";
import MainNavBar from "components/content/navbar/MainNavBar";

import { mapGetters } from "vuex";

export default {
  name: "MainLayout",
  data() {
    return {};
  },
  components: {
    Layout,
    MainTabBar,
    MainNavBar
  },
  computed: {
    ...mapGetters({
      BreadcrumbList: "getBreadcrumbList"
    })
  },
};
</script>
<style scoped>
.layout-title,
.layout-left,
.layout-right,
.layout-foot {
  position: relative;
  height: 100%;
}
.layout-right {
  width: 100%;
  background-color: #eee;
}

.layout-title {
  background-color: rgb(52, 55, 60);
  color: #fff;
}
.layout-left {
  background-color: rgb(77, 95, 133);
}

.layout-foot {
  text-align: center;
  font-size: 12px;
}

.layout-right-breadcrumb {
  padding-top: 10px;
  padding-left: 10px;
}
.layout-right-page {
  position: relative;
  padding: 10px;
  width: 100%;
  height: calc(100% - 24.5px);
}
</style>