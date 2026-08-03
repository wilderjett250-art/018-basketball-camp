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
import com.entity.BisaiguanliEntity;
import com.entity.view.BisaiguanliView;
import com.service.BisaiguanliService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;
/**
 * 比赛管理Controller
 *后端接口
 */
@RestController
@RequestMapping("/bisaiguanli")
public class BisaiguanliController {

    @Autowired
    private BisaiguanliService bisaiguanliService;



    
    
            /**
         * 后端列表
         */
                @RequestMapping("/page")
        public R page(@RequestParam Map<String, Object> params, BisaiguanliEntity bisaiguanli, HttpServletRequest request) {
                                    EntityWrapper<BisaiguanliEntity> ew = new EntityWrapper<BisaiguanliEntity>();
            PageUtils page = bisaiguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bisaiguanli), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 前端列表
         */
                @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params, BisaiguanliEntity bisaiguanli, HttpServletRequest request) {

         

                                    EntityWrapper<BisaiguanliEntity> ew = new EntityWrapper<BisaiguanliEntity>();
            PageUtils page = bisaiguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, bisaiguanli), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 列表
         */
                @RequestMapping("/lists")
        public R list( BisaiguanliEntity bisaiguanli) {
            EntityWrapper<BisaiguanliEntity> ew = new EntityWrapper<BisaiguanliEntity>();
            ew.allEq(MPUtil.allEQMapPre( bisaiguanli, "bisaiguanli"));
            return R.ok().put("data", bisaiguanliService.selectListView(ew));
        }

        /**
         * 查询
         */
                @RequestMapping("/query")
        public R query(BisaiguanliEntity bisaiguanli) {
            EntityWrapper< BisaiguanliEntity> ew = new EntityWrapper< BisaiguanliEntity>();
            ew.allEq(MPUtil.allEQMapPre( bisaiguanli, "Bisaiguanli"));
            BisaiguanliView bisaiguanliView = bisaiguanliService.selectView(ew);
            return R.ok("比赛管理").put("data", bisaiguanliView);
        }

        /**
             * 后端详情
             */
                @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Long id) {
            BisaiguanliEntity bisaiguanli = bisaiguanliService.selectById(id);
            return R.ok().put("data", bisaiguanli);
        }

        /**
            * 前端详情
            */
                @RequestMapping("/detail/{id}")
        public R detail(@PathVariable("id") Long id) {
            BisaiguanliEntity bisaiguanli = bisaiguanliService.selectById(id);
                        return R.ok().put("data", bisaiguanli);
        }

        /**
        * 后端保存
        */
                @RequestMapping("/save")
        public R save(@RequestBody BisaiguanliEntity bisaiguanli, HttpServletRequest request) {
            
        
            bisaiguanli.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(address);
                            bisaiguanliService.insert(bisaiguanli);
            return R.ok();
        }

        /**
            * 前端保存
            */
                @RequestMapping("/add")
        public R add(@RequestBody BisaiguanliEntity bisaiguanli, HttpServletRequest request) {
                                bisaiguanli.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(yiyuanjianjie);

                bisaiguanliService.insert(bisaiguanli);
            return R.ok();
        }

        /**
          * 修改
          */
                @RequestMapping("/update")
        public R update(@RequestBody BisaiguanliEntity bisaiguanli, HttpServletRequest request) {
            //ValidatorUtils.validateEntity(zaixianbaoming);
                bisaiguanliService.updateById(bisaiguanli);//全部更新
            return R.ok();
        }

        /**
         * 删除
         */
                @RequestMapping("/delete")
        public R delete(@RequestBody Long[] ids) {
            bisaiguanliService.deleteBatchIds(Arrays.asList(ids));
            return R.ok();
        }
    

    
    





    
}
