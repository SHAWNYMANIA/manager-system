package com.msr.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.msr.entity.Proprietor;
import com.msr.entity.Qfee;
import com.msr.service.IProprietorService;
import com.msr.service.IQfeeService;
import com.msr.utils.AppContextUtil;
import com.msr.utils.SendsmsUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Job1 implements Job {
    //定义qfeeService对象
    @Autowired
    private IQfeeService qfeeService;
    @Autowired
    private IProprietorService proprietorService;



    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private void before() {

        qfeeService = (IQfeeService) AppContextUtil.getBean("qfeeServiceImpl");
        proprietorService = (IProprietorService) AppContextUtil.getBean("proprietorServiceImpl");

        System.out.println("任务1：开始执行-" + dateFormat.format(new Date()));
    }

    // 需求：在固定时间，给欠费的业主手机发送通知信息
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        before();
        System.out.println("任务1：业务逻辑。。。");
        // 构造条件对象
        QueryWrapper<Qfee> qfeeQueryWrapper = new QueryWrapper<>();
        // status值为0代表是欠费状态
        qfeeQueryWrapper.eq("status",0);
        // 获取所有欠费的信息
        List<Qfee> qfeeList = qfeeService.list(qfeeQueryWrapper);
        for(Qfee qfee : qfeeList){
            // 根据ID获取业主对象
            Proprietor proprietor = proprietorService.getById(qfee.getProprietorid());
            System.out.println("手机号码"+proprietor.getPhone());
            SendsmsUtils.send(proprietor.getPhone()); // 发送短信息通知
        }
        after();
    }

    private void after() {
        System.out.println("任务1：执行结束");
        System.out.println();
    }
}