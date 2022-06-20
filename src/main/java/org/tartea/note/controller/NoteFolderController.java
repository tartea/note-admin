package org.tartea.note.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tartea.note.common.BaseApiCode;
import org.tartea.note.common.Result;
import org.tartea.note.dto.NoteFolderDTO;
import org.tartea.note.service.NoteFolderService;

import java.util.List;
import java.util.Objects;

/**
 * 笔记文件夹
 *
 * @author jiawenhao
 * @date 2022-06-20 11:36
 */
@RestController
public class NoteFolderController {

    private static final Logger logger = LoggerFactory.getLogger(NoteFolderController.class);

    @Autowired
    private NoteFolderService noteFolderService;

    @RequestMapping("saveNoteFolder")
    public Result saveNoteFolder(@RequestBody NoteFolderDTO noteFolderDTO) {
        if (StringUtils.isEmpty(noteFolderDTO.getTitle())) {
            return new Result().fail(BaseApiCode.INVALID_FORMAT.getCode(), BaseApiCode.INVALID_FORMAT.getMsg());
        }
        try {
            noteFolderService.saveNoteFolder(noteFolderDTO);
        } catch (Exception e) {
            logger.error("保存文件夹失败,{}", JSON.toJSONString(noteFolderDTO), e);
        }

        return new Result().success();
    }

    /**
     * 更新文件夹内容
     *
     * @param noteFolderDTO
     * @return
     */
    @RequestMapping("updateNoteFolder")
    public Result updateNoteFolder(NoteFolderDTO noteFolderDTO) {
        if (StringUtils.isEmpty(noteFolderDTO.getTitle())) {
            return new Result().fail(BaseApiCode.INVALID_FORMAT.getCode(), BaseApiCode.INVALID_FORMAT.getMsg());
        }
        if (Objects.isNull(noteFolderDTO.getId())) {
            return new Result().fail(BaseApiCode.INVALID_FORMAT.getCode(), BaseApiCode.INVALID_FORMAT.getMsg());
        }
        try {
            noteFolderService.updateNoteFolder(noteFolderDTO);
        }catch (Exception e){
            logger.error("更新文件夹内容失败，{}",JSON.toJSONString(noteFolderDTO),e);
        }
        return new Result().success();
    }


    /**
     * 获取笔记本文件夹
     */
    @RequestMapping("queryFolderTree")
    public Result queryFolderTree() {
        try {
            List<NoteFolderDTO> noteFolderDTOS = noteFolderService.queryFolderTree();
            return new Result().success(noteFolderDTOS);
        } catch (Exception e) {
            logger.error("查询文件夹业务异常", e);
        }
        return new Result().fail();
    }
}
