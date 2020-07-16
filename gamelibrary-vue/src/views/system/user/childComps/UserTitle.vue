<template>
  <div class="UserTitle">
    <div class="search-option">
      <div>
        <el-input size="mini" v-model="user.username" clearable placeholder="用户名"></el-input>
      </div>

      <div>
        <el-input size="mini" v-model="user.tel" clearable placeholder="手机号"></el-input>
      </div>

      <div>
        <el-select size="mini" v-model="user.roleId" placeholder="用户类型">
          <el-option label="全部角色" :value="null"></el-option>
          <el-option
            v-for="(item,index) in roles"
            :key="'roles'+index"
            :label="item.name"
            :value="item.id"
          ></el-option>
        </el-select>
      </div>

      <div class="option-search">
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
  name: "UserTitle",
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
      roles: [],
      user: {
        username: "",
        tel: "",
        roleId: null
      }
    };
  },
  methods: {
    queryData() {
      this.$emit("searchDataList", this.user);
    }
  }
};
</script>
<style scoped>
.UserTitle {
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