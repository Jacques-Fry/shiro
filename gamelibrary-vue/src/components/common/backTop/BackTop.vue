<template>
  <div class="AppBackTop">
    <transition name="el-fade-in">
      <div class="page-up" @click="scrollToTop" v-show="toTopShow">
        <i class="el-icon-caret-top"></i>
      </div>
    </transition>
  </div>
</template>

<script type="text/javascript">
export default {
  name: "AppBackTop",
  data() {
    return { toTopShow: false, scrollTop: 0 };
  },
  components: {},
  mounted() {
    this.$nextTick(function() {
      window.addEventListener("scroll", this.handleScroll, true);
    });
  },
  destroyed() {
    window.addEventListener("scroll", this.handleScroll, true);
  },
  methods: {
    handleScroll() {
      let scrollTop =
        window.pageYOffset ||
        document.documentElement.scrollTop ||
        document.body.scrollTop;
      this.scrollTop = scrollTop;
      if (this.scrollTop > 500) {
        this.toTopShow = true;
      } else {
        this.toTopShow = false;
      }
    },
    scrollToTop() {
      let timer = null;
      let _this = this;
      cancelAnimationFrame(timer);
      timer = requestAnimationFrame(function fn() {
        if (_this.scrollTop > 5000) {
          _this.scrollTop -= 1000;
          document.documentElement.scrollTop = document.body.scrollTop =
            _this.scrollTop;
          timer = requestAnimationFrame(fn);
        } else if (_this.scrollTop > 1000 && _this.scrollTop <= 5000) {
          _this.scrollTop -= 500;
          document.documentElement.scrollTop = document.body.scrollTop =
            _this.scrollTop;
          timer = requestAnimationFrame(fn);
        } else if (_this.scrollTop > 200 && _this.scrollTop <= 1000) {
          _this.scrollTop -= 100;
          document.documentElement.scrollTop = document.body.scrollTop =
            _this.scrollTop;
          timer = requestAnimationFrame(fn);
        } else if (_this.scrollTop > 50 && _this.scrollTop <= 200) {
          _this.scrollTop -= 10;
          document.documentElement.scrollTop = document.body.scrollTop =
            _this.scrollTop;
          timer = requestAnimationFrame(fn);
        } else if (_this.scrollTop > 0 && _this.scrollTop <= 50) {
          _this.scrollTop -= 5;
          document.documentElement.scrollTop = document.body.scrollTop =
            _this.scrollTop;
          timer = requestAnimationFrame(fn);
        } else {
          cancelAnimationFrame(timer);
          _this.toTopShow = false;
        }
      });
    }
  }
};
</script>

<style scoped>
.page-up {
  background-color: #409eff;
  position: fixed;
  right: 40px;
  bottom: 30px;
  width: 40px;
  height: 40px;
  border-radius: 20px;
  cursor: pointer;
  transition: 0.3s;
  box-shadow: 0 3px 6px rgba(0, 0, 0, 0.5);
  opacity: 0.8;
  z-index: 100;
}
.el-icon-caret-top {
  color: #fff;
  display: block;
  line-height: 40px;
  text-align: center;
  font-size: 18px;
}
</style>
