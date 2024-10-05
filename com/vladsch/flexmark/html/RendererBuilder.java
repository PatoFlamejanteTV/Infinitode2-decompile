package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.renderer.HeaderIdGeneratorFactory;
import com.vladsch.flexmark.util.data.DataHolder;

public interface RendererBuilder extends DataHolder {
  RendererBuilder attributeProviderFactory(AttributeProviderFactory paramAttributeProviderFactory);
  
  RendererBuilder linkResolverFactory(LinkResolverFactory paramLinkResolverFactory);
  
  RendererBuilder contentResolverFactory(UriContentResolverFactory paramUriContentResolverFactory);
  
  RendererBuilder htmlIdGeneratorFactory(HeaderIdGeneratorFactory paramHeaderIdGeneratorFactory);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\RendererBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */