package com.esotericsoftware.asm;

class Handler {
  Label a;
  
  Label b;
  
  Label c;
  
  String d;
  
  int e;
  
  Handler f;
  
  static Handler a(Handler paramHandler, Label paramLabel1, Label paramLabel2) {
    if (paramHandler == null)
      return null; 
    paramHandler.f = a(paramHandler.f, paramLabel1, paramLabel2);
    int i = paramHandler.a.c;
    int j = paramHandler.b.c;
    int k = paramLabel1.c;
    int m = (paramLabel2 == null) ? Integer.MAX_VALUE : paramLabel2.c;
    if (k < j && m > i)
      if (k <= i) {
        if (m >= j) {
          paramHandler = paramHandler.f;
        } else {
          paramHandler.a = paramLabel2;
        } 
      } else if (m >= j) {
        paramHandler.b = paramLabel1;
      } else {
        Handler handler;
        (handler = new Handler()).a = paramLabel2;
        handler.b = paramHandler.b;
        handler.c = paramHandler.c;
        handler.d = paramHandler.d;
        handler.e = paramHandler.e;
        handler.f = paramHandler.f;
        paramHandler.b = paramLabel1;
        paramHandler.f = handler;
      }  
    return paramHandler;
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\asm\Handler.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */