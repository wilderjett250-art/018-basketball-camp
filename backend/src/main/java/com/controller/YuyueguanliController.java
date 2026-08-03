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
import com.entity.YuyueguanliEntity;
import com.entity.view.YuyueguanliView;
import com.service.YuyueguanliService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;
/**
 * 预约管理Controller
 *后端接口
 */
@RestController
@RequestMapping("/yuyueguanli")
public class YuyueguanliController {

    @Autowired
    private YuyueguanliService yuyueguanliService;



    
    
            /**
         * 后端列表
         */
                @RequestMapping("/page")
        public R page(@RequestParam Map<String, Object> params, YuyueguanliEntity yuyueguanli, HttpServletRequest request) {
//                            if (!request.getSession().getAttribute("role").toString().equals("管理员")) {
//                    yuyueguanli.setUserid((Long) request.getSession().getAttribute("userId"));
//                }
                                    EntityWrapper<YuyueguanliEntity> ew = new EntityWrapper<YuyueguanliEntity>();
            PageUtils page = yuyueguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyueguanli), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 前端列表
         */
                @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params, YuyueguanliEntity yuyueguanli, HttpServletRequest request) {

         

                                    EntityWrapper<YuyueguanliEntity> ew = new EntityWrapper<YuyueguanliEntity>();
            PageUtils page = yuyueguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyueguanli), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 列表
         */
                @RequestMapping("/lists")
        public R list( YuyueguanliEntity yuyueguanli) {
            EntityWrapper<YuyueguanliEntity> ew = new EntityWrapper<YuyueguanliEntity>();
            ew.allEq(MPUtil.allEQMapPre( yuyueguanli, "yuyueguanli"));
            return R.ok().put("data", yuyueguanliService.selectListView(ew));
        }

        /**
         * 查询
         */
                @RequestMapping("/query")
        public R query(YuyueguanliEntity yuyueguanli) {
            EntityWrapper< YuyueguanliEntity> ew = new EntityWrapper< YuyueguanliEntity>();
            ew.allEq(MPUtil.allEQMapPre( yuyueguanli, "Yuyueguanli"));
            YuyueguanliView yuyueguanliView = yuyueguanliService.selectView(ew);
            return R.ok("预约管理").put("data", yuyueguanliView);
        }

        /**
             * 后端详情
             */
                @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Long id) {
            YuyueguanliEntity yuyueguanli = yuyueguanliService.selectById(id);
            return R.ok().put("data", yuyueguanli);
        }

        /**
            * 前端详情
            */
                @RequestMapping("/detail/{id}")
        public R detail(@PathVariable("id") Long id) {
            YuyueguanliEntity yuyueguanli = yuyueguanliService.selectById(id);
                        return R.ok().put("data", yuyueguanli);
        }

        /**
        * 后端保存
        */
                @RequestMapping("/save")
        public R save(@RequestBody YuyueguanliEntity yuyueguanli, HttpServletRequest request) {
            
        
            yuyueguanli.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(address);
                            yuyueguanli.setUserid((Long) request.getSession().getAttribute("userId"));
                            yuyueguanliService.insert(yuyueguanli);
            return R.ok();
        }

        /**
            * 前端保存
            */
                @RequestMapping("/add")
        public R add(@RequestBody YuyueguanliEntity yuyueguanli, HttpServletRequest request) {
                    
            yuyueguanli.setUserid((Long) request.getSession().getAttribute("userId"));

                        yuyueguanli.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(yiyuanjianjie);

                yuyueguanliService.insert(yuyueguanli);
            return R.ok();
        }

        /**
          * 修改
          */
                @RequestMapping("/update")
        public R update(@RequestBody YuyueguanliEntity yuyueguanli, HttpServletRequest request) {
            //ValidatorUtils.validateEntity(zaixianbaoming);
                yuyueguanliService.updateById(yuyueguanli);//全部更新
            return R.ok();
        }

        /**
         * 删除
         */
                @RequestMapping("/delete")
        public R delete(@RequestBody Long[] ids) {
            yuyueguanliService.deleteBatchIds(Arrays.asList(ids));
            return R.ok();
        }
    

    
    





    
}
