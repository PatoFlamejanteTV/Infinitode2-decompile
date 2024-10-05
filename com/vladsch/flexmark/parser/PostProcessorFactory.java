package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public interface PostProcessorFactory extends Dependent, Function<Document, PostProcessor> {
  Map<Class<?>, Set<Class<?>>> getNodeTypes();
  
  PostProcessor apply(Document paramDocument);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\PostProcessorFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */