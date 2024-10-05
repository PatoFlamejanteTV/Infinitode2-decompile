package com.vladsch.flexmark.ext.yaml.front.matter;

public interface YamlFrontMatterVisitor {
  void visit(YamlFrontMatterNode paramYamlFrontMatterNode);
  
  void visit(YamlFrontMatterBlock paramYamlFrontMatterBlock);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\yaml\front\matter\YamlFrontMatterVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */