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
import com.entity.CrkEntity;
import com.entity.view.CrkView;
import com.service.CrkService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;
/**
 * 出入库Controller
 *后端接口
 */
@RestController
@RequestMapping("/crk")
public class CrkController {

    @Autowired
    private CrkService crkService;



    
    
            /**
         * 后端列表
         */
                @RequestMapping("/page")
        public R page(@RequestParam Map<String, Object> params, CrkEntity crk, HttpServletRequest request) {
                                    EntityWrapper<CrkEntity> ew = new EntityWrapper<CrkEntity>();
            PageUtils page = crkService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, crk), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 前端列表
         */
                @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params, CrkEntity crk, HttpServletRequest request) {

         

                                    EntityWrapper<CrkEntity> ew = new EntityWrapper<CrkEntity>();
            PageUtils page = crkService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, crk), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 列表
         */
                @RequestMapping("/lists")
        public R list( CrkEntity crk) {
            EntityWrapper<CrkEntity> ew = new EntityWrapper<CrkEntity>();
            ew.allEq(MPUtil.allEQMapPre( crk, "crk"));
            return R.ok().put("data", crkService.selectListView(ew));
        }

        /**
         * 查询
         */
                @RequestMapping("/query")
        public R query(CrkEntity crk) {
            EntityWrapper< CrkEntity> ew = new EntityWrapper< CrkEntity>();
            ew.allEq(MPUtil.allEQMapPre( crk, "Crk"));
            CrkView crkView = crkService.selectView(ew);
            return R.ok("出入库").put("data", crkView);
        }

        /**
             * 后端详情
             */
                @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Long id) {
            CrkEntity crk = crkService.selectById(id);
            return R.ok().put("data", crk);
        }

        /**
            * 前端详情
            */
                @RequestMapping("/detail/{id}")
        public R detail(@PathVariable("id") Long id) {
            CrkEntity crk = crkService.selectById(id);
                        return R.ok().put("data", crk);
        }

        /**
        * 后端保存
        */
                @RequestMapping("/save")
        public R save(@RequestBody CrkEntity crk, HttpServletRequest request) {
            
        
            crk.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(address);
                            crkService.insert(crk);
            return R.ok();
        }

        /**
            * 前端保存
            */
                @RequestMapping("/add")
        public R add(@RequestBody CrkEntity crk, HttpServletRequest request) {
                                crk.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(yiyuanjianjie);

                crkService.insert(crk);
            return R.ok();
        }

        /**
          * 修改
          */
                @RequestMapping("/update")
        public R update(@RequestBody CrkEntity crk, HttpServletRequest request) {
            //ValidatorUtils.validateEntity(zaixianbaoming);
                crkService.updateById(crk);//全部更新
            return R.ok();
        }

        /**
         * 删除
         */
                @RequestMapping("/delete")
        public R delete(@RequestBody Long[] ids) {
            crkService.deleteBatchIds(Arrays.asList(ids));
            return R.ok();
        }
    

    
    





    
}
