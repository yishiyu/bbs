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
    path: "/userHome",
    redirect: "/userHome/profile"
  },
  {
    path: "/userHome",
    name: "userhome",
    component: () => import("../components/userHome/userhome"),
    children: [
      {
        path: "profile",
        name: "profile",
        component: () => import("../components/userHome/profile")
      },
      {
        path: "posts",
        name: "posts",
        component: () => import("../components/userHome/posts")
      },
      {
        path: "following",
        name: "following",
        component: () => import("../components/userHome/following")
      },
      {
        path: "collection",
        name: "collection",
        component: () => import("../components/userHome/collection")
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
  },
  {
    path: "/aboutus",
    name: "aboutus",
    component: () => import("../components/about/about")
  },
  {
    path: "*",
    name: "404",
    component: () => import("../components/notfound/notFound")
  }
];

const router = new VueRouter({
  routes
});

export default router;
