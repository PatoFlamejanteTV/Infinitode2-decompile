/*     */ package com.vladsch.flexmark.util.html.ui;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.swing.JTextPane;
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
/*     */ public class HtmlHelpers
/*     */ {
/*     */   public static String toHtmlError(String paramString, boolean paramBoolean) {
/*  31 */     if (paramString == null) return null;  Matcher matcher;
/*     */     String str;
/*  33 */     if (paramBoolean && (
/*     */       
/*  35 */       matcher = Pattern.compile("(?:^|\n)(.*\n)(\\s*)\\^(\n?)$").matcher(paramString)).find() && (
/*     */       
/*  37 */       str = matcher.group(2)) != null && !str.isEmpty()) {
/*  38 */       int i = (matcher.group(1) != null) ? matcher.start(1) : matcher.start(2);
/*  39 */       String str1 = Utils.repeat("&nbsp;", str.length());
/*  40 */       paramString = paramString.substring(0, i) + "<span style=\"font-family:monospaced\">" + paramString.substring(i, matcher.start(2)).replace(" ", "&nbsp;") + str1 + "^</span>" + str;
/*     */     } 
/*     */ 
/*     */     
/*  44 */     return paramString.replace("\n", "<br>");
/*     */   }
/*     */   
/*     */   public static void setRegExError(String paramString, JTextPane paramJTextPane, Font paramFont, BackgroundColor paramBackgroundColor1, BackgroundColor paramBackgroundColor2) {
/*     */     HtmlBuilder htmlBuilder;
/*  49 */     ((HtmlBuilder)(htmlBuilder = new HtmlBuilder()).tag("html")).style("margin:2px;vertical-align:middle;").attr(new Object[] { paramBackgroundColor1, paramFont }).tag("body");
/*  50 */     htmlBuilder.attr(new Object[] { paramBackgroundColor2 }).tag("div");
/*  51 */     htmlBuilder.append(toHtmlError(paramString, true));
/*  52 */     htmlBuilder.closeTag("div");
/*  53 */     htmlBuilder.closeTag("body");
/*  54 */     htmlBuilder.closeTag("html");
/*     */     
/*  56 */     paramJTextPane.setVisible(true);
/*  57 */     paramJTextPane.setText(htmlBuilder.toFinalizedString());
/*  58 */     paramJTextPane.revalidate();
/*  59 */     paramJTextPane.getParent().revalidate();
/*  60 */     paramJTextPane.getParent().getParent().revalidate();
/*     */   }
/*     */   
/*     */   public static String withContext(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {
/*     */     StringBuilder stringBuilder;
/*  65 */     (stringBuilder = new StringBuilder()).append(paramString1).append('\n');
/*  66 */     stringBuilder.append(paramString3).append(paramString2).append(paramString4).append('\n');
/*  67 */     for (byte b = 1; b < paramString3.length(); ) { stringBuilder.append(' '); b++; }
/*  68 */      stringBuilder.append('^').append('\n');
/*  69 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static String toRgbString(Color paramColor) {
/*  73 */     return (paramColor == null) ? "rgb(0,0,0)" : ("rgb(" + paramColor.getRed() + "," + paramColor.getGreen() + "," + paramColor.getBlue() + ")");
/*     */   }
/*     */   
/*     */   public static String toHtmlString(Color paramColor) {
/*  77 */     return (paramColor == null) ? "#000000" : String.format("#%02x%02x%02x", new Object[] { Integer.valueOf(paramColor.getRed()), Integer.valueOf(paramColor.getGreen()), Integer.valueOf(paramColor.getBlue()) });
/*     */   }
/*     */   
/*     */   public static Color mixedColor(Color paramColor1, Color paramColor2) {
/*  81 */     float[] arrayOfFloat1 = Color.RGBtoHSB(paramColor1.getRed(), paramColor1.getGreen(), paramColor1.getBlue(), new float[3]);
/*  82 */     float[] arrayOfFloat2 = Color.RGBtoHSB(paramColor2.getRed(), paramColor2.getGreen(), paramColor2.getBlue(), new float[3]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     float[] arrayOfFloat3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     (arrayOfFloat3 = new float[3])[0] = arrayOfFloat2[0];
/*  98 */     arrayOfFloat3[1] = Utils.rangeLimit(arrayOfFloat1[1], Utils.min(Utils.max(arrayOfFloat2[1], new float[] { 0.3F }), new float[] { 0.5F }), 1.0F);
/*  99 */     arrayOfFloat3[2] = Utils.rangeLimit(arrayOfFloat1[2], Utils.min(Utils.max(arrayOfFloat2[2], new float[] { 0.3F }), new float[] { 0.5F }), 1.0F);
/* 100 */     return Color.getHSBColor(arrayOfFloat3[0], arrayOfFloat3[1], arrayOfFloat3[2]);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\htm\\ui\HtmlHelpers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */