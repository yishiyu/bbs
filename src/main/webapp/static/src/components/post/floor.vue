<template>
  <b-row id="floor">
    <!--楼层用户信息-->
    <b-col md="2" id="user">
      <div style="text-align: left;">
        <img src="http://gittub.cc/small2.png" alt="" />
      </div>
    </b-col>
    <b-col md="10" id="content">
      <div>
        <p>{{ content.text }}</p>
      </div>
    </b-col>
  </b-row>
</template>
<script>
export default {
  props: {
    content: {
      type: Object,
      default: () => {}
    }
  }
};
</script>
<style lang="scss" scoped>
#user {
  border: 0.5px solid gray;
  background-color: bisque;
  min-height: 100px;
  & img {
    height: 5rem;
    width: 5rem;
  }
}

#content {
  border-bottom: 0.5px solid grey;
}
@media (max-width: 768px) {
  #user img {
    height: 16px;
    width: 16px;
  }
}
.col {
  border: 1px solid;
}
</style>
