package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.renderer.LinkResolverContext;
import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.Set;
import java.util.function.Function;

public interface AttributeProviderFactory extends Dependent, Function<LinkResolverContext, AttributeProvider> {
  Set<Class<?>> getAfterDependents();
  
  Set<Class<?>> getBeforeDependents();
  
  boolean affectsGlobalScope();
  
  AttributeProvider apply(LinkResolverContext paramLinkResolverContext);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\AttributeProviderFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */