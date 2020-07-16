<template>
  <div class="DetailCard">
    <div class="card" v-for="(item , index) in cardList" :key="'cardList'+index">
      <el-image
        :preview-src-list="imgList"
        lazy
        :src="item.img"
        class="card-img-top"
        title="点击预览大图"
      >
        <div slot="placeholder" class="image-slot">
          <i class="el-icon-loading"></i>
        </div>

        <div slot="error" class="image-slot">
          <i class="el-icon-picture-outline"></i>
        </div>
      </el-image>

      <div class="card-body">
        <h5 class="card-title">{{item.title}}</h5>
        <p class="card-text">{{item.context}}</p>
      </div>

      <a v-show="item.url" :href="item.url" target="_blank" class="btn btn-primary">了解更多</a>
    </div>
  </div>
</template>

<script type="text/javascript">
export default {
  name: "DetailCard",
  data() {
    return {};
  },
  props: {
    cardList: {
      type: Array,
      default() {
        return [];
      }
    }
  },
  computed: {
    imgList() {
      return this.cardList.map(item => item.img);
    }
  },
  components: {}
};
</script>

<style scoped>
.DetailCard {
  /* display: flex; */
}

.card {
  /* flex: 1; */
  display: inline-block;
  vertical-align: middle;
  margin-right: 25px;
  margin-bottom: 25px;

  width: 31%;
  min-height: 650px;
}

.card-img-top {
  text-align: center;
}
.image-slot {
  font-size: 30px;
  line-height: 40px;
  color: #0099ff;
}

.card-text {
  text-align: justify;
}
.btn-primary {
  position: absolute;
  left: 20px;
  bottom: 30px;
}

.card-img-top {
  color: white;
}
</style>
