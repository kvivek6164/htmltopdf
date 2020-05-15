package com.example.demo;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import com.itextpdf.styledxmlparser.css.media.MediaType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemoApplication.class, args);
		String htmlSource = getContent();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setMediaDeviceDescription(new MediaDeviceDescription(MediaType.PRINT));
		HtmlConverter.convertToPdf(htmlSource, outputStream, converterProperties);
		byte[] bytes = outputStream.toByteArray();
		File pdfFile = new File("java9.pdf");
		FileOutputStream fos = new FileOutputStream(pdfFile);
		fos.write(bytes);
		fos.flush();
		fos.close();
	}

	private static String getContent() {
		return "<!DOCTYPE html>\n" +
				"<html lang=\"en\">\n" +
				"\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
				"    <link href=\"https://fonts.googleapis.com/css2?family=Harmattan&display=swap\" rel=\"stylesheet\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
				"    <title>Document</title>\n" +
				"</head>\n" +
				"\n" +
				"<body\n" +
				"    style=\"margin: 0;padding: 0;;font-family: 'Harmattan', sans-serif;font-size: 14px;line-height: 125%;width: 100%;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;color: #222222;\">\n" +
				"    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background: white;\">\n" +
				"        <tbody>\n" +
				"            <tr>\n" +
				"                <td style=\"background: #93d500;height: 84px; padding: 8px 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td>\n" +
				"                                    <img src=\"https://seera-auto-rental-qa.s3.eu-central-1.amazonaws.com/qa/lar-cms/logo_white.png\"\n" +
				"                                        alt=\"Logo\">\n" +
				"                                </td>\n" +
				"                                <td\n" +
				"                                    style=\"text-align:right; color: #fff;font-weight: 700;font-size: 18px;padding: 23px 0;\">\n" +
				"                                    <span th:text=\"${currentDate}\">Fri, Nov 01, 2019</span>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td style=\"padding: 8px 0;text-align: left;vertical-align: top;\">\n" +
				"                                    <p style=\"font-size: 24px;line-height: 26px;font-weight: bold;margin: 0;\">\n" +
				"                                        Thanks for riding with us, <br>\n" +
				"                                        <span th:text=\"${firstName}\">Steve</span>\n" +
				"                                    </p>\n" +
				"                                </td>\n" +
				"                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                    <p\n" +
				"                                        style=\"font-size: 18px;font-weight:normal;line-height: 20px;text-align: right;margin: 0;\">\n" +
				"                                        <strong>Booking Date:</strong> <span th:text=\"${bookingDate}\">22 April\n" +
				"                                            2020</span><br>\n" +
				"                                        <strong>Booking ID:</strong> <span th:text=\"${bookingId}\">550</span><br>\n" +
				"                                        <strong>Invoice ID:</strong> <span th:text=\"${invoiceId}\">334</span>\n" +
				"                                    </p>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <p>\n" +
				"                        We hope you enjoyed your rental experience\n" +
				"                    </p>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <th\n" +
				"                                    style=\"font-size: 25px;padding: 15px 0;border-bottom: solid 2px #92d500;text-align: left;\">\n" +
				"                                    Total Fare\n" +
				"                                </th>\n" +
				"                                <th\n" +
				"                                    style=\"font-size: 25px;padding: 15px 0;border-bottom: solid 2px #92d500;text-align: right;\">\n" +
				"                                    <small style=\"font-size: 18px; font-weight: normal;\">SAR</small>\n" +
				"                                    <span th:text=\"${totalFare}\">580.00</span>\n" +
				"                                </th>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 10px 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                    Daily Rental\n" +
				"                                </td>\n" +
				"                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                    <small>SAR </small><span th:text=\"${dailyRental}\">450.00</span>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                            <tr th:if=\"${cdw} != 0\">\n" +
				"                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                    Collision Damage Waiver<br>\n" +
				"                                    (CDW)\n" +
				"                                </td>\n" +
				"                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                    <small>SAR </small><span th:text=\"${cdw}\">35.00</span>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                            <tr th:if=\"${excessKm} != 0\">\n" +
				"                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                    Excess <span style=\"font-weight: bold;\" th:text=\"${excessKm}\">15</span>\n" +
				"                                    KMs\n" +
				"                                </td>\n" +
				"                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                    <small>SAR </small><span th:text=\"${excessKmCharge}\">60.00</span>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-top: solid 2px #a5a5a5;\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td style=\"padding: 10px 0px;\">\n" +
				"                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                                        <tbody>\n" +
				"                                            <tr>\n" +
				"                                                <th colspan=\"2\"\n" +
				"                                                    style=\"padding: 8px 0;text-align: left;font-weight: bold;\">\n" +
				"                                                    <b>Additional Charges</b>\n" +
				"                                                </th>\n" +
				"                                            </tr>\n" +
				"                                            <tr th:if=\"${minorDamage} != 0\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    Minor Damage\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    <small>SAR </small><span th:text=\"${minorDamage}\">10.00</span>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                            <tr th:if=\"${majorDamage} != 0\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    Major Damage\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    <small>SAR </small><span th:text=\"${majorDamage}\">20.00</span>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                            <tr th:if=\"${trafficFines} != 0\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    Traffic Fines\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    <small>SAR </small><span th:text=\"${trafficFines}\">50.00</span>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                        </tbody>\n" +
				"                                    </table>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-top: solid 2px #a5a5a5;\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td style=\"padding: 10px 0px;\">\n" +
				"                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                                        <tbody>\n" +
				"                                            <tr th:if=\"${promotions} != 0\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    Promotions\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;color: #93d500;\">\n" +
				"                                                    <small>-SAR </small><span th:text=\"${promotions}\">35.00</span>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                            <tr th:if=\"${refund} != 0\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    Refunds\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;color: #93d500;\">\n" +
				"                                                    <small>-SAR </small><span th:text=\"${refunds}\">80.00</span>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                        </tbody>\n" +
				"                                    </table>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-top: solid 2px #a5a5a5;\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td style=\"padding: 10px 0px;\">\n" +
				"                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                                        <tbody>\n" +
				"                                            <tr>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    Before Taxes\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    <small>SAR </small><span th:text=\"${beforeTaxes}\">550.00</span>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                            <tr>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    VAT amount (5%)\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    <small>SAR </small><span th:text=\"${vat}\">30.00</span>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                        </tbody>\n" +
				"                                    </table>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-top: solid 2px #a5a5a5;\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td style=\"padding: 10px 0px;\">\n" +
				"                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                                        <tbody>\n" +
				"                                            <tr th:if=\"${amountStatus} == 'Amount Pending'\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;font-weight: bold;\">\n" +
				"                                                    <b>Amount Pending</b>\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    <small>SAR </small><span th:text=\"${totalFare}\">800.00</span>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                            <tr th:if=\"${amountStatus} == 'Amount Charged'\">\n" +
				"                                                <td colspan=\"2\"\n" +
				"                                                    style=\"padding: 8px 0;text-align: left;font-weight: bold;\">\n" +
				"                                                    <b>Amount Charged</b>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                            <tr th:if=\"${amountStatus} == 'Amount Charged'\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    <img style=\"width: 45px; height: 30px; display: inline-block;\"\n" +
				"                                                        src=\"https://seera-auto-rental-qa.s3.eu-central-1.amazonaws.com/icon/Image_45@2x.png\"\n" +
				"                                                        alt=\"\">\n" +
				"                                                    **** <span th:text=\"${cardNo}\"></span>\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    <small>SAR </small><span th:text=\"${totalFare}\">580.00</span>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                        </tbody>\n" +
				"                                    </table>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 8px 35px;text-align: left;\">\n" +
				"                    <br>Please keep this invoice as record of your\n" +
				"                    payment.\n" +
				"\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 8px 35px;text-align: left;\">Happy Driving! <br>\n" +
				"                    <span style=\"margin-top:5px; display: block;\">\n" +
				"                        Lumi\n" +
				"                        Car Rental Team\n" +
				"                    </span>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 8px 35px;text-align: left;color: #707070\">\n" +
				"                    <small style=\"font-size: 11px;\">Fare does not include fees that may be charged by\n" +
				"                        your bank. Please contact your bank\n" +
				"                        directly for inquiries</small>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"        </tbody>\n" +
				"    </table>\n" +
				"    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background: white; direction: rtl;\">\n" +
				"        <tbody>\n" +
				"            <tr>\n" +
				"                <td style=\"background: #93d500;height: 84px; padding: 8px 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td>\n" +
				"                                    <img src=\"https://seera-auto-rental-qa.s3.eu-central-1.amazonaws.com/qa/lar-cms/logo_white.png\"\n" +
				"                                        alt=\"Logo\">\n" +
				"                                </td>\n" +
				"                                <td\n" +
				"                                    style=\"text-align:left; color: #fff;font-weight: 700;font-size: 18px;padding: 23px 0;\">\n" +
				"                                    <span th:text=\"${currentDate}\">Fri, Nov 01, 2019</span>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td style=\"padding: 8px 0;text-align: right;vertical-align: top;\">\n" +
				"                                    <p style=\"font-size: 24px;line-height: 26px;font-weight: bold;margin: 0;\">\n" +
				"                                        شكرا لركوب معنا ،<br>\n" +
				"                                        <span th:text=\"${firstName}\">Steve</span>\n" +
				"                                    </p>\n" +
				"                                </td>\n" +
				"                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                    <p\n" +
				"                                        style=\"font-size: 18px;font-weight:normal;line-height: 20px;text-align: left;margin: 0;\">\n" +
				"                                        <strong>تاريخ الحجز:</strong><span th:text=\"${bookingDate}\">22 April\n" +
				"                                            2020</span>\n" +
				"                                        <br>\n" +
				"                                        <strong>معرف الفاتورة:</strong> <span th:text=\"${bookingId}\">550</span>\n" +
				"                                        <br>\n" +
				"                                        <strong>معرف فاتورة:</strong> <span th:text=\"${invoiceId}\">334</span>\n" +
				"\n" +
				"                                    </p>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <p>\n" +
				"                        نأمل أن تستمتع بتجربة استئجارك\n" +
				"                    </p>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <th\n" +
				"                                    style=\"font-size: 25px;padding: 15px 0;border-bottom: solid 2px #92d500;text-align: right;\">\n" +
				"                                    الأجرة الكلية\n" +
				"                                </th>\n" +
				"                                <th\n" +
				"                                    style=\"font-size: 25px;padding: 15px 0;border-bottom: solid 2px #92d500;text-align: left;\">\n" +
				"                                    <span th:text=\"${totalFare}\">580.00</span>\n" +
				"                                    <small style=\"font-size: 18px; font-weight: normal;\">ريال</small>\n" +
				"                                </th>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 10px 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                    تأجير اليومي\n" +
				"                                </td>\n" +
				"                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                    <span th:text=\"${dailyRental}\">450.00</span> <small>ريال </small>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                            <tr th:if=\"${cdw} != 0\">\n" +
				"                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                    التنازل عن ضرر الحادث<br>\n" +
				"                                    (تأمين السيارة)\n" +
				"                                </td>\n" +
				"                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                    <span th:text=\"${cdw}\">35.00</span> <small>ريال </small>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                            <tr th:if=\"${excessKm} != 0\">\n" +
				"                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                    KMs <span style=\"font-weight: bold;\" th:text=\"${excessKm}\">15</span>\n" +
				"                                    فائض <br>\n" +
				"                                </td>\n" +
				"                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                    <span th:text=\"${excessKmCharge}\">60.00</span> <small>ريال </small>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-top: solid 2px #a5a5a5;\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td style=\"padding: 10px 0px;\">\n" +
				"                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                                        <tbody>\n" +
				"                                            <tr>\n" +
				"                                                <th colspan=\"2\"\n" +
				"                                                    style=\"padding: 8px 0;text-align: right;font-weight: bold;\">\n" +
				"                                                    <strong>رسوم إضافية</strong>\n" +
				"                                                </th>\n" +
				"                                            </tr>\n" +
				"                                            <tr th:if=\"${minorDamage} != 0\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    ضرر طفيف\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    <span th:text=\"${minorDamage}\">10.00</span> <small>ريال </small>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                            <tr th:if=\"${majorDamage} != 0\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    أضرار كبيرة\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    <span th:text=\"${majorDamage}\">20.00</span> <small>ريال </small>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                            <tr th:if=\"${trafficFines} != 0\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    المخالفات المرورية\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    <span th:text=\"${trafficFines}\">50.00</span> <small>ريال </small>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                        </tbody>\n" +
				"                                    </table>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-top: solid 2px #a5a5a5;\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td style=\"padding: 10px 0px;\">\n" +
				"                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                                        <tbody>\n" +
				"                                            <tr th:if=\"${promotions} != 0\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    الترقيات\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;color: #93d500;\">\n" +
				"                                                    <span th:text=\"${promotions}\">35.00</span> <small>-ريال\n" +
				"                                                        </small>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                            <tr th:if=\"${refund} != 0\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    إعادة مال\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;color: #93d500;\">\n" +
				"                                                    <span th:text=\"${refunds}\">80.00</span> <small>-ريال\n" +
				"                                                        </small>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                        </tbody>\n" +
				"                                    </table>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-top: solid 2px #a5a5a5;\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td style=\"padding: 10px 0px;\">\n" +
				"                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                                        <tbody>\n" +
				"                                            <tr>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    قبل الضرائب\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    <span th:text=\"${beforeTaxes}\">550.00</span> <small>ريال </small>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                            <tr>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    VAT amount (5%)\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    <span th:text=\"${vat}\">30.00</span> <small>ريال </small>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                        </tbody>\n" +
				"                                    </table>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 0 35px;\">\n" +
				"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-top: solid 2px #a5a5a5;\">\n" +
				"                        <tbody>\n" +
				"                            <tr>\n" +
				"                                <td style=\"padding: 10px 0px;\">\n" +
				"                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                                        <tbody>\n" +
				"                                            <tr th:if=\"${amountStatus} == 'Amount Pending'\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right; font-weight: bold;\">\n" +
				"                                                    المبلغ المعلق\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    <span th:text=\"${totalFare}\">800.00</span> <small>ريال </small>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                            <tr th:if=\"${amountStatus} == 'Amount Charged'\">\n" +
				"                                                <td colspan=\"2\"\n" +
				"                                                    style=\"padding: 8px 0;text-align: right;font-weight: bold;\">\n" +
				"                                                    <b>المبلغ المشحون</b>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                            <tr th:if=\"${amountStatus} == 'Amount Charged'\">\n" +
				"                                                <td style=\"padding: 8px 0;text-align: right;\">\n" +
				"                                                    <img style=\"width: 45px; height: 30px; display: inline-block;\"\n" +
				"                                                        src=\"https://seera-auto-rental-qa.s3.eu-central-1.amazonaws.com/icon/Image_45@2x.png\"\n" +
				"                                                        alt=\"\">\n" +
				"                                                    **** <span th:text=\"${cardNo}\"></span>\n" +
				"                                                </td>\n" +
				"                                                <td style=\"padding: 8px 0;text-align: left;\">\n" +
				"                                                    <span th:text=\"${totalFare}\">580.00</span> <small>ريال </small>\n" +
				"                                                </td>\n" +
				"                                            </tr>\n" +
				"                                        </tbody>\n" +
				"                                    </table>\n" +
				"                                </td>\n" +
				"                            </tr>\n" +
				"                        </tbody>\n" +
				"                    </table>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 8px 35px;text-align: right;\">\n" +
				"                    <p>\n" +
				"                        يرجى الاحتفاظ بهذه الفاتورة كسجل للدفع.\n" +
				"                    </p>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 8px 35px;text-align: right;\">\n" +
				"                    قيادة سعيدة!\n" +
				"                    <br>\n" +
				"                    <span style=\"margin-top:5px; display: block;\">\n" +
				"                        فريق لومي لتأجير السيارات\n" +
				"                    </span>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"            <tr>\n" +
				"                <td style=\"padding: 8px 35px;text-align: right;color: #707070\">\n" +
				"                    <small style=\"font-size: 11px;\">Fare does not include fees that may be charged by\n" +
				"                        your bank. Please contact your bank\n" +
				"                        directly for inquiries</small>\n" +
				"                </td>\n" +
				"            </tr>\n" +
				"        </tbody>\n" +
				"    </table>\n" +
				"\n" +
				"</body>\n" +
				"\n" +
				"</html>";
	}
}
