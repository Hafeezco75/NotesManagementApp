package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.Author;
import com.ebay.westafrica.data.models.Notes;
import com.ebay.westafrica.data.repositories.NotesRepository;
import com.ebay.westafrica.dtos.requests.AddNotesRequest;
import com.ebay.westafrica.dtos.requests.ModifyNotesRequest;
import com.ebay.westafrica.dtos.requests.RemoveNotesRequest;
import com.ebay.westafrica.dtos.responses.AddNotesResponse;
import com.ebay.westafrica.dtos.responses.ModifyNotesResponse;
import com.ebay.westafrica.dtos.responses.RemoveNotesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotesServiceImpl implements NotesService{
    @Autowired
    private NotesRepository notesRepository;


    @Override
    public AddNotesResponse addNotes(AddNotesRequest addNotesRequest){
        Notes notes = new Notes();
        notes.setId("432");
        notes.setTitle("LORD OF THE RINGS");
        notes.setContent("A Highly fictional movie produced by Jack Willis and Bradon James");
        notes.setDate(LocalDateTime.parse("2020-03-03T10:15:30"));
        notes.setAuthor(new Author("23","Mark","Blaise","BobMartins@gmail.com","Seter123"));
        notesRepository.save(notes);

        AddNotesResponse addNotesResponse = new AddNotesResponse();
        addNotesResponse.setMessage("Notes has been added successfully");
        return addNotesResponse;
    }

    @Override
    public RemoveNotesResponse deleteNotes(RemoveNotesRequest removeNotesRequest){
        RemoveNotesResponse removeNotesResponse = new RemoveNotesResponse();
            for (Notes notes : notesRepository.findAll()) {
                if (notes.getId().equalsIgnoreCase (removeNotesRequest.getId())) {
                    if (notes.getTitle().equalsIgnoreCase(removeNotesRequest.getTitle())) {
                        notesRepository.delete(notes);
                    } else {
                        throw new IllegalArgumentException("Notes id does not match,input correct id");
                    }
                }
            }
        removeNotesResponse.setMessage("Notes has been deleted successfully");
        return removeNotesResponse;
    }

    @Override
    public ModifyNotesResponse editNotes(ModifyNotesRequest modifyNotesRequest){
        ModifyNotesResponse modifyNotesResponse = new ModifyNotesResponse();
        for (Notes notes: notesRepository.findAll()) {
            if (notes.getId().equals(modifyNotesRequest.getId())) {
                if (notes.getTitle().equals(modifyNotesRequest.getTitle())) {
                    notes.setId(modifyNotesRequest.getId());
                    notes.setTitle(modifyNotesRequest.getTitle());
                    notes.setContent(modifyNotesRequest.getContent());
                    notes.setDate(LocalDateTime.now());
                    notes.setAuthor(modifyNotesRequest.getAuthor());
                    notesRepository.save(notes);
                } else {
                    throw new IllegalArgumentException("Notes id does not match,input correct id");
                }
            }
        }

        modifyNotesResponse.setMessage("Notes has been updated successfully");
        return modifyNotesResponse;
    }

    @Override
    public List<Notes> getAllNotes(){
        return notesRepository.findAll();
    }
}
