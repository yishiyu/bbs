<template>
  <b-row>
    <b-breadcrumb id="bread" :items="items"></b-breadcrumb>
  </b-row>
</template>
<script>
export default {
  data() {
    return {
      items: [
        {
          text: "home",
          to: "/"
        }
      ]
    };
  },
  mounted() {
    var s = this.$route.path.split("/");

    var that = this;

    var r = s.filter(function(s) {
      return s && s.trim(); // 注：IE9(不包含IE9)以下的版本没有trim()方法
    });
    r.forEach(function(e) {
      console.log(e);
      that.items.push({
        text: e,
        to: that.items[that.items.length - 1].to + e + "/"
      });
    });
    that.items[that.items.length - 1]["active"] = true;
  }
};
</script>
<style lang="scss" scoped>
#bread {
  padding: 0px;
  margin: 0px;
  background-color: $background-color;
}
</style>
