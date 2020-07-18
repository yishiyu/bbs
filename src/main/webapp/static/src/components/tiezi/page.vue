<template>
  <div>
    <page_header></page_header>
    <b-container>
      <navigator></navigator>
      <floor
        v-for="(item, index) in items"
        :content="item"
        :key="index"
      ></floor>
    </b-container>
    <page_footer></page_footer>
  </div>
</template>
<script>
import page_header from "../common/Header.vue";
import page_footer from "../common/Footer";
import navigator from "../common/breadcrumb";
import floor from "./floor";

export default {
  data() {
    return {
      floors_num: "10",
      items: [
        {
          user: "ttt",
          text: "testtesttest"
        },
        {
          user: "ttt",
          text: "testtesttest"
        },
        {
          user: "ttt",
          text: "testtesttest"
        },
        {
          user: "ttt",
          text: "testtesttest"
        }
      ]
    };
  },
  components: {
    page_header,
    page_footer,
    floor,
    navigator
  }
};
</script>
<style></style>
