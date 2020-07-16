<template>
  <div class="HomeCard">
    <!-- v-for="(item,index) in cardLost" :key="'cardList'+index" -->
    <div class="media">
      <img
        src="~assets/img/home/animals/mouse.jpg"
        class="rounded img-thumbnail align-self-center mr-3 img"
      />
      <div class="media-body">
        <h3 class="mt-0">布丁鼠</h3>
        <p>布丁鼠是加卡利亚仓鼠(Phodopus sungorus)的一种，加卡利亚仓鼠就是宠物鼠中常见的三线鼠，布丁鼠的体色为黄色，很像布丁，所以称为布丁鼠，这是日本培育出来的。布丁鼠背上的条纹为橙色或金色的称为黄布丁，毛色为乳白色的称为白布丁；他们的个性很温和，跟人们的互动性高，而且照顾容易，所以很适合成为新手或小朋友的小型宠物鼠。布丁鼠和其它宠物鼠一样，具有不占空间，喂食、清洁方便的特点，个性温驯。布丁鼠很怕热，夏天需要调节温度。</p>
        <p>布丁鼠和其它宠物鼠一样，具有不占空间，喂食、清洁方便，个性温驯，花费不大等优点，所以很受那些空间、时间都有限的上班族的喜爱，很快就成为流行宠物。</p>
      </div>
    </div>

    <div class="media">
      <div class="media-body">
        <h3 class="mt-0 text-right">英国短毛猫</h3>
        <p>英国短毛猫，体形圆胖，四肢粗短发达，毛短而密，头大脸圆，温柔平静，对人友善，极易饲养。大而圆的眼睛根据被毛不同而呈现各种颜色。作为一个古老的猫品种，其历史可追溯至古罗马时期的家猫，由于拥有悠久的育种历史，可以称得上是猫家族中的典范。</p>
        <p>英国短毛猫除了拥有固定而聚，代表性的遗传特征之外，又具有丰富的变异性，如背毛色眼睛颜色等。更重要的是，有了广泛的配种历史后，这种猫拥有了更健康的身体和更温驯的性格。</p>
        <p>英国短毛猫的被毛像绒布一般柔软、厚实，很少脱落，容易打理。不过，猫一年四季都会脱毛，尤其是春、秋两季的换毛季节。猫自己梳理会将毛吞入胃内，久而久之在胃内形成毛球，如不能通过呕吐吐出，又不能及时通过肠道排出，滞留胃内，就会形成毛球堵塞，影响食欲，甚至危及生命。所以，如果其处在脱毛期，主人每天可以适量为其多梳理几次毛或让其食用化毛膏。</p>
      </div>

      <img
        src="~assets/img/home/animals/cat.jpg"
        class="rounded img-thumbnail align-self-center ml-3 img"
      />
    </div>

    <div class="media">
      <img
        src="~assets/img/home/animals/dog1.jpg"
        class="rounded img-thumbnail align-self-center mr-3 img"
      />
      <div class="media-body">
        <h3 class="mt-0">西伯利亚雪橇犬</h3>
        <p>西伯利亚雪橇犬（俄语：Сибирский хаски，英语：Siberian Husky），常见别名哈士奇，昵称为二哈。</p>
        <p>西伯利亚雪橇犬是原始的古老犬种，主要生活在在西伯利亚东北部、格陵兰南部。哈士奇名字是源自其独特的嘶哑叫声。哈士奇性格多变，有的极端胆小，也有的极端暴力，进入人类社会和家庭的哈士奇，都已经没有了这种极端的性格，比较温顺，是一种流行于全球的宠物犬。哈士奇、金毛犬与拉布拉多并列为三大无攻击性犬类，被世界各地人们广泛饲养，并在全球范围内有大量该犬种的赛事。</p>
        <p>西伯利亚雪撬犬属于中型工作犬。脚步轻快，动作优美，身体紧凑，有着很厚的被毛，耳朵直立，尾如毛刷，显示出北方地区的遗传特征，西伯利亚雪撬犬是和狼的血统非常近的犬种，所以外形非常的像狼，有着比大多数犬种都要厚的毛发</p>
      </div>
    </div>

    <div class="media">
      <div class="media-body">
        <h3 class="mt-0 text-right">日本柴犬</h3>
        <p>日本柴犬是日本本土最小的犬种，用于在日本多山的地形中，在浓密的灌木丛中，利用视觉和嗅觉进行捕猎的猎犬，警惕而敏捷，感觉敏锐。同时，他也是一种非常卓越的门卫犬和伴侣犬。</p>
        <p>在日本，柴犬被政府指定为“天然纪念物”。原因是其起源早，早在公元前1000年，柴犬就生活在日本山区，也叫丛林犬，动作轻盈敏捷，是十分优秀的犬种。</p>
        <p>柴犬包括岐阜县的美浓柴犬。鸟取县的少量山阴柴犬，从外形上与其它柴犬差别不大，但在血液蛋白质遗传基因构成上却有很大的差别，故它们与一般的柴犬(以原产地取名的信州柴犬)不同。</p>
      </div>
      <img
        src="~assets/img/home/animals/dog2.jpg"
        class="rounded img-thumbnail align-self-center ml-3 img"
      />
    </div>
  </div>
</template>

<script type="text/javascript">
export default {
  name: "HomeCard",
  data() {
    return {
      cardLost: [0, 0, 0]
    };
  },
  components: {}
};
</script>

<style scoped>
.media {
  margin-top: 40px;
  background-color: rgba(171, 199, 223, 0.8);
  padding: 10px 20px;

  text-align: justify;
}

.img {
  width: 200px;
}
</style>
