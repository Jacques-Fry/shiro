<template>
  <div class="SnowFlake">
    <div class="snowflake" v-for="item in 20" :key="'snow'+item">
      <div class="layer-1">
        <div class="a">A</div>
        <div class="a">A</div>
        <div class="a">A</div>
        <div class="a">A</div>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
export default {
  name: "Snowflake",
  data() {
    return {};
  },
  components: {}
};
</script>

<style scoped>
@import url(./style.css);
.Snowflake {
  overflow: hidden;
  position: relative;
  width: 100%;
  height: 100%;
}
</style>
