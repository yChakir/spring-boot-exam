package org.cigma.ychakir.springbootexam.utils;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Utility class to manipulate Excel file (XLSX).
 */
public class ExcelUtil {

  /**
   * create a new Bold Font and add it to the workbook's font table
   *
   * @param workbook the workbook object
   * @return new bold font object
   */
  public static Font getFontBold(final XSSFWorkbook workbook) {
    final Font cellFontBold = getFontNormal(workbook);
    cellFontBold.setBoldweight(Font.BOLDWEIGHT_BOLD);
    return cellFontBold;
  }

  /**
   * create a new Normal Font and add it to the workbook's font table
   *
   * @param workbook the workbook object
   * @return new normal font object
   */
  public static Font getFontNormal(final XSSFWorkbook workbook) {
    final Font cellFontNormal = workbook.createFont();
    cellFontNormal.setFontHeightInPoints((short) 12);
    cellFontNormal.setFontName("Arial");
    cellFontNormal.setColor(IndexedColors.BLACK.getIndex());
    return cellFontNormal;
  }

  /**
   * create a new numeric style with format ##0.00
   *
   * @param workbook the workbook object
   * @return new numeric style object
   */
  public static CellStyle getNumericStyle(final XSSFWorkbook workbook) {
    final CellStyle numericStyle = workbook.createCellStyle();
    final CreationHelper createHelper = workbook.getCreationHelper();
    numericStyle.setDataFormat(createHelper.createDataFormat().getFormat("##0.00"));
    return numericStyle;
  }

}
