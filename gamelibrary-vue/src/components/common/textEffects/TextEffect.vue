<template>
  <div class="TextEffect">
    <transition name="el-fade-in-linear">
      <div v-show="show" >
        <slot name="content"></slot>
      </div>
    </transition>
  </div>
</template>

<script type="text/javascript">
import { setInterval } from "timers";
export default {
  name: "TextEffect",
  data() {
    return {
      times: null
    };
  },
  props: {
    show: {
      type: Boolean,
      default() {
        return true;
      }
    }
  }
};
</script>

<style scoped>
</style>
