<template>
<div>
    <div style="width: 400px;margin: 200px auto">
      <h2 style="text-align: center;margin-bottom: 30px">登 录</h2>
      <el-form :model="user" :rules="rules" ref="ruleFormRef" size="large">
        <el-form-item prop="username">
            <el-input v-model="user.username" :prefix-icon="User"/>
        </el-form-item>
        <el-form-item prop="password">
            <el-input v-model="user.password" :prefix-icon="Lock" show-password/>
        </el-form-item>
        <el-form-item >
          <el-button type="primary" style="width:100%" @click="login">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
</div>
</template>

<script setup>
import {ref, reactive, getCurrentInstance} from "vue";
import {User,Lock} from '@element-plus/icons-vue'
import {ElMessage, ElNotification} from "element-plus";
import request from "../request.js";

const { proxy } = getCurrentInstance()
const user = reactive({
   username:'',
   password:''
})
const rules = reactive({
     username: [
       {required: true,message:'请输入用户名',trigger:'blur'}
     ],
    password: [
       {required: true,message:'请输入密码',trigger:'blur'}
    ],

})
const changeUser = (name) => {
  user.name = name
}
const login = () => {
    proxy.$refs.ruleFormRef.validate( valid => {
        if (valid) {
           //往后台发请求
          request.post('/user/login').then( res => {
               if(res.code==='200'){
                  ElNotification({
                      type: 'success',
                       message: '登录成功'
                  })
               }else{
                 ElNotification({
                   type:'error',
                   message:'用户名或密码错误'
                 })
               }

          })
        } else{
            ElNotification({
              type:'error',
              message:'用户名或密码错误'
            })
        }
    })
}
</script>

<style scoped>

</style>