package com.skillbrain.app.service;

import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String buildStatusMessage() {
        return "SkillBrain Java App is running - " + LocalDate.now();
    }
}
