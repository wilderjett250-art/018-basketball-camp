<script setup lang="ts">
    import { Session } from '@/utils/storage';
    import request from "@/utils/request";
    import { uploadImg } from '@/api/common/media';
    import base from "@/utils/base";
    import { defineAsyncComponent,reactive,ref,toRefs,nextTick } from 'vue';
    import {notify,confirm} from '@/utils/element';
    import {useRoute,useRouter} from 'vue-router'
    import {geren} from '@/utils/menu';
    const router = useRouter();
    const menus=geren.list();
    // console.log("个人菜单",menus)
    const grmenu=[];
    const grmenuesc=[];
 menus.forEach((item)=>{
          item.ykMenu.forEach((i)=>{
            // console.log("个人中心",i.child);
            i.child.forEach((a)=>{
                // console.log(a.tableName)
                grmenuesc.push(a.tableName);
            })
             grmenu.push(i.menu)
          });
     })
                        const forumAddORupdate=defineAsyncComponent(()=>import('@/views/forum/add-update.vue'));
                    const state=reactive({
                gr:grmenu,
        gresc:grmenuesc,
                                                                                                                            ruleForm: {

        },
        formInline: {},
        dataList: [],

        user:{},
                            forumpage:{
                current:1,
                size:10,
                total:0,
            },
            forumList:[],
            forumsearchForm:{},
                
        
    })


    const {dataList,ordersList,ruleForm,gr,gresc,
                                                                                                                                    
                    forumpage,
            forumList,
            forumsearchForm,
                formInline,
        
        

    } = {...toRefs(state)};




    init();

        
        
        
    function init(){
        let sessionTable = Session.get("tableName")
        request({
            url: sessionTable + '/session',
            method: "get"
        }).then((
                data
        ) => {
            if (data && data.code === 0) {

            state.user = data.data;
            state.ruleForm=data.data;

        } else {
            notify(data.msg,{type:'error'});
        }
    });
    }



        
    const formRef=ref();
    // 提交
    function onSubmit() {
        let sessionTable = Session.get("tableName")
        formRef.value?.validate((valid)=>{

            if(!valid) return;

        request({
            url:`${sessionTable}/${!state.ruleForm.id ? "save" : "update"}`,
            method:'post',
            data:state.ruleForm
        }).then((data)=>{
            notify("操作成功",{type:'success'});

        emit("refresh");
    })
    })

    }
        setTimeout(()=>{
  getforumlist();
},300)
    
                const forumupref=ref();

        function getforumlist(){
            var params={
                page: state.forumpage.current,
                limit: state.forumpage.size,
                parentid:'0'
            }
            if (state.forumsearchForm.title != '' && state.forumsearchForm.title != undefined) {
                params['title'] = '%' + state.forumsearchForm.title + '%'
            }
            request({
                url:'forum/page?sort=addtime&order=desc',
                method:'get',
                params
            }).then((data)=>{
                state.forumList=data.data.list;
            state.forumpage.total=data.data.total
        })
        }




        function addforum(){
            var type='add';
            var title='新增';
            var item={};
            item.id=0

            forumupref.value.openaddOrupdate(title,item,type);


        }


        function updateforum(item){
            var type='up';
            var title='修改';
            forumupref.value.openaddOrupdate(title,item,type);

        }

        function delforum(item){
            confirm('此操作将永久删除该信息吗, 是否继续?').then(() => {

                request({
                            url:'forum/delete',
                            method:'post',
                            data:[item.id]
                        }).then((data) => {
                if (data && data.code === 0) {

                notify("操作成功",{type:'success'});


                getforumlist();

            } else {
                notify(data.msg,{type:'error'});
            }
        })






        })
        }



        

        
                    
                    
                    
                    
                    
        
function handleClick(tab:any){
    console.log(tab.props.name)
    if(tab.props.name){
        router.push(`/${tab.props.name}list`)
    }
}

        

        
</script>



<template>
  <div class="bg-gray-60">
    <div class="container mx-auto px-4 py-8 max-w-7xl">



      <div class="">
    <div style="line-height: 50px;">
        <el-card class="box-card">
            <div slot="header" class="clearfix" style="text-align: center;">
                <span>个人中心</span>
            </div>

        </el-card>
        <div style="height: 50px;"></div>

        <el-tabs  tab-position="activeName" type="border-card" style="height: 800px;"  @tab-click="handleClick">
                
            

            
            
                <el-tab-pane label="我的发布">

                    <el-card>

                        <el-form :inline="true" :model="forumsearchForm" class="demo-form-inline">
                            <el-form-item >
                                <el-input v-model="forumsearchForm.title" placeholder="标题"></el-input>
                            </el-form-item>

                            <el-form-item>
                                <el-button type="primary" @click="forumsearch()">查询</el-button>
                                <el-button type="success" @click="addforum()">发布</el-button>
                            </el-form-item>

                        </el-form>

                        <el-table
                                :data="forumList"
                                style="width: 100%"
                                height="450">
                            <el-table-column
                                    fixed
                                    prop="title"
                                    label="标题"
                            >
                            </el-table-column>
                            <el-table-column
                                    prop="addtime"
                                    label="发布时间"
                            >
                            </el-table-column>
                            <el-table-column
                                    prop="isdone"
                                    label="发布类型"
                            >
                            </el-table-column>


                            <el-table-column label="操作">

                                <template  #default="{row}">
                                    <el-button
                                            size="mini"
                                            @click="updateforum(row)">编辑</el-button>
                                    <el-button
                                            size="mini"
                                            type="danger"
                                            @click="delforum(row)">删除</el-button>
                                </template>

                            </el-table-column>
                        </el-table>





                        <m-page :page="forumpage" @pageChange="getforumlist"/>





                    </el-card>



                </el-tab-pane>

            


            

            

            
<el-tab-pane :label="item" v-for="(item,index) in gr" :name="gresc[index]">

            </el-tab-pane>


            <el-tab-pane label="修改个人信息">



                <div class="addEdit-block">
                    <el-form
                            ref="formRef" :model="ruleForm"
                            label-width="85px" label-right="right"
                            label-suffix=":" status-icon
                    >
                        <el-row>




                                                                                                                                                                                    


                                    <el-col :span="24">
                                        <el-form-item class="input" label="账号" prop="zhanghao"  :rules="{required: true, message: '账号为必填项！', trigger: 'blur'}" >
                                            <el-input v-model="ruleForm.zhanghao"
                                                      placeholder="账号" clearable></el-input>
                                        </el-form-item>
                                    </el-col>
                                                                                            


                                    <el-col :span="24">
                                        <el-form-item class="input" label="密码" prop="mima"  :rules="{required: true, message: '密码为必填项！', trigger: 'blur'}" >
                                            <el-input v-model="ruleForm.mima"
                                                      placeholder="密码" clearable></el-input>
                                        </el-form-item>
                                    </el-col>
                                                                                            


                                    <el-col :span="24">
                                        <el-form-item class="input" label="手机号" prop="shoujihao"  :rules="{required: true, message: '手机号为必填项！', trigger: 'blur'}" >
                                            <el-input v-model="ruleForm.shoujihao"
                                                      placeholder="手机号" clearable></el-input>
                                        </el-form-item>
                                    </el-col>
                                                            

















                        </el-row>
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">提交</el-button>
                        </el-form-item>
                    </el-form>
                </div>
            </el-tab-pane>


        </el-tabs>
    </div>
      </div>
    </div>

    </div>
                <forumAddORupdate @refresh="getforumlist" ref="forumupref"></forumAddORupdate>
    
</template>
<style lang="scss" scoped>
    .avatar-uploader{
        border:1px solid #e4e6e9
    }

    .avatar-uploader .el-upload {
        border: 1px dashed var(--el-border-color);
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
        transition: var(--el-transition-duration-fast);
    }

    .avatar-uploader .el-upload:hover {
        border-color: var(--el-color-primary);
    }

    .el-icon.avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        text-align: center;
    }
</style>
