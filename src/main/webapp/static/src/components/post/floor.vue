<template>
  <b-row>
    <b-col>
      <div class="comment">
        <b-row>
          <b-col md="7">
            <div class="userBox">
              <img src="../../assets/logo.png" class="icon" alt="" />
              {{ content.userName }}
            </div>
          </b-col>
          <b-col md="5">
            {{ content.time }}
          </b-col>
        </b-row>
        <b-row class="textBox">
          <p>
            {{ content.comment }}
          </p>
        </b-row>
      </div>
    </b-col>
  </b-row>
</template>
<script>
export default {
  props: {
    content: {
      type: Object,
      default: () => {
        return {
          userName: "test",
          time: "2020.7.20",
          iconUrl: "../../assets/logo.png",
          comment: "这是一条评论"
        };
      }
    }
  }
};
</script>
<style lang="scss" scoped>
.comment {
  margin: 10px;
  border-bottom: 1px lightgray ridge;
  .userBox {
    float: left;

    .icon {
      height: 50px;
      width: 50px;
      border-radius: 50%;
    }
  }
}
</style>
