<template>
  <div class="HomeSwiper">
    <!-- <swiper class="swiper" :autoplay="{delay:5000, disableOnInteraction: false}">
      <div
        slot="content"
        class="swiper-slide"
        v-for="(item,index) in imgList"
        :key="'imglist'+index"
      >
        <img :src="item" />

      </div>
    </!-->

    <div id="carouselExampleCaptions" class="carousel slide swiper" data-ride="carousel">
      <ol class="carousel-indicators">
        <li
          data-target="#carouselExampleCaptions"
          v-for="(item,index) in imgList"
          :key="item+index+'1'"
          :data-slide-to="index"
          class="active"
        ></li>
      </ol>
      <div class="carousel-inner">
        <div
          class="carousel-item"
          :class="{active: index===0}"
          v-for="(item,index) in imgList"
          :key="item+index"
        >
          <!-- <img :src="item.img" class="d-block w-100" /> -->
          <img :src="item.img" class="d-block w-100" />
          <!-- <div slot="placeholder" class="image-slot">
              <i class="el-icon-loading"></i>
            </div>

            <div slot="error" class="image-slot">
              <i class="el-icon-picture-outline"></i>
          </div>-->
          <div class="carousel-caption d-none d-md-block">
            <h5>{{item.title}}</h5>
            <p>{{item.context}}</p>
          </div>
        </div>
      </div>
      <a
        class="carousel-control-prev"
        href="#carouselExampleCaptions"
        role="button"
        data-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a
        class="carousel-control-next"
        href="#carouselExampleCaptions"
        role="button"
        data-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </div>
</template>

<script type="text/javascript">
import swiper from "components/common/swiper/Swiper";
export default {
  name: "HomeSwiper",
  data() {
    return {
      baseUrl: process.env.BASE_URL
    };
  },
  props: {
    imgList: {
      type: Array,
      default() {
        return [];
      }
    }
  },
  components: { swiper }
};
</script>

<style scoped>
.swiper {
  position: relative;
  overflow: hidden;

  width: 100%;
  height: 675px;
  border-radius: 3px;
}

.carousel-item {
  height: 675px;
  border-radius: 3px;
}

img {
  width: auto;
  height: 100%;
}
.d-block {
  text-align: center;
}
</style>
