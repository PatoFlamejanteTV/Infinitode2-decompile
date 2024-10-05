package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.Set;
import java.util.function.Function;

public interface LinkResolverFactory extends Dependent, Function<LinkResolverBasicContext, LinkResolver> {
  Set<Class<?>> getAfterDependents();
  
  Set<Class<?>> getBeforeDependents();
  
  boolean affectsGlobalScope();
  
  LinkResolver apply(LinkResolverBasicContext paramLinkResolverBasicContext);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\LinkResolverFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */