package it.nepsthermoney.controller;

import it.nepsthermoney.entity.Release;
import it.nepsthermoney.entity.dto.request.ReleaseDto;
import it.nepsthermoney.service.ReleaseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static it.nepsthermoney.util.UriUtil.addIdToCurrentUrlPath;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1/release")
public class ReleaseController {
    ReleaseService releaseService;

    @GetMapping("/{id}")
    public ResponseEntity<Release> findById(@PathVariable Long id) {
        Release release = releaseService.findById(id);
        return ResponseEntity.ok((release));
    }

    @GetMapping
    public ResponseEntity<List<Release>> findAll() {
        List<Release> release = releaseService.findAll();
        return ResponseEntity.ok().body(release);

    }

    @PostMapping
    public ResponseEntity<Release> create(@Valid @RequestBody ReleaseDto releaseDto){
        var release = new Release();
        BeanUtils.copyProperties(releaseDto, release);
        release =  releaseService.save(release);
        return ResponseEntity.created( addIdToCurrentUrlPath(release.getId())).body(release);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Release> update(@PathVariable Long id, @Valid @RequestBody ReleaseDto releaseDto){
        var release = new Release();
        BeanUtils.copyProperties(releaseDto, release);
        return ResponseEntity.ok().body(releaseService.update(id, release));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        releaseService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("release deleted");


    }
}
