package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.Author;
import com.ebay.westafrica.data.models.Notes;
import com.ebay.westafrica.data.models.NotesCategory;
import com.ebay.westafrica.dtos.requests.AddNotesRequest;
import com.ebay.westafrica.dtos.requests.ModifyNotesRequest;
import com.ebay.westafrica.dtos.requests.RemoveNotesRequest;
import com.ebay.westafrica.dtos.requests.RetrieveAllNotesRequest;
import com.ebay.westafrica.dtos.responses.AddNotesResponse;
import com.ebay.westafrica.dtos.responses.ModifyNotesResponse;
import com.ebay.westafrica.dtos.responses.RemoveNotesResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class NotesServiceImplTest {
    @Autowired
    private NotesService notesService;

    @Test
    public void testThatNotesCanBeAddedByAuthor() {
        AddNotesRequest addRequest = new AddNotesRequest();
        addRequest.setTitle("THE GODS ARE CRAZY");
        addRequest.setContent("A Relaxing, breathtaking movie of the year");
        addRequest.setAuthor(new Author("43","Bob","Marlon","Bob@gmail.com","crested234"));
        addRequest.setPublishDate(LocalDate.now());
        addRequest.setCategory(NotesCategory.MOVIES);
        AddNotesResponse addNotesResponse = notesService.addNotes(addRequest);
        assertThat(addNotesResponse.getMessage()).isEqualTo("Notes has been added successfully");
    }

    @Test
    public void testThatNotesCanBeRemovedByAuthor() {
        RemoveNotesRequest removeRequest = new RemoveNotesRequest();
        removeRequest.setId("25");
        removeRequest.setTitle("THE GODS ARE CRAZY");
        removeRequest.setContent("A Relaxing, breathtaking movie of the year");
        removeRequest.setAuthor(new Author("43","Bob","Marlon","Bob@gmail.com","crested234"));
        removeRequest.setDate(LocalDateTime.now());
        removeRequest.setCategory(NotesCategory.MOVIES);
        RemoveNotesResponse removeNotesResponse = notesService.deleteNotes(removeRequest);
        assertThat(removeNotesResponse.getMessage()).isEqualTo("Notes has been deleted successfully");

    }

    @Test
    public void testThatNotesCanBeEditedByAuthor() {
        ModifyNotesRequest modifyRequest = new ModifyNotesRequest();
        modifyRequest.setId("29");
        modifyRequest.setTitle("THE THREE IDIOTS");
        modifyRequest.setContent("A Relaxing, breathtaking movie of the decade");
        modifyRequest.setAuthor(new Author("43","Bob","Marlon","Bob@gmail.com","crested234"));
        modifyRequest.setCategory(NotesCategory.MOVIES);
        modifyRequest.setPublishDate(LocalDate.now());
        ModifyNotesResponse modifyNotesResponse = notesService.editNotes(modifyRequest);
        assertThat(modifyNotesResponse.getMessage()).isEqualTo("Notes has been updated successfully");
    }

    @Test
    public void testThatNotesCanBeRetrievedByUser() {
        List<Notes> notes = notesService.getAllNotes();
        notes.forEach(note -> note.setId(note.getId() + 1));
        assertThat(notes.size()).isNotNull();
        assertThat(notes.size()).isEqualTo(1);
    }


}
