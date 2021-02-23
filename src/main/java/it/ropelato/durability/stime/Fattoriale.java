package it.ropelato.durability.stime;
import java.util.HashMap;
public class Fattoriale {
 public Double A = Double.valueOf(1.0D);
 
 public Double B = Double.valueOf(1.0D);
 
 public Double C = Double.valueOf(1.0D);
 
 public Double D = Double.valueOf(1.0D);
 
 public Double E = Double.valueOf(1.0D);
 
 public Double F = Double.valueOf(1.0D);
 
 public Double G = Double.valueOf(1.0D);
 
 public Double RSL;
 
 public void setA(Double A) {
   this.A = A;
 }
 
 public void setB(Double B) {
   this.B = B;
 }
 
 public void setC(Double C) {
   this.C = C;
 }
 
 public void setD(Double D) {
   this.D = D;
 }
 
 public void setE(Double E) {
   this.E = E;
 }
 
 public void setF(Double F) {
   this.F = F;
 }
 
 public void setG(Double G) {
   this.G = G;
 }
 
 public void setRSL(Double RSL) {
   this.RSL = RSL;
 }
 
 public void setFactors(Double A, Double B, Double C, Double D, Double E, Double F, Double G) {
   this.A = A;
   this.B = B;
   this.C = C;
   this.D = D;
   this.E = E;
   this.F = F;
   this.G = G;
 }
 
 public Double getA() {
   return this.A;
 }
 
 public Double getB() {
   return this.B;
 }
 
 public Double getC() {
   return this.C;
 }
 
 public Double getD() {
   return this.D;
 }
 
 public Double getE() {
   return this.E;
 }
 
 public Double getF() {
   return this.F;
 }
 
 public Double getG() {
   return this.G;
 }
 
 public Double getRSL() {
   return this.RSL;
 }
 
 public HashMap<String, Double> getFactors() {
   HashMap<String, Double> factors = new HashMap<String, Double>();
   factors.put("A", this.A);
   factors.put("B", this.B);
   factors.put("C", this.C);
   factors.put("D", this.D);
   factors.put("E", this.E);
   factors.put("F", this.F);
   factors.put("G", this.G);
   return factors;
 }
 
 public Double getESL() {
   Double ESL = Double.valueOf(this.RSL.doubleValue() * this.A.doubleValue() * this.B.doubleValue() * this.C.doubleValue() * this.D.doubleValue() * this.E.doubleValue() * this.F.doubleValue() * this.G.doubleValue());
   return ESL;
 }
}