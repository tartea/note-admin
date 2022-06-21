package org.tartea.note.service.impl;

import org.springframework.stereotype.Service;
import org.tartea.note.convert.NoteFileConvert;
import org.tartea.note.domain.NoteFile;
import org.tartea.note.dto.NoteFileDTO;
import org.tartea.note.exception.BusinessException;
import org.tartea.note.mapper.NoteFileMapper;
import org.tartea.note.service.NoteContentService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

@Service
public class NoteContentServiceImpl implements NoteContentService {

    @Resource
    private NoteFileMapper noteFileMapper;


    @Override
    public void saveNoteContent(NoteFileDTO noteFileDTO) {
        NoteFile noteFile = noteFileMapper.selectById(noteFileDTO.getId());
        if (Objects.isNull(noteFile)) {
            throw new BusinessException("文件不存在");
        }
        noteFile.setContent(noteFileDTO.getContent());
        noteFile.setUpdateTime(new Date());
        noteFileMapper.updateById(noteFile);
    }

    @Override
    public String getNoteContent(Integer noteId) {
        NoteFile noteFile = noteFileMapper.selectById(noteId);
        if(Objects.isNull(noteFile)){
            throw new BusinessException("文件不存在");
        }
        return noteFile.getContent();
    }
}
