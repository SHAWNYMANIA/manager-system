package com.msr.controller;

import com.msr.utils.QuartzSchedulerUtils;
import org.quartz.CronExpression;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class QuartzController {
    @Autowired
    private QuartzSchedulerUtils quartzSchedulerUtils;

    // @Description: 获取定时器信息
    @GetMapping("/info")
    public String getQuartzJob(String name, String group) {
        String info = null;
        try {
            info = quartzSchedulerUtils.getJobInfo(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return info;
    }

    // @Description: 修改定时器的 执行时间
    @PostMapping("/modify")
    public boolean modifyQuartzJob(String name, String group, String time) {
        boolean flag = true;

        if (!CronExpression.isValidExpression(time)) {
            throw new RuntimeException("非法的cron表达式");
        }

        try {
            flag = quartzSchedulerUtils.modifyJob(name, group, time);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return flag;
    }

    // @Description: 启动所有定时器
    @PostMapping("/start")
    public void startQuartzJob() {
        try {
            quartzSchedulerUtils.startJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    // @Description: 暂停指定 定时器
    @PostMapping(value = "/pause")
    public void pauseQuartzJob(String name, String group) {
        try {
            quartzSchedulerUtils.pauseJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    // 暂停所有定时器
    @PostMapping(value = "/pauseAll")
    public void pauseAllQuartzJob() {
        try {
            quartzSchedulerUtils.pauseAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    // 删除指定定时器
    @PostMapping(value = "/delete")
    public void deleteJob(String name, String group) {
        try {
            quartzSchedulerUtils.deleteJob(name, group);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}