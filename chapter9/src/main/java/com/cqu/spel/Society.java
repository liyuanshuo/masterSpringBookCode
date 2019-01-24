package com.cqu.spel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:34
 * @description :  add description here
 */
public class Society {
    private String name;
    public static String Advisors = "advisors";
    public static String President = "president";
    private List<Inventor> members = new ArrayList<Inventor>();
    private Map officers = new HashMap();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getAdvisors() {
        return Advisors;
    }

    public static void setAdvisors(String advisors) {
        Advisors = advisors;
    }

    public static String getPresident() {
        return President;
    }

    public static void setPresident(String president) {
        President = president;
    }

    public List getMembers() {
        return members;
    }

    public void setMembers(List<Inventor> members) {
        this.members = members;
    }

    public Map getOfficers() {
        return officers;
    }

    public void setOfficers(Map officers) {
        this.officers = officers;
    }
    public boolean isMember(String name) {
        for (Inventor inventor : members) {
            if (inventor.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
