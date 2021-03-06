package org.tartea.note.service;

import org.tartea.note.dto.NoteFileDTO;

public interface NoteContentService {

    /**
     * 保存文件内容
     *
     * @param noteFileDTO
     */
    void saveNoteContent(NoteFileDTO noteFileDTO);


    /**
     * 获取笔记内容
     *
     * @param noteId
     * @return
     */
    String getNoteContent(Integer noteId);
}
