# SkillBrain Java App

Acesta este proiectul de bază pentru Modulul 4, folosit progresiv în toate exercițiile de CI/CD.

## Stack

- Java 17
- Spring Boot 3
- Maven
- JUnit 5

## Endpoints

- `GET /` -> UI web pentru demo
- `GET /api/health` -> status aplicație
- `GET /api/info` -> mesaj de status al aplicației
- `GET /api/pipeline` -> pașii pipeline-ului folosiți în laborator

## Rulezi local

```bash
mvn clean test
mvn spring-boot:run
```

Aplicația pornește implicit pe `http://localhost:8080`, iar pagina principală este UI-ul web.

## Milestones pentru laborator

1. **CI de bază**: build + test în GitHub Actions.
2. **Publish artefact**: JAR upload ca artifact în workflow.
3. **Containerizare**: build/push imagine în GHCR.
4. **Deploy**: deploy în mediu cloud (ex. Elastic Beanstalk).
5. **Backup**: arhivare + upload în S3 pe schedule.

## Ce trebuie să faci tu

Repo-ul nu include workflow-urile finale de curs. Le adaugi tu pas cu pas în `.github/workflows`, conform lecțiilor.
# java-app
Folosesc două tipuri de tag-uri:

- sha-<commit> → pentru trasabilitate exactă
- latest → pentru ultima versiune

Motiv:
sha = știu exact ce cod rulează
latest = ușor de folosit în dezvoltare