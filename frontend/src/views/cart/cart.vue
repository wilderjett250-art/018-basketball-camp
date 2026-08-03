<template>
    <div>
       <el-dialog title="购物车" v-model="open" append-to-body :close-on-click-modal="false" :close-on-press-escape="false">
        <div class="cart">
        <h1>购物车</h1>
        <div class="cart-item" v-for="(item,index) in dataList" :key="index">
            <img :src="item.picture" alt="商品图片">
            <div class="item-details">
                <h3>{{ item.goodname }}</h3>
                <!-- <p>描述：{{ item. }}</p> -->
            </div>
            <div class="quantity">
                <button @click="reduceCartNum(index)">-</button>
                <input type="text" v-model="item.buynumber" readonly>
                <button @click="addCartNum(index)">+</button>
            </div>
            <div class="item-price">{{item.price}}</div>
            <button class="remove-item" @click="deleteCart(index)">删除</button>
        </div>

 
    
        <div class="cart-total">
            总计：¥<span id="total" >{{totalPrice}}</span>
        </div>
        <div class="cart-total">
           <el-button type="danger" style="width: 150px;" @click="onform()">结算</el-button>
        </div>
    </div>

</el-dialog>
    
     <OrdersFrom ref="ordersRef"></OrdersFrom>

</div>
</template>

<script setup>
import { defineAsyncComponent,reactive,ref,toRefs,computed } from 'vue';
import { toRaw } from "@vue/reactivity";
import { Key } from '@/stores/auth';
import { Session } from '@/utils/storage';
import request from "@/utils/request";
import {notify,confirm} from '@/utils/element';
import { isAuth } from '@/utils/utils'
import { ElLoading } from 'element-plus'
const OrdersFrom=defineAsyncComponent(()=>import('@/views/orders/orderfrom.vue'));
     const state=reactive({
         open:false,
         dataList:[],
         user:{},
         total:0,
         openOrdersDialog:false,
         detailTable: '${tableName}',
     })


const {open,dataList,user,total,openOrdersDialog,detailTable} = {...toRefs(state)};

    const totalPrice=computed(()=>{
        state.total=0;

            for (var item of state.dataList) {

                state.total += item.price * item.buynumber
            }
                 return state.total;
    })
    // computed: {
    //
    //         totalPrice: function() {
    //
    //
    //         }
    //     },


let sessionTable = Session.get("tableName")
    request({
        url: sessionTable + '/session',
        method: "get"
    }).then((data) => {
        if (data && data.code === 0) {
        state.user = data.data;
        console.log("用户ID:"+state.user.id)
    } else {
    notify(data.msg,{type:'error'});
    }
});



  function getlist(){
           request({
    url:"cart/list",
    method:'get',
    params:{
            page: 1,
            limit: 100,
            userid: state.user.id
    }
   }).then((data) => {
        if (data && data.code === 0) {
        state.dataList = data.data.list;

       
    } else {
          notify(data.msg,{type:'error'});
    }
})
   }
 


             // 添加数量
            function addCartNum(index) {
                // 查询对应的商品的详情信息，判断是否有商品限次，库存的判断
                 var item = state.dataList[index];
                    request({
                    url:`${item.tablename}/info/${item.goodid}`,
                    method:"get"

                 }).then((data) => {

                  
            if (data && data.code === 0) {

                if (data.data.onelimittimes && data.data.onelimittimes > 0 && data.data.onelimittimes <= item.buynumber) {


                    notify(`每人单次只能购买${data.data.onelimittimes}次`,{type:'error'});
                        return
                    }else{
                     
                    }

                    if (data.data.alllimittimes && data.data.alllimittimes > 0 && data.data.alllimittimes <= item.buynumber) {
                        notify(`商品已售罄`,{type:'error'});
                        return
                    }   
                    item.buynumber = item.buynumber + 1;


                         request({
                    url:`cart/update`,
                    method:"post",
                    data:item
                  }).then((data) => {
            if (data && data.code === 0) {
            
        } else {
                        notify(data.msg,{type:'error'});
        }
    });

            
        } else {
                    notify(data.msg,{type:'error'});
        }
    });
                 
    
    
      
           
           
                }



        // 减少数量
       function reduceCartNum(index) {
                var item = state.dataList[index];
                if (item.buynumber > 1) {
                    item.buynumber = item.buynumber - 1;
                       request({
                    url:`cart/update`,
                    method:"post",
                    data:item
                  }).then((data) => {
            if (data && data.code === 0) {
            
        } else {
                        notify(data.msg,{type:'error'});
        }
    });
                }
            }
  
 // 删除
 function deleteCart(index) {
                var item = state.dataList[index];
        request({
                    url:`cart/delete`,
                    method:"post",
                    data:[item.id]
                  }).then((data) => {
            if (data && data.code === 0) {
                getlist()
        } else {
         notify(data.msg,{type:'error'});
        }
    });
            }


function openinit(){
   state.open=true;
    state.total=0;
    getlist();


}

const ordersRef=ref();
 function onform(){
      state.open=false;

     ordersRef.value.openordersinit();

 }




defineExpose({
    openinit
})
















</script>


<style scoped>

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f9f9f9;
            color: #333;
        }
        .cart {
            /* width: 80%;
            max-width: 800px; */
            margin: 0 auto;
            background: #fff;
            padding: 30px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        .cart h1 {
            text-align: center;
            margin-bottom: 30px;
            font-size: 28px;
            color: #444;
        }
        .cart-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px 0;
            border-bottom: 1px solid #eee;
        }
        .cart-item:last-child {
            border-bottom: none;
        }
        .cart-item img {
            width: 80px;
            height: 80px;
            margin-right: 20px;
            border-radius: 8px;
        }
        /* .cart-item .item-details {
            flex: 1;
        } */
        .cart-item .item-details h3 {
            margin: 0;
            font-size: 20px;
            color: #333;
        }
        .cart-item .item-details p {
            margin: 5px 0 0;
            font-size: 14px;
            color: #777;
        }
        .cart-item .item-price {
            font-size: 20px;
            font-weight: bold;
            color: #e74c3c;
        }
        .cart-item .quantity {
            display: flex;
            align-items: center;
            border: 1px solid #ddd;
            border-radius: 5px;
            overflow: hidden;
        }
        .cart-item .quantity button {
            width: 40px;
            height: 40px;
            border: none;
            background: #f1f1f1;
            cursor: pointer;
            font-size: 18px;
            color: #555;
            transition: background 0.3s, color 0.3s;
        }
        .cart-item .quantity button:hover {
            background: #ddd;
            color: #333;
        }
        .cart-item .quantity input {
            width: 50px;
            height: 40px;
            text-align: center;
            border: none;
            font-size: 16px;
            color: #333;
        }
        .cart-item .remove-item {
            background: #e74c3c;
            color: #fff;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            transition: background 0.3s;
        }
        .cart-item .remove-item:hover {
            background: #c0392b;
        }
        .cart-total {
            text-align: right;
            margin-top: 30px;
            font-size: 24px;
            font-weight: bold;
            color: #333;
        }
        .cart-total span {
            color: #e74c3c;
        }
  
</style>