package org.example.demo_11.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.dto.RoomDto;
import org.example.demo_11.model.Room;
import org.example.demo_11.service.RoomPriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomPriceService roomService; // السيرفس اللي بيحسب

    @PostMapping("/calculate")
    public ResponseEntity<RoomDto> calculatePrice(@RequestBody Room roomJson) {

        // ✅ السيرفس يستقبل الـ Room الجاهز من الـ JSON
        RoomDto dto = roomService.calculateRoomPrice(roomJson);

        return ResponseEntity.ok(dto);
    }
}
