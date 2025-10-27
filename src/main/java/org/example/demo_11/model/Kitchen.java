package org.example.demo_11.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.demo_11.eunms.ceiling.CeilingType;
import org.example.demo_11.eunms.exhaust.ExhaustType;
import org.example.demo_11.eunms.floorwall.FloorMaterial;
import org.example.demo_11.eunms.floorwall.WallType;
import org.example.demo_11.eunms.sink.SinkType;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
public class Kitchen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;         // اسم الغرفة
    private Double width;        // العرض
    private Double length;       // الطول
    private Double area;         // المساحة الكلية
    private Double perimeter;    // المحيط

    private Boolean adaptation ;
    // ============ أنواع الأسقف ============
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private CeilingType ceilingType;

    // ============ مواد الأرضيات والجدران ============
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private FloorMaterial floorWallMaterial;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private WallType wallType;


    // ============ أنواع الأحوض ============
    @Column(nullable = true)

    @Enumerated(EnumType.STRING)
    private SinkType sinkType;


    @Column(nullable = true)

    @Enumerated(EnumType.STRING)
    private ExhaustType exhaustType;

    @ManyToOne
    @JoinColumn(name = "residential_unit_id")
    @JsonBackReference("unit=kitchens")
    private ResidentialUnit residentialUnit;


    @PrePersist
    @PreUpdate
    private void calculateAreaAndPerimeter() {
        if (width != null && length != null) {
            this.area = width * length;               // المساحة
            this.perimeter = 2 * (width + length);    // المحيط
        }
    }
}