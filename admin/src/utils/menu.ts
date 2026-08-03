const menu = {
    list() {
        return [{"frontMenu":[{"child": [{
            "buttons":["查看","回复","查看评论","我要预约"],
            "menu": "训练营信息",
            "menuJump": "列表",
            "tableName": "xunlianyingxinxi"
        }], "menu": "训练营信息"
    },{"child": [{
            "buttons":["查看"],
            "menu": "比赛管理",
            "menuJump": "列表",
            "tableName": "bisaiguanli"
        }], "menu": "比赛管理"
    },{"child": [{
            "buttons":["新增","删除","修改","查看"],
            "menu": "我的收藏管理",
            "menuJump": "列表",
            "tableName": "wodeshouzangguanli"
        }], "menu": "我的收藏管理"
    },{"child": [{
            "buttons":["查看"],
            "menu": "训练项目",
            "menuJump": "列表",
            "tableName": "xunlianxiangmu"
        }], "menu": "训练项目"
    },{
                "child": [{"buttons": ["查看"], "menu": "系统公告", "tableName": "news"}],
                "menu": "系统公告"
            },{
                "child": [{"buttons": ["查看"], "menu": "交流论坛管理", "tableName": "forum"}],
                "menu": "交流论坛"
            }],"roleName": "用户", "tableName": "yonghu"},{"backMenu":[{"child": [{
            "buttons":["查看", "修改", "删除"],
            "menu": "训练营信息评论",
            "menuJump": "列表",
            "tableName": "discussxunlianyingxinxi"
        }], "menu": "训练营信息评论"
    },{"child": [{
            "buttons":["查看","查看评论","回复"],
            "menu": "训练营信息",
            "menuJump": "列表",
            "tableName": "xunlianyingxinxi"
        }], "menu": "训练营信息"
    },{"child": [{
            "buttons":["查看"],
            "menu": "预约管理",
            "menuJump": "列表",
            "tableName": "yuyueguanli"
        }], "menu": "预约管理"
    },{"child": [{
            "buttons":["查看", "修改", "删除"],
            "menu": "比赛管理评论",
            "menuJump": "列表",
            "tableName": "discussbisaiguanli"
        }], "menu": "比赛管理评论"
    },{"child": [{
            "buttons":["查看"],
            "menu": "比赛管理",
            "menuJump": "列表",
            "tableName": "bisaiguanli"
        }], "menu": "比赛管理"
    },{"child": [{
            "buttons":["查看","出入库"],
            "menu": "器材管理",
            "menuJump": "列表",
            "tableName": "qicaiguanli"
        }], "menu": "器材管理"
    },{"child": [{
            "buttons":["查看","删除"],
            "menu": "出入库管理",
            "menuJump": "列表",
            "tableName": "crk"
        }], "menu": "出入库管理"
    },{"child": [{
            "buttons":["新增","删除","修改","查看"],
            "menu": "训练项目",
            "menuJump": "列表",
            "tableName": "xunlianxiangmu"
        }], "menu": "训练项目"
    }],"frontMenu":[{
                "child": [{"buttons": ["查看"], "menu": "系统公告", "tableName": "news"}],
                "menu": "系统公告"
            },{
                "child": [{"buttons": ["查看"], "menu": "交流论坛管理", "tableName": "forum"}],
                "menu": "交流论坛"
            },{
                "child": [{"buttons": ["查看"], "menu": "系统公告", "tableName": "news"}],
                "menu": "系统公告"
            },{
                "child": [{"buttons": ["查看"], "menu": "交流论坛管理", "tableName": "forum"}],
                "menu": "交流论坛"
            }],"roleName": "训练人员", "tableName": "xunlianrenyuan"},{"backMenu":[{"child": [{
            "buttons":["查看", "修改", "删除"],
            "menu": "训练营信息评论",
            "menuJump": "列表",
            "tableName": "discussxunlianyingxinxi"
        }], "menu": "训练营信息评论"
    },{"child": [{
            "buttons":["新增","删除","修改","查看","查看评论","回复"],
            "menu": "训练营信息",
            "menuJump": "列表",
            "tableName": "xunlianyingxinxi"
        }], "menu": "训练营信息"
    },{"child": [{
            "buttons":["删除","查看","审核"],
            "menu": "预约管理",
            "menuJump": "列表",
            "tableName": "yuyueguanli"
        }], "menu": "预约管理"
    },{"child": [{
            "buttons":["查看", "修改", "删除"],
            "menu": "比赛管理评论",
            "menuJump": "列表",
            "tableName": "discussbisaiguanli"
        }], "menu": "比赛管理评论"
    },{"child": [{
            "buttons":["新增","删除","修改","查看"],
            "menu": "比赛管理",
            "menuJump": "列表",
            "tableName": "bisaiguanli"
        }], "menu": "比赛管理"
    },{"child": [{
            "buttons":["新增","删除","修改","查看","出入库"],
            "menu": "器材管理",
            "menuJump": "列表",
            "tableName": "qicaiguanli"
        }], "menu": "器材管理"
    },{"child": [{
            "buttons":["新增","修改","删除","查看","审核"],
            "menu": "训练项目",
            "menuJump": "列表",
            "tableName": "xunlianxiangmu"
        }], "menu": "训练项目"
    },{"child": [{
            "buttons":["新增","删除","修改","查看"],
            "menu": "用户",
            "menuJump": "列表",
            "tableName": "yonghu"
        }], "menu": "用户"
    },{"child": [{
            "buttons":["新增","删除","修改","查看"],
            "menu": "训练人员",
            "menuJump": "列表",
            "tableName": "xunlianrenyuan"
        }], "menu": "训练人员"
    },{
                "child": [{"buttons": [ "查看", "修改", "删除"], "menu": "交流论坛管理", "tableName": "forum"}],
                "menu": "交流论坛管理"
            },{
                "child": [{"buttons": ["查看", "删除"], "menu": "出入库", "tableName": "crk"}],
                "menu": "出入库"
            },{"child":[{
            "buttons": ["新增", "查看", "修改", "删除"],
            "menu": "轮播图管理",
            "tableName": "config"
        },{
                        "buttons": ["新增", "查看", "修改", "删除"],
                        "menu": "系统公告", "tableName": "news"
                    }],
                "menu": "系统管理"
            }],"roleName": "管理员", "tableName": "users"},{"ykMenu":[{
                "child": [{"buttons": ["查看"], "menu": "系统公告", "tableName": "news"}],
                "menu": "系统公告"
            }],"roleName": "游客", "tableName": "游客"}]
    }
}
export default menu;
