package com.printer.utils;

import java.io.FileInputStream;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xslf.usermodel.XSLFSlideShow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class PIOGetPage {
	// public static void main(String[] args) {
	// try {
	// getPage("F:\\文档\\Tencent Files\\1959997566\\FileRecv\\ACCESS题库全部选择题。.doc");
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	public static int getPage(String FilePath) throws Exception {
		// String lowerFilePath = filePath.toLowerCase();
		if (FilePath.endsWith(".xls")) {
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
					FilePath));
			Integer sheetNums = workbook.getNumberOfSheets();
			if (sheetNums > 0) {
				return workbook.getSheetAt(0).getRowBreaks().length + 1;
			}
		} else if (FilePath.endsWith(".xlsx")) {
			XSSFWorkbook xwb = new XSSFWorkbook(FilePath);
			Integer sheetNums = xwb.getNumberOfSheets();
			if (sheetNums > 0) {
				return xwb.getSheetAt(0).getRowBreaks().length + 1;
			}
		} else if (FilePath.endsWith(".docx")) {
			XWPFDocument docx = new XWPFDocument(
					POIXMLDocument.openPackage(FilePath));
			return docx.getProperties().getExtendedProperties()
					.getUnderlyingProperties().getPages();
		} else if (FilePath.endsWith(".doc")) {
			HWPFDocument wordDoc = new HWPFDocument(new FileInputStream(
					FilePath));

			return wordDoc.getSummaryInformation().getPageCount();
		} else if (FilePath.endsWith(".ppt")) {
			HSLFSlideShow document = new HSLFSlideShow(new FileInputStream(
					FilePath));

			return document.getSlides().size();

		} else if (FilePath.endsWith(".pptx")) {

			XSLFSlideShow xdocument = new XSLFSlideShow(FilePath);
			return xdocument.getPresentation().getSldIdLst().sizeOfSldIdArray();
		}
		return 0;
	}
}
