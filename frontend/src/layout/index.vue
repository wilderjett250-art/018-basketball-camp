<script setup lang="ts">
     import {ref,reactive,onMounted,defineAsyncComponent,toRefs,watch} from 'vue';
     import { useRoute } from 'vue-router';
     const Header=defineAsyncComponent(()=>import('@/layout/header.vue'));
     const LunBo=defineAsyncComponent(()=>import('@/layout/lunbo.vue'));
     const Footer=defineAsyncComponent(()=>import('@/layout/footer.vue'));
      import { useAuthStore,Key } from '@/stores/auth';
      import { Session, Local } from '@/utils/storage';
      import {GetUsersToken} from '@/api/auth'
     import request from "@/utils/request";
                    const authstore=useAuthStore();
  // console.log();


   const state=reactive({
      users:{
        type:0,
        img:'',
        uname:'',
        id:0
      }
   })

   const {users} ={...toRefs(state)};

     const route = useRoute();
     const lunboVisible = ref(true);

      const tableName = Session.get("tableName");
      const hasSession = tableName && !['null', 'undefined'].includes(String(tableName));
      if (hasSession) {
        request({
          url: `${tableName}/session`,
          method: 'POST'
        }).then(resp => {
          localStorage.setItem('user', JSON.stringify(resp.data));
          state.users = resp.data;
                            Session.set(Key.userInfoKey, resp.data);
        });
      }

     // 使用 watch 监听路由变化
     watch(
         () => route.path,
         (newPath) => {
           // 根据新路径设置 lunboVisible 的值
           if (newPath === '/sixin') {
             lunboVisible.value = false;
           } else {
             lunboVisible.value = true;
           }
         },
         { immediate: true } // ����ִ��һ�λص������ó�ʼֵ
     );

     onMounted(()=>{
     })



</script>

<template>
  <div class="min-h-screen">
  <Header></Header>

  <LunBo v-if="lunboVisible"/>
  <router-view></router-view>

  <Footer></Footer>
  </div>
    
</template>

<style>
 .el-footer {
                line-height: 48px;
                font-size: 14px;
                color: rgba(0, 0, 0, 0.5);
                text-align: center;
                overflow: hidden;
                user-select: none;
            }
</style>
