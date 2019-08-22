# Serendipity-cloud

[========]

## 项目目录
```
|-cloud  
    |-server    # 基础服务
        |-config    # 配置中心
        |-eureka    # 注册中心
        |-zuul      # 网关
    |-provider  # 服务提供者
        |-hello     # hello服务提供者
    |-consumer  # 服务消费者
        |-feign     # feign服务消费者
        |-ribbon    # ribbon服务消费者
    |-orm       # orm映射
        |-jdbc      # Jdbc-Demo
        |-jpa       # Jpa-Demo
        |-mybatis   # Mybatis-Demo
        |-model     # 公共入参返参实体
    |-monitor   # 监控
        |-admin     # Spring boot admin监控组件
        |-hystrix   # Hystrix 熔断器监控组件
        |-turbine   # Turbine 熔断器汇聚监控组件 
        |-zipkin    # Zipkin 链路追踪监控组件
    |-common    # 公共服务
        |-email     # 邮件公共服务
        |-security  # 权限组件
```

[========]

### 说明：
 | 服务名称 | 功能 |
 | --- | --- |
 | config | 启动配置中心提供给其余组件配置文件 |
 | eureka | 启动注册中心提供服务检索 |
 | zuul | 启动网关提供路由信息 |
 | customer-server | 启动用户自定义服务 |

[========]

###  启动流程
```flow
st=>start: config
configOpt=>operation: 启动配置中心
configCond=>condition: 是否启动成功
eurekaOpt=>operation: 启动注册中心
eurekaCond=>condition: 是否启动成功
zuulOpt=>operation: 启动API网关
zuulCond=>condition: 是否启动成功
customer=>operation: 启动customer服务
e=>end: cloud启动完成
error=>end: cloud启动失败
exception=>end: API网关启动失败

st->configOpt
configOpt->configCond
configCond(yes)->eurekaOpt
configCond(no)->error
eurekaOpt->eurekaCond
eurekaCond(yes)->zuulOpt
eurekaCond(no)->error
zuulOpt->zuulCond
zuulCond(yes)->customer
zuulCond(no)->exception
customer->e
```

[========]

### 数据源
orm均为Spring Boot2.1.X下的多数据源配置
单数据源正常配置即可
注：多数据源下 Spring事务 没有测试

[========]

### 配置中心
需要拉取配置的项目添加/resources/bootstrap.yml
修改相应配置项

[========]

### 其余服务
均提供模版项目，相应功能按需提取

[========]

## TODO
monitor-admin 缺少日志监控/接入更多端点

### 日志模块
1. 在consumer-feign->resources/logback-spring.xml中包含
2. 异步输出日志只需要添加对应的appender即可

### 启动优化
*java -server -Xms512m -Xmx512m  -jar springboot-1.0.jar*
1. 设置JVM使用server模式。64位JDK默认启动该模式
2. -Xms :设置Java堆栈的初始化大小
3. -Xmx :设置最大的java堆大小
   
建议设置相同大小，避免Java堆内存自动扩缩容




