package org.example.demo_11.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
        // === المعلومات الأساسية ===
        "totalArea",
        "roomsNumber",

        // ✅ بيانات العميل
        "customerName",
        "customerPhone",
        "customerEmail",

        "location",
        "unitCollection",
        "finishingStatus",

        // === الوحدة السكنية ===
        "unitPriceDetails",
        "unitTotalPrice",

        // === الغرف ===
        "roomsCount",
        "roomsTotalPrice",
        "roomsDetails",

        // === المطابخ ===
        "kitchensCount",
        "kitchensTotalPrice",
        "kitchensDetails",

        // === الحمامات ===
        "pathRoomsCount",
        "pathRoomsTotalPrice",
        "pathRoomsDetails",

        // === الإجمالي ===
        "totalPrice"
})
public class CompleteResidentialUnitDto {

    // === المعلومات الأساسية ===
    private Long totalArea;
    private int roomsNumber;

    // ✅ بيانات العميل
    private String customerName;
    private String customerPhone;

    // ✅ (جديد) إيميل العميل
    private String customerEmail;

    private String location;
    private String unitCollection;
    private String finishingStatus;

    // === الوحدة السكنية ===
    private ResidentialUnitDto unitPriceDetails;
    private Long unitTotalPrice;

    // === الغرف ===
    private int roomsCount;
    private Long roomsTotalPrice;
    private List<RoomDto> roomsDetails;

    // === المطابخ ===
    private int kitchensCount;
    private Long kitchensTotalPrice;
    private List<KitchenDto> kitchensDetails;

    // === الحمامات ===
    private int pathRoomsCount;
    private Long pathRoomsTotalPrice;
    private List<PathDto> pathRoomsDetails;

    // === الإجمالي ===
    private Long totalPrice;
}
