package com.ssc.showinfo.dao.entity;

import javax.persistence.*;

/**
 * @program: show-info
 * @description: NBA球队实体类
 * @author: ssc
 * @create: 2019/8/26 17:12
 **/
@Table(name = "tb_nba_team")
public class NBATeamInfo extends BaseEntity{

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "boss")
    private String boss;

    @Column(name = "brief")
    private String brief;

    @Column(name = "city")
    private String city;

    @Column(name = "cityEnName")
    private String cityEnName;

    @Column(name = "cnName")
    private String cnName;

    @Column(name = "fullCnName")
    private String fullCnName;

    @Column(name = "coach")
    private String coach;

    @Column(name = "conference")
    private String conference;

    @Column(name = "division")
    private String division;

    @Column(name = "enName")
    private String enName;

    @Column(name = "historyChampion")
    private String historyChampion;

    @Column(name = "joinNBADate")
    private String joinNBADate;

    @Column(name = "logoBlack")
    private String logoBlack;

    @Column(name = "logoNew")
    private String logoNew;

    @Column(name = "propsLogo")
    private String propsLogo;

    @Column(name = "teamId")
    private String teamId;

    @Column(name = "venue")
    private String venue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityEnName() {
        return cityEnName;
    }

    public void setCityEnName(String cityEnName) {
        this.cityEnName = cityEnName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getFullCnName() {
        return fullCnName;
    }

    public void setFullCnName(String fullCnName) {
        this.fullCnName = fullCnName;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getHistoryChampion() {
        return historyChampion;
    }

    public void setHistoryChampion(String historyChampion) {
        this.historyChampion = historyChampion;
    }

    public String getJoinNBADate() {
        return joinNBADate;
    }

    public void setJoinNBADate(String joinNBADate) {
        this.joinNBADate = joinNBADate;
    }

    public String getLogoBlack() {
        return logoBlack;
    }

    public void setLogoBlack(String logoBlack) {
        this.logoBlack = logoBlack;
    }

    public String getLogoNew() {
        return logoNew;
    }

    public void setLogoNew(String logoNew) {
        this.logoNew = logoNew;
    }

    public String getPropsLogo() {
        return propsLogo;
    }

    public void setPropsLogo(String propsLogo) {
        this.propsLogo = propsLogo;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
