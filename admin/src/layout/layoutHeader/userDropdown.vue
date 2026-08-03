<script setup lang="ts">
import { Key } from '@/stores/auth';
import { Session } from '@/utils/storage';
import { useFullscreen,useDark } from '@vueuse/core'
import {useLayoutConfigStore} from '@/stores/layoutConfig'
import {ref,inject} from 'vue';
import {useRouter} from 'vue-router'
import { storeToRefs } from 'pinia';
const layoutConfig=useLayoutConfigStore();
const {isCollapse,globalTitle}=storeToRefs(layoutConfig)
const val=ref(false);
const router=useRouter();
const LayoutConfigStore=useLayoutConfigStore();
  

//切换全屏模式->https://www.vueusejs.com/core/useFullscreen/  或者https://vueuse.org/core/useFullscreen/
const { isFullscreen,toggle:toggleFullscreen } = useFullscreen();
    

   async function handleToggleFullscreen(){
      await toggleFullscreen();
    //  console.log('isFullscreen',isFullscreen.value);
    LayoutConfigStore.isFullscreen=isFullscreen.value;
     
    }
   //返回值是boolean值，当前是否位暗黑模式，并且会将这个状态值保存到localstorege中
   //会自动监听isDark变化，来设置对应的主题模式
const isDark=useDark({
  valueDark:'auto',//暗黑时在html元素的class属性值
  valueLight:'',//高亮时在html元素的class属性值
  initialValue:'auto'//初始属性:auto(高亮模式)|dark
});

    function changeDark(val:boolean){
     // console.log('val',val);
      LayoutConfigStore.isDrak=val;
    }

   
   const props= defineProps<{
        id:number,
        img:string,
        uname:string
    }>();


    function tc(){
       Session.remove(Key.accessTokenKey);
       Session.remove(Key.userInfoKey);
       router.push("/login")
    }
const avatarUrl = 'https://ai-public.mastergo.com/ai/img_res/8a1e2c786bb03b4538d64309baaaa932.jpg';
const showUserMenu = ref(false);

const toggleUserMenu = () => {
  showUserMenu.value = !showUserMenu.value;
};
  
</script>

<template>
  <header class="fixed top-0 left-0 right-0 h-16 bg-white shadow-md z-50 flex items-center justify-between px-6">
    <div class="flex items-center">
      🏀
      <h1 class="text-xl font-medium">{{globalTitle}}</h1>
    </div>
    <div class="flex items-center">
      <img :src="avatarUrl" class="w-10 h-10 rounded-full cursor-pointer" @click="toggleUserMenu" />
      <div v-if="showUserMenu" class="absolute top-16 right-6 bg-white shadow-lg rounded-lg py-2 w-40">
        <a @click="router.push('/center')" class="block px-4 py-2 hover:bg-gray-100">个人信息</a>
        <a @click="tc" class="block px-4 py-2 hover:bg-gray-100">退出登录</a>
      </div>
    </div>
  </header>
<!--    <div class="layout-header-user">-->
<!--      &lt;!&ndash;全屏&ndash;&gt;-->
<!--        <div>-->
<!--            <SvgIcon name="ele-FullScreen" @click="handleToggleFullscreen"/>-->
<!--        </div>-->

<!--        &lt;!&ndash;切换主题&ndash;&gt;-->
<!--        <div class="layout-header-user-icon">-->
<!--          &lt;!&ndash;  style="&#45;&#45;el-switch-on-color: #333; " &ndash;&gt;-->
<!--          <el-switch -->
<!--                v-model="isDark"-->
<!--                @change="changeDark"-->
<!--                inline-prompt-->
<!--                style="&#45;&#45;el-switch-on-color: #333;"-->
<!--                active-icon="ele-Moon" inactive-icon="ele-Sunny"-->
<!--            />-->
<!--        </div>-->

<!--        &lt;!&ndash;下拉菜单&ndash;&gt;-->

<!--        <el-dropdown>-->
<!--            &lt;!&ndash; :src="circleUrl"&ndash;&gt;-->
<!--       <span class="user-dropdown-link ml5">-->
<!--        <el-avatar class="mr3" :size="30" icon="ele-UserFilled" :src="props.img?props.img:''"/>-->
<!--        {{ props.uname }}-->
<!--      <el-icon class="el-icon&#45;&#45;right">-->
<!--        <SvgIcon class="ml3" name="ele-ArrowDown"/>-->
<!--      </el-icon>-->
<!--    </span>-->
<!--    <template #dropdown>-->
<!--      <el-dropdown-menu>-->
<!--        <el-dropdown-item @click="router.push('/')">首页</el-dropdown-item>-->
<!--        <el-dropdown-item @click="router.push('/upusers')">个人信息</el-dropdown-item>-->
<!--        <el-dropdown-item divided @click="tc()">退出系统</el-dropdown-item>-->
<!--      </el-dropdown-menu>-->
<!--    </template>-->
<!--  </el-dropdown>-->
<!--    </div>-->
</template>

<style scoped></style>