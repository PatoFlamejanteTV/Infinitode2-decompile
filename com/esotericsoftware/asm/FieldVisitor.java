package com.esotericsoftware.asm;

public abstract class FieldVisitor {
  protected final int api;
  
  protected FieldVisitor fv;
  
  public FieldVisitor(int paramInt) {
    this(paramInt, null);
  }
  
  public FieldVisitor(int paramInt, FieldVisitor paramFieldVisitor) {
    if (paramInt != 262144 && paramInt != 327680)
      throw new IllegalArgumentException(); 
    this.api = paramInt;
    this.fv = paramFieldVisitor;
  }
  
  public AnnotationVisitor visitAnnotation(String paramString, boolean paramBoolean) {
    return (this.fv != null) ? this.fv.visitAnnotation(paramString, paramBoolean) : null;
  }
  
  public AnnotationVisitor visitTypeAnnotation(int paramInt, TypePath paramTypePath, String paramString, boolean paramBoolean) {
    if (this.api < 327680)
      throw new RuntimeException(); 
    return (this.fv != null) ? this.fv.visitTypeAnnotation(paramInt, paramTypePath, paramString, paramBoolean) : null;
  }
  
  public void visitAttribute(Attribute paramAttribute) {
    if (this.fv != null)
      this.fv.visitAttribute(paramAttribute); 
  }
  
  public void visitEnd() {
    if (this.fv != null)
      this.fv.visitEnd(); 
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\FieldVisitor.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */