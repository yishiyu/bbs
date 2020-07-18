<template>
  <div>
    <div style="width:100%;position:relative;">
      <img src="../../assets/sitehead.png"
           style="width:100%;height:auto"
           alt="">
    </div>
    <home_header style="margin-top:-13.55%"></home_header>
    <progressbar></progressbar>
    <br><br><br><br><br><br>
    <b-container id="contain">
      <br>
      <b-row>
        <b-col md="8"
               id="carousel"
               class="incontainer">
          <carousel></carousel>
        </b-col>
        <b-col md="4"
               id="fashion"
               class="rounded-lg incontainer">
          <div>
            <ul>
              <router-link v-for="(item, index) in fashion"
                           :key="index"
                           :to="item.url">
                <li style="display: block;">
                  {{ item.title }}
                  <p style="text-align: end;">time</p>
                </li>
              </router-link>
            </ul>
          </div>
        </b-col>
      </b-row>
      <br />
      <b-row>
        <b-col class="nopadding rounded-top incontainer"
               style="border: 0.5px ridge ;">
          论坛版块
        </b-col>
      </b-row>

      <b-row id="main">
        <b-col md="8"
               id="blocks">
          <br />
          <div>
            <b-row>
              <b-col v-for="(item, index) in blocks"
                     :key="index"
                     cols="6">
                <router-link :to="item.url"
                             class="block_box">
                  <div style="max-width: 20rem;"
                       class="mb-2 block_card">
                    <div class="imgbox">
                      <img src="http://gittub.cc/small2.png"
                           alt="" />
                    </div>
                    <p>
                      {{ item.name }}
                    </p>
                  </div>
                </router-link>
              </b-col>
            </b-row>
          </div>
        </b-col>
        <b-col md="4">
          <br /><br /><br /><br />
          <div id="sider_bar"
               class="rounded-lg ">
            <div class="sider">
              <div style="width:100%;height:100px;overflow:hidden">
                <img src="../../assets/back.jpg"
                     style="width:100%;overflow:hidden"
                     alt="">
              </div>
              <div id="icon_box">
                <img src="http://gittub.cc/small2.png"
                     alt="">
              </div>
              <h2>Gittub</h2>
              <p>这里是gittub的简介</p>
              <div id="site_intro">

              </div>
            </div>
          </div>
        </b-col>
      </b-row>
      <home_footer></home_footer>
    </b-container>
  </div>
</template>
<script>
import home_header from '../common/Header'
import home_footer from '../common/Footer'
import carousel from '../common/carousel'
import progressbar from '../common/progress'
export default {
  name: 'home',
  data() {
    return {
      blocks: [
        {
          name: 'test',
          imgurl: 'http://gittub.cc/small2.png',
          introduction: '',
          url: '/block/111'
        },
        {
          name: 'test',
          imgurl: 'http://gittub.cc/small2.png',
          introduction: '',
          url: '/block/111'
        },
        {
          name: 'test',
          imgurl: 'http://gittub.cc/small2.png',
          introduction: '',
          url: '/block/111'
        },
        {
          name: 'test',
          imgurl: 'http://gittub.cc/small2.png',
          introduction: '',
          url: '/block/111'
        },
        {
          name: 'test',
          imgurl: 'http://gittub.cc/small2.png',
          introduction: '',
          url: '/block/111'
        },
        {
          name: 'test',
          imgurl: 'http://gittub.cc/small2.png',
          introduction: '',
          url: '/block/111'
        },
        {
          name: 'test',
          imgurl: 'http://gittub.cc/small2.png',
          introduction: '',
          url: '/block/111'
        },
        {
          name: 'test',
          imgurl: 'http://gittub.cc/small2.png',
          introduction: '',
          url: '/blocks/111'
        }
      ],
      fashion: [
        {
          title: '测试热门文章',
          url: '/page/1'
        },
        {
          title: '测试热门文章',
          url: 'xxx://dfdf.vdf'
        },
        {
          title: '测试热门文章',
          url: 'xxx://dfdf.vdf'
        },
        {
          title: '测试热门文章',
          url: 'xxx://dfdf.vdf'
        }
      ],
      block_names: [{ text: 'Select One', value: null }, 'a', 'b', 'c']
    }
  },
  components: {
    home_header,
    home_footer,
    carousel,
    progressbar
  },
  methods: {
    onReset() {},
    onSubmit() {}
  },
  mounted() {}
}
</script>
<style lang="scss" scoped>
.title {
  border: 1px ridge;
  padding: 15px;
}

#fashion {
  border: 0.5px ridge white;
  text-align: left;
  & ul {
    padding-left: 0;
  }
  & li {
    border-bottom: 0.5px ridge;
    height: 50px;
  }
}

#main {
  #sider_bar {
    width: 100%;
    .sider {
      @include card;

      display: flex;
      flex-direction: column;
      #site_intro {
        border-top: 0.5px $background-color ridge;
        width: 80%;
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

  #blocks {
    margin: 0 auto;
    .block_box:hover img {
      transform: scale(1.5);
      -webkit-transform: scale(1.5);
    }

    .block_box img {
      width: 100%;
      height: auto;
      transition: transform 2s;
      -webkit-transition: -webkit-transform 2s;
    }
    .block_card {
      @include card;
    }
    border-right: 0.5px ridge $background-color;
  }
  .imgbox {
    overflow: hidden;
    width: 100%;
  }
}

.nopadding {
  padding: 0;
}
</style>
