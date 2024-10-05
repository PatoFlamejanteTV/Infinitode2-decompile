/*     */ package org.a.b.b;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Stack;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class v
/*     */ {
/*  37 */   private static final a a = c.a(v.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public v(String paramString1, String paramString2) {
/*  58 */     this.b = paramString1;
/*  59 */     this.c = paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<Object> a(byte[] paramArrayOfbyte, List<byte[]> paramList) {
/*  72 */     return a(paramArrayOfbyte, paramList, new ArrayList());
/*     */   }
/*     */ 
/*     */   
/*     */   private List<Object> a(byte[] paramArrayOfbyte, List<byte[]> paramList, List<Object> paramList1) {
/*  77 */     b b = new b(paramArrayOfbyte);
/*  78 */     while (b.a()) {
/*     */       byte b1;
/*     */       
/*  81 */       if ((b1 = b.d()) == 10) {
/*     */ 
/*     */ 
/*     */         
/*  85 */         if (!(b1 = paramList1.remove(paramList1.size() - 1) instanceof Integer)) {
/*     */           
/*  87 */           (new StringBuilder("Parameter ")).append(b1).append(" for CALLSUBR is ignored, integer expected in glyph '").append(this.c).append("' of font ").append(this.b);
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/*     */         Integer integer;
/*  93 */         if ((integer = (Integer)b1).intValue() >= 0 && integer.intValue() < paramList.size()) {
/*     */           
/*  95 */           byte[] arrayOfByte = paramList.get(integer.intValue());
/*  96 */           a(arrayOfByte, paramList, paramList1);
/*     */           
/*  98 */           if (b1 = paramList1.get(paramList1.size() - 1) instanceof q && ((q)b1)
/*  99 */             .a().a()[0] == 11)
/*     */           {
/* 101 */             paramList1.remove(paramList1.size() - 1);
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/* 106 */         (new StringBuilder("CALLSUBR is ignored, operand: ")).append(integer).append(", subrs.size(): ")
/* 107 */           .append(paramList.size()).append(" in glyph '").append(this.c).append("' of font ").append(this.b);
/*     */ 
/*     */         
/* 110 */         while (paramList1.get(paramList1.size() - 1) instanceof Integer)
/*     */         {
/* 112 */           paramList1.remove(paramList1.size() - 1);
/*     */         }
/*     */         continue;
/*     */       } 
/* 116 */       if (b1 == 12 && b.b(0) == 16) {
/*     */ 
/*     */         
/* 119 */         b.c();
/*     */         
/* 121 */         Integer integer1 = (Integer)paramList1.remove(paramList1.size() - 1);
/* 122 */         Integer integer2 = (Integer)paramList1.remove(paramList1.size() - 1);
/*     */ 
/*     */         
/* 125 */         Stack<Integer> stack = new Stack();
/* 126 */         switch (integer1.intValue()) {
/*     */           
/*     */           case 0:
/* 129 */             stack.push(a(paramList1));
/* 130 */             stack.push(a(paramList1));
/* 131 */             paramList1.remove(paramList1.size() - 1);
/*     */             
/* 133 */             paramList1.add(Integer.valueOf(0));
/* 134 */             paramList1.add(new q(12, 16));
/*     */             break;
/*     */           
/*     */           case 1:
/* 138 */             paramList1.add(Integer.valueOf(1));
/* 139 */             paramList1.add(new q(12, 16));
/*     */             break;
/*     */           
/*     */           case 3:
/* 143 */             stack.push(a(paramList1));
/*     */             break;
/*     */           
/*     */           default:
/* 147 */             for (b1 = 0; b1 < integer2.intValue(); b1++)
/*     */             {
/* 149 */               stack.push(a(paramList1));
/*     */             }
/*     */             break;
/*     */         } 
/*     */ 
/*     */         
/* 155 */         while (b.b(0) == 12 && b.b(1) == 17) {
/*     */           
/* 157 */           b.c();
/* 158 */           b.c();
/* 159 */           paramList1.add(stack.pop());
/*     */         } 
/*     */         
/* 162 */         if (stack.size() > 0)
/*     */         {
/* 164 */           (new StringBuilder("Value left on the PostScript stack in glyph ")).append(this.c).append(" of font ").append(this.b); } 
/*     */         continue;
/*     */       } 
/* 167 */       if (b1 >= 0 && b1 <= 31) {
/*     */         
/* 169 */         paramList1.add(a(b, b1)); continue;
/*     */       } 
/* 171 */       if (b1 >= 32 && b1 <= 'ÿ') {
/*     */         
/* 173 */         paramList1.add(b(b, b1));
/*     */         
/*     */         continue;
/*     */       } 
/* 177 */       throw new IllegalArgumentException();
/*     */     } 
/*     */     
/* 180 */     return paramList1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Integer a(List<Object> paramList) {
/*     */     int i;
/*     */     Object object;
/* 188 */     if (object = paramList.remove(paramList.size() - 1) instanceof Integer)
/*     */     {
/* 190 */       return (Integer)object;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 195 */     if ((object = object).a().a()[0] == 12 && object.a().a()[1] == 12) {
/*     */       
/* 197 */       i = ((Integer)paramList.remove(paramList.size() - 1)).intValue();
/*     */       int j;
/* 199 */       return Integer.valueOf((j = ((Integer)paramList.remove(paramList.size() - 1)).intValue()) / i);
/*     */     } 
/* 201 */     throw new IOException("Unexpected char string command: " + i.a());
/*     */   }
/*     */ 
/*     */   
/*     */   private static q a(b paramb, int paramInt) {
/* 206 */     if (paramInt == 12) {
/*     */       
/* 208 */       int i = paramb.d();
/* 209 */       return new q(paramInt, i);
/*     */     } 
/* 211 */     return new q(paramInt);
/*     */   }
/*     */   
/*     */   private static Integer b(b paramb, int paramInt) {
/*     */     // Byte code:
/*     */     //   0: iload_1
/*     */     //   1: bipush #32
/*     */     //   3: if_icmplt -> 22
/*     */     //   6: iload_1
/*     */     //   7: sipush #246
/*     */     //   10: if_icmpgt -> 22
/*     */     //   13: iload_1
/*     */     //   14: sipush #139
/*     */     //   17: isub
/*     */     //   18: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   21: areturn
/*     */     //   22: iload_1
/*     */     //   23: sipush #247
/*     */     //   26: if_icmplt -> 58
/*     */     //   29: iload_1
/*     */     //   30: sipush #250
/*     */     //   33: if_icmpgt -> 58
/*     */     //   36: aload_0
/*     */     //   37: invokevirtual d : ()I
/*     */     //   40: istore_0
/*     */     //   41: iload_1
/*     */     //   42: sipush #247
/*     */     //   45: isub
/*     */     //   46: bipush #8
/*     */     //   48: ishl
/*     */     //   49: iload_0
/*     */     //   50: iadd
/*     */     //   51: bipush #108
/*     */     //   53: iadd
/*     */     //   54: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   57: areturn
/*     */     //   58: iload_1
/*     */     //   59: sipush #251
/*     */     //   62: if_icmplt -> 95
/*     */     //   65: iload_1
/*     */     //   66: sipush #254
/*     */     //   69: if_icmpgt -> 95
/*     */     //   72: aload_0
/*     */     //   73: invokevirtual d : ()I
/*     */     //   76: istore_0
/*     */     //   77: iload_1
/*     */     //   78: sipush #251
/*     */     //   81: isub
/*     */     //   82: ineg
/*     */     //   83: bipush #8
/*     */     //   85: ishl
/*     */     //   86: iload_0
/*     */     //   87: isub
/*     */     //   88: bipush #108
/*     */     //   90: isub
/*     */     //   91: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   94: areturn
/*     */     //   95: iload_1
/*     */     //   96: sipush #255
/*     */     //   99: if_icmpne -> 110
/*     */     //   102: aload_0
/*     */     //   103: invokevirtual g : ()I
/*     */     //   106: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   109: areturn
/*     */     //   110: new java/lang/IllegalArgumentException
/*     */     //   113: dup
/*     */     //   114: invokespecial <init> : ()V
/*     */     //   117: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #216	-> 0
/*     */     //   #218	-> 13
/*     */     //   #220	-> 22
/*     */     //   #222	-> 36
/*     */     //   #223	-> 41
/*     */     //   #225	-> 58
/*     */     //   #227	-> 72
/*     */     //   #228	-> 77
/*     */     //   #230	-> 95
/*     */     //   #232	-> 102
/*     */     //   #236	-> 110
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\b\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */