
import { createRouter, createWebHistory,createWebHashHistory } from 'vue-router'
import type { RouteRecordRaw } from 'vue-router';
import { Session } from '@/utils/storage';
import { Key } from '@/stores/auth';

export const dynamicRoutes: RouteRecordRaw[] = [
    {
        path: "/",
        name: "layout", // layout 的 children 数组为用户菜单页面的集合
        redirect: "/home",
        component: () => import('@/layout/index.vue'),
        children: [
            {
                path: "/home",
                name: "home",
                meta: {
                    hideInMenu: false, // 该菜单是否隐藏；true 为隐藏
                    title: "首页",
                    cache: true, // 为true，则缓存菜单
                    icon: "&#xe611;", // 图标
                },
                component: () => import("@/views/home.vue"),
            },
            {
                path: "/cen",
                name: "cen",
                meta: {
                    title: "个人信息",
                    icon: "&#xe7fc;", // 图标
                },
                redirect:'/center',
                children: [
                    {
                        path: "/center",
                        name: "center",
                        meta: {
                            title: "个人信息",
                            icon: "&#xe90f;", // 图标
                        },
                        component: () => import("@/views/center.vue"),
                    },

                ],
            },
            {
                path: "/updatePassword",
                name: "updatePassword",
                meta: {
                    title: "修改密码",
                    icon: "&#xe7fc;", // 图标
                },
                redirect:'/updatePassword',
                children: [
                    {
                        path: "/updatePassword",
                        name: "updatePassword",
                        meta: {
                            title: "修改密码",
                            icon: "&#xe90f;", // 图标
                        },
                        component: () => import("@/views/update-password.vue"),
                    },

                ],
            },


    

            
            

            {
                path: "/forum",
                name: "forum",
                meta: {
                    title: "交流论坛管理",
                    icon: "&#xe7fc;", // 图标
                },
                redirect:'/forum',
                children: [
                    {
                        path: "/forum",
                        name: "forum",
                        meta: {
                            title: "交流论坛管理",
                            icon: "&#xe90f;", // 图标
                        },
                        component: () => import("@/views/forum/index.vue"),
                    },

                ],
            },


            
                                    {
                        path: "/news",
                        name: "news",
                        meta: {
                            title: "系统公告",
                            icon: "&#xe7fc;", // 图标
                        },
                        redirect:'/news',
                        children: [
                            {
                                path: "/news",
                                name: "news",
                                meta: {
                                    title: "系统公告",
                                    icon: "&#xe90f;", // 图标
                                },
                                component: () => import("@/views/news/index.vue"),
                            },

                        ],
                    },

                
            
                                    {
                        path: "/wodeshouzangguanli",
                        name: "wodeshouzangguanli",
                        meta: {
                            title: "我的收藏",
                            icon: "&#xe7fc;", // 图标
                        },
                        redirect:'/wodeshouzangguanli',
                        children: [
                            {
                                path: "/wodeshouzangguanli",
                                name: "wodeshouzangguanli",
                                meta: {
                                    title: "我的收藏",
                                    icon: "&#xe90f;", // 图标
                                },
                                component: () => import("@/views/storeup/index.vue"),
                            },

                        ],
                    },
                
            
                                    {
                        path: "/xunlianyingxinxi",
                        name: "xunlianyingxinxi",
                        meta: {
                            title: "训练营信息",
                            icon: "&#xe7fc;", // 图标
                        },
                        redirect:'/xunlianyingxinxi',
                        children: [
                            {
                                path: "/xunlianyingxinxi",
                                name: "xunlianyingxinxi",
                                meta: {
                                    title: "训练营信息",
                                    icon: "&#xe90f;", // 图标
                                },
                                component: () => import("@/views/xunlianyingxinxi/index.vue"),
                            },

                        ],
                    },
                
            
                                    {
                        path: "/discussxunlianyingxinxi",
                        name: "/discussxunlianyingxinxi",
                        meta: {
                            title: "训练营信息评论",
                            icon: "&#xe7fc;", // 图标
                        },
                        redirect:'/discussxunlianyingxinxi',
                        children: [
                            {
                                path: "/discussxunlianyingxinxi",
                                name: "discussxunlianyingxinxi",
                                meta: {
                                    title: "训练营信息评论",
                                    icon: "&#xe90f;", // 图标
                                },
                                component: () => import("@/views/discussxunlianyingxinxi/index.vue"),
                            },

                        ],
                    },


                
            
                                    {
                        path: "/yuyueguanli",
                        name: "yuyueguanli",
                        meta: {
                            title: "预约管理",
                            icon: "&#xe7fc;", // 图标
                        },
                        redirect:'/yuyueguanli',
                        children: [
                            {
                                path: "/yuyueguanli",
                                name: "yuyueguanli",
                                meta: {
                                    title: "预约管理",
                                    icon: "&#xe90f;", // 图标
                                },
                                component: () => import("@/views/yuyueguanli/index.vue"),
                            },

                        ],
                    },
                
            
                                    {
                        path: "/bisaiguanli",
                        name: "bisaiguanli",
                        meta: {
                            title: "比赛管理",
                            icon: "&#xe7fc;", // 图标
                        },
                        redirect:'/bisaiguanli',
                        children: [
                            {
                                path: "/bisaiguanli",
                                name: "bisaiguanli",
                                meta: {
                                    title: "比赛管理",
                                    icon: "&#xe90f;", // 图标
                                },
                                component: () => import("@/views/bisaiguanli/index.vue"),
                            },

                        ],
                    },
                
            
                                    {
                        path: "/discussbisaiguanli",
                        name: "/discussbisaiguanli",
                        meta: {
                            title: "比赛管理评论",
                            icon: "&#xe7fc;", // 图标
                        },
                        redirect:'/discussbisaiguanli',
                        children: [
                            {
                                path: "/discussbisaiguanli",
                                name: "discussbisaiguanli",
                                meta: {
                                    title: "比赛管理评论",
                                    icon: "&#xe90f;", // 图标
                                },
                                component: () => import("@/views/discussbisaiguanli/index.vue"),
                            },

                        ],
                    },


                
            
                                    {
                        path: "/qicaiguanli",
                        name: "qicaiguanli",
                        meta: {
                            title: "器材管理",
                            icon: "&#xe7fc;", // 图标
                        },
                        redirect:'/qicaiguanli',
                        children: [
                            {
                                path: "/qicaiguanli",
                                name: "qicaiguanli",
                                meta: {
                                    title: "器材管理",
                                    icon: "&#xe90f;", // 图标
                                },
                                component: () => import("@/views/qicaiguanli/index.vue"),
                            },

                        ],
                    },

                    {
                        path: "/crk",
                        name: "crk",
                        meta: {
                            title: "出入库管理",
                            icon: "&#xe7fc;",
                        },
                        redirect:'/crk',
                        children: [
                            {
                                path: "/crk",
                                name: "crk",
                                meta: {
                                    title: "出入库管理",
                                    icon: "&#xe90f;",
                                },
                                component: () => import("@/views/crk/index.vue"),
                            },

                        ],
                    },

                                    {
                        path: "/xunlianxiangmu",
                        name: "xunlianxiangmu",
                        meta: {
                            title: "训练项目",
                            icon: "&#xe7fc;", // 图标
                        },
                        redirect:'/xunlianxiangmu',
                        children: [
                            {
                                path: "/xunlianxiangmu",
                                name: "xunlianxiangmu",
                                meta: {
                                    title: "训练项目",
                                    icon: "&#xe90f;", // 图标
                                },
                                component: () => import("@/views/xunlianxiangmu/index.vue"),
                            },

                        ],
                    },
                
            
                                    {
                        path: "/yonghu",
                        name: "yonghu",
                        meta: {
                            title: "用户",
                            icon: "&#xe7fc;", // 图标
                        },
                        redirect:'/yonghu',
                        children: [
                            {
                                path: "/yonghu",
                                name: "yonghu",
                                meta: {
                                    title: "用户",
                                    icon: "&#xe90f;", // 图标
                                },
                                component: () => import("@/views/yonghu/index.vue"),
                            },

                        ],
                    },
                
            
                                    {
                        path: "/xunlianrenyuan",
                        name: "xunlianrenyuan",
                        meta: {
                            title: "训练人员",
                            icon: "&#xe7fc;", // 图标
                        },
                        redirect:'/xunlianrenyuan',
                        children: [
                            {
                                path: "/xunlianrenyuan",
                                name: "xunlianrenyuan",
                                meta: {
                                    title: "训练人员",
                                    icon: "&#xe90f;", // 图标
                                },
                                component: () => import("@/views/xunlianrenyuan/index.vue"),
                            },

                        ],
                    },
                
                        {
                path: "/config",
                name: "config",
                meta: {
                    title: "系统管理",
                    icon: "&#xe7fc;", // 图标
                },
                redirect:'/config',
                children: [
                    {
                        path: "/config",
                        name: "config",
                        meta: {
                            title: "轮播图列表",
                            icon: "&#xe90f;", // 图标
                        },
                        component: () => import("@/views/config/index.vue"),
                    },

                ],
            },



            {
                path: '/401',
                name: 'NoPermission',
                component: () => import('@/views/error/401.vue'),
                meta: {
                    title: '401页面',
                    icon: 'ele-Warning',
                    cache: true,
                    hidden: false,
                }
            },
            {
                path: '/:path(.*)*', //  404匹配不存在的路由
                name: 'NotFound',
                component: () => import('@/views/error/404.vue'),
                meta: {
                    title: '未找到此页面',
                    cache: true,
                    hidden: true,
                }
            },

        ],
    },
    {
        path:'/login',
        name:'Login',
        component:()=>import('@/views/login/index.vue')
    }

]

const router = createRouter({
    // 参数获取的是 vite.config.ts 中base 属性值
    history: createWebHashHistory(),
    routes: dynamicRoutes,
});


router.beforeEach((to,from)=>{
    // const token = localStorage.getItem('token');
    //用户未登录，且跳转的目标路由不是登陆页面：则跳转登录页面/login


    const token=Session.get(Key.accessTokenKey);
    console.log(token);
    if(!token && (to.path !=='/login')){
        //通过return返回一个跳转的路由对象，重定向到指定路由
        //  return router.push({path:'/login'});
        //  return {path:'/login'}


        return {path:'/login'}


    }
    //已登录,正常进入目标路由
    return true;


})

// 路由后置守卫

export default router
