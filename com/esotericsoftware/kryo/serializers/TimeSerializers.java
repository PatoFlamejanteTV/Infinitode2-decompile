/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.kryo.util.Util;
/*     */ import java.time.Duration;
/*     */ import java.time.Instant;
/*     */ import java.time.LocalDate;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.LocalTime;
/*     */ import java.time.MonthDay;
/*     */ import java.time.OffsetDateTime;
/*     */ import java.time.OffsetTime;
/*     */ import java.time.Period;
/*     */ import java.time.Year;
/*     */ import java.time.YearMonth;
/*     */ import java.time.ZoneId;
/*     */ import java.time.ZoneOffset;
/*     */ import java.time.ZonedDateTime;
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
/*     */ 
/*     */ public final class TimeSerializers
/*     */ {
/*     */   public static void addDefaultSerializers(Kryo paramKryo) {
/*  51 */     if (Util.isClassAvailable("java.time.Duration")) paramKryo.addDefaultSerializer(Duration.class, DurationSerializer.class); 
/*  52 */     if (Util.isClassAvailable("java.time.Instant")) paramKryo.addDefaultSerializer(Instant.class, InstantSerializer.class); 
/*  53 */     if (Util.isClassAvailable("java.time.LocalDate")) paramKryo.addDefaultSerializer(LocalDate.class, LocalDateSerializer.class); 
/*  54 */     if (Util.isClassAvailable("java.time.LocalTime")) paramKryo.addDefaultSerializer(LocalTime.class, LocalTimeSerializer.class); 
/*  55 */     if (Util.isClassAvailable("java.time.LocalDateTime"))
/*  56 */       paramKryo.addDefaultSerializer(LocalDateTime.class, LocalDateTimeSerializer.class); 
/*  57 */     if (Util.isClassAvailable("java.time.ZoneOffset")) paramKryo.addDefaultSerializer(ZoneOffset.class, ZoneOffsetSerializer.class); 
/*  58 */     if (Util.isClassAvailable("java.time.ZoneId")) paramKryo.addDefaultSerializer(ZoneId.class, ZoneIdSerializer.class); 
/*  59 */     if (Util.isClassAvailable("java.time.OffsetTime")) paramKryo.addDefaultSerializer(OffsetTime.class, OffsetTimeSerializer.class); 
/*  60 */     if (Util.isClassAvailable("java.time.OffsetDateTime"))
/*  61 */       paramKryo.addDefaultSerializer(OffsetDateTime.class, OffsetDateTimeSerializer.class); 
/*  62 */     if (Util.isClassAvailable("java.time.ZonedDateTime"))
/*  63 */       paramKryo.addDefaultSerializer(ZonedDateTime.class, ZonedDateTimeSerializer.class); 
/*  64 */     if (Util.isClassAvailable("java.time.Year")) paramKryo.addDefaultSerializer(Year.class, YearSerializer.class); 
/*  65 */     if (Util.isClassAvailable("java.time.YearMonth")) paramKryo.addDefaultSerializer(YearMonth.class, YearMonthSerializer.class); 
/*  66 */     if (Util.isClassAvailable("java.time.MonthDay")) paramKryo.addDefaultSerializer(MonthDay.class, MonthDaySerializer.class); 
/*  67 */     if (Util.isClassAvailable("java.time.Period")) paramKryo.addDefaultSerializer(Period.class, PeriodSerializer.class); 
/*     */   }
/*     */   
/*     */   public static class DurationSerializer extends ImmutableSerializer<Duration> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, Duration param1Duration) {
/*  72 */       param1Output.writeLong(param1Duration.getSeconds());
/*  73 */       param1Output.writeInt(param1Duration.getNano(), true);
/*     */     }
/*     */     
/*     */     public Duration read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*  77 */       long l = param1Input.readLong();
/*  78 */       int i = param1Input.readInt(true);
/*  79 */       return Duration.ofSeconds(l, i);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class InstantSerializer extends ImmutableSerializer<Instant> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, Instant param1Instant) {
/*  85 */       param1Output.writeVarLong(param1Instant.getEpochSecond(), true);
/*  86 */       param1Output.writeInt(param1Instant.getNano(), true);
/*     */     }
/*     */     
/*     */     public Instant read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/*  90 */       long l = param1Input.readVarLong(true);
/*  91 */       int i = param1Input.readInt(true);
/*  92 */       return Instant.ofEpochSecond(l, i);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LocalDateSerializer extends ImmutableSerializer<LocalDate> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, LocalDate param1LocalDate) {
/*  98 */       write(param1Output, param1LocalDate);
/*     */     }
/*     */     
/*     */     static void write(Output param1Output, LocalDate param1LocalDate) {
/* 102 */       param1Output.writeInt(param1LocalDate.getYear(), true);
/* 103 */       param1Output.writeByte(param1LocalDate.getMonthValue());
/* 104 */       param1Output.writeByte(param1LocalDate.getDayOfMonth());
/*     */     }
/*     */     
/*     */     public LocalDate read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 108 */       return read(param1Input);
/*     */     }
/*     */     
/*     */     static LocalDate read(Input param1Input) {
/* 112 */       int i = param1Input.readInt(true);
/* 113 */       byte b2 = param1Input.readByte();
/* 114 */       byte b1 = param1Input.readByte();
/* 115 */       return LocalDate.of(i, b2, b1);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LocalDateTimeSerializer extends ImmutableSerializer<LocalDateTime> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, LocalDateTime param1LocalDateTime) {
/* 121 */       TimeSerializers.LocalDateSerializer.write(param1Output, param1LocalDateTime.toLocalDate());
/* 122 */       TimeSerializers.LocalTimeSerializer.write(param1Output, param1LocalDateTime.toLocalTime());
/*     */     }
/*     */     
/*     */     public LocalDateTime read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 126 */       LocalDate localDate = TimeSerializers.LocalDateSerializer.read(param1Input);
/* 127 */       LocalTime localTime = TimeSerializers.LocalTimeSerializer.read(param1Input);
/* 128 */       return LocalDateTime.of(localDate, localTime);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LocalTimeSerializer extends ImmutableSerializer<LocalTime> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, LocalTime param1LocalTime) {
/* 134 */       write(param1Output, param1LocalTime);
/*     */     }
/*     */     
/*     */     static void write(Output param1Output, LocalTime param1LocalTime) {
/* 138 */       if (param1LocalTime.getNano() == 0) {
/* 139 */         if (param1LocalTime.getSecond() == 0) {
/* 140 */           if (param1LocalTime.getMinute() == 0) {
/* 141 */             param1Output.writeByte(param1LocalTime.getHour() ^ 0xFFFFFFFF); return;
/*     */           } 
/* 143 */           param1Output.writeByte(param1LocalTime.getHour());
/* 144 */           param1Output.writeByte(param1LocalTime.getMinute() ^ 0xFFFFFFFF);
/*     */           return;
/*     */         } 
/* 147 */         param1Output.writeByte(param1LocalTime.getHour());
/* 148 */         param1Output.writeByte(param1LocalTime.getMinute());
/* 149 */         param1Output.writeByte(param1LocalTime.getSecond() ^ 0xFFFFFFFF);
/*     */         return;
/*     */       } 
/* 152 */       param1Output.writeByte(param1LocalTime.getHour());
/* 153 */       param1Output.writeByte(param1LocalTime.getMinute());
/* 154 */       param1Output.writeByte(param1LocalTime.getSecond());
/* 155 */       param1Output.writeInt(param1LocalTime.getNano(), true);
/*     */     }
/*     */ 
/*     */     
/*     */     public LocalTime read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 160 */       return read(param1Input);
/*     */     }
/*     */     
/*     */     static LocalTime read(Input param1Input) {
/* 164 */       int i = param1Input.readByte();
/* 165 */       int j = 0;
/* 166 */       int k = 0;
/* 167 */       int m = 0;
/* 168 */       if (i < 0) {
/* 169 */         i = i ^ 0xFFFFFFFF;
/*     */       
/*     */       }
/* 172 */       else if ((j = param1Input.readByte()) < 0) {
/* 173 */         j ^= 0xFFFFFFFF;
/*     */       
/*     */       }
/* 176 */       else if ((k = param1Input.readByte()) < 0) {
/* 177 */         k ^= 0xFFFFFFFF;
/*     */       } else {
/* 179 */         m = param1Input.readInt(true);
/*     */       } 
/*     */ 
/*     */       
/* 183 */       return LocalTime.of(i, j, k, m);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ZoneOffsetSerializer extends ImmutableSerializer<ZoneOffset> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, ZoneOffset param1ZoneOffset) {
/* 189 */       write(param1Output, param1ZoneOffset);
/*     */     }
/*     */     
/*     */     static void write(Output param1Output, ZoneOffset param1ZoneOffset) {
/*     */       int i;
/* 194 */       boolean bool = ((i = param1ZoneOffset.getTotalSeconds()) % 900 == 0) ? (i / 900) : true;
/* 195 */       param1Output.writeByte(bool);
/* 196 */       if (bool == 127) {
/* 197 */         param1Output.writeInt(i);
/*     */       }
/*     */     }
/*     */     
/*     */     public ZoneOffset read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 202 */       return read(param1Input);
/*     */     }
/*     */     
/*     */     static ZoneOffset read(Input param1Input) {
/*     */       byte b;
/* 207 */       return ((b = param1Input.readByte()) == Byte.MAX_VALUE) ? ZoneOffset.ofTotalSeconds(param1Input.readInt()) : ZoneOffset.ofTotalSeconds(b * 900);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ZoneIdSerializer extends ImmutableSerializer<ZoneId> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, ZoneId param1ZoneId) {
/* 213 */       write(param1Output, param1ZoneId);
/*     */     }
/*     */     
/*     */     static void write(Output param1Output, ZoneId param1ZoneId) {
/* 217 */       param1Output.writeString(param1ZoneId.getId());
/*     */     }
/*     */     
/*     */     public ZoneId read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 221 */       return read(param1Input);
/*     */     }
/*     */     
/*     */     static ZoneId read(Input param1Input) {
/*     */       String str;
/* 226 */       return ZoneId.of(str = param1Input.readString());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class OffsetTimeSerializer extends ImmutableSerializer<OffsetTime> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, OffsetTime param1OffsetTime) {
/* 232 */       TimeSerializers.LocalTimeSerializer.write(param1Output, param1OffsetTime.toLocalTime());
/* 233 */       TimeSerializers.ZoneOffsetSerializer.write(param1Output, param1OffsetTime.getOffset());
/*     */     }
/*     */     
/*     */     public OffsetTime read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 237 */       LocalTime localTime = TimeSerializers.LocalTimeSerializer.read(param1Input);
/* 238 */       ZoneOffset zoneOffset = TimeSerializers.ZoneOffsetSerializer.read(param1Input);
/* 239 */       return OffsetTime.of(localTime, zoneOffset);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class OffsetDateTimeSerializer extends ImmutableSerializer<OffsetDateTime> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, OffsetDateTime param1OffsetDateTime) {
/* 245 */       TimeSerializers.LocalDateSerializer.write(param1Output, param1OffsetDateTime.toLocalDate());
/* 246 */       TimeSerializers.LocalTimeSerializer.write(param1Output, param1OffsetDateTime.toLocalTime());
/* 247 */       TimeSerializers.ZoneOffsetSerializer.write(param1Output, param1OffsetDateTime.getOffset());
/*     */     }
/*     */     
/*     */     public OffsetDateTime read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 251 */       LocalDate localDate = TimeSerializers.LocalDateSerializer.read(param1Input);
/* 252 */       LocalTime localTime = TimeSerializers.LocalTimeSerializer.read(param1Input);
/* 253 */       ZoneOffset zoneOffset = TimeSerializers.ZoneOffsetSerializer.read(param1Input);
/* 254 */       return OffsetDateTime.of(localDate, localTime, zoneOffset);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ZonedDateTimeSerializer extends ImmutableSerializer<ZonedDateTime> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, ZonedDateTime param1ZonedDateTime) {
/* 260 */       TimeSerializers.LocalDateSerializer.write(param1Output, param1ZonedDateTime.toLocalDate());
/* 261 */       TimeSerializers.LocalTimeSerializer.write(param1Output, param1ZonedDateTime.toLocalTime());
/* 262 */       TimeSerializers.ZoneIdSerializer.write(param1Output, param1ZonedDateTime.getZone());
/*     */     }
/*     */     
/*     */     public ZonedDateTime read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 266 */       LocalDate localDate = TimeSerializers.LocalDateSerializer.read(param1Input);
/* 267 */       LocalTime localTime = TimeSerializers.LocalTimeSerializer.read(param1Input);
/* 268 */       ZoneId zoneId = TimeSerializers.ZoneIdSerializer.read(param1Input);
/* 269 */       return ZonedDateTime.of(localDate, localTime, zoneId);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class YearSerializer extends ImmutableSerializer<Year> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, Year param1Year) {
/* 275 */       param1Output.writeVarInt(param1Year.getValue(), true);
/*     */     }
/*     */     
/*     */     public Year read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 279 */       return Year.of(param1Input.readInt(true));
/*     */     }
/*     */   }
/*     */   
/*     */   public static class YearMonthSerializer extends ImmutableSerializer<YearMonth> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, YearMonth param1YearMonth) {
/* 285 */       param1Output.writeVarInt(param1YearMonth.getYear(), true);
/* 286 */       param1Output.writeByte(param1YearMonth.getMonthValue());
/*     */     }
/*     */     
/*     */     public YearMonth read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 290 */       int i = param1Input.readInt(true);
/* 291 */       byte b = param1Input.readByte();
/* 292 */       return YearMonth.of(i, b);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class MonthDaySerializer extends ImmutableSerializer<MonthDay> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, MonthDay param1MonthDay) {
/* 298 */       param1Output.writeByte(param1MonthDay.getMonthValue());
/* 299 */       param1Output.writeByte(param1MonthDay.getDayOfMonth());
/*     */     }
/*     */     
/*     */     public MonthDay read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 303 */       byte b1 = param1Input.readByte();
/* 304 */       byte b2 = param1Input.readByte();
/* 305 */       return MonthDay.of(b1, b2);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PeriodSerializer extends ImmutableSerializer<Period> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, Period param1Period) {
/* 311 */       param1Output.writeVarInt(param1Period.getYears(), true);
/* 312 */       param1Output.writeVarInt(param1Period.getMonths(), true);
/* 313 */       param1Output.writeVarInt(param1Period.getDays(), true);
/*     */     }
/*     */     
/*     */     public Period read(Kryo param1Kryo, Input param1Input, Class param1Class) {
/* 317 */       int i = param1Input.readInt(true);
/* 318 */       int k = param1Input.readInt(true);
/* 319 */       int j = param1Input.readInt(true);
/* 320 */       return Period.of(i, k, j);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\TimeSerializers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */