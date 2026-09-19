/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.soc.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class SecurityIncidentClosureServiceTest {
    private final SecurityIncidentClosureService service = new SecurityIncidentClosureService();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void closesControlledIncident() {
        var result = service.assess(new SecurityIncidentClosureService.Request("I1", true, true, true,
                true, true, true, true, true, true, 0));
        assertThat(result.decision()).isEqualTo(SecurityIncidentClosureService.Decision.CLOSE);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void reviewsIncompleteLearningCycle() {
        var result = service.assess(new SecurityIncidentClosureService.Request("I2", true, true, true,
                true, false, false, false, false, false, 0));
        assertThat(result.actions()).hasSize(3);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksUnsafeClosure() {
        var result = service.assess(new SecurityIncidentClosureService.Request("I3", false, false, false,
                false, true, true, false, true, true, 2));
        assertThat(result.blockers()).hasSize(6);
    }
}
