package dz.bdjaghout.conference.controllers;

import dz.bdjaghout.conference.models.Session;
import dz.bdjaghout.conference.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionRepository repository;

    @GetMapping
    public List<Session> list() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Session get(@PathVariable Long id) {
        return repository.getById(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session) {
        return repository.saveAndFlush(session);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        Session existingSession = repository.getById(id);
        BeanUtils.copyProperties(session, existingSession, "id");
        return repository.saveAndFlush(existingSession);
    }
}
