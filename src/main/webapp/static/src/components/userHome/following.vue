<template>
  <div>
    <b-row>
      <b-col>
        <b-nav tabs align="center">
          <b-nav-item to="/userHome/profile">profile</b-nav-item>
          <b-nav-item to="/userHome/posts">帖子</b-nav-item>
          <b-nav-item active to="/userHome/following">关注</b-nav-item>
          <b-nav-item to="/userHome/collection">收藏</b-nav-item>
        </b-nav>
      </b-col>
    </b-row>
    <b-row>
      <b-col cols="4" v-for="(item, index) in followings" :key="index">
        <div class="sider">
          <div style="width:100%;height:100px;overflow:hidden">
            <img
              src="../../assets/back.jpg"
              style="width:100%;overflow:hidden"
              alt=""
            />
          </div>
          <div id="icon_box">
            <img :src="item.url" alt="" />
          </div>
          <h2>{{ item.name }}</h2>
          <div id="site_intro">
            {{ item.intro }}
          </div>
        </div>
      </b-col>
    </b-row>
  </div>
</template>
<script>
export default {
  data() {
    return {
      followings: [
        {
          name: "test",
          url: "http://gittub.cc/small2.png",
          uid: 0,
          intro: ""
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png",
          uid: 0,
          intro: ""
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png",
          uid: 0,
          intro: ""
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png",
          uid: 0,
          intro: ""
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png",
          uid: 0,
          intro: ""
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png",
          uid: 0,
          intro: ""
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png",
          uid: 0,
          intro: ""
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png",
          uid: 0,
          intro: ""
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png",
          uid: 0,
          intro: ""
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png",
          uid: 0,
          intro: ""
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png",
          uid: 0,
          intro: ""
        }
      ]
    };
  }
};
</script>
<style lang="scss" scoped>
.sider {
  @include card;
  margin: 10px;
  display: flex;
  flex-direction: column;
  #site_intro {
    border-top: 0.5px $background-color ridge;
    width: 80%;
    margin: 0 auto;
    text-align: center;
  }
  #icon_box {
    & img {
      border-radius: 50%;
      overflow: hidden;
      width: 80px;
      height: 80px;
    }
    position: relative;
    top: -40px;
  }
}
</style>
