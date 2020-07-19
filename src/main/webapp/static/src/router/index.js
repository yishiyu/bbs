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
    component: () => import("../components/post/page")
  },
  {
    path: "/admin",
    name: "admin",

    component: () => import("../components/admin/pinel"),
    children: [
      {
        path: "dashboard",
        name: "dashboard",
        component: () => import("../components/admin/dashboard")
      }
    ]
  },
  {
    path: "/admin",
    redirect: "/admin/dashboard"
  },
  {
    path: "/block/:block_id/:count",
    name: "block",
    component: () => import("../components/block/showpages")
  },
  {
    path: "/block/:block_id/",
    redirect: "/block/:block_id/1"
  },
  {
    path: "/userHome/:user_id",
    name: "userhome",
    component: () => import("../components/userHome/userhome"),
    children: [
      {
        path: "profile",
        name: "profile",
        component: () => import("../components/userHome/profile")
      }
    ]
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
