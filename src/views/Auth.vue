<script setup>
import {ref} from 'vue'
import axios from 'axios'
import {ElMessage} from "element-plus";

const formdata = ref({})
const mode = ref(0)
const login = () => {
  axios.post(`http://127.0.0.1:8888/auth/login?username=${formdata.value.username}&password=${formdata.value.password}`).then(resp => {
    console.log(resp)
    ElMessage.closeAll('success')
    ElMessage.success({
      message: resp.data.msg
    })
  })
}

const register = ()=>{
  axios.post('http://127.0.0.1:8888/auth/register',formdata.value).then(resp=>{
    ElMessage.success(resp.data.msg)
  })
}
</script>

<template>
  <div class="authcontainer">
    <div class="form-container" v-show="mode === 0">
      <div class="title">登录</div>
      <el-form-item>
        <el-input v-model="formdata.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="formdata.password" type="password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width: 48%" @click="login">登录</el-button>
        <el-button type="primary" style="width: 48%" @click="mode = 1">注册</el-button>
      </el-form-item>
    </div>
    <div class="form-container" v-show="mode === 1">
      <div class="title">注册</div>
      <el-form-item>
        <el-input v-model="formdata.userName" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="formdata.password" type="password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="formdata.email" placeholder="请输入邮箱"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width: 100%" @click="register">注册</el-button>
      </el-form-item>
    </div>
  </div>
</template>

<style scoped lang="scss">
.authcontainer {
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #f2f3f5;

  .form-container {
    width: 25rem;
    padding: 1rem;
    box-shadow: 0 0 20px rgba(0 0 0 / .2);
    border-radius: 8px;
    background: #FFF;

    .title {
      text-align: center;
      font-weight: 800;
      font-size: 1.2rem;
      margin-bottom: 1rem;
    }
  }
}
</style>