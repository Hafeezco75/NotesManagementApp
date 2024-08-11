package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.NotesCategory;
import com.ebay.westafrica.data.models.ReminderStatus;
import com.ebay.westafrica.dtos.requests.AddReminderRequest;
import com.ebay.westafrica.dtos.requests.ModifyNotesRequest;
import com.ebay.westafrica.dtos.requests.ModifyRemindersRequest;
import com.ebay.westafrica.dtos.requests.RemoveReminderRequest;
import com.ebay.westafrica.dtos.responses.AddReminderResponse;
import com.ebay.westafrica.dtos.responses.ModifyRemindersResponse;
import com.ebay.westafrica.dtos.responses.RemoveReminderResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RemindersServiceImplTest {
    @Autowired
    private RemindersService remindersService;

    @Test
    public void testThatUserCanSetReminder() {
        AddReminderRequest addReminderRequest = new AddReminderRequest();
        addReminderRequest.setTitle("WAKE UP NIGERIA");
        addReminderRequest.setDescription("Remove Bad Government and Deploy Centralised Monarchy");
        addReminderRequest.setNotesCategory(NotesCategory.DAILYMOTIVATION);
        addReminderRequest.setReminderStatus(ReminderStatus.NEWLYADDED);
        addReminderRequest.setReminderDate(LocalDateTime.parse("2020-01-01T00:10:12"));
        AddReminderResponse addReminderResponse = remindersService.setReminders(addReminderRequest);
        assertThat(addReminderResponse.getMessage()).isNotNull();
        assertThat(addReminderResponse.getMessage()).isEqualTo("Successfully added reminder");
    }

    @Test
    public void testThatUserCanRemoveReminders() {
        RemoveReminderRequest removeReminderRequest = new RemoveReminderRequest();
        removeReminderRequest.setTitle("WAKE UP NIGERIA");
        removeReminderRequest.setDescription("Badass system and politicised Government");
        removeReminderRequest.setReminderDate(LocalDateTime.parse("2020-04-03T09:14:15"));
        removeReminderRequest.setNotesCategory(NotesCategory.DAILYMOTIVATION);
        removeReminderRequest.setReminderStatus(ReminderStatus.NEWLYADDED);
        RemoveReminderResponse removeReminderResponse = remindersService.removeReminder(removeReminderRequest);
        assertThat(removeReminderResponse.getMessage()).isEqualTo("Reminder Deleted Successfully");
    }

    @Test
    public void testThatUserCanEditReminders() {
        ModifyRemindersRequest modifyRemindersRequest = new ModifyRemindersRequest();
        modifyRemindersRequest.setTitle("ROMEO AND JULIET");
        modifyRemindersRequest.setDescription("Watch this Tragic blockbuster and be glad you did");
        modifyRemindersRequest.setDate(LocalDateTime.now());
        modifyRemindersRequest.setNotesCategory(NotesCategory.MOVIES);
        modifyRemindersRequest.setReminderStatus(ReminderStatus.NEWLYADDED);
        ModifyRemindersResponse modifyRemindersResponse = remindersService.modifyReminder(modifyRemindersRequest);
        assertThat(modifyRemindersResponse.getMessage()).isNotNull();
        assertThat(modifyRemindersResponse.getMessage()).isEqualTo("Successfully modified reminder");
    }
}
