import axios from 'axios'
import Vue from 'vue'
import store from '@/store'
const vue = new Vue()

export function request(config) {
  //创建axios实例
  const instance = axios.create({
    //http://127.0.0.1:10001
    baseURL: 'http://129.204.232.85:8888',
    timeout: 10000
  })

  //axios拦截器
  //请求拦截
  instance.interceptors.request.use(config => {
    // console.log(store.getters.getToken)
    // console.log(typeof (store.getters.getToken) == "string")
    config.headers['Authorization'] = 'c4b6f317-e92e-408d-9282-1578943cd1d1'
    return config
  }, err => {
    console.log(err)
    vue.$message({
      showClose: true,
      message: "网络异常",
      type: "error"
    })
  })

  //响应拦截
  instance.interceptors.response.use(res => {
    if (res.status != 200) {
      vue.$message({
        showClose: true,
        message: "网络异常",
        type: "error"
      })
    }

    if (res.data.code != 200) {
      vue.$message({
        showClose: true,
        message: res.data.msg,
        type: "error"
      });
    }
    // if (res.data.code === 6000) {
    //   localStorage.clear()
    //   store.commit('setToken', '')
    //   vue.$bus.$emit("toLogin");
    // }
    return res.data
  }, err => {
    console.log(err)
    vue.$message({
      showClose: true,
      message: "网络异常",
      type: "error"
    })
  })

  //发送网络请求
  return instance(config)
}