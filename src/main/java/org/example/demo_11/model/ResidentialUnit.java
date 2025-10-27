package org.example.demo_11.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.demo_11.eunms.*;
import org.example.demo_11.eunms.door.DoorType;
import org.example.demo_11.eunms.shutter.ShutterType;
import org.example.demo_11.eunms.window.WindowType;

import java.util.List;

@Entity
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ResidentialUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include @ToString.Include

    private Long id;

    @Column(nullable = true)
    @ToString.Include
    private Long totalArea ;


    @Column(nullable = true)
    @ToString.Include
    private int roomsNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    @ToString.Exclude
    private Location location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    @ToString.Exclude
    private UnitCollection unitCollection;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    @ToString.Exclude
    private FinishingStatus  finishingStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    @ToString.Exclude
    private SPOT spot;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    @ToString.Exclude
    private MAGNTIC_TRACK MAGNTIC_TRACK;


    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    @ToString.Exclude
    private DoorType interDoor ;

    private int interDoorCounter;
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    @ToString.Exclude
    private DoorType outDoor ;


    private Long widowCounter;
    // ============ أنواع النوافذ ============
    @Column(nullable = true)

    @Enumerated(EnumType.STRING)
    private WindowType windowType;

    @ElementCollection
    @CollectionTable(name = "unit_shutter_types", joinColumns = @JoinColumn(name = "unit_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "shutter_type")
    private List<ShutterType> shutterTypes;

    @OneToMany(mappedBy = "residentialUnit", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("unit=pathRooms")
    @ToString.Exclude
    private List<PathRoom> pathRooms ;


    @OneToMany(mappedBy = "residentialUnit", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("unit=kitchens")
    @ToString.Exclude
    private List<Kitchen> kitchens;

    @OneToMany(mappedBy = "residentialUnit", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("unit=rooms")
    @ToString.Exclude
    private List<Room> rooms;

    @Column(nullable = true)
    private Long totalPrice; // السعر المحسوب للوحدة



}
