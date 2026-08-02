package com.marka.notes_api.service;

import com.marka.notes_api.model.Note;
import com.marka.notes_api.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id, Note updatedNote) {
        Optional<Note> existingNote = noteRepository.findById(id);

        if (existingNote.isPresent()) {
            Note note = existingNote.get();
            note.setTitle(updatedNote.getTitle());
            note.setContent(updatedNote.getContent());

            return noteRepository.save(note);
        }

        return null;
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}