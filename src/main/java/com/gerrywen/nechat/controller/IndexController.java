package com.gerrywen.nechat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenguoli
 * @date 2020/1/14 14:32
 */
@RestController
@RequestMapping("/api")
@Api(value = "IndexController", tags = "首页模块管理")
public class IndexController {

    @ApiOperation(value = "api接口文档")
    @GetMapping("")
    public String api() {
        return "小张，瞧啥瞧！！！";
    }
}
