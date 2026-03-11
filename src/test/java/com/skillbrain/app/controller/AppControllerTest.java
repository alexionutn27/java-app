package com.skillbrain.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.skillbrain.app.service.MessageService;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class AppControllerTest {

    private final AppController appController = new AppController(new MessageService());

    @Test
    void healthEndpointShouldReturnUp() {
        Map<String, String> response = appController.health();
        assertEquals("UP", response.get("status"));
        assertEquals("skillbrain-java-app", response.get("service"));
    }

    @Test
    void infoEndpointShouldContainAppName() {
        Map<String, String> response = appController.info();
        assertEquals("SkillBrain Java App", response.get("name"));
    }

    @Test
    void pipelineEndpointShouldReturnSteps() {
        List<Map<String, Object>> response = appController.pipeline();
        assertEquals(4, response.size());
        assertFalse(response.isEmpty());
    }
}
