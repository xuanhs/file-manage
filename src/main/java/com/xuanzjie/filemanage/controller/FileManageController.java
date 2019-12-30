package com.xuanzjie.filemanage.controller;

import com.xuanzjie.filemanage.api.FileManageApi;
import com.xuanzjie.filemanage.response.ResResult;
import com.xuanzjie.filemanage.service.FileManageService;
import com.xuanzjie.filemanage.utils.ResUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xuan
 * @Date: 2019/12/30 11:07
 * @Description:
 */
@RestController
public class FileManageController implements FileManageApi {

    @Autowired
    FileManageService fileManageService;
    @Override
    public ResResult<Integer> uploadFile(HttpServletRequest request, HttpServletResponse response) {
        return ResUtils.data(fileManageService.uploadFile(request,response));
    }

    @Override
    public ResResult<String> test(HttpServletRequest request, HttpServletResponse response) {
        return ResUtils.data("测试测试");
    }
}
