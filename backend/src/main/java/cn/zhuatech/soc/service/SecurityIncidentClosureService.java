/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.soc.service;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityIncidentClosureService {
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.containmentVerified()) blockers.add("遏制措施未验证");
        if (!request.evidencePreserved()) blockers.add("事件证据未完整保全");
        if (!request.scopeConfirmed()) blockers.add("影响范围尚未确认");
        if (!request.eradicationVerified()) blockers.add("威胁清除未验证");
        if (request.notificationRequired() && !request.notificationCompleted()) blockers.add("法定或客户通知未完成");
        if (request.openCriticalActions() > 0) blockers.add("仍有未关闭的重大处置项");
        if (!blockers.isEmpty()) {
            actions.add("保持事件开启并升级未完成的关键处置");
            return new Assessment(Decision.BLOCKED, blockers, actions);
        }
        if (!request.recoveryMonitored() || !request.rootCauseApproved() || !request.lessonsShared()) {
            if (!request.recoveryMonitored()) actions.add("完成恢复观察期和复发监控");
            if (!request.rootCauseApproved()) actions.add("完成根因分析审批");
            if (!request.lessonsShared()) actions.add("沉淀复盘结论并更新响应预案");
            return new Assessment(Decision.REVIEW, blockers, actions);
        }
        actions.add("批准事件结案并归档证据、时间线和改进任务");
        return new Assessment(Decision.CLOSE, blockers, actions);
    }

    public record Request(@NotBlank String incidentId, boolean containmentVerified, boolean evidencePreserved,
                          boolean scopeConfirmed, boolean eradicationVerified, boolean recoveryMonitored,
                          boolean notificationRequired, boolean notificationCompleted, boolean rootCauseApproved,
                          boolean lessonsShared, @Min(0) int openCriticalActions) {}
    public record Assessment(Decision decision, List<String> blockers, List<String> actions) {}
    public enum Decision { CLOSE, REVIEW, BLOCKED }
}
