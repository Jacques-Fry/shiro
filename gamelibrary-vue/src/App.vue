<template>
  <div id="app">
    <MainLayout />
  </div>
</template>

<script>
import MainLayout from "components/content/layout/MainLayout";

export default {
  name: "app",
  mounted() {},
  components: {
    MainLayout
  },
  created() {}
};
</script>

<style>
@import "assets/css/normalize.css";
</style>
<style scoped>
#app {
  min-width: 1250px;
}
</style>
