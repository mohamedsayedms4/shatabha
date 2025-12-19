package org.example.demo_11.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "enum_display_names")
@Data
public class EnumDisplayName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enumType;
    private String enumKey;
    private String displayName;
}
