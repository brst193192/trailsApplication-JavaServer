package com.example.server_side.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.server_side.DTO.TrailDTO;
import com.example.server_side.Service.TrailService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/trails")
@RestController
public class TrailController {

    @Autowired
    private TrailService trailService;

    @GetMapping("/getAll")
    public ResponseEntity<List<TrailDTO>> getAll() {
        return ResponseEntity.ok(trailService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<TrailDTO> addNewTrail(@RequestBody TrailDTO trail) {
        TrailDTO res = trailService.addTrail(trail);
        if (res != null)
            return ResponseEntity.ok(res);
        return ResponseEntity.badRequest().body(res);
    }

    @PutMapping("/update")
    public void updateTrail(@RequestBody TrailDTO trail) {
        trailService.updateTrail(trail);
    }

    // מוחק רק אם אין תלויות
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        System.out.println("------------------------delete id: " + id);
        trailService.deleteTrail(id);
    }
}
