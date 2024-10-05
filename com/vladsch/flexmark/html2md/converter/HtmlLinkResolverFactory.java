package com.vladsch.flexmark.html2md.converter;

import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.Set;
import java.util.function.Function;

public interface HtmlLinkResolverFactory extends Dependent, Function<HtmlNodeConverterContext, HtmlLinkResolver> {
  Set<Class<?>> getAfterDependents();
  
  Set<Class<?>> getBeforeDependents();
  
  boolean affectsGlobalScope();
  
  HtmlLinkResolver apply(HtmlNodeConverterContext paramHtmlNodeConverterContext);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\HtmlLinkResolverFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */