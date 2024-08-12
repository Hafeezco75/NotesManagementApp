package com.ebay.westafrica.web;

import com.ebay.westafrica.data.models.Notes;
import com.ebay.westafrica.dtos.requests.AddNotesRequest;
import com.ebay.westafrica.dtos.requests.ModifyNotesRequest;
import com.ebay.westafrica.dtos.requests.RemoveNotesRequest;
import com.ebay.westafrica.dtos.responses.AddNotesResponse;
import com.ebay.westafrica.dtos.responses.ApiResponse;
import com.ebay.westafrica.dtos.responses.ModifyNotesResponse;
import com.ebay.westafrica.dtos.responses.RemoveNotesResponse;
import com.ebay.westafrica.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class NotesController {
    @Autowired
    private NotesService notesService;

    @PostMapping("/addNotes")
    public ResponseEntity<?> addNotes(@RequestBody AddNotesRequest addNotesRequest) {
        try {
            AddNotesResponse addNotesResponse = notesService.addNotes(addNotesRequest);
            return new ResponseEntity<>(new ApiResponse(true, addNotesResponse), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteNotes")
    public ResponseEntity<?> deleteNotes(@RequestBody RemoveNotesRequest removeNotesRequest) {
        try {
            RemoveNotesResponse removeNotesResponse = notesService.deleteNotes(removeNotesRequest);
            return new ResponseEntity<>(new ApiResponse(true, removeNotesResponse), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping("/updateNotes")
    public ResponseEntity<?> updateNotes(@RequestBody ModifyNotesRequest modifyNotesRequest) {
        try {
            ModifyNotesResponse modifyNotesResponse = notesService.editNotes(modifyNotesRequest);
            return new ResponseEntity<>(new ApiResponse(true, modifyNotesResponse), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllNotes() {
        try{
            List<Notes> notesList = notesService.getAllNotes();
            return new ResponseEntity<>(notesService.getAllNotes(), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }
}
