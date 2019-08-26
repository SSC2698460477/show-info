package com.ssc.showinfo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: show-info
 * @description: NBA球员信息实体类
 * @author: ssc
 * @create: 2019/8/26 17:13
 **/
@Table(name = "tb_nba_player")
public class NBAPlayerInfo extends BaseEntity{

    @Id
    private int id;

    @Column(name = "armLength")
    private String armLength;

    @Column(name = "birthDate")
    private String birthDate;

    @Column(name = "cnAlias")
    private String cnAlias;

    @Column(name = "cnName")
    private String cnName;

    @Column(name = "curRegularSeasonId")
    private String curRegularSeasonId;

    @Column(name = "curSeasonId")
    private String curSeasonId;

    @Column(name = "draftYear")
    private String draftYear;

    @Column(name = "enName")
    private String enName;

    @Column(name = "height")
    private String height;

    @Column(name = "honor")
    private String honor;

    @Column(name = "jerseyNum")
    private String jerseyNum;

    @Column(name = "picFromSIB")
    private String picFromSIB;

    @Column(name = "playerId")
    private String playerId;

    @Column(name = "position")
    private String position;

    @Column(name = "seasonExp")
    private String seasonExp;

    @Column(name = "status")
    private String status;

    @Column(name = "teamId")
    private String teamId;

    @Column(name = "wage")
    private String wage;

    @Column(name = "weight")
    private String weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArmLength() {
        return armLength;
    }

    public void setArmLength(String armLength) {
        this.armLength = armLength;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCnAlias() {
        return cnAlias;
    }

    public void setCnAlias(String cnAlias) {
        this.cnAlias = cnAlias;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getCurRegularSeasonId() {
        return curRegularSeasonId;
    }

    public void setCurRegularSeasonId(String curRegularSeasonId) {
        this.curRegularSeasonId = curRegularSeasonId;
    }

    public String getCurSeasonId() {
        return curSeasonId;
    }

    public void setCurSeasonId(String curSeasonId) {
        this.curSeasonId = curSeasonId;
    }

    public String getDraftYear() {
        return draftYear;
    }

    public void setDraftYear(String draftYear) {
        this.draftYear = draftYear;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    public String getJerseyNum() {
        return jerseyNum;
    }

    public void setJerseyNum(String jerseyNum) {
        this.jerseyNum = jerseyNum;
    }

    public String getPicFromSIB() {
        return picFromSIB;
    }

    public void setPicFromSIB(String picFromSIB) {
        this.picFromSIB = picFromSIB;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSeasonExp() {
        return seasonExp;
    }

    public void setSeasonExp(String seasonExp) {
        this.seasonExp = seasonExp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
