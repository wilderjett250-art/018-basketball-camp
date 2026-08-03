<script setup lang="ts">
  import {defineAsyncComponent, reactive, ref, toRefs} from 'vue';
  import base from "@/utils/base";
  import {uploadImg} from '@/api/common/media';
  import request from "@/utils/request";
  import {notify} from '@/utils/element'
  import {Session} from '@/utils/storage';

  const Editor = defineAsyncComponent(() => import('@/components/editor/index.vue'));
  const formRef = ref();
  const state = reactive({
    loadding: false,//加载框
    visible: false,//隐藏显示
    formData: {} as any,
                                                                                                                                                                                                                                                                                          title: '注册',
    tableName: ''
  })
  const initData = {}
  const {
    loadding,
    visible,
    formData,
    title,
    tableName,
                                                                                                                                                                                                                                                                                        } = {...toRefs(state)};


  function open(tableName: string) {

    state.tableName = tableName;
    state.visible = true;
  }


  const emit = defineEmits(['refresh']);

  const close = () => {
    state.visible = false;
  }

  function submitForm() {
    formRef.value?.validate((valid: boolean) => {

      if (!valid) return;
      state.loadding = true;
      request({
        url: `${state.tableName}/register`,
        method: 'post',
        data: state.formData
      }).then(({data}) => {
        notify("注册成功", {type: 'success'});
        state.loadding = false;
        close();

      })


    })

  }

  defineExpose({
    open
  })








                              
                        
                        
                        
                        
          
                              
                        
                        
                        
                        
          
      

</script>

<template>
  <el-dialog :title="''" v-model="visible"
             center draggable :before-close="close" width="550px"
             :close-on-click-modal="false" destroy-on-close
             class="register-dialog-custom">
    <div v-loading="loadding" class="register-card">
      <div class="register-title">注册</div>
      <el-form ref="formRef" :model="formData"
               label-width="85px" label-right="right"
               label-suffix=":" status-icon
               class="register-form">
                                                                                                                              <el-form-item v-if="tableName=='yonghu'" label="账号"
                                  prop="zhanghao"
                                  :rules="{required: true, message: '账号为必填项！', trigger: 'blur'}">
                      <div class="input-group-meetup">
                        <i class="fas fa-user input-icon-meetup"></i>
                        <el-input v-model="formData.zhanghao" maxlength="30" clearable show-word-limit
                                  placeholder="请输入账号" class="input-meetup"/>
                      </div>
                    </el-form-item>
                                                                      <el-form-item v-if="tableName=='yonghu'" label="密码"
                                  prop="mima"
                                  :rules="{required: true, message: '密码为必填项！', trigger: 'blur'}">
                      <div class="input-group-meetup">
                        <i class="fas fa-user input-icon-meetup"></i>
                        <el-input v-model="formData.mima" maxlength="30" clearable show-word-limit
                                  placeholder="请输入密码" class="input-meetup"/>
                      </div>
                    </el-form-item>
                                                                      <el-form-item v-if="tableName=='yonghu'" label="手机号"
                                  prop="shoujihao"
                                  :rules="{required: true, message: '手机号为必填项！', trigger: 'blur'}">
                      <div class="input-group-meetup">
                        <i class="fas fa-user input-icon-meetup"></i>
                        <el-input v-model="formData.shoujihao" maxlength="30" clearable show-word-limit
                                  placeholder="请输入手机号" class="input-meetup"/>
                      </div>
                    </el-form-item>
                                                                                                                                                              <el-form-item v-if="tableName=='xunlianrenyuan'" label="账号"
                                  prop="zhanghao"
                                  :rules="{required: true, message: '账号为必填项！', trigger: 'blur'}">
                      <div class="input-group-meetup">
                        <i class="fas fa-user input-icon-meetup"></i>
                        <el-input v-model="formData.zhanghao" maxlength="30" clearable show-word-limit
                                  placeholder="请输入账号" class="input-meetup"/>
                      </div>
                    </el-form-item>
                                                                      <el-form-item v-if="tableName=='xunlianrenyuan'" label="密码"
                                  prop="mima"
                                  :rules="{required: true, message: '密码为必填项！', trigger: 'blur'}">
                      <div class="input-group-meetup">
                        <i class="fas fa-user input-icon-meetup"></i>
                        <el-input v-model="formData.mima" maxlength="30" clearable show-word-limit
                                  placeholder="请输入密码" class="input-meetup"/>
                      </div>
                    </el-form-item>
                                                                      <el-form-item v-if="tableName=='xunlianrenyuan'" label="手机号"
                                  prop="shoujihao"
                                  :rules="{required: true, message: '手机号为必填项！', trigger: 'blur'}">
                      <div class="input-group-meetup">
                        <i class="fas fa-user input-icon-meetup"></i>
                        <el-input v-model="formData.shoujihao" maxlength="30" clearable show-word-limit
                                  placeholder="请输入手机号" class="input-meetup"/>
                      </div>
                    </el-form-item>
                                                </el-form>
      <div class="register-btns">
        <el-button @click="close" class="register-cancel">取 消</el-button>
        <el-button @click="submitForm" type="primary" class="register-submit">注 册</el-button>
      </div>
    </div>
  </el-dialog>
</template>

<style lang="scss" scoped>

  .register-dialog-custom .el-dialog__wrapper {
    border-radius: 25px;
    overflow: hidden;
    background: transparent !important;
  }

  .register-dialog-custom .el-overlay {
    border-radius: 25px;
    overflow: hidden;
  }

  .register-dialog-custom .el-dialog,
  .register-card {
    border-radius: 25px !important;
  }

  .register-card {
    overflow: hidden;
    max-height: none;
  }

  .register-dialog-custom .el-dialog {
    border-radius: 25px !important;
    overflow: hidden;
  }

  .register-dialog-custom .el-dialog__body {
    border-radius: 25px !important;
    background: rgba(255, 255, 255, 0.85) !important;
    backdrop-filter: blur(15px);
    overflow: hidden;
    padding: 0;
    border: 2px solid rgba(255, 255, 255, 0.3);
  }

  .register-card {
    background: rgba(255, 255, 255, 0.85);
    backdrop-filter: blur(15px);
    border-radius: 25px;
    box-shadow: 0 25px 50px rgba(0, 0, 0, 0.15);
    margin: 0;
    padding: 60px 50px 50px 50px;
    width: 100%;
    height: auto;
    max-width: 550px;
    max-height: none;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    border: 2px solid rgba(255, 255, 255, 0.3);
  }

  .register-title {
    font-size: 2.5rem;
    font-weight: 800;
    color: #2d1b69;
    margin-bottom: 30px;
    letter-spacing: 2px;
    text-align: center;
    font-family: 'Microsoft YaHei', Arial, sans-serif;
    text-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }

  .register-form {
    width: 100%;
    display: flex;
    flex-direction: column;
    gap: 20px;
  }

  .register-input .el-input__inner,
  .register-input {
    width: 100%;
    height: 55px;
    border-radius: 15px;
    border: 2px solid #e0e0e0;
    background: rgba(255, 255, 255, 0.8);
    font-size: 1.1rem;
    padding: 0 25px;
    outline: none;
    transition: all 0.3s ease;
    box-shadow: 0 3px 10px rgba(0, 0, 0, 0.08);
  }

  .register-input .el-input__inner:focus,
  .register-input:focus {
    border-color: #5b4b8a;
    box-shadow: 0 5px 15px rgba(91, 75, 138, 0.2);
    transform: translateY(-2px);
  }

  .register-btns {
    display: flex;
    justify-content: center;
    gap: 20px;
    margin-top: 25px;
    margin-bottom: 0;
    width: 100%;
    position: static;
  }

  .register-cancel, .register-submit {
    width: 140px;
    height: 50px;
    border-radius: 15px;
    font-size: 1.1rem;
    font-weight: 700;
    letter-spacing: 1px;
    margin: 0 8px;
    cursor: pointer;
    transition: all 0.3s ease;
    text-transform: uppercase;
  }

  .register-cancel {
    background: rgba(255, 255, 255, 0.8);
    color: #5b4b8a;
    border: 3px solid #5b4b8a;
    box-shadow: 0 5px 15px rgba(91, 75, 138, 0.1);
  }

  .register-cancel:hover {
    background: #5b4b8a;
    color: white;
    transform: translateY(-3px);
    box-shadow: 0 8px 20px rgba(91, 75, 138, 0.3);
  }

  .register-submit {
    background: linear-gradient(135deg, #5b4b8a, #7c5ac2);
    color: white;
    border: none;
    box-shadow: 0 8px 20px rgba(91, 75, 138, 0.3);
  }

  .register-submit:hover {
    transform: translateY(-3px);
    box-shadow: 0 12px 25px rgba(91, 75, 138, 0.4);
    background: linear-gradient(135deg, #4a3b7a, #6b4ab2);
  }

  .avatar-uploader {
    border: 3px solid #e0e0e0;
    border-radius: 15px;
    margin-bottom: 1rem;
    background: rgba(255, 255, 255, 0.8);
    transition: all 0.3s ease;
  }

  .avatar-uploader:hover {
    border-color: #5b4b8a;
    box-shadow: 0 5px 15px rgba(91, 75, 138, 0.2);
  }

  .avatar-uploader .el-upload {
    border: 3px dashed #e0e0e0;
    border-radius: 15px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    transition: all 0.3s ease;
    background: rgba(255, 255, 255, 0.8);
  }

  .avatar-uploader .el-upload:hover {
    border-color: #5b4b8a;
    box-shadow: 0 5px 15px rgba(91, 75, 138, 0.2);
  }

  .el-icon.avatar-uploader-icon {
    font-size: 28px;
    color: #5b4b8a;
    width: 100px;
    height: 100px;
    text-align: center;
    line-height: 100px;
  }
</style>