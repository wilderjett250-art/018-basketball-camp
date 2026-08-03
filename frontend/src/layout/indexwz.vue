<script setup lang='ts'>

import { defineProps,ref,reactive,toRefs,toRaw,onMounted,watch } from 'vue';
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

onMounted(()=>{
    	//从底部上升的遮罩效果开始
	$(".con").hover(function(){
		$(this).find(".txt").stop().animate({height:"198px"},200);
		$(this).find(".txt h3").stop().animate({paddingTop:"60px"},200);
	},function(){
		$(this).find(".txt").stop().animate({height:"45px"},200);
		$(this).find(".txt h3").stop().animate({paddingTop:"0px"},200);
	})
	//从底部上升的遮罩效果结束
})

const state=reactive({
    dataList:props.datalist,
	tablename:props.tablename
})
watch(() => props.datalist, (newVal: any) => {
      state.dataList = newVal;
     
    })
const {dataList,tablename} =toRefs(state);
console.log("子组件："+state.tablename);
</script>

<template>


    <div class="block news">
	<div class="items">
		<ul>
			<li v-for="item in dataList" :key="item.id">
				<router-link :to="`/${tablename}detail/`+item.id">
				<a href="#">
					<div v-for="(value, key, ind) in item" :key="ind" v-show="ind == 3" class="items-l"><img :src="value" /></div>
					<div class="items-r">
						<p class="title" v-for="(value, key, ind) in item" :key="ind" v-show="ind == 2">{{value}}</p>
						<!-- <p class="time"  v-for="(value, key, ind) in item" :key="ind" v-show="ind == 1">{{value}}</p> -->
					</div>
				</a>
			</router-link>
			</li>
			
		</ul>
	</div>



  </div>
</template>

<style  scoped>
*{margin: 0;padding: 0;border: 0;list-style: none;text-decoration: none;color: inherit;font-weight: normal;font-family: "微软雅黑";box-sizing: border-box;}
body{min-width: 1440px;}
img{vertical-align: middle;max-width: 100%;}
/*公共头部*/
.block h2.title{font-size: 30px;color: #333333;padding-bottom: 8px;position: relative;text-align: center;}
.block p.sub-title{font-size: 14px;color: #999999;text-align: center;}
.block h2.title:after{display: block;content: "";position: absolute;width: 70px;height: 3px;background: #4c80e7;bottom: -30px;left: 50%;transform: translateX(-50%);}
/*资讯*/
.news{width: 100%;height: auto;overflow: hidden;padding: 90px 0 80px;}
.news .items{padding-top: 70px;width: 100%;height: auto;overflow: hidden;}
.news .items ul{width: 1200px;margin: 0 auto;display: flex;justify-content: space-between;flex-wrap: wrap;}
.news .items ul li{width: 48.5%;background: rgba(255,255,255,.9);border-radius: 5px;margin-bottom: 40px;}
.news .items ul li a{display: block;width: 100%;height: 100%;display: flex;align-items: center;transition: all .3s;}
.news .items ul li a:hover{transform: translateY(-5px);transition: all .3s;}
.news .items ul li a:hover .items-r .title{color: #4c80e7;}
.news .items ul li .items-l {width: 250px;height: 130px;flex-shrink: 0;}
.news .items ul li .items-l img{display: inline-block;width: 100%;height: 100%;}
.news .items ul li .items-r{padding-left: 20px;}
.news .items ul li .items-r .title{font-size: 18px;color: #333333;padding-bottom: 10px;}
.news .items ul li .items-r .time{font-size: 12px;color: #999999;padding-bottom: 10px;}
.news .items ul li .items-r .desc{font-size: 14px;color: #666666;line-height: 20px;}
.news .more{text-align: center;}
.news .more a{display: inline-block;width: 120px;height: 34px;border: 1px solid #4c80e7;background: #4c80e7;border-radius: 3px;line-height: 34px;text-align: center;font-size: 14px;color: #FFFFFF;margin: 20px 0;}
/*按钮动画效果*/
.btn{transition: all .3s;}
.btn:hover{transform: scale(0.9);transition: all .3s;}
</style>
