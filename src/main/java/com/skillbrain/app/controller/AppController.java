package com.skillbrain.app.controller;

import com.skillbrain.app.service.MessageService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    private final MessageService messageService;

    public AppController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
            "status", "UP",
            "service", "skillbrain-java-app",
            "checkedAt", LocalDateTime.now().toString()
        );
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
            "name", "SkillBrain Java App",
            "message", messageService.buildStatusMessage(),
            "module", "Module 4 - Continuous Delivery & Deployment"
        );
    }

    @GetMapping("/pipeline")
    public List<Map<String, Object>> pipeline() {
        return List.of(
            Map.of("step", "Build & Test", "status", "ready"),
            Map.of("step", "Publish Artifact", "status", "ready"),
            Map.of("step", "Deploy", "status", "planned"),
            Map.of("step", "Backup", "status", "planned")
        );
    }
}
