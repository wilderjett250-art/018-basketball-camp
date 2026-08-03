<script setup lang="ts">
import {menu} from '@/utils/menu'
import { toRaw } from "@vue/reactivity";
import { Session } from '@/utils/storage';
import { ref,reactive,toRefs,defineAsyncComponent } from "vue";
import {GetUsersToken} from '@/api/auth'
   import {useRoute,useRouter} from 'vue-router'
   import { Key } from '@/stores/auth';
const Register=defineAsyncComponent(()=>import('@/views/register/index.vue'));
const Login=defineAsyncComponent(()=>import('@/views/login/index.vue'));

   const route=useRoute();
   const router = useRouter();
const state=reactive({
  menuList: [],
  role:"",
  user: {},
islogin:''
})
state.role = Session.get('role')
const { menuList,role,user,islogin} = {...toRefs(state)};
const menus = menu.list()
state.menuList = toRaw(menus);
   const storedTableName = Session.get('tableName');
   const hasValidTableName = storedTableName && !['null', 'undefined'].includes(String(storedTableName));
   if(Session.get(Key.isLoingKey)==null){
    state.islogin='0';
}else{
    state.islogin=Session.get(Key.isLoingKey);
}
console.log(state.menuList);

   function menuHandler(name:any) {
      name = '/'+name
      router.push(name)
    }

       if(state.islogin=='1' && hasValidTableName){
        getutoken();
    }


    async function getutoken(){
  try {
    const {data} = await GetUsersToken();
    state.user=data;
      } catch (error) {

     }

    }
    

const LoginRef=ref();
function dl(){
  LoginRef.value.showlogin();
}
const RegisterRef=ref();
function  register(tableName) {
  RegisterRef.value.open(tableName);
}

    function tc(){
       Session.remove(Key.accessTokenKey);
       Session.remove("tableName");
        Session.remove("role");
        Session.remove("adminName");
        Session.set(Key.isLoingKey,'0');
        state.islogin='0';
       router.push("/")
    }
</script>
<template>


  <nav class="bg-[#00a0e9] fixed w-full z-50 bg-gradient-to-r from-sky-400 to-blue-500">
    <div class="max-w-7xl mx-auto px-4 h-16 flex items-center justify-between">
      <div class="flex items-center space-x-16">
        <div class="text-white text-2xl font-bold relative">
<span class="relative inline-block">
篮球训练营
<div class="absolute -bottom-1 left-0 w-full h-0.5 bg-white/60"></div>
</span>
        </div>
        <div class="hidden md:flex items-center space-x-8"  v-if="islogin=='0'">
                    <div v-for="item in menuList" :key="item.roleName">

                      <p style="margin-left: 0;" v-if="'游客'==item.roleName">
                 <span style="cursor:pointer">
                   <a style="margin-right: 24px;" @click="menuHandler(`home`)" class="text-white hover:text-[#007BFF]">首页</a>
               </span>
                        <span  style="margin-right: 24px;" v-for="(menu,index1) in item.ykMenu" :key="index1">
                   <a style="cursor:pointer" v-for=" (child,sort) in menu.child" :key="sort" @click="menuHandler(child.tableName)" class="text-white hover:text-[#007BFF]">{{ menu.menu}}</a>
                        </span>
                      </p>
                    </div>

        </div>

        <div class="hidden md:flex items-center space-x-8"  v-if="islogin=='1'">
          <div v-for="item in menuList" :key="item.roleName">
          <p style="margin-left: 0;" v-if="role==item.roleName">
        <span style="cursor:pointer">
         <a style="margin-right: 24px;" @click="menuHandler(`home`)" class="text-white hover:text-[#007BFF]">首页</a>
      </span>
            <span  style="margin-right: 24px;" v-for="(menu,index1) in item.frontMenu" :key="index1">
           <a style="cursor:pointer" v-for=" (child,sort) in menu.child" :key="sort" @click="menuHandler(child.tableName)" class="text-white hover:text-[#007BFF]">{{ menu.menu}}</a>
          </span>
            <a style="cursor:pointer;" @click="menuHandler('grzx')" class="text-white hover:text-[#007BFF]">个人中心</a>
                                      </p>
        </div>



        </div>
      </div>
      <div class="flex items-center space-x-4">
        <button v-if="islogin=='0'" @click="dl()" class="!rounded-button text-white bg-gradient-to-r from-sky-500 to-blue-600 px-4 py-2 hover:from-sky-600 hover:to-blue-700 whitespace-nowrap shadow-lg">登录</button>
                      <button v-if="islogin=='0'" @click="register('yonghu')" class="!rounded-button text-sky-500 border border-sky-500 bg-white/90 px-4 py-2 hover:bg-sky-500 hover:text-white whitespace-nowrap shadow-lg">注册用户</button>
                  
                  <button v-if="islogin=='1'" @click="tc" class="!rounded-button text-rose-500 border border-rose-500 bg-white/90 px-4 py-2 hover:bg-rose-500 hover:text-white whitespace-nowrap shadow-lg">退出</button>
      </div>
    </div>
  </nav>


  <!-- 导航栏 -->





  <Register ref="RegisterRef" v-if="islogin=='0'"></Register>
  <Login ref="LoginRef" v-if="islogin=='0'"></Login>



</template>

<style scoped>

</style>
