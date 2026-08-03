
<!-- 代码已包含 CSS：使用 TailwindCSS , 安装 TailwindCSS 后方可看到布局样式效果 -->
<template>
  <div class="min-h-screen bg-gray-50">
    <div class="mx-auto max-w-7xl p-8">
      <div class="rounded-xl bg-white p-8 shadow-lg">

        <div class="mb-12 flex gap-12">

          <div class="relative w-2/5 overflow-hidden" @click="handleImagePreview">
                                                                                                                                                                                                                                                                                  <img :src="detail.xunlianyingtupian" alt="" class="h-[400px] w-full rounded-lg object-cover object-top cursor-pointer hover:opacity-90 transition-opacity"/>
                                                                                                                                                                                                                                                                                                                                                                        
          </div>

          <div class="w-3/5">
                                                                                                                            <h1 class="mb-6 text-4xl font-bold text-gray-900">{{detail.xunlianyingmingcheng}}</h1>
                                                                                                                                                                                                                                                                             <div class="mb-6 space-y-2">
                                                  <div class="flex items-center gap-2">
                <span class="font-bold text-gray-700">训练营名称：</span>
                <span class="text-gray-600">{{detail.xunlianyingmingcheng}}</span>
              </div>
                                                        <div class="flex items-center gap-2">
                <span class="font-bold text-gray-700">招收人数：</span>
                <span class="text-gray-600">{{detail.zhaoshourenshu}}</span>
              </div>
                                                        <div class="flex items-center gap-2">
                <span class="font-bold text-gray-700">开放时间：</span>
                <span class="text-gray-600">{{detail.kaifangshijian}}</span>
              </div>
                                                                  </div>

            <div class="mb-6 flex items-center gap-4">
              <button  @click="storeUp(1)" v-if="!storeupFlag" class="flex items-center gap-2 rounded-lg bg-green-500 px-4 py-2 text-white hover:bg-green-600 transition-colors !rounded-button whitespace-nowrap">
                <i class="fas fa-bookmark"></i>
                <span>收藏</span>
              </button>
              <button  @click="storeUp(1)" v-if="storeupFlag" class="flex items-center gap-2 rounded-lg bg-red-500 px-4 py-2 text-white hover:bg-red-600 transition-colors !rounded-button whitespace-nowrap">
                <i class="fas fa-flag"></i>
                <span>已收藏</span>
              </button>
  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
                                    


                                                            <button v-if="isAuth('xunlianyingxinxi','我要预约')"
                                                                                     @click="yuyueguanliCrossAddOrUpdateHandler(detail,'cross','','','')"
                                                                        class="flex items-center gap-2 rounded-lg bg-red-500 px-4 py-2 text-white hover:bg-red-600 transition-colors !rounded-button whitespace-nowrap">
                                 <i class="fas fa-share-alt"></i>
                                 <span>我要预约</span>
                               </button>

                             


                                                                                    
                                                                                                                                                   <button 
                                        @click="onThumb('thumbsupnum')" 
                                        :disabled="thumbsUpLoading"
                                        :class="{'opacity-50 cursor-not-allowed': thumbsUpLoading, 'thumb-animate': thumbsUpAnimate}"
                                        class="flex items-center gap-2 rounded-lg bg-green-500 px-4 py-2 text-white hover:bg-green-600 transition-all duration-300 transform hover:scale-105 !rounded-button whitespace-nowrap">
                                        <i class="fas fa-thumbs-up" :class="{'animate-bounce': thumbsUpAnimate}"></i>
                                        <span>赞 ({{ detail.thumbsupnum || 0 }})</span>
                                      </button>
                                      <button 
                                        @click="onThumb('crazilynum')" 
                                        :disabled="thumbsDownLoading"
                                        :class="{'opacity-50 cursor-not-allowed': thumbsDownLoading, 'thumb-animate': thumbsDownAnimate}"
                                        class="flex items-center gap-2 rounded-lg bg-gray-500 px-4 py-2 text-white hover:bg-gray-600 transition-all duration-300 transform hover:scale-105 !rounded-button whitespace-nowrap">
                                        <i class="fas fa-thumbs-down" :class="{'animate-bounce': thumbsDownAnimate}"></i>
                                        <span>踩 ({{ detail.crazilynum || 0 }})</span>
                                      </button>
                                                                        


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




        

        
                 <yuyueguanli-cross-add-or-update ref="yuyueguanliCrossaddOrUpdate"></yuyueguanli-cross-add-or-update>
    
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

    const yuyueguanliCrossAddOrUpdate=defineAsyncComponent(()=>import('@/views/yuyueguanli/add-edit.vue'));
        
        
        
    // 打印
    const id=route.params.id
    request({
        url: `xunlianyingxinxi/info/${id}`,
        method: "get"
    }).then((data) => {
        if (data && data.code === 0) {
        state.detail=data.data;
                    isStoreup(id);
                
            getpllist()

            } else {
        notify(data.msg,{type:'error'});
    }
    });

            const state=reactive({
                detail:{},
        user:{},
        pinglunDate:[],
                            storeupFlag:0,
            storeupList:[],
                            thumbsUpLoading: false,
            thumbsDownLoading: false,
            thumbsUpAnimate: false,
            thumbsDownAnimate: false,
                detailTable:'xunlianyingxinxi',
        formData:{
            userid:"",
            nickname:"",
            refid:"",
            content:""
        },
        detailFlag:false,
    })


    const {detail,user,pinglunDate,detailFlag,
                            storeupFlag,
            storeupList,
                                    thumbsUpLoading,
            thumbsDownLoading,
            thumbsUpAnimate,
            thumbsDownAnimate,
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
                    isStoreup(id);
            }
    function info(id) {
        request({
            url: `xunlianyingxinxi/info/${id}`,
            method: "get"
        }).then((data) => {
            if (data && data.code === 0) {
            state.detail=data.data;
        } else {
            notify(data.msg,{type:'error'});
        }
    });
    }



      const yuyueguanliCrossaddOrUpdate=ref();

    function  yuyueguanliCrossAddOrUpdateHandler(row, type, statusColumnName, tips, statusColumnValue) {
            Session.set('crossObj', row);
            Session.set('crossTable', 'xunlianyingxinxi');
            Session.set('statusColumnName', statusColumnName);
            Session.set('statusColumnValue', statusColumnValue);
            Session.set('tips', tips);
        if (statusColumnName != '') {
            var obj = Session.get('crossObj');
                                                                                                                                                                                            }

            yuyueguanliCrossaddOrUpdate.value.open('我要预约',row.id,type);


    }


    

        
        function getpllist() {
            request({
                url: `discussxunlianyingxinxi/list`,
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
                url: `discussxunlianyingxinxi/save`,
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

        
        

        
                function isStoreup(id){
            request({
                url:'storeup/list',
                method:'get',
                params:{
                    page: 1,
                    limit: 1,
                    type: 1,
                    refid: state.detail.id,
                    tablename: state.detailTable,
                    userid: state.user.id
                }
            }).then((data)=>{
                state.storeupList=data.data.list;
            if (data.data.list.length == 1) {
                state.storeupFlag=1;
            }else{
                state.storeupFlag=0;
            }


        })
        }


        function storeUp(type){
            request({
                url:'storeup/list',
                method:'get',
                params:{
                    page: 1,
                    limit: 1,
                    type: 1,
                    refid: state.detail.id,
                    tablename: state.detailTable,
                    userid: state.user.id
                }
            }).then((data)=>{
                state.storeupList=data.data.list;

            if (data.data.list.length == 1) {

                request({
                    url:'storeup/delete',
                    method:'post',
                    data:[data.data.list[0].id]

                }).then((data)=>{
                    notify("取消成功",{type:'warning'});

                state.storeupFlag=0;

            })
            }else{
                request({
                    url:'storeup/save',
                    method:'post',
                    data:{
                        refid: state.detail.id,
                        tablename: state.detailTable,
                           name: state.detail.xunlianyingmingcheng,
                               userid:state.user.id,
                                                                                                                                                                                                                                                picture: state.detail.xunlianyingtupian,
                                                                                                                                                                                                                                                                                                                                            }

                }).then((data)=>{
                    notify("收藏成功",{type:'warning'});

                state.storeupFlag=1;

            })
            }
        })
        }

        


        

        
        
                // 点赞和踩的处理函数
        const onThumb = (type) => {
          // 防止重复点击
          if (type === 'thumbsupnum' && state.thumbsUpLoading) return;
          if (type === 'crazilynum' && state.thumbsDownLoading) return;
          
          // 设置加载状态
          if (type === 'thumbsupnum') {
            state.thumbsUpLoading = true;
            state.thumbsUpAnimate = true;
          } else {
            state.thumbsDownLoading = true;
            state.thumbsDownAnimate = true;
          }
          
          // 增加计数
          state.detail[type] = (state.detail[type] || 0) + 1;
          
          // 发送请求
          request({
            url: `xunlianyingxinxi/update`,
            method: 'post',
            data: state.detail
          }).then((res) => {
            if (res && res.code === 0) {
              notify('操作成功', { type: 'success' });
              // 重新获取数据以确保准确性
              info(id);
            } else {
              // 失败时回滚计数
              state.detail[type] = (state.detail[type] || 1) - 1;
              notify(res.msg || '操作失败', { type: 'error' });
            }
          }).catch((error) => {
            // 错误时回滚计数
            state.detail[type] = (state.detail[type] || 1) - 1;
            notify('网络错误，请稍后重试', { type: 'error' });
          }).finally(() => {
            // 清除加载状态
            if (type === 'thumbsupnum') {
              state.thumbsUpLoading = false;
              // 300ms后清除动画
              setTimeout(() => {
                state.thumbsUpAnimate = false;
              }, 300);
            } else {
              state.thumbsDownLoading = false;
              // 300ms后清除动画
              setTimeout(() => {
                state.thumbsDownAnimate = false;
              }, 300);
            }
          });
        };
        
</script>

<style scoped>

        

                @import '@/assets/pinglun.css';
                
        
                /* 点赞和踩的动画效果 */
        @keyframes thumbPulse {
          0%, 100% {
            transform: scale(1);
          }
          50% {
            transform: scale(1.2);
          }
        }
        
        .thumb-animate {
          animation: thumbPulse 0.3s ease-in-out;
        }
        
        /* 按钮点击波纹效果 */
        button {
          position: relative;
          overflow: hidden;
        }
        
        button::after {
          content: '';
          position: absolute;
          top: 50%;
          left: 50%;
          width: 0;
          height: 0;
          border-radius: 50%;
          background: rgba(255, 255, 255, 0.5);
          transform: translate(-50%, -50%);
          transition: width 0.6s, height 0.6s;
        }
        
        button:active::after {
          width: 300px;
          height: 300px;
        }
        
        /* 禁用状态样式 */
        button:disabled {
          cursor: not-allowed;
          opacity: 0.6;
        }
        
        /* 图标动画 */
        .animate-bounce {
          animation: bounce 0.5s ease-in-out;
        }
        
        @keyframes bounce {
          0%, 100% {
            transform: translateY(0);
          }
          50% {
            transform: translateY(-5px);
          }
        }
        
        /* Hover效果增强 */
        button:hover:not(:disabled) {
          box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
        }
        
</style>
