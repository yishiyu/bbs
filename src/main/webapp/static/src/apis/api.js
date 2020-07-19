import axios from "axios";
import Qs from "qs";
axios.defaults.baseURL = "http://localhost:9090";
axios.defaults.headers["Content-Type"] = "application/x-www-form-urlencoded";

export const findAllBlocks = () => {
  return axios.post("/block/findAll");
};
// 通过id获取板块横幅和介绍
export const findByBid = bid => {
  return axios.post("/block/findByBid", Qs.stringify({ bid }));
};
// 通过名字获取板块横幅和介绍
export const findByName = name => {
  return axios.post("/block/findByName", Qs.stringify({ name }));
};

/* 获取搜索结果
 * currentPage:现在到第几页了
 * pageSize:一页显示多少个结果
 * bid:属于哪个分类
 * postName:搜索的关键字
 * */
export const getPageQuery = (currentPage, pageSize, bid, postName) => {
  return axios.post(
    "/post/pageQuery",
    Qs.stringify({ currentPage, pageSize, bid, postName })
  );
};

// 通过id获取文章
export const findOne = pid => {
  return axios.post("post/findOne", Qs.stringify({ pid }));
};

// 获取当前用户是否收藏了某一个文章
export const isFavourite = pid => {
  return axios.post("post/isFavourite", Qs.stringify({ pid }));
};

// 取消和添加收藏
export const cancelFavourite = pid => {
  return axios.post("post/cancelFavourite", Qs.stringify({ pid }));
};

export const addFavouritePost = pid => {
  return axios.post("post/addFavourite", Qs.stringify({ pid }));
};

// 获取所有收藏的文章
export const getAllLikedPosts = () => {
  return axios.post("post/likedPosts");
};

// 获取我的文章
export const getMyPosts = () => {
  return axios.post("post/myPosts");
};
// 注册和登录api
export const register = (username, password, email) => {
  return axios.post(
    "user/register",
    Qs.stringify({ username, password, email })
  );
};

export const exit = () => {
  return axios.post("user/exit");
};
export const findUser = uid => {
  return axios.post("user/findUser", Qs.stringify({ uid }));
};
export const login = (username, password, checkCode) => {
  return axios.post(
    "user/login",
    Qs.stringify({ username, password, checkCode })
  );
};

export const getLikedPeople = () => {
  return axios.post("user/likedPeople");
};

export const addFavouriteUser = uid => {
  return axios.post("user/addFavorite", Qs.stringify({ uid }));
};
