package com.vladsch.flexmark.ext.gitlab;

public interface GitLabVisitor {
  void visit(GitLabIns paramGitLabIns);
  
  void visit(GitLabDel paramGitLabDel);
  
  void visit(GitLabInlineMath paramGitLabInlineMath);
  
  void visit(GitLabBlockQuote paramGitLabBlockQuote);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gitlab\GitLabVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */