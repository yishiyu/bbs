<template>
    <div>
        <nav_bar></nav_bar>
        <div id="loginBox">
            <b-form @submit="onSubmit" @reset="onReset" id="login">

                <b-form-group id="input-group-2" label="用户名:" label-for="input-2">
                    <b-form-input :state="validation_name" id="input-2" v-model="form.userName" required
                        placeholder="Enter name"></b-form-input>
                    <b-form-invalid-feedback :state="initial">
                        <p v-show="!initial">用户名未激活</p>
                    </b-form-invalid-feedback>
                    <b-form-invalid-feedback :state="validation_name_require">
                        <p v-show="!validation_name_require">用户名不为空</p>
                    </b-form-invalid-feedback>
                </b-form-group>
                <b-form-group label="密码:" label-for="input-3">
                    <b-form-input :state="validation_password" id="input-3" v-model="form.password" required
                        placeholder="Enter password"></b-form-input>
                    <b-form-invalid-feedback :state="auth">
                        <p v-show="!initial">密码错误</p>
                    </b-form-invalid-feedback>
                    <b-form-invalid-feedback :state="validation_password_require">
                        <p v-show="!validation_password_require">密码缺少</p>
                    </b-form-invalid-feedback>
                </b-form-group>


                <b-button style="margin: 5px;" type="submit" variant="primary">登录</b-button>

                <b-button style="margin: 5px;" type="reset" variant="danger">清除</b-button>
            </b-form>
        </div>
    </div>
</template>
<script>
    import nav_bar from "./header";
    export default {
        data() {
            return {
                initial: true,
                auth: true,
                form: {
                    userName: "",
                    password: ""
                }
            };
        },
        computed: {
            validation_name() {
                return this.initial && this.validation_name_require
            },
            validation_name_require() {
                return this.form.userName.length > 0
            },
            validation_password() {
                return this.auth && this.validation_password_require
            },
            validation_password_require() {
                return this.form.password.length > 0;
            }

        },
        components: {
            nav_bar
        },
        methods: {
            onSubmit(e) {
                e.preventDefault();

            },
            onReset(e) {
                e.preventDefault();
            }
        },
    };
</script>
<style lang="scss" scoped>
    #loginBox {
        @include log-container #login {
            @include card align-self: center;
            margin: 0 auto;
            width: 30%;
            text-align: left;
            padding: 30px;
            background-color: white;

        }
    }
</style>