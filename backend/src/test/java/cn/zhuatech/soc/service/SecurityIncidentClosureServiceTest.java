/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.soc.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SecurityIncidentClosureServiceTest {
    private final SecurityIncidentClosureService service = new SecurityIncidentClosureService();
    @Test void closesControlledIncident() {
        var result = service.assess(new SecurityIncidentClosureService.Request("I1", true, true, true,
                true, true, true, true, true, true, 0));
        assertThat(result.decision()).isEqualTo(SecurityIncidentClosureService.Decision.CLOSE);
    }
    @Test void reviewsIncompleteLearningCycle() {
        var result = service.assess(new SecurityIncidentClosureService.Request("I2", true, true, true,
                true, false, false, false, false, false, 0));
        assertThat(result.actions()).hasSize(3);
    }
    @Test void blocksUnsafeClosure() {
        var result = service.assess(new SecurityIncidentClosureService.Request("I3", false, false, false,
                false, true, true, false, true, true, 2));
        assertThat(result.blockers()).hasSize(6);
    }
}
