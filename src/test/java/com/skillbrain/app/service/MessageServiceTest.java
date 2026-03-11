package com.skillbrain.app.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MessageServiceTest {

    private final MessageService messageService = new MessageService();

    @Test
    void shouldReturnExpectedPrefix() {
        String value = messageService.buildStatusMessage();
        assertTrue(value.startsWith("SkillBrain Java App is running - "));
    }
}
