package it.ropelato.durability.stime;

import it.ropelato.durability.stime.EvolutaESL;
import it.ropelato.durability.stime.Factor;

public class Evoluta {
  public Factor A;
  
  public Factor B;
  
  public Factor C;
  
  public Factor D;
  
  public Factor E;
  
  public Factor F;
  
  public Factor G;
  
  public Double RSL;
  
  public static int N;
  
  public static int M;
  
  public void setN(Integer N) {
    it.ropelato.durability.stime.Evoluta.N = N.intValue();
  }
  
  public void setM(Integer M) {
    it.ropelato.durability.stime.Evoluta.M = M.intValue();
  }
  
  public void setA(int Type, Double arg1, Double arg2, Double arg3) {
    Factor FA = new Factor();
    FA.setFactor(Type, arg1, arg2, arg3);
    this.A = FA;
  }
  
  public void setB(int Type, Double arg1, Double arg2, Double arg3) {
    Factor FB = new Factor();
    FB.setFactor(Type, arg1, arg2, arg3);
    this.B = FB;
  }
  
  public void setC(int Type, Double arg1, Double arg2, Double arg3) {
    Factor FC = new Factor();
    FC.setFactor(Type, arg1, arg2, arg3);
    this.C = FC;
  }
  
  public void setD(int Type, Double arg1, Double arg2, Double arg3) {
    Factor FD = new Factor();
    FD.setFactor(Type, arg1, arg2, arg3);
    this.D = FD;
  }
  
  public void setE(int Type, Double arg1, Double arg2, Double arg3) {
    Factor FE = new Factor();
    FE.setFactor(Type, arg1, arg2, arg3);
    this.E = FE;
  }
  
  public void setF(int Type, Double arg1, Double arg2, Double arg3) {
    Factor FF = new Factor();
    FF.setFactor(Type, arg1, arg2, arg3);
    this.F = FF;
  }
  
  public void setG(int Type, Double arg1, Double arg2, Double arg3) {
    Factor FG = new Factor();
    FG.setFactor(Type, arg1, arg2, arg3);
    this.G = FG;
  }
  
  public void setRSL(Double RSL) {
    this.RSL = RSL;
  }
  
  public Factor getA() {
    return this.A;
  }
  
  public Factor getB() {
    return this.B;
  }
  
  public Factor getC() {
    return this.C;
  }
  
  public Factor getD() {
    return this.D;
  }
  
  public Factor getE() {
    return this.E;
  }
  
  public Factor getF() {
    return this.F;
  }
  
  public Factor getG() {
    return this.G;
  }
  
  public Double getRSL() {
    return this.RSL;
  }
  
  public EvolutaESL[] getESL() {
    int M = it.ropelato.durability.stime.Evoluta.M;
    EvolutaESL[] OUTESL = new EvolutaESL[M];
    double[][] facA = this.A.getValues();
    double[][] facB = this.B.getValues();
    double[][] facC = this.C.getValues();
    double[][] facD = this.D.getValues();
    double[][] facE = this.E.getValues();
    double[][] facF = this.F.getValues();
    double[][] facG = this.G.getValues();
    for (int im = 0; im < M; im++) {
      EvolutaESL ESL = new EvolutaESL();
      ESL.getESL(facA[im], facB[im], facC[im], facD[im], facE[im], facF[im], facG[im], this.RSL.doubleValue(), this.N);
      OUTESL[im] = ESL;
    } 
    return OUTESL;
  }
}