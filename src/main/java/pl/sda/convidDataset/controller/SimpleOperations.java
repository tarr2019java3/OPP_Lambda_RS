package pl.sda.convidDataset.controller;

import java.util.Arrays;

public class SimpleOperations {

    private int [] numbers={2,1,44,56,26,27,43,2,7,-98,432};
  public int getMaxValue(){

      return Arrays.stream(numbers).max().getAsInt();

  }
  public int getMinValue(){
      return Arrays.stream(numbers).min().getAsInt();
  }

  public double getAvg(){
      return Arrays.stream(numbers).average().getAsDouble();
  }

  public void  getAllElementsGreaterthenAvg(){
      Arrays.stream(numbers).filter(number -> number>getAvg()).forEach(System.out::println);
  }


  public static void main(String[] args){
      SimpleOperations so =new SimpleOperations();
      System.out.println("MAX= "+so.getMaxValue());
      System.out.println("MIN= "+so.getMinValue());
      System.out.println("AVG= "+so.getAvg());
      so.getAllElementsGreaterthenAvg();


  }

}
