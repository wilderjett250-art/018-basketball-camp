<script setup lang="ts" name="LayoutVerticalMenu">
import {useRoute,useRouter} from 'vue-router'
import {useLayoutConfigStore} from '@/stores/layoutConfig'
import { toRaw } from "@vue/reactivity";
import { storeToRefs } from 'pinia';
import menu from '@/utils/menu'
import { Session } from '@/utils/storage';
import { reactive,toRefs,ref } from 'vue';
const route=useRoute();
const router = useRouter();
const layoutConfig=useLayoutConfigStore();
const {isCollapse}=storeToRefs(layoutConfig);
//  console.log('isCollapse',isCollapse.value);

const props= defineProps<{
  type:number
}>();


const state=reactive({
  menuList: [],
  dynamicMenuRoutes: [],
  role: '',
  icon:[
    'ele-Calendar',
    'ele-Box',
    'ele-Money',
    'ele-Refrigerator',
    'ele-Cpu',
    'ele-Football',
    'ele-Brush',
    'ele-Suitcase',
    'ele-Monitor',
    'ele-BrushFilled',
    'ele-DataBoard',
    'ele-DataLine',
    'ele-Reading',
    'ele-FirstAidKit',
    'ele-ScaleToOriginal',
    'ele-ShoppingTrolley',
    'ele-Timer',
    'ele-Sunset',
    'ele-SwitchFilled',
    'ele-Dish',
    'ele-Dessert',
    'ele-Burger',
    'ele-GobletSquare',
    'ele-Cherry',

  ]
})

const { menuList,dynamicMenuRoutes,role,icon} = {...toRefs(state)};
const menus = menu.list()
state.menuList = toRaw(menus);
console.log("菜单",state.menuList);

state.role = Session.get('role')
function menuHandler(name:any) {
  // console.log("跳转页面:"+name);

  name = '/'+name
  router.push(name)
}


const showUserMenu = ref(false);
const submenuOpen = ref({
  pets: true,
  appointments: false
});

const toggleSubmenu = (menu: string) => {
  submenuOpen.value[menu as keyof typeof submenuOpen.value] = !submenuOpen.value[menu as keyof typeof submenuOpen.value];
};
</script>

<template>


  <!-- 左侧菜单 -->
  <aside class="fixed left-0 top-16 bottom-0 w-56 bg-white text-gray-900 overflow-y-auto handwrite-font">

    <nav  v-for="(item,index) in menuList" :key="item.roleName">

  <span v-if="role==item.roleName">
  <a  style="cursor:pointer" @click="menuHandler(`home`)" class="flex items-center px-6 py-3 hover:bg-gray-800">
<i class="fas fa-home mr-3"></i>
<span>首页</span>
</a>
<a  style="cursor:pointer" @click="menuHandler(`center`)" class="flex items-center px-6 py-3 hover:bg-gray-800">
<i class="fas fa-user mr-3"></i>
<span>个人信息</span>
</a>
<a  style="cursor:pointer" @click="menuHandler(`updatePassword`)" class="flex items-center px-6 py-3 hover:bg-gray-800">
<i class="fas fa-cog mr-3"></i>
<span>修改密码</span>
</a>
<span v-for=" (menu,index) in item.backMenu" :key="menu.menu">
<span>
<a style="cursor:pointer" v-for=" (child,sort) in menu.child" :key="sort" @click="menuHandler(child.tableName)" class="flex items-center px-6 py-3 hover:bg-gray-800">
<!-- <i class="fas far fa-badge"></i> -->
 <i class="mr-3">
 <SvgIcon :name="icon[index]" />

</i>
<span>{{ child.menu }}</span>
</a>
</span>
</span>
    <!-- <div>
    <div class="flex items-center px-6 py-3 cursor-pointer" @click="toggleSubmenu(menu.menu)">
    <i class="fas fa-dog mr-3"></i>
    <span>{{ menu.menu }}</span>
    <i :class="['fas', 'ml-auto', submenuOpen.pets ? 'fa-angle-down' : 'fa-angle-right']"></i>
    </div> -->
    <!-- <div v-show="submenuOpen.pets" class="bg-gray-800">
    <a  style="cursor:pointer" v-for=" (child,sort) in menu.child" :key="sort" @click="menuHandler(child.tableName)" class="block px-12 py-2 hover:bg-gray-700">{{ child.menu }}</a>

    </div> -->
    <!-- </div> -->


</span>
    </nav>
  </aside>

  <!-- <el-scrollbar>


    <el-col v-for="(item,index) in menuList" :key="item.roleName">
    <div v-if="role==item.roleName">
<el-menu
        router
        :default-active="route.path"
        background-color="transparent"
        :default-openeds="['/system']"
        :collapse="isCollapse"
      >
        <el-menu-item index="/home">
          <SvgIcon name="ele-HomeFilled" />
          <span>首页</span>
        </el-menu-item>
        <el-sub-menu :index="9">
          <template #title>
            <SvgIcon name="ele-User" />
            <span>个人信息</span>
          </template>

          <el-menu-item @click="menuHandler('center')">个人信息</el-menu-item>
        </el-sub-menu>
        <el-sub-menu :index="10">
          <template #title>
            <SvgIcon name="ele-User" />
            <span>修改密码</span>
          </template>

          <el-menu-item @click="menuHandler('updatePassword')">修改密码</el-menu-item>
        </el-sub-menu>

        <el-sub-menu v-for=" (menu,index) in item.backMenu" :key="menu.menu" :index="index+3+''">
          <template #title>
            <SvgIcon name="ele-User" />
            <span>{{ menu.menu }}</span>
          </template>

          <el-menu-item v-for=" (child,sort) in menu.child" :key="sort" @click="menuHandler(child.tableName)">{{ child.menu }}</el-menu-item>

        </el-sub-menu>













      </el-menu>
    </div>
    </el-col>

    </el-scrollbar> -->
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Zhi+Mang+Xing&display=swap');

.handwrite-font, .handwrite-font * {
  font-family: 'Zhi Mang Xing', cursive !important;
}
.menu-item {
  transition: all 0.3s;
}
input[type="number"]::-webkit-inner-spin-button,
input[type="number"]::-webkit-outer-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
/* 侧边栏菜单项鼠标悬停淡紫色 */
aside .flex.items-center:hover {
  background: linear-gradient(135deg, #f0f0ff, #e6e6fa) !important;
  color: #5b4b8a !important;
  transform: translateX(5px);
  transition: all 0.3s ease;
  box-shadow: 0 2px 8px rgba(91, 75, 138, 0.2);
}

/* 侧边栏整体样式优化 */
aside {
  background: rgba(255, 255, 255, 0.95) !important;
  backdrop-filter: blur(10px);
  border-right: 1px solid rgba(91, 75, 138, 0.1);
}

/* 菜单项基础样式 */
aside .flex.items-center {
  transition: all 0.3s ease;
  border-radius: 8px;
  margin: 2px 8px;
  font-size: 16px;
}

/* 菜单项文字样式 */
aside .flex.items-center span {
  font-size: 16px;
  font-weight: 500;
}
</style>