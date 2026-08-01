/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.soc.config;

import cn.zhuatech.soc.model.*;
import cn.zhuatech.soc.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seed(OperatingUnitRepository operatingUnits, WorkRecordRepository orders,
                           ResourceRegisterRepository resources, ReviewRecordRepository reviewRecords,
                           UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (operatingUnits.count() > 0) return;
            OperatingUnit primaryUnit = operatingUnits.save(new OperatingUnit("SOC-MONITOR", "威胁监测一组", "安全运营中心", 180));
            OperatingUnit secondaryUnit = operatingUnits.save(new OperatingUnit("SOC-APP", "应用安全组", "应用安全组", 120));
            OperatingUnit tertiaryUnit = operatingUnits.save(new OperatingUnit("SOC-DATA", "数据安全组", "信息安全部", 96));

            WorkRecord t1 = orders.save(new WorkRecord("FC-260801-018", "DET-CRED-ACCESS", "财务终端异常凭据访问调查", tertiaryUnit, 24, 16, 1, LocalDate.now().plusDays(1), WorkRecord.Status.RUNNING, "GW-Q3"));
            WorkRecord t2 = orders.save(new WorkRecord("FC-260801-021", "DET-WEB-UPLOAD", "公网应用可疑文件上传行为", primaryUnit, 18, 8, 0, LocalDate.now().plusDays(1), WorkRecord.Status.RUNNING, "TERM-12"));
            WorkRecord t3 = orders.save(new WorkRecord("BUD-260802-006", "DET-UEBA-LOGIN", "海外账号异常登录聚类分析", secondaryUnit, 12, 0, 0, LocalDate.now().plusDays(3), WorkRecord.Status.RELEASED, "SP-2026"));
            WorkRecord t4 = orders.save(new WorkRecord("FC-260728-015", "DET-MAIL-PHISH", "邮件钓鱼活动溯源调查", primaryUnit, 20, 20, 1, LocalDate.now(), WorkRecord.Status.COMPLETED, "SEA-09"));

            resources.saveAll(List.of(
                new ResourceRegister("CAT-HPLC-03", "终端威胁检测能力", primaryUnit, ResourceRegister.Status.RUNNING, 88),
                new ResourceRegister("CAT-ICP-02", "云工作负载检测能力", primaryUnit, ResourceRegister.Status.IDLE, 76),
                new ResourceRegister("CAT-UTM-05", "数据库行为检测能力", tertiaryUnit, ResourceRegister.Status.RUNNING, 91),
                new ResourceRegister("CAT-INC-08", "告警关联引擎", secondaryUnit, ResourceRegister.Status.ALARM, 62)
            ));
            reviewRecords.saveAll(List.of(
                new ReviewRecord("ISS-260801-032", t1, "事件影响复核", 6, 0, ReviewRecord.Result.PASSED, "何谨"),
                new ReviewRecord("ISS-260801-011", t2, "检测规则校验", 3, 0, ReviewRecord.Result.PASSED, "陆遥"),
                new ReviewRecord("ISS-260801-018", t4, "事件关闭复核", 5, 1, ReviewRecord.Result.FAILED, "何谨"),
                new ReviewRecord("ISS-260802-003", t3, "调查范围确认", 4, 0, ReviewRecord.Result.PENDING, "陆遥")
            ));
            String demo = encoder.encode("Demo@2026");
            users.saveAll(List.of(
                new UserAccount("operator", demo, "陆遥", UserAccount.Role.DOMAIN_USER, "SOC-MONITOR"),
                new UserAccount("planner", demo, "何谨", UserAccount.Role.DOMAIN_OPERATOR, null),
                new UserAccount("quality", demo, "顾清", UserAccount.Role.QUALITY, null),
                new UserAccount("admin", encoder.encode("ZhuaTech@2026"), "系统管理员", UserAccount.Role.ADMIN, null)
            ));
        };
    }
}
