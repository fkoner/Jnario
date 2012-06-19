package org.jnario.spec.tests.unit.naming;

import java.util.ArrayList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.jnario.jnario.test.util.Query;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.jnario.runner.Subject;
import org.jnario.spec.naming.ExampleNameProvider;
import org.jnario.spec.spec.ExampleGroup;
import org.jnario.spec.tests.unit.naming.ExampleNameProviderSpec;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("toJavaClassName[ExampleGroup]")
public class ExampleNameProviderToJavaClassNameExampleGroupSpec extends ExampleNameProviderSpec {
  @Subject
  public ExampleNameProvider subject;
  
  @Test
  @Named("should remove all white spaces from ExampleGroup\\\'s description")
  @Order(99)
  public void shouldRemoveAllWhiteSpacesFromExampleGroupSDescription() throws Exception {
    String _firstJavaClassName = this.firstJavaClassName("describe \'My Example\'");
    boolean _should_contain = Should.should_contain(_firstJavaClassName, " ");
    Assert.assertFalse("\nExpected firstJavaClassName(\"describe \'My Example\'\") should not contain \" \" but"
     + "\n     firstJavaClassName(\"describe \'My Example\'\") is " + "\"" + _firstJavaClassName + "\"" + "\n", _should_contain);
    
  }
  
  @Test
  @Named("should append \\\'Spec\\\' to class name")
  @Order(99)
  public void shouldAppendSpecToClassName() throws Exception {
    String _firstJavaClassName = this.firstJavaClassName("describe \'My Example\'");
    Matcher<String> _endsWith = Matchers.endsWith("Spec");
    boolean _doubleArrow = Should.operator_doubleArrow(_firstJavaClassName, _endsWith);
    Assert.assertTrue("\nExpected firstJavaClassName(\"describe \'My Example\'\") => endsWith(\'Spec\') but"
     + "\n     firstJavaClassName(\"describe \'My Example\'\") is " + "\"" + _firstJavaClassName + "\""
     + "\n     endsWith(\'Spec\') is " + _endsWith + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("should prepend target type name")
  @Order(99)
  public void shouldPrependTargetTypeName() throws Exception {
    String _firstJavaClassName = this.firstJavaClassName("describe org.junit.Assert \'My Example\'");
    Matcher<String> _startsWith = Matchers.startsWith("Assert");
    boolean _doubleArrow = Should.operator_doubleArrow(_firstJavaClassName, _startsWith);
    Assert.assertTrue("\nExpected firstJavaClassName(\"describe org.junit.Assert \'My Example\'\") => startsWith(\"Assert\") but"
     + "\n     firstJavaClassName(\"describe org.junit.Assert \'My Example\'\") is " + "\"" + _firstJavaClassName + "\""
     + "\n     startsWith(\"Assert\") is " + _startsWith + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("should convert description to camel case")
  @Order(99)
  public void shouldConvertDescriptionToCamelCase() throws Exception {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(
      "describe \'my example\'", 
      "describe \'my\nexample\'", 
      "describe \'my\texample\'", 
      "describe \'my_example\'");
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          String _firstJavaClassName = ExampleNameProviderToJavaClassNameExampleGroupSpec.this.firstJavaClassName(it);
          boolean _doubleArrow = Should.operator_doubleArrow(_firstJavaClassName, "MyExampleSpec");
          Assert.assertTrue("\nExpected firstJavaClassName(it) => \'MyExampleSpec\' but"
           + "\n     firstJavaClassName(it) is " + "\"" + _firstJavaClassName + "\""
           + "\n     it is " + "\"" + it + "\"" + "\n", _doubleArrow);
          
        }
      };
    IterableExtensions.<String>forEach(_newArrayList, _function);
  }
  
  @Test
  @Named("should append the target operation\\\'s name and params")
  @Order(99)
  public void shouldAppendTheTargetOperationSNameAndParams() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("describe org.junit.Assert{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("context assertTrue(boolean) ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String _secondJavaClassName = this.secondJavaClassName(_builder);
    Matcher<String> _endsWith = Matchers.endsWith("AssertTrueBooleanSpec");
    boolean _doubleArrow = Should.operator_doubleArrow(_secondJavaClassName, _endsWith);
    Assert.assertTrue("\nExpected secondJavaClassName(\r\n        \'\'\'\r\n        describe org.junit.Assert{\r\n              context assertTrue(boolean) \r\n        }\r\n        \'\'\') => endsWith(\'AssertTrueBooleanSpec\') but"
     + "\n     secondJavaClassName(\r\n        \'\'\'\r\n        describe org.junit.Assert{\r\n              context assertTrue(boolean) \r\n        }\r\n        \'\'\') is " + "\"" + _secondJavaClassName + "\""
     + "\n     \'\'\'\r\n        describe org.junit.Assert{\r\n              context assertTrue(boolean) \r\n        }\r\n        \'\'\' is " + _builder
     + "\n     endsWith(\'AssertTrueBooleanSpec\') is " + _endsWith + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("should append the description")
  @Order(99)
  public void shouldAppendTheDescription() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("describe org.junit.Assert{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("context \'assertTrue\' ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String _secondJavaClassName = this.secondJavaClassName(_builder);
    Matcher<String> _endsWith = Matchers.endsWith("AssertTrueSpec");
    boolean _doubleArrow = Should.operator_doubleArrow(_secondJavaClassName, _endsWith);
    Assert.assertTrue("\nExpected secondJavaClassName(\r\n      \t\r\n      \'\'\'\r\n        describe org.junit.Assert{\r\n          context \'assertTrue\' \r\n        }\r\n      \'\'\') => endsWith(\'AssertTrueSpec\') but"
     + "\n     secondJavaClassName(\r\n      \t\r\n      \'\'\'\r\n        describe org.junit.Assert{\r\n          context \'assertTrue\' \r\n        }\r\n      \'\'\') is " + "\"" + _secondJavaClassName + "\""
     + "\n     \'\'\'\r\n        describe org.junit.Assert{\r\n          context \'assertTrue\' \r\n        }\r\n      \'\'\' is " + _builder
     + "\n     endsWith(\'AssertTrueSpec\') is " + _endsWith + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("should prepend the parent ExampleGroup\\\'s name")
  @Order(99)
  public void shouldPrependTheParentExampleGroupSName() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("describe org.junit.Assert{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("context assertTrue(boolean) ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String _secondJavaClassName = this.secondJavaClassName(_builder);
    boolean _doubleArrow = Should.operator_doubleArrow(_secondJavaClassName, "AssertAssertTrueBooleanSpec");
    Assert.assertTrue("\nExpected secondJavaClassName(\r\n      \'\'\'\r\n      describe org.junit.Assert{\r\n        context assertTrue(boolean) \r\n      }\r\n      \'\'\') => \'AssertAssertTrueBooleanSpec\' but"
     + "\n     secondJavaClassName(\r\n      \'\'\'\r\n      describe org.junit.Assert{\r\n        context assertTrue(boolean) \r\n      }\r\n      \'\'\') is " + "\"" + _secondJavaClassName + "\""
     + "\n     \'\'\'\r\n      describe org.junit.Assert{\r\n        context assertTrue(boolean) \r\n      }\r\n      \'\'\' is " + _builder + "\n", _doubleArrow);
    
  }
  
  public String firstJavaClassName(final CharSequence content) {
    String _plus = (content + "{}");
    Query _parse = this.parse(_plus);
    ExampleGroup _first = _parse.<ExampleGroup>first(ExampleGroup.class);
    String _javaClassName = this.subject.toJavaClassName(_first);
    return _javaClassName;
  }
  
  public String secondJavaClassName(final CharSequence content) {
    String _plus = (content + "{}");
    Query _parse = this.parse(_plus);
    ExampleGroup _second = _parse.<ExampleGroup>second(ExampleGroup.class);
    String _javaClassName = this.subject.toJavaClassName(_second);
    return _javaClassName;
  }
}
