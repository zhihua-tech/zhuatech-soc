/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.soc.controller;

import cn.zhuatech.soc.common.ApiResponse;
import cn.zhuatech.soc.service.SecurityIncidentClosureService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/soc")
public class SecurityIncidentClosureController {
    private final SecurityIncidentClosureService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public SecurityIncidentClosureController(SecurityIncidentClosureService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/incident-closure")
    public ApiResponse<SecurityIncidentClosureService.Assessment> assess(
            @Valid @RequestBody SecurityIncidentClosureService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
