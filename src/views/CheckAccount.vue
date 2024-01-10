<script setup>
import {useRoute} from "vue-router";

import {ref, onMounted} from 'vue'
import axios from 'axios'
import {ElMessage} from "element-plus";

const route = useRoute();

const id = ref()
const result = ref()

onMounted(() => {
  id.value = route.query.id
  axios.get(`http://127.0.0.1:8888/auth/checkAccount/${id.value}`).then(resp=>{
    result.value = resp.data
    ElMessage.info({
      message: resp.data
    })
  })
})


</script>

<template>
  <div class="CA-container">
    <div class="box">
      <div class="text">邮箱验证</div>
      <div class="text">{{ result }}: {{ id }}</div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.CA-container{
  width: 100vw;
  height: 100vh;
  .box{
    width: 100%;
    height: 30%;
    background: #1e1f22;
    display: flex;
    align-items: center;
    flex-wrap: wrap;
    padding: 4rem 2rem;
    .text{
      color: #FFF;
      font-size: 1.6rem;
      width: 100%;
    }
  }
}
</style>