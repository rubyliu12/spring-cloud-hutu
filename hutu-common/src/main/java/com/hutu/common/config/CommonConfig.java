package com.hutu.common.config;

import com.hutu.common.handler.GlobalExceptionHandler;
import com.hutu.common.handler.CustomRestNotFoundHandler;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 引入controller全局异常处理和自定义404处理
 *
 * ErrorMvcAutoConfiguration 会先配置 BasicErrorController导致 404 mapping重复
 * 此处在 ErrorMvcAutoConfiguration 之前配置会导致 BasicErrorController 不装载。
 * 详情看 BasicErrorController 装载条件。
 */
@Import({GlobalExceptionHandler.class, CustomRestNotFoundHandler.class})
@Configuration
@AutoConfigureBefore(ErrorMvcAutoConfiguration.class)
public class CommonConfig {
}
