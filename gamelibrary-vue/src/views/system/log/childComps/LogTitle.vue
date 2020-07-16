<template>
  <div class="LogTitle">
    <div class="search-option">
      <div>
        <el-input size="mini" v-model="log.name" clearable placeholder="操作"></el-input>
      </div>

      <div>
        <el-input size="mini" v-model="log.username" clearable placeholder="操作用户"></el-input>
      </div>

      <div>
        <el-input size="mini" v-model="log.ip" clearable placeholder="IP"></el-input>
      </div>

      <div>
        <el-button
          :loading="loading"
          size="mini"
          type="primary"
          icon="el-icon-search"
          @click="queryData"
        >搜索</el-button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "LogTitle",
  props: {
    loading: {
      type: Boolean,
      default() {
        return false;
      }
    }
  },
  data() {
    return {
      log: {
        name: "",
        username: "",
        ip: ""
      }
    };
  },
  methods: {
    queryData() {
      this.$emit("searchDataList", this.log);
    }
  }
};
</script>
<style scoped>
.LogTitle {
  margin: 10px 0;
}

.search-option {
  position: relative;
  width: 100%;
  display: flex;
}
.search-option div {
  margin-right: 10px;
}
</style>