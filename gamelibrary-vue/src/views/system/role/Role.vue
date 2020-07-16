<template>
  <div class="Role">
    <div class="page">
      <RoleContent />
    </div>
  </div>
</template>
<script>
import RoleContent from "./childComps/RoleContent.vue";

export default {
  name: "Role",
  data() {
    return {};
  },
  components: {  RoleContent },
  created() {
    let breadcrumbList = [
      {
        name: "角色管理",
        url: "/role"
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