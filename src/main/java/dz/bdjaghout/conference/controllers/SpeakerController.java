package dz.bdjaghout.conference.controllers;

import dz.bdjaghout.conference.models.Speaker;
import dz.bdjaghout.conference.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository repository;

    @GetMapping
    public List<Speaker> list() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return repository.getById(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
        return repository.saveAndFlush(speaker);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        Speaker existingSpeaker = repository.getById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "id");
        return repository.saveAndFlush(existingSpeaker);
    }
}
