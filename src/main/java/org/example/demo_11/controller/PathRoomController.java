package org.example.demo_11.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.dto.PathDto;
import org.example.demo_11.model.PathRoom;
import org.example.demo_11.service.PathRoomPriceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pathroom")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PathRoomController {

    private final PathRoomPriceService pathRoomPriceService;

    @PostMapping("/calculate")
    public PathDto calculatePathRoomPrice(@RequestBody PathRoom pathRoom) {
        return pathRoomPriceService.calculatePathRoomPrice(pathRoom);
    }
}