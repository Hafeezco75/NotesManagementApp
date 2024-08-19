package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.BackUpNotes;
import com.ebay.westafrica.data.repositories.BackUpNotesRepository;
import com.ebay.westafrica.dtos.requests.BackUpNotesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class BackUpNotesImpl implements BackUpNotesService {
    @Autowired
    private BackUpNotesRepository backUpNotesRepository;
    private String userResponse;


    @Override
    public BackUpNotes createBackUp(BackUpNotesRequest backUpNotesRequest) {
        BackUpNotes backNotes = new BackUpNotes();
             if (backNotes.isCreated()) {
                 backUpNotesRepository.findAll();
        }else {
            throw new IllegalArgumentException("Invalid request");
        }
        return backNotes;
    }

    private void updateBackUpNotesRepositoryBy(BackUpNotes backUpRepo){
        backUpRepo.setCreated(true);
    }


    private String addBackUp(BackUpNotes backUpRepo) {
        String confirmation = "Do you want to add this Notes to Backup? (Yes/No)";
        if (userResponse.equalsIgnoreCase("Yes")) {
            return userResponse;
        }
        return null;
    }

}
