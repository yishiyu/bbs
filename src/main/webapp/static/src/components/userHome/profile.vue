<template>
  <div>
    <b-row>
      <b-col>
        <b-nav tabs align="center">
          <b-nav-item active to="/userHome/profile">profile</b-nav-item>
          <b-nav-item to="/userHome/posts">帖子</b-nav-item>
          <b-nav-item to="/userHome/following">关注</b-nav-item>
          <b-nav-item to="/userHome/collection">收藏</b-nav-item>
        </b-nav>
      </b-col>
    </b-row>
    <b-row>
      <b-col md="4">
        <div>
          <br />
          <img src="" style="width:200px;height:200px;display:block" alt="" />
          <b-button variant="success">更改头像</b-button>
        </div>
      </b-col>
      <b-col md="8">
        <b-row>
          <b-col>
            <div class="profile_card">
              <div>
                <h4>我的信息</h4>
              </div>
              <br />
              <b-row style="min-height:20px">
                <b-col cols="4">
                  用户名
                </b-col>
                <b-col cols="8">
                  <p v-if="show">{{ userName }}</p>
                  <b-input-group v-if="input">
                    <b-form-input v-model="userName"></b-form-input>

                    <b-input-group-append>
                      <b-button variant="outline-secondary" @click="submit"
                        >更改</b-button
                      >
                    </b-input-group-append>
                  </b-input-group>
                </b-col>
              </b-row>
              <br />
              <b-row v-if="input">
                <b-col cols="4">
                  密码
                </b-col>
                <b-col cols="8">
                  <b-input-group>
                    <b-form-input v-model="password"></b-form-input>

                    <b-input-group-append>
                      <b-button variant="outline-secondary">更改</b-button>
                    </b-input-group-append>
                  </b-input-group>
                </b-col>
              </b-row>
              <br />

              <b-row style="min-height:20px">
                <b-col cols="4">
                  个人简介：
                </b-col>
                <b-col cols="8">
                  <p v-if="show">{{ introduction }}</p>
                  <b-form-textarea
                    id="textarea"
                    v-if="input"
                    v-model="introduction"
                    placeholder="Enter something..."
                    rows="3"
                    max-rows="10"
                  ></b-form-textarea>
                </b-col>
              </b-row>
              <br />
              <b-row>
                <b-col style="padding:0 10%">
                  <b-button
                    style="float:center"
                    variant="success"
                    @click="click"
                  >
                    {{ state }}
                  </b-button>
                </b-col>
              </b-row>
            </div>
          </b-col>
        </b-row>
      </b-col>
    </b-row>
  </div>
</template>
<script>
export default {
  data() {
    return {
      userName: "test",
      password: "111",
      introduction: "这个人什么也没留下。。。",
      state: "修改",
      input: false
    };
  },
  computed: {
    show() {
      return !this.input;
    }
  },
  methods: {
    click(e) {
      e.preventDefault();
      if (this.state == "修改") {
        this.state = "保存";
        this.input = "true";
      } else {
        this.state = "修改";
        this.input = false;
        this.submit();
      }
    },
    submit() {}
  },
  mounted() {}
};
</script>
<style lang="scss" scoped>
.profile_card {
  @include card;
  padding: 10%;
}
</style>
