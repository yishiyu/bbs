<template>
  <div>
    <nav_bar></nav_bar>
    <div id="signinBox">
      <b-form @submit="onSubmit" @reset="onReset" id="signin">
        <h2 style="text-align:center">注册</h2>
        <b-form-group
          id="input-group-1"
          label="email地址:"
          label-for="input-1"
          label-align-md="center"
          label-cols-lg="3"
        >
          <b-form-input
            :state="validation_email"
            id="input-1"
            v-model="form.email"
            placeholder="Enter email"
          >
          </b-form-input>
          <b-form-invalid-feedback v-if="alert" :state="validation_email">
            非法email地址
          </b-form-invalid-feedback>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="用户名:"
          label-for="input-2"
          label-align-md="center"
          label-cols-lg="3"
        >
          <b-form-input
            :state="validation_name"
            id="input-2"
            v-model="form.userName"
            placeholder="Enter name"
          ></b-form-input>
          <b-form-invalid-feedback v-if="alert" :state="validation_name">
            <p v-show="!validation_name_length">用户名为5位到12位</p>
            <p v-show="!isUsed">用过了</p>
          </b-form-invalid-feedback>
        </b-form-group>
        <b-form-group
          label="密码:"
          label-for="input-3"
          label-align-md="center"
          label-cols-lg="3"
        >
          <b-form-input
            :state="validation_password"
            id="input-3"
            v-model="form.password"
            placeholder="Enter password"
          ></b-form-input>
          <b-form-invalid-feedback v-if="alert" :state="validation_password">
            密码至少八位
          </b-form-invalid-feedback>
        </b-form-group>
        <img
          :src="checkurl"
          alt=""
          @click="change($event, this)"
          style="min-width:10px;min-height:10px"
        />
        <b-form-group
          label="验证码"
          label-for="input-4"
          label-align-md="center"
          label-cols-lg="5"
          class="flex-row"
        >
          <b-form-input
            id="input-4"
            v-model="form.check"
            placeholder="Enter verifacation code"
          >
          </b-form-input>
        </b-form-group>

        <b-button style="margin: 5px;" type="submit" variant="primary"
          >注册</b-button
        >

        <b-button style="margin: 5px;" type="reset" variant="danger"
          >清除</b-button
        >
      </b-form>
    </div>
  </div>
</template>
<script>
import nav_bar from "./header";
export default {
  data() {
    return {
      form: {
        userName: "",
        password: "",
        email: "",
        check: ""
      },
      alert: false,
      used: false,
      checkurl: ""
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      this.alert = true;
      console.log(1);
    },
    onReset(event) {
      event.preventDefault();
      this.password = "";
      this.userName = "";
      this.email = "";
    },
    change(e) {
      e.preventDefault();
      this.checkurl = "checkCode?" + new Date().getTime();
    }
  },
  mounted() {
    this.checkurl = "checkCode?" + new Date().getTime();
  },
  components: {
    nav_bar
  },
  computed: {
    //检查用户名，密码，邮件地址
    validation_name_length() {
      return this.form.userName.length > 4 && this.form.userName.length < 13;
    },
    validation_name() {
      if (!this.alert) return null;
      return !this.used && this.validation_name_length;
    },
    validation_email() {
      if (!this.alert) return null;
      var reg = new RegExp(
        "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"
      );
      return reg.test(this.form.email);
    },
    validation_password() {
      if (!this.alert) return null;
      return this.form.password.length > 7;
    },
    isUsed() {
      return !this.used;
    }
  }
};
</script>
<style lang="scss" scoped>
#signinBox {
  @include log-container;
  #signin {
    @include card;
    align-self: center;
    margin: 0 auto;
    width: 30%;
    text-align: left;
    padding: 30px;
    background-color: white;
  }
}
</style>
