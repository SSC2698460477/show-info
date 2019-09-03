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

import java.util.List;

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
     * 根据id查询NBA球员的信息
     *
     * @param id
     * @return
     */
    @GetMapping("queryPlayerById")
    public ResponseEntity queryPlayerById(@RequestParam("id") Integer id){

        if(logger.isInfoEnabled()){
            logger.info("进入根据id查询NBA球员信息的接口 id={}", id);
        }
        try{
            NBAPlayerInfo record = new NBAPlayerInfo();
            record.setId(id);
            NBAPlayerInfo nbaPlayerInfo = nbaPlayerService.queryOne(record);
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
     * @param teamId
     * @return
     */
    @GetMapping("queryTeamById/{teamId}")
    public ResponseEntity queryTeamById(@PathVariable("teamId") String teamId){

        if(logger.isInfoEnabled()){
            logger.info("进入根据id查询NBA球员信息的接口 id={}", teamId);
        }
        try{
            NBATeamInfo record = new NBATeamInfo();
            record.setTeamId(teamId);
            NBATeamInfo nbaTeamInfo = nbaTeamService.queryOne(record);
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
    @GetMapping("queryTeamList")
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

    /**
     * 查询所有球队的数据信息
     *
     * @return
     */
    @GetMapping("queryAllTeam")
    public ResponseEntity queryAllTeam(){
        if(logger.isInfoEnabled()){
            logger.info("调用queryAllTeam接口查询信息");
        }
        try{
            List<NBATeamInfo> teamList = nbaTeamService.queryAll();
            return ResponseEntity.ok(teamList);
        }catch(Exception e){
            logger.error("调用queryAllTeam接口失败！",e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 根据TeamId查询球员的列表
     *
     * @param teamId
     * @return
     */
    @GetMapping("queryPlayersByTeamId")
    public ResponseEntity queryPlayersByTeamId(@RequestParam("teamId") String teamId){

        if(logger.isInfoEnabled()){
            logger.info("调用queryAllTeam接口查询信息");
        }
        try {
            NBAPlayerInfo record = new NBAPlayerInfo();
            record.setTeamId(teamId);
            List<NBAPlayerInfo> list = nbaPlayerService.queryListByWhere(record);
            return ResponseEntity.ok(list);
        }catch (Exception e){
            logger.error("调用queryPlayersByTeamId接口失败！",e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
