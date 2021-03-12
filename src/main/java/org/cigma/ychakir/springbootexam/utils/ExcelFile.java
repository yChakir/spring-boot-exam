package org.cigma.ychakir.springbootexam.utils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel file builder to create {@link XSSFWorkbook} file (XLSX).
 */
public class ExcelFile {

  private static final Pattern NUMERIC_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

  /**
   * Get Builder to create {@link XSSFWorkbook} excel file.
   *
   * @return Builder to create Excel file
   */
  public static ExcelFileBuilder builder() {
    return new ExcelFileBuilder();
  }

  public enum FontType {
    NORMAL, BOLD
  }

  public static class ExcelFileBuilder {

    private String sheetName;
    private boolean autoSizeColumn = true;
    private boolean forceNumeric = true;
    private FontType headerFontType;
    private String[] headers;
    private List<String[]> data;

    ExcelFileBuilder() {
    }

    /**
     * Set the sheet name.
     *
     * @param sheetName the name of the sheet
     * @return the current instance of this builder.
     */
    public ExcelFileBuilder sheetName(String sheetName) {
      this.sheetName = sheetName;
      return this;
    }

    /**
     * Flag to indicate if the column width should be adjusted to fit the contents. Default value is <code>true</code>.
     *
     * @param autoSizeColumn <code>false</code> to not adjust column width.
     * @return the current instance of this builder.
     */
    public ExcelFileBuilder autoSizeColumn(boolean autoSizeColumn) {
      this.autoSizeColumn = autoSizeColumn;
      return this;
    }

    /**
     * Flag to indicate if numeric cell should be treated as numeric. Default value is <code>true</code>.
     *
     * @param forceNumeric <code>false</code> to not trat numeric values as numeric.
     * @return the current instance of this builder.
     */
    public ExcelFileBuilder forceNumeric(boolean forceNumeric) {
      this.forceNumeric = forceNumeric;
      return this;
    }

    /**
     * Set the header font Type. If not set, a default font will be generated.
     *
     * @param headerFontType the font type
     * @return the current instance of this builder.
     * @see FontType
     * @see XSSFWorkbook#createFont()
     */
    public ExcelFileBuilder headerFontType(FontType headerFontType) {
      this.headerFontType = headerFontType;
      return this;
    }

    /**
     * Set the headers name (columns names).
     *
     * @param headers the columns name
     * @return the current instance of this builder.
     */
    public ExcelFileBuilder headers(String[] headers) {
      this.headers = headers;
      return this;
    }

    /**
     * Set the data to be generated for this file.
     *
     * @param data the data to be included in this file.
     * @return the current instance of this builder.
     */
    public ExcelFileBuilder data(List<String[]> data) {
      this.data = data;
      return this;
    }

    public XSSFWorkbook buildExcel() {
      if (this.data == null || this.data.isEmpty()) {
        throw new IllegalArgumentException("Data should not be empty !");
      }
      if (this.headers == null || this.headers.length == 0) {
        throw new IllegalArgumentException("Headers should be provided !");
      }

      checkConsistency();

      final XSSFWorkbook workbook = new XSSFWorkbook();
      final Font headerFont;
      if (this.headerFontType != null) {
        if (FontType.NORMAL.equals(this.headerFontType)) {
          headerFont = ExcelUtil.getFontNormal(workbook);
        } else if (FontType.BOLD.equals(this.headerFontType)) {
          headerFont = ExcelUtil.getFontBold(workbook);
        } else {
          headerFont = workbook.createFont();
        }
      } else {
        headerFont = workbook.createFont();
      }

      if (this.sheetName == null || this.sheetName.trim().isEmpty()) {
        this.sheetName = "DataSheet";
      }
      final XSSFCellStyle headerCellStyle = workbook.createCellStyle();
      headerCellStyle.setFont(headerFont);

      final XSSFSheet sheet = workbook.createSheet(this.sheetName);

      int rowIndex = 0;
      final Row headerRow = sheet.createRow(rowIndex++);
      final AtomicInteger headerIndex = new AtomicInteger(0);
      // Construct header row
      for (String headerName : headers) {
        final Cell cell = headerRow.createCell(headerIndex.getAndIncrement());
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(headerName);
      }
      // create rows
      final Font dataFont = ExcelUtil.getFontNormal(workbook);
      final XSSFCellStyle dataCellStyle = workbook.createCellStyle();
      dataCellStyle.setFont(dataFont);
      final CellStyle numericStyle = ExcelUtil.getNumericStyle(workbook);
      numericStyle.setFont(dataFont);

      for (final String[] line : this.data) {
        final XSSFRow row = sheet.createRow(rowIndex++);
        for (int i = 0; i < line.length; i++) {
          final String value = line[i];
          final XSSFCell cell = row.createCell(i);
          final boolean numeric = value != null && NUMERIC_PATTERN.matcher(value).matches();
          if (forceNumeric && numeric) {
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellStyle(numericStyle);
            cell.setCellValue(Float.parseFloat(value));
          } else {
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellStyle(dataCellStyle);
            cell.setCellValue(value);
          }
        }
      }

      if (autoSizeColumn) {
        for (int i = 0; i < headers.length; i++) {
          sheet.autoSizeColumn(i); // Warning about performance, if so use the below code instead.
          //int width = ((int)(40 * 1.14388)) * 256;
          //sheet.setColumnWidth(i, width);
        }
      }
      return workbook;
    }

    private void checkConsistency() {
      for (String[] line : this.data) {
        if (line.length != headers.length) {
          throw new IllegalArgumentException("Headers number and data are not consistent !");
        }
      }
    }
  }

}
