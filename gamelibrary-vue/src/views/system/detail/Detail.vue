<template>
  <div class="UserDetail">
    个人中心
  </div>
</template>
<script>
export default {
  name: "UserDetail",
  data () {
    return {
    };
  },
 components:{},
 created() {
    let breadcrumbList = [
      {
        name: "个人中心",
        url: "/detail"
      },
      {
        name: "列表",
      }
    ];
    this.$store.commit("setBreadcrumbList", breadcrumbList);
  }
}
</script>
<style scoped>
</style>