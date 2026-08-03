
<!-- 代码已包含 CSS：使用 TailwindCSS , 安装 TailwindCSS 后方可看到布局样式效果 -->
<template>
  <div class="min-h-screen bg-gray-50">
    <div class="mx-auto max-w-7xl p-8">
      <div class="rounded-xl bg-white p-8 shadow-lg">

        <div class="mb-12 flex gap-12">

          <div class="relative w-2/5 overflow-hidden" @click="handleImagePreview">
                                                                                                                                                                                                                                                                                  <img :src="detail.changditupian" alt="" class="h-[400px] w-full rounded-lg object-cover object-top cursor-pointer hover:opacity-90 transition-opacity"/>
                                                                                                                                                                                                                                                                                                            
          </div>

          <div class="w-3/5">
                                                                                                                            <h1 class="mb-6 text-4xl font-bold text-gray-900">{{detail.changdimingcheng}}</h1>
                                                                                                                                                                                                                                       <div class="mb-6 space-y-2">
                                                  <div class="flex items-center gap-2">
                <span class="font-bold text-gray-700">场地名称：</span>
                <span class="text-gray-600">{{detail.changdimingcheng}}</span>
              </div>
                                                        <div class="flex items-center gap-2">
                <span class="font-bold text-gray-700">场地大小：</span>
                <span class="text-gray-600">{{detail.changdidaxiao}}</span>
              </div>
                                        <div class="flex items-center gap-2">
                <span class="font-bold text-gray-700">场地人数：</span>
                <span class="text-gray-600">{{detail.changdirenshu}}</span>
              </div>
                                                        <div class="flex items-center gap-2">
                <span class="font-bold text-gray-700">比赛时间：</span>
                <span class="text-gray-600">{{detail.bisaishijian}}</span>
              </div>
                                  </div>

            <div class="mb-6 flex items-center gap-4">

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
                                    


                             


                                                                                    
                                                                                                                                                 


            </div>

          </div>
        </div>
        <!-- 详情区 -->
        <div class="mt-12 rounded-lg bg-gray-50 p-8">
          <div class="prose prose-lg max-w-none">
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                                                        <p class="mb-6" v-html="detail.xiangqing"></p>
                              
                                                        
                          
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          

          </div>
        </div>
        <!-- 评论区 -->

        <div class="mt-12">
          <h2 class="mb-6 text-2xl font-bold text-gray-900">评论区</h2>
          <!-- 评论输入框 -->
          <div class="mb-8 flex gap-4">
            <div class="h-10 w-10 flex-shrink-0 flex items-center justify-center">
              <i class="fas fa-user text-gray-400 text-xl"></i>
            </div>
            <div class="flex-grow">
              <textarea v-model="formData.content" class="min-h-[100px] w-full rounded-lg border border-gray-200 p-4 text-gray-700 focus:border-blue-500 focus:outline-none" placeholder="写下你的评论..."></textarea>
              <button @click="addpl()" class="mt-4 flex items-center gap-2 rounded-lg bg-blue-500 px-6 py-2 text-white hover:bg-blue-600 transition-colors !rounded-button whitespace-nowrap">
                <i class="fas fa-paper-plane"></i>
                <span>发表评论</span>
              </button>
            </div>
          </div>
          <!-- 评论列表 -->
          <div class="space-y-8">
            <div class="flex gap-4" v-for="item in pinglunDate " :key="item">
              <div class="h-10 w-10 flex-shrink-0 flex items-center justify-center">
                <i class="fas fa-user text-gray-400 text-xl"></i>
              </div>
              <div class="flex-grow">
                <div class="flex items-center gap-2">
                  <span class="font-bold text-gray-900">{{item.nickname}}</span>
                </div>
                <p class="mt-2 text-gray-700">{{item.content}}</p>
                <div class="mt-4 rounded-lg bg-gray-50 p-4" v-if="item.reply">
                  <div class="space-y-4">
                    <div class="flex gap-3">
                      <div class="h-8 w-8 flex-shrink-0 flex items-center justify-center">
                        <i class="fas fa-user text-gray-400 text-sm"></i>
                      </div>
                      <div>
                        <div class="flex items-center gap-2">
                          <span class="font-semibold text-gray-900">管理员</span>
                        </div>
                        <p class="mt-1 text-sm text-gray-700">{{item.reply}}</p>
                      </div>
                    </div>

                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>

        

      </div>
    </div>
    <!-- 图片预览弹窗 -->
    <div v-if="showPreview" class="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-75" @click="closePreview">
      <img :src="detail.tupian" alt="预览图" class="max-h-[90vh] max-w-[90vw] object-contain"/>
    </div>
  </div>




        

        
             
                </template>


<script setup>



    import { defineAsyncComponent,reactive,ref,toRefs } from 'vue';
    import { toRaw } from "@vue/reactivity";
    import { Key } from '@/stores/auth';
    import { Session } from '@/utils/storage';
    import request from "@/utils/request";
    import {notify,confirm} from '@/utils/element';
    import { isAuth } from '@/utils/utils'
    import { ElLoading } from 'element-plus'
            const showPreview = ref(false);
    const handleImagePreview = () => {
      showPreview.value = true;
    };
    const closePreview = () => {
      showPreview.value = false;
    };

    import { useRoute } from 'vue-router'

        


        
    const route = useRoute()

        
        
        
    // 打印
    const id=route.params.id
    request({
        url: `bisaiguanli/info/${id}`,
        method: "get"
    }).then((data) => {
        if (data && data.code === 0) {
        state.detail=data.data;
                
            getpllist()

            } else {
        notify(data.msg,{type:'error'});
    }
    });

            const state=reactive({
                detail:{},
        user:{},
        pinglunDate:[],
                                detailTable:'bisaiguanli',
        formData:{
            userid:"",
            nickname:"",
            refid:"",
            content:""
        },
        detailFlag:false,
    })


    const {detail,user,pinglunDate,detailFlag,
                                        detailTable,
        formData,
    } = {...toRefs(state)};

                

        






    let sessionTable = Session.get("tableName")
    request({
        url: sessionTable + '/session',
        method: "get"
    }).then((
            data
    ) => {
        if (data && data.code === 0) {
        state.user = data.data;
    } else {
        notify(data.msg,{type:'error'});


    }
    });




    function download(file) {
        window.open(`${file}`)
    }


    function init(id){
        state.detailFlag=true;
        info(id);
            }
    function info(id) {
        request({
            url: `bisaiguanli/info/${id}`,
            method: "get"
        }).then((data) => {
            if (data && data.code === 0) {
            state.detail=data.data;
        } else {
            notify(data.msg,{type:'error'});
        }
    });
    }





        
        function getpllist() {
            request({
                url: `discussbisaiguanli/list`,
                method: "get",
                params: {
                    refid: state.detail.id,
                }
            }).then((data) => {
                if (data && data.code === 0) {
                state.pinglunDate=data.data.list;
            } else {
                notify(data.msg,{type:'error'});
            }
        });
        }





        function addpl(){
            state.formData.nickname=Session.get("adminName")
            state.formData.userid=state.user.id
            state.formData.refid=state.detail.id

            request({
                url: `discussbisaiguanli/save`,
                method: "post",
                data:state.formData
            }).then((data) => {
                if (data && data.code === 0) {
                notify("评论成功",{type:'success'});

                getpllist();
            } else {
                notify(data.msg,{type:'error'});
            }
        });
        }

        
        

        
        


        

        
        
        
</script>

<style scoped>

        

                @import '@/assets/pinglun.css';
                
        
        
</style>
