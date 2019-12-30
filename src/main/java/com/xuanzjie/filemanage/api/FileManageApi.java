package com.xuanzjie.filemanage.api;

import com.xuanzjie.filemanage.response.ResResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xuan
 * @Date: 2019/12/30 10:55
 * @Description:
 */
@FeignClient(value = "file-manage")
public interface FileManageApi {


    /**
     * 文件上传
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/file/upload")
    ResResult<Integer> uploadFile(HttpServletRequest request, HttpServletResponse response);

    /**
     * 测试
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "/file/test")
    ResResult<String> test(HttpServletRequest request, HttpServletResponse response);
}
