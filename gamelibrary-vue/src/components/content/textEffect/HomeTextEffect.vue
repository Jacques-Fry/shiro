<template>
  <div class="HomeTextEffect">
    <TextEffect :show="show">
      <div class="content" slot="content" v-html="textList[index]"></div>
    </TextEffect>
  </div>
</template>

<script type="text/javascript">
import TextEffect from "components/common/textEffects/TextEffect";

export default {
  name: "HomeTextEffect",
  data() {
    return {
      index: 0,
      show: true
    };
  },
  components: {
    TextEffect
  },
  props: {
    textList: {
      type: Array,
      default() {
        return [];
      }
    }
  },
  computed: {
    textListLength() {
      return this.textList.length;
    }
  },
  activated() {
    this.show = true;
    this.index = 0;
    this.times = window.setInterval(() => {
      if (this.index < this.textListLength - 1) {
        this.show = false;
        setTimeout(() => {
          this.index++;
          this.show = true;
        }, 1200);
      } else {
        this.show = false;
        window.clearInterval(this.times);
      }
      console.log("执行一次", this.index);
    }, 5000);
  },
  deactivated() {
    if (this.times) window.clearInterval(this.times);
  }
};
</script>

<style scoped>
.HomeTextEffect {
  height: 50px;
}
.content {
  position: relative;
  left: 50%;
  transform: translateX(-50%);

  text-align: center;
  /* padding: 0 20px; */
  color: rgb(80, 80, 80);

  height: 50px;
  line-height: 50px;

  font-size: 25px;
  font-weight: 600;

  /* background-color: rgba(255, 255, 255, 0.7); */
}
</style>
