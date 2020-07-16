<template>
  <div class="Home">主页</div>
</template>
<script>
export default {
  name: "Home",
  data() {
    return {};
  },
  components: {},
  created() {
    let breadcrumbList = [
      {
        name: "主页",
        url: "/home"
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
</style>