package com.liyuanshuo.placeholder;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/21 21:17
 * @description :  add description here
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private String[] encryptPropNames ={"userName","password"};

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if(isEncryptProp(propertyName)){
            String decryptValue = DESUtils.getDecryptString(propertyValue);
            System.out.println(decryptValue);
            return decryptValue;
        }else{
            return propertyValue;
        }
    }

    /**
     *@author:  liyuanshuo
     *@dateTime:  2019/1/21 21:23
     *@description:  判断是否是加密的属性
     *@param:  null
     *@return:  
     *@other information: to add other information here
     */
     
    private boolean isEncryptProp(String propertyName){
        for(String encryptPropName:encryptPropNames){
            if(encryptPropName.equals(propertyName)){
                return true;
            }
        }
        return false;
    }

}
