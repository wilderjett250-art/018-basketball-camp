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
import com.entity.QicaiguanliEntity;
import com.entity.view.QicaiguanliView;
import com.service.QicaiguanliService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;
/**
 * 器材管理Controller
 *后端接口
 */
@RestController
@RequestMapping("/qicaiguanli")
public class QicaiguanliController {

    @Autowired
    private QicaiguanliService qicaiguanliService;



    
    
            /**
         * 后端列表
         */
                @RequestMapping("/page")
        public R page(@RequestParam Map<String, Object> params, QicaiguanliEntity qicaiguanli, HttpServletRequest request) {
                                    EntityWrapper<QicaiguanliEntity> ew = new EntityWrapper<QicaiguanliEntity>();
            PageUtils page = qicaiguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicaiguanli), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 前端列表
         */
                @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params, QicaiguanliEntity qicaiguanli, HttpServletRequest request) {

         

                                    EntityWrapper<QicaiguanliEntity> ew = new EntityWrapper<QicaiguanliEntity>();
            PageUtils page = qicaiguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicaiguanli), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 列表
         */
                @RequestMapping("/lists")
        public R list( QicaiguanliEntity qicaiguanli) {
            EntityWrapper<QicaiguanliEntity> ew = new EntityWrapper<QicaiguanliEntity>();
            ew.allEq(MPUtil.allEQMapPre( qicaiguanli, "qicaiguanli"));
            return R.ok().put("data", qicaiguanliService.selectListView(ew));
        }

        /**
         * 查询
         */
                @RequestMapping("/query")
        public R query(QicaiguanliEntity qicaiguanli) {
            EntityWrapper< QicaiguanliEntity> ew = new EntityWrapper< QicaiguanliEntity>();
            ew.allEq(MPUtil.allEQMapPre( qicaiguanli, "Qicaiguanli"));
            QicaiguanliView qicaiguanliView = qicaiguanliService.selectView(ew);
            return R.ok("器材管理").put("data", qicaiguanliView);
        }

        /**
             * 后端详情
             */
                @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Long id) {
            QicaiguanliEntity qicaiguanli = qicaiguanliService.selectById(id);
            return R.ok().put("data", qicaiguanli);
        }

        /**
            * 前端详情
            */
                @RequestMapping("/detail/{id}")
        public R detail(@PathVariable("id") Long id) {
            QicaiguanliEntity qicaiguanli = qicaiguanliService.selectById(id);
                        return R.ok().put("data", qicaiguanli);
        }

        /**
        * 后端保存
        */
                @RequestMapping("/save")
        public R save(@RequestBody QicaiguanliEntity qicaiguanli, HttpServletRequest request) {
            
        
            qicaiguanli.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(address);
                            qicaiguanliService.insert(qicaiguanli);
            return R.ok();
        }

        /**
            * 前端保存
            */
                @RequestMapping("/add")
        public R add(@RequestBody QicaiguanliEntity qicaiguanli, HttpServletRequest request) {
                                qicaiguanli.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(yiyuanjianjie);

                qicaiguanliService.insert(qicaiguanli);
            return R.ok();
        }

        /**
          * 修改
          */
                @RequestMapping("/update")
        public R update(@RequestBody QicaiguanliEntity qicaiguanli, HttpServletRequest request) {
            //ValidatorUtils.validateEntity(zaixianbaoming);
                qicaiguanliService.updateById(qicaiguanli);//全部更新
            return R.ok();
        }

        /**
         * 删除
         */
                @RequestMapping("/delete")
        public R delete(@RequestBody Long[] ids) {
            qicaiguanliService.deleteBatchIds(Arrays.asList(ids));
            return R.ok();
        }
    

    
    





    
}
