<template>
  <div class="Table">
    <vue-scroll>
      <table class="table">
        <thead class="table-thead table-borderless" :style="theadStyle">
          <tr>
            <!-- 标题 -->
            <th class="check-th">
              <el-checkbox
                v-model="isCheckAll"
                :indeterminate="isIndeterminate"
                @change="checkAll"
              >全选</el-checkbox>
            </th>
            <th scope="col" v-for="(item,index) of titles" :key="'title:'+index">{{item}}</th>
          </tr>
        </thead>
        <tbody>
          <!-- 数据 -->
          <tr v-for="(data,index) of dataList" :key="'dataList:'+index">
            <td>
              <el-checkbox v-model="data.isCheck" @change="dataCheck"></el-checkbox>
            </td>
            <td v-for="(key,index) of columns" :key="'columns:'+index">{{data[key]}}</td>
          </tr>
        </tbody>
      </table>
    </vue-scroll>
  </div>
</template>
<script>
export default {
  name: "Table",
  props: {
    //表头
    titles: {
      type: Array,
      default() {
        return [];
      }
    },
    //展示内容
    columns: {
      type: Array,
      default() {
        return [];
      }
    },
    dataList: {
      type: Array,
      default() {
        return [];
      }
    },
    theadStyle: {
      type: Object,
      default() {
        return {};
      }
    },
    tbodyStyle: {
      type: Object,
      default() {
        return {};
      }
    }
  },
  computed: {
    checkNum() {
      return this.dataList.filter(item => item.isCheck).length;
    },
    isIndeterminate() {
      return this.checkNum > 0 && this.checkNum < this.dataList.length;
    }
  },
  data() {
    return {
      isCheckAll: false
    };
  },
  methods: {
    checkAll() {
      this.dataList.forEach(item => {
        item.isCheck = this.isCheckAll;
      });
    },
    dataCheck() {
      this.isCheckAll = this.checkNum == this.dataList.length;
    }
  }
};
</script>
<style scoped>
.table {
  height: 100%;
  margin-bottom: 0;
}

thead tr th {
  color: #909399;
  vertical-align: top;
}

.check-th {
  width: 100px;
}

tbody tr:hover {
  background-color: rgb(245, 247, 250);
}
</style>