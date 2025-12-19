package org.example.demo_11.service;

import lombok.RequiredArgsConstructor;
import org.example.demo_11.model.EnumDisplayName;
import org.example.demo_11.repository.EnumDisplayNameRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EnumService {

    private final EnumDisplayNameRepository repo;

    private static final String[] ENUM_PACKAGES = {
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

    public List<String> getEnumValues(String enumType) {

        Class<?> enumClass = findEnumClass(enumType);
        Object[] constants = enumClass.getEnumConstants();

        return Arrays.stream(constants)
                .map(c -> repo.findByEnumTypeAndEnumKey(enumType, c.toString())
                        .map(EnumDisplayName::getDisplayName) // ناخد بس الـ displayName
                        .orElse(c.toString()) // fallback لو مش موجود DB
                )
                .toList();
    }

    public EnumDisplayName update(Long id, EnumDisplayName request) {

        EnumDisplayName existing = repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Enum not found with id: " + id)
                );

        existing.setDisplayName(request.getDisplayName());

        return repo.save(existing);
    }

    public EnumDisplayName create(EnumDisplayName request) {

        // منع التكرار
        repo.findByEnumTypeAndEnumKey(
                request.getEnumType(),
                request.getEnumKey()
        ).ifPresent(e -> {
            throw new RuntimeException("Enum already exists");
        });

        return repo.save(request);
    }

private Class<?> findEnumClass(String enumType) {
        for (String pkg : ENUM_PACKAGES) {
            try {
                Class<?> clazz = Class.forName(pkg + "." + enumType);
                if (clazz.isEnum()) {
                    return clazz;
                }
            } catch (ClassNotFoundException ignored) {}
        }
        throw new RuntimeException("Enum not found: " + enumType);
    }
}
