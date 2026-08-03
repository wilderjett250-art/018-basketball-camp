
<template>
  <div class="login-bg min-h-screen w-full flex flex-col justify-center items-center relative">
    <div class="login-bg-img absolute inset-0" :style="{ backgroundImage: `url('${serviceUrl}/upload/1768881258722.jpg')` }"></div>
    <div class="login-bg-mask absolute inset-0"></div>
    <div class="login-container relative z-10 flex flex-col items-center w-full">
      <div class="login-card-new">
        <div class="login-title-new">🏀 篮球训练营管理系统</div>
        <div class="login-subtitle">Basketball Training Camp</div>
        <form class="login-form-new">
          <div class="form-item college-register-section">
                        
                        <button @click="register('xunlianrenyuan')" type="button" class="register-btn-new">
              注册训练人员
            </button>
                      </div>
          <div class="form-item">
            <input
              v-model="loginData.username"
              type="text"
              class="input-new"
              placeholder="账号"
            />
          </div>
          <div class="form-item">
            <input
              v-model="loginData.password"
              :type="showPassword ? 'text' : 'password'"
              class="input-new"
              placeholder="密码"
              autocomplete="current-password"
            />
          </div>
          <div class="form-item flex-row">
            <input
              v-model="captcha"
              type="text"
              class="input-new flex-1"
              placeholder="验证码"
              maxlength="4"
            />
            <div
              @click="generateVerificationCode"
              class="captcha-box-new"
            >
              {{ verificationCode }}
            </div>
          </div>
          <div class="form-item role-select-row">
            <span v-for="item in menus" :key="item.roleName">
              <label class="role-radio-label" v-if="item.roleName!='游客'  &&item.roleName!='用户'">
                <input
                  type="radio"
                  :value="item.roleName"
                  v-model="loginData.role"
                  class="role-radio-input"
                />
                <span class="role-radio-custom" :class="loginData.role === `${item.roleName}` ? 'checked' : ''"></span>
                <span class="role-radio-text">{{item.roleName}}</span>
              </label>
            </span>
          </div>
          <div class="form-item form-remember">
            <label class="remember-label">
              <input type="checkbox" v-model="rememberMe" />
              记住密码
            </label>
          </div>
          <button type="button" @click="handleLogin" class="login-btn-new">
            登录
          </button>
          <div class="forgot-password">忘记密码？</div>
        </form>
      </div>
      <div class="login-footer mt-10 text-white text-sm opacity-90">
        © 2025 篮球训练营管理系统 | 专业·专注·卓越
    </div>
    <Register ref="RegisterRef"></Register>
  </div>
</div>
</template>
<script lang="ts" setup>
  import { ref, reactive, toRefs,defineAsyncComponent,onMounted } from 'vue';
  import { isUsername, isPassword } from '@/utils/validate';
  import { useAuthStore } from '@/stores/auth';
  import { useRouter, useRoute } from 'vue-router';
  import { Session } from '@/utils/storage';
  import type { FormRules } from 'element-plus/es/components/form/src/types';
  import menu from "@/utils/menu";
  const Register=defineAsyncComponent(()=>import('@/views/login/register.vue'));
  const authStore = useAuthStore();
  const serviceUrl = (import.meta.env.VITE_APP_SERVICE_URL || '/springbootgslq').replace(/\/+$/, '');

  const router = useRouter();
  const route = useRoute();

  const formRef = ref();

  const state = reactive({
    loading: false,
    registerloading:false,
    loginData: {
      username: '',
      password: '',
      role:''
    } as LoginData,
    tableName:''
  });

  const menus = menu.list();

  const { loading, loginData,tableName } = {...toRefs(state)};
  const RegisterRef=ref();
  const rememberMe = ref(false);
  function  register(tableName: string) {
    RegisterRef.value.open(tableName);
  }
  import {notify,confirm} from '@/utils/element';

import bgg from '@/assets/bg0.png';
const bgUrl = bgg;
  const captcha = ref('');
  const verificationCode = ref('');

  const generateVerificationCode = () => {
    const characters = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    let code = '';
    for (let i = 0; i < 4; i++) {
      code += characters[Math.floor(Math.random() * characters.length)];
    }
    verificationCode.value = code;
  };

  onMounted(() => {
    generateVerificationCode();
  });
  const username = ref('');
  const password = ref('');
  const showPassword = ref(false);
  const selectedRole = ref('管理员');
  const togglePassword = () => {
    showPassword.value = !showPassword.value;
  };
  const handleLogin =async () => {

    if (!state.loginData.username || !state.loginData.password) {
      notify("账号密码不能为空",{type:"error"})
      return;
    }
    if (captcha.value.toUpperCase() !== verificationCode.value) {
      notify("验证码错误",{type:"error"})
      return;
    }


    console.log(state.loginData);

    for (let i = 0; i < menus.length; i++) {
      if (menus[i].roleName == loginData.value.role) {
        state.tableName = menus[i].tableName;
      }
    }


    state.loading = true;


    //     // 登录中


    // 触发action，发送登录请求
    const res = await authStore.userLogin(state.loginData,`${state.tableName}/login`);
    // console.log('submitForm', res);
    // 跳转到来源地址  login?redirect=/home
    Session.set("tableName",state.tableName);
    Session.set("role", state.loginData.role);
    Session.set("adminName", state.loginData.username);
    router.replace({path: <string>route.query?.redirect || '/'});

    // 处理登录逻辑
    // console.log({
    //   username: username.value,
    //   password: password.value,
    //   role: selectedRole.value,
    //   captcha: captcha.value
    // });
  };
</script>
<style scoped>
.login-bg {
  min-height: 100vh;
  width: 100vw;
  position: relative;
  overflow: hidden;
}
.login-bg-img {
  background-size: cover;
  background-position: center;
  position: absolute;
  inset: 0;
  z-index: 0;
}
.login-bg-mask {
  position: absolute;
  inset: 0;
  background: rgba(0, 0, 0, 0.5);
  z-index: 1;
}
.login-container {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
  z-index: 2;
}
.login-card-new {
  background: rgba(255, 255, 255, 0.85);
  backdrop-filter: blur(15px);
  border-radius: 25px;
  box-shadow: 0 25px 50px rgba(0, 0, 0, 0.15);
  padding: 60px 50px 50px 50px;
  width: 500px;
  max-width: 90vw;
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 2px solid rgba(255, 255, 255, 0.3);
}
.login-title-new {
  font-size: 2.2rem;
  font-weight: 800;
  color: #ff6b35;
  margin-bottom: 10px;
  letter-spacing: 1px;
  text-align: center;
  font-family: 'Microsoft YaHei', Arial, sans-serif;
  text-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
.login-subtitle {
  font-size: 1rem;
  font-weight: 500;
  color: #666;
  margin-bottom: 30px;
  text-align: center;
  letter-spacing: 1px;
  text-transform: uppercase;
}
.login-form-new {
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 25px;
}
.form-item {
  width: 100%;
  display: flex;
  flex-direction: column;
}
.form-item.flex-row {
  flex-direction: row;
  align-items: center;
  gap: 15px;
}
.input-new {
  width: 100%;
  height: 55px;
  border-radius: 15px;
  border: 2px solid #e0e0e0;
  background: rgba(255, 255, 255, 0.8);
  font-size: 1.1rem;
  padding: 0 25px;
  outline: none;
  transition: all 0.3s ease;
  box-shadow: 0 3px 10px rgba(0, 0, 0, 0.08);
}
.input-new:focus {
  border-color: #ff6b35;
  box-shadow: 0 5px 15px rgba(255, 107, 53, 0.2);
  transform: translateY(-2px);
}
.captcha-box-new {
  width: 110px;
  height: 55px;
  background: linear-gradient(135deg, #ff6b35, #ff8c42);
  border: none;
  border-radius: 15px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-family: 'Consolas', 'Menlo', 'Monaco', monospace;
  font-size: 1.3rem;
  font-weight: 700;
  letter-spacing: 5px;
  color: white;
  cursor: pointer;
  user-select: none;
  margin-left: 10px;
  box-shadow: 0 5px 15px rgba(255, 107, 53, 0.3);
  transition: all 0.3s ease;
}
.captcha-box-new:hover {
  transform: translateY(-3px);
  box-shadow: 0 8px 20px rgba(255, 107, 53, 0.4);
}
.form-remember {
  display: flex;
  align-items: center;
  justify-content: flex-start;
  margin-bottom: -5px;
  margin-top: -5px;
}
.remember-label {
  font-size: 16px;
  color: #555;
  display: flex;
  align-items: center;
  gap: 10px;
  cursor: pointer;
  font-weight: 500;
}
.remember-label input[type="checkbox"] {
  width: 20px;
  height: 20px;
  border: 2px solid #ff6b35;
  border-radius: 6px;
  cursor: pointer;
  accent-color: #ff6b35;
}
.login-btn-new {
  width: 100%;
  background: linear-gradient(135deg, #ff6b35, #ff8c42);
  color: white;
  padding: 18px 0;
  border-radius: 15px;
  font-size: 1.2rem;
  font-weight: 700;
  letter-spacing: 2px;
  border: none;
  margin-top: 10px;
  margin-bottom: 10px;
  box-shadow: 0 8px 20px rgba(255, 107, 53, 0.3);
  transition: all 0.3s ease;
  cursor: pointer;
  text-transform: uppercase;
}
.login-btn-new:hover {
  transform: translateY(-3px);
  box-shadow: 0 12px 25px rgba(255, 107, 53, 0.4);
  background: linear-gradient(135deg, #e65a2b, #ff7a32);
}
.forgot-password {
  width: 100%;
  text-align: center;
  color: #ff6b35;
  font-size: 16px;
  margin-top: 5px;
  margin-bottom: 5px;
  cursor: pointer;
  transition: color 0.3s ease;
  font-weight: 500;
  text-decoration: underline;
}
.forgot-password:hover {
  color: #ff8c42;
}
.login-footer {
  margin-top: 3rem;
  color: rgba(255, 255, 255, 0.9);
  text-align: center;
  font-size: 1rem;
  opacity: 0.9;
  font-family: 'Poppins', 'Microsoft YaHei', Arial, sans-serif;
}
.role-select-row {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  gap: 35px;
  justify-content: center;
  align-items: center;
  margin-bottom: 5px;
  margin-top: 5px;
}
.role-radio-label {
  display: flex;
  align-items: center;
  cursor: pointer;
  gap: 10px;
  font-size: 16px;
  color: #555;
  transition: color 0.3s ease;
  font-weight: 500;
}
.role-radio-label:hover {
  color: #ff6b35;
}
.role-radio-input {
  display: none;
}
.role-radio-custom {
  width: 22px;
  height: 22px;
  border: 3px solid #e0e0e0;
  border-radius: 50%;
  display: inline-block;
  position: relative;
  background: #fff;
  margin-right: 3px;
  transition: all 0.3s ease;
}
.role-radio-custom.checked {
  border-color: #ff6b35;
  background: #ff6b35;
}
.role-radio-custom.checked::after {
  content: '';
  display: block;
  width: 8px;
  height: 8px;
  background: white;
  border-radius: 50%;
  position: absolute;
  top: 5px;
  left: 5px;
}
.role-radio-text {
  font-size: 16px;
  color: #555;
  transition: color 0.3s ease;
  font-weight: 500;
}
.role-radio-label:hover .role-radio-text {
  color: #5b4b8a;
}
.register-btn-new {
  width: 48%;
  background: rgba(255, 255, 255, 0.8);
  color: #5b4b8a;
  border: 3px solid #5b4b8a;
  font-size: 1.1rem;
  font-weight: 700;
  border-radius: 15px;
  padding: 16px 0;
  margin: 0 1%;
  transition: all 0.3s ease;
  box-shadow: 0 5px 15px rgba(91, 75, 138, 0.1);
  cursor: pointer;
  text-transform: uppercase;
  letter-spacing: 1px;
}
.register-btn-new:hover {
  background: #5b4b8a;
  color: white;
  transform: translateY(-3px);
  box-shadow: 0 8px 20px rgba(91, 75, 138, 0.3);
}
.college-register-section {
  display: flex;
  flex-direction: row;
  gap: 20px;
  justify-content: space-between;
  align-items: center;
  margin-top: 0px;
  margin-bottom: 25px;
  width: 100%;
}
</style>




