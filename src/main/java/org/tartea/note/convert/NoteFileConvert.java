package org.tartea.note.convert;

import org.tartea.note.domain.NoteFile;
import org.tartea.note.dto.NoteFileDTO;

import java.util.Objects;

public class NoteFileConvert {

    public static NoteFileDTO convertToNoteFileDTO(NoteFile noteFile) {
        if (Objects.isNull(noteFile)) {
            return null;
        }
        NoteFileDTO noteFileDTO = new NoteFileDTO();
        noteFileDTO.setId(noteFile.getId());
        noteFileDTO.setTitle(noteFile.getTitle());
        noteFileDTO.setContent(noteFile.getContent());
        noteFileDTO.setCreateTime(noteFile.getCreateTime());
        noteFileDTO.setUpdateTime(noteFile.getUpdateTime());

        return noteFileDTO;
    }

    public static NoteFile convertToNoteFile(NoteFileDTO noteFileDTO) {
        if (Objects.isNull(noteFileDTO)) {
            return null;
        }
        NoteFile noteFile = new NoteFile();
        noteFile.setId(noteFileDTO.getId());
        noteFile.setFolderId(noteFileDTO.getFolderId());
        noteFile.setTitle(noteFileDTO.getTitle());
        noteFile.setContent(noteFileDTO.getContent());
        noteFile.setCreateTime(noteFileDTO.getCreateTime());
        noteFile.setUpdateTime(noteFileDTO.getUpdateTime());

        return noteFile;
    }


}
