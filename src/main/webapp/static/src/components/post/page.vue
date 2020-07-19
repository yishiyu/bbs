<template>
  <div>
    <page_header></page_header>
    <progress_bar></progress_bar>
    <b-container>
      <navigator></navigator>
      <b-row>
        <b-col id="page_container" md="8">
          <br />
          <b-row>
            <b-col cols="6">
              <div class="userBox">
                <img src="../../assets/logo.png" class="icon" alt="" />
                {{ page.authName }}
              </div>
            </b-col>
            <b-col cols="6">
              <b-button variant="success">关注</b-button>
            </b-col>
          </b-row>
          <b-row>
            <b-col>
              <h1>{{ page.title }}</h1>
            </b-col>
          </b-row>
          <b-row style="border-bottom:0.5px lightgray ridge">
            <b-col class="textBox">
              <p>{{ page.content }}</p>
            </b-col>
          </b-row>
          <b-row>
            <b-col col>
              <a href="#input_comment">
                <div>
                  <b-icon icon="chat-fill"></b-icon>
                  {{ page.comments }}
                </div>
              </a>
            </b-col>
            <b-col col>
              <b-icon @click="clickLike" icon="star-fill"></b-icon>
              {{ page.liked }}
            </b-col>
            <b-col col>
              <b-icon icon="eye-fill"></b-icon>
              {{ page.visited }}
            </b-col>
          </b-row>
          <floor
            v-for="(item, index) in items"
            :content="item"
            :key="index"
          ></floor>
          <b-row>
            <b-col>
              <div id="input_comment">
                <h4>发表评论</h4>
                <b-form-textarea
                  id="textarea"
                  v-model="text"
                  placeholder="Enter something..."
                  rows="3"
                  max-rows="6"
                ></b-form-textarea>
                <br />
                <b-button variant="success" style="float:right;display:block"
                  >提交</b-button
                >
              </div>
            </b-col>
          </b-row>
        </b-col>
        <b-col md="4">
          <div id="sider_bar" class="rounded-lg ">
            <div class="sider">
              <div style="width:100%;height:100px;overflow:hidden">
                <img
                  src="../../assets/back.jpg"
                  style="width:100%;overflow:hidden"
                  alt=""
                />
              </div>
              <div id="icon_box">
                <img src="http://gittub.cc/small2.png" alt="" />
              </div>
              <h2>{{ page.authName }}</h2>
              <div id="site_intro">
                {{ page.sign }}
              </div>
            </div>
            <br />
            <div class="sider">
              <h2>板块链接</h2>
              <b-row style="padding : 0 10px">
                <b-col
                  style="margin: 10px 0"
                  v-for="(item, index) in blocks"
                  :key="index"
                  cols="4"
                >
                  <img style="width:100%" :src="item.url" alt="" />
                  {{ item.name }}
                </b-col>
              </b-row>
            </div>
          </div>
        </b-col>
      </b-row>
    </b-container>
    <page_footer></page_footer>
  </div>
</template>
<script>
import page_header from "../common/Header.vue";
import page_footer from "../common/Footer";
import navigator from "../common/breadcrumb";
import progress_bar from "../common/progress";
import floor from "./floor";

export default {
  data() {
    return {
      text: "",
      liked: false,
      floors_num: "10",
      items: [
        {
          userName: "ttt",
          comment: "testtesttest",
          iconUrl: "../../assets/logo.png",
          time: "2020.7.4"
        },
        {
          userName: "ttt",
          comment: "testtesttest",
          iconUrl: "../../assets/logo.png",
          time: "2020.7.4"
        },
        {
          userName: "ttt",
          comment: "testtesttest",
          iconUrl: "../../assets/logo.png",
          time: "2020.7.4"
        },
        {
          userName: "ttt",
          comment: "testtesttest",
          iconUrl: "../../assets/logo.png",
          time: "2020.7.4"
        }
      ],
      page: {
        authName: "test",
        iconUrl: "",
        title: "测试文章",
        content:
          "测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容",
        visited: 0,
        liked: 0,
        comments: 0,
        sign: "这是作者的简介"
      },
      blocks: [
        {
          name: "test",
          url: "http://gittub.cc/small2.png"
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png"
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png"
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png"
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png"
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png"
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png"
        },

        {
          name: "test",
          url: "http://gittub.cc/small2.png"
        },
        {
          name: "test",
          url: "http://gittub.cc/small2.png"
        }
      ]
    };
  },
  methods: {
    clickLike(e) {
      e.preventDefault();
      this.liked = !this.liked;
    }
  },
  components: {
    page_header,
    page_footer,
    navigator,
    progress_bar,
    floor
  }
};
</script>
<style lang="scss" scoped>
.userBox {
  float: left;
  .icon {
    height: 50px;
    width: 50px;
    border-radius: 50%;
  }
}
#page_container {
  @include card;
  #input_comment {
    text-align: left;
    padding: 10px;
  }
}
#sider_bar {
  width: 100%;
  .sider {
    @include card;

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
  position: sticky;
  top: 60px;
}
</style>
