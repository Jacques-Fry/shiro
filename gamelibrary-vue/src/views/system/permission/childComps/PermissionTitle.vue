<template>
  <div class="PermissionTitle">
    <div class="search-option">
      <div >
        <el-input size="mini" v-model="permission.name" clearable placeholder="权限名称"></el-input>
      </div>

      <div>
        <el-input size="mini" v-model="permission.nickname" clearable placeholder="权限别称"></el-input>
      </div>

      <div >
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
  name: "PermissionTitle",
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
      permission: {
        name: "",
        nickname: "",
      }
    };
  },
  methods: {
    queryData() {
      this.$emit("searchDataList",this.permission);
    }
  }
};
</script>
<style scoped>
.PermissionTitle {
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