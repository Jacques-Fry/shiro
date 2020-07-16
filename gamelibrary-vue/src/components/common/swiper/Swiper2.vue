<template>
  <div class="swiper-container">
    <div class="swiper-wrapper">
      <div class="swiper-slide">Slide 1</div>
      <div class="swiper-slide">Slide 2</div>
      <div class="swiper-slide">Slide 3</div>
    </div>
    <!-- 如果需要分页器 -->
    <div class="swiper-pagination"></div>

    <!-- 如果需要导航按钮 -->
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>

    <!-- 如果需要滚动条 -->
    <!-- <div class="swiper-scrollbar"></div> -->
  </div>
</template>

<script type="text/javascript">
import Swiper from "swiper";
import "swiper/css/swiper.min.css";

export default {
  name: "HomeSwiper",
  data() {
    return {};
  },
  mounted() {
    var mySwiper = new Swiper(".swiper-container", {
      // direction: "vertical", // 垂直切换选项
      loop: true, // 循环模式选项
      autoplay: {
        delay: 5000 //1秒切换一次
      },

      lazy: {
        loadPrevNext: true,
        loadPrevNextAmount: 2 //前两个和后两个
      }, //延迟加载

      // 如果需要分页器
      pagination: {
        el: ".swiper-pagination"
      },

      // 如果需要前进后退按钮
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev"
      }

      // 如果需要滚动条
      // scrollbar: {
      //   el: ".swiper-scrollbar"
      // }
    });
  }
};
</script>

<style scoped>
.swiper-container {
  width: 600px;
  height: 300px;
}
</style>
