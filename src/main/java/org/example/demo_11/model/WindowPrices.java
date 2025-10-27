package org.example.demo_11.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WindowPrices {
    // ============ ألوميتال PS ============
    private Long alumetalPsMaterials;
    private Long alumetalPsLabor;

    // ============ ألوميتال Jumpo ============
    private Long alumetalJumpoMaterials;
    private Long alumetalJumpoLabor;

    // ============ UPVC Turkey ============
    private Long upvcTurkeyMaterials;
    private Long upvcTurkeyLabor;

    // ============ UPVC Belgium ============
    private Long upvcBelgiumMaterials;
    private Long upvcBelgiumLabor;

    // ============ أنواع النوافذ الأخرى ============
    private Long windowShutterGeneralMaterials;
    private Long windowShutterGeneralLabor;
    private Long windowShutterNormalMaterials;
    private Long windowShutterNormalLabor;
    private Long windowShutterArmoredMaterials;
    private Long windowShutterArmoredLabor;

    private Long upvcTurkeySingleMaterials;
    private Long upvcTurkeySingleLabor;
    private Long upvcTurkeyDoubleMaterials;
    private Long upvcTurkeyDoubleLabor;
    private Long upvcBelgiumSingleMaterials;
    private Long upvcBelgiumSingleLabor;
    private Long upvcBelgiumDoubleMaterials;
    private Long upvcBelgiumDoubleLabor;

    private Long alumetalPsSmallSingleMaterials;
    private Long alumetalPsSmallSingleLabor;
    private Long alumetalPsSmallDoubleMaterials;
    private Long alumetalPsSmallDoubleLabor;
    private Long alumetalPsLargeSingleMaterials;
    private Long alumetalPsLargeSingleLabor;
    private Long alumetalPsLargeDoubleMaterials;
    private Long alumetalPsLargeDoubleLabor;

    private Long alumetalJumboSingleMaterials;
    private Long alumetalJumboSingleLabor;
    private Long alumetalJumboDoubleMaterials;
    private Long alumetalJumboDoubleLabor;

    private Long alumetalTangoSingleMaterials;
    private Long alumetalTangoSingleLabor;
    private Long alumetalTangoDoubleMaterials;
    private Long alumetalTangoDoubleLabor;
}