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
                                                                                              xunlianyingmingcheng: false,
                                                            xunlianyingtupian: false,
                                                            yuyueren: false,
                                                            yuyuerendianhua: false,
                                                            yuyuerennianling: false,
                                                            yuyuerenxingbie: false,
                                                            yuyueshijian: false,
                                                            userid: false,
                              },
                                                                                                                                                                                    yuyueguanliOptions: [],
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
                                                                                                                                                                                , yuyueguanliyuyuerenxingbieOptions
                                                            
                                                                                                                                                                                                                    } = {...toRefs(state)};


    function open(title:string,type:string,formData?:any){

        state.title=title;
        state.type=type;
        state.formData={...formData,...initData};
        state.visible=true;


      if (state.type == 'cross') {
        var obj = Session.get('crossObj');
        for (var o in obj) {
                                                                                                      if (o == 'xunlianyingmingcheng') {
                    state.formData.xunlianyingmingcheng = obj[o];
                    state.roisfalg.xunlianyingmingcheng = true;
                    continue;
                  }
                                                              if (o == 'xunlianyingtupian') {
                    state.formData.xunlianyingtupian = obj[o];
                    state.roisfalg.xunlianyingtupian = true;
                    continue;
                  }
                                                              if (o == 'yuyueren') {
                    state.formData.yuyueren = obj[o];
                    state.roisfalg.yuyueren = true;
                    continue;
                  }
                                                              if (o == 'yuyuerendianhua') {
                    state.formData.yuyuerendianhua = obj[o];
                    state.roisfalg.yuyuerendianhua = true;
                    continue;
                  }
                                                              if (o == 'yuyuerennianling') {
                    state.formData.yuyuerennianling = obj[o];
                    state.roisfalg.yuyuerennianling = true;
                    continue;
                  }
                                                              if (o == 'yuyuerenxingbie') {
                    state.formData.yuyuerenxingbie = obj[o];
                    state.roisfalg.yuyuerenxingbie = true;
                    continue;
                  }
                                                              if (o == 'yuyueshijian') {
                    state.formData.yuyueshijian = obj[o];
                    state.roisfalg.yuyueshijian = true;
                    continue;
                  }
                                                              if (o == 'userid') {
                    state.formData.userid = obj[o];
                    state.roisfalg.userid = true;
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
              url:`yuyueguanli/save`,
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
              url:`yuyueguanli/${!state.formData.id ? "save" : "update"}`,
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


                    


                    


                    


                                async function yuyueguanlixunlianyingtupianhandleUploadImg(options: any){
              try {
                loadding.value = true;
                const form = new FormData();
                form.append('file', options.file);
                form.append('data', JSON.stringify({sourceType: 'goods_img'}));
                // 开始上传
                const data = await uploadImg(form);

                // 上传成功 , 将上传成功的图片地址赋值回显出来
                const name=base.get().url;
                formData.value.xunlianyingtupian = name+'upload/'+ data.file;
              } catch(e) {

              } finally {
                loadding.value = false;
              }
            }
            


                    


                    


                    


                                                    state.yuyueguanliyuyuerenxingbieOptions= "男,女".split(',')
                



    


                    


                    


        


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
                                                                                                            
                        <el-form-item label="训练营名称" prop="xunlianyingmingcheng" :rules="{required: true, message: '训练营名称为必填项！', trigger: 'blur'}">
                            <el-input v-model="formData.xunlianyingmingcheng" maxlength="30" clearable show-word-limit placeholder="请输入训练营名称" :readonly="roisfalg.xunlianyingmingcheng"/>
                        </el-form-item>
                                                                                                                        

                                                                                <el-form-item label="训练营图片" prop="xunlianyingtupian" :rules="{required: true, message: '为必填项', trigger: 'blur'}">

                            <el-upload
                                    class="avatar-uploader"
                                    accept="image/png,image/jpg,image/jpeg"
                                    action="#"
                                    :show-file-list="false"
                                    :http-request="yuyueguanlixunlianyingtupianhandleUploadImg"
                            >
                                <img style="width: 100px;height: 100px;" v-if="formData.xunlianyingtupian" :src="formData.xunlianyingtupian" class="avatar" />
                                <el-icon v-else class="avatar-uploader-icon"><ele-Plus /></el-icon>

                            </el-upload>
                        </el-form-item>


                                                        
                        <el-form-item label="预约人" prop="yuyueren" :rules="{required: true, message: '预约人为必填项！', trigger: 'blur'}">
                            <el-input v-model="formData.yuyueren" maxlength="30" clearable show-word-limit placeholder="请输入预约人" :readonly="roisfalg.yuyueren"/>
                        </el-form-item>
                                                                                                                        

                                                        
                        <el-form-item label="预约人电话" prop="yuyuerendianhua" :rules="{required: true, message: '预约人电话为必填项！', trigger: 'blur'}">
                            <el-input v-model="formData.yuyuerendianhua" maxlength="30" clearable show-word-limit placeholder="请输入预约人电话" :readonly="roisfalg.yuyuerendianhua"/>
                        </el-form-item>
                                                                                                                        

                                                        
                        <el-form-item label="预约人年龄" prop="yuyuerennianling" :rules="{required: true, message: '预约人年龄为必填项！', trigger: 'blur'}">
                            <el-input v-model="formData.yuyuerennianling" maxlength="30" clearable show-word-limit placeholder="请输入预约人年龄" :readonly="roisfalg.yuyuerennianling"/>
                        </el-form-item>
                                                                                                                        

                                                                                <el-form-item label="预约人性别" prop="yuyuerenxingbie" :rules="{required: true, message: '预约人性别为必选项！', trigger: 'blur'}">
                            <el-select
                                    v-model="formData.yuyuerenxingbie"
                                    clearable
                                    placeholder="请选择预约人性别"
                                    style="width: 240px"
                            >
                                <el-option
                                        v-for="(item,index) in yuyueguanliyuyuerenxingbieOptions"
                                        v-bind:key="index"
                                        :label="item"
                                        :value="item"
                                />
                            </el-select>
                        </el-form-item>

                                                                                <el-form-item label="预约时间" prop="yuyueshijian"  :rules="{required: true, message: '预约时间为必填项', trigger: 'blur'}">

                            <el-date-picker
                                    v-model="formData.yuyueshijian"
                                    type="datetime"
                                    value-format="YYYY-MM-DD HH:mm:ss"
                                    placeholder="预约时间"
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
