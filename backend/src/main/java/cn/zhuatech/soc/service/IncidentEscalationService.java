/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.soc.service;
import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service public class IncidentEscalationService {
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public Result evaluate(Request r){int score=switch(r.severity().toUpperCase()){case "P1"->60;case "P2"->40;case "P3"->20;default->5;};List<String> reasons=new ArrayList<>();if(r.activeExfiltration()){score+=50;reasons.add("检测到持续数据外泄");}if(r.privilegedAccount()){score+=30;reasons.add("涉及特权账户");}score+=Math.min(20,r.affectedAssets()*2);if(r.ageMinutes()>=r.responseSlaMinutes()){score+=20;reasons.add("响应已超过 SLA");}if(r.contained())score-=30;score=Math.max(0,Math.min(100,score));String status=score>=90?"CRITICAL_ESCALATION":score>=50?"ESCALATE":"MONITOR";if(reasons.isEmpty())reasons.add("继续监控告警证据和影响范围");return new Result(score,status,reasons,status.equals("CRITICAL_ESCALATION")?"立即启动重大事件响应并通知管理层":"按分级流程处置并更新事件记录");}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Request(@Pattern(regexp="(?i)P1|P2|P3|P4") String severity,@Min(1) int affectedAssets,@NotNull Boolean privilegedAccount,@NotNull Boolean activeExfiltration,@NotNull Boolean contained,@Min(0) int ageMinutes,@Min(1) int responseSlaMinutes){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Result(int escalationScore,String status,List<String> reasons,String action){}
}
