package org.example.demo_11.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.demo_11.eunms.BathFloorMaterial;
import org.example.demo_11.eunms.base.BaseType;
import org.example.demo_11.eunms.ceiling.CeilingType;
import org.example.demo_11.eunms.exhaust.ExhaustType;
import org.example.demo_11.eunms.mixer.BasinMixerType;
import org.example.demo_11.eunms.mixer.ShattafMixerType;
import org.example.demo_11.eunms.mixer.ShowerMixerType;
import org.example.demo_11.eunms.shower.ShowerArea;
import org.example.demo_11.eunms.sink.SinkType;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
public class PathRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;         // اسم الغرفة
    private Double width;        // العرض
    private Double length;       // الطول
    private Double area;         // المساحة الكلية
    private Double perimeter;    // المحيط

    // ============ أنواع القواعد في الحمامات ============
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private BaseType baseType;

    // ============ أنواع الأسقف ============
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private CeilingType ceilingType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private BathFloorMaterial bathFloorMaterial;

    // ============ أنواع الخلاطات (مقسمة) ============

    // خلاط الحوض
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private BasinMixerType basinMixerType;

    // خلاط الدش (يُترك null لو ShowerArea = WITHOUT)
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private ShowerMixerType showerMixerType;

    // الشطاف (يُترك null لو القاعدة عادية حسب منطقك)
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private ShattafMixerType shattafMixerType;

    // ============ مناطق الاستحمام ============
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private ShowerArea showerArea;

    // ============ أنواع الأحوض ============
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private SinkType sinkType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private ExhaustType exhaustType;

    @ManyToOne
    @JoinColumn(name = "residential_unit_id")
    @JsonBackReference("unit=pathRooms")
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
