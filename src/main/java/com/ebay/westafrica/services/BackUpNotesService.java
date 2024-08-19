package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.BackUpNotes;
import com.ebay.westafrica.dtos.requests.BackUpNotesRequest;
import org.springframework.stereotype.Service;

@Service
public interface BackUpNotesService {

    BackUpNotes createBackUp(BackUpNotesRequest backUpNotesRequest);
}
