<template>
  <div>
    <b-row>
      <b-col>
        <b-nav tabs align="center">
          <b-nav-item to="/userHome/profile">profile</b-nav-item>
          <b-nav-item to="/userHome/posts">帖子</b-nav-item>
          <b-nav-item to="/userHome/following">关注</b-nav-item>
          <b-nav-item active to="/userHome/collection">收藏</b-nav-item>
        </b-nav>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <router-link
          id="post"
          :to="post.link"
          v-for="(post, index) in posts"
          :key="index"
        >
          <div>
            <b-row>
              <b-col style="display:flex;align-items:center ">
                <b-icon
                  style="display: inline-block"
                  icon="star-fill"
                  v-if="post.isBoutique"
                >
                </b-icon>

                <h4 style="display:inline-block;margin:10px">
                  {{ post.title }}
                </h4>
              </b-col>
            </b-row>
            <b-row>
              <b-col>
                <div id="page_abstract">
                  <p>{{ post.abstract }}</p>
                </div>
              </b-col>
            </b-row>
            <b-row>
              <b-col cols="1">
                <img :src="icon" alt="" />
              </b-col>
              <b-col cols="5"> {{ post.name }}|{{ post.time }} </b-col>

              <b-col style="text-align: right;padding-right:20px">
                点赞{{ post.liked }}|浏览{{ post.visited }}
              </b-col>
            </b-row>
          </div>
        </router-link>
      </b-col>
    </b-row>
  </div>
</template>
<script>
export default {
  data() {
    return {
      posts: []
    };
  },
  computed: {
    icon() {
      return this.$store.getters.getIcon;
    }
  },
  mounted() {
    for (var i = 0; i < 10; i++) {
      this.posts.push({
        name: this.$store.getters.getName,
        title: "test",
        abstract: "testtesttest",
        article: "terstetsteestetsetsetsetsetsetsetsetset",
        link: "",
        liked: 0,
        visited: 0,
        time: "十年前"
      });
    }
  }
};
</script>
<style lang="scss" scoped>
#post {
  @include card;
  color: black;
  margin: 10px auto;
  display: block;
  &:hover {
    text-decoration: none;
  }
  #page_abstract {
    text-align: left;
    background-color: $background-color;
    display: block;
    margin: 20px;
  }
}
</style>
