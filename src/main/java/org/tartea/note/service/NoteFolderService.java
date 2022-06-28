package org.tartea.note.service;

import org.tartea.note.dto.NoteFolderDTO;

import java.util.List;

/**
 * 获取笔记本文件夹
 *
 * @author jiawenhao
 * @date 2022-06-20 16:48
 */
public interface NoteFolderService {

    /**
     * 获取文件夹树
     */
    List<NoteFolderDTO> queryFolderTree();

    /**
     * 保存文件夹
     *
     * @param noteFolderDTO
     */
    void saveNoteFolder(NoteFolderDTO noteFolderDTO);

    /**
     * 更新文件夹内容
     *
     * @param noteFolderDTO
     */
    void updateNoteFolder(NoteFolderDTO noteFolderDTO);

    /**
     * 删除文件夹
     *
     * @param folderId
     */
    void deleteFolderTree(Integer folderId);
}
