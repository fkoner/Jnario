/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario.suite.conversion;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.xbase.conversion.XbaseValueConverterService;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.jnario.suite.conversion.LinkValueConverter;
import org.jnario.suite.conversion.PatternValueConverter;

@SuppressWarnings("all")
public class SuiteValueConverterService extends XbaseValueConverterService {
  private final LinkValueConverter textValueConverter = new Function0<LinkValueConverter>() {
    public LinkValueConverter apply() {
      LinkValueConverter _linkValueConverter = new LinkValueConverter(":", "");
      return _linkValueConverter;
    }
  }.apply();
  
  private final PatternValueConverter patternValueConverter = new Function0<PatternValueConverter>() {
    public PatternValueConverter apply() {
      PatternValueConverter _patternValueConverter = new PatternValueConverter();
      return _patternValueConverter;
    }
  }.apply();
  
  @ValueConverter(rule = "TEXT")
  public IValueConverter<String> getTextValueConverter() {
    return this.textValueConverter;
  }
  
  @ValueConverter(rule = "PATTERN")
  public IValueConverter<String> getPatternValueConverter() {
    return this.patternValueConverter;
  }
}