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

    @Transactional
    public Price smartUpdate(Long id, Map<String, Object> updates) {
        Price existing = priceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Price not found with id: " + id));

        initializeEmbeddedObjects(existing);

        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String fieldName = entry.getKey();
            Object value = entry.getValue();

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
                    case "alumetalJumboMaterials": windowPrices.setAlumetalJumboMaterials(longValue); break;
                    case "alumetalJumboLabor": windowPrices.setAlumetalJumboLabor(longValue); break;
                    case "upvcTurkeyMaterials": windowPrices.setUpvcTurkeyMaterials(longValue); break;
                    case "upvcTurkeyLabor": windowPrices.setUpvcTurkeyLabor(longValue); break;
                    case "upvcBelgiumMaterials": windowPrices.setUpvcBelgiumMaterials(longValue); break;
                    case "upvcBelgiumLabor": windowPrices.setUpvcBelgiumLabor(longValue); break;
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
                    case "showerConcealedTwoOutletMaterials": bathroomPrices.setShowerConcealedTwoOutletMaterials(longValue); break;
                    case "showerConcealedTwoOutletLabor": bathroomPrices.setShowerConcealedTwoOutletLabor(longValue); break;
                    case "buriedShowerMixerTwoOutletMaterials": bathroomPrices.setBuriedShowerMixerTwoOutletMaterials(longValue); break;
                    case "buriedShowerMixerTwoOutletLabor": bathroomPrices.setBuriedShowerMixerTwoOutletLabor(longValue); break;
                    case "showerConcealedThreeOutletMaterials": bathroomPrices.setShowerConcealedThreeOutletMaterials(longValue); break;
                    case "showerConcealedThreeOutletLabor": bathroomPrices.setShowerConcealedThreeOutletLabor(longValue); break;
                    case "buriedShowerMixerThreeOutletMaterials": bathroomPrices.setBuriedShowerMixerThreeOutletMaterials(longValue); break;
                    case "buriedShowerMixerThreeOutletLabor": bathroomPrices.setBuriedShowerMixerThreeOutletLabor(longValue); break;
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
                    case "baseFloorStandingMaterials": bathroomPrices.setBaseFloorStandingMaterials(longValue); break;
                    case "baseFloorStandingLabor": bathroomPrices.setBaseFloorStandingLabor(longValue); break;
                    case "bathtubMaterials": bathroomPrices.setBathtubMaterials(longValue); break;
                    case "bathtubLabor": bathroomPrices.setBathtubLabor(longValue); break;
                    case "jacuzziMaterials": bathroomPrices.setJacuzziMaterials(longValue); break;
                    case "jacuzziLabor": bathroomPrices.setJacuzziLabor(longValue); break;
                    case "showerBaseGlass80_210Materials": bathroomPrices.setShowerBaseGlass80_210Materials(longValue); break;
                    case "showerBaseGlass80_210Labor": bathroomPrices.setShowerBaseGlass80_210Labor(longValue); break;
                    case "showerNoneMaterials": bathroomPrices.setShowerNoneMaterials(longValue); break;
                    case "showerNoneLabor": bathroomPrices.setShowerNoneLabor(longValue); break;
                    case "showerBaseMaterials": bathroomPrices.setShowerBaseMaterials(longValue); break;
                    case "showerBaseLabor": bathroomPrices.setShowerBaseLabor(longValue); break;
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
                    case "hdfGermanParquetMaterials": floorWallPrices.setHdfGermanParquetMaterials(longValue); break;
                    case "hdfGermanParquetLabor": floorWallPrices.setHdfGermanParquetLabor(longValue); break;
                    case "hdfWaterproofParquetMaterials": floorWallPrices.setHdfWaterproofParquetMaterials(longValue); break;
                    case "hdfWaterproofParquetLabor": floorWallPrices.setHdfWaterproofParquetLabor(longValue); break;
                    case "pcdParquetMaterials": floorWallPrices.setPcdParquetMaterials(longValue); break;
                    case "pcdParquetLabor": floorWallPrices.setPcdParquetLabor(longValue); break;
                    case "porcelain60x80ParquetMaterials": floorWallPrices.setPorcelain60x80ParquetMaterials(longValue); break;
                    case "porcelain60x80ParquetLabor": floorWallPrices.setPorcelain60x80ParquetLabor(longValue); break;
                    case "porcelain85x125ParquetMaterials": floorWallPrices.setPorcelain85x125ParquetMaterials(longValue); break;
                    case "porcelain85x125ParquetLabor": floorWallPrices.setPorcelain85x125ParquetLabor(longValue); break;
                    case "spcImportedParquetMaterials": floorWallPrices.setSpcImportedParquetMaterials(longValue); break;
                    case "spcImportedParquetLabor": floorWallPrices.setSpcImportedParquetLabor(longValue); break;
                    case "spcLocalParquetMaterials": floorWallPrices.setSpcLocalParquetMaterials(longValue); break;
                    case "spcLocalParquetLabor": floorWallPrices.setSpcLocalParquetLabor(longValue); break;
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
                    case "paintNormalMaterials": floorWallPrices.setPaintNormalMaterials(longValue); break;
                    case "paintNormalLabor": floorWallPrices.setPaintNormalLabor(longValue); break;
                    case "paintDicoarMaterials": floorWallPrices.setPaintDicoarMaterials(longValue); break;
                    case "paintDicoarLabor": floorWallPrices.setPaintDicoarLabor(longValue); break;
                    case "tagliadMadeMaterials": floorWallPrices.setTagliadMadeMaterials(longValue); break;
                    case "tagliadMadeLabor": floorWallPrices.setTagliadMadeLabor(longValue); break;
                    case "tagliadNormalMaterials": floorWallPrices.setTagliadNormalMaterials(longValue); break;
                    case "tagliadNormalLabor": floorWallPrices.setTagliadNormalLabor(longValue); break;
                    case "banohAtMaterials": floorWallPrices.setBanohAtMaterials(longValue); break;
                    case "banohAtLabor": floorWallPrices.setBanohAtLabor(longValue); break;
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
                    case "band51Materials": ceilingPrices.setBand51Materials(longValue); break;
                    case "band51Labor": ceilingPrices.setBand51Labor(longValue); break;
                    case "shadowGapLightMaterials": ceilingPrices.setShadowGapLightMaterials(longValue); break;
                    case "shadowGapLightLabor": ceilingPrices.setShadowGapLightLabor(longValue); break;
                    case "corniceFutecSmallMaterials": ceilingPrices.setCorniceFutecSmallMaterials(longValue); break;
                    case "corniceFutecSmallLabor": ceilingPrices.setCorniceFutecSmallLabor(longValue); break;
                    case "corniceFutecLargeMaterials": ceilingPrices.setCorniceFutecLargeMaterials(longValue); break;
                    case "corniceFutecLargeLabor": ceilingPrices.setCorniceFutecLargeLabor(longValue); break;
                    case "flatMaterials": ceilingPrices.setFlatMaterials(longValue); break;
                    case "flatLabor": ceilingPrices.setFlatLabor(longValue); break;
                    case "ceilingPaintNormalMaterials": ceilingPrices.setCeilingPaintNormalMaterials(longValue); break;
                    case "ceilingPaintNormalLabor": ceilingPrices.setCeilingPaintNormalLabor(longValue); break;
                    case "ceilingPaintStretchMaterials": ceilingPrices.setCeilingPaintStretchMaterials(longValue); break;
                    case "ceilingPaintStretchLabor": ceilingPrices.setCeilingPaintStretchLabor(longValue); break;
                    case "ceilingDicoarQatifaMaterials": ceilingPrices.setCeilingDicoarQatifaMaterials(longValue); break;
                    case "ceilingDicoarQatifaLabor": ceilingPrices.setCeilingDicoarQatifaLabor(longValue); break;
                    case "ceilingDicoarTagalidMaterials": ceilingPrices.setCeilingDicoarTagalidMaterials(longValue); break;
                    case "ceilingDicoarTagalidLabor": ceilingPrices.setCeilingDicoarTagalidLabor(longValue); break;
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
                case "mahrhaBand38": price.setMahrhaBand38(longValue); break;
                case "bathRoomAccessories": price.setBathRoomAccessories(longValue); break;
                case "plumbingBathRoomSetup": price.setPlumbingBathRoomSetup(longValue); break;
                case "plumbingBathRoomFinish": price.setPlumbingBathRoomFinish(longValue); break;
                case "plumbingKitchenSetup": price.setPlumbingKitchenSetup(longValue); break;
                case "plumbingKitchenFinish": price.setPlumbingKitchenFinish(longValue); break;
                case "paintForWallMaterials": price.setPaintForWallMaterials(longValue); break;
                case "paintForWallLabor": price.setPaintForWallLabor(longValue); break;
                case "paintForCeilingMaterials": price.setPaintForCeilingMaterials(longValue); break;
                case "paintForCeilingLabor": price.setPaintForCeilingLabor(longValue); break;
                case "previousFinishingDemolitionLessThan100Sqm": price.setPreviousFinishingDemolitionLessThan100Sqm(longValue); break;
                case "previousFinishingDemolitionLessThan150Sqm": price.setPreviousFinishingDemolitionLessThan150Sqm(longValue); break;
                case "previousFinishingDemolitionMoreThan150Sqm": price.setPreviousFinishingDemolitionMoreThan150Sqm(longValue); break;
                case "electricalInstallationLessThan100SqmCategory": price.setElectricalInstallationLessThan100SqmCategory(longValue); break;
                case "electricalInstallationLessThan100SqmManufacturers": price.setElectricalInstallationLessThan100SqmManufacturers(longValue); break;
                case "electricalInstallationLessThan150SqmCategory": price.setElectricalInstallationLessThan150SqmCategory(longValue); break;
                case "electricalInstallationLessThan150SqmManufacturers": price.setElectricalInstallationLessThan150SqmManufacturers(longValue); break;
                case "electricalInstallationMoreThan150SqmCategory": price.setElectricalInstallationMoreThan150SqmCategory(longValue); break;
                case "electricalInstallationMoreThan150SqmManufacturers": price.setElectricalInstallationMoreThan150SqmManufacturers(longValue); break;
                case "cementAndMaterialSupplyLessThan100Sqm": price.setCementAndMaterialSupplyLessThan100Sqm(longValue); break;
                case "cementAndMaterialSupplyLessThan150Sqm": price.setCementAndMaterialSupplyLessThan150Sqm(longValue); break;
                case "cementAndMaterialSupplyMoreThan150Sqm": price.setCementAndMaterialSupplyMoreThan150Sqm(longValue); break;
                case "cementSandAndMaterialsSupplyLessThan100Sqm": price.setCementSandAndMaterialsSupplyLessThan100Sqm(longValue); break;
                case "cementSandAndMaterialsSupplyLessThan150Sqm": price.setCementSandAndMaterialsSupplyLessThan150Sqm(longValue); break;
                case "cementSandAndMaterialsSupplyMoreThan150Sqm": price.setCementSandAndMaterialsSupplyMoreThan150Sqm(longValue); break;
                case "adaptationMaterials": price.setAdaptationMaterials(longValue); break;
                case "adaptationLabor": price.setAdaptationLabor(longValue); break;
            }
        }
    }

    @Transactional
    public Price partialUpdate(Long id, Price updates) {
        Price existing = priceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Price not found with id: " + id));

        initializeEmbeddedObjects(existing);

        if (updates.getColdInsulationForFloors() != null) existing.setColdInsulationForFloors(updates.getColdInsulationForFloors());
        if (updates.getMahrhaBand38() != null) existing.setMahrhaBand38(updates.getMahrhaBand38());
        if (updates.getBathRoomAccessories() != null) existing.setBathRoomAccessories(updates.getBathRoomAccessories());
        if (updates.getPlumbingBathRoomSetup() != null) existing.setPlumbingBathRoomSetup(updates.getPlumbingBathRoomSetup());
        if (updates.getPlumbingBathRoomFinish() != null) existing.setPlumbingBathRoomFinish(updates.getPlumbingBathRoomFinish());
        if (updates.getPlumbingKitchenSetup() != null) existing.setPlumbingKitchenSetup(updates.getPlumbingKitchenSetup());
        if (updates.getPlumbingKitchenFinish() != null) existing.setPlumbingKitchenFinish(updates.getPlumbingKitchenFinish());
        if (updates.getPaintForWallMaterials() != null) existing.setPaintForWallMaterials(updates.getPaintForWallMaterials());
        if (updates.getPaintForWallLabor() != null) existing.setPaintForWallLabor(updates.getPaintForWallLabor());
        if (updates.getPaintForCeilingMaterials() != null) existing.setPaintForCeilingMaterials(updates.getPaintForCeilingMaterials());
        if (updates.getPaintForCeilingLabor() != null) existing.setPaintForCeilingLabor(updates.getPaintForCeilingLabor());
        if (updates.getAdaptationMaterials() != null) existing.setAdaptationMaterials(updates.getAdaptationMaterials());
        if (updates.getAdaptationLabor() != null) existing.setAdaptationLabor(updates.getAdaptationLabor());

        if (updates.getFloorWallPrices() != null) {
            FloorWallPrices src = updates.getFloorWallPrices();
            FloorWallPrices dst = existing.getFloorWallPrices();

            if (src.getHdfGermanParquetMaterials() != null) dst.setHdfGermanParquetMaterials(src.getHdfGermanParquetMaterials());
            if (src.getHdfGermanParquetLabor() != null) dst.setHdfGermanParquetLabor(src.getHdfGermanParquetLabor());
            if (src.getHdfWaterproofParquetMaterials() != null) dst.setHdfWaterproofParquetMaterials(src.getHdfWaterproofParquetMaterials());
            if (src.getHdfWaterproofParquetLabor() != null) dst.setHdfWaterproofParquetLabor(src.getHdfWaterproofParquetLabor());
            if (src.getPcdParquetMaterials() != null) dst.setPcdParquetMaterials(src.getPcdParquetMaterials());
            if (src.getPcdParquetLabor() != null) dst.setPcdParquetLabor(src.getPcdParquetLabor());
            if (src.getPorcelain60x80ParquetMaterials() != null) dst.setPorcelain60x80ParquetMaterials(src.getPorcelain60x80ParquetMaterials());
            if (src.getPorcelain60x80ParquetLabor() != null) dst.setPorcelain60x80ParquetLabor(src.getPorcelain60x80ParquetLabor());
            if (src.getPorcelain85x125ParquetMaterials() != null) dst.setPorcelain85x125ParquetMaterials(src.getPorcelain85x125ParquetMaterials());
            if (src.getPorcelain85x125ParquetLabor() != null) dst.setPorcelain85x125ParquetLabor(src.getPorcelain85x125ParquetLabor());
            if (src.getSpcImportedParquetMaterials() != null) dst.setSpcImportedParquetMaterials(src.getSpcImportedParquetMaterials());
            if (src.getSpcImportedParquetLabor() != null) dst.setSpcImportedParquetLabor(src.getSpcImportedParquetLabor());
            if (src.getSpcLocalParquetMaterials() != null) dst.setSpcLocalParquetMaterials(src.getSpcLocalParquetMaterials());
            if (src.getSpcLocalParquetLabor() != null) dst.setSpcLocalParquetLabor(src.getSpcLocalParquetLabor());
            if (src.getPaintNormalMaterials() != null) dst.setPaintNormalMaterials(src.getPaintNormalMaterials());
            if (src.getPaintNormalLabor() != null) dst.setPaintNormalLabor(src.getPaintNormalLabor());
            if (src.getPaintDicoarMaterials() != null) dst.setPaintDicoarMaterials(src.getPaintDicoarMaterials());
            if (src.getPaintDicoarLabor() != null) dst.setPaintDicoarLabor(src.getPaintDicoarLabor());
            if (src.getTagliadMadeMaterials() != null) dst.setTagliadMadeMaterials(src.getTagliadMadeMaterials());
            if (src.getTagliadMadeLabor() != null) dst.setTagliadMadeLabor(src.getTagliadMadeLabor());
            if (src.getTagliadNormalMaterials() != null) dst.setTagliadNormalMaterials(src.getTagliadNormalMaterials());
            if (src.getTagliadNormalLabor() != null) dst.setTagliadNormalLabor(src.getTagliadNormalLabor());
            if (src.getBanohAtMaterials() != null) dst.setBanohAtMaterials(src.getBanohAtMaterials());
            if (src.getBanohAtLabor() != null) dst.setBanohAtLabor(src.getBanohAtLabor());
        }

        if (updates.getCeilingPrices() != null) {
            CeilingPrices src = updates.getCeilingPrices();
            CeilingPrices dst = existing.getCeilingPrices();

            if (src.getCeilingPaintNormalMaterials() != null) dst.setCeilingPaintNormalMaterials(src.getCeilingPaintNormalMaterials());
            if (src.getCeilingPaintNormalLabor() != null) dst.setCeilingPaintNormalLabor(src.getCeilingPaintNormalLabor());
            if (src.getCeilingPaintStretchMaterials() != null) dst.setCeilingPaintStretchMaterials(src.getCeilingPaintStretchMaterials());
            if (src.getCeilingPaintStretchLabor() != null) dst.setCeilingPaintStretchLabor(src.getCeilingPaintStretchLabor());
            if (src.getCeilingDicoarQatifaMaterials() != null) dst.setCeilingDicoarQatifaMaterials(src.getCeilingDicoarQatifaMaterials());
            if (src.getCeilingDicoarQatifaLabor() != null) dst.setCeilingDicoarQatifaLabor(src.getCeilingDicoarQatifaLabor());
            if (src.getCeilingDicoarTagalidMaterials() != null) dst.setCeilingDicoarTagalidMaterials(src.getCeilingDicoarTagalidMaterials());
            if (src.getCeilingDicoarTagalidLabor() != null) dst.setCeilingDicoarTagalidLabor(src.getCeilingDicoarTagalidLabor());
        }

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