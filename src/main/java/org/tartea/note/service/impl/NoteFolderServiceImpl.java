package org.tartea.note.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.tartea.note.convert.NoteFolderConvert;
import org.tartea.note.domain.NoteFolder;
import org.tartea.note.dto.NoteFolderDTO;
import org.tartea.note.mapper.NoteFolderMapper;
import org.tartea.note.service.NoteFolderService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class NoteFolderServiceImpl implements NoteFolderService {

    private static final Logger logger = LoggerFactory.getLogger(NoteFolderServiceImpl.class);

    @Resource
    private NoteFolderMapper noteFolderMapper;

    @Override
    public List<NoteFolderDTO> queryFolderTree() {
        List<NoteFolder> noteFolders = noteFolderMapper.selectList(new QueryWrapper<>());
        if (CollectionUtils.isEmpty(noteFolders)) {
            return Collections.emptyList();
        }
        List<NoteFolderDTO> result = new ArrayList<>(noteFolders.size());
        noteFolders.forEach(note -> result.add(NoteFolderConvert.convertToNoteFolderDTO(note)));
        return result;
    }

    @Override
    public void saveNoteFolder(NoteFolderDTO noteFolderDTO) {
        Date date = new Date();
        noteFolderDTO.setCreateTime(date);
        noteFolderDTO.setUpdateTime(date);
        noteFolderMapper.insert(NoteFolderConvert.convertToNoteFolder(noteFolderDTO));
    }

    @Override
    public void updateNoteFolder(NoteFolderDTO noteFolderDTO) {
        noteFolderDTO.setUpdateTime(new Date());
        noteFolderMapper.updateById(NoteFolderConvert.convertToNoteFolder(noteFolderDTO));
    }
}
