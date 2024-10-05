package com.vladsch.flexmark.util.html;

import com.vladsch.flexmark.util.misc.Mutable;

public interface MutableAttribute extends Attribute, Mutable<MutableAttribute, Attribute> {
  MutableAttribute copy();
  
  boolean containsValue(CharSequence paramCharSequence);
  
  MutableAttribute replaceValue(CharSequence paramCharSequence);
  
  MutableAttribute setValue(CharSequence paramCharSequence);
  
  MutableAttribute removeValue(CharSequence paramCharSequence);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\html\MutableAttribute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */