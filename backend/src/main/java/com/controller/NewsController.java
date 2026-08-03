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
import com.entity.NewsEntity;
import com.entity.view.NewsView;
import com.service.NewsService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;
/**
 * 系统公告Controller
 *后端接口
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;



    
    
            /**
         * 后端列表
         */
                @IgnoreAuth
                @RequestMapping("/page")
        public R page(@RequestParam Map<String, Object> params, NewsEntity news, HttpServletRequest request) {
                                    EntityWrapper<NewsEntity> ew = new EntityWrapper<NewsEntity>();
            PageUtils page = newsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, news), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 前端列表
         */
                @IgnoreAuth
                @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params, NewsEntity news, HttpServletRequest request) {

         

                                    EntityWrapper<NewsEntity> ew = new EntityWrapper<NewsEntity>();
            PageUtils page = newsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, news), params), params));
            request.setAttribute("data", page);
            return R.ok().put("data", page);
        }

        /**
         * 列表
         */
                @IgnoreAuth
                @RequestMapping("/lists")
        public R list( NewsEntity news) {
            EntityWrapper<NewsEntity> ew = new EntityWrapper<NewsEntity>();
            ew.allEq(MPUtil.allEQMapPre( news, "news"));
            return R.ok().put("data", newsService.selectListView(ew));
        }

        /**
         * 查询
         */
                @IgnoreAuth
                @RequestMapping("/query")
        public R query(NewsEntity news) {
            EntityWrapper< NewsEntity> ew = new EntityWrapper< NewsEntity>();
            ew.allEq(MPUtil.allEQMapPre( news, "News"));
            NewsView newsView = newsService.selectView(ew);
            return R.ok("系统公告").put("data", newsView);
        }

        /**
             * 后端详情
             */
                @IgnoreAuth
                @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Long id) {
            NewsEntity news = newsService.selectById(id);
            return R.ok().put("data", news);
        }

        /**
            * 前端详情
            */
                @IgnoreAuth
                @RequestMapping("/detail/{id}")
        public R detail(@PathVariable("id") Long id) {
            NewsEntity news = newsService.selectById(id);
                        return R.ok().put("data", news);
        }

        /**
        * 后端保存
        */
                @IgnoreAuth
                @RequestMapping("/save")
        public R save(@RequestBody NewsEntity news, HttpServletRequest request) {
            
        
            news.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(address);
                            newsService.insert(news);
            return R.ok();
        }

        /**
            * 前端保存
            */
                @IgnoreAuth
                @RequestMapping("/add")
        public R add(@RequestBody NewsEntity news, HttpServletRequest request) {
                                news.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
            //ValidatorUtils.validateEntity(yiyuanjianjie);

                newsService.insert(news);
            return R.ok();
        }

        /**
          * 修改
          */
                @IgnoreAuth
                @RequestMapping("/update")
        public R update(@RequestBody NewsEntity news, HttpServletRequest request) {
            //ValidatorUtils.validateEntity(zaixianbaoming);
                newsService.updateById(news);//全部更新
            return R.ok();
        }

        /**
         * 删除
         */
                @IgnoreAuth
                @RequestMapping("/delete")
        public R delete(@RequestBody Long[] ids) {
            newsService.deleteBatchIds(Arrays.asList(ids));
            return R.ok();
        }
    

    
    





    
}
