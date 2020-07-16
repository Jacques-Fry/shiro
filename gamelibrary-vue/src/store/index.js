import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    breadcrumbList: {
      type: Array,
      default () {
        return []
      }
    }
  },
  getters: {
    getBreadcrumbList(state) {
      return state.breadcrumbList
    }
  },
  mutations: {
    setBreadcrumbList(state, payLoad) {
      state.breadcrumbList = payLoad
    },
  },
  actions: {},
  modules: {}
})