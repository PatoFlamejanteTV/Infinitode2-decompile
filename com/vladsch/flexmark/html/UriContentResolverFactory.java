package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.Set;
import java.util.function.Function;

public interface UriContentResolverFactory extends Dependent, Function<LinkResolverBasicContext, UriContentResolver> {
  Set<Class<?>> getAfterDependents();
  
  Set<Class<?>> getBeforeDependents();
  
  boolean affectsGlobalScope();
  
  UriContentResolver apply(LinkResolverBasicContext paramLinkResolverBasicContext);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\UriContentResolverFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */