
<script setup lang='ts'>

import { defineProps,ref,reactive,toRefs,toRaw,onMounted,watch,onUpdated } from 'vue';
const props = defineProps({
  datalist: {
    type: Array,
    default() {
      return []
    }
  },
  tablename:{
	type:String,
	default(){
		return ""
	}
  }
 
})


watch(() => props.datalist, (newVal: any) => {

   state.dataList = newVal;

})

onMounted(()=>{
    $(".pro-new-show").slide({
				mainCell: ".pro-list ul",
				titCell:".pagination ul",
				autoPage: true,
				effect: "left",
				autoPlay: false,
				vis: 3,
				trigger: "click"
	});
})

onUpdated(()=>{
            $(".pro-new-show").slide({
				mainCell: ".pro-list ul",
				titCell:".pagination ul",
				autoPage: true,
				effect: "left",
				autoPlay: false,
				vis: 3,
				trigger: "click"
	});
})


const state=reactive({
    dataList:props.datalist,
	tablename:props.tablename
})



const {dataList,tablename} =toRefs(state);
console.log("子组件："+state.tablename);
// console.log("子组件执行:"+props.datalist)

</script>

<template>
  

  <div class="pro-new">
			<div class="container">
				<div class="pro-new-show">
					<!--新品列表-->
					<div class="pro-list">
						<ul>
							<li v-for="(item, index) in dataList" :key="item.id">
								<div  v-for="(value, key, ind) in item" :key="ind">
								<router-link :to="`/${tablename}detail/`+item.id">
								<a href="#">
									
										<div class="img" v-show="ind == 3">
										<img :src="value" />
									</div>
									

									<div class="desc" v-show="ind == 2">
										<p class="p-title">{{value}}</p>

									</div>
								</a>
							
							</router-link>
						</div>
							</li>
						
							
						</ul>
					</div>
					<!--轮播左右箭头-->
					<div class="arrow">
						<a class="prev" href="javascript:void(0)"></a>
						<a class="next" href="javascript:void(0)"></a>
					</div>
					
				</div>
			</div>
		</div>
   


</template>

<style  scoped>
*{margin: 0;padding: 0;font-family: "微软雅黑";font-weight: normal;list-style:none;font-style:normal;text-decoration:none}
.container{width: 1200px;margin: 0 auto;}
/*新品展示*/
.pro-new{width: 100%;height: auto;overflow: hidden;padding: 35px 0 45px 0;background: #f3f1ff;}
.pro-new .title{font-size: 34px;text-align: center;padding-bottom: 5px;color: #333333;letter-spacing: 1px;}
.pro-new .sub-title{font-size: 20px;text-align: center;color: #333333;}
.pro-new .sub-title span{display: inline-block;height: 30px;line-height: 30px;width: auto;}
.pro-new .sub-title span.text{padding: 0 10px;}
.pro-new-show {position: relative;width: 100%;height: auto;overflow: hidden;}
.pro-new-show .pro-list{width: 100%;height: auto;margin-top: 30px;overflow: hidden;}
.pro-new-show .pro-list ul li{float: left;width: 387px;height: auto;overflow: hidden;background: #FFFFFF;margin-right: 19px;}
.pro-new-show .pro-list ul li:last-child{margin-right: 0;}
.pro-new-show .pro-list ul li img{width: 100%;height: 291px;}
.pro-new-show .pro-list ul li .desc{padding: 10px 20px;box-sizing: border-box;}
.pro-new-show .pro-list ul li .desc .p-title{font-size: 16px;color: #323232;padding-bottom: 5px;}
.pro-new-show .pro-list ul li .desc .p-desc{font-size: 14px;color: #969696;line-height: 25px;}
.pro-new-show .arrow a{display: inline-block;position: absolute;width: 49px;height: 100px;z-index: 2;}
.pro-new-show .arrow a.prev{left: 0;top: 50%;margin-top: -100px;background: url(@/assets/img/arrow-left.png) center center no-repeat;}
.pro-new-show .arrow a.next{right: 0;top: 50%;margin-top: -100px;background: url(@/assets/img/arrow-right.png) center center no-repeat;}
.pro-new-show .arrow a:hover{background-color: rgba(0,0,0,.3);}
.pro-new-show .pagination{position: relative;width: 100%;height: auto;overflow: hidden;padding-top: 40px;text-align: center;}
.pro-new-show .pagination ul li{width: 15px;height: 15px;border-radius: 100%;background: #FFFFFF;display: inline-block;margin: 0 8px;text-indent:-9999px; }
.pro-new-show .pagination ul li.on{background: #2069ff;}
</style>
