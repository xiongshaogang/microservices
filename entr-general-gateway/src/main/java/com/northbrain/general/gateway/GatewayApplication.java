package com.northbrain.general.gateway;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

import com.northbrain.base.common.model.bo.BaseType;
import com.northbrain.base.common.model.bo.Constants;
import com.northbrain.base.common.model.bo.Errors;
import com.northbrain.base.common.model.bo.Hints;
import com.northbrain.base.common.util.LauncherUitl;
import com.northbrain.base.common.util.StackTracerUtil;

@EnableZuulProxy
@SpringCloudApplication
@ComponentScan({"com.northbrain"})
public class GatewayApplication
{
    private static Logger logger = Logger.getLogger(GatewayApplication.class);

    public static void main(String[] arguments)
    {
        try
        {
            if(LauncherUitl.parseCommandLine(arguments))
            {
                //初始化属性配置，从application.properties中读取业务的基础配置参数。
                LauncherUitl.initProperties(BaseType.SERVICETYPE.ORCH);
                //设置域名
                LauncherUitl.appendParameter(Constants.STORAGE_ZOOKEEPER_STORAGE_NAMESPACE,
                        Constants.STORAGE_ZOOKEEPER_DOMAIN_NAMESPACE_NAME,
                        Constants.STORAGE_ZOOKEEPER_GATEWAY_NAMESPACE);
                //设置应用名称
                LauncherUitl.appendParameter(Constants.STORAGE_ZOOKEEPER_BUSINESS_NAMESPACE,
                        Constants.BUSINESS_COMMON_APPLICATION_NAME,
                        Constants.SYSTEM_GENERAL_GATEWAY_ENTR_MICROSERVICE);
                //设置日志级别
                LauncherUitl.setLog();

                logger.info(Hints.HINT_SYSTEM_PROCESS_SYSTEM_STARTUP);

                //设置服务名称
                Map<String, Object> defaultProperties = new HashMap<>();
                defaultProperties.put(Constants.SYSTEM_SPRING_PROPERTY_APPLICATION_NAME,
                        Constants.SYSTEM_GENERAL_GATEWAY_ENTR_MICROSERVICE);

                //设置spring.application.name
                SpringApplication springApplication = new SpringApplication(GatewayApplication.class);
                springApplication.setDefaultProperties(defaultProperties);

                //启动服务
                springApplication.run(arguments);
            }
            else
            {
                logger.error(Errors.ERROR_SYSTEM_PARSE_COMMAND_LINE);
            }
        }
        catch (Exception exception)
        {
            logger.error(StackTracerUtil.getExceptionInfo(exception));
        }
        catch (Throwable throwable)
        {
            logger.error(StackTracerUtil.getExceptionInfo(throwable));
        }
    }
}
