package com.liyuanshuo.attr;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/11 20:54
 * @description :  add description here
 */
public class Boss {

    private String name;
    private Integer age;
    private Car car = new Car();
    private Map jobs = new HashMap();
    private Properties mails = new Properties();
    private Map<String, Integer> jobTime = new HashMap<String, Integer>();
    private Set favorites = new HashSet();

    public Boss(){
        System.out.println("Default Constructing Function Without Arguments");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Map getJobs() {
        return jobs;
    }

    public void setJobs(Map jobs) {
        this.jobs = jobs;
    }

    public Properties getMails() {
        return mails;
    }

    public void setMails(Properties mails) {
        this.mails = mails;
    }

    public Map<String, Integer> getJobTime() {
        return jobTime;
    }

    public void setJobTime(Map<String, Integer> jobTime) {
        this.jobTime = jobTime;
    }

    public Set getFavorites() {
        return favorites;
    }

    public void setFavorites(Set favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", jobs=" + jobs +
                ", mails=" + mails +
                ", jobTime=" + jobTime +
                ", favorites=" + favorites +
                '}';
    }
}
