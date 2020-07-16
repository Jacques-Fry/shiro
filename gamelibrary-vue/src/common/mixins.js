import {
    formatDate
} from "common/utils.js";

import {
    Loading
} from "element-ui";

//数据列表页
export const CommonDataListContent = {
    data() {
        return {
            dataList: [],
            data: {},
            pageSize: 20,
            pageSizes: [20, 30, 50],
            currentPage: 1,
            total: 0,
            loading: false
        }
    },
    created() {
        this.queryDataList();
    },
    methods: {
        handleSizeChange(val) {
            // console.log(`每页 ${val} 条`);
            this.pageSize = val;
            this.currentPage = 1;
            this.queryDataList();
        },
        handleCurrentChange(val) {
            // console.log(`当前页: ${val}`);
            this.currentPage = val;
            this.queryDataList();
        },
        searchDataList(data) {
            this.data = data;
            this.currentPage = 1;
            this.queryDataList();
        },
        pageLoading() {
            this.loading = true;
            return Loading.service();
        },
        pageStopLoading(loadingInstance) {
            this.loading = false;
            this.$nextTick(() => {
                // 以服务的方式调用的 Loading 需要异步关闭
                loadingInstance.close();
            });
        },
        //日期格式化
        timeFormat(value) {
            return formatDate(new Date(value), "yyyy年MM月dd日 hh:mm");
        },
    }
}