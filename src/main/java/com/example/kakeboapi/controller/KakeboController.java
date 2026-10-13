package com.example.kakeboapi.controller;

import com.example.kakeboapi.dto.Kakebo;
import com.example.kakeboapi.service.KakeboService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/kakebo")
public class KakeboController {
private final KakeboService kakeboService;

    public KakeboController(KakeboService kakeboService) {
        this.kakeboService = kakeboService;
    }

    @GetMapping
    public ResponseEntity<List<Kakebo>> selectAllKakebo() {
        List<Kakebo> kakebos = kakeboService.selectAllKakebos();

        return ResponseEntity.ok(kakebos);
    }

    @PostMapping
    public ResponseEntity<Kakebo> insertKakebo(@RequestBody Kakebo kakebo,
                                               UriComponentsBuilder uriBuilder) {
        Kakebo createdKakebo = kakeboService.insertKakebo(kakebo);
        URI location = uriBuilder.path("/api/kakebo/{id}").buildAndExpand(createdKakebo.getId()).toUri();

        return ResponseEntity.created(location).body(createdKakebo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kakebo> findById(@PathVariable long id) {
        Kakebo kakebo = kakeboService.findById(id);

        return ResponseEntity.ok(kakebo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        kakeboService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kakebo> update(@PathVariable long id,
                                         @RequestBody Kakebo kakebo) {
        kakeboService.update(kakebo, id);

        return ResponseEntity.ok(kakebo);
    }

}
