<template>
  <div class="RoleTitle">
    <div class="search-option">
      <div >
        <el-input size="mini" v-model="role.name" clearable placeholder="角色名"></el-input>
      </div>

      <div >
        <el-input size="mini" v-model="role.nickname" clearable placeholder="角色别称"></el-input>
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
  name: "RoleTitle",
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
      role: {
        name: "",
        nickname: "",
      }
    };
  },
  methods: {
    queryData() {
      this.$emit("searchDataList",this.role);
    }
  }
};
</script>
<style scoped>
.RoleTitle {
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