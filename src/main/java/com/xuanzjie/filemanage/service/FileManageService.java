package com.xuanzjie.filemanage.service;

import com.xuanzjie.filemanage.wrapper.FileWrapper;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: xuan
 * @Date: 2019/12/30 11:08
 * @Description:
 */
public interface FileManageService {

    Integer uploadFile(HttpServletRequest request, HttpServletResponse response);

    Integer uploadCourseImage(HttpServletRequest request, HttpServletResponse response,
                              FileWrapper.CourseCoverDTO courseCoverDTO);

    Integer uploadFileTest(MultipartFile file);
}
