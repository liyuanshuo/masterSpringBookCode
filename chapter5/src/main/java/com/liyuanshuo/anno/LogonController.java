package com.liyuanshuo.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/11 19:57
 * @description :  add description here
 */
@Controller
public class LogonController {

    @Autowired
    private LogonService logonService;
}
