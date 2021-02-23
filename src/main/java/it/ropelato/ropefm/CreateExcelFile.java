package it.ropelato.ropefm;

import it.ropelato.durability.stime.Evoluta;
import it.ropelato.durability.utility.Utility;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class CreateExcelFile {
  int rownum = 0;
  
  HSSFWorkbook workbook = new HSSFWorkbook();
  
  HSSFSheet firstSheet = this.workbook.createSheet("FIRST SHEET");
  
  Collection<File> files;
  
  File exactFile;
  
  CreateExcelFile(List<List> l1) throws Exception {
    HSSFRow hSSFRow = this.firstSheet.createRow(this.rownum);
    hSSFRow.setHeightInPoints(40.0F);
    try {
      for (int j = 0; j < l1.size(); j++) {
        HSSFRow hSSFRow1 = this.firstSheet.createRow(this.rownum);
        List<String> l2 = l1.get(j);
        for (int k = 0; k < l2.size(); k++) {
          Cell cell = hSSFRow1.createCell(k);
          cell.setCellValue(l2.get(k));
        } 
        this.rownum++;
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public static String excelExp(Evoluta evo, HttpServletRequest request) throws Exception {
    List<String> headerRow = new ArrayList<String>();
    headerRow.add("Estimated Service Life");
    headerRow.add("Fattore A");
    headerRow.add("Fattore B");
    headerRow.add("Fattore C");
    headerRow.add("Fattore D");
    headerRow.add("Fattore E");
    headerRow.add("Fattore F");
    headerRow.add("Fattore G");
    List<List> recordToAdd = new ArrayList<List>();
    recordToAdd.add(headerRow);
    for (int i = 0; i < Evoluta.N; i++) {
      List<String> Row = new ArrayList<String>();
      Row.add(String.valueOf(evo.getESL()[0].getValues()[i]).replace('.', ','));
      Row.add(String.valueOf(evo.getA().getValues()[0][i]).replace('.', ','));
      Row.add(String.valueOf(evo.getB().getValues()[0][i]).replace('.', ','));
      Row.add(String.valueOf(evo.getC().getValues()[0][i]).replace('.', ','));
      Row.add(String.valueOf(evo.getD().getValues()[0][i]).replace('.', ','));
      Row.add(String.valueOf(evo.getE().getValues()[0][i]).replace('.', ','));
      Row.add(String.valueOf(evo.getF().getValues()[0][i]).replace('.', ','));
      Row.add(String.valueOf(evo.getG().getValues()[0][i]).replace('.', ','));
      recordToAdd.add(Row);
    } 
    it.ropelato.ropefm.CreateExcelFile cls = new it.ropelato.ropefm.CreateExcelFile(recordToAdd);
    return cls.createExcelFile(request);
  }
  
  String createExcelFile(HttpServletRequest request) {
    FileOutputStream fos = null;
    String context = request.getRealPath("/");
    Random rn = new Random();
    int simul = rn.nextInt();
    String filename = "SimulationSheet_" + Math.abs(simul) + ".xls";
    Utility.print(String.valueOf(context) + "/assets/" + filename);
    try {
      fos = new FileOutputStream(new File(String.valueOf(context) + "/assets/" + filename));
      HSSFCellStyle hsfstyle = this.workbook.createCellStyle();
      // hsfstyle.setBorderBottom((short)1);
      hsfstyle.setFillBackgroundColor((short)245);
      this.workbook.write(fos);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return filename;
  }
}