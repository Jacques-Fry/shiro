<template>
  <div class="Link">
    <span @click="openLocal">
      <slot name="vue-link"></slot>
    </span>
    <span @click="openNew">
      <slot name="js-link"></slot>
    </span>
  </div>
</template>

<script type="text/javascript">
export default {
  name: "Link",
  props: {
    link: {
      type: String,
      default() {
        return "";
      }
    }
  },
  methods: {
    openLocal() {
      if (this.$route.path.indexOf(this.link) === -1) {
        this.$router.push(this.link);
      }
    },
    openNew() {
      window.open(this.link);
    }
  }
};
</script>

<style scoped>
.Link {
  display: inline-block;
}
</style>
