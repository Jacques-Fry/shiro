<template>
  <div class="DetailFont">
    <Font fontStyle="font6">
      <span slot="font-6">Jacques ·Fry</span>
    </Font>
  </div>
</template>

<script type="text/javascript">
import Font from "components/common/font/Font";
export default {
  name: "DetailFont",
  components: { Font }
};
</script>

<style scoped>
.DetailFont {
  font-size: 50px;
  margin-top: 10px;
  margin-bottom: 10px;
}
</style>
