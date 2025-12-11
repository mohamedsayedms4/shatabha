package org.example.demo_11.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.demo_11.model.*;
import org.example.demo_11.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    public Price save(Price price) {
        initializeEmbeddedObjects(price);
        return priceRepository.save(price);
    }

    public Optional<Price> findById(Long id) {
        Optional<Price> priceOpt = priceRepository.findById(id);
        priceOpt.ifPresent(this::initializeEmbeddedObjects);
        return priceOpt;
    }

    public Price getOrCreateDefault() {
        Price price = priceRepository.findById(1L)
                .orElseGet(() -> {
                    Price defaultPrice = new Price();
                    defaultPrice.setId(1L);
                    initializeEmbeddedObjects(defaultPrice);
                    return priceRepository.save(defaultPrice);
                });

        initializeEmbeddedObjects(price);
        return price;
    }

    /**
     * 🔥 تحديث ذكي باستخدام Map
     * يدعم تحديث حقول فردية فقط
     */
    @Transactional
    public Price smartUpdate(Long id, Map<String, Object> updates) {
        Price existing = priceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Price not found with id: " + id));

        initializeEmbeddedObjects(existing);

        // معالجة كل حقل في الماب
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String fieldName = entry.getKey();
            Object value = entry.getValue();

            // التحقق إذا كان الحقل من الكائنات المضمنة
            if (isEmbeddedField(fieldName)) {
                updateEmbeddedField(existing, fieldName, value);
            } else {
                updateSimpleField(existing, fieldName, value);
            }
        }

        return priceRepository.save(existing);
    }

    private boolean isEmbeddedField(String fieldName) {
        return fieldName.equals("windowPrices") ||
                fieldName.equals("shutterPrices") ||
                fieldName.equals("doorPrices") ||
                fieldName.equals("lightingPrices") ||
                fieldName.equals("bathroomPrices") ||
                fieldName.equals("floorWallPrices") ||
                fieldName.equals("ceilingPrices") ||
                fieldName.equals("ventilationPrices");
    }

    @SuppressWarnings("unchecked")
    private void updateEmbeddedField(Price price, String embeddedField, Object value) {
        try {
            Map<String, Object> fieldUpdates = (Map<String, Object>) value;

            switch (embeddedField) {
                case "windowPrices":
                    updateWindowPrices(price.getWindowPrices(), fieldUpdates);
                    break;
                case "shutterPrices":
                    updateShutterPrices(price.getShutterPrices(), fieldUpdates);
                    break;
                case "doorPrices":
                    updateDoorPrices(price.getDoorPrices(), fieldUpdates);
                    break;
                case "lightingPrices":
                    updateLightingPrices(price.getLightingPrices(), fieldUpdates);
                    break;
                case "bathroomPrices":
                    updateBathroomPrices(price.getBathroomPrices(), fieldUpdates);
                    break;
                case "floorWallPrices":
                    updateFloorWallPrices(price.getFloorWallPrices(), fieldUpdates);
                    break;
                case "ceilingPrices":
                    updateCeilingPrices(price.getCeilingPrices(), fieldUpdates);
                    break;
                case "ventilationPrices":
                    updateVentilationPrices(price.getVentilationPrices(), fieldUpdates);
                    break;
            }
        } catch (ClassCastException e) {
            throw new RuntimeException("Invalid format for embedded field: " + embeddedField);
        }
    }

    private void updateWindowPrices(WindowPrices windowPrices, Map<String, Object> updates) {
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Number) {
                Long longValue = ((Number) value).longValue();

                switch (field) {
                    case "alumetalPsMaterials": windowPrices.setAlumetalPsMaterials(longValue); break;
                    case "alumetalPsLabor": windowPrices.setAlumetalPsLabor(longValue); break;
                    case "alumetalJumpoMaterials": windowPrices.setAlumetalJumpoMaterials(longValue); break;
                    case "alumetalJumpoLabor": windowPrices.setAlumetalJumpoLabor(longValue); break;
                    case "upvcTurkeyMaterials": windowPrices.setUpvcTurkeyMaterials(longValue); break;
                    case "upvcTurkeyLabor": windowPrices.setUpvcTurkeyLabor(longValue); break;
                    case "upvcBelgiumMaterials": windowPrices.setUpvcBelgiumMaterials(longValue); break;
                    case "upvcBelgiumLabor": windowPrices.setUpvcBelgiumLabor(longValue); break;
                    case "windowShutterGeneralMaterials": windowPrices.setWindowShutterGeneralMaterials(longValue); break;
                    case "windowShutterGeneralLabor": windowPrices.setWindowShutterGeneralLabor(longValue); break;
                    case "windowShutterNormalMaterials": windowPrices.setWindowShutterNormalMaterials(longValue); break;
                    case "windowShutterNormalLabor": windowPrices.setWindowShutterNormalLabor(longValue); break;
                    case "windowShutterArmoredMaterials": windowPrices.setWindowShutterArmoredMaterials(longValue); break;
                    case "windowShutterArmoredLabor": windowPrices.setWindowShutterArmoredLabor(longValue); break;
                    case "upvcTurkeySingleMaterials": windowPrices.setUpvcTurkeySingleMaterials(longValue); break;
                    case "upvcTurkeySingleLabor": windowPrices.setUpvcTurkeySingleLabor(longValue); break;
                    case "upvcTurkeyDoubleMaterials": windowPrices.setUpvcTurkeyDoubleMaterials(longValue); break;
                    case "upvcTurkeyDoubleLabor": windowPrices.setUpvcTurkeyDoubleLabor(longValue); break;
                    case "upvcBelgiumSingleMaterials": windowPrices.setUpvcBelgiumSingleMaterials(longValue); break;
                    case "upvcBelgiumSingleLabor": windowPrices.setUpvcBelgiumSingleLabor(longValue); break;
                    case "upvcBelgiumDoubleMaterials": windowPrices.setUpvcBelgiumDoubleMaterials(longValue); break;
                    case "upvcBelgiumDoubleLabor": windowPrices.setUpvcBelgiumDoubleLabor(longValue); break;
                    case "alumetalPsSmallSingleMaterials": windowPrices.setAlumetalPsSmallSingleMaterials(longValue); break;
                    case "alumetalPsSmallSingleLabor": windowPrices.setAlumetalPsSmallSingleLabor(longValue); break;
                    case "alumetalPsSmallDoubleMaterials": windowPrices.setAlumetalPsSmallDoubleMaterials(longValue); break;
                    case "alumetalPsSmallDoubleLabor": windowPrices.setAlumetalPsSmallDoubleLabor(longValue); break;
                    case "alumetalPsLargeSingleMaterials": windowPrices.setAlumetalPsLargeSingleMaterials(longValue); break;
                    case "alumetalPsLargeSingleLabor": windowPrices.setAlumetalPsLargeSingleLabor(longValue); break;
                    case "alumetalPsLargeDoubleMaterials": windowPrices.setAlumetalPsLargeDoubleMaterials(longValue); break;
                    case "alumetalPsLargeDoubleLabor": windowPrices.setAlumetalPsLargeDoubleLabor(longValue); break;
                    case "alumetalJumboSingleMaterials": windowPrices.setAlumetalJumboSingleMaterials(longValue); break;
                    case "alumetalJumboSingleLabor": windowPrices.setAlumetalJumboSingleLabor(longValue); break;
                    case "alumetalJumboDoubleMaterials": windowPrices.setAlumetalJumboDoubleMaterials(longValue); break;
                    case "alumetalJumboDoubleLabor": windowPrices.setAlumetalJumboDoubleLabor(longValue); break;
                    case "alumetalTangoSingleMaterials": windowPrices.setAlumetalTangoSingleMaterials(longValue); break;
                    case "alumetalTangoSingleLabor": windowPrices.setAlumetalTangoSingleLabor(longValue); break;
                    case "alumetalTangoDoubleMaterials": windowPrices.setAlumetalTangoDoubleMaterials(longValue); break;
                    case "alumetalTangoDoubleLabor": windowPrices.setAlumetalTangoDoubleLabor(longValue); break;
                }
            }
        }
    }

    private void updateShutterPrices(ShutterPrices shutterPrices, Map<String, Object> updates) {
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Number) {
                Long longValue = ((Number) value).longValue();

                switch (field) {
                    case "shutterProtectionMaterials": shutterPrices.setShutterProtectionMaterials(longValue); break;
                    case "shutterProtectionLabor": shutterPrices.setShutterProtectionLabor(longValue); break;
                    case "shutterWeatherResistantMaterials": shutterPrices.setShutterWeatherResistantMaterials(longValue); break;
                    case "shutterWeatherResistantLabor": shutterPrices.setShutterWeatherResistantLabor(longValue); break;
                    case "shutterAntiTheftMaterials": shutterPrices.setShutterAntiTheftMaterials(longValue); break;
                    case "shutterAntiTheftLabor": shutterPrices.setShutterAntiTheftLabor(longValue); break;
                }
            }
        }
    }

    private void updateDoorPrices(DoorPrices doorPrices, Map<String, Object> updates) {
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Number) {
                Long longValue = ((Number) value).longValue();

                switch (field) {
                    case "customMadeDoorMaterials": doorPrices.setCustomMadeDoorMaterials(longValue); break;
                    case "customMadeDoorLabor": doorPrices.setCustomMadeDoorLabor(longValue); break;
                    case "readyMadeDoorMaterials": doorPrices.setReadyMadeDoorMaterials(longValue); break;
                    case "readyMadeDoorLabor": doorPrices.setReadyMadeDoorLabor(longValue); break;
                    case "armoredDoorMaterials": doorPrices.setArmoredDoorMaterials(longValue); break;
                    case "armoredDoorLabor": doorPrices.setArmoredDoorLabor(longValue); break;
                }
            }
        }
    }

    private void updateLightingPrices(LightingPrices lightingPrices, Map<String, Object> updates) {
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Number) {
                Long longValue = ((Number) value).longValue();

                switch (field) {
                    case "spotSingleMaterials": lightingPrices.setSpotSingleMaterials(longValue); break;
                    case "spotSingleLabor": lightingPrices.setSpotSingleLabor(longValue); break;
                    case "spotDoubleMaterials": lightingPrices.setSpotDoubleMaterials(longValue); break;
                    case "spotDoubleLabor": lightingPrices.setSpotDoubleLabor(longValue); break;
                    case "spot15cmMaterials": lightingPrices.setSpot15cmMaterials(longValue); break;
                    case "spot15cmLabor": lightingPrices.setSpot15cmLabor(longValue); break;
                    case "spot25cmMaterials": lightingPrices.setSpot25cmMaterials(longValue); break;
                    case "spot25cmLabor": lightingPrices.setSpot25cmLabor(longValue); break;
                    case "chandelierMaterials": lightingPrices.setChandelierMaterials(longValue); break;
                    case "chandelierLabor": lightingPrices.setChandelierLabor(longValue); break;
                    case "backLedHiddenLightingMaterials": lightingPrices.setBackLedHiddenLightingMaterials(longValue); break;
                    case "backLedHiddenLightingLabor": lightingPrices.setBackLedHiddenLightingLabor(longValue); break;
                    case "magneticTrackLightingMaterials": lightingPrices.setMagneticTrackLightingMaterials(longValue); break;
                    case "magneticTrackLightingLabor": lightingPrices.setMagneticTrackLightingLabor(longValue); break;
                    case "backLedHiddenLighting": lightingPrices.setBackLedHiddenLighting(longValue); break;
                    case "magneticTrackMaterials": lightingPrices.setMagneticTrackMaterials(longValue); break;
                    case "magneticTrackLabor": lightingPrices.setMagneticTrackLabor(longValue); break;
                }
            }
        }
    }

    private void updateBathroomPrices(BathroomPrices bathroomPrices, Map<String, Object> updates) {
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Number) {
                Long longValue = ((Number) value).longValue();

                switch (field) {
                    case "basinSurfaceMaterials": bathroomPrices.setBasinSurfaceMaterials(longValue); break;
                    case "basinSurfaceLabor": bathroomPrices.setBasinSurfaceLabor(longValue); break;
                    case "basinConcealedMaterials": bathroomPrices.setBasinConcealedMaterials(longValue); break;
                    case "basinConcealedLabor": bathroomPrices.setBasinConcealedLabor(longValue); break;
                    case "buriedSinkMixerMaterials": bathroomPrices.setBuriedSinkMixerMaterials(longValue); break;
                    case "buriedSinkMixerLabor": bathroomPrices.setBuriedSinkMixerLabor(longValue); break;
                    case "showerSurfaceMaterials": bathroomPrices.setShowerSurfaceMaterials(longValue); break;
                    case "showerSurfaceLabor": bathroomPrices.setShowerSurfaceLabor(longValue); break;
                    case "showerConcealedMaterials": bathroomPrices.setShowerConcealedMaterials(longValue); break;
                    case "showerConcealedLabor": bathroomPrices.setShowerConcealedLabor(longValue); break;
                    case "showerConcealed2Materials": bathroomPrices.setShowerConcealed2Materials(longValue); break;
                    case "showerConcealed2Labor": bathroomPrices.setShowerConcealed2Labor(longValue); break;
                    case "buriedShowerMixer2OutletMaterials": bathroomPrices.setBuriedShowerMixer2OutletMaterials(longValue); break;
                    case "buriedShowerMixer2OutletLabor": bathroomPrices.setBuriedShowerMixer2OutletLabor(longValue); break;
                    case "showerConcealed3Materials": bathroomPrices.setShowerConcealed3Materials(longValue); break;
                    case "showerConcealed3Labor": bathroomPrices.setShowerConcealed3Labor(longValue); break;
                    case "buriedShowerMixer3OutletMaterials": bathroomPrices.setBuriedShowerMixer3OutletMaterials(longValue); break;
                    case "buriedShowerMixer3OutletLabor": bathroomPrices.setBuriedShowerMixer3OutletLabor(longValue); break;
                    case "showerSmartMaterials": bathroomPrices.setShowerSmartMaterials(longValue); break;
                    case "showerSmartLabor": bathroomPrices.setShowerSmartLabor(longValue); break;
                    case "shattafSurfaceMaterials": bathroomPrices.setShattafSurfaceMaterials(longValue); break;
                    case "shattafSurfaceLabor": bathroomPrices.setShattafSurfaceLabor(longValue); break;
                    case "shattafConcealedMaterials": bathroomPrices.setShattafConcealedMaterials(longValue); break;
                    case "shattafConcealedLabor": bathroomPrices.setShattafConcealedLabor(longValue); break;
                    case "buriedShattafMixerMaterials": bathroomPrices.setBuriedShattafMixerMaterials(longValue); break;
                    case "buriedShattafMixerLabor": bathroomPrices.setBuriedShattafMixerLabor(longValue); break;
                    case "shattafHangingMaterials": bathroomPrices.setShattafHangingMaterials(longValue); break;
                    case "shattafHangingLabor": bathroomPrices.setShattafHangingLabor(longValue); break;
                    case "wallHungConcealedMaterials": bathroomPrices.setWallHungConcealedMaterials(longValue); break;
                    case "wallHungConcealedLabor": bathroomPrices.setWallHungConcealedLabor(longValue); break;
                    case "baseWallHungConcealedMaterials": bathroomPrices.setBaseWallHungConcealedMaterials(longValue); break;
                    case "baseWallHungConcealedLabor": bathroomPrices.setBaseWallHungConcealedLabor(longValue); break;
                    case "baseWallHungConcealedBoxMaterials": bathroomPrices.setBaseWallHungConcealedBoxMaterials(longValue); break;
                    case "baseWallHungConcealedBoxLabor": bathroomPrices.setBaseWallHungConcealedBoxLabor(longValue); break;
                    case "basefloorStandingMaterials": bathroomPrices.setBasefloorStandingMaterials(longValue); break;
                    case "basefloorStandingLabor": bathroomPrices.setBasefloorStandingLabor(longValue); break;
                    case "bathtubMaterials": bathroomPrices.setBathtubMaterials(longValue); break;
                    case "bathtubLabor": bathroomPrices.setBathtubLabor(longValue); break;
                    case "jacuzziMaterials": bathroomPrices.setJacuzziMaterials(longValue); break;
                    case "jacuzziLabor": bathroomPrices.setJacuzziLabor(longValue); break;
                    case "showerBaseGlass80_210Materials": bathroomPrices.setShowerBaseGlass80_210Materials(longValue); break;
                    case "showerBaseGlass80_210Labor": bathroomPrices.setShowerBaseGlass80_210Labor(longValue); break;
                    case "showerNoneMaterials": bathroomPrices.setShowerNoneMaterials(longValue); break;
                    case "showerNoneLabor": bathroomPrices.setShowerNoneLabor(longValue); break;
                    case "shower_baseLabor": bathroomPrices.setShower_baseLabor(longValue); break;
                    case "shower_baseMaterials": bathroomPrices.setShower_baseMaterials(longValue); break;
                    case "sinkAboveUnitMaterials": bathroomPrices.setSinkAboveUnitMaterials(longValue); break;
                    case "sinkAboveUnitLabor": bathroomPrices.setSinkAboveUnitLabor(longValue); break;
                    case "sinkHalfPedestalMaterials": bathroomPrices.setSinkHalfPedestalMaterials(longValue); break;
                    case "sinkHalfPedestalLabor": bathroomPrices.setSinkHalfPedestalLabor(longValue); break;
                    case "sinkMarbleMaterials": bathroomPrices.setSinkMarbleMaterials(longValue); break;
                    case "sinkMarbleLabor": bathroomPrices.setSinkMarbleLabor(longValue); break;
                    case "sinkPorcelainMaterials": bathroomPrices.setSinkPorcelainMaterials(longValue); break;
                    case "sinkPorcelainLabor": bathroomPrices.setSinkPorcelainLabor(longValue); break;
                }
            }
        }
    }

    private void updateFloorWallPrices(FloorWallPrices floorWallPrices, Map<String, Object> updates) {
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Number) {
                Long longValue = ((Number) value).longValue();

                switch (field) {
                    case "marbleFloorBrecciaMaterials": floorWallPrices.setMarbleFloorBrecciaMaterials(longValue); break;
                    case "marbleFloorBrecciaLabor": floorWallPrices.setMarbleFloorBrecciaLabor(longValue); break;
                    case "marbleFloorPietraGrayMaterials": floorWallPrices.setMarbleFloorPietraGrayMaterials(longValue); break;
                    case "marbleFloorPietraGrayLabor": floorWallPrices.setMarbleFloorPietraGrayLabor(longValue); break;
                    case "marbleFloorKarraraMaterials": floorWallPrices.setMarbleFloorKarraraMaterials(longValue); break;
                    case "marbleFloorKarraraLabor": floorWallPrices.setMarbleFloorKarraraLabor(longValue); break;
                    case "marbleFloorOtherMaterials": floorWallPrices.setMarbleFloorOtherMaterials(longValue); break;
                    case "marbleFloorOtherLabor": floorWallPrices.setMarbleFloorOtherLabor(longValue); break;
                    case "HDFGERMANParquetMaterials": floorWallPrices.setHDFGERMANParquetMaterials(longValue); break;
                    case "HDFGERMANParquetLabor": floorWallPrices.setHDFGERMANParquetLabor(longValue); break;
                    case "HDFWATERPROOFParquetMaterials": floorWallPrices.setHDFWATERPROOFParquetMaterials(longValue); break;
                    case "HDFWATERPROOFParquetLabor": floorWallPrices.setHDFWATERPROOFParquetLabor(longValue); break;
                    case "PCDParquetMaterials": floorWallPrices.setPCDParquetMaterials(longValue); break;
                    case "PCDParquetLabor": floorWallPrices.setPCDParquetLabor(longValue); break;
                    case "PORCELAIN60x80ParquetMaterials": floorWallPrices.setPORCELAIN60x80ParquetMaterials(longValue); break;
                    case "PORCELAIN60x80ParquetLabor": floorWallPrices.setPORCELAIN60x80ParquetLabor(longValue); break;
                    case "PORCELAIN85x125ParquetMaterials": floorWallPrices.setPORCELAIN85x125ParquetMaterials(longValue); break;
                    case "PORCELAIN85x125ParquetLabor": floorWallPrices.setPORCELAIN85x125ParquetLabor(longValue); break;
                    case "SPCIMPORTEDParquetMaterials": floorWallPrices.setSPCIMPORTEDParquetMaterials(longValue); break;
                    case "SPCIMPORTEDParquetLabor": floorWallPrices.setSPCIMPORTEDParquetLabor(longValue); break;
                    case "SPCLOCALParquetMaterials": floorWallPrices.setSPCLOCALParquetMaterials(longValue); break;
                    case "SPCLOCALParquetLabor": floorWallPrices.setSPCLOCALParquetLabor(longValue); break;
                    case "ceramicFloor60x60Materials": floorWallPrices.setCeramicFloor60x60Materials(longValue); break;
                    case "ceramicFloor60x60Labor": floorWallPrices.setCeramicFloor60x60Labor(longValue); break;
                    case "ceramicFloor120x60Materials": floorWallPrices.setCeramicFloor120x60Materials(longValue); break;
                    case "ceramicFloor120x60Labor": floorWallPrices.setCeramicFloor120x60Labor(longValue); break;
                    case "localPorcelainFloor60x120Materials": floorWallPrices.setLocalPorcelainFloor60x120Materials(longValue); break;
                    case "localPorcelainFloor60x120Labor": floorWallPrices.setLocalPorcelainFloor60x120Labor(longValue); break;
                    case "hindiPorcelainFloor60x120Materials": floorWallPrices.setHindiPorcelainFloor60x120Materials(longValue); break;
                    case "hindiPorcelainFloor60x120Labor": floorWallPrices.setHindiPorcelainFloor60x120Labor(longValue); break;
                    case "hindiPorcelainFloor120x180Materials": floorWallPrices.setHindiPorcelainFloor120x180Materials(longValue); break;
                    case "hindiPorcelainFloor120x180Labor": floorWallPrices.setHindiPorcelainFloor120x180Labor(longValue); break;
                    case "hindiPorcelainFloor120x240Materials": floorWallPrices.setHindiPorcelainFloor120x240Materials(longValue); break;
                    case "hindiPorcelainFloor120x240Labor": floorWallPrices.setHindiPorcelainFloor120x240Labor(longValue); break;
                    case "spanishPorcelainFloor60x120Materials": floorWallPrices.setSpanishPorcelainFloor60x120Materials(longValue); break;
                    case "spanishPorcelainFloor60x120Labor": floorWallPrices.setSpanishPorcelainFloor60x120Labor(longValue); break;
                    case "spanishPorcelainFloor120x180Materials": floorWallPrices.setSpanishPorcelainFloor120x180Materials(longValue); break;
                    case "spanishPorcelainFloor120x180Labor": floorWallPrices.setSpanishPorcelainFloor120x180Labor(longValue); break;
                    case "spanishPorcelainFloor120x240Materials": floorWallPrices.setSpanishPorcelainFloor120x240Materials(longValue); break;
                    case "spanishPorcelainFloor120x240Labor": floorWallPrices.setSpanishPorcelainFloor120x240Labor(longValue); break;
                    case "PAINT_NORMALMaterials": floorWallPrices.setPAINT_NORMALMaterials(longValue); break;
                    case "PAINT_NORMALLabor": floorWallPrices.setPAINT_NORMALLabor(longValue); break;
                    case "PAINT_DICOARMaterials": floorWallPrices.setPAINT_DICOARMaterials(longValue); break;
                    case "PAINT_DICOARLabor": floorWallPrices.setPAINT_DICOARLabor(longValue); break;
                    case "TAGLIAD_MADEMaterials": floorWallPrices.setTAGLIAD_MADEMaterials(longValue); break;
                    case "TAGLIAD_MADELabor": floorWallPrices.setTAGLIAD_MADELabor(longValue); break;
                    case "TAGLIAD_NORMALMaterials": floorWallPrices.setTAGLIAD_NORMALMaterials(longValue); break;
                    case "TAGLIAD_NORMALLabor": floorWallPrices.setTAGLIAD_NORMALLabor(longValue); break;
                    case "BANOHATMaterials": floorWallPrices.setBANOHATMaterials(longValue); break;
                    case "BANOHATLabor": floorWallPrices.setBANOHATLabor(longValue); break;
                    case "ceramicWall60x30Materials": floorWallPrices.setCeramicWall60x30Materials(longValue); break;
                    case "ceramicWall60x30Labor": floorWallPrices.setCeramicWall60x30Labor(longValue); break;
                    case "ceramicWall75x25Materials": floorWallPrices.setCeramicWall75x25Materials(longValue); break;
                    case "ceramicWall75x25Labor": floorWallPrices.setCeramicWall75x25Labor(longValue); break;
                    case "ceramicWall120x60Materials": floorWallPrices.setCeramicWall120x60Materials(longValue); break;
                    case "ceramicWall120x60Labor": floorWallPrices.setCeramicWall120x60Labor(longValue); break;
                    case "localPorcelainWall60x120Materials": floorWallPrices.setLocalPorcelainWall60x120Materials(longValue); break;
                    case "localPorcelainWall60x120Labor": floorWallPrices.setLocalPorcelainWall60x120Labor(longValue); break;
                    case "hindiPorcelainWall60x120Materials": floorWallPrices.setHindiPorcelainWall60x120Materials(longValue); break;
                    case "hindiPorcelainWall60x120Labor": floorWallPrices.setHindiPorcelainWall60x120Labor(longValue); break;
                    case "hindiPorcelainWall120x180Materials": floorWallPrices.setHindiPorcelainWall120x180Materials(longValue); break;
                    case "hindiPorcelainWall120x180Labor": floorWallPrices.setHindiPorcelainWall120x180Labor(longValue); break;
                    case "hindiPorcelainWall120x240Materials": floorWallPrices.setHindiPorcelainWall120x240Materials(longValue); break;
                    case "hindiPorcelainWall120x240Labor": floorWallPrices.setHindiPorcelainWall120x240Labor(longValue); break;
                    case "spanishPorcelainWall60x120Materials": floorWallPrices.setSpanishPorcelainWall60x120Materials(longValue); break;
                    case "spanishPorcelainWall60x120Labor": floorWallPrices.setSpanishPorcelainWall60x120Labor(longValue); break;
                    case "spanishPorcelainWall120x180Materials": floorWallPrices.setSpanishPorcelainWall120x180Materials(longValue); break;
                    case "spanishPorcelainWall120x180Labor": floorWallPrices.setSpanishPorcelainWall120x180Labor(longValue); break;
                    case "spanishPorcelainWall120x240Materials": floorWallPrices.setSpanishPorcelainWall120x240Materials(longValue); break;
                    case "spanishPorcelainWall120x240Labor": floorWallPrices.setSpanishPorcelainWall120x240Labor(longValue); break;
                }
            }
        }
    }

    private void updateCeilingPrices(CeilingPrices ceilingPrices, Map<String, Object> updates) {
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Number) {
                Long longValue = ((Number) value).longValue();

                switch (field) {
                    case "beitNoorMaterials": ceilingPrices.setBeitNoorMaterials(longValue); break;
                    case "beitNoorLabor": ceilingPrices.setBeitNoorLabor(longValue); break;
                    case "shadowGapMaterials": ceilingPrices.setShadowGapMaterials(longValue); break;
                    case "shadowGapLabor": ceilingPrices.setShadowGapLabor(longValue); break;
                    case "band51": ceilingPrices.setBand51(longValue); break;
                    case "shadowGapLightMaterials": ceilingPrices.setShadowGapLightMaterials(longValue); break;
                    case "shadowGapLightLabor": ceilingPrices.setShadowGapLightLabor(longValue); break;
                    case "corniceFutecSmallMaterials": ceilingPrices.setCorniceFutecSmallMaterials(longValue); break;
                    case "corniceFutecSmallLabor": ceilingPrices.setCorniceFutecSmallLabor(longValue); break;
                    case "corniceFutecLargeMaterials": ceilingPrices.setCorniceFutecLargeMaterials(longValue); break;
                    case "corniceFutecLargeLabor": ceilingPrices.setCorniceFutecLargeLabor(longValue); break;
                    case "flatMaterials": ceilingPrices.setFlatMaterials(longValue); break;
                    case "flatLabor": ceilingPrices.setFlatLabor(longValue); break;
                    case "CelingPaint_NormalMaterials": ceilingPrices.setCelingPaint_NormalMaterials(longValue); break;
                    case "CelingPaint_NormalLabor": ceilingPrices.setCelingPaint_NormalLabor(longValue); break;
                    case "CelingPaint_StritchMaterials": ceilingPrices.setCelingPaint_StritchMaterials(longValue); break;
                    case "CelingPaint_StritchLabor": ceilingPrices.setCelingPaint_StritchLabor(longValue); break;
                    case "CelingDicoar_QatifaMaterials": ceilingPrices.setCelingDicoar_QatifaMaterials(longValue); break;
                    case "CelingDicoar_QatifaLabor": ceilingPrices.setCelingDicoar_QatifaLabor(longValue); break;
                    case "CelingDicoar_TagalidMaterials": ceilingPrices.setCelingDicoar_TagalidMaterials(longValue); break;
                    case "CelingDicoar_TagalidLabor": ceilingPrices.setCelingDicoar_TagalidLabor(longValue); break;
                }
            }
        }
    }

    private void updateVentilationPrices(VentilationPrices ventilationPrices, Map<String, Object> updates) {
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Number) {
                Long longValue = ((Number) value).longValue();

                switch (field) {
                    case "windowExhaustMaterials": ventilationPrices.setWindowExhaustMaterials(longValue); break;
                    case "windowExhaustLabor": ventilationPrices.setWindowExhaustLabor(longValue); break;
                    case "ceilingExhaustMaterials": ventilationPrices.setCeilingExhaustMaterials(longValue); break;
                    case "ceilingExhaustLabor": ventilationPrices.setCeilingExhaustLabor(longValue); break;
                }
            }
        }
    }

    private void updateSimpleField(Price price, String fieldName, Object value) {
        if (value instanceof Number) {
            Long longValue = ((Number) value).longValue();

            switch (fieldName) {
                case "coldInsulationForFloors": price.setColdInsulationForFloors(longValue); break;
                case "maharhBand38": price.setMaharhBand38(longValue); break;
                case "pathRoomAccesories": price.setPathRoomAccesories(longValue); break;
                case "plumbingPatRoomSetup": price.setPlumbingPatRoomSetup(longValue); break;
                case "plumbingPatRoomFinnish": price.setPlumbingPatRoomFinnish(longValue); break;
                case "plumbingKitchenSetup": price.setPlumbingKitchenSetup(longValue); break;
                case "plumbingKitchenFinnish": price.setPlumbingKitchenFinnish(longValue); break;
                case "paintForWallMaterials": price.setPaintForWallMaterials(longValue); break;
                case "paintForWallLabor": price.setPaintForWallLabor(longValue); break;
                case "paintForCeilingMaterials": price.setPaintForCeilingMaterials(longValue); break;
                case "paintForCeilingLabor": price.setPaintForCeilingLabor(longValue); break;
                case "previousFinishingDemolitionLessThan100M": price.setPreviousFinishingDemolitionLessThan100M(longValue); break;
                case "previousFinishingDemolitionLessThan150M": price.setPreviousFinishingDemolitionLessThan150M(longValue); break;
                case "previousFinishingDemolitionMoreThan150M": price.setPreviousFinishingDemolitionMoreThan150M(longValue); break;
                case "electricalInstallationLessThan100MCategory": price.setElectricalInstallationLessThan100MCategory(longValue); break;
                case "electricalInstallationLessThan100MManufacturers": price.setElectricalInstallationLessThan100MManufacturers(longValue); break;
                case "electricalInstallationLessThan150MCategory": price.setElectricalInstallationLessThan150MCategory(longValue); break;
                case "electricalInstallationLessThan150MManufacturers": price.setElectricalInstallationLessThan150MManufacturers(longValue); break;
                case "electricalInstallationMoreThan150MCategory": price.setElectricalInstallationMoreThan150MCategory(longValue); break;
                case "electricalInstallationMoreThan150MManufacturers": price.setElectricalInstallationMoreThan150MManufacturers(longValue); break;
                case "cementAndMaterialSupplyLessThan100M": price.setCementAndMaterialSupplyLessThan100M(longValue); break;
                case "cementAndMaterialSupplyLessThan150M": price.setCementAndMaterialSupplyLessThan150M(longValue); break;
                case "cementAndMaterialSupplyMoreThan150M": price.setCementAndMaterialSupplyMoreThan150M(longValue); break;
                case "cementSandAndMaterialsSupplyLessThan100M": price.setCementSandAndMaterialsSupplyLessThan100M(longValue); break;
                case "cementSandAndMaterialsSupplyLessThan150M": price.setCementSandAndMaterialsSupplyLessThan150M(longValue); break;
                case "cementSandAndMaterialsSupplyMoreThan150M": price.setCementSandAndMaterialsSupplyMoreThan150M(longValue); break;
                case "adaptationMaterials": price.setAdaptationMaterials(longValue); break;
                case "adaptationLabor": price.setAdaptationLabor(longValue); break;
            }
        }
    }

    /**
     * 🔥 الحل البديل: استخدام copyNonNullProperties بدون reflection
     */
    @Transactional
    public Price partialUpdate(Long id, Price updates) {
        Price existing = priceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Price not found with id: " + id));

        // تهيئة embedded objects
        initializeEmbeddedObjects(existing);

        // تحديث الحقول العادية يدوياً
        if (updates.getColdInsulationForFloors() != null) existing.setColdInsulationForFloors(updates.getColdInsulationForFloors());
        if (updates.getMaharhBand38() != null) existing.setMaharhBand38(updates.getMaharhBand38());
        if (updates.getPathRoomAccesories() != null) existing.setPathRoomAccesories(updates.getPathRoomAccesories());
        if (updates.getPlumbingPatRoomSetup() != null) existing.setPlumbingPatRoomSetup(updates.getPlumbingPatRoomSetup());
        if (updates.getPlumbingPatRoomFinnish() != null) existing.setPlumbingPatRoomFinnish(updates.getPlumbingPatRoomFinnish());
        if (updates.getPlumbingKitchenSetup() != null) existing.setPlumbingKitchenSetup(updates.getPlumbingKitchenSetup());
        if (updates.getPlumbingKitchenFinnish() != null) existing.setPlumbingKitchenFinnish(updates.getPlumbingKitchenFinnish());
        if (updates.getPaintForWallMaterials() != null) existing.setPaintForWallMaterials(updates.getPaintForWallMaterials());
        if (updates.getPaintForWallLabor() != null) existing.setPaintForWallLabor(updates.getPaintForWallLabor());
        if (updates.getPaintForCeilingMaterials() != null) existing.setPaintForCeilingMaterials(updates.getPaintForCeilingMaterials());
        if (updates.getPaintForCeilingLabor() != null) existing.setPaintForCeilingLabor(updates.getPaintForCeilingLabor());
        if (updates.getAdaptationMaterials() != null) existing.setAdaptationMaterials(updates.getAdaptationMaterials());
        if (updates.getAdaptationLabor() != null) existing.setAdaptationLabor(updates.getAdaptationLabor());

        // تحديث FloorWallPrices
        if (updates.getFloorWallPrices() != null) {
            FloorWallPrices src = updates.getFloorWallPrices();
            FloorWallPrices dst = existing.getFloorWallPrices();

            if (src.getHDFGERMANParquetMaterials() != null) dst.setHDFGERMANParquetMaterials(src.getHDFGERMANParquetMaterials());
            if (src.getHDFGERMANParquetLabor() != null) dst.setHDFGERMANParquetLabor(src.getHDFGERMANParquetLabor());
            if (src.getHDFWATERPROOFParquetMaterials() != null) dst.setHDFWATERPROOFParquetMaterials(src.getHDFWATERPROOFParquetMaterials());
            if (src.getHDFWATERPROOFParquetLabor() != null) dst.setHDFWATERPROOFParquetLabor(src.getHDFWATERPROOFParquetLabor());
            if (src.getPCDParquetMaterials() != null) dst.setPCDParquetMaterials(src.getPCDParquetMaterials());
            if (src.getPCDParquetLabor() != null) dst.setPCDParquetLabor(src.getPCDParquetLabor());
            if (src.getPORCELAIN60x80ParquetMaterials() != null) dst.setPORCELAIN60x80ParquetMaterials(src.getPORCELAIN60x80ParquetMaterials());
            if (src.getPORCELAIN60x80ParquetLabor() != null) dst.setPORCELAIN60x80ParquetLabor(src.getPORCELAIN60x80ParquetLabor());
            if (src.getPORCELAIN85x125ParquetMaterials() != null) dst.setPORCELAIN85x125ParquetMaterials(src.getPORCELAIN85x125ParquetMaterials());
            if (src.getPORCELAIN85x125ParquetLabor() != null) dst.setPORCELAIN85x125ParquetLabor(src.getPORCELAIN85x125ParquetLabor());
            if (src.getSPCIMPORTEDParquetMaterials() != null) dst.setSPCIMPORTEDParquetMaterials(src.getSPCIMPORTEDParquetMaterials());
            if (src.getSPCIMPORTEDParquetLabor() != null) dst.setSPCIMPORTEDParquetLabor(src.getSPCIMPORTEDParquetLabor());
            if (src.getSPCLOCALParquetMaterials() != null) dst.setSPCLOCALParquetMaterials(src.getSPCLOCALParquetMaterials());
            if (src.getSPCLOCALParquetLabor() != null) dst.setSPCLOCALParquetLabor(src.getSPCLOCALParquetLabor());
            if (src.getPAINT_NORMALMaterials() != null) dst.setPAINT_NORMALMaterials(src.getPAINT_NORMALMaterials());
            if (src.getPAINT_NORMALLabor() != null) dst.setPAINT_NORMALLabor(src.getPAINT_NORMALLabor());
            if (src.getPAINT_DICOARMaterials() != null) dst.setPAINT_DICOARMaterials(src.getPAINT_DICOARMaterials());
            if (src.getPAINT_DICOARLabor() != null) dst.setPAINT_DICOARLabor(src.getPAINT_DICOARLabor());
            if (src.getTAGLIAD_MADEMaterials() != null) dst.setTAGLIAD_MADEMaterials(src.getTAGLIAD_MADEMaterials());
            if (src.getTAGLIAD_MADELabor() != null) dst.setTAGLIAD_MADELabor(src.getTAGLIAD_MADELabor());
            if (src.getTAGLIAD_NORMALMaterials() != null) dst.setTAGLIAD_NORMALMaterials(src.getTAGLIAD_NORMALMaterials());
            if (src.getTAGLIAD_NORMALLabor() != null) dst.setTAGLIAD_NORMALLabor(src.getTAGLIAD_NORMALLabor());
            if (src.getBANOHATMaterials() != null) dst.setBANOHATMaterials(src.getBANOHATMaterials());
            if (src.getBANOHATLabor() != null) dst.setBANOHATLabor(src.getBANOHATLabor());
        }

        // تحديث CeilingPrices
        if (updates.getCeilingPrices() != null) {
            CeilingPrices src = updates.getCeilingPrices();
            CeilingPrices dst = existing.getCeilingPrices();

            if (src.getCelingPaint_NormalMaterials() != null) dst.setCelingPaint_NormalMaterials(src.getCelingPaint_NormalMaterials());
            if (src.getCelingPaint_NormalLabor() != null) dst.setCelingPaint_NormalLabor(src.getCelingPaint_NormalLabor());
            if (src.getCelingPaint_StritchMaterials() != null) dst.setCelingPaint_StritchMaterials(src.getCelingPaint_StritchMaterials());
            if (src.getCelingPaint_StritchLabor() != null) dst.setCelingPaint_StritchLabor(src.getCelingPaint_StritchLabor());
            if (src.getCelingDicoar_QatifaMaterials() != null) dst.setCelingDicoar_QatifaMaterials(src.getCelingDicoar_QatifaMaterials());
            if (src.getCelingDicoar_QatifaLabor() != null) dst.setCelingDicoar_QatifaLabor(src.getCelingDicoar_QatifaLabor());
            if (src.getCelingDicoar_TagalidMaterials() != null) dst.setCelingDicoar_TagalidMaterials(src.getCelingDicoar_TagalidMaterials());
            if (src.getCelingDicoar_TagalidLabor() != null) dst.setCelingDicoar_TagalidLabor(src.getCelingDicoar_TagalidLabor());
        }

        // حفظ التغييرات
        return priceRepository.save(existing);
    }

    private void initializeEmbeddedObjects(Price price) {
        if (price.getWindowPrices() == null) price.setWindowPrices(new WindowPrices());
        if (price.getShutterPrices() == null) price.setShutterPrices(new ShutterPrices());
        if (price.getDoorPrices() == null) price.setDoorPrices(new DoorPrices());
        if (price.getLightingPrices() == null) price.setLightingPrices(new LightingPrices());
        if (price.getBathroomPrices() == null) price.setBathroomPrices(new BathroomPrices());
        if (price.getFloorWallPrices() == null) price.setFloorWallPrices(new FloorWallPrices());
        if (price.getCeilingPrices() == null) price.setCeilingPrices(new CeilingPrices());
        if (price.getVentilationPrices() == null) price.setVentilationPrices(new VentilationPrices());
    }
}