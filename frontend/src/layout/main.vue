<script setup lang='ts'>
    import { defineAsyncComponent,reactive,ref,toRefs,onMounted,onUnmounted } from 'vue';
    import { toRaw } from "@vue/reactivity";
    import { Key } from '@/stores/auth';
    import { Session } from '@/utils/storage';
    import request from "@/utils/request";
    import {notify} from '@/utils/element';
    import { isAuth } from '@/utils/utils'

    const serviceUrl = (import.meta.env.VITE_APP_SERVICE_URL || '/springbootgslq').replace(/\/+$/, '');
    const bannerUrl = `${serviceUrl}/upload/1768881263817.jpg`;

    // const indexlunbo=defineAsyncComponent(()=>import('@/layout/indexlunbo.vue'));
    // const indexwz=defineAsyncComponent(()=>import('@/layout/indexwz.vue'));
    // const indexleibiao=defineAsyncComponent(()=>import('@/layout/indexliebiao.vue'));


    const state=reactive({

                        xunlianyingxinxiList: [],
                        bisaiguanliList: [],
                        xunlianxiangmuList: [],
                                xunlianyingxinxirecommendList: [],
                             newsList:[],
                  username:'',
        user:{}
    })

    const {
                        xunlianyingxinxiList,
                        bisaiguanliList,
                        xunlianxiangmuList,
                                xunlianyingxinxirecommendList,
                          newsList,
                username,
        user

    } = {...toRefs(state)};

                getxunlianyingxinxi()
                getbisaiguanli()
                getxunlianxiangmu()
            getnews()
                function getnews(){
          const params={
            page: 0,
            limit: 8,
            sort: 'id',
          }
          request({
            url:'news/list',
            method:'get',
            params,
            suppressAuthError: true
          }).then((data)=>{
            state.newsList=data?.data?.list || [];
          })
        }

        

                function getxunlianyingxinxi(){
            const params={
                page: 0,
                limit: 6,
                sort: 'id',
            }


            request({
                url:'xunlianyingxinxi/list',
                method:'get',
                params,
                suppressAuthError: true
            }).then((data)=>{
                state.xunlianyingxinxiList=data?.data?.list || [];
        })
        }




                function getbisaiguanli(){
            const params={
                page: 0,
                limit: 6,
                sort: 'id',
            }


            request({
                url:'bisaiguanli/list',
                method:'get',
                params,
                suppressAuthError: true
            }).then((data)=>{
                state.bisaiguanliList=data?.data?.list || [];
        })
        }




                function getxunlianxiangmu(){
            const params={
                page: 0,
                limit: 6,
                sort: 'id',
            }


            request({
                url:'xunlianxiangmu/list',
                method:'get',
                params,
                suppressAuthError: true
            }).then((data)=>{
                state.xunlianxiangmuList=data?.data?.list || [];
        })
        }




        


    state.username=Session.get("adminName");
    const sessionTable = Session.get("tableName");
    const hasSession = state.username && sessionTable && !['null', 'undefined'].includes(String(sessionTable));
    if(hasSession){
        request({
            url: sessionTable + '/session',
            method: "get"
        }).then((data) => {
            if (data && data.code === 0) {
            state.user = data.data;

                            request({
                    url:'xunlianyingxinxi/recommendList',
                    method:'POST',
                    params:{
                        num: 6,
                        userId:data.data.id,
                    }
                }).then((data)=>{
                    state.xunlianyingxinxirecommendList=data.data;
            })

            

        } else {
            notify(data.msg,{type:'error'});
        }
    });
    } else {
        state.username = '';
    }


    import { Swiper, SwiperSlide } from 'swiper/vue';
    import { Pagination, Autoplay } from 'swiper/modules';
    const swiperModules = [Pagination, Autoplay];
    const showBackToTop = ref(false);
    const handleScroll = () => {
      showBackToTop.value = window.scrollY > 300;
    };
    const scrollToTop = () => {
      window.scrollTo({
        top: 0,
        behavior: 'smooth'
      });
    };
    onMounted(() => {
      window.addEventListener('scroll', handleScroll);
    });
    onUnmounted(() => {
      window.removeEventListener('scroll', handleScroll);
    });

    const features = [
      {
        icon: 'fas fa-info-circle',
        title: '关于我们',
        description: '专注篮球训练教育 10 年，始终致力于为学员提供专业的篮球训练服务'
      },
      {
        icon: 'fas fa-tasks',
        title: '成功案例',
        description: '已成功培训学员超过 5000 名，多名学员进入职业球队和重点高校'
      },
      {
        icon: 'fas fa-award',
        title: '荣誉资质',
        description: '荣获中国篮协认证训练基地，并多次获得青少年篮球培训优秀机构称号'
      }
    ];

</script>

<template>

  <div class="max-w-7xl mx-auto px-4 py-12">
    <div class="flex items-center gap-12">
      <div class="w-1/2">
        <img :src="bannerUrl"
             alt="关于我们"
             class="w-full h-[500px] object-cover rounded-xl shadow-lg" />
      </div>
      <div class="w-1/2">
        <h2 class="text-3xl font-bold mb-8 relative inline-block">
          关于我们
          <div class="absolute -bottom-2 left-0 w-full h-1 bg-blue-500"></div>
        </h2>
        <div class="space-y-8">
          <div v-for="(feature, index) in features"
               :key="index"
               class="bg-white/80 backdrop-blur-sm rounded-xl shadow-lg p-6 border border-sky-100 hover:border-sky-300 transition-all duration-300">
            <div class="flex items-start gap-4">
              <i :class="feature.icon" class="text-[#007BFF] text-2xl mt-1"></i>
              <div>
                <h3 class="text-xl font-bold mb-2">{{ feature.title }}</h3>
                <p class="text-gray-600">{{ feature.description }}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

          <!-- 新闻动态 -->
      <div class="py-20 bg-gray-50">
        <div class="max-w-7xl mx-auto px-4">
          <h2 class="text-3xl font-bold text-center mb-4">系统公告</h2>
          <p class="text-gray-600 text-center mb-12">了解最新的资讯和独家XXX</p>
          <div class="grid grid-cols-2 gap-8">



            <div class="bg-white rounded-xl shadow-lg overflow-hidden hover:shadow-xl transition-shadow duration-300"  v-for="(item, index) in newsList" :key="index">
              <div class="flex">
                <div class="w-1/3">
                  <img :src="item.picture" alt="" class="w-full h-full object-cover">
                </div>
                <div class="w-2/3 p-6">
                  <div class="flex items-center mb-3">
                    <span class="ml-3 text-gray-500 text-sm">{{item.addtime}}</span>
                  </div>
                  <h3 class="text-xl font-bold mb-3">{{item.title}}</h3>
                  <p class="text-gray-600 line-clamp-2">{{item.introduction}}</p>
                  <router-link :to="`/newsdetail/`+item.id">
                    <button class="mt-4 text-blue-600 hover:text-blue-700 flex items-center text-sm">
                      阅读更多 <i class="fas fa-arrow-right ml-2"></i>
                    </button>
                  </router-link>
                </div>
              </div>
            </div>




          </div>
        </div>
      </div>

    
  <div class="bg-gradient-to-b from-sky-50 to-white py-16">
    <div class="max-w-7xl mx-auto px-4 relative">
      <div class="absolute top-0 left-0 w-full h-full bg-[url('https://ai-public.mastergo.com/ai/img_res/4d98957383dd479f90644a811d299700.jpg')] opacity-10"></div>
      <h2 class="text-3xl font-bold text-center mb-12 relative">
<span class="relative inline-block">
训练营信息
<div class="absolute -bottom-2 left-0 w-full h-1 bg-blue-500"></div>
</span>
      </h2>
      <div class="grid grid-cols-3 gap-8">
        <div v-for="(item, index) in xunlianyingxinxiList" class="bg-white rounded-xl overflow-hidden shadow-lg">
          <div class="h-64 overflow-hidden">
            <span v-for="(value, key, ind) in item" :key="ind">
            <img v-if="ind==3" :src="value" alt="" class="w-full h-full object-cover object-top transition-transform hover:scale-110 duration-300" />
          </span>
          </div>

          <div class="p-6">
            <div class="flex items-center justify-between">
              <span v-for="(value, key, ind) in item" :key="ind">
                <h3 v-if="ind==2" class="text-xl font-bold">{{ value }}</h3>
              </span>
              <router-link :to="`/xunlianyingxinxidetail/`+item.id">
              <button class="!rounded-button bg-gradient-to-r from-sky-500 to-blue-600 text-white px-6 py-2 hover:from-sky-600 hover:to-blue-700 whitespace-nowrap shadow-lg transform hover:scale-105 transition-transform duration-300">查看详情</button>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

   <div class="bg-gradient-to-b from-sky-50 to-white py-16">
    <div class="max-w-7xl mx-auto px-4 relative">
      <div class="absolute top-0 left-0 w-full h-full bg-[url('https://ai-public.mastergo.com/ai/img_res/4d98957383dd479f90644a811d299700.jpg')] opacity-10"></div>
      <h2 class="text-3xl font-bold text-center mb-12 relative">
<span class="relative inline-block">
比赛管理
<div class="absolute -bottom-2 left-0 w-full h-1 bg-blue-500"></div>
</span>
      </h2>
      <div class="grid grid-cols-3 gap-8">
        <div v-for="(item, index) in bisaiguanliList" class="bg-white rounded-xl overflow-hidden shadow-lg">
          <div class="h-64 overflow-hidden">
            <span v-for="(value, key, ind) in item" :key="ind">
            <img v-if="ind==3" :src="value" alt="" class="w-full h-full object-cover object-top transition-transform hover:scale-110 duration-300" />
          </span>
          </div>

          <div class="p-6">
            <div class="flex items-center justify-between">
              <span v-for="(value, key, ind) in item" :key="ind">
                <h3 v-if="ind==2" class="text-xl font-bold">{{ value }}</h3>
              </span>
              <router-link :to="`/bisaiguanlidetail/`+item.id">
              <button class="!rounded-button bg-gradient-to-r from-sky-500 to-blue-600 text-white px-6 py-2 hover:from-sky-600 hover:to-blue-700 whitespace-nowrap shadow-lg transform hover:scale-105 transition-transform duration-300">查看详情</button>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

   <div class="bg-gradient-to-b from-sky-50 to-white py-16">
    <div class="max-w-7xl mx-auto px-4 relative">
      <div class="absolute top-0 left-0 w-full h-full bg-[url('https://ai-public.mastergo.com/ai/img_res/4d98957383dd479f90644a811d299700.jpg')] opacity-10"></div>
      <h2 class="text-3xl font-bold text-center mb-12 relative">
<span class="relative inline-block">
训练项目
<div class="absolute -bottom-2 left-0 w-full h-1 bg-blue-500"></div>
</span>
      </h2>
      <div class="grid grid-cols-3 gap-8">
        <div v-for="(item, index) in xunlianxiangmuList" class="bg-white rounded-xl overflow-hidden shadow-lg">
          <div class="h-64 overflow-hidden">
            <span v-for="(value, key, ind) in item" :key="ind">
            <img v-if="ind==3" :src="value" alt="" class="w-full h-full object-cover object-top transition-transform hover:scale-110 duration-300" />
          </span>
          </div>

          <div class="p-6">
            <div class="flex items-center justify-between">
              <span v-for="(value, key, ind) in item" :key="ind">
                <h3 v-if="ind==2" class="text-xl font-bold">{{ value }}</h3>
              </span>
              <router-link :to="`/xunlianxiangmudetail/`+item.id">
              <button class="!rounded-button bg-gradient-to-r from-sky-500 to-blue-600 text-white px-6 py-2 hover:from-sky-600 hover:to-blue-700 whitespace-nowrap shadow-lg transform hover:scale-105 transition-transform duration-300">查看详情</button>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

 

  <div class="py-16 bg-gradient-to-b from-white to-sky-50">
    <div class="max-w-7xl mx-auto px-4">
      <h2 class="text-3xl font-bold text-center mb-12 relative">
<span class="relative inline-block">
训练营信息推荐
<div class="absolute -bottom-2 left-0 w-full h-1 bg-blue-500"></div>
</span>
      </h2>
      <div class="grid grid-cols-4 gap-6">
        <div v-for="(trip, index) in xunlianyingxinxirecommendList" :key="index"
             class="bg-white rounded-xl overflow-hidden shadow-lg hover:shadow-xl transition-shadow duration-300 group">
          <div class="h-48 overflow-hidden">
            <span v-for="(value, key, ind) in trip" :key="ind">
            <img v-if="ind==3" :src="value" alt=""
                 class="w-full h-full object-cover object-top group-hover:scale-110 transition-transform duration-300" />
              </span>
          </div>
          <div class="p-4">
            <div class="flex items-center justify-between">
              <span v-for="(value, key, ind) in trip" :key="ind">
              <h3 v-if="ind==2" class="text-lg font-bold text-gray-800">{{ value }}</h3>
              </span>
              <router-link :to="`/xunlianyingxinxidetail/`+item.id">
              <button class="!rounded-button bg-gradient-to-r from-rose-500 to-red-600 text-white px-4 py-1.5 text-sm hover:from-rose-600 hover:to-red-700 whitespace-nowrap flex items-center gap-2">
                查看详情
                <i class="fas fa-arrow-right"></i>
              </button>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

    







</template>

<style  scoped>


</style>
