package com.dalhousie.group14.BusinessLogic.utilities;

//AS THE TAX RULES ARE BOUND TO CHANGE IN SOME YEARS WE MADE A INTERFACE SO THAT 'D' OF SOLID IS NOT VIOLATED
public interface Taxes {

  public double computeTaxes(double ctc, double epf, double basic_salary);
}
