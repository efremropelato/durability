package it.ropelato.durability.stime;

import it.ropelato.durability.stime.Evoluta;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class EvolutaESL {
  public double Mean;
  
  public double Max;
  
  public double Min;
  
  public double Median;
  
  public double Variance;
  
  public double StandardDeviation;
  
  public double Skewness;
  
  public double[] Values;
  
  public void getESL(double[] facA, double[] facB, double[] facC, double[] facD, double[] facE, double[] facF, double[] facG, double RSL, int N) {
    double[] values = new double[N];
    for (int in = 0; in < N; in++)
      values[in] = RSL * facA[in] * facB[in] * facC[in] * facD[in] * facE[in] * facF[in] * facG[in]; 
    this.Values = values;
    double[] initialDoubleArray = values;
    DescriptiveStatistics dsesl = new DescriptiveStatistics(initialDoubleArray);
    this.Mean = dsesl.getMean();
    this.Max = dsesl.getMax();
    this.Min = dsesl.getMin();
    this.Median = dsesl.getPercentile(50.0D);
    this.Variance = dsesl.getVariance();
    this.StandardDeviation = dsesl.getStandardDeviation();
    this.Skewness = dsesl.getSkewness();
  }
  
  public double[] getValues() {
    return this.Values;
  }
  
  public String getStringValues() {
    String stringvalues = "[";
    for (int i = 0; i < this.Values.length; i++)
      stringvalues = String.valueOf(stringvalues) + this.Values[i] + ","; 
    stringvalues = stringvalues.substring(0, stringvalues.length() - 1);
    stringvalues = String.valueOf(stringvalues) + "]";
    return stringvalues;
  }
  
  public double getMean() {
    return this.Mean;
  }
  
  public double getMax() {
    return this.Max;
  }
  
  public double getMin() {
    return this.Min;
  }
  
  public double getMedian() {
    return this.Median;
  }
  
  public double getVariance() {
    return this.Variance;
  }
  
  public double getStandardDeviation() {
    return this.StandardDeviation;
  }
  
  public double getSkewness() {
    return this.Skewness;
  }
}