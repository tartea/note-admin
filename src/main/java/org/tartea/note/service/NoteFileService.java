package org.tartea.note.service;

import org.tartea.note.dto.NoteFileDTO;

import java.util.List;

/**
 * 文件处理
 *
 * @Author: jiawenhao
 * @Date: 2022-06-20  21:39
 */
public interface NoteFileService {


    /**
     * 根据文件夹id获取文件列表
     *
     * @param folderId
     * @return
     */
    List<NoteFileDTO> queryNoteFileList(Integer folderId);

    /**
     * 保存文件
     *
     * @param noteFileDTO
     */
    void saveNoteFile(NoteFileDTO noteFileDTO);

    /**
     * 更新文件
     *
     * @param noteFileDTO
     */
    void updateNoteFile(NoteFileDTO noteFileDTO);

}
