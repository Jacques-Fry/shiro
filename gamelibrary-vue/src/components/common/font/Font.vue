<template>
  <div class="Font">
    <span class="x-sign" id="font1">
      <slot name="font-1"></slot>
    </span>
    <span class="x-sign" id="font2">
      <slot name="font-2"></slot>
    </span>
    <span class="x-sign" id="font3">
      <slot name="font-3"></slot>
    </span>
    <span class="x-sign" id="font4">
      <slot name="font-4"></slot>
    </span>
    <span class="x-sign" id="font5">
      <slot name="font-5"></slot>
    </span>
    <span class="x-sign" id="font6">
      <slot name="font-6"></slot>
    </span>
    <span class="x-sign" id="font7">
      <slot name="font-7"></slot>
    </span>
    <span class="x-sign" id="font8">
      <slot name="font-8"></slot>
    </span>
    <span class="x-sign" id="font9">
      <slot name="font-9"></slot>
    </span>
  </div>
</template>

<script type="text/javascript">
export default {
  name: "Font",
  props: {
    fontStyle: {
      type: String,
      default() {
        return "font1";
      }
    }
  },
  components: {},
  mounted() {
    // this.flashing();
  },
  methods: {
    mixupInterval(el) {
      const ms = this.randomIn(2000, 4000);
      el.style.setProperty("--interval", `${ms}ms`);
    },
    randomIn(min, max) {
      return Math.floor(Math.random() * (max - min + 1) + min);
    },
    flashing() {
      if (this.fontStyle) {
        const signs = document.getElementById(this.fontStyle);
        this.mixupInterval(signs);
        signs.addEventListener("webkitAnimationIteration", () => {
          this.mixupInterval(signs);
        });
      }
    }
  }
};
</script>

<style scoped>
@import url(~assets/css/googleapis/family.css);
@import url(~assets/css/googleapis/familys.css);

.Font {
  display: inline-block;
}

.x-sign {
  --interval: 1s;
  display: block;
  text-shadow: 0 0 10px var(--color1), 0 0 20px var(--color2),
    0 0 40px var(--color3), 0 0 80px var(--color4);
  will-change: filter, color;
  filter: saturate(60%);
  animation: flicker steps(100) var(--interval) 1s infinite;
}

#font1 {
  color: yellow;
  --color1: goldenrod;
  --color2: orangered;
  --color3: mediumblue;
  --color4: purple;
  font-family: Gruppo;
}

#font2 {
  color: lightpink;
  --color1: pink;
  --color2: orangered;
  --color3: red;
  --color4: magenta;
  font-family: Bad Script;
}

#font3 {
  color: lightyellow;
  --color1: yellow;
  --color2: lime;
  --color3: green;
  --color4: mediumblue;
  font-family: Kumar One Outline;
}

#font4 {
  color: lightyellow;
  --color1: gold;
  --color2: firebrick;
  --color3: pink;
  --color4: red;
  font-family: Londrina Outline;
}

#font5 {
  color: azure;
  --color1: azure;
  --color2: aqua;
  --color3: dodgerblue;
  --color4: blue;
  font-family: Sriracha;
}

#font6 {
  color: tomato;
  --color1: orangered;
  --color2: firebrick;
  --color3: maroon;
  --color4: darkred;
  font-family: Yellowtail;
}

#font7 {
  color: lightyellow;
  --color1: yellow;
  --color2: orange;
  --color3: brown;
  --color4: purple;
  font-family: Bad Script;
}

#font8 {
  color: yellow;
  --color1: yellow;
  --color2: lime;
  --color3: green;
  --color4: darkgreen;
  font-family: Monoton;
}

#font9 {
  color: lightyellow;
  --color1: yellow;
  --color2: gold;
  --color3: orange;
  --color4: darkred;
  font-family: Sriracha;
}

@keyframes flicker {
  50% {
    color: white;
    filter: saturate(200%) hue-rotate(20deg);
  }
}
</style>
