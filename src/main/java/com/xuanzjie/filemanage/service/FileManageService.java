package com.xuanzjie.filemanage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xuan
 * @Date: 2019/12/30 11:08
 * @Description:
 */
public interface FileManageService {

    Integer uploadFile(HttpServletRequest request, HttpServletResponse response);
}
