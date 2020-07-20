import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    // isLogin: window.localStorage.getItem("isLogin" || "[]") == null ? "" : true,
    // user: {
    //   userName:
    //     window.localStorage.getItem("user" || "[]") == null
    //       ? ""
    //       : JSON.parse(window.localStorage.getItem("user" || "[]")).userName,
    //   password:
    //     window.localStorage.getItem("user" || "[]") == null
    //       ? ""
    //       : JSON.parse(window.localStorage.getItem("user" || "[]")).password,

    //   userId:
    //     window.localStorage.getItem("user" || "[]") == null
    //       ? ""
    //       : JSON.parse(window.localStorage.getItem("user" || "[]")).userId
    // },
    isLogin: true,
    user: {
      userName: "测试用户名",
      iconUrl: "",
      userId: "111"
    },
    scroll: 0,
    maxPageNum: 3,
    keyWord: ""
  },
  mutations: {
    login(state, user) {
      state.isLogin = true;
      state.user = user;
      window.localStorage.setItem("user", JSON.stringify(user));
      window, localStorage.setItem("islogin", true);
    },
    scroll(state, curr) {
      state.scroll = curr;
    }
  },
  actions: {},
  modules: {},
  getters: {
    getScroll: state => {
      return state.scroll;
    },
    getLogState: state => {
      return state.isLogin;
    },
    getName: state => {
      return state.user.userName;
    },
    getIcon: state => {
      return state.user.iconUrl;
    },
    getId: state => {
      return state.user.userId;
    }
  }
});
