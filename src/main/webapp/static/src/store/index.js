import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLogin: window.localStorage.getItem("isLogin" || "[]") == null ? "" : true,
    user: {
      userName:
        window.localStorage.getItem("user" || "[]") == null
          ? ""
          : JSON.parse(window.localStorage.getItem("user" || "[]")).userName,
      password:
        window.localStorage.getItem("user" || "[]") == null
          ? ""
          : JSON.parse(window.localStorage.getItem("user" || "[]")).password,

      userId:
        window.localStorage.getItem("user" || "[]") == null
          ? ""
          : JSON.parse(window.localStorage.getItem("user" || "[]")).userId,
      token:
        window.localStorage.getItem("user" || "[]") == null
          ? ""
          : JSON.parse(window.localStorage.getItem("user" || "[]")).token
    },
    visit: {
      userId: ""
    },
    scroll: 0,
    maxPageNum: 3
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
    }
  }
});
