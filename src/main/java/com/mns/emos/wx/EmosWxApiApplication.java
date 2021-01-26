package com.mns.emos.wx;

import cn.hutool.core.util.StrUtil;
import com.mns.emos.wx.config.SystemConstants;
import com.mns.emos.wx.db.dao.SysConfigDao;
import com.mns.emos.wx.db.pojo.SysConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.List;

@SpringBootApplication
@ServletComponentScan
@Slf4j
public class EmosWxApiApplication {

    @Autowired
    private SysConfigDao sysConfigDao;

    @Autowired
    private SystemConstants constants;

    public static void main(String[] args) {
        SpringApplication.run(EmosWxApiApplication.class, args);
    }

    @PostConstruct
    public void init() {
        List<SysConfig> sysConfigs = sysConfigDao.selectAllParam();
        sysConfigs.forEach(sysConfig -> {
            String key = sysConfig.getParamKey();
            key = StrUtil.toCamelCase(key);
            String value = sysConfig.getParamValue();
            try {
                Field field = constants.getClass().getDeclaredField(key);
                field.set(constants, value);
            } catch (Exception e) {
                log.error("执行异常", e);
            }
        });
    }


}
