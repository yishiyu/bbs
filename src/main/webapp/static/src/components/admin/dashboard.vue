<template>
    <div>
        <b-row>
            <b-col md="3">
                <router-link>
                    <div class="card">
                        <h1 style="color: aliceblue;width:100%">
                            {{postNum}}
                        </h1>
                        <p>
                            用户
                        </p>
                    </div>
                </router-link>
            </b-col>
            <b-col md="3">
                <div class="card"></div>
            </b-col>
            <b-col md="3">
                <div class="card"></div>
            </b-col>
            <b-col md="3">
                <div class="card"></div>
            </b-col>
        </b-row>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                postNum: 0,
                userNum: 0,
                blockNum: 0,
                visitNum: 10000
            }
        },
    };
</script>