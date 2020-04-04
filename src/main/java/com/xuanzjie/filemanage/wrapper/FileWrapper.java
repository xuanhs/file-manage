package com.xuanzjie.filemanage.wrapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FileWrapper {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(value = "CourseCoverDTO")
    public static class CourseCoverDTO{

        @ApiModelProperty(notes = "课程id")
        private Integer courseId;

        @ApiModelProperty(notes = "原文件id")
        private Integer fileId;
    }
}
