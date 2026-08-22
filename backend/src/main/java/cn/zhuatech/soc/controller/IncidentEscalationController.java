/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.soc.controller;
import cn.zhuatech.soc.common.ApiResponse;import cn.zhuatech.soc.service.IncidentEscalationService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/soc/insights/incident-escalation") public class IncidentEscalationController {private final IncidentEscalationService service;public IncidentEscalationController(IncidentEscalationService service){this.service=service;}@PostMapping ApiResponse<IncidentEscalationService.Result> evaluate(@Valid @RequestBody IncidentEscalationService.Request request){return ApiResponse.ok(service.evaluate(request));}}
