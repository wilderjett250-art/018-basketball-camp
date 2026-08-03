<script setup lang="ts">
import request from "@/utils/request";
import {ref,onMounted,reactive,toRefs,nextTick} from 'vue';
import { Swiper, SwiperSlide } from 'swiper/vue';
import { Pagination, Autoplay } from 'swiper/modules';
const swiperModules = [Pagination, Autoplay];
const state=reactive({
  page:{
    current:1,//当前页码
    size:20,//每页显示多少条
    total:0,//总条数
  },
  tableList:[],
  loadding:false,
  query:{name:'',type:1}
});
const {page,tableList,loadding,query} = {...toRefs(state)};
onMounted(()=>{
  getpagelist();
})
async function getpagelist(){
  try {
    state.loadding=true;
    request({
      url:'config/list',
      method:'get'
    }).then((data)=>{
      state.tableList.length=0;
      state.tableList=data.data.list;
    })
    nextTick(()=>{})
  } catch (error) {

  }finally{
    state.loadding=false;
  }
}

</script>

<template>



  <div class="pt-16">
    <swiper :modules="swiperModules" :pagination="{ clickable: true }" :autoplay="{ delay: 5000 }" class="h-[500px]">
      <swiper-slide v-for="(slide, index) in tableList" :key="index">
        <div class="relative h-full">
          <img :src="slide.value" :alt="slide.name" class="w-full h-full object-cover object-top" />
          <div class="absolute bottom-0 left-0 right-0 bg-gradient-to-t from-black/70 to-transparent p-8">
            <h2 class="text-white text-3xl font-bold mb-2">{{ slide.name }}</h2>
          </div>
        </div>
      </swiper-slide>
    </swiper>
  </div>





</template>

<style lang="scss" scoped>
.swiper {
  width: 100%;
}
</style>