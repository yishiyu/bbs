<template>
  <div>
    <b-row>
      <b-col>
        <b-nav tabs align="center">
          <b-nav-item active to="this.r">profile</b-nav-item>
          <b-nav-item>帖子</b-nav-item>
          <b-nav-item>关注</b-nav-item>
          <b-nav-item>粉丝</b-nav-item>
        </b-nav>
      </b-col>
    </b-row>
    <b-row>
      <b-col class="card">
        <div>
          <h4>我的信息</h4>
        </div>
        <b-row>
          <b-col cols="2">
            用户名
          </b-col>
          <b-col cols="10">
            <b-input-group>
              <b-form-input></b-form-input>

              <b-input-group-append>
                <b-button variant="outline-secondary">更改</b-button>
              </b-input-group-append>
            </b-input-group>
          </b-col>
        </b-row>
        <b-row>
          <b-col cols="2">
            密码
          </b-col>
          <b-col cols="10">
            <b-input-group>
              <b-form-input></b-form-input>

              <b-input-group-append>
                <b-button variant="outline-secondary">更改</b-button>
              </b-input-group-append>
            </b-input-group>
          </b-col>
        </b-row>
        <b-form-textarea
          id="textarea"
          v-model="text"
          placeholder="Enter something..."
          rows="3"
          max-rows="6"
        ></b-form-textarea>
      </b-col>
    </b-row>
  </div>
</template>
<script>
export default {
  data() {
    return {};
  },
  mounted() {}
};
</script>
<style lang="scss" scoped></style>
