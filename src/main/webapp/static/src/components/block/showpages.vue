<template>
  <div>
    <block_header></block_header>
    <progressbar></progressbar>
    <bread></bread>
    <b-container class="list">
      <b-row>
        <b-col id="imageBox">
          <img
            src="../../assets/back.jpg"
            style="height: 300px;width:100%"
            alt=""
            class="rounded-lg"
          />
        </b-col>
      </b-row>
      <b-row id="introductionBox">
        <b-col>
          {{ block_introduction }}
        </b-col>
      </b-row>
      <b-row>
        <b-col md="8">
          <router-link
            style="color:black"
            :to="page.url"
            v-for="(page, index) in pages"
            :key="index"
          >
            <div :class="page.class">
              <b-row>
                <b-col style="display:flex;align-items:center ">
                  <b-icon
                    style="display: inline-block"
                    icon="star-fill"
                    v-if="page.isBoutique"
                  >
                  </b-icon>

                  <h4 style="display:inline-block;margin:10px">
                    {{ page.title }}
                  </h4>
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <div id="page_abstract">
                    <p>{{ page.abstract }}</p>
                  </div>
                </b-col>
              </b-row>
              <b-row>
                <b-col cols="1">
                  <img src="page.url" alt="" />
                </b-col>
                <b-col cols="5"> {{ page.user }}|{{ page.time }} </b-col>

                <b-col style="text-align: right;padding-right:20px">
                  点赞{{ page.data.iine }}|浏览{{ page.data.visited }}
                </b-col>
              </b-row>
            </div>
          </router-link>
        </b-col>
        <b-col md="4">
          <div id="sider" class="rounded-lg shadow">
            <h1>我要发贴</h1>
            <b-form @submit="onSubmit" @reset="onReset">
              <b-form-group label="发帖分区:" label-for="input-1">
                <b-form-select
                  id="input-1"
                  v-model="form.block"
                  :options="block_names"
                  required
                >
                </b-form-select>
              </b-form-group>
              <b-form-textarea
                id="textarea"
                v-model="form.text"
                placeholder="Enter something..."
                rows="3"
                max-rows="6"
              ></b-form-textarea>
              <b-button type="submit" variant="primary">Submit</b-button>
              <b-button type="reset" variant="danger">Reset</b-button>
            </b-form>
          </div>
        </b-col>
      </b-row>
    </b-container>
    <block_footer></block_footer>.
  </div>
</template>
<script>
import block_header from "../common/Header";
import block_footer from "../common/Footer";
import bread from "../common/breadcrumb";
import progressbar from "../common/progress";
export default {
  data() {
    return {
      page_count: 20,
      pages: [],
      block_introduction: "这是板块介绍介绍介绍",
      form: {
        block: "",
        user: "",
        text: ""
      },
      block_names: [{ text: "Select One", value: null }, "a", "b", "c"]
    };
  },
  components: {
    block_header,
    block_footer,
    bread,
    progressbar
  },
  methods: {
    onSubmit(e) {
      e.preventDefault();
    },
    onReset(e) {
      e.preventDefault();
    }
  },
  mounted() {
    for (var i = 0; i < this.page_count; i++) {
      this.pages.push({
        isBoutique: true,
        title: "这是一段标题",
        user: "发帖人",
        abstract:
          "我是一段摘要摘要摘要摘要我是一段摘要摘要摘要摘要我是一段摘要摘要摘要摘要我是一段摘要摘要摘要摘要我是一段摘要摘要摘要摘要我是一段摘要摘要摘要摘要我是一段摘要摘要摘要摘要我是一段摘要摘要摘要摘要我是一段摘要摘要摘要摘要",
        data: {
          iine: 0,
          visited: 0
        },
        url: "/page/10?1",
        class: " shadow mb-1 tiezi bg-white rounded-lg",
        time: "十年前"
      });
    }
  }
};
</script>
<style lang="scss" scoped>
#im .list {
  background-color: white;
  text-align: left;

  #imageBox {
    width: 100%;
    height: 280px;
  }
  #introductionBox {
    color: red;
    text-align: left;
  }
  .tiezi {
    text-align: left;
    #page_abstract {
      background-color: lightgray;
      display: block;
      margin: 20px;
    }
  }
}
#sider {
  position: sticky;
  background-color: white;
  top: 100px;
}
</style>
