package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.BackUpNotes;
import com.ebay.westafrica.data.models.Notes;
import com.ebay.westafrica.data.repositories.BackUpNotesRepository;
import com.ebay.westafrica.dtos.requests.BackUpNotesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BackUpNotesImpl implements BackUpNotesService {
    @Autowired
    private BackUpNotesService backUpNotesService;
    @Autowired
    private BackUpNotesRepository backUpNotesRepository;
    private String userResponse;

    @Override
    public BackUpNotes createBackUp(BackUpNotesRequest backUpNotesRequest) {
        BackUpNotes backNotes = new BackUpNotes();
             addBackUp(backNotes);
             if (backNotes.isCreated()) {
                 backUpNotesRepository.findAll();
            return backNotes;
        }else {
            throw new IllegalArgumentException("Invalid request");
        }
    }

    private void updateBackUpNotesRepositoryBy(BackUpNotes backUpRepo){
        backUpRepo.setCreated(true);
    }


    public CommandLineRunner addBackUp(BackUpNotes backUpRepo) {
        String confirmation = "Do you want to add this Notes to Backup? (Yes/No)";
        if (userResponse.equalsIgnoreCase("Yes")) {
            return (args) -> updateBackUpNotesRepositoryBy(backUpRepo);
        }
        return null;
    }

}
