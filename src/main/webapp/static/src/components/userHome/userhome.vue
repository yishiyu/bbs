<template>
  <b-container>
    <b-row>
      <b-col>
        <div>
          <!--横幅图片-->
          <img style="width:100%;" src="../../assets/userhome.png" alt="" />
        </div>
      </b-col>
    </b-row>
    <br />
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
      <b-col class="card"> </b-col>
    </b-row>
  </b-container>
</template>
<style lang="scss" scoped>
.card {
  @include card;
}
</style>
