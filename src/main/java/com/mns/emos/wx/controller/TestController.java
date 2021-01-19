package com.mns.emos.wx.controller;

import com.mns.emos.wx.common.util.R;
import com.mns.emos.wx.controller.form.TestSayHelloForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
}
