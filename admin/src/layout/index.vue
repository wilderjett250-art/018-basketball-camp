<script setup lang="ts" name="Layout">
import { Key } from '@/stores/auth';
import { Session } from '@/utils/storage';
import request from "@/utils/request";
import {GetUsersToken} from '@/api/auth'
import { useSocketStore } from '@/stores/socketStore';
   import { defineAsyncComponent,provide,reactive, toRefs,onMounted ,nextTick } from 'vue';
   const LayoutAside=defineAsyncComponent(()=>import('./layoutAside/index.vue'));
   const LayoutHeader=defineAsyncComponent(()=>import('./layoutHeader/index.vue'));
   const LayoutMain=defineAsyncComponent(()=>import('./layoutMain/index.vue'));
   const state=reactive({
      users:{
        type:0,
        img:'',
        uname:'',
        id:0
      }
   })

   const {users} ={...toRefs(state)};


   onMounted(()=>{
   })


const tableName = Session.get("tableName");
const socketStore = useSocketStore();
if (tableName && !['null', 'undefined'].includes(String(tableName))) {
  request({
      url: `${tableName}/session`,
      method: 'POST'
  }).then(resp => {
      const user = resp.data || {};
      const userType = Number(user.type);
      const normalizedUser = {
          ...state.users,
          ...user,
          type: Number.isFinite(userType) ? userType : 0,
          img: user.img || user.touxiang || '',
          uname: user.uname || user.nicheng || user.username || ''
      };
      localStorage.setItem('user', JSON.stringify(normalizedUser));
      state.users = normalizedUser;
      const nickname = normalizedUser.uname || '管理员';
      const role = user.role || user.type;
      if (normalizedUser.id && role) {
          socketStore.initializeSocket(normalizedUser.id, nickname, role);
      }
      Session.set(Key.userInfoKey, normalizedUser);
  })
}

</script>

<template>

      <el-container class="layout-container">

        <LayoutAside :type="users.type"></LayoutAside>


      <el-container direction="vertical">
          <LayoutHeader :id="users.id" :img="users.img" :uname="users.uname"></LayoutHeader>
          <LayoutMain></LayoutMain>
      </el-container>
    </el-container>

</template>

<style>

</style>
