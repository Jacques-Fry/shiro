<template>
  <div class="UserContent">
    <UserTitle @searchDataList="searchDataList" :loading="loading" />

    <Table class="Table" :titles="titles" :columns="columns" :dataList="dataList" />

    <div class="paging">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="pageSizes"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </div>
  </div>
</template>
<script>
import UserTitle from "./UserTitle.vue";

import Table from "components/common/bootstrap/table/Table.vue";

import { queryUserList } from "network/user.js";

import { CommonDataListContent } from "common/mixins.js";

export default {
  name: "UserContent",
  data() {
    return {
      titles: ["ID", "用户名", "手机号", "账户状态", "角色", "注册时间"],
      columns: ["id", "dataname", "tel", "status", "roleId", "createTime"],
    };
  },
  components: { UserTitle, Table },
  methods: {
    queryDataList() {
      let loadingInstance = this.pageLoading();
      queryUserList(this.data, this.currentPage, this.pageSize).then(res => {
        this.pageStopLoading(loadingInstance);
        if (res && res.code === 200) {
          this.total = res.data.total;
          let list = res.data.list;
          list.forEach(item => {
            item.createTime = this.timeFormat(item.createTime);
            item.isCheck = false;
          });
          this.dataList = list;
        }
      });
    }
  },
  mixins: [CommonDataListContent]
};
</script>
<style scoped>
.UserContent {
  position: relative;
  height: 100%;
}
.Table {
  box-shadow: 0 0 2px 0 rgba(0, 0, 0, 0.2);
  position: relative;
  height: calc(100% - 100px);
}
.paging {
  text-align: center;
  margin-left: 10px;
  padding-top: 20px;

  width: 100%;
  height: 50px;
  background-color: #fff;
}
</style>