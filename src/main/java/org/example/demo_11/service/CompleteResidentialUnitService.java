package org.example.demo_11.service;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.dto.*;
import org.example.demo_11.model.ResidentialUnit;
import org.example.demo_11.model.Room;
import org.example.demo_11.model.Kitchen;
import org.example.demo_11.model.PathRoom;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompleteResidentialUnitService {

    private final ResidentialUnitPriceService residentialUnitPriceService;
    private final RoomPriceService roomPriceService;
    private final KitchenPriceService kitchenPriceService;
    private final PathRoomPriceService pathRoomPriceService;
    private final EmailService emailService;

    public CompleteResidentialUnitDto calculateCompleteUnitPrice(ResidentialUnit unit) {
        CompleteResidentialUnitDto completeDto = new CompleteResidentialUnitDto();

        // تعيين المعلومات الأساسية
        completeDto.setTotalArea(unit.getTotalArea() != null ? unit.getTotalArea() : 0);
        completeDto.setRoomsNumber(unit.getRoomsNumber() != 0 ? unit.getRoomsNumber() : 0);
        completeDto.setLocation(unit.getLocation() != null ? unit.getLocation().getArabicName() : null);
        completeDto.setUnitCollection(unit.getUnitCollection() != null ? unit.getUnitCollection().getArabicName() : null);
        completeDto.setFinishingStatus(unit.getFinishingStatus() != null ? unit.getFinishingStatus().getArabicName() : null);

        long totalPrice = 0;

        // ✅ حساب سعر الوحدة السكنية الأساسية
        ResidentialUnitDto unitDto = residentialUnitPriceService.calculateResidentialUnitPrice(unit);
        completeDto.setUnitPriceDetails(unitDto);
        completeDto.setUnitTotalPrice(unitDto.getTotalPrice() != null ? unitDto.getTotalPrice() : 0);
        totalPrice += unitDto.getTotalPrice() != null ? unitDto.getTotalPrice() : 0;

        // ✅ حساب أسعار الغرف
        if (unit.getRooms() != null && !unit.getRooms().isEmpty()) {
            List<RoomDto> roomsDetails = new ArrayList<>();
            long roomsTotal = 0;

            for (Room room : unit.getRooms()) {
                RoomDto roomDto = roomPriceService.calculateRoomPrice(room);
                roomsDetails.add(roomDto);
                roomsTotal += roomDto.getTotalPrice() != null ? roomDto.getTotalPrice() : 0;
            }

            completeDto.setRoomsCount(unit.getRooms().size());
            completeDto.setRoomsTotalPrice(roomsTotal);
            completeDto.setRoomsDetails(roomsDetails);
            totalPrice += roomsTotal;
        }

        // ✅ حساب أسعار المطابخ
        if (unit.getKitchens() != null && !unit.getKitchens().isEmpty()) {
            List<KitchenDto> kitchensDetails = new ArrayList<>();
            long kitchensTotal = 0;

            for (Kitchen kitchen : unit.getKitchens()) {
                KitchenDto kitchenDto = kitchenPriceService.calculateKitchenPrice(kitchen);
                kitchensDetails.add(kitchenDto);
                kitchensTotal += kitchenDto.getTotalPrice() != null ? kitchenDto.getTotalPrice() : 0;
            }

            completeDto.setKitchensCount(unit.getKitchens().size());
            completeDto.setKitchensTotalPrice(kitchensTotal);
            completeDto.setKitchensDetails(kitchensDetails);
            totalPrice += kitchensTotal;
        }

        // ✅ حساب أسعار الحمامات
        if (unit.getPathRooms() != null && !unit.getPathRooms().isEmpty()) {
            List<PathDto> pathRoomsDetails = new ArrayList<>();
            long pathRoomsTotal = 0;

            for (PathRoom pathRoom : unit.getPathRooms()) {
                PathDto pathDto = pathRoomPriceService.calculatePathRoomPrice(pathRoom);
                pathRoomsDetails.add(pathDto);
                pathRoomsTotal += pathDto.getTotalPrice() != null ? pathDto.getTotalPrice() : 0;
            }

            completeDto.setPathRoomsCount(unit.getPathRooms().size());
            completeDto.setPathRoomsTotalPrice(pathRoomsTotal);
            completeDto.setPathRoomsDetails(pathRoomsDetails);
            totalPrice += pathRoomsTotal;
        }

        completeDto.setTotalPrice(totalPrice);

//        emailService.sendDetailedResidentialUnitEmail(completeDto, "ms4002@fayoum.wdu.wg");

        return completeDto;
    }
}
