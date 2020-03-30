package com.xuanzjie.filemanage.service.impl;

import com.xuanzjie.filemanage.service.FileManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: xuan
 * @Date: 2019/12/30 11:08
 * @Description:
 */
@Service
@Slf4j
public class FileManageServiceImpl implements FileManageService {

    public final static String FILE_PATH = "E:\\upload\\";

    @Override
    public Integer uploadFile(HttpServletRequest request, HttpServletResponse response) {
        List<MultipartFile> fileList = ((MultipartHttpServletRequest) request).getFiles("fileList");
        return upload(fileList);
    }

    @Override
    public Integer uploadFileTest(MultipartFile file) {

        if (file == null) {
            return 0;
        }
        String fileName = file.getOriginalFilename();
        File file1 = new File(FILE_PATH + fileName);
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    private Integer upload(List<MultipartFile> fileList) {

        for (MultipartFile multipartFile : fileList) {
            String fileName = multipartFile.getOriginalFilename();
            File file = new File(FILE_PATH + fileName);
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
                log.warn("上传文件出错 {} ", multipartFile.getOriginalFilename());
            }
        }
        log.info("上传文件数量：{}", fileList.size());
        return fileList.size();
    }
}
