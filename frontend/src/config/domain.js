/* Copyright 2026 上海如静知华信息科技有限公司 */
export const domain={
 code:'SOC',systemName:'安全运营中心平台',englishName:'SECURITY OPERATIONS CENTER',theme:{primary:'#315978',dark:'#1e2d3a',accent:'#c67643'},
 workspace:'信息安全部 / 安全运营中心',fieldWorkspace:'威胁监测一组',period:'2026-08-01 · 日班',liveText:'安全事件流于 10:42 更新',fieldContextLabel:'当前值班组',fieldContext:'日班 · L2 分析',fieldUser:'陆遥',fieldRole:'安全分析师',adminUser:'何谨',adminRole:'安全运营经理',
 adminTitle:'企业安全运营指挥中心',adminBreadcrumb:'安全运营 / 实时态势',adminSubtitle:'统一查看告警、事件、威胁情报、资产风险、响应进度与运营指标。',exportAction:'生成安全态势日报',createAction:'启动事件调查',
 chartTitle:'安全告警处置趋势',chartSubtitle:'累计关闭率 / 运营目标',chartLabels:['08:00','09:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00'],loadTitle:'检测场景负荷',loadSubtitle:'开放告警占班次处理能力',recordsTitle:'高优先级安全事件',recordsSubtitle:'按风险等级、资产重要性与响应时限排序',issueTitle:'关键安全风险',issueSubtitle:'需要安全运营经理协调的事项',
 recordName:'安全事件',itemName:'检测场景',unitName:'处置小组',batchName:'风险等级',planName:'调查项',doneName:'已确认',exceptionName:'未关闭',unitLabel:'项',
 listBreadcrumb:'事件响应 / 调查中心',listSubtitle:'管理告警归并、证据研判、影响确认、响应处置与复盘归档。',listSummary:[['今日告警','1,286'],['有效事件','38'],['待调查事件','12'],['高危事件','3',true]],tabs:['全部','待研判','调查中','处置中','已关闭'],
 fieldBreadcrumb:'安全运营 / 分析师工作台',fieldTitle:'威胁监测一组工作台',fieldSubtitle:'当前 7 个调查任务 · 3 个高危事件 · 安全分析师陆遥',fieldSecondary:'查看值班交接',reportAction:'提交研判',fieldNoticeTitle:'采集与检测链路运行正常',fieldNotice:'日志覆盖率 98.6%，关键资产采集无中断',
 steps:['告警确认','证据研判','影响界定','响应处置','复盘关闭'],documentAction:'查看响应手册',printAction:'导出证据包',resourceCardTitle:'检测能力状态',resourceValueLabel:'在线检测规则',resourceHealthLabel:'日志覆盖率',quickSubtitle:'安全分析师常用入口',quickActions:[['研判更新','/shopfloor/report','结论、证据与处置建议'],['情报检索','/shopfloor/material','IOC、攻击组织与技战术'],['资产查询','/shopfloor/resources','重要性、漏洞与负责人'],['事件升级','/shopfloor/andon','入侵、泄漏与业务影响']],
 reportDefaults:[6,1],reportTitle:'安全事件研判',reportSubtitle:'记录证据数量、未关闭事项和研判结论。',reportSuccess:'研判结果已写入事件时间线',reportPlaceholder:'填写攻击路径、影响资产、证据判断和处置建议',reportFootnote:'提交后自动关联威胁情报和资产上下文',ruleTitle:'事件响应目标',ruleSubtitle:'SEC-INC-P1 · V5.3',rules:[['首次研判','≤ 15 分钟'],['遏制目标','≤ 60 分钟'],['证据保留','180 天'],['响应手册','有效',true]],fieldTotals:[['38','有效安全事件'],['3','高危事件'],['12','待调查'],['98.6%','日志覆盖率']],
 adminMenus:[['/admin','home','安全指挥中心'],['/admin/work-orders','order','事件调查'],['/admin/samples','box','告警中心'],['/admin/schedule','calendar','值班计划'],['/admin/methods','process','检测规则'],['/admin/reviews','quality','响应复盘'],['/admin/resources','machine','资产与情报'],['/admin/report','chart','运营分析']],
 fieldMenus:[['/shopfloor','home','分析师工作台'],['/shopfloor/report','report','研判更新'],['/shopfloor/tasks','order','调查任务'],['/shopfloor/material','box','情报检索'],['/shopfloor/resources','machine','资产查询'],['/shopfloor/andon','risk','事件升级',3]],
 moduleTitles:{tasks:['调查任务','查看风险等级、影响资产与响应期限'],material:['情报检索','搜索 IOC、攻击组织、漏洞和技战术'],resources:['资产查询','查看资产重要性、暴露面和安全责任人'],andon:['事件升级','发起重大安全事件和跨部门响应'],samples:['告警中心','管理原始告警、归并规则和误报反馈'],schedule:['值班计划','协调班次、交接和重大活动保障'],methods:['检测规则','维护查询逻辑、阈值与 MITRE 映射'],reviews:['响应复盘','评估处置效果、根因和改进措施'],report:['运营分析','分析 MTTD、MTTR、告警质量和风险趋势']},
 tagline:'让安全告警转化为及时、可验证的响应行动',storyTitle:'从海量信号到事件闭环，<br/>每一次判断都有证据支撑。',storyText:'连接日志、检测、情报、资产和响应团队的企业安全运营底座。',pattern:[1,3,4,7,10,12,15,18,21,24,27,30],loginStats:[['98.6%','日志覆盖率'],['38','今日有效事件'],['18 min','平均研判时间']],loginTitle:'企业安全运营中心',adminDemo:'告警 / 事件 / 情报',fieldDemo:'研判 / 证据 / 响应'
}
export const records=[
 {no:'SEC-260801-018',name:'财务终端异常凭据访问调查',code:'DET-CRED-ACCESS',unit:'威胁监测一组',group:'安全运营中心',plan:12,done:7,exception:2,due:'08-01',batch:'高危 P1',status:'调查中',progress:62,priority:'加急'},
 {no:'SEC-260801-021',name:'公网应用可疑文件上传行为',code:'DET-WEB-UPLOAD',unit:'应用安全组',group:'信息安全部',plan:8,done:6,exception:1,due:'08-01',batch:'中危 P2',status:'处置中',progress:78,priority:'关注'},
 {no:'SEC-260802-006',name:'海外账号异常登录聚类分析',code:'DET-UEBA-LOGIN',unit:'身份安全组',group:'信息安全部',plan:16,done:0,exception:0,due:'08-02',batch:'中危 P2',status:'待研判',progress:18,priority:'正常'},
 {no:'SEC-260731-015',name:'邮件钓鱼活动溯源调查',code:'DET-MAIL-PHISH',unit:'威胁监测二组',group:'安全运营中心',plan:10,done:10,exception:0,due:'08-01',batch:'高危 P1',status:'已关闭',progress:100,priority:'正常'},
 {no:'SEC-260801-024',name:'核心数据库批量导出告警',code:'DET-DB-EXPORT',unit:'数据安全组',group:'信息安全部',plan:9,done:4,exception:3,due:'08-01',batch:'高危 P1',status:'升级处置',progress:48,priority:'加急'}]
export const resources=[{code:'DET-ENDPOINT-01',name:'终端威胁检测能力',unit:'安全运营中心',status:'在线',health:97,value:'186',valueUnit:'条',note:'覆盖 8,642 个终端资产'},{code:'DET-CLOUD-02',name:'云工作负载检测能力',unit:'云安全组',status:'在线',health:91,value:'74',valueUnit:'条',note:'覆盖 12 个云账号'},{code:'DET-DATA-03',name:'数据库行为检测能力',unit:'数据安全组',status:'预警',health:72,value:'38',valueUnit:'条',note:'两套数据库日志延迟'}]
export const reviews=[{no:'SOC-260801-032',title:'财务终端事件升级评审',type:'影响确认',detail:'14 台资产 · 何谨',result:'待确认'},{no:'SOC-260801-011',title:'钓鱼邮件处置复盘',type:'事件复盘',detail:'遏制 36 分钟 · 陆遥',result:'通过'},{no:'SOC-260728-018',title:'数据库日志覆盖检查',type:'检测健康',detail:'缺口 2 套',result:'异常'}]
export const adminMetrics=[['今日原始告警','1,286','同比昨日减少 8%','blue'],['有效事件','38','告警转化率 3.0%','green'],['待调查事件','12','其中 4 项临近 SLA','orange'],['高危事件','3','均已启动响应','red']]
export const fieldMetrics=[['我的调查','7','3 个高危事件','blue'],['今日已关闭','11','平均 1.8 小时','green'],['待研判','12','4 项临近 SLA','orange'],['检测覆盖','98.6%','关键资产正常','slate']]
export const chartActual=[18,29,38,49,57,68,76,84,89],chartTarget=[20,31,42,53,64,73,82,90,95]
export const loads=[['终端安全检测',89,'开放事件 14 个'],['身份与访问检测',82,'开放事件 9 个'],['应用安全检测',76,'开放事件 8 个'],['数据安全检测',68,'开放事件 7 个']]
export const issues=[{type:'入侵',title:'财务终端出现横向访问行为',detail:'涉及 14 台资产 · 已隔离 9 台',status:'响应中'},{type:'数据',title:'核心数据库批量导出待确认',detail:'异常访问账号 2 个',status:'调查中'},{type:'采集',title:'两套数据库审计日志延迟',detail:'延迟约 18 分钟',status:'修复中'}]
