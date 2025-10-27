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


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;         // اسم الغرفة
    private Double width;        // العرض
    private Double length;       // الطول
    private Double area;         // المساحة الكلية
    private Double perimeter;    // المحيط


    // ============ أنواع الأسقف ============
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private CeilingType ceilingType;



    // ============ مواد الأرضيات والجدران ============
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private FloorMaterial floorWallMaterial;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private WallType wallType;






    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private ExhaustType exhaustType;


    public void setWidth(Double width) {
        this.width = width;
        recalculate();
    }

    public void setLength(Double length) {
        this.length = length;
        recalculate();
    }

    private void recalculate() {
        if (this.width != null && this.length != null) {
            this.area = this.width * this.length;
            this.perimeter = 2 * (this.width + this.length);
        }
    }


    @ManyToOne
    @JoinColumn(name = "residential_unit_id")
    @JsonBackReference("unit=rooms")
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