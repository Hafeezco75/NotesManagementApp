package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.Notes;
import com.ebay.westafrica.dtos.requests.AddNotesRequest;
import com.ebay.westafrica.dtos.requests.ModifyNotesRequest;
import com.ebay.westafrica.dtos.requests.RemoveNotesRequest;
import com.ebay.westafrica.dtos.requests.RetrieveAllNotesRequest;
import com.ebay.westafrica.dtos.responses.AddNotesResponse;
import com.ebay.westafrica.dtos.responses.ModifyNotesResponse;
import com.ebay.westafrica.dtos.responses.RemoveNotesResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotesService {
    AddNotesResponse addNotes(AddNotesRequest addNotesRequest);

    RemoveNotesResponse deleteNotes(RemoveNotesRequest removeNotesRequest);

    ModifyNotesResponse editNotes(ModifyNotesRequest modifyNotesRequest);

    List<Notes> getAllNotes();
}
