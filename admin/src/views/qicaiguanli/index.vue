<script setup lang="ts">
    import { defineAsyncComponent,reactive,ref,toRefs,onMounted,computed } from 'vue';
    import { toRaw } from "@vue/reactivity";
    import { Key } from '@/stores/auth';
    import { Session } from '@/utils/storage';
    import request from "@/utils/request";
    import {notify,confirm} from '@/utils/element';
    import { isAuth } from '@/utils/utils';
    import {exportExcel} from '@/utils/exportExcel';
    import printJS from 'print-js';
    import { ElMessageBox } from 'element-plus';

    const AddEdit=defineAsyncComponent(()=>import('@/views/qicaiguanli/add-edit.vue'));
            const state=reactive({
        query:{
                                                                            qicaimingcheng:'',
                                                                                
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


                                                                            if (state.query.qicaimingcheng != '' && state.query.qicaimingcheng != undefined) {
                    params['qicaimingcheng'] = '%' + state.query.qicaimingcheng + '%'
                }
                                                                                        request({
            url:'qicaiguanli/page',
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
            url:`qicaiguanli/delete`,
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
        url:`qicaiguanli/delete`,
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

    // 出库功能
    function handleChuku(row:any){
        ElMessageBox.prompt('请输入出库数量', '出库', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            inputPattern: /^[1-9]\d*$/,
            inputErrorMessage: '请输入有效的数量（正整数）',
            inputPlaceholder: '请输入出库数量'
        }).then(({ value }) => {
            request({
                url: 'crk/save',
                method: 'post',
                data: {
                    refid: row.id,
                    name: row.qicaimingcheng,
                    sl: parseInt(value),
                    crkzt: '出库'
                }
            }).then(() => {
                notify("出库成功", {type: 'success'});
                getDateList();
            });
        }).catch(() => {
            // 用户取消操作
        });
    }

    // 入库功能
    function handleRuku(row:any){
        ElMessageBox.prompt('请输入入库数量', '入库', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            inputPattern: /^[1-9]\d*$/,
            inputErrorMessage: '请输入有效的数量（正整数）',
            inputPlaceholder: '请输入入库数量'
        }).then(({ value }) => {
            request({
                url: 'crk/save',
                method: 'post',
                data: {
                    refid: row.id,
                    name: row.qicaimingcheng,
                    sl: parseInt(value),
                    crkzt: '入库'
                }
            }).then(() => {
                notify("入库成功", {type: 'success'});
                getDateList();
            });
        }).catch(() => {
            // 用户取消操作
        });
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

                                                                                                            
                        <el-form-item label="器材名称"  prop="qicaimingcheng">
                            <el-input v-model="query.qicaimingcheng" maxlength="100" placeholder="请输入器材名称" clearable style="width: 200px;"/>
                        </el-form-item>
                                                                                                                                                                <el-form-item>
                    <el-button icon="ele-Search" @click="handleQuery()" type="primary">查询</el-button>
                  <el-button v-if="isAuth('qicaiguanli','删除') && selectedPets.length > 0" icon="ele-Delete" @click="handleBatchDelete" type="danger">多选删除</el-button>
                    <el-button v-if="isAuth('qicaiguanli','新增')" icon="ele-Plus" type="success" @click="add()">新增</el-button>
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

                      <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors whitespace-nowrap">器材名称</th>
            
          <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors whitespace-nowrap">器材图片</th>
    
          <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors whitespace-nowrap">器材用途</th>
    
                      <th class="px-6 py-4 text-left text-sm font-medium text-gray-500 transition-colors whitespace-nowrap">库存</th>
            
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
                              <span class="truncate max-w-[120px] block">{{ pet.qicaimingcheng }}</span>
                              <div class="absolute left-0 top-full z-50 bg-gray-900 text-white p-2 rounded whitespace-nowrap opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-200">
                                {{ pet.qicaimingcheng }}
                              </div>
                            </td>

     
                        <td class="px-6 py-4 text-sm group relative">
        <span class="truncate max-w-[120px] block">
            <img class="w-20 h-20 rounded-full object-cover mr-3" v-if="pet.qicaitupian" :src="pet.qicaitupian" alt="">
           <div v-else>无图片</div>
        </span>

                        </td>
                                  <td class="px-6 py-4 text-sm group relative">
        <span class="truncate max-w-[120px] block">{{ pet.qicaiyongtu }}</span>
        <div class="absolute left-0 top-full z-50 bg-gray-900 text-white p-2 rounded opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-200 multi-text-content">
          {{ pet.qicaiyongtu }}
        </div>
      </td>

    
                            <td class="px-6 py-4 text-sm group relative">
                              <span class="truncate max-w-[120px] block">{{ pet.alllimittimes }}</span>
                              <div class="absolute left-0 top-full z-50 bg-gray-900 text-white p-2 rounded whitespace-nowrap opacity-0 invisible group-hover:opacity-100 group-hover:visible transition-all duration-200">
                                {{ pet.alllimittimes }}
                              </div>
                            </td>

     
                    <td class="px-6 py-4">
                      <div class="flex space-x-3">
                        <button v-if="isAuth('qicaiguanli','修改')" @click.stop="handleEdit(pet)" class="px-3 py-1 text-xs bg-green-500 text-white hover:bg-green-600 !rounded-button whitespace-nowrap">
                          <i class="fas fa-edit mr-1"></i>编辑
                        </button>
                        <button @click.stop="handleChuku(pet)" class="px-3 py-1 text-xs bg-orange-500 text-white hover:bg-orange-600 !rounded-button whitespace-nowrap">
                          <i class="fas fa-arrow-circle-down mr-1"></i>出库
                        </button>
                        <button @click.stop="handleRuku(pet)" class="px-3 py-1 text-xs bg-blue-500 text-white hover:bg-blue-600 !rounded-button whitespace-nowrap">
                          <i class="fas fa-arrow-circle-up mr-1"></i>入库
                        </button>
                        <button v-if="isAuth('qicaiguanli','删除')" @click.stop="handleDelete(pet)" class="px-3 py-1 text-xs bg-red-500 text-white hover:bg-red-600 !rounded-button whitespace-nowrap">
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
