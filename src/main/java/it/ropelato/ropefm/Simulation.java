package it.ropelato.ropefm;

import it.ropelato.durability.stime.Evoluta;
import it.ropelato.durability.stime.EvolutaESL;
import it.ropelato.durability.stime.Factor;
import it.ropelato.durability.stime.Fattoriale;
import it.ropelato.durability.utility.Utility;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.json.JSONException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@RestController
public class Simulation {

  @PostMapping(path = "/api/esl", consumes = "application/json", produces = "application/json")
  public String getESLfattoriale(@RequestBody String factors) {
    Fattoriale fat = new Fattoriale();
    try {
      JSONObject jsonObject = new JSONObject(factors);
      fat.setFactors(Double.valueOf(jsonObject.get("fatA").toString()), Double.valueOf(jsonObject.get("fatB").toString()),
              Double.valueOf(jsonObject.get("fatC").toString()), Double.valueOf(jsonObject.get("fatD").toString()),
              Double.valueOf(jsonObject.get("fatE").toString()), Double.valueOf(jsonObject.get("fatF").toString()),
              Double.valueOf(jsonObject.get("fatG").toString()));
      fat.setRSL(Double.valueOf(jsonObject.get("RSL").toString()));
    }catch (JSONException err){
      System.out.println(err.toString());
    }
    return String.valueOf(Math.round(fat.getESL().doubleValue() * 100.0D) / 100.0D);
  };

  @PostMapping(path = "/api/esl/evolved", consumes = "application/json", produces = "application/json")
  public Map<String, Object> getESLEvoluto(@RequestBody String factors, HttpServletRequest request) throws Exception {
    TimeZone tz1 = TimeZone.getTimeZone("EST");
    Date now1 = new Date();
    DateFormat df1 = new SimpleDateFormat("yyyy.mm.dd hh:mm:ss ");
    df1.setTimeZone(tz1);
    String currentTime1 = df1.format(now1);
    Utility.print(String.valueOf(currentTime1) + " :inizio");
    Evoluta evo = new Evoluta();
    Map<String, Object> response = new HashMap<String, Object>();
    try {
      JSONObject jsonObject = new JSONObject(factors);
      evo.setN(Integer.valueOf(jsonObject.get("iterations").toString()));
      evo.setM(Integer.valueOf(1));
      evo.setA(Integer.valueOf(jsonObject.get("distrA").toString()), Double.valueOf(jsonObject.get("fatA1").toString()), Double.valueOf(jsonObject.get("fatA2").toString()), Double.valueOf(jsonObject.get("fatA3").toString()));
      evo.setB(Integer.valueOf(jsonObject.get("distrB").toString()), Double.valueOf(jsonObject.get("fatB1").toString()), Double.valueOf(jsonObject.get("fatB2").toString()), Double.valueOf(jsonObject.get("fatB3").toString()));
      evo.setC(Integer.valueOf(jsonObject.get("distrC").toString()), Double.valueOf(jsonObject.get("fatC1").toString()), Double.valueOf(jsonObject.get("fatC2").toString()), Double.valueOf(jsonObject.get("fatC3").toString()));
      evo.setD(Integer.valueOf(jsonObject.get("distrD").toString()), Double.valueOf(jsonObject.get("fatD1").toString()), Double.valueOf(jsonObject.get("fatD2").toString()), Double.valueOf(jsonObject.get("fatD3").toString()));
      evo.setE(Integer.valueOf(jsonObject.get("distrE").toString()), Double.valueOf(jsonObject.get("fatE1").toString()), Double.valueOf(jsonObject.get("fatE2").toString()), Double.valueOf(jsonObject.get("fatE3").toString()));
      evo.setF(Integer.valueOf(jsonObject.get("distrF").toString()), Double.valueOf(jsonObject.get("fatF1").toString()), Double.valueOf(jsonObject.get("fatF2").toString()), Double.valueOf(jsonObject.get("fatF3").toString()));
      evo.setG(Integer.valueOf(jsonObject.get("distrG").toString()), Double.valueOf(jsonObject.get("fatG1").toString()), Double.valueOf(jsonObject.get("fatG2").toString()), Double.valueOf(jsonObject.get("fatG3").toString()));
      evo.setRSL(Double.valueOf(jsonObject.get("RSL").toString()));
      EvolutaESL[] outevo = evo.getESL();
      Map<String, Map<String, Object>> respESL = new HashMap<String, Map<String, Object>>();
      respESL.put("graficoESL", getriassuntoESL(outevo[0]));
      Map<String, Map<String, Object>> respFatA = new HashMap<String, Map<String, Object>>();
      respFatA.put("graficoFatA", getriassuntoFAT(evo.getA()));
      Map<String, Map<String, Object>> respFatB = new HashMap<String, Map<String, Object>>();
      respFatB.put("graficoFatB", getriassuntoFAT(evo.getB()));
      Map<String, Map<String, Object>> respFatC = new HashMap<String, Map<String, Object>>();
      respFatC.put("graficoFatC", getriassuntoFAT(evo.getC()));
      Map<String, Map<String, Object>> respFatD = new HashMap<String, Map<String, Object>>();
      respFatD.put("graficoFatD", getriassuntoFAT(evo.getD()));
      Map<String, Map<String, Object>> respFatE = new HashMap<String, Map<String, Object>>();
      respFatE.put("graficoFatE", getriassuntoFAT(evo.getE()));
      Map<String, Map<String, Object>> respFatF = new HashMap<String, Map<String, Object>>();
      respFatF.put("graficoFatF", getriassuntoFAT(evo.getF()));
      Map<String, Map<String, Object>> respFatG = new HashMap<String, Map<String, Object>>();
      respFatG.put("graficoFatG", getriassuntoFAT(evo.getG()));
      response.put("ESL", respESL);
      response.put("FatA", respFatA);
      response.put("FatB", respFatB);
      response.put("FatC", respFatC);
      response.put("FatD", respFatD);
      response.put("FatE", respFatE);
      response.put("FatF", respFatF);
      response.put("FatG", respFatG);
      TimeZone tz2 = TimeZone.getTimeZone("EST");
      Date now2 = new Date();
      DateFormat df2 = new SimpleDateFormat("yyyy.mm.dd hh:mm:ss ");
      df2.setTimeZone(tz2);
      String currentTime2 = df2.format(now2);
      String filename = null;
      if (Boolean.valueOf(jsonObject.get("excel").toString())){
        filename = CreateExcelFile.excelExp(evo, request);
        Map<String, String> respFile = new HashMap<String, String>();
        respFile.put("filename", filename);
        response.put("response", respFile);
      }
      Utility.print(String.valueOf(currentTime2) + " :fine");
    }catch (JSONException err){
      System.out.println(err.toString());
    }
    return response;
  }

  private Map<String, Object> getriassuntoESL(EvolutaESL riassuntoESL) {
    String media = String.valueOf(Math.round(riassuntoESL.getMean() * 100.0D) / 100.0D);
    String minimo = String.valueOf(Math.round(riassuntoESL.getMin() * 100.0D) / 100.0D);
    String massimo = String.valueOf(Math.round(riassuntoESL.getMax() * 100.0D) / 100.0D);
    String devstd = String.valueOf(Math.round(riassuntoESL.getStandardDeviation() * 100.0D) / 100.0D);
    double[] initialDoubleArray = riassuntoESL.getValues();
    DescriptiveStatistics test = new DescriptiveStatistics(initialDoubleArray);
    String per10 = String.valueOf(Math.round(test.getPercentile(10.0D) * 100.0D) / 100.0D);
    String per90 = String.valueOf(Math.round(test.getPercentile(90.0D) * 100.0D) / 100.0D);
    Map<String, Object> resp = new HashMap<String, Object>();
    resp.put("minimo", minimo);
    resp.put("perc10", per10);
    resp.put("media", media);
    resp.put("perc90", per90);
    resp.put("massimo", massimo);
    resp.put("devstd", devstd);
    resp.put("values", riassuntoESL.getValues());
    return resp;
  }

  private Map<String, Object> getriassuntoFAT(Factor riassuntoFAT) {
    String media = String.valueOf(Math.round(riassuntoFAT.getMean()[0] * 100.0D) / 100.0D);
    String minimo = String.valueOf(Math.round(riassuntoFAT.getMin()[0] * 100.0D) / 100.0D);
    String massimo = String.valueOf(Math.round(riassuntoFAT.getMax()[0] * 100.0D) / 100.0D);
    String devstd = String.valueOf(Math.round(riassuntoFAT.getStandardDeviation()[0] * 100.0D) / 100.0D);
    double[] initialDoubleArray = riassuntoFAT.getValues()[0];
    DescriptiveStatistics test = new DescriptiveStatistics(initialDoubleArray);
    String per10 = String.valueOf(Math.round(test.getPercentile(10.0D) * 100.0D) / 100.0D);
    String per90 = String.valueOf(Math.round(test.getPercentile(90.0D) * 100.0D) / 100.0D);
    Map<String, Object> resp = new HashMap<String, Object>();
    resp.put("minimo", minimo);
    resp.put("perc10", per10);
    resp.put("media", media);
    resp.put("perc90", per90);
    resp.put("massimo", massimo);
    resp.put("devstd", devstd);
    resp.put("values", riassuntoFAT.getValues());
    return resp;
  }

  private String getESLtable(double[] ds) {
    String table = "";
    table = "<div style=\"height:150px;overflow-y: scroll; border:1px solid none;\">";
    table = String.valueOf(table) + "<table>";
    table = String.valueOf(table) + "<tr><td>DATI [1]";
    table = String.valueOf(table) + "</td></tr>";
    for (int i = 0; i < ds.length; i++) {
      double valore = ds[i];
      table = String.valueOf(table) + "<tr><td>" + String.valueOf(valore).replace('.', ',');
      table = String.valueOf(table) + "</td></tr>";
    }
    table = String.valueOf(table) + "</table></div>";
    return table;
  }
}