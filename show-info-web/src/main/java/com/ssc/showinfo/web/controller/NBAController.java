package com.ssc.showinfo.web.controller;

import com.github.pagehelper.PageInfo;
import com.ssc.showinfo.biz.service.NBAPlayerService;
import com.ssc.showinfo.biz.service.NBATeamService;
import com.ssc.showinfo.dao.entity.NBAPlayerInfo;
import com.ssc.showinfo.dao.entity.NBATeamInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @program: show-info
 * @description: 获取NBA球队以及球员的信息接口
 * @author: ssc
 * @create: 2019/8/26 16:54
 **/
@RestController
@RequestMapping("api/nba")
public class NBAController {

    private Logger logger = LoggerFactory.getLogger(NBAController.class);

    @Autowired
    private NBAPlayerService nbaPlayerService;

    @Autowired
    private NBATeamService nbaTeamService;

    /**
     * 根据id 查询NBA球员的信息
     *
     * @param id
     * @return
     */
    @GetMapping("queryPlayerById/{id}")
    public ResponseEntity queryPlayerById(@PathVariable("id") Integer id){

        if(logger.isInfoEnabled()){
            logger.info("进入根据id查询NBA球员信息的接口 id={}", id);
        }
        try{
            NBAPlayerInfo nbaPlayerInfo = nbaPlayerService.queryById(id);
            return ResponseEntity.ok(nbaPlayerInfo);
        }catch(Exception e){
            logger.error("调用queryPlayerById接口失败！", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 根绝条件分页查询NBA球员的信息
     *
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("queryPlayerList")
    public ResponseEntity queryPlayerList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                          @RequestParam(value = "rows",defaultValue = "10") Integer rows){
        if(logger.isInfoEnabled()){
            logger.info("调用queryPlayerList接口分页查询信息 page={}, row={}", page, rows);
        }
        try{
            PageInfo<NBAPlayerInfo> pageInfo = nbaPlayerService.queryPageListByWhere(null,page,rows);
            return ResponseEntity.ok(pageInfo);
        }catch(Exception e){
            logger.error("调用queryPlayerList接口失败！", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 根据id 查询NBA球队的信息
     *
     * @param id
     * @return
     */
    @GetMapping("queryTeamById/{id}")
    public ResponseEntity queryTeamById(@PathVariable("id") Integer id){

        if(logger.isInfoEnabled()){
            logger.info("进入根据id查询NBA球员信息的接口 id={}", id);
        }
        try{
            NBATeamInfo nbaTeamInfo = nbaTeamService.queryById(id);
            return ResponseEntity.ok(nbaTeamInfo);
        }catch(Exception e){
            logger.error("调用queryTeamById接口失败！", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 根绝条件分页查询NBA球队的信息
     *
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("queryPlayerList")
    public ResponseEntity queryTeamList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                          @RequestParam(value = "rows",defaultValue = "10") Integer rows){
        if(logger.isInfoEnabled()){
            logger.info("调用queryTeamList接口分页查询信息 page={}, row={}", page, rows);
        }
        try{
            PageInfo<NBATeamInfo> pageInfo = nbaTeamService.queryPageListByWhere(null,page,rows);
            return ResponseEntity.ok(pageInfo);
        }catch(Exception e){
            logger.error("调用queryTeamList接口失败！", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
