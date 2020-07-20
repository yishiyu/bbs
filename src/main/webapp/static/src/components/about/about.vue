<template>
  <div>
    <nav_head></nav_head>
    <b-container>
      <b-row>
        <pre>



      关于我们
      本站是专为程序员以及互联网工作者所开发的论坛，我们致力于打造一个优秀的代码资源共享学习平台。
      本站历史：
       2020年7月 GitTub网站建成
       2020年7月 GitTub用户突破两位数
      坚守责任，以社会发展为己任
      当前，互联网发展极其快速。在这样的浪潮下，程序以及代码成为了能够推动社会发展必不可少的资源。我们建立这样的网站，是希望能够为我国互联网工作者建立一个自由，简单，易用的分享平台，推进我国互联网行业发展。
      以安全第一，保障用户个人隐私
      我们始终坚信保障用户隐私是所有服务的底线。因此我们使用强有力的方式对用户信息进行加密，保护用户个人隐私。同时我们也会尽量使用最少的用户数据服务用户，对于用户的浏览记录我们将不会进行任何方式的使用。
      愿景和使命 代码连接世界，科技描绘未来。
    </pre
        >
      </b-row>
    </b-container>
  </div>
</template>
<script>
import nav_head from "../common/Header";
export default {
  components: {
    nav_head
  }
};
</script>
<style lang="scss" scoped>
pre {
  @include article;
}
</style>
