package com.my.frame.controller;

import com.my.commonEnum.ModelEnum;
import com.my.commonEnum.OperationEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.filter.LogAnnotation;

/**
 * @author whm
 * @date 2018/7/3
 */
@Controller()
@RequestMapping("/error*")
public class ErrorController {

    /**
     * 	未找到页面
     * @return
     */
    @RequestMapping("authorityError")
    public String authorityError(){
        return "error/authorityError";
    }

	/**
	 * 	未找到页面
	 * @return
	 */
    @RequestMapping("notFound")
    @LogAnnotation(model=ModelEnum.ERROR, operation=OperationEnum.NOEFOUND)
    public String notFoundError(){
        return "error/notFound";
    }

}
