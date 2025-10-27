package org.example.demo_11.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/V2/enums")
@CrossOrigin(origins = "*")
public class EnumController2 {

    // ✅ استرجاع القيم حسب الكاتيجوري من الـ URL
    @GetMapping("/{enumName}/category/{category}/{lang}")
    public List<String> getEnumValuesByCategory(
            @PathVariable String enumName,
            @PathVariable String category,
            @PathVariable String lang) {

        boolean arabic = lang.equalsIgnoreCase("ar");
        String[] packages = getEnumPackages();

        try {
            Class<?> enumClass = findEnumClass(enumName, packages);
            Object[] constants = enumClass.getEnumConstants();

            // ✅ تصفية القيم حسب الكاتيجوري (case-insensitive)
            List<String> filtered = Arrays.stream(constants)
                    .filter(constant -> constant.toString().toLowerCase().startsWith(category.toLowerCase()))
                    .map(constant -> mapEnumValue(constant, arabic))
                    .collect(Collectors.toList());

            if (filtered.isEmpty()) {
                log.warn("⚠️ No values found for category '{}' in enum '{}'", category, enumName);
                throw new IllegalArgumentException("No values found for category: " + category);
            }

            log.info("✅ Found {} values for category '{}' in enum '{}'", filtered.size(), category, enumName);
            return filtered;

        } catch (Exception e) {
            log.error("❌ Error fetching enum '{}' for category '{}': {}", enumName, category, e.getMessage());
            throw new RuntimeException("Error fetching enum values for category: " + category, e);
        }
    }

    // ✅ استرجاع القيم مجمعة حسب الكاتيجوري
    @GetMapping("/{enumName}/grouped/{lang}")
    public Map<String, List<String>> getEnumValuesGrouped(
            @PathVariable String enumName,
            @PathVariable String lang) {

        boolean arabic = lang.equalsIgnoreCase("ar");
        String[] packages = getEnumPackages();

        try {
            Class<?> enumClass = findEnumClass(enumName, packages);
            Object[] constants = enumClass.getEnumConstants();

            Map<String, List<String>> grouped = new LinkedHashMap<>();

            for (Object constant : constants) {
                String name = constant.toString();
                String group = name.split("_")[0]; // اسم المجموعة (الكاتيجوري)
                String value = mapEnumValue(constant, arabic);

                grouped.computeIfAbsent(group, k -> new ArrayList<>()).add(value);
            }

            log.info("✅ Enum '{}' grouped into {} categories", enumName, grouped.size());
            return grouped;

        } catch (Exception e) {
            log.error("❌ Error grouping enum '{}': {}", enumName, e.getMessage());
            throw new RuntimeException("Error grouping enum: " + enumName, e);
        }
    }

    // ✅ إرجاع القيم الإنجليزية فقط
    @GetMapping("/{enumName}/en")
    public List<String> getEnumValuesEnglish(@PathVariable String enumName) {
        return getEnumValues(enumName, false);
    }

    // ✅ إرجاع القيم بالعربية فقط
    @GetMapping("/{enumName}/ar")
    public List<String> getEnumValuesArabic(@PathVariable String enumName) {
        return getEnumValues(enumName, true);
    }

    // ==============================
    // 🔹 دوال مساعدة
    // ==============================

    private List<String> getEnumValues(String enumName, boolean arabic) {
        String[] packages = getEnumPackages();

        try {
            Class<?> enumClass = findEnumClass(enumName, packages);
            Object[] constants = enumClass.getEnumConstants();

            return Arrays.stream(constants)
                    .map(constant -> mapEnumValue(constant, arabic))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error("❌ Error fetching enum values for '{}': {}", enumName, e.getMessage());
            throw new RuntimeException("Error fetching enum values for: " + enumName, e);
        }
    }

    private String mapEnumValue(Object constant, boolean arabic) {
        if (arabic) {
            try {
                return (String) constant.getClass()
                        .getMethod("getArabicName")
                        .invoke(constant);
            } catch (Exception e) {
                return constant.toString();
            }
        } else {
            return constant.toString();
        }
    }

    private Class<?> findEnumClass(String enumName, String[] packages) throws ClassNotFoundException {
        for (String pkg : packages) {
            try {
                return Class.forName(pkg + "." + enumName);
            } catch (ClassNotFoundException ignored) {}
        }
        throw new ClassNotFoundException("Enum not found in known packages: " + enumName);
    }

    private String[] getEnumPackages() {
        return new String[]{
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
    }
}
