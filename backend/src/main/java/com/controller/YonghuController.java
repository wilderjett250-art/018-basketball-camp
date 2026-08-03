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
import com.entity.YonghuEntity;
import com.entity.view.YonghuView;
import com.service.YonghuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;
/**
 * 用户Controller
 *后端接口
 */
@RestController
@RequestMapping("/yonghu")
public class YonghuController {

    @Autowired
    private YonghuService yonghuService;



            @Autowired
        private TokenService tokenService;
    
    
            /**
         * 后端列表
         */
                @RequestMapping("/page")
        public R page(@RequestParam Map<String, Object> params, YonghuEntity yonghu, HttpServletRequest request) {
                                    EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
            PageUtils page = yonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghu), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 前端列表
         */
                @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params, YonghuEntity yonghu, HttpServletRequest request) {

         

                                    EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
            PageUtils page = yonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghu), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 列表
         */
                @RequestMapping("/lists")
        public R list( YonghuEntity yonghu) {
            EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
            ew.allEq(MPUtil.allEQMapPre( yonghu, "yonghu"));
            return R.ok().put("data", yonghuService.selectListView(ew));
        }

        /**
         * 查询
         */
                @RequestMapping("/query")
        public R query(YonghuEntity yonghu) {
            EntityWrapper< YonghuEntity> ew = new EntityWrapper< YonghuEntity>();
            ew.allEq(MPUtil.allEQMapPre( yonghu, "Yonghu"));
            YonghuView yonghuView = yonghuService.selectView(ew);
            return R.ok("用户").put("data", yonghuView);
        }

        /**
             * 后端详情
             */
                @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Long id) {
            YonghuEntity yonghu = yonghuService.selectById(id);
            return R.ok().put("data", yonghu);
        }

        /**
            * 前端详情
            */
                @RequestMapping("/detail/{id}")
        public R detail(@PathVariable("id") Long id) {
            YonghuEntity yonghu = yonghuService.selectById(id);
                        return R.ok().put("data", yonghu);
        }

        /**
        * 后端保存
        */
                @RequestMapping("/save")
        public R save(@RequestBody YonghuEntity yonghu, HttpServletRequest request) {
            
        
            yonghu.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(address);
                            yonghuService.insert(yonghu);
            return R.ok();
        }

        /**
            * 前端保存
            */
                @RequestMapping("/add")
        public R add(@RequestBody YonghuEntity yonghu, HttpServletRequest request) {
                                yonghu.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(yiyuanjianjie);

                yonghuService.insert(yonghu);
            return R.ok();
        }

        /**
          * 修改
          */
                @RequestMapping("/update")
        public R update(@RequestBody YonghuEntity yonghu, HttpServletRequest request) {
            //ValidatorUtils.validateEntity(zaixianbaoming);
                yonghuService.updateById(yonghu);//全部更新
            return R.ok();
        }

        /**
         * 删除
         */
                @RequestMapping("/delete")
        public R delete(@RequestBody Long[] ids) {
            yonghuService.deleteBatchIds(Arrays.asList(ids));
            return R.ok();
        }
    

    
    





            /**
         * 注册
         */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody YonghuEntity yonghu) {
            YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("zhanghao", yonghu.getZhanghao()))
        ;
        if (user != null) {
            return R.error("注册用户已存在");
        }

  Long uId = new Date().getTime();
            yonghu.setId(uId);
                yonghuService.insert(yonghu);
   
          
            return R.ok();
        }

        /**
             * 登录
             */
        @IgnoreAuth
        @RequestMapping(value = "/login")
        public R login(@RequestBody UserEntity userEntity , String captcha, HttpServletRequest request) {
                YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("zhanghao",userEntity.getUsername() ));
            if (user == null || !user.getMima().equals(userEntity.getPassword())) {
                return R.error("账号或密码不正确");
            }
            String token = tokenService.generateToken(user.getId(), userEntity.getUsername(), "yonghu", "用户");
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
            YonghuEntity user = yonghuService.selectById(id);
            JSONObject json = (JSONObject)JSON.toJSON(user);
            json.put("role", "yonghu");
            return R.ok().put("data", json);
        }

        /**
     * 密码重置
     */
        @IgnoreAuth
        @RequestMapping(value = "/resetPass")
        public R resetPass(String username, HttpServletRequest request) {
                YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("zhanghao", username));
            if (user == null) {
                return R.error("账号不存在");
            }
            user.setMima("123456");
                yonghuService.updateById(user);
            return R.ok("密码已重置为：123456");
        }
    
}
