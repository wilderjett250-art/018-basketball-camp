<script setup lang="ts">
    import { defineAsyncComponent,reactive,ref,toRefs } from 'vue';
    import base from "@/utils/base";
    import { uploadImg } from '@/api/common/media';
    import request from "@/utils/request";
    import {notify} from '@/utils/element'
    import { Session } from '@/utils/storage';
    const Editor=defineAsyncComponent(()=>import('@/components/editor/index.vue'));


                                
    const formRef=ref();
    const state=reactive({
        loadding:false,//加载框
        visible:false,//隐藏显示
        formData:{} as any,
      roisfalg:{
                                                                                              changdimingcheng: false,
                                                            changditupian: false,
                                                            changdidaxiao: false,
                                                            changdirenshu: false,
                                                            xiangqing: false,
                                                            bisaishijian: false,
                              },
                                                                                                                                                                                                                                                                                                                                                        title:'新增',
        type:'add'
    })
    const initData={

    }
    const {
        loadding,
        visible,
        formData,
        title,
        type,
      roisfalg
                                                                                                                                                                        
                                                                                                                                                                            } = {...toRefs(state)};


    function open(title:string,type:string,formData?:any){

        state.title=title;
        state.type=type;
        state.formData={...formData,...initData};
        state.visible=true;


      if (state.type == 'cross') {
        var obj = Session.get('crossObj');
        for (var o in obj) {
                                                                                                      if (o == 'changdimingcheng') {
                    state.formData.changdimingcheng = obj[o];
                    state.roisfalg.changdimingcheng = true;
                    continue;
                  }
                                                              if (o == 'changditupian') {
                    state.formData.changditupian = obj[o];
                    state.roisfalg.changditupian = true;
                    continue;
                  }
                                                              if (o == 'changdidaxiao') {
                    state.formData.changdidaxiao = obj[o];
                    state.roisfalg.changdidaxiao = true;
                    continue;
                  }
                                                              if (o == 'changdirenshu') {
                    state.formData.changdirenshu = obj[o];
                    state.roisfalg.changdirenshu = true;
                    continue;
                  }
                                                              if (o == 'xiangqing') {
                    state.formData.xiangqing = obj[o];
                    state.roisfalg.xiangqing = true;
                    continue;
                  }
                                                              if (o == 'bisaishijian') {
                    state.formData.bisaishijian = obj[o];
                    state.roisfalg.bisaishijian = true;
                    continue;
                  }
                                    }


      }
    }


    const emit = defineEmits(['refresh']);

    const close=()=>{
        state.visible=false;
    }

    function submitForm(){
        formRef.value?.validate((valid:boolean)=>{

            if(!valid) return;
            state.loadding=true;
          if (state.type == 'cross') {
            request({
              url:`bisaiguanli/save`,
              method:'post',
              data:state.formData
            }).then(({data})=>{
              notify("操作成功",{type:'success'});
              state.loadding=false;
              close();
              emit("refresh");
            })
          }else{
            request({
              url:`bisaiguanli/${!state.formData.id ? "save" : "update"}`,
              method:'post',
              data:state.formData
            }).then(({data})=>{
              notify("操作成功",{type:'success'});
              state.loadding=false;
              close();
              emit("refresh");
            })
          }




        })

    }

    defineExpose({
        open
    })


                    


                    


                    


                                async function bisaiguanlichangditupianhandleUploadImg(options: any){
              try {
                loadding.value = true;
                const form = new FormData();
                form.append('file', options.file);
                form.append('data', JSON.stringify({sourceType: 'goods_img'}));
                // 开始上传
                const data = await uploadImg(form);

                // 上传成功 , 将上传成功的图片地址赋值回显出来
                const name=base.get().url;
                formData.value.changditupian = name+'upload/'+ data.file;
              } catch(e) {

              } finally {
                loadding.value = false;
              }
            }
            


                    


                    


                    


                    


        


</script>

<template>
    <el-dialog :title="`${title}`" v-model="visible"
               center draggable :before-close="close" width="1000px"
               :close-on-click-modal="false" destroy-on-close>
        <div v-loading="loadding">
            <el-form ref="formRef" :model="formData"
                     label-width="85px" label-right="right"
                     label-suffix=":" status-icon
            >
                                                                                                            
                        <el-form-item label="场地名称" prop="changdimingcheng" :rules="{required: true, message: '场地名称为必填项！', trigger: 'blur'}">
                            <el-input v-model="formData.changdimingcheng" maxlength="30" clearable show-word-limit placeholder="请输入场地名称" :readonly="roisfalg.changdimingcheng"/>
                        </el-form-item>
                                                                                                                        

                                                                                <el-form-item label="场地图片" prop="changditupian" :rules="{required: true, message: '为必填项', trigger: 'blur'}">

                            <el-upload
                                    class="avatar-uploader"
                                    accept="image/png,image/jpg,image/jpeg"
                                    action="#"
                                    :show-file-list="false"
                                    :http-request="bisaiguanlichangditupianhandleUploadImg"
                            >
                                <img style="width: 100px;height: 100px;" v-if="formData.changditupian" :src="formData.changditupian" class="avatar" />
                                <el-icon v-else class="avatar-uploader-icon"><ele-Plus /></el-icon>

                            </el-upload>
                        </el-form-item>


                                                        
                        <el-form-item label="场地大小" prop="changdidaxiao" :rules="{required: true, message: '场地大小为必填项！', trigger: 'blur'}">
                            <el-input v-model="formData.changdidaxiao" maxlength="30" clearable show-word-limit placeholder="请输入场地大小" :readonly="roisfalg.changdidaxiao"/>
                        </el-form-item>
                                                                                                                        

                                                        
                        <el-form-item label="场地人数" prop="changdirenshu" :rules="{required: true, message: '场地人数为必填项！', trigger: 'blur'}">
                            <el-input v-model="formData.changdirenshu" maxlength="30" clearable show-word-limit placeholder="请输入场地人数" :readonly="roisfalg.changdirenshu"/>
                        </el-form-item>
                                                                                                                        

                                                                                <el-form-item label="详情" prop="xiangqing">

                            <Editor v-model="formData.xiangqing"/>

                        </el-form-item>

                                                                                <el-form-item label="比赛时间" prop="bisaishijian"  :rules="{required: true, message: '比赛时间为必填项', trigger: 'blur'}">

                            <el-date-picker
                                    v-model="formData.bisaishijian"
                                    type="datetime"
                                    value-format="YYYY-MM-DD HH:mm:ss"
                                    placeholder="比赛时间"
                            />


                        </el-form-item>
                                    

                
            </el-form>
            <el-row justify="center" class="mt10">
                <el-button @click="close">取 消</el-button>
                <el-button @click="submitForm" type="primary">保 存</el-button>
            </el-row>
        </div>
    </el-dialog>









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
