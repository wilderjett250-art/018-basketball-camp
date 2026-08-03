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
import com.entity.DiscussbisaiguanliEntity;
import com.entity.view.DiscussbisaiguanliView;
import com.service.DiscussbisaiguanliService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;
/**
 * 比赛管理评论Controller
 *后端接口
 */
@RestController
@RequestMapping("/discussbisaiguanli")
public class DiscussbisaiguanliController {

    @Autowired
    private DiscussbisaiguanliService discussbisaiguanliService;



    
    
            /**
         * 后端列表
         */
                @RequestMapping("/page")
        public R page(@RequestParam Map<String, Object> params, DiscussbisaiguanliEntity discussbisaiguanli, HttpServletRequest request) {
                                    EntityWrapper<DiscussbisaiguanliEntity> ew = new EntityWrapper<DiscussbisaiguanliEntity>();
            PageUtils page = discussbisaiguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussbisaiguanli), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 前端列表
         */
                @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params, DiscussbisaiguanliEntity discussbisaiguanli, HttpServletRequest request) {

         

                                    EntityWrapper<DiscussbisaiguanliEntity> ew = new EntityWrapper<DiscussbisaiguanliEntity>();
            PageUtils page = discussbisaiguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussbisaiguanli), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 列表
         */
                @RequestMapping("/lists")
        public R list( DiscussbisaiguanliEntity discussbisaiguanli) {
            EntityWrapper<DiscussbisaiguanliEntity> ew = new EntityWrapper<DiscussbisaiguanliEntity>();
            ew.allEq(MPUtil.allEQMapPre( discussbisaiguanli, "discussbisaiguanli"));
            return R.ok().put("data", discussbisaiguanliService.selectListView(ew));
        }

        /**
         * 查询
         */
                @RequestMapping("/query")
        public R query(DiscussbisaiguanliEntity discussbisaiguanli) {
            EntityWrapper< DiscussbisaiguanliEntity> ew = new EntityWrapper< DiscussbisaiguanliEntity>();
            ew.allEq(MPUtil.allEQMapPre( discussbisaiguanli, "Discussbisaiguanli"));
            DiscussbisaiguanliView discussbisaiguanliView = discussbisaiguanliService.selectView(ew);
            return R.ok("比赛管理评论").put("data", discussbisaiguanliView);
        }

        /**
             * 后端详情
             */
                @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Long id) {
            DiscussbisaiguanliEntity discussbisaiguanli = discussbisaiguanliService.selectById(id);
            return R.ok().put("data", discussbisaiguanli);
        }

        /**
            * 前端详情
            */
                @RequestMapping("/detail/{id}")
        public R detail(@PathVariable("id") Long id) {
            DiscussbisaiguanliEntity discussbisaiguanli = discussbisaiguanliService.selectById(id);
                        return R.ok().put("data", discussbisaiguanli);
        }

        /**
        * 后端保存
        */
                @RequestMapping("/save")
        public R save(@RequestBody DiscussbisaiguanliEntity discussbisaiguanli, HttpServletRequest request) {
            
        
            discussbisaiguanli.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(address);
                            discussbisaiguanliService.insert(discussbisaiguanli);
            return R.ok();
        }

        /**
            * 前端保存
            */
                @RequestMapping("/add")
        public R add(@RequestBody DiscussbisaiguanliEntity discussbisaiguanli, HttpServletRequest request) {
                                discussbisaiguanli.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(yiyuanjianjie);

                discussbisaiguanliService.insert(discussbisaiguanli);
            return R.ok();
        }

        /**
          * 修改
          */
                @RequestMapping("/update")
        public R update(@RequestBody DiscussbisaiguanliEntity discussbisaiguanli, HttpServletRequest request) {
            //ValidatorUtils.validateEntity(zaixianbaoming);
                discussbisaiguanliService.updateById(discussbisaiguanli);//全部更新
            return R.ok();
        }

        /**
         * 删除
         */
                @RequestMapping("/delete")
        public R delete(@RequestBody Long[] ids) {
            discussbisaiguanliService.deleteBatchIds(Arrays.asList(ids));
            return R.ok();
        }
    

    
    





    
}
