<template>
  <div class="main-nav-bar">
    <NavBar class="nav-bar-item" path="/home">
      <i slot="icon" class="el-icon-s-home"></i>
      <span slot="name">首页</span>
    </NavBar>

    <NavBar class="nav-bar-item" path="/user">
      <i slot="icon" class="el-icon-s-order"></i>
      <span slot="name">用户管理</span>
    </NavBar>

    <NavBar class="nav-bar-item" path="/role">
      <i slot="icon" class="el-icon-s-custom"></i>
      <span slot="name">角色管理</span>
    </NavBar>

    <NavBar class="nav-bar-item" path="/permission">
      <i slot="icon" class="el-icon-menu"></i>
      <span slot="name">权限管理</span>
    </NavBar>

    <NavBar class="nav-bar-item" path="/log">
      <i slot="icon" class="el-icon-document"></i>
      <span slot="name">操作记录</span>
    </NavBar>

    <NavBar class="nav-bar-item" path="/detail">
      <i slot="icon" class="el-icon-user"></i>
      <span slot="name">个人中心</span>
    </NavBar>
  </div>
</template>

<script type="text/javascript">
import NavBar from "components/common/navbar/NavBar";
export default {
  name: "MainNavBar",
  data() {
    return {};
  },
  components: { NavBar }
};
</script>

<style scoped>
.nav-bar {
  text-align: center;
  width: 100%;

  color: rgb(187, 206, 246);
}
.nav-bar-item {
  cursor: pointer;
  padding: 5px 0;
}
.nav-bar-item:hover {
  color: #fff;
  background-color: rgb(95, 111, 145);
}
.nav-bar-item i {
  /* margin-bottom: 5px; */
  font-size: 30px;
}
.nav-bar-item span{
  font-size: 14px;
}
</style>
