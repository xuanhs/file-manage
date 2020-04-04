package com.xuanzjie.filemanage.controller;

import com.xuanzjie.filemanage.api.FileManageApi;
import com.xuanzjie.filemanage.service.FileManageService;
import com.xuanzjie.filemanage.wrapper.FileWrapper;
import com.xuanzjie.personnelmanage.api.UserServiceApi;
import com.xuanzjie.personnelmanage.utils.ResResult;
import com.xuanzjie.personnelmanage.utils.ResUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    UserServiceApi userServiceApi;

    @Override
    public ResResult<Integer> uploadFile(HttpServletRequest request, HttpServletResponse response) {
        return ResUtils.data(fileManageService.uploadFile(request, response));
    }

    @Override
    public ResResult<Integer> uploadCourseImage(HttpServletRequest request, HttpServletResponse response,
                                                FileWrapper.CourseCoverDTO courseCoverDTO) {
        return ResUtils.data(fileManageService.uploadCourseImage( request,response,courseCoverDTO));
    }

    @Override
    public ResResult<Integer> uploadFileTest(MultipartFile file) {
        return ResUtils.data(fileManageService.uploadFileTest(file));
    }

    @Override
    public ResResult<String> test() {
        return userServiceApi.test();
    }

}
