<script setup lang='ts'>
    import { defineAsyncComponent,reactive,ref,toRefs } from 'vue';
    import { toRaw } from "@vue/reactivity";
    import { Key } from '@/stores/auth';
    import { Session } from '@/utils/storage';
    import request from "@/utils/request";
    import {notify} from '@/utils/element';
    import { isAuth } from '@/utils/utils'
    import { ElLoading } from 'element-plus'
    const AddEdit=defineAsyncComponent(()=>import('@/views/crk/add-edit.vue'));
    const state=reactive({

        dataList: [],
        searchForm:{
            biaoti:'',

        },
                page:{
            current:1,
            size:10,
            total:0
        },
        showFlag:true,
    })

    const ragRef=ref();
    const ragRefInstance=ref();
    const {dataList,searchForm,page,showFlag
            } = {...toRefs(state)};

    getDataList()

        
        
    function download(file) {
        window.open(`${file}`)
    }
        
        function getDataList(){

            ragRefInstance.value = ElLoading.service({
                target: ragRef.value,
                body: true,
                text: 'Loading...',
            })
            const params={
                page: state.page.current,
                limit: state.page.size,
            }


                                                                                                                                                                                    

            request({
                url:'crk/list',
                method:'get',
                params
            }).then((data)=>{
                ragRefInstance.value.close()
            state.page.total=data.data.total;
            state.dataList=data.data.list;

        })
        }
            function handleQuery(){
        getDataList()
    }

    const editRef=ref();

    function add(){
        editRef.value.open('新增','add');
    }
    function handleEdit(row:any){
        editRef.value.open('修改','up',row);
    }
    function handleDelete(row:any){

        request({
            url:`crk/delete`,
            method:'post',
            data:[row.id]
        }).then(({data})=>{
            notify("删除成功",{type:'success'});
          getDataList();

    })
    }

</script>

<template ref="ragRefInstance">



  <div>
    <!-- 旅行灵感 -->
    <div class="py-20 bg-white">
      <div class="max-w-7xl mx-auto px-4">
        <h2 class="text-3xl font-bold text-center mb-4">出入库</h2>
        <div class="max-w-4xl mx-auto mb-12">
          <div class="flex items-center gap-4">

                                                                                                                                                                                                                                                                                                                                                                                                                                          
            <button @click="handleQuery()" class="px-6 py-2 !rounded-button bg-blue-600 text-white hover:bg-blue-700 transition-colors whitespace-nowrap">
              <i class="fas fa-search mr-2"></i>搜索
            </button>
          </div>
        </div>
        <div class="grid grid-cols-4 gap-8">
          <div v-for="(item, index) in dataList" :key="index" class="group cursor-pointer">
            <div class="overflow-hidden rounded-lg shadow-lg">





            </div>
                                                                                                                                                                                    </div>
        </div>
      </div>
      <m-page :page="page" style="text-align: center;" @pageChange="getDataList"/>
    </div>

  </div>


    
        </template>

<style  scoped>
    .el-row.is-justify-end {
        justify-content: center;
    }

</style>
