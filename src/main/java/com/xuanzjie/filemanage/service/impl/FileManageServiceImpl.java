package com.xuanzjie.filemanage.service.impl;

import com.xuanzjie.filemanage.service.FileManageService;
import com.xuanzjie.filemanage.wrapper.FileWrapper;
import com.xuanzjie.personnelmanage.api.FileServiceApi;
import com.xuanzjie.personnelmanage.pojo.dto.FileBaseDTO;
import com.xuanzjie.personnelmanage.pojo.vo.EntitySaveVO;
import com.xuanzjie.personnelmanage.utils.DateUtils;
import com.xuanzjie.personnelmanage.utils.ResResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
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

    public final static String FILE_PATH = "D:\\experiment\\fileBase\\";

    @Autowired
    FileServiceApi fileServiceApi;


    @Override
    public Integer uploadFile(HttpServletRequest request, HttpServletResponse response) {
        List<MultipartFile> fileList = ((MultipartHttpServletRequest) request).getFiles("file");
        return upload(fileList);
    }

    @Override
    public Integer uploadCourseImage(HttpServletRequest request, HttpServletResponse response,
                                     @RequestBody @Validated FileWrapper.CourseCoverDTO courseCoverDTO) {
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
        log.info("新增/更新课程封面，获取前端传参：{}", file.getOriginalFilename());
        return uploadCourseImage(file, courseCoverDTO.getFileId());
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

    /**
     * 新增更新课程封面
     *
     * @param multipartFile
     * @param fileId
     * @return
     */
    private Integer uploadCourseImage(MultipartFile multipartFile, Integer fileId) {

        String fileName = DateUtils.currentTimeSeconds() + multipartFile.getOriginalFilename();
        File file = new File(FILE_PATH + fileName);
        try {
            multipartFile.transferTo(file);
            log.info("上传文件成功，fileName:{}", fileName);
            Integer charAt = fileName.lastIndexOf(".");
            EntitySaveVO entitySaveVO = updateFileBse(multipartFile.getOriginalFilename(), fileName.substring(0,charAt), fileId);
            return entitySaveVO.getKey();
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("上传文件出错 {} ", multipartFile.getOriginalFilename());
            return 0;
        }
    }

    /**
     * 新增更新文件记录
     *
     * @param fileName
     * @param memoryName
     * @param fileId
     * @return
     */
    private EntitySaveVO updateFileBse(String fileName, String memoryName, Integer fileId) {
        log.info("新增更新文件，fileName:{},memoryName:{},fileId:{}", fileName, memoryName, fileId);
        FileBaseDTO.UpdateFileBaseDTO fileBaseDTO = new FileBaseDTO.UpdateFileBaseDTO();
        fileBaseDTO.setMemoryName(memoryName);
        fileBaseDTO.setFileName(fileName);
        if (fileId == null || fileId <= 0) {
            fileId = 0;
        }
        fileBaseDTO.setId(fileId);
        ResResult<EntitySaveVO> result = fileServiceApi.updateFileBase(fileBaseDTO);
        log.info("新增/更新文件成功，result:{}", result);
        return result.getData();
    }

}
