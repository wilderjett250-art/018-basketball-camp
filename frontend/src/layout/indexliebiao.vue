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

onUpdated(()=>{
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



	<div class="content">
		<ul class="contentbox">
			<li class="con" v-for="item in dataList" :key="item.id">

				<div  v-for="(value, key, ind) in item" :key="ind">
				<router-link :to="`/${tablename}detail/`+item.id">
				<img  v-show="ind == 3" :src="value" alt="con1"/>
				<div class="txt" v-show="ind == 2">
					<h3>{{value}}</h3>
				</div>
			</router-link>
		       </div>
			</li>
		</ul>
	</div>


  
</template>

<style  scoped>

@charset "utf-8";
*{padding: 0; margin: 0;}
img{border: none;}
ol,ul,li{list-style: none;}
a{text-decoration: none;}
body{ font-family: "微软雅黑";}

/*----------- 遮罩内容区 开始------------------------------------*/
/*----------- 从底部上升的遮罩效果 开始---------------------------*/
.content-title{
	margin-top: 50px;
	text-align: center;
}
.content{
	width:1200px;
	height: 428px;
	margin:20px auto;
	padding: 15px 25px 15px 25px;
}
.con{
	width: 345px;
	height: 198px;
	float: left;
	margin-right: 35px;
	margin-bottom: 15px;
	position: relative;
	cursor: pointer;
}
.con img{
	width:345px;
	height: 198px;
}
.txt{
	position: absolute;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 45px;
	line-height: 45px;
	text-align: center;
	color: #fff;
	background: rgba(0,0,0,0.6);
}
.txt h3{
	font-weight: normal;
}
.txt p{
	font-size: 14px;
	display: block;
	line-height: 20px;
	-webkit-margin-before: 1em;
	-webkit-margin-after: 1em;
	-webkit-margin-start: 0px;
	-webkit-margin-end: 0px;
	-moz-margin-before: 1em;
	-moz-margin-after: 1em;
	-moz-margin-start: 0px;
	-moz-margin-end: 0px;
}


</style>
