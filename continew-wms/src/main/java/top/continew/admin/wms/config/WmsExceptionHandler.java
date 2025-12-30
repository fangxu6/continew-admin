package top.continew.admin.wms.config;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.hutool.core.util.StrUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.continew.admin.common.enums.ResultCodeEnum;
import top.continew.admin.common.exception.BusinessException;
import top.continew.admin.common.model.dto.ResponseDTO;
import top.continew.starter.log.annotation.LogRecord;

/**
 * WMS模块异常处理配置
 *
 * @author 小aron
 * @since 2025/12/30
 */
@Slf4j
@RestControllerAdvice(basePackages = "top.continew.admin.wms")
@RequiredArgsConstructor
public class WmsExceptionHandler {

    /**
     * 业务异常处理
     */
    @LogRecord
    @ExceptionHandler(BusinessException.class)
    public ResponseDTO<Void> handleBusinessException(HttpServletRequest request, BusinessException e) {
        log.error("WMS模块业务异常: {}", e.getMessage(), e);
        return ResponseDTO.<Void>builder()
            .code(e.getCode())
            .message(e.getMessage())
            .path(request.getRequestURI())
            .build();
    }

    /**
     * 未登录异常处理
     */
    @LogRecord
    @ExceptionHandler(NotLoginException.class)
    public ResponseDTO<Void> handleNotLoginException(HttpServletRequest request, NotLoginException e) {
        log.error("WMS模块未登录异常: {}", e.getMessage(), e);
        return ResponseDTO.<Void>builder()
            .code(ResultCodeEnum.NOT_LOGIN.getCode())
            .message("请先登录")
            .path(request.getRequestURI())
            .build();
    }

    /**
     * 无权限异常处理
     */
    @LogRecord
    @ExceptionHandler(NotPermissionException.class)
    public ResponseDTO<Void> handleNotPermissionException(HttpServletRequest request, NotPermissionException e) {
        log.error("WMS模块无权限异常: {}", e.getMessage(), e);
        return ResponseDTO.<Void>builder()
            .code(ResultCodeEnum.FORBIDDEN.getCode())
            .message("权限不足")
            .path(request.getRequestURI())
            .build();
    }

    /**
     * 无角色异常处理
     */
    @LogRecord
    @ExceptionHandler(NotRoleException.class)
    public ResponseDTO<Void> handleNotRoleException(HttpServletRequest request, NotRoleException e) {
        log.error("WMS模块无角色异常: {}", e.getMessage(), e);
        return ResponseDTO.<Void>builder()
            .code(ResultCodeEnum.FORBIDDEN.getCode())
            .message("角色不足")
            .path(request.getRequestURI())
            .build();
    }

    /**
     * 其他异常处理
     */
    @LogRecord
    @ExceptionHandler(Exception.class)
    public ResponseDTO<Void> handleException(HttpServletRequest request, Exception e) {
        log.error("WMS模块系统异常: {}", e.getMessage(), e);
        return ResponseDTO.<Void>builder()
            .code(ResultCodeEnum.SYSTEM_ERROR.getCode())
            .message("系统异常")
            .path(request.getRequestURI())
            .build();
    }
}