package com.vladsch.flexmark.ext.enumerated.reference;

public interface EnumeratedOrdinalRenderer {
  void startRendering(EnumeratedReferenceRendering[] paramArrayOfEnumeratedReferenceRendering);
  
  void setEnumOrdinalRunnable(Runnable paramRunnable);
  
  Runnable getEnumOrdinalRunnable();
  
  void render(int paramInt, EnumeratedReferenceBlock paramEnumeratedReferenceBlock, String paramString, boolean paramBoolean);
  
  void endRendering();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\EnumeratedOrdinalRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */