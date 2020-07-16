<template>
  <div class="Permission">
    <div class="page">
      <PermissionContent />
    </div>
  </div>
</template>
<script>
import PermissionContent from "./childComps/PermissionContent.vue";

export default {
  name: "Permission",
  data() {
    return {};
  },
  components: {  PermissionContent },
  created() {
    let breadcrumbList = [
      {
        name: "权限管理",
        url: "/permission"
      },
      {
        name: "列表"
      }
    ];
    this.$store.commit("setBreadcrumbList", breadcrumbList);
  }
};
</script>
<style scoped>
.page {
  position: relative;
  padding: 10px;
  width: 100%;
  height: 100%;
  background-color: #ffffff;
}
</style>