package com.ebay.westafrica.web;

import com.ebay.westafrica.data.models.Reminders;
import com.ebay.westafrica.dtos.requests.AddReminderRequest;
import com.ebay.westafrica.dtos.requests.ModifyRemindersRequest;
import com.ebay.westafrica.dtos.requests.RemoveReminderRequest;
import com.ebay.westafrica.dtos.responses.AddReminderResponse;
import com.ebay.westafrica.dtos.responses.ApiResponse;
import com.ebay.westafrica.dtos.responses.ModifyRemindersResponse;
import com.ebay.westafrica.dtos.responses.RemoveReminderResponse;
import com.ebay.westafrica.services.RemindersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RemindersController {
    @Autowired
    private RemindersService remindersService;


    @PostMapping("/")
    public ResponseEntity<?> setReminders(AddReminderRequest addReminderRequest) {
        try{
            AddReminderResponse addReminderResponse = remindersService.setReminders(addReminderRequest);
            return new ResponseEntity<>(new ApiResponse(true, addReminderResponse), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> removeReminders(RemoveReminderRequest removeReminderRequest) {
        try{
            RemoveReminderResponse removeReminderResponse = remindersService.removeReminder(removeReminderRequest);
            return new ResponseEntity<>(new ApiResponse(true, removeReminderResponse), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateReminders(ModifyRemindersRequest modifyRemindersRequest) {
        try {
            ModifyRemindersResponse modifyRemindersResponse = remindersService.modifyReminder(modifyRemindersRequest);
            return new ResponseEntity<>(new ApiResponse(true, modifyRemindersResponse), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }


}
