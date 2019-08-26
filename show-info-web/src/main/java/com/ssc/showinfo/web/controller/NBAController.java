package com.ssc.showinfo.web.controller;

import com.ssc.showinfo.biz.service.NBAPlayerService;
import com.ssc.showinfo.biz.service.NBATeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: show-info
 * @description: 获取NBA球队以及球员的信息接口
 * @author: ssc
 * @create: 2019/8/26 16:54
 **/
@RestController
@RequestMapping("api/nba")
public class NBAController {

    @Autowired
    private NBAPlayerService nbaPlayerService;

    @Autowired
    private NBATeamService nbaTeamService;


}
