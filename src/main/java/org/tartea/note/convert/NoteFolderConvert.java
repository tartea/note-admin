package org.tartea.note.convert;

import org.tartea.note.domain.NoteFolder;
import org.tartea.note.dto.NoteFolderDTO;

import java.util.Objects;

public class NoteFolderConvert {

    public static NoteFolderDTO convertToNoteFolderDTO(NoteFolder noteFolder) {
        if(Objects.isNull(noteFolder)){
            return null;
        }
        NoteFolderDTO noteFolderDTO = new NoteFolderDTO();
        noteFolderDTO.setId(noteFolder.getId());
        noteFolderDTO.setTitle(noteFolder.getTitle());
        noteFolderDTO.setCreateTime(noteFolder.getCreateTime());
        return noteFolderDTO;
    }
    public static NoteFolder convertToNoteFolder(NoteFolderDTO noteFolderDTO) {
        if(Objects.isNull(noteFolderDTO)){
            return null;
        }
        NoteFolder noteFolder = new NoteFolder();
        noteFolder.setId(noteFolderDTO.getId());
        noteFolder.setTitle(noteFolderDTO.getTitle());
        noteFolder.setCreateTime(noteFolderDTO.getCreateTime());
        noteFolder.setUpdateTime(noteFolderDTO.getUpdateTime());
        return noteFolder;
    }
}
