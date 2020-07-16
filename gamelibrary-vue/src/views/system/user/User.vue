<template>
  <div class="User">
    <div class="page">
      <UserContent />
    </div>
  </div>
</template>
<script>
import UserContent from "./childComps/UserContent.vue";

export default {
  name: "User",
  data() {
    return {};
  },
  components: {  UserContent },
  created() {
    let breadcrumbList = [
      {
        name: "用户管理",
        url: "/user"
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