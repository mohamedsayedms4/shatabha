package org.example.demo_11.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/enums")
//@CrossOrigin("*")
public class EnumController {

    // ✅ القيم باللغة الإنجليزية (أسماء الـ Enum)
    @GetMapping("/{enumName}/en")
    public List<String> getEnumValuesEnglish(@PathVariable String enumName) {
        return getEnumValues(enumName, false);
    }

    // ✅ القيم باللغة العربية (arabicName)
    @GetMapping("/{enumName}/ar")
    public List<String> getEnumValuesArabic(@PathVariable String enumName) {
        return getEnumValues(enumName, true);
    }

    // ✅ دالة مشتركة
    private List<String> getEnumValues(String enumName, boolean arabic) {
        try {
            // 1️⃣ قائمة بالـ packages الممكن أن يوجد بها الـ Enum
            String[] packages = {
                    "org.example.demo_11.eunms",
                    "org.example.demo_11.eunms.base",
                    "org.example.demo_11.eunms.ceiling",
                    "org.example.demo_11.eunms.door",
                    "org.example.demo_11.eunms.exhaust",
                    "org.example.demo_11.eunms.floorwall",
                    "org.example.demo_11.eunms.mixer",
                    "org.example.demo_11.eunms.shower",
                    "org.example.demo_11.eunms.sink",
                    "org.example.demo_11.eunms.window",
                    "org.example.demo_11.eunms.shutter"
            };

            Class<?> enumClass = null;
            for (String pkg : packages) {
                try {
                    enumClass = Class.forName(pkg + "." + enumName);
                    break; // إذا تم العثور على الكلاس
                } catch (ClassNotFoundException ignored) {}
            }

            if (enumClass == null) {
                throw new IllegalArgumentException("Enum not found: " + enumName);
            }

            if (!enumClass.isEnum()) {
                throw new IllegalArgumentException(enumName + " is not an enum type");
            }

            Object[] enumConstants = enumClass.getEnumConstants();

            return Arrays.stream(enumConstants)
                    .map(constant -> {
                        if (arabic) {
                            try {
                                // محاولة استدعاء getArabicName()
                                return (String) constant.getClass()
                                        .getMethod("getArabicName")
                                        .invoke(constant);
                            } catch (Exception e1) {
                                try {
                                    // محاولة استدعاء getNameAr() لـ CeilingType
                                    return (String) constant.getClass()
                                            .getMethod("getNameAr")
                                            .invoke(constant);
                                } catch (Exception e2) {
                                    // إذا فشل كل شيء، ارجع toString
                                    return constant.toString();
                                }
                            }
                        } else {
                            return constant.toString();
                        }
                    })
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException("Error fetching enum values for: " + enumName, e);
        }
    }

    // ✅ إندپوينت جديد لجميع الـ Enums المتاحة
    @GetMapping("/available")
    public List<String> getAvailableEnums() {
        String[] availableEnums = {
                "BaseType",
                "CeilingType",
                "DoorType",
                "ExhaustType",
                "FloorMaterial",
                "WallType",
                "MixerType",
                "ShowerArea",
                "SinkType",
                "WindowType",
                "ShutterType",
                "FinishingStatus",
                "Location",
                "MAGNTIC_TRACK",
                "SPOT",
                "UnitCollection",
                "WindowStatus"
        };
        return Arrays.asList(availableEnums);
    }
}