package calculator;

import org.eclipse.xtext.xbase.lib.IntegerExtensions;

@SuppressWarnings("all")
public class Calculator {
  public int add(final int a, final int b) {
    int _plus = IntegerExtensions.operator_plus(a, b);
    return _plus;
  }
  
  public int divide(final int a, final int b) {
    int _divide = IntegerExtensions.operator_divide(a, b);
    return _divide;
  }
  
  public int substract(final int a, final int b) {
    int _minus = IntegerExtensions.operator_minus(a, b);
    return _minus;
  }
  
  public String toString() {
    return "Calculator";
  }
}