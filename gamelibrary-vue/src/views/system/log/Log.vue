<template>
  <div class="Log">
    <div class="page">
      <LogContent />
    </div>
  </div>
</template>
<script>
import LogContent from "./childComps/LogContent.vue";

export default {
  name: "Log",
  data() {
    return {};
  },
  components: {  LogContent },
  created() {
    let breadcrumbList = [
      {
        name: "操作记录",
        url: "/log"
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