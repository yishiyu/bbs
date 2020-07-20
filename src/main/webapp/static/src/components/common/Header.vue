<template>
  <b-navbar :class="curr_class" toggleable="lg" type="light" :sticky="true">
    <b-navbar-brand href="/">gittub</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item to="/aboutus">关于俺们</b-nav-item>
      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <b-nav-form>
          <label class="mr-sm-2" for="inline-form-custom-select-pref"
            >搜索分区</label
          >
          <b-form-select
            class="mr-sm-2 p-3 mb-0"
            :value="null"
            :options="{ '1': 'One', '2': 'Two', '3': 'Three' }"
            id="inline-form-custom-select-pref"
          ></b-form-select>
          <b-form-input
            size="md    "
            class="mr-sm-2"
            placeholder="Search"
          ></b-form-input>
          <b-button size="sm" class="my-2 my-sm-0" type="submit"
            >Search</b-button
          >
        </b-nav-form>

        <b-nav-item-dropdown right>
          <!-- Using 'button-content' slot -->
          <template v-slot:button-content>
            <em>我</em>
          </template>
          <b-dropdown-item v-if="logged" :to="userhome">用户</b-dropdown-item>
          <b-dropdown-item v-if="logged" @click="exit">登出</b-dropdown-item>
          <b-dropdown-item v-if="unlogged" to="/signin">注册</b-dropdown-item>
          <b-dropdown-item v-if="unlogged" to="/login">登录</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</template>
<script>
import { getAllBlocks } from "../../apis/api";
export default {
  data() {
    return {
      curr_class: "up",
      blocks: []
    };
  },
  methods: {
    search: function() {},
    handleScroll() {
      if (this.$store.getters.getScroll > 50) {
        this.curr_class = "down shadow";
      } else {
        this.curr_class = "up";
      }
    },
    exit() {}
  },
  computed: {
    options() {
      var res = [];
      for (var i = 0; i < this.blocks.length; i++) {
        res.push({ value: this.blocks[i].id, text: this.blocks[i].name });
      }
      return res;
    },
    logged() {
      return this.$store.getters.getLogState;
    },
    unlogged() {
      return !this.logged;
    },
    userhome() {
      return "/userHome/" + this.$store.getters.getId;
    }
  },
  mounted() {
    window.addEventListener("scroll", this.handleScroll);
    getAllBlocks().then(res => {
      for (var i = 0; i < res.data.length; i++) {
        this.blocks.push({
          value: res.data[i].blockName,
          text: res.data[i].blockName
        });
      }
    });
  }
};
</script>
<style lang="scss" scoped>
@media (max-width: 768px) {
  .up {
    background-color: $main-color !important;
  }
}
.up {
  background-color: initial;
}
.down {
  background-color: $main-color;
}
</style>
