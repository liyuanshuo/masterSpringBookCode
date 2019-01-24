package com.cqu.ltw;

/**
 * @author : liyuanshuo
 * @date : 2019/1/24 16:00
 * @description :  add description here
 * @version 1.0
 */
public aspect TopicAspectj {
    private pointcut tracedCall() :execution(* Topic.setTitle(..));
    before(): tracedCall() {
        System.out.println("---调用Topic.setTitle()-----");
        System.out.println("message:"+message);
        System.out.println("---调用Topic.setTitle()-----");
    }
    private String message;
    public void setMessage(String message){
        this.message = message;
    }
    @Override
    public String toString(){
        return "message:"+this.message;
    }
}
