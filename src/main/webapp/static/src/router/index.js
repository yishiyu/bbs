import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);
const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../components/mainPage/home")
  },
  {
    path: "/page/:page_id",
    name: "tiezi",
    component: () => import("../components/tiezi/page")
  },
  {
    path: "/admin",
    name: "admin",

    component: () => import("../components/admin/pinel")
  },
  {
    path: "/block/:block_id",
    name: "block",
    component: () => import("../components/block/showpages")
  },
  {
    path: "/userHome/:user_id",
    name: "userhome",
    component: () => import("../components/userHome/userhome")
  },
  {
    path: "/login",
    name: "login",
    component: () => import("../components/login/login")
  },
  {
    path: "/signin",
    name: "signin",
    component: () => import("../components/login/signin")
  }
];

const router = new VueRouter({
  routes
});

export default router;
