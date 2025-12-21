package org.example.demo_11.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.demo_11.dto.*;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    // بريد الأدمن الافتراضي
    private static final String ADMIN_EMAIL = "ms4002@fayoum.edu.eg";

    public void sendEmail(String email, String subject, String body) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(body, true);
            mailSender.send(mimeMessage);
        } catch (MailException e) {
            throw new MailSendException("Failed to send email", e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * إرسال رسالة مفصلة بتكلفة الوحدة السكنية
     * - يرسل دائمًا للأدمن
     * - ويرسل للعميل لو البريد موجود
     */
    public void sendDetailedResidentialUnitEmail(CompleteResidentialUnitDto completeDto, String customerEmail) {
        String subject = "📊 تفاصيل تكلفة الوحدة السكنية - تقرير مفصل";
        String body = generateDetailedEmailBody(completeDto);

        // إرسال للأدمن دائمًا
        sendEmail(ADMIN_EMAIL, subject, body);

        // إرسال نسخة للعميل لو البريد موجود
        if (customerEmail != null && !customerEmail.trim().isEmpty()
                && !customerEmail.trim().equalsIgnoreCase(ADMIN_EMAIL)) {
            sendEmail(customerEmail.trim(), subject, body);
        }
    }

    /**
     * توليد محتوى البريد الإلكتروني المفصل
     */
    private String generateDetailedEmailBody(CompleteResidentialUnitDto completeDto) {
        StringBuilder html = new StringBuilder();

        html.append("""
            <!DOCTYPE html>
            <html dir="rtl" lang="ar">
            <head>
                <meta charset="UTF-8">
                <style>
                    body {
                        font-family: 'Arial', 'Segoe UI', Tahoma, sans-serif;
                        line-height: 1.6;
                        color: #333;
                        background-color: #f9f9f9;
                        margin: 0;
                        padding: 20px;
                    }
                    .container {
                        max-width: 900px;
                        margin: 0 auto;
                        background: white;
                        padding: 30px;
                        border-radius: 10px;
                        box-shadow: 0 0 20px rgba(0,0,0,0.1);
                    }
                    .header {
                        text-align: center;
                        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                        color: white;
                        padding: 20px;
                        border-radius: 10px 10px 0 0;
                        margin: -30px -30px 30px -30px;
                    }
                    .section {
                        margin: 25px 0;
                        padding: 20px;
                        background: #f8f9fa;
                        border-radius: 8px;
                        border-right: 4px solid #667eea;
                    }
                    .section-title {
                        color: #2c3e50;
                        margin-bottom: 15px;
                        font-size: 18px;
                        font-weight: bold;
                        border-bottom: 2px solid #e9ecef;
                        padding-bottom: 8px;
                    }
                    .price-item {
                        display: flex;
                        justify-content: space-between;
                        margin: 8px 0;
                        padding: 8px 12px;
                        background: white;
                        border-radius: 6px;
                        border: 1px solid #e9ecef;
                        gap: 10px;
                    }
                    .price-item .label {
                        flex: 1;
                    }
                    .price-item .value {
                        white-space: nowrap;
                    }
                    .formula {
                        margin: 0 0 10px 0;
                        padding: 8px 12px;
                        background: #fff;
                        border-radius: 6px;
                        border: 1px dashed #cfd6dd;
                        color: #555;
                        font-size: 13px;
                    }
                    .total {
                        font-weight: bold;
                        font-size: 18px;
                        color: #27ae60;
                        background: #d5f4e6;
                        padding: 12px;
                        border-radius: 6px;
                        margin-top: 10px;
                    }
                    .sub-total {
                        font-weight: bold;
                        color: #2980b9;
                        background: #d6eaf8;
                        padding: 10px;
                        border-radius: 6px;
                        margin: 10px 0 0 0;
                        display: flex;
                        justify-content: space-between;
                        gap: 10px;
                    }
                    .room-details {
                        background: #fff;
                        padding: 15px;
                        margin: 10px 0;
                        border-radius: 6px;
                        border: 1px solid #ddd;
                    }
                    .info-grid {
                        display: grid;
                        grid-template-columns: 1fr 1fr;
                        gap: 15px;
                        margin: 15px 0;
                    }
                    .info-item {
                        background: white;
                        padding: 12px;
                        border-radius: 6px;
                        border: 1px solid #e9ecef;
                    }
                    .currency {
                        color: #e74c3c;
                        font-weight: bold;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <div class="header">
                        <h1>🏠 تقرير مفصل لتكلفة الوحدة السكنية</h1>
                        <p>تحليل شامل لجميع بنود التكلفة</p>
                    </div>
            """);

        // ✅ (جديد) استخراج بيانات العميل مع fallback
        String customerName = resolveCustomerName(completeDto);
        String customerPhone = resolveCustomerPhone(completeDto);

        // المعلومات الأساسية
        html.append(String.format("""
            <div class="section">
                <div class="section-title">📋 المعلومات الأساسية</div>
                <div class="info-grid">
                    <div class="info-item"><strong>اسم العميل:</strong> %s</div>
                    <div class="info-item"><strong>رقم الهاتف:</strong> %s</div>

                    <div class="info-item"><strong>المساحة الكلية:</strong> %s م²</div>
                    <div class="info-item"><strong>عدد الغرف:</strong> %s</div>
                    <div class="info-item"><strong>الموقع:</strong> %s</div>
                    <div class="info-item"><strong>نوع الوحدة:</strong> %s</div>
                    <div class="info-item"><strong>حالة التشطيب:</strong> %s</div>
                    <div class="info-item"><strong>عدد الحمامات:</strong> %s</div>
                    <div class="info-item"><strong>عدد المطابخ:</strong> %s</div>
                </div>
            </div>
            """,
                escapeHtml(customerName),
                escapeHtml(customerPhone),
                formatNumber(completeDto.getTotalArea()),
                safeToString(completeDto.getRoomsNumber()),
                safeToString(completeDto.getLocation()),
                safeToString(completeDto.getUnitCollection()),
                safeToString(completeDto.getFinishingStatus()),
                safeToString(completeDto.getPathRoomsCount()),
                safeToString(completeDto.getKitchensCount())
        ));

        // ===== قسم الوحدة السكنية الأساسية =====
        if (completeDto.getUnitPriceDetails() != null) {
            ResidentialUnitDto unitDto = completeDto.getUnitPriceDetails();
            html.append("""
                <div class="section">
                    <div class="section-title">🏗️ تكاليف الوحدة السكنية الأساسية</div>
            """);

            addPriceItem(html,
                    safeLabel(unitDto.getPreviousFinishingDemolitionStr(), "تكسير التشطيب السابق"),
                    unitDto.getPreviousFinishingDemolition(),
                    unitDto.getDemolitionFormula());

            addPriceItem(html,
                    safeLabel(unitDto.getElectricalInstallationStr(), "تأسيس الكهرباء"),
                    unitDto.getElectricalInstallation(),
                    unitDto.getElectricalFormula());

            addPriceItem(html,
                    safeLabel(unitDto.getCementAndMaterialSupplyStr(), "توريدات أسمنت ومواد"),
                    unitDto.getCementAndMaterialSupply(),
                    unitDto.getCementMaterialFormula());

            addPriceItem(html,
                    safeLabel(unitDto.getCementSandAndMaterialsSupplyStr(), "توريدات رمل وأسمنت وخامات"),
                    unitDto.getCementSandAndMaterialsSupply(),
                    unitDto.getCementSandFormula());

            if (unitDto.getSpotPrice() != null && unitDto.getSpotPrice() > 0) {
                addPriceItem(html,
                        "الإضاءة (" + safeToString(unitDto.getSpotTypeStr()) + ")",
                        unitDto.getSpotPrice(),
                        unitDto.getSpotFormula());
            }

            if (unitDto.getMagneticTrackPrice() != null && unitDto.getMagneticTrackPrice() > 0) {
                addPriceItem(html,
                        "الماجنتيك تراك (" + safeToString(unitDto.getMagneticTrackTypeStr()) + ")",
                        unitDto.getMagneticTrackPrice(),
                        unitDto.getMagneticTrackFormula());
            }

            if (unitDto.getInteriorDoorsPrice() != null && unitDto.getInteriorDoorsPrice() > 0) {
                addPriceItem(html,
                        safeLabel(unitDto.getInteriorDoorsStr(), "الأبواب الداخلية")
                                + " (" + safeToString(unitDto.getInteriorDoorsCount()) + " باب)",
                        unitDto.getInteriorDoorsPrice(),
                        unitDto.getInteriorDoorsFormula());
            }

            if (unitDto.getExteriorDoorsPrice() != null && unitDto.getExteriorDoorsPrice() > 0) {
                addPriceItem(html,
                        safeLabel(unitDto.getExteriorDoorsStr(), "الباب الخارجي"),
                        unitDto.getExteriorDoorsPrice(),
                        unitDto.getExteriorDoorsFormula());
            }

            if (unitDto.getShutterPrice() != null && unitDto.getShutterPrice() > 0) {
                addPriceItem(html,
                        safeLabel(unitDto.getShutterStr(), "الشاتر")
                                + " (" + safeToString(unitDto.getShutterCount()) + " شباك)",
                        unitDto.getShutterPrice(),
                        unitDto.getShutterFormula());
            }

            if (unitDto.getWindowsPrice() != null && unitDto.getWindowsPrice() > 0) {
                addPriceItem(html,
                        safeLabel(unitDto.getWindowsStr(), "النوافذ")
                                + " (" + safeToString(unitDto.getWindowsCount()) + " شباك)",
                        unitDto.getWindowsPrice(),
                        unitDto.getWindowsFormula());
            }

            html.append(String.format("""
                <div class="sub-total">
                    <span>المجموع الجزئي للوحدة السكنية:</span>
                    <span class="currency">%s ج.م</span>
                </div>
                """, formatNumber(completeDto.getUnitTotalPrice())));

            html.append("</div>");
        }

        // ===== قسم الغرف =====
        if (completeDto.getRoomsDetails() != null && !completeDto.getRoomsDetails().isEmpty()) {
            html.append(String.format("""
                <div class="section">
                    <div class="section-title">🚪 تكاليف الغرف (%s غرفة)</div>
                """, safeToString(completeDto.getRoomsCount())));

            for (int i = 0; i < completeDto.getRoomsDetails().size(); i++) {
                RoomDto room = completeDto.getRoomsDetails().get(i);
                html.append(String.format("""
                    <div class="room-details">
                        <strong>الغرفة %s:</strong>
                    """, i + 1));

                addPriceItem(html,
                        " - " + safeToString(room.getFloorColdInsulationStr()),
                        room.getPriceFloorColdInsulation(),
                        room.getPriceFloorColdInsulationFormula());

                addPriceItem(html,
                        " - الأرضية (" + safeToString(room.getFloorMaterialSTR()) + ")",
                        room.getPriceFloorMaterial(),
                        room.getPriceFloorMaterialFormula());

                addPriceItem(html,
                        " - الحوائط (" + safeToString(room.getWallMaterialSTR()) + ")",
                        room.getPriceWallMaterial(),
                        room.getPriceWallMaterialFormula());

                addPriceItem(html,
                        " - السقف (" + safeToString(room.getCeilingTypeSTR()) + ")",
                        room.getCeilingTypePeice(),
                        room.getCeilingTypePeiceFormula());

                addPriceItem(html,
                        " - الشفاط (" + safeToString(room.getExhaustMaterialSTR()) + ")",
                        room.getPriceExhaust(),
                        room.getPriceExhaustFormula());

                if (room.getTotalPriceFormula() != null && !room.getTotalPriceFormula().trim().isEmpty()) {
                    html.append(String.format("""
                        <div class="formula"><strong>فورميولا الإجمالي:</strong> %s</div>
                        """, escapeHtml(room.getTotalPriceFormula())));
                }

                html.append(String.format("""
                    <div style="background: #e8f4fd; padding: 8px; border-radius: 4px; margin: 10px 0 0 0;">
                        <strong>المجموع:</strong> <span class="currency">%s ج.م</span>
                    </div>
                    </div>
                    """, formatNumber(room.getTotalPrice())));
            }

            html.append(String.format("""
                <div class="sub-total">
                    <span>المجموع الجزئي للغرف:</span>
                    <span class="currency">%s ج.م</span>
                </div>
                """, formatNumber(completeDto.getRoomsTotalPrice())));

            html.append("</div>");
        }

        // ===== قسم المطابخ =====
        if (completeDto.getKitchensDetails() != null && !completeDto.getKitchensDetails().isEmpty()) {
            html.append(String.format("""
                <div class="section">
                    <div class="section-title">👨‍🍳 تكاليف المطابخ (%s مطبخ)</div>
                """, safeToString(completeDto.getKitchensCount())));

            for (int i = 0; i < completeDto.getKitchensDetails().size(); i++) {
                KitchenDto kitchen = completeDto.getKitchensDetails().get(i);
                html.append(String.format("""
                    <div class="room-details">
                        <strong>المطبخ %s:</strong>
                    """, i + 1));

                String kitchenMaterialName = firstNonBlank(kitchen.getKitchenMaterialSTR(),
                        safeToString(kitchen.getKitchenMaterial()));
                addPriceItem(html,
                        " - خامة المطبخ (" + kitchenMaterialName + ")",
                        kitchen.getPriceKitchenMaterial(),
                        kitchen.getPriceKitchenMaterialFormula());

                addPriceItem(html,
                        " - السقف (" + safeToString(kitchen.getCeilingTypeSTR()) + ")",
                        kitchen.getCeilingTypePrice(),
                        kitchen.getCeilingTypeFormula());

                addPriceItem(html,
                        " - الشفاط (" + safeToString(kitchen.getExhaustMaterialSTR()) + ")",
                        kitchen.getPriceExhaust(),
                        kitchen.getPriceExhaustFormula());

                addPriceItem(html,
                        " - " + safeToString(kitchen.getAdaptationPriceSTR()),
                        kitchen.getAdaptationprice(),
                        kitchen.getAdaptationPriceFormula());

                addPriceItem(html,
                        " - " + safeToString(kitchen.getFloorColdInsulationSTR()),
                        kitchen.getFloorColdInsulation(),
                        kitchen.getFloorColdInsulationFormula());

                addPriceItem(html,
                        " - " + safeToString(kitchen.getPlumbingKitchenSetupSTR()),
                        kitchen.getPlumbingKitchenSetup(),
                        kitchen.getPlumbingKitchenSetupFormula());

                addPriceItem(html,
                        " - " + safeToString(kitchen.getPlumbingKitchenFinnishSTR()),
                        kitchen.getPlumbingKitchenFinnish(),
                        kitchen.getPlumbingKitchenFinnishFormula());

                addPriceItem(html,
                        " - " + safeToString(kitchen.getMaharhBand38STR()),
                        kitchen.getMaharhBand38(),
                        kitchen.getMaharhBand38Formula());

                if (kitchen.getTotalPriceFormula() != null && !kitchen.getTotalPriceFormula().trim().isEmpty()) {
                    html.append(String.format("""
                        <div class="formula"><strong>فورميولا الإجمالي:</strong> %s</div>
                        """, escapeHtml(kitchen.getTotalPriceFormula())));
                }

                html.append(String.format("""
                    <div style="background: #e8f4fd; padding: 8px; border-radius: 4px; margin: 10px 0 0 0;">
                        <strong>المجموع:</strong> <span class="currency">%s ج.م</span>
                    </div>
                    </div>
                    """, formatNumber(kitchen.getTotalPrice())));
            }

            html.append(String.format("""
                <div class="sub-total">
                    <span>المجموع الجزئي للمطابخ:</span>
                    <span class="currency">%s ج.م</span>
                </div>
                """, formatNumber(completeDto.getKitchensTotalPrice())));

            html.append("</div>");
        }

        // ===== قسم الحمامات =====
        if (completeDto.getPathRoomsDetails() != null && !completeDto.getPathRoomsDetails().isEmpty()) {
            html.append(String.format("""
                <div class="section">
                    <div class="section-title">🚽 تكاليف الحمامات (%s حمام)</div>
                """, safeToString(completeDto.getPathRoomsCount())));

            for (int i = 0; i < completeDto.getPathRoomsDetails().size(); i++) {
                PathDto pathRoom = completeDto.getPathRoomsDetails().get(i);
                html.append(String.format("""
                    <div class="room-details">
                        <strong>الحمام %s:</strong>
                    """, i + 1));

                addPriceItem(html, " - السقف (" + safeToString(pathRoom.getCeilingTypeSTR()) + ")", pathRoom.getCeilingType(), null);
                addPriceItem(html, " - الشفاط (" + safeToString(pathRoom.getExhaustMaterialSTR()) + ")", pathRoom.getPriceExhaust(), null);
                addPriceItem(html, " - القاعدة (" + safeToString(pathRoom.getBaseTypeSTR()) + ")", pathRoom.getPriceBase(), null);
                addPriceItem(html, " - منطقة الاستحمام (" + safeToString(pathRoom.getShowerAreaSTR()) + ")", pathRoom.getPriceShowerArea(), null);
                addPriceItem(html, " - الحوض (" + safeToString(pathRoom.getSinkTypeSTR()) + ")", pathRoom.getSinkPrice(), null);
                addPriceItem(html, " - العزل الحراري", pathRoom.getFloorColdInsulation(), null);
                addPriceItem(html, " - تأسيس السباكة", pathRoom.getPlumbingPatRoomSetup(), null);
                addPriceItem(html, " - تشطيب السباكة", pathRoom.getPlumbingPatRoomFinnish(), null);
                addPriceItem(html, " - المحارة", pathRoom.getMaharhBand38(), null);
                addPriceItem(html, " - دهان الحوائط", pathRoom.getPaintForWall(), null);
                addPriceItem(html, " - دهان السقف", pathRoom.getPaintForCeiling(), null);
                addPriceItem(html, " - اكسسوارات الحمام", pathRoom.getPathRoomAccesories(), null);

                html.append(String.format("""
                    <div style="background: #e8f4fd; padding: 8px; border-radius: 4px; margin: 10px 0 0 0;">
                        <strong>المجموع:</strong> <span class="currency">%s ج.م</span>
                    </div>
                    </div>
                    """, formatNumber(pathRoom.getTotalPrice())));
            }

            html.append(String.format("""
                <div class="sub-total">
                    <span>المجموع الجزئي للحمامات:</span>
                    <span class="currency">%s ج.م</span>
                </div>
                """, formatNumber(completeDto.getPathRoomsTotalPrice())));

            html.append("</div>");
        }

        // ===== المجموع الكلي =====
        html.append(String.format("""
            <div class="section">
                <div class="section-title">💰 الإجمالي النهائي</div>
                <div class="total">
                    <span>المجموع الكلي للتكلفة:</span>
                    <span class="currency">%s ج.م</span>
                </div>
            </div>
            """, formatNumber(completeDto.getTotalPrice())));

        html.append("""
                </div>
            </body>
            </html>
            """);

        return html.toString();
    }

    /**
     * إضافة عنصر سعر إلى HTML + (اختياري) فورميولا
     */
    private void addPriceItem(StringBuilder html, String label, Long price, String formula) {
        if (price != null && price > 0) {
            html.append(String.format("""
                <div class="price-item">
                    <span class="label">%s</span>
                    <span class="value currency">%s ج.م</span>
                </div>
                """, escapeHtml(label), formatNumber(price)));

            if (formula != null && !formula.trim().isEmpty()) {
                html.append(String.format("""
                    <div class="formula"><strong>فورميولا:</strong> %s</div>
                    """, escapeHtml(formula)));
            }
        }
    }

    private String safeLabel(String preferred, String fallback) {
        if (preferred == null || preferred.trim().isEmpty()) return fallback;
        return preferred;
    }

    private String firstNonBlank(String a, String b) {
        if (a != null && !a.trim().isEmpty()) return a.trim();
        if (b != null && !b.trim().isEmpty()) return b.trim();
        return "غير محدد";
    }

    private String resolveCustomerName(CompleteResidentialUnitDto completeDto) {
        // 1) من Complete DTO (لو ضفته)
        try {
            String v = completeDto.getCustomerName();
            if (v != null && !v.trim().isEmpty()) return v.trim();
        } catch (Exception ignored) {}

        // 2) fallback من unitPriceDetails
        if (completeDto.getUnitPriceDetails() != null) {
            String v = completeDto.getUnitPriceDetails().getCustomerName();
            if (v != null && !v.trim().isEmpty()) return v.trim();
        }

        return "غير محدد";
    }

    private String resolveCustomerPhone(CompleteResidentialUnitDto completeDto) {
        // 1) من Complete DTO (لو ضفته)
        try {
            String v = completeDto.getCustomerPhone();
            if (v != null && !v.trim().isEmpty()) return v.trim();
        } catch (Exception ignored) {}

        // 2) fallback من unitPriceDetails
        if (completeDto.getUnitPriceDetails() != null) {
            String v = completeDto.getUnitPriceDetails().getCustomerPhone();
            if (v != null && !v.trim().isEmpty()) return v.trim();
        }

        return "غير محدد";
    }

    /**
     * تنسيق الأرقام بفواصل
     */
    private String formatNumber(Long number) {
        if (number == null) return "0";
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }

    private String formatNumber(Integer number) {
        if (number == null) return "0";
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }

    /**
     * تحويل القيم إلى String بأمان
     */
    private String safeToString(Object obj) {
        if (obj == null) return "غير محدد";
        return obj.toString();
    }

    private String safeToString(Integer number) {
        if (number == null) return "0";
        return number.toString();
    }

    /**
     * حماية بسيطة من كسر HTML لو النصوص فيها رموز
     */
    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
