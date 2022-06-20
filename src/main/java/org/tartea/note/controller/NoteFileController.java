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
import org.tartea.note.dto.NoteFileDTO;
import org.tartea.note.service.NoteFileService;

import java.util.List;
import java.util.Objects;

/**
 * 笔记摘要
 *
 * @author jiawenhao
 * @date 2022-06-20 11:36
 */
@RestController
public class NoteFileController {
    private static final Logger logger = LoggerFactory.getLogger(NoteFileController.class);

    @Autowired
    private NoteFileService noteFileService;


    /**
     * 根据文件夹id获取文件列表
     *
     * @param folderId
     * @return
     */
    @RequestMapping("queryNoteFileList")
    public Result queryNoteFileList(Integer folderId) {
        if (Objects.isNull(folderId)) {
            return new Result().fail(BaseApiCode.INVALID_FORMAT.getCode(), BaseApiCode.INVALID_FORMAT.getMsg());
        }

        try {
            List<NoteFileDTO> noteFileDTOList = noteFileService.queryNoteFileList(folderId);
            return new Result().success(noteFileDTOList);

        } catch (Exception e) {
            logger.error("查询文件列表失败,{}", folderId, e);
        }
        return new Result().fail();
    }

    /**
     * 保存文件
     *
     * @param noteFileDTO
     */
    @RequestMapping("saveNoteFile")
    public Result saveNoteFile(@RequestBody NoteFileDTO noteFileDTO) {
        if (StringUtils.isEmpty(noteFileDTO.getTitle())) {
            return new Result().fail(BaseApiCode.INVALID_FORMAT.getCode(), BaseApiCode.INVALID_FORMAT.getMsg());
        }
        if (Objects.isNull(noteFileDTO.getFolderId())) {
            return new Result().fail(BaseApiCode.INVALID_FORMAT.getCode(), BaseApiCode.INVALID_FORMAT.getMsg());
        }
        try {
            noteFileService.saveNoteFile(noteFileDTO);
        } catch (Exception e) {
            logger.error("保存文件失败,{}", JSON.toJSONString(noteFileDTO) , e);
        }
        return new Result().fail();
    }

}
