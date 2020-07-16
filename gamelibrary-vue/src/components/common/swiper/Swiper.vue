<template>
  <div class="swiper-container">
    <div class="swiper-wrapper">
      <!-- 存放具体的轮播内容 -->
      <slot name="content"></slot>
    </div>
    <!-- 分页器 -->
    <div :class="{'swiper-pagination':pagination}"></div>

    <!-- 如果需要导航按钮 -->
    <div :class="{'swiper-button-prev':navigation}" class="navigation-button"></div>
    <div :class="{'swiper-button-next':navigation}" class="navigation-button"></div>
  </div>
</template>
<script>
import Swiper from "swiper";
import "swiper/css/swiper.min.css";
export default {
  props: {
    // 特效
    effect: {
      type: String,
      default() {
        return "slide";
      }
    },
    // 循环模式选项
    loop: {
      type: Boolean,
      default() {
        return true;
      }
    },
    //方向
    direction: {
      type: String,
      default() {
        return "horizontal";
      }
    },
    // 如果需要分页器
    pagination: {
      type: Boolean,
      default() {
        return true;
      }
    },
    // 如果需要前进后退按钮
    navigation: {
      type: Boolean,
      default() {
        return true;
      }
    },
    paginationType: {
      type: String,
      default() {
        return "bullets";
      }
    },
    // 自动切换
    autoplay: {
      type: [Object, Boolean],
      default() {
        return {
          delay: 5000, // 5秒切换一次
          disableOnInteraction: false // 用户操作swiper之后，不禁止autoplay
        };
      }
    },
    //延迟加载
    lazy: {
      type: Object,
      default() {
        return {
          loadPrevNext: true,
          loadPrevNextAmount: 2 //前两个和后两个
        };
      }
    } //延迟加载
  },
  data() {
    return {
      dom: ""
    };
  },
  mounted() {
    var that = this;
    this.dom = new Swiper(".swiper-container", {
      //循环
      loop: that.loop,
      //分页器
      pagination: {
        el: ".swiper-pagination",
        dynamicBullets: true,
        dynamicMainBullets: 2, //动态显示个数
        clickable: true // 此参数设置为true时，点击分页器的指示点分页器会控制Swiper切换。
      },
      // 如果需要前进后退按钮
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev"
        // hideOnClick: true // 点击slide时显示/隐藏按钮。
      },
      //分页类型
      paginationType: that.paginationType,
      //自动播放
      autoplay: that.autoplay,
      //方向
      direction: that.direction,
      //特效
      effect: that.effect,
      //修改swiper自己或子元素时，自动初始化swiper
      observer: true,
      //修改swiper的父元素时，自动初始化swiper
      observeParents: true,
      //延迟加载
      lazy: that.lazy
    });
  }
};
</script>

<style scoped>
.swiper-container .swiper-button-hidden {
  opacity: 0;
}

.navigation-button {
  /* opacity: 0; */
  padding: 30px 6px;
  /* background-color: rgba(255, 255, 255, 0.05); */
}

.navigation-button:hover {
  background-color: rgba(255,255, 255, 0.3);
}

.swiper-container {
  --swiper-theme-color: #08bff7; /* 设置Swiper风格 */
  --swiper-navigation-color: #08bff7; /* 单独设置按钮颜色 */
  --swiper-navigation-size: 30px; /* 设置按钮大小 */
}
</style>
