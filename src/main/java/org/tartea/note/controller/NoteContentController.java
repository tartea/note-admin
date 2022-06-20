package org.tartea.note.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tartea.note.common.BaseApiCode;
import org.tartea.note.common.Result;
import org.tartea.note.dto.NoteFileDTO;
import org.tartea.note.exception.BusinessException;
import org.tartea.note.service.NoteContentService;

import java.util.Objects;

/**
 * 笔记内容
 *
 * @author jiawenhao
 * @date 2022-06-20 11:35
 */
@RestController
public class NoteContentController {

    private static final Logger logger = LoggerFactory.getLogger(NoteContentController.class);


    @Autowired
    private NoteContentService noteContentService;

    /**
     * 保存文件内容
     *
     * @param noteFileDTO
     */
    @RequestMapping("saveNoteContent")
    public Result saveNoteContent(NoteFileDTO noteFileDTO) {
        if (StringUtils.isEmpty(noteFileDTO.getContent())) {
            return new Result().fail(BaseApiCode.INVALID_FORMAT.getCode(), BaseApiCode.INVALID_FORMAT.getMsg());
        }
        if (Objects.isNull(noteFileDTO.getId())) {
            return new Result().fail(BaseApiCode.INVALID_FORMAT.getCode(), BaseApiCode.INVALID_FORMAT.getMsg());
        }
        try {
            noteContentService.saveNoteContent(noteFileDTO);
        } catch (BusinessException e) {
            logger.error("保存文件内容失败,{}", JSON.toJSONString(noteFileDTO), e);
            return new Result().fail(-1, e.getMessage());
        } catch (Exception e) {
            logger.error("保存文件内容失,{}", JSON.toJSONString(noteFileDTO), e);
        }
        return new Result().fail();

    }
}
