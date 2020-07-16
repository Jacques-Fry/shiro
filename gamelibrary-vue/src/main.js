import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// element插件
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI)

//vue侧边栏
import vuescroll from 'vuescroll';
Vue.use(vuescroll, {
  // 在这里设置全局默认配置
  ops: {
    vuescroll: {
      //选择一个模式, native 或者 slide
      mode: "native",
      //如果父容器不是固定高度，请设置为 number , 否则保持默认的percent即可
      sizeStrategy: "number",
      //是否检测内容尺寸发生变化
      detectResize: true
    },
    scrollPanel: {
      scrollingX: false
    },
    rail: {
      //轨道的背景色
      background: "#666666",
      //轨道的尺寸
      size: "5px",
      //轨道的透明度
      opacity: 0.2
    },
    bar: {
      //在鼠标离开容器后多长时间隐藏滚动条
      showDelay: 2000,
      //滚动条背景色
      background: "#666666",
      //滚动条透明度
      opacity: 0.5
    }
  },
  name: 'vue-scroll' // 在这里自定义组件名字，默认是vueScroll
});

// 音乐播放器
// import APlayer from '@moefe/vue-aplayer';
// Vue.use(APlayer, {
//   defaultCover: 'https://github.com/u3u.png',
//   productionTip: true,
// });

// Echart图表插件
// import echarts from 'echarts'
// Vue.prototype.$echarts = echarts

//bootstrap
import $ from "jquery"
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.min.js";

Vue.config.productionTip = false

new Vue({
  router,
  store,
  $,
  render: h => h(App)
}).$mount('#app')
