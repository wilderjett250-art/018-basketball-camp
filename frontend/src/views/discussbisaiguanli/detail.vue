
<!-- 代码已包含 CSS：使用 TailwindCSS , 安装 TailwindCSS 后方可看到布局样式效果 -->
<template>
  <div class="min-h-screen bg-gray-50">
    <div class="mx-auto max-w-7xl p-8">
      <div class="rounded-xl bg-white p-8 shadow-lg">

        <div class="mb-12 flex gap-12">

          <div class="relative w-2/5 overflow-hidden" @click="handleImagePreview">
                                                                                                                                                                                                                                                                                                                                                                                                                                                                
          </div>

          <div class="w-3/5">
                                                                                                                                                                                                                                                                                                   <div class="mb-6 space-y-2">
                                                                                                                            </div>

            <div class="mb-6 flex items-center gap-4">

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
                                    


                             


                                                                                    
                                                                                                                                                 


            </div>

          </div>
        </div>
        <!-- 详情区 -->
        <div class="mt-12 rounded-lg bg-gray-50 p-8">
          <div class="prose prose-lg max-w-none">
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                          
                                                                                                                                                                                                                                                                                                                                                                                                                                  

          </div>
        </div>
        <!-- 评论区 -->


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
        url: `discussbisaiguanli/info/${id}`,
        method: "get"
    }).then((data) => {
        if (data && data.code === 0) {
        state.detail=data.data;
                    } else {
        notify(data.msg,{type:'error'});
    }
    });

            const state=reactive({
                detail:{},
        user:{},
        pinglunDate:[],
                                detailTable:'discussbisaiguanli',
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
            url: `discussbisaiguanli/info/${id}`,
            method: "get"
        }).then((data) => {
            if (data && data.code === 0) {
            state.detail=data.data;
        } else {
            notify(data.msg,{type:'error'});
        }
    });
    }





        
        

        
        


        

        
        
        
</script>

<style scoped>

        

                
        
        
</style>
