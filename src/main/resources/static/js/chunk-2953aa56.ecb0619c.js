(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2953aa56"],{"4cca":function(e,t,s){},a66c:function(e,t,s){"use strict";var r=s("4cca"),n=s.n(r);n.a},b0d8:function(e,t,s){"use strict";s.r(t);var r=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",[s("div",{staticClass:"login-container"},[s("el-form",{ref:"user",staticClass:"demo-ruleForm login-page",attrs:{model:e.user,rules:e.rules,"status-icon":"","label-position":"left","label-width":"0px"}},[s("h3",{staticClass:"title"},[e._v("资料馆系统登录")]),s("el-form-item",{attrs:{prop:"username"}},[s("el-input",{attrs:{type:"text","auto-complete":"off",placeholder:"用户名/手机号"},model:{value:e.user.username,callback:function(t){e.$set(e.user,"username",t)},expression:"user.username"}})],1),s("el-form-item",{attrs:{prop:"password"}},[s("el-input",{attrs:{type:"password","auto-complete":"off",placeholder:"密码"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleSubmit(t)}},model:{value:e.user.password,callback:function(t){e.$set(e.user,"password",t)},expression:"user.password"}})],1),s("el-form-item",{staticStyle:{width:"100%"}},[s("el-button",{staticStyle:{width:"100%"},attrs:{type:"primary",loading:e.logining},nativeOn:{click:function(t){return e.handleSubmit(t)}}},[e._v("登录")])],1)],1)],1)])},n=[],a=s("5530"),i=s("8d85"),o=s("2f62"),u={data:function(){return{logining:!1,user:{username:"admin",password:"123456"},rules:{username:[{required:!0,message:"账号不能为空",trigger:"blur"}],password:[{required:!0,message:"密码不能为空",trigger:"blur"}]}}},computed:Object(a["a"])({},Object(o["b"])(["isLogin"])),mounted:function(){this.isLogin&&this.$router.push("/")},methods:{handleSubmit:function(e){var t=this;this.$refs.user.validate((function(e){if(!e)return!1;t.logining=!0,Object(i["b"])(t.user.username,t.user.password).then((function(e){t.logining=!1,200==e.code&&(localStorage.setItem("token",e.data),t.$store.commit("setToken",e.data),Object(i["a"])().then((function(e){t.$store.commit("setUser",e.data),t.$notify({showClose:!0,title:"欢迎来到资料馆",type:"success"})})))}))}))}}},l=u,c=(s("a66c"),s("2877")),d=Object(c["a"])(l,r,n,!1,null,"2324f768",null);t["default"]=d.exports}}]);
//# sourceMappingURL=chunk-2953aa56.ecb0619c.js.map