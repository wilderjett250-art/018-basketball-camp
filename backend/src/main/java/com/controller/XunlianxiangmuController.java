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
import com.entity.XunlianxiangmuEntity;
import com.entity.view.XunlianxiangmuView;
import com.service.XunlianxiangmuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;
/**
 * 训练项目Controller
 *后端接口
 */
@RestController
@RequestMapping("/xunlianxiangmu")
public class XunlianxiangmuController {

    @Autowired
    private XunlianxiangmuService xunlianxiangmuService;



    
    
            /**
         * 后端列表
         */
                @RequestMapping("/page")
        public R page(@RequestParam Map<String, Object> params, XunlianxiangmuEntity xunlianxiangmu, HttpServletRequest request) {
                            if (!request.getSession().getAttribute("role").toString().equals("管理员")) {
                    xunlianxiangmu.setUserid((Long) request.getSession().getAttribute("userId"));
                }
                                    EntityWrapper<XunlianxiangmuEntity> ew = new EntityWrapper<XunlianxiangmuEntity>();
            PageUtils page = xunlianxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunlianxiangmu), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 前端列表
         */
                @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params, XunlianxiangmuEntity xunlianxiangmu, HttpServletRequest request) {

         

                            xunlianxiangmu.setSfsh("是");
                                    EntityWrapper<XunlianxiangmuEntity> ew = new EntityWrapper<XunlianxiangmuEntity>();
            PageUtils page = xunlianxiangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunlianxiangmu), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 列表
         */
                @RequestMapping("/lists")
        public R list( XunlianxiangmuEntity xunlianxiangmu) {
            EntityWrapper<XunlianxiangmuEntity> ew = new EntityWrapper<XunlianxiangmuEntity>();
            ew.allEq(MPUtil.allEQMapPre( xunlianxiangmu, "xunlianxiangmu"));
            return R.ok().put("data", xunlianxiangmuService.selectListView(ew));
        }

        /**
         * 查询
         */
                @RequestMapping("/query")
        public R query(XunlianxiangmuEntity xunlianxiangmu) {
            EntityWrapper< XunlianxiangmuEntity> ew = new EntityWrapper< XunlianxiangmuEntity>();
            ew.allEq(MPUtil.allEQMapPre( xunlianxiangmu, "Xunlianxiangmu"));
            XunlianxiangmuView xunlianxiangmuView = xunlianxiangmuService.selectView(ew);
            return R.ok("训练项目").put("data", xunlianxiangmuView);
        }

        /**
             * 后端详情
             */
                @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Long id) {
            XunlianxiangmuEntity xunlianxiangmu = xunlianxiangmuService.selectById(id);
            return R.ok().put("data", xunlianxiangmu);
        }

        /**
            * 前端详情
            */
                @RequestMapping("/detail/{id}")
        public R detail(@PathVariable("id") Long id) {
            XunlianxiangmuEntity xunlianxiangmu = xunlianxiangmuService.selectById(id);
                        return R.ok().put("data", xunlianxiangmu);
        }

        /**
        * 后端保存
        */
                @RequestMapping("/save")
        public R save(@RequestBody XunlianxiangmuEntity xunlianxiangmu, HttpServletRequest request) {
            
        
            xunlianxiangmu.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(address);
                            xunlianxiangmu.setUserid((Long) request.getSession().getAttribute("userId"));
                            xunlianxiangmuService.insert(xunlianxiangmu);
            return R.ok();
        }

        /**
            * 前端保存
            */
                @RequestMapping("/add")
        public R add(@RequestBody XunlianxiangmuEntity xunlianxiangmu, HttpServletRequest request) {
                    
            xunlianxiangmu.setUserid((Long) request.getSession().getAttribute("userId"));

                        xunlianxiangmu.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(yiyuanjianjie);

                xunlianxiangmuService.insert(xunlianxiangmu);
            return R.ok();
        }

        /**
          * 修改
          */
                @RequestMapping("/update")
        public R update(@RequestBody XunlianxiangmuEntity xunlianxiangmu, HttpServletRequest request) {
            //ValidatorUtils.validateEntity(zaixianbaoming);
                xunlianxiangmuService.updateById(xunlianxiangmu);//全部更新
            return R.ok();
        }

        /**
         * 删除
         */
                @RequestMapping("/delete")
        public R delete(@RequestBody Long[] ids) {
            xunlianxiangmuService.deleteBatchIds(Arrays.asList(ids));
            return R.ok();
        }
    

    
    





    
}
