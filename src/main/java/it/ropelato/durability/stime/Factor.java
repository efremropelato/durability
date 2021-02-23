package it.ropelato.durability.stime;

import it.ropelato.durability.stime.Evoluta;

import org.apache.commons.math3.distribution.TriangularDistribution;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Factor {
  public double[] Mean;
  
  public double[] Max;
  
  public double[] Min;
  
  public double[] Median;
  
  public double[] Variance;
  
  public double[] StandardDeviation;
  
  public double[] Skewness;
  
  public int Type;
  
  public String TypeName;
  
  public double[][] Values;
  
  public void setFactor(int Type, Double arg1, Double arg2, Double arg3) {
    this.Type = Type;
    this.Values = setValues(arg1, arg2, arg3);
  }
  
  public double[][] setValues(Double arg1, Double arg2, Double arg3) {
    RandomDataGenerator rdb;
    int im;
    RandomDataGenerator rdca;
    int i;
    RandomDataGenerator rdch;
    int j;
    RandomDataGenerator rde;
    int k;
    RandomDataGenerator rdf;
    int m;
    RandomDataGenerator rdgm;
    int n;
    RandomDataGenerator rdga;
    int i1;
    RandomDataGenerator rdpo;
    int i2;
    RandomDataGenerator rdt;
    int i3;
    RandomDataGenerator rdun;
    int i4;
    RandomDataGenerator rdwb;
    int i5;
    RandomDataGenerator rdtr;
    int i6;
    int Type = this.Type;
    int N = Evoluta.N;
    int M = Evoluta.M;
    double[][] values = new double[M][N];
    this.Mean = new double[M];
    this.Max = new double[M];
    this.Min = new double[M];
    this.Median = new double[M];
    this.Variance = new double[M];
    this.StandardDeviation = new double[M];
    this.Skewness = new double[M];
    switch (Type) {
      case 1:
        this.TypeName = "Beta Distribution";
        rdb = new RandomDataGenerator();
        for (im = 0; im < M; im++) {
          for (int in = 0; in < N; in++)
            values[im][in] = rdb.nextBeta(arg1.doubleValue(), arg2.doubleValue()); 
          double[] initialDoubleArray = values[im];
          DescriptiveStatistics dsbet = new DescriptiveStatistics(initialDoubleArray);
          this.Mean[im] = dsbet.getMean();
          this.Max[im] = dsbet.getMax();
          this.Min[im] = dsbet.getMin();
          this.Median[im] = dsbet.getPercentile(50.0D);
          this.Variance[im] = dsbet.getVariance();
          this.StandardDeviation[im] = dsbet.getStandardDeviation();
          this.Skewness[im] = dsbet.getSkewness();
        } 
        break;
      case 2:
        this.TypeName = "Cauchy Distribution";
        rdca = new RandomDataGenerator();
        for (i = 0; i < M; i++) {
          for (int in = 0; in < N; in++)
            values[i][in] = rdca.nextCauchy(arg1.doubleValue(), arg2.doubleValue()); 
          double[] initialDoubleArray = values[i];
          DescriptiveStatistics dscau = new DescriptiveStatistics(initialDoubleArray);
          this.Mean[i] = dscau.getMean();
          this.Max[i] = dscau.getMax();
          this.Min[i] = dscau.getMin();
          this.Median[i] = dscau.getPercentile(50.0D);
          this.Variance[i] = dscau.getVariance();
          this.StandardDeviation[i] = dscau.getStandardDeviation();
          this.Skewness[i] = dscau.getSkewness();
        } 
        break;
      case 3:
        this.TypeName = "ChiSquare Distribution";
        rdch = new RandomDataGenerator();
        for (j = 0; j < M; j++) {
          for (int in = 0; in < N; in++)
            values[j][in] = rdch.nextChiSquare(arg1.doubleValue()); 
          double[] initialDoubleArray = values[j];
          DescriptiveStatistics dschi = new DescriptiveStatistics(initialDoubleArray);
          this.Mean[j] = dschi.getMean();
          this.Max[j] = dschi.getMax();
          this.Min[j] = dschi.getMin();
          this.Median[j] = dschi.getPercentile(50.0D);
          this.Variance[j] = dschi.getVariance();
          this.StandardDeviation[j] = dschi.getStandardDeviation();
          this.Skewness[j] = dschi.getSkewness();
        } 
        break;
      case 4:
        this.TypeName = "Exponential Distribution";
        rde = new RandomDataGenerator();
        for (k = 0; k < M; k++) {
          for (int in = 0; in < N; in++)
            values[k][in] = rde.nextExponential(arg1.doubleValue()); 
          double[] initialDoubleArray = values[k];
          DescriptiveStatistics dsexp = new DescriptiveStatistics(initialDoubleArray);
          this.Mean[k] = dsexp.getMean();
          this.Max[k] = dsexp.getMax();
          this.Min[k] = dsexp.getMin();
          this.Median[k] = dsexp.getPercentile(50.0D);
          this.Variance[k] = dsexp.getVariance();
          this.StandardDeviation[k] = dsexp.getStandardDeviation();
          this.Skewness[k] = dsexp.getSkewness();
        } 
        break;
      case 5:
        this.TypeName = "F Distribution";
        rdf = new RandomDataGenerator();
        for (m = 0; m < M; m++) {
          for (int in = 0; in < N; in++)
            values[m][in] = rdf.nextF(arg1.doubleValue(), arg2.doubleValue()); 
          double[] initialDoubleArray = values[m];
          DescriptiveStatistics dsf = new DescriptiveStatistics(initialDoubleArray);
          this.Mean[m] = dsf.getMean();
          this.Max[m] = dsf.getMax();
          this.Min[m] = dsf.getMin();
          this.Median[m] = dsf.getPercentile(50.0D);
          this.Variance[m] = dsf.getVariance();
          this.StandardDeviation[m] = dsf.getStandardDeviation();
          this.Skewness[m] = dsf.getSkewness();
        } 
        break;
      case 6:
        this.TypeName = "Gamma Distribution";
        rdgm = new RandomDataGenerator();
        for (n = 0; n < M; n++) {
          for (int in = 0; in < N; in++)
            values[n][in] = rdgm.nextGamma(arg1.doubleValue(), arg2.doubleValue()); 
          double[] initialDoubleArray = values[n];
          DescriptiveStatistics dsgam = new DescriptiveStatistics(initialDoubleArray);
          this.Mean[n] = dsgam.getMean();
          this.Max[n] = dsgam.getMax();
          this.Min[n] = dsgam.getMin();
          this.Median[n] = dsgam.getPercentile(50.0D);
          this.Variance[n] = dsgam.getVariance();
          this.StandardDeviation[n] = dsgam.getStandardDeviation();
          this.Skewness[n] = dsgam.getSkewness();
        } 
        break;
      case 7:
        this.TypeName = "Normal Distribution";
        rdga = new RandomDataGenerator();
        for (i1 = 0; i1 < M; i1++) {
          for (int in = 0; in < N; in++)
            values[i1][in] = rdga.nextGaussian(arg1.doubleValue(), arg2.doubleValue()); 
          double[] initialDoubleArray = values[i1];
          DescriptiveStatistics dsnor = new DescriptiveStatistics(initialDoubleArray);
          this.Mean[i1] = dsnor.getMean();
          this.Max[i1] = dsnor.getMax();
          this.Min[i1] = dsnor.getMin();
          this.Median[i1] = dsnor.getPercentile(50.0D);
          this.Variance[i1] = dsnor.getVariance();
          this.StandardDeviation[i1] = dsnor.getStandardDeviation();
          this.Skewness[i1] = dsnor.getSkewness();
        } 
        break;
      case 8:
        this.TypeName = "Poisson Distribution";
        rdpo = new RandomDataGenerator();
        for (i2 = 0; i2 < M; i2++) {
          for (int in = 0; in < N; in++)
            values[i2][in] = rdpo.nextPoisson(arg1.doubleValue()); 
          double[] initialDoubleArray = values[i2];
          DescriptiveStatistics dspoi = new DescriptiveStatistics(initialDoubleArray);
          this.Mean[i2] = dspoi.getMean();
          this.Max[i2] = dspoi.getMax();
          this.Min[i2] = dspoi.getMin();
          this.Median[i2] = dspoi.getPercentile(50.0D);
          this.Variance[i2] = dspoi.getVariance();
          this.StandardDeviation[i2] = dspoi.getStandardDeviation();
          this.Skewness[i2] = dspoi.getSkewness();
        } 
        break;
      case 9:
        this.TypeName = "T Distribution";
        rdt = new RandomDataGenerator();
        for (i3 = 0; i3 < M; i3++) {
          for (int in = 0; in < N; in++)
            values[i3][in] = rdt.nextT(arg1.doubleValue()); 
          double[] initialDoubleArray = values[i3];
          DescriptiveStatistics dst = new DescriptiveStatistics(initialDoubleArray);
          this.Mean[i3] = dst.getMean();
          this.Max[i3] = dst.getMax();
          this.Min[i3] = dst.getMin();
          this.Median[i3] = dst.getPercentile(50.0D);
          this.Variance[i3] = dst.getVariance();
          this.StandardDeviation[i3] = dst.getStandardDeviation();
          this.Skewness[i3] = dst.getSkewness();
        } 
        break;
      case 10:
        this.TypeName = "Uniform Distribution";
        rdun = new RandomDataGenerator();
        for (i4 = 0; i4 < M; i4++) {
          for (int in = 0; in < N; in++)
            values[i4][in] = rdun.nextUniform(arg1.doubleValue(), arg2.doubleValue()); 
          double[] initialDoubleArray = values[i4];
          DescriptiveStatistics dsuni = new DescriptiveStatistics(initialDoubleArray);
          this.Mean[i4] = dsuni.getMean();
          this.Max[i4] = dsuni.getMax();
          this.Min[i4] = dsuni.getMin();
          this.Median[i4] = dsuni.getPercentile(50.0D);
          this.Variance[i4] = dsuni.getVariance();
          this.StandardDeviation[i4] = dsuni.getStandardDeviation();
          this.Skewness[i4] = dsuni.getSkewness();
        } 
        break;
      case 11:
        this.TypeName = "Weilbull Distribution";
        rdwb = new RandomDataGenerator();
        for (i5 = 0; i5 < M; i5++) {
          for (int in = 0; in < N; in++)
            values[i5][in] = rdwb.nextWeibull(arg1.doubleValue(), arg2.doubleValue()); 
          double[] initialDoubleArray = values[i5];
          DescriptiveStatistics dswb = new DescriptiveStatistics(initialDoubleArray);
          this.Mean[i5] = dswb.getMean();
          this.Max[i5] = dswb.getMax();
          this.Min[i5] = dswb.getMin();
          this.Median[i5] = dswb.getPercentile(50.0D);
          this.Variance[i5] = dswb.getVariance();
          this.StandardDeviation[i5] = dswb.getStandardDeviation();
          this.Skewness[i5] = dswb.getSkewness();
        } 
        break;
      case 12:
        this.TypeName = "Triangular Distribution";
        TriangularDistribution trd = new TriangularDistribution(arg1.doubleValue(), arg2.doubleValue(), arg3.doubleValue());
        for (i6 = 0; i6 < M; i6++) {
          for (int in1 = 0; in1 < N; in1++)
            values[i6][in1] = trd.sample();   
          double[] initialDoubleArray = values[i6];
          DescriptiveStatistics dstr = new DescriptiveStatistics(initialDoubleArray);
          this.Mean[i6] = dstr.getMean();
          this.Max[i6] = dstr.getMax();
          this.Min[i6] = dstr.getMin();
          this.Median[i6] = dstr.getPercentile(50.0D);
          this.Variance[i6] = dstr.getVariance();
          this.StandardDeviation[i6] = dstr.getStandardDeviation();
          this.Skewness[i6] = dstr.getSkewness();
        } 
        break;
    } 
    return values;
  }
  
  public double[][] getValues() {
    return this.Values;
  }
  
  public double[] getMean() {
    return this.Mean;
  }
  
  public double[] getMax() {
    return this.Max;
  }
  
  public double[] getMin() {
    return this.Min;
  }
  
  public double[] getMedian() {
    return this.Median;
  }
  
  public double[] getVariance() {
    return this.Variance;
  }
  
  public double[] getStandardDeviation() {
    return this.StandardDeviation;
  }
  
  public double[] getSkewness() {
    return this.Skewness;
  }
  
  public int getType() {
    return this.Type;
  }
  
  public String getTypeName() {
    return this.TypeName;
  }
}
