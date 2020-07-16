<template>
  <div class="HomeEchat">
    <div id="echartsBarDemo"></div>
  </div>
</template>

<script type="text/javascript">
export default {
  name: "HomeEchat",
  components: {},
  data() {
    return {
      content: ""
    };
  },
  mounted() {
    this.drawBar();
  },
  methods: {
    drawBar() {
      let data = [
        ["2020-01-05", 116],
        ["2020-01-06", 333],
        ["2020-01-07", 135],
        ["2020-01-08", 888],
        ["2020-01-09", 999],
        ["2020-01-10", 666],
        ["2020-01-11", 73]
      ];

      var dateList = data.map(function(item) {
        return item[0];
      });

      var valueList = data.map(function(item) {
        return item[1];
      });

      let option = {
        // Make gradient line here
        visualMap: {
          show: false,
          type: "continuous",
          seriesIndex: 0,
          min: 0,
          max: 99999
        },

        title: {
          left: "center",
          text: "网站最近一周被访问数统计"
        },
        tooltip: {
          trigger: "axis"
        },
        xAxis: {
          data: dateList
        },

        yAxis: {
          splitLine: { show: false }
        },
        grid: {
          bottom: "30px"
        },
        series: {
          type: "line",
          showSymbol: false,
          data: valueList,
          itemStyle: {
            normal: {
              color: "#275F82", //改变折线点的颜色
              lineStyle: {
                color: "#253A5D" //改变折线颜色
              }
            }
          },
          areaStyle: {
            normal: {
              color: "#275F82" //改变区域颜色
            }
          }
        }
      };

      let echartsBarDemo = this.$echarts.init(
        document.getElementById("echartsBarDemo")
      );
      echartsBarDemo.setOption(option);
    }
  }
};
</script>

<style scoped>
#echartsBarDemo {
  position: relative;
  left: 50%;
  transform: translateX(-50%);

  padding: 20px 0;

  width: 800px;
  height: 600px;

  background: rgba(255, 255, 255, 0.9);
}
</style>
