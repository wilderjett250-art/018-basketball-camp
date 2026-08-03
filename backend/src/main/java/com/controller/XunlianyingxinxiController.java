package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.entity.UserEntity;
import com.utils.ValidatorUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
 import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.entity.XunlianyingxinxiEntity;
import com.entity.view.XunlianyingxinxiView;
import com.service.XunlianyingxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;
/**
 * 训练营信息Controller
 *后端接口
 */
@RestController
@RequestMapping("/xunlianyingxinxi")
public class XunlianyingxinxiController {

    @Autowired
    private XunlianyingxinxiService xunlianyingxinxiService;



    
    
            /**
         * 后端列表
         */
                @RequestMapping("/page")
        public R page(@RequestParam Map<String, Object> params, XunlianyingxinxiEntity xunlianyingxinxi, HttpServletRequest request) {
                                    EntityWrapper<XunlianyingxinxiEntity> ew = new EntityWrapper<XunlianyingxinxiEntity>();
            PageUtils page = xunlianyingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunlianyingxinxi), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 前端列表
         */
                @IgnoreAuth
                @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params, XunlianyingxinxiEntity xunlianyingxinxi, HttpServletRequest request) {

         

                                    EntityWrapper<XunlianyingxinxiEntity> ew = new EntityWrapper<XunlianyingxinxiEntity>();
            PageUtils page = xunlianyingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunlianyingxinxi), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 列表
         */
                @RequestMapping("/lists")
        public R list( XunlianyingxinxiEntity xunlianyingxinxi) {
            EntityWrapper<XunlianyingxinxiEntity> ew = new EntityWrapper<XunlianyingxinxiEntity>();
            ew.allEq(MPUtil.allEQMapPre( xunlianyingxinxi, "xunlianyingxinxi"));
            return R.ok().put("data", xunlianyingxinxiService.selectListView(ew));
        }

        /**
         * 查询
         */
                @RequestMapping("/query")
        public R query(XunlianyingxinxiEntity xunlianyingxinxi) {
            EntityWrapper< XunlianyingxinxiEntity> ew = new EntityWrapper< XunlianyingxinxiEntity>();
            ew.allEq(MPUtil.allEQMapPre( xunlianyingxinxi, "Xunlianyingxinxi"));
            XunlianyingxinxiView xunlianyingxinxiView = xunlianyingxinxiService.selectView(ew);
            return R.ok("训练营信息").put("data", xunlianyingxinxiView);
        }

        /**
             * 后端详情
             */
                @IgnoreAuth
                @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Long id) {
            XunlianyingxinxiEntity xunlianyingxinxi = xunlianyingxinxiService.selectById(id);
            return R.ok().put("data", xunlianyingxinxi);
        }

        /**
            * 前端详情
            */
                @IgnoreAuth
                @RequestMapping("/detail/{id}")
        public R detail(@PathVariable("id") Long id) {
            XunlianyingxinxiEntity xunlianyingxinxi = xunlianyingxinxiService.selectById(id);
                        return R.ok().put("data", xunlianyingxinxi);
        }

        /**
        * 后端保存
        */
                @RequestMapping("/save")
        public R save(@RequestBody XunlianyingxinxiEntity xunlianyingxinxi, HttpServletRequest request) {
            
        
            xunlianyingxinxi.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(address);
                            xunlianyingxinxiService.insert(xunlianyingxinxi);
            return R.ok();
        }

        /**
            * 前端保存
            */
                @RequestMapping("/add")
        public R add(@RequestBody XunlianyingxinxiEntity xunlianyingxinxi, HttpServletRequest request) {
                                xunlianyingxinxi.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(yiyuanjianjie);

                xunlianyingxinxiService.insert(xunlianyingxinxi);
            return R.ok();
        }

        /**
          * 修改
          */
                @RequestMapping("/update")
        public R update(@RequestBody XunlianyingxinxiEntity xunlianyingxinxi, HttpServletRequest request) {
            //ValidatorUtils.validateEntity(zaixianbaoming);
                xunlianyingxinxiService.updateById(xunlianyingxinxi);//全部更新
            return R.ok();
        }

        /**
         * 删除
         */
                @RequestMapping("/delete")
        public R delete(@RequestBody Long[] ids) {
            xunlianyingxinxiService.deleteBatchIds(Arrays.asList(ids));
            return R.ok();
        }
    

            /**
         * 推荐
         * @param userId
         * @param num
         * @return
         */
        @PostMapping("/recommendList")
        public R recommendList(@RequestParam("userId") Long userId, @RequestParam("num") Integer num) {
            Map<String, Double> map = xunlianyingxinxiService.recommend(userId, num);
            List<Map.Entry<String, Double>> entryList = new ArrayList<>(map.entrySet());
            // 使用Collections.sort()对List进行排序
            Collections.sort(entryList, (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
            // 提取排序后的键
            List<Long> sortedKeys = new ArrayList<>();
            for (Map.Entry<String, Double> entry : entryList) {
                if(entry.getValue() > 0) {
                    sortedKeys.add(Long.valueOf(entry.getKey()));
                }
            }
            if(sortedKeys.size() > 0) {
                return R.ok().put("data", xunlianyingxinxiService.selectBatchIds(sortedKeys));
            }
            return R.ok().put("data", null);
        }
    
    





    
}
