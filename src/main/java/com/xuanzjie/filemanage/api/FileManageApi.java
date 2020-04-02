package com.xuanzjie.filemanage.api;

import com.xuanzjie.personnelmanage.utils.ResResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    @PostMapping(value = "/upload")
    ResResult<Integer> uploadFile(HttpServletRequest request, HttpServletResponse response);

    /**
     * 文件上传测试
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/uploadTest")
    ResResult<Integer> uploadFileTest(@RequestParam("file") MultipartFile file);

    /**
     * 测试
     *
     * @return
     */
    @GetMapping(value = "/test")
    ResResult<String> test();
}
