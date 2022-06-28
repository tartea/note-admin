package org.tartea.note.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.tartea.note.convert.NoteFileConvert;
import org.tartea.note.domain.NoteFile;
import org.tartea.note.dto.NoteFileDTO;
import org.tartea.note.mapper.NoteFileMapper;
import org.tartea.note.service.NoteFileService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class NoteFileServiceImpl implements NoteFileService {

    @Resource
    private NoteFileMapper noteFileMapper;

    @Override
    public List<NoteFileDTO> queryNoteFileList(Integer folderId) {

        QueryWrapper<NoteFile> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("folder_id", folderId);
        queryWrapper.orderByDesc("create_time");
        List<NoteFile> noteFiles = noteFileMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(noteFiles)) {
            return Collections.emptyList();
        }
        List<NoteFileDTO> noteFileDTOList = new ArrayList<NoteFileDTO>(noteFiles.size());
        noteFiles.forEach(note -> noteFileDTOList.add(NoteFileConvert.convertToNoteFileDTO(note)));
        return noteFileDTOList;
    }


    @Override
    public void saveNoteFile(NoteFileDTO noteFileDTO) {
        Date date = new Date();
        noteFileDTO.setCreateTime(date);
        noteFileDTO.setUpdateTime(date);
        noteFileMapper.insert(NoteFileConvert.convertToNoteFile(noteFileDTO));
    }

    @Override
    public void updateNoteFile(NoteFileDTO noteFileDTO) {
        Date date = new Date();
        noteFileDTO.setUpdateTime(date);
        noteFileMapper.updateById(NoteFileConvert.convertToNoteFile(noteFileDTO));
    }

    @Override
    public void deleteNoteFile(Integer fileId) {
        noteFileMapper.deleteById(fileId);
    }
}
