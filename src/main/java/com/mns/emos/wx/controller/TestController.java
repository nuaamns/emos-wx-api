package com.mns.emos.wx.controller;

import com.mns.emos.wx.common.util.R;
import com.mns.emos.wx.controller.form.TestSayHelloForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
@Api("test web interface")
public class TestController {

    @PostMapping("/sayHello")
    @ApiOperation("test test")
    public R sayHello(@Valid @RequestBody TestSayHelloForm form) {
        return R.ok().put("message", "Hello, " + form.getName());
    }

    @PostMapping("/addUser")
    @ApiOperation("添加用户")
    @RequiresPermissions(value = {"A", "B"}, logical = Logical.OR)
    public R addUser() {
        return R.ok("用户添加成功");
    }
}
