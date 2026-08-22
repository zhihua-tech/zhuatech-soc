/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.soc;
import cn.zhuatech.soc.service.IncidentEscalationService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class IncidentEscalationServiceTests {private final IncidentEscalationService service=new IncidentEscalationService();
 @Test void escalatesActiveExfiltration(){var r=service.evaluate(new IncidentEscalationService.Request("P1",5,true,true,false,20,15));assertEquals("CRITICAL_ESCALATION",r.status());}
 @Test void monitorsContainedLowSeverityEvent(){var r=service.evaluate(new IncidentEscalationService.Request("P4",1,false,false,true,5,30));assertEquals("MONITOR",r.status());}}
