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
import com.entity.DiscussxunlianyingxinxiEntity;
import com.entity.view.DiscussxunlianyingxinxiView;
import com.service.DiscussxunlianyingxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;
/**
 * 训练营信息评论Controller
 *后端接口
 */
@RestController
@RequestMapping("/discussxunlianyingxinxi")
public class DiscussxunlianyingxinxiController {

    @Autowired
    private DiscussxunlianyingxinxiService discussxunlianyingxinxiService;



    
    
            /**
         * 后端列表
         */
                @RequestMapping("/page")
        public R page(@RequestParam Map<String, Object> params, DiscussxunlianyingxinxiEntity discussxunlianyingxinxi, HttpServletRequest request) {
                                    EntityWrapper<DiscussxunlianyingxinxiEntity> ew = new EntityWrapper<DiscussxunlianyingxinxiEntity>();
            PageUtils page = discussxunlianyingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxunlianyingxinxi), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 前端列表
         */
                @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params, DiscussxunlianyingxinxiEntity discussxunlianyingxinxi, HttpServletRequest request) {

         

                                    EntityWrapper<DiscussxunlianyingxinxiEntity> ew = new EntityWrapper<DiscussxunlianyingxinxiEntity>();
            PageUtils page = discussxunlianyingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxunlianyingxinxi), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 列表
         */
                @RequestMapping("/lists")
        public R list( DiscussxunlianyingxinxiEntity discussxunlianyingxinxi) {
            EntityWrapper<DiscussxunlianyingxinxiEntity> ew = new EntityWrapper<DiscussxunlianyingxinxiEntity>();
            ew.allEq(MPUtil.allEQMapPre( discussxunlianyingxinxi, "discussxunlianyingxinxi"));
            return R.ok().put("data", discussxunlianyingxinxiService.selectListView(ew));
        }

        /**
         * 查询
         */
                @RequestMapping("/query")
        public R query(DiscussxunlianyingxinxiEntity discussxunlianyingxinxi) {
            EntityWrapper< DiscussxunlianyingxinxiEntity> ew = new EntityWrapper< DiscussxunlianyingxinxiEntity>();
            ew.allEq(MPUtil.allEQMapPre( discussxunlianyingxinxi, "Discussxunlianyingxinxi"));
            DiscussxunlianyingxinxiView discussxunlianyingxinxiView = discussxunlianyingxinxiService.selectView(ew);
            return R.ok("训练营信息评论").put("data", discussxunlianyingxinxiView);
        }

        /**
             * 后端详情
             */
                @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Long id) {
            DiscussxunlianyingxinxiEntity discussxunlianyingxinxi = discussxunlianyingxinxiService.selectById(id);
            return R.ok().put("data", discussxunlianyingxinxi);
        }

        /**
            * 前端详情
            */
                @RequestMapping("/detail/{id}")
        public R detail(@PathVariable("id") Long id) {
            DiscussxunlianyingxinxiEntity discussxunlianyingxinxi = discussxunlianyingxinxiService.selectById(id);
                        return R.ok().put("data", discussxunlianyingxinxi);
        }

        /**
        * 后端保存
        */
                @RequestMapping("/save")
        public R save(@RequestBody DiscussxunlianyingxinxiEntity discussxunlianyingxinxi, HttpServletRequest request) {
            
        
            discussxunlianyingxinxi.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(address);
                            discussxunlianyingxinxiService.insert(discussxunlianyingxinxi);
            return R.ok();
        }

        /**
            * 前端保存
            */
                @RequestMapping("/add")
        public R add(@RequestBody DiscussxunlianyingxinxiEntity discussxunlianyingxinxi, HttpServletRequest request) {
                                discussxunlianyingxinxi.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(yiyuanjianjie);

                discussxunlianyingxinxiService.insert(discussxunlianyingxinxi);
            return R.ok();
        }

        /**
          * 修改
          */
                @RequestMapping("/update")
        public R update(@RequestBody DiscussxunlianyingxinxiEntity discussxunlianyingxinxi, HttpServletRequest request) {
            //ValidatorUtils.validateEntity(zaixianbaoming);
                discussxunlianyingxinxiService.updateById(discussxunlianyingxinxi);//全部更新
            return R.ok();
        }

        /**
         * 删除
         */
                @RequestMapping("/delete")
        public R delete(@RequestBody Long[] ids) {
            discussxunlianyingxinxiService.deleteBatchIds(Arrays.asList(ids));
            return R.ok();
        }
    

    
    





    
}
