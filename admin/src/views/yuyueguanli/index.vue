<script setup lang="ts">
    import { defineAsyncComponent,reactive,ref,toRefs,onMounted,computed } from 'vue';
    import { toRaw } from "@vue/reactivity";
    import { Key } from '@/stores/auth';
    import { Session } from '@/utils/storage';
    import request from "@/utils/request";
    import {notify,confirm} from '@/utils/element';
    import { isAuth } from '@/utils/utils';
    import {exportExcel} from '@/utils/exportExcel';
    import printJS from 'print-js'

    const AddEdit=defineAsyncComponent(()=>import('@/views/yuyueguanli/add-edit.vue'));
            const state=reactive({
        query:{
                                                                            xunlianyingmingcheng:'',
                                                                    yuyueren:'',
                                                                                                                        
    },
    page:{
        current:1,
                size:10,
                total:0
    },
                    tableList:[],
            ids:[],
            isdel:true,
        
            })
    const { query,tableList,page,isdel
                               } = {...toRefs(state)};


    


    //进入执行
    getDateList();
    //获取列表
    function getDateList(){
        const params={
            page: state.page.current,
            limit: state.page.size,
                                }


                                                                            if (state.query.xunlianyingmingcheng != '' && state.query.xunlianyingmingcheng != undefined) {
                    params['xunlianyingmingcheng'] = '%' + state.query.xunlianyingmingcheng + '%'
                }
                                                                    if (state.query.yuyueren != '' && state.query.yuyueren != undefined) {
                    params['yuyueren'] = '%' + state.query.yuyueren + '%'
                }
                                                                                                                                request({
            url:'yuyueguanli/page',
            method:'get',
            params
        }).then(({data})=>{

            state.page.total=data.total;
        state.tableList=data.list;
            })
    }
    //查询
    function handleQuery(){
        getDateList();
    }

    function download(file) {
        window.open(`${file}`)
    }

    //删除

    function handleDelete(row:any){

        request({
            url:`yuyueguanli/delete`,
            method:'post',
            data:[row.id]
        }).then(({data})=>{
            notify("删除成功",{type:'success'});
        getDateList();

    })
    }


    const selectedPets = ref<string[]>([]);
    const isAllSelected = computed(() => {
      return state.tableList.length > 0 && selectedPets.value.length === state.tableList.length;
    });
    const toggleSelect = (petId: string) => {
      const index = selectedPets.value.indexOf(petId);
      if (index === -1) {
        selectedPets.value.push(petId);
      } else {
        selectedPets.value.splice(index, 1);
      }
    };
    const toggleSelectAll = () => {
      if (isAllSelected.value) {
        selectedPets.value = [];
      } else {
        selectedPets.value = state.tableList.map(pet => pet.id);
      }
    };

    const handleBatchDelete = () => {
// 这里添加批量删除的逻辑
      if (selectedPets.value.length === 0) return;
      request({
        url:`yuyueguanli/delete`,
        method:'post',
        data:selectedPets.value
      }).then(({data})=>{
        selectedPets.value = [];
        notify("删除成功",{type:'success'});
        getDateList();
      })

    };


                                                                                                                                

    const users=Session.get(Key.userInfoKey);

    const editRef=ref();


        


    function add(){
        editRef.value.open('新增','add');
    }
    function handleEdit(row:any){
        editRef.value.open('修改','up',row);
    }

        

        


        
    

</script>

<template>
    <el-card shadow="never" class="index">
        <template #header>
            <div class="card_header">

                <b>列表</b>
            </div>
        </template>
        <div class="layout-padding">
            <el-form inline :model="query" label-suffix=":">

                                                                                                            
                        <el-form-item label="训练营名称"  prop="xunlianyingmingcheng">
                            <el-input v-model="query.xunlianyingmingcheng" maxlength="100" placeholder="请输入训练营名称" clearable style="width: 200px;"/>
                        </el-form-item>
                                                                                            
                        <el-form-item label="预约人"  prop="yuyueren">
                            <el-input v-model="query.yuyueren" maxlength="100" placeholder="请输入预约人" clearable style="width: 200px;"/>
                        </el-form-item>
                                                                                                                                                                                                                                        <el-form-item>
                    <el-button icon="ele-Search" @click="handleQuery()" type="primary">查询</el-button>
                  <el-button v-if="isAuth('yuyueguanli','删除') && selectedPets.length > 0" icon="ele-Delete" @click="handleBatchDelete" type="danger">多选删除</el-button>
                    <el-button v-if="isAuth('yuyueguanli','新增')" icon="ele-Plus" type="success" @click="add()">新增</el-button>
                                                                            </el-form-item>
            </el-form>




          <main>
            <!-- 表格区域 -->
            <div class="bg-white rounded-lg shadow-sm">
              <div class="border-b flex justify-between items-center">
                <div class="flex items-center space-x-4">

                </div>
              </div>
              <div class="overflow-x-auto relative h-[600px]">
                <table class="w-full h-400 border-collapse">
                  <thead class="bg-gray-50 sticky top-0">
                  <tr class="border-b border-gray-100">
                    <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors">
                      <div class="flex items-center">
                        <input type="checkbox"
                               :checked="isAllSelected"
                               @change="toggleSelectAll"
                               class="w-4 h-4 rounded border-gray-300 text-blue-500 focus:ring-blue-500 mr-2">
                        全选
                      </div>
                    </th>

                      <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors whitespace-nowrap">训练营名称</th>
            
          <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors whitespace-nowrap">训练营图片</th>
    
                      <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors whitespace-nowrap">预约人</th>
            
                      <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors whitespace-nowrap">预约人电话</th>
            
                      <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors whitespace-nowrap">预约人年龄</th>
            
                      <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors whitespace-nowrap">预约人性别</th>
            
                      <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors whitespace-nowrap">预约时间</th>
            
                      <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors whitespace-nowrap">用户id</th>
            
                    <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors">操作</th>

                  </tr>
                  </thead>
                  <tbody class="divide-y divide-gray-200">





                  <tr v-for="pet in tableList" :key="pet.id" class="hover:bg-gray-50 transition-colors">
                    <td class="px-6 py-4 text-sm group relative">
                      <input type="checkbox"
                             :checked="selectedPets.includes(pet.id)"
                             @change="toggleSelect(pet.id)"
                      >
                    </td>

    
                            <td class="px-6 py-4 text-sm group relative">
                              <span class="truncate max-w-[120px] block">{{ pet.xunlianyingmingcheng }}</span>
                              <div class="absolute left-0 top-full z-50 bg-gray-900 text-white p-2 rounded whitespace-nowrap opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-200">
                                {{ pet.xunlianyingmingcheng }}
                              </div>
                            </td>

     
                        <td class="px-6 py-4 text-sm group relative">
        <span class="truncate max-w-[120px] block">
            <img class="w-20 h-20 rounded-full object-cover mr-3" v-if="pet.xunlianyingtupian" :src="pet.xunlianyingtupian" alt="">
           <div v-else>无图片</div>
        </span>

                        </td>
                            
    
                            <td class="px-6 py-4 text-sm group relative">
                              <span class="truncate max-w-[120px] block">{{ pet.yuyueren }}</span>
                              <div class="absolute left-0 top-full z-50 bg-gray-900 text-white p-2 rounded whitespace-nowrap opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-200">
                                {{ pet.yuyueren }}
                              </div>
                            </td>

     
    
                            <td class="px-6 py-4 text-sm group relative">
                              <span class="truncate max-w-[120px] block">{{ pet.yuyuerendianhua }}</span>
                              <div class="absolute left-0 top-full z-50 bg-gray-900 text-white p-2 rounded whitespace-nowrap opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-200">
                                {{ pet.yuyuerendianhua }}
                              </div>
                            </td>

     
    
                            <td class="px-6 py-4 text-sm group relative">
                              <span class="truncate max-w-[120px] block">{{ pet.yuyuerennianling }}</span>
                              <div class="absolute left-0 top-full z-50 bg-gray-900 text-white p-2 rounded whitespace-nowrap opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-200">
                                {{ pet.yuyuerennianling }}
                              </div>
                            </td>

     
    
                            <td class="px-6 py-4 text-sm group relative">
                              <span class="truncate max-w-[120px] block">{{ pet.yuyuerenxingbie }}</span>
                              <div class="absolute left-0 top-full z-50 bg-gray-900 text-white p-2 rounded whitespace-nowrap opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-200">
                                {{ pet.yuyuerenxingbie }}
                              </div>
                            </td>

     
    
                            <td class="px-6 py-4 text-sm group relative">
                              <span class="truncate max-w-[120px] block">{{ pet.yuyueshijian }}</span>
                              <div class="absolute left-0 top-full z-50 bg-gray-900 text-white p-2 rounded whitespace-nowrap opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-200">
                                {{ pet.yuyueshijian }}
                              </div>
                            </td>

     
    
                            <td class="px-6 py-4 text-sm group relative">
                              <span class="truncate max-w-[120px] block">{{ pet.userid }}</span>
                              <div class="absolute left-0 top-full z-50 bg-gray-900 text-white p-2 rounded whitespace-nowrap opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-200">
                                {{ pet.userid }}
                              </div>
                            </td>

     
                    <td class="px-6 py-4">
                      <div class="flex space-x-3">
                        <button v-if="isAuth('yuyueguanli','修改')" @click.stop="handleEdit(pet)" class="px-3 py-1 text-xs bg-green-500 text-white hover:bg-green-600 !rounded-button whitespace-nowrap">
                          <i class="fas fa-edit mr-1"></i>编辑
                        </button>
                        <button v-if="isAuth('yuyueguanli','删除')" @click.stop="handleDelete(pet)" class="px-3 py-1 text-xs bg-red-500 text-white hover:bg-red-600 !rounded-button whitespace-nowrap">
                          <i class="fas fa-trash mr-1"></i>删除
                        </button>
                          

                      </div>
                    </td>
                  </tr>







                  </tbody>
                </table>
              </div>
            </div>
          </main>

            <m-page :page="page" @pageChange="getDateList"/>

            <AddEdit ref="editRef" @refresh="getDateList"/>
        </div>
    </el-card>

    

</template>

<style scoped>

</style>
