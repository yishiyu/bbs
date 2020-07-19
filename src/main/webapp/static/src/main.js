import Vue from "vue";
import "./plugins/bootstrap-vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import { BootstrapVue, BootstrapVueIcons } from "bootstrap-vue";
import axios from "axios";
import VueAxios from "vue-axios";
Vue.use(BootstrapVue);
Vue.use(BootstrapVueIcons);
Vue.use(VueAxios, axios);
Vue.config.productionTip = false;
import moment from "moment"; //导入文件
Vue.prototype.$moment = moment; //赋值使用
moment.locale("zh-cn"); //国际化，中文
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
