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
import com.entity.XunlianrenyuanEntity;
import com.entity.view.XunlianrenyuanView;
import com.service.XunlianrenyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;
/**
 * 训练人员Controller
 *后端接口
 */
@RestController
@RequestMapping("/xunlianrenyuan")
public class XunlianrenyuanController {

    @Autowired
    private XunlianrenyuanService xunlianrenyuanService;



            @Autowired
        private TokenService tokenService;
    
    
            /**
         * 后端列表
         */
                @RequestMapping("/page")
        public R page(@RequestParam Map<String, Object> params, XunlianrenyuanEntity xunlianrenyuan, HttpServletRequest request) {
                                    EntityWrapper<XunlianrenyuanEntity> ew = new EntityWrapper<XunlianrenyuanEntity>();
            PageUtils page = xunlianrenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunlianrenyuan), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 前端列表
         */
                @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params, XunlianrenyuanEntity xunlianrenyuan, HttpServletRequest request) {

         

                                    EntityWrapper<XunlianrenyuanEntity> ew = new EntityWrapper<XunlianrenyuanEntity>();
            PageUtils page = xunlianrenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunlianrenyuan), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 列表
         */
                @RequestMapping("/lists")
        public R list( XunlianrenyuanEntity xunlianrenyuan) {
            EntityWrapper<XunlianrenyuanEntity> ew = new EntityWrapper<XunlianrenyuanEntity>();
            ew.allEq(MPUtil.allEQMapPre( xunlianrenyuan, "xunlianrenyuan"));
            return R.ok().put("data", xunlianrenyuanService.selectListView(ew));
        }

        /**
         * 查询
         */
                @RequestMapping("/query")
        public R query(XunlianrenyuanEntity xunlianrenyuan) {
            EntityWrapper< XunlianrenyuanEntity> ew = new EntityWrapper< XunlianrenyuanEntity>();
            ew.allEq(MPUtil.allEQMapPre( xunlianrenyuan, "Xunlianrenyuan"));
            XunlianrenyuanView xunlianrenyuanView = xunlianrenyuanService.selectView(ew);
            return R.ok("训练人员").put("data", xunlianrenyuanView);
        }

        /**
             * 后端详情
             */
                @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Long id) {
            XunlianrenyuanEntity xunlianrenyuan = xunlianrenyuanService.selectById(id);
            return R.ok().put("data", xunlianrenyuan);
        }

        /**
            * 前端详情
            */
                @RequestMapping("/detail/{id}")
        public R detail(@PathVariable("id") Long id) {
            XunlianrenyuanEntity xunlianrenyuan = xunlianrenyuanService.selectById(id);
                        return R.ok().put("data", xunlianrenyuan);
        }

        /**
        * 后端保存
        */
                @RequestMapping("/save")
        public R save(@RequestBody XunlianrenyuanEntity xunlianrenyuan, HttpServletRequest request) {
            
        
            xunlianrenyuan.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(address);
                            xunlianrenyuanService.insert(xunlianrenyuan);
            return R.ok();
        }

        /**
            * 前端保存
            */
                @RequestMapping("/add")
        public R add(@RequestBody XunlianrenyuanEntity xunlianrenyuan, HttpServletRequest request) {
                                xunlianrenyuan.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(yiyuanjianjie);

                xunlianrenyuanService.insert(xunlianrenyuan);
            return R.ok();
        }

        /**
          * 修改
          */
                @RequestMapping("/update")
        public R update(@RequestBody XunlianrenyuanEntity xunlianrenyuan, HttpServletRequest request) {
            //ValidatorUtils.validateEntity(zaixianbaoming);
                xunlianrenyuanService.updateById(xunlianrenyuan);//全部更新
            return R.ok();
        }

        /**
         * 删除
         */
                @RequestMapping("/delete")
        public R delete(@RequestBody Long[] ids) {
            xunlianrenyuanService.deleteBatchIds(Arrays.asList(ids));
            return R.ok();
        }
    

    
    





            /**
         * 注册
         */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody XunlianrenyuanEntity xunlianrenyuan) {
            XunlianrenyuanEntity user = xunlianrenyuanService.selectOne(new EntityWrapper<XunlianrenyuanEntity>().eq("zhanghao", xunlianrenyuan.getZhanghao()))
        ;
        if (user != null) {
            return R.error("注册用户已存在");
        }

  Long uId = new Date().getTime();
            xunlianrenyuan.setId(uId);
                xunlianrenyuanService.insert(xunlianrenyuan);
   
          
            return R.ok();
        }

        /**
             * 登录
             */
        @IgnoreAuth
        @RequestMapping(value = "/login")
        public R login(@RequestBody UserEntity userEntity , String captcha, HttpServletRequest request) {
                XunlianrenyuanEntity user = xunlianrenyuanService.selectOne(new EntityWrapper<XunlianrenyuanEntity>().eq("zhanghao",userEntity.getUsername() ));
            if (user == null || !user.getMima().equals(userEntity.getPassword())) {
                return R.error("账号或密码不正确");
            }
            String token = tokenService.generateToken(user.getId(), userEntity.getUsername(), "xunlianrenyuan", "训练人员");
            return R.ok().put("token", token);
        }

        /**
	 * 退出
	 */
        @RequestMapping("/logout")
        public R logout(HttpServletRequest request) {
            request.getSession().invalidate();
            return R.ok("退出成功");
        }

        /**
     * 获取用户的session用户信息
     */
        @RequestMapping("/session")
        public R getCurrUser(HttpServletRequest request) {
            Long id = (Long) request.getSession().getAttribute("userId");
            XunlianrenyuanEntity user = xunlianrenyuanService.selectById(id);
            JSONObject json = (JSONObject)JSON.toJSON(user);
            json.put("role", "xunlianrenyuan");
            return R.ok().put("data", json);
        }

        /**
     * 密码重置
     */
        @IgnoreAuth
        @RequestMapping(value = "/resetPass")
        public R resetPass(String username, HttpServletRequest request) {
                XunlianrenyuanEntity user = xunlianrenyuanService.selectOne(new EntityWrapper<XunlianrenyuanEntity>().eq("zhanghao", username));
            if (user == null) {
                return R.error("账号不存在");
            }
            user.setMima("123456");
                xunlianrenyuanService.updateById(user);
            return R.ok("密码已重置为：123456");
        }
    
}
