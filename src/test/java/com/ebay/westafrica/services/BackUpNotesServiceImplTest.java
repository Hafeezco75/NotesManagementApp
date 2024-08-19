package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.Author;
import com.ebay.westafrica.data.models.BackUpNotes;
import com.ebay.westafrica.dtos.requests.BackUpNotesRequest;
import com.ebay.westafrica.dtos.responses.BackUpNotesResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BackUpNotesServiceImplTest {
    @Autowired
    private BackUpNotesService backUpNotesService;

    @Test
    public void testThatNotesAreBackedUp() {
        BackUpNotesRequest backUpNotesRequest = new BackUpNotesRequest();
        backUpNotesRequest.setTitle("THE GODS ARE CRAZY");
        backUpNotesRequest.setAuthor(new Author());
        backUpNotesRequest.setContent("An exciting story of euphoria and sarcasm");
        backUpNotesRequest.setPublishDate(LocalDate.now());
        BackUpNotes backUpNotes = backUpNotesService.createBackUp(backUpNotesRequest);
        assertThat(backUpNotes.isCreated()).isEqualTo(true);
        assertThat(backUpNotes.getTitle()).isEqualTo("THE GODS ARE CRAZY");
    }
}
