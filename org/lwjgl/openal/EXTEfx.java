/*      */ package org.lwjgl.openal;
/*      */ 
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class EXTEfx
/*      */ {
/*      */   public static final int ALC_EFX_MAJOR_VERSION = 131073;
/*      */   public static final int ALC_EFX_MINOR_VERSION = 131074;
/*      */   public static final int ALC_MAX_AUXILIARY_SENDS = 131075;
/*      */   public static final int AL_METERS_PER_UNIT = 131076;
/*      */   public static final int AL_DIRECT_FILTER = 131077;
/*      */   public static final int AL_AUXILIARY_SEND_FILTER = 131078;
/*      */   public static final int AL_AIR_ABSORPTION_FACTOR = 131079;
/*      */   public static final int AL_ROOM_ROLLOFF_FACTOR = 131080;
/*      */   public static final int AL_CONE_OUTER_GAINHF = 131081;
/*      */   public static final int AL_DIRECT_FILTER_GAINHF_AUTO = 131082;
/*      */   public static final int AL_AUXILIARY_SEND_FILTER_GAIN_AUTO = 131083;
/*      */   public static final int AL_AUXILIARY_SEND_FILTER_GAINHF_AUTO = 131084;
/*      */   public static final int AL_EFFECTSLOT_NULL = 0;
/*      */   public static final int AL_EFFECTSLOT_EFFECT = 1;
/*      */   public static final int AL_EFFECTSLOT_GAIN = 2;
/*      */   public static final int AL_EFFECTSLOT_AUXILIARY_SEND_AUTO = 3;
/*      */   public static final int AL_REVERB_DENSITY = 1;
/*      */   public static final int AL_REVERB_DIFFUSION = 2;
/*      */   public static final int AL_REVERB_GAIN = 3;
/*      */   public static final int AL_REVERB_GAINHF = 4;
/*      */   public static final int AL_REVERB_DECAY_TIME = 5;
/*      */   public static final int AL_REVERB_DECAY_HFRATIO = 6;
/*      */   public static final int AL_REVERB_REFLECTIONS_GAIN = 7;
/*      */   public static final int AL_REVERB_REFLECTIONS_DELAY = 8;
/*      */   public static final int AL_REVERB_LATE_REVERB_GAIN = 9;
/*      */   public static final int AL_REVERB_LATE_REVERB_DELAY = 10;
/*      */   public static final int AL_REVERB_AIR_ABSORPTION_GAINHF = 11;
/*      */   public static final int AL_REVERB_ROOM_ROLLOFF_FACTOR = 12;
/*      */   public static final int AL_REVERB_DECAY_HFLIMIT = 13;
/*      */   public static final int AL_EAXREVERB_DENSITY = 1;
/*      */   public static final int AL_EAXREVERB_DIFFUSION = 2;
/*      */   public static final int AL_EAXREVERB_GAIN = 3;
/*      */   public static final int AL_EAXREVERB_GAINHF = 4;
/*      */   public static final int AL_EAXREVERB_GAINLF = 5;
/*      */   public static final int AL_EAXREVERB_DECAY_TIME = 6;
/*      */   public static final int AL_EAXREVERB_DECAY_HFRATIO = 7;
/*      */   public static final int AL_EAXREVERB_DECAY_LFRATIO = 8;
/*      */   public static final int AL_EAXREVERB_REFLECTIONS_GAIN = 9;
/*      */   public static final int AL_EAXREVERB_REFLECTIONS_DELAY = 10;
/*      */   public static final int AL_EAXREVERB_REFLECTIONS_PAN = 11;
/*      */   public static final int AL_EAXREVERB_LATE_REVERB_GAIN = 12;
/*      */   public static final int AL_EAXREVERB_LATE_REVERB_DELAY = 13;
/*      */   public static final int AL_EAXREVERB_LATE_REVERB_PAN = 14;
/*      */   public static final int AL_EAXREVERB_ECHO_TIME = 15;
/*      */   public static final int AL_EAXREVERB_ECHO_DEPTH = 16;
/*      */   public static final int AL_EAXREVERB_MODULATION_TIME = 17;
/*      */   public static final int AL_EAXREVERB_MODULATION_DEPTH = 18;
/*      */   public static final int AL_EAXREVERB_AIR_ABSORPTION_GAINHF = 19;
/*      */   public static final int AL_EAXREVERB_HFREFERENCE = 20;
/*      */   public static final int AL_EAXREVERB_LFREFERENCE = 21;
/*      */   public static final int AL_EAXREVERB_ROOM_ROLLOFF_FACTOR = 22;
/*      */   public static final int AL_EAXREVERB_DECAY_HFLIMIT = 23;
/*      */   public static final int AL_CHORUS_WAVEFORM = 1;
/*      */   public static final int AL_CHORUS_PHASE = 2;
/*      */   public static final int AL_CHORUS_RATE = 3;
/*      */   public static final int AL_CHORUS_DEPTH = 4;
/*      */   public static final int AL_CHORUS_FEEDBACK = 5;
/*      */   public static final int AL_CHORUS_DELAY = 6;
/*      */   public static final int AL_DISTORTION_EDGE = 1;
/*      */   public static final int AL_DISTORTION_GAIN = 2;
/*      */   public static final int AL_DISTORTION_LOWPASS_CUTOFF = 3;
/*      */   public static final int AL_DISTORTION_EQCENTER = 4;
/*      */   public static final int AL_DISTORTION_EQBANDWIDTH = 5;
/*      */   public static final int AL_ECHO_DELAY = 1;
/*      */   public static final int AL_ECHO_LRDELAY = 2;
/*      */   public static final int AL_ECHO_DAMPING = 3;
/*      */   public static final int AL_ECHO_FEEDBACK = 4;
/*      */   public static final int AL_ECHO_SPREAD = 5;
/*      */   public static final int AL_FLANGER_WAVEFORM = 1;
/*      */   public static final int AL_FLANGER_PHASE = 2;
/*      */   public static final int AL_FLANGER_RATE = 3;
/*      */   public static final int AL_FLANGER_DEPTH = 4;
/*      */   public static final int AL_FLANGER_FEEDBACK = 5;
/*      */   public static final int AL_FLANGER_DELAY = 6;
/*      */   public static final int AL_FREQUENCY_SHIFTER_FREQUENCY = 1;
/*      */   public static final int AL_FREQUENCY_SHIFTER_LEFT_DIRECTION = 2;
/*      */   public static final int AL_FREQUENCY_SHIFTER_RIGHT_DIRECTION = 3;
/*      */   public static final int AL_VOCMORPHER_PHONEMEA = 1;
/*      */   public static final int AL_VOCMORPHER_PHONEMEA_COARSE_TUNING = 2;
/*      */   public static final int AL_VOCMORPHER_PHONEMEB = 3;
/*      */   public static final int AL_VOCMORPHER_PHONEMEB_COARSE_TUNING = 4;
/*      */   public static final int AL_VOCMORPHER_WAVEFORM = 5;
/*      */   public static final int AL_VOCMORPHER_RATE = 6;
/*      */   public static final int AL_PITCH_SHIFTER_COARSE_TUNE = 1;
/*      */   public static final int AL_PITCH_SHIFTER_FINE_TUNE = 2;
/*      */   public static final int AL_RING_MODULATOR_FREQUENCY = 1;
/*      */   public static final int AL_RING_MODULATOR_HIGHPASS_CUTOFF = 2;
/*      */   public static final int AL_RING_MODULATOR_WAVEFORM = 3;
/*      */   public static final int AL_AUTOWAH_ATTACK_TIME = 1;
/*      */   public static final int AL_AUTOWAH_RELEASE_TIME = 2;
/*      */   public static final int AL_AUTOWAH_RESONANCE = 3;
/*      */   public static final int AL_AUTOWAH_PEAK_GAIN = 4;
/*      */   public static final int AL_COMPRESSOR_ONOFF = 1;
/*      */   public static final int AL_EQUALIZER_LOW_GAIN = 1;
/*      */   public static final int AL_EQUALIZER_LOW_CUTOFF = 2;
/*      */   public static final int AL_EQUALIZER_MID1_GAIN = 3;
/*      */   public static final int AL_EQUALIZER_MID1_CENTER = 4;
/*      */   public static final int AL_EQUALIZER_MID1_WIDTH = 5;
/*      */   public static final int AL_EQUALIZER_MID2_GAIN = 6;
/*      */   public static final int AL_EQUALIZER_MID2_CENTER = 7;
/*      */   public static final int AL_EQUALIZER_MID2_WIDTH = 8;
/*      */   public static final int AL_EQUALIZER_HIGH_GAIN = 9;
/*      */   public static final int AL_EQUALIZER_HIGH_CUTOFF = 10;
/*      */   public static final int AL_EFFECT_FIRST_PARAMETER = 0;
/*      */   public static final int AL_EFFECT_LAST_PARAMETER = 32768;
/*      */   public static final int AL_EFFECT_TYPE = 32769;
/*      */   public static final int AL_EFFECT_NULL = 0;
/*      */   public static final int AL_EFFECT_REVERB = 1;
/*      */   public static final int AL_EFFECT_CHORUS = 2;
/*      */   public static final int AL_EFFECT_DISTORTION = 3;
/*      */   public static final int AL_EFFECT_ECHO = 4;
/*      */   public static final int AL_EFFECT_FLANGER = 5;
/*      */   public static final int AL_EFFECT_FREQUENCY_SHIFTER = 6;
/*      */   public static final int AL_EFFECT_VOCAL_MORPHER = 7;
/*      */   public static final int AL_EFFECT_PITCH_SHIFTER = 8;
/*      */   public static final int AL_EFFECT_RING_MODULATOR = 9;
/*      */   public static final int AL_EFFECT_AUTOWAH = 10;
/*      */   public static final int AL_EFFECT_COMPRESSOR = 11;
/*      */   public static final int AL_EFFECT_EQUALIZER = 12;
/*      */   public static final int AL_EFFECT_EAXREVERB = 32768;
/*      */   public static final int AL_LOWPASS_GAIN = 1;
/*      */   public static final int AL_LOWPASS_GAINHF = 2;
/*      */   public static final int AL_HIGHPASS_GAIN = 1;
/*      */   public static final int AL_HIGHPASS_GAINLF = 2;
/*      */   public static final int AL_BANDPASS_GAIN = 1;
/*      */   public static final int AL_BANDPASS_GAINLF = 2;
/*      */   public static final int AL_BANDPASS_GAINHF = 3;
/*      */   public static final int AL_FILTER_FIRST_PARAMETER = 0;
/*      */   public static final int AL_FILTER_LAST_PARAMETER = 32768;
/*      */   public static final int AL_FILTER_TYPE = 32769;
/*      */   public static final int AL_FILTER_NULL = 0;
/*      */   public static final int AL_FILTER_LOWPASS = 1;
/*      */   public static final int AL_FILTER_HIGHPASS = 2;
/*      */   public static final int AL_FILTER_BANDPASS = 3;
/*      */   public static final float AL_MIN_AIR_ABSORPTION_FACTOR = 0.0F;
/*      */   public static final float AL_MAX_AIR_ABSORPTION_FACTOR = 10.0F;
/*      */   public static final float AL_DEFAULT_AIR_ABSORPTION_FACTOR = 0.0F;
/*      */   public static final float AL_MIN_ROOM_ROLLOFF_FACTOR = 0.0F;
/*      */   public static final float AL_MAX_ROOM_ROLLOFF_FACTOR = 10.0F;
/*      */   public static final float AL_DEFAULT_ROOM_ROLLOFF_FACTOR = 0.0F;
/*      */   public static final float AL_MIN_CONE_OUTER_GAINHF = 0.0F;
/*      */   public static final float AL_MAX_CONE_OUTER_GAINHF = 1.0F;
/*      */   public static final float AL_DEFAULT_CONE_OUTER_GAINHF = 1.0F;
/*      */   public static final int AL_MIN_DIRECT_FILTER_GAINHF_AUTO = 0;
/*      */   public static final int AL_MAX_DIRECT_FILTER_GAINHF_AUTO = 1;
/*      */   public static final int AL_DEFAULT_DIRECT_FILTER_GAINHF_AUTO = 1;
/*      */   public static final int AL_MIN_AUXILIARY_SEND_FILTER_GAIN_AUTO = 0;
/*      */   public static final int AL_MAX_AUXILIARY_SEND_FILTER_GAIN_AUTO = 1;
/*      */   public static final int AL_DEFAULT_AUXILIARY_SEND_FILTER_GAIN_AUTO = 1;
/*      */   public static final int AL_MIN_AUXILIARY_SEND_FILTER_GAINHF_AUTO = 0;
/*      */   public static final int AL_MAX_AUXILIARY_SEND_FILTER_GAINHF_AUTO = 1;
/*      */   public static final int AL_DEFAULT_AUXILIARY_SEND_FILTER_GAINHF_AUTO = 1;
/*      */   public static final float AL_MIN_METERS_PER_UNIT = 1.4E-45F;
/*      */   public static final float AL_MAX_METERS_PER_UNIT = 3.4028235E38F;
/*      */   public static final float AL_DEFAULT_METERS_PER_UNIT = 1.0F;
/*      */   public static final float AL_REVERB_MIN_DENSITY = 0.0F;
/*      */   public static final float AL_REVERB_MAX_DENSITY = 1.0F;
/*      */   public static final float AL_REVERB_DEFAULT_DENSITY = 1.0F;
/*      */   public static final float AL_REVERB_MIN_DIFFUSION = 0.0F;
/*      */   public static final float AL_REVERB_MAX_DIFFUSION = 1.0F;
/*      */   public static final float AL_REVERB_DEFAULT_DIFFUSION = 1.0F;
/*      */   public static final float AL_REVERB_MIN_GAIN = 0.0F;
/*      */   public static final float AL_REVERB_MAX_GAIN = 1.0F;
/*      */   public static final float AL_REVERB_DEFAULT_GAIN = 0.32F;
/*      */   public static final float AL_REVERB_MIN_GAINHF = 0.0F;
/*      */   public static final float AL_REVERB_MAX_GAINHF = 1.0F;
/*      */   public static final float AL_REVERB_DEFAULT_GAINHF = 0.89F;
/*      */   public static final float AL_REVERB_MIN_DECAY_TIME = 0.1F;
/*      */   public static final float AL_REVERB_MAX_DECAY_TIME = 20.0F;
/*      */   public static final float AL_REVERB_DEFAULT_DECAY_TIME = 1.49F;
/*      */   public static final float AL_REVERB_MIN_DECAY_HFRATIO = 0.1F;
/*      */   public static final float AL_REVERB_MAX_DECAY_HFRATIO = 2.0F;
/*      */   public static final float AL_REVERB_DEFAULT_DECAY_HFRATIO = 0.83F;
/*      */   public static final float AL_REVERB_MIN_REFLECTIONS_GAIN = 0.0F;
/*      */   public static final float AL_REVERB_MAX_REFLECTIONS_GAIN = 3.16F;
/*      */   public static final float AL_REVERB_DEFAULT_REFLECTIONS_GAIN = 0.05F;
/*      */   public static final float AL_REVERB_MIN_REFLECTIONS_DELAY = 0.0F;
/*      */   public static final float AL_REVERB_MAX_REFLECTIONS_DELAY = 0.3F;
/*      */   public static final float AL_REVERB_DEFAULT_REFLECTIONS_DELAY = 0.007F;
/*      */   public static final float AL_REVERB_MIN_LATE_REVERB_GAIN = 0.0F;
/*      */   public static final float AL_REVERB_MAX_LATE_REVERB_GAIN = 10.0F;
/*      */   public static final float AL_REVERB_DEFAULT_LATE_REVERB_GAIN = 1.26F;
/*      */   public static final float AL_REVERB_MIN_LATE_REVERB_DELAY = 0.0F;
/*      */   public static final float AL_REVERB_MAX_LATE_REVERB_DELAY = 0.1F;
/*      */   public static final float AL_REVERB_DEFAULT_LATE_REVERB_DELAY = 0.011F;
/*      */   public static final float AL_REVERB_MIN_AIR_ABSORPTION_GAINHF = 0.892F;
/*      */   public static final float AL_REVERB_MAX_AIR_ABSORPTION_GAINHF = 1.0F;
/*      */   public static final float AL_REVERB_DEFAULT_AIR_ABSORPTION_GAINHF = 0.994F;
/*      */   public static final float AL_REVERB_MIN_ROOM_ROLLOFF_FACTOR = 0.0F;
/*      */   public static final float AL_REVERB_MAX_ROOM_ROLLOFF_FACTOR = 10.0F;
/*      */   public static final float AL_REVERB_DEFAULT_ROOM_ROLLOFF_FACTOR = 0.0F;
/*      */   public static final int AL_REVERB_MIN_DECAY_HFLIMIT = 0;
/*      */   public static final int AL_REVERB_MAX_DECAY_HFLIMIT = 1;
/*      */   public static final int AL_REVERB_DEFAULT_DECAY_HFLIMIT = 1;
/*      */   public static final float AL_EAXREVERB_MIN_DENSITY = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_DENSITY = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_DENSITY = 1.0F;
/*      */   public static final float AL_EAXREVERB_MIN_DIFFUSION = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_DIFFUSION = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_DIFFUSION = 1.0F;
/*      */   public static final float AL_EAXREVERB_MIN_GAIN = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_GAIN = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_GAIN = 0.32F;
/*      */   public static final float AL_EAXREVERB_MIN_GAINHF = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_GAINHF = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_GAINHF = 0.89F;
/*      */   public static final float AL_EAXREVERB_MIN_GAINLF = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_GAINLF = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_GAINLF = 1.0F;
/*      */   public static final float AL_EAXREVERB_MIN_DECAY_TIME = 0.1F;
/*      */   public static final float AL_EAXREVERB_MAX_DECAY_TIME = 20.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_DECAY_TIME = 1.49F;
/*      */   public static final float AL_EAXREVERB_MIN_DECAY_HFRATIO = 0.1F;
/*      */   public static final float AL_EAXREVERB_MAX_DECAY_HFRATIO = 2.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_DECAY_HFRATIO = 0.83F;
/*      */   public static final float AL_EAXREVERB_MIN_DECAY_LFRATIO = 0.1F;
/*      */   public static final float AL_EAXREVERB_MAX_DECAY_LFRATIO = 2.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_DECAY_LFRATIO = 1.0F;
/*      */   public static final float AL_EAXREVERB_MIN_REFLECTIONS_GAIN = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_REFLECTIONS_GAIN = 3.16F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_REFLECTIONS_GAIN = 0.05F;
/*      */   public static final float AL_EAXREVERB_MIN_REFLECTIONS_DELAY = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_REFLECTIONS_DELAY = 0.3F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_REFLECTIONS_DELAY = 0.007F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_REFLECTIONS_PAN_XYZ = 0.0F;
/*      */   public static final float AL_EAXREVERB_MIN_LATE_REVERB_GAIN = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_LATE_REVERB_GAIN = 10.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_LATE_REVERB_GAIN = 1.26F;
/*      */   public static final float AL_EAXREVERB_MIN_LATE_REVERB_DELAY = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_LATE_REVERB_DELAY = 0.1F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_LATE_REVERB_DELAY = 0.011F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_LATE_REVERB_PAN_XYZ = 0.0F;
/*      */   public static final float AL_EAXREVERB_MIN_ECHO_TIME = 0.075F;
/*      */   public static final float AL_EAXREVERB_MAX_ECHO_TIME = 0.25F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_ECHO_TIME = 0.25F;
/*      */   public static final float AL_EAXREVERB_MIN_ECHO_DEPTH = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_ECHO_DEPTH = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_ECHO_DEPTH = 0.0F;
/*      */   public static final float AL_EAXREVERB_MIN_MODULATION_TIME = 0.04F;
/*      */   public static final float AL_EAXREVERB_MAX_MODULATION_TIME = 4.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_MODULATION_TIME = 0.25F;
/*      */   public static final float AL_EAXREVERB_MIN_MODULATION_DEPTH = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_MODULATION_DEPTH = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_MODULATION_DEPTH = 0.0F;
/*      */   public static final float AL_EAXREVERB_MIN_AIR_ABSORPTION_GAINHF = 0.892F;
/*      */   public static final float AL_EAXREVERB_MAX_AIR_ABSORPTION_GAINHF = 1.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_AIR_ABSORPTION_GAINHF = 0.994F;
/*      */   public static final float AL_EAXREVERB_MIN_HFREFERENCE = 1000.0F;
/*      */   public static final float AL_EAXREVERB_MAX_HFREFERENCE = 20000.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_HFREFERENCE = 5000.0F;
/*      */   public static final float AL_EAXREVERB_MIN_LFREFERENCE = 20.0F;
/*      */   public static final float AL_EAXREVERB_MAX_LFREFERENCE = 1000.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_LFREFERENCE = 250.0F;
/*      */   public static final float AL_EAXREVERB_MIN_ROOM_ROLLOFF_FACTOR = 0.0F;
/*      */   public static final float AL_EAXREVERB_MAX_ROOM_ROLLOFF_FACTOR = 10.0F;
/*      */   public static final float AL_EAXREVERB_DEFAULT_ROOM_ROLLOFF_FACTOR = 0.0F;
/*      */   public static final int AL_EAXREVERB_MIN_DECAY_HFLIMIT = 0;
/*      */   public static final int AL_EAXREVERB_MAX_DECAY_HFLIMIT = 1;
/*      */   public static final int AL_EAXREVERB_DEFAULT_DECAY_HFLIMIT = 1;
/*      */   public static final int AL_CHORUS_WAVEFORM_SINUSOID = 0;
/*      */   public static final int AL_CHORUS_WAVEFORM_TRIANGLE = 1;
/*      */   public static final int AL_CHORUS_MIN_WAVEFORM = 0;
/*      */   public static final int AL_CHORUS_MAX_WAVEFORM = 1;
/*      */   public static final int AL_CHORUS_DEFAULT_WAVEFORM = 1;
/*      */   public static final int AL_CHORUS_MIN_PHASE = -180;
/*      */   public static final int AL_CHORUS_MAX_PHASE = 180;
/*      */   public static final int AL_CHORUS_DEFAULT_PHASE = 90;
/*      */   public static final float AL_CHORUS_MIN_RATE = 0.0F;
/*      */   public static final float AL_CHORUS_MAX_RATE = 10.0F;
/*      */   public static final float AL_CHORUS_DEFAULT_RATE = 1.1F;
/*      */   public static final float AL_CHORUS_MIN_DEPTH = 0.0F;
/*      */   public static final float AL_CHORUS_MAX_DEPTH = 1.0F;
/*      */   public static final float AL_CHORUS_DEFAULT_DEPTH = 0.1F;
/*      */   public static final float AL_CHORUS_MIN_FEEDBACK = -1.0F;
/*      */   public static final float AL_CHORUS_MAX_FEEDBACK = 1.0F;
/*      */   public static final float AL_CHORUS_DEFAULT_FEEDBACK = 0.25F;
/*      */   public static final float AL_CHORUS_MIN_DELAY = 0.0F;
/*      */   public static final float AL_CHORUS_MAX_DELAY = 0.016F;
/*      */   public static final float AL_CHORUS_DEFAULT_DELAY = 0.016F;
/*      */   public static final float AL_DISTORTION_MIN_EDGE = 0.0F;
/*      */   public static final float AL_DISTORTION_MAX_EDGE = 1.0F;
/*      */   public static final float AL_DISTORTION_DEFAULT_EDGE = 0.2F;
/*      */   public static final float AL_DISTORTION_MIN_GAIN = 0.01F;
/*      */   public static final float AL_DISTORTION_MAX_GAIN = 1.0F;
/*      */   public static final float AL_DISTORTION_DEFAULT_GAIN = 0.05F;
/*      */   public static final float AL_DISTORTION_MIN_LOWPASS_CUTOFF = 80.0F;
/*      */   public static final float AL_DISTORTION_MAX_LOWPASS_CUTOFF = 24000.0F;
/*      */   public static final float AL_DISTORTION_DEFAULT_LOWPASS_CUTOFF = 8000.0F;
/*      */   public static final float AL_DISTORTION_MIN_EQCENTER = 80.0F;
/*      */   public static final float AL_DISTORTION_MAX_EQCENTER = 24000.0F;
/*      */   public static final float AL_DISTORTION_DEFAULT_EQCENTER = 3600.0F;
/*      */   public static final float AL_DISTORTION_MIN_EQBANDWIDTH = 80.0F;
/*      */   public static final float AL_DISTORTION_MAX_EQBANDWIDTH = 24000.0F;
/*      */   public static final float AL_DISTORTION_DEFAULT_EQBANDWIDTH = 3600.0F;
/*      */   public static final float AL_ECHO_MIN_DELAY = 0.0F;
/*      */   public static final float AL_ECHO_MAX_DELAY = 0.207F;
/*      */   public static final float AL_ECHO_DEFAULT_DELAY = 0.1F;
/*      */   public static final float AL_ECHO_MIN_LRDELAY = 0.0F;
/*      */   public static final float AL_ECHO_MAX_LRDELAY = 0.404F;
/*      */   public static final float AL_ECHO_DEFAULT_LRDELAY = 0.1F;
/*      */   public static final float AL_ECHO_MIN_DAMPING = 0.0F;
/*      */   public static final float AL_ECHO_MAX_DAMPING = 0.99F;
/*      */   public static final float AL_ECHO_DEFAULT_DAMPING = 0.5F;
/*      */   public static final float AL_ECHO_MIN_FEEDBACK = 0.0F;
/*      */   public static final float AL_ECHO_MAX_FEEDBACK = 1.0F;
/*      */   public static final float AL_ECHO_DEFAULT_FEEDBACK = 0.5F;
/*      */   public static final float AL_ECHO_MIN_SPREAD = -1.0F;
/*      */   public static final float AL_ECHO_MAX_SPREAD = 1.0F;
/*      */   public static final float AL_ECHO_DEFAULT_SPREAD = -1.0F;
/*      */   public static final int AL_FLANGER_WAVEFORM_SINUSOID = 0;
/*      */   public static final int AL_FLANGER_WAVEFORM_TRIANGLE = 1;
/*      */   public static final int AL_FLANGER_MIN_WAVEFORM = 0;
/*      */   public static final int AL_FLANGER_MAX_WAVEFORM = 1;
/*      */   public static final int AL_FLANGER_DEFAULT_WAVEFORM = 1;
/*      */   public static final int AL_FLANGER_MIN_PHASE = -180;
/*      */   public static final int AL_FLANGER_MAX_PHASE = 180;
/*      */   public static final int AL_FLANGER_DEFAULT_PHASE = 0;
/*      */   public static final float AL_FLANGER_MIN_RATE = 0.0F;
/*      */   public static final float AL_FLANGER_MAX_RATE = 10.0F;
/*      */   public static final float AL_FLANGER_DEFAULT_RATE = 0.27F;
/*      */   public static final float AL_FLANGER_MIN_DEPTH = 0.0F;
/*      */   public static final float AL_FLANGER_MAX_DEPTH = 1.0F;
/*      */   public static final float AL_FLANGER_DEFAULT_DEPTH = 1.0F;
/*      */   public static final float AL_FLANGER_MIN_FEEDBACK = -1.0F;
/*      */   public static final float AL_FLANGER_MAX_FEEDBACK = 1.0F;
/*      */   public static final float AL_FLANGER_DEFAULT_FEEDBACK = -0.5F;
/*      */   public static final float AL_FLANGER_MIN_DELAY = 0.0F;
/*      */   public static final float AL_FLANGER_MAX_DELAY = 0.004F;
/*      */   public static final float AL_FLANGER_DEFAULT_DELAY = 0.002F;
/*      */   public static final float AL_FREQUENCY_SHIFTER_MIN_FREQUENCY = 0.0F;
/*      */   public static final float AL_FREQUENCY_SHIFTER_MAX_FREQUENCY = 24000.0F;
/*      */   public static final float AL_FREQUENCY_SHIFTER_DEFAULT_FREQUENCY = 0.0F;
/*      */   public static final int AL_FREQUENCY_SHIFTER_MIN_LEFT_DIRECTION = 0;
/*      */   public static final int AL_FREQUENCY_SHIFTER_MAX_LEFT_DIRECTION = 2;
/*      */   public static final int AL_FREQUENCY_SHIFTER_DEFAULT_LEFT_DIRECTION = 0;
/*      */   public static final int AL_FREQUENCY_SHIFTER_DIRECTION_DOWN = 0;
/*      */   public static final int AL_FREQUENCY_SHIFTER_DIRECTION_UP = 1;
/*      */   public static final int AL_FREQUENCY_SHIFTER_DIRECTION_OFF = 2;
/*      */   public static final int AL_FREQUENCY_SHIFTER_MIN_RIGHT_DIRECTION = 0;
/*      */   public static final int AL_FREQUENCY_SHIFTER_MAX_RIGHT_DIRECTION = 2;
/*      */   public static final int AL_FREQUENCY_SHIFTER_DEFAULT_RIGHT_DIRECTION = 0;
/*      */   public static final int AL_VOCAL_MORPHER_MIN_PHONEMEA = 0;
/*      */   public static final int AL_VOCAL_MORPHER_MAX_PHONEMEA = 29;
/*      */   public static final int AL_VOCAL_MORPHER_DEFAULT_PHONEMEA = 0;
/*      */   public static final int AL_VOCAL_MORPHER_MIN_PHONEMEA_COARSE_TUNING = -24;
/*      */   public static final int AL_VOCAL_MORPHER_MAX_PHONEMEA_COARSE_TUNING = 24;
/*      */   public static final int AL_VOCAL_MORPHER_DEFAULT_PHONEMEA_COARSE_TUNING = 0;
/*      */   public static final int AL_VOCAL_MORPHER_MIN_PHONEMEB = 0;
/*      */   public static final int AL_VOCAL_MORPHER_MAX_PHONEMEB = 29;
/*      */   public static final int AL_VOCAL_MORPHER_DEFAULT_PHONEMEB = 10;
/*      */   public static final int AL_VOCAL_MORPHER_MIN_PHONEMEB_COARSE_TUNING = -24;
/*      */   public static final int AL_VOCAL_MORPHER_MAX_PHONEMEB_COARSE_TUNING = 24;
/*      */   public static final int AL_VOCAL_MORPHER_DEFAULT_PHONEMEB_COARSE_TUNING = 0;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_A = 0;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_E = 1;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_I = 2;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_O = 3;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_U = 4;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_AA = 5;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_AE = 6;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_AH = 7;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_AO = 8;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_EH = 9;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_ER = 10;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_IH = 11;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_IY = 12;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_UH = 13;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_UW = 14;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_B = 15;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_D = 16;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_F = 17;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_G = 18;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_J = 19;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_K = 20;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_L = 21;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_M = 22;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_N = 23;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_P = 24;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_R = 25;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_S = 26;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_T = 27;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_V = 28;
/*      */   public static final int AL_VOCAL_MORPHER_PHONEME_Z = 29;
/*      */   public static final int AL_VOCAL_MORPHER_WAVEFORM_SINUSOID = 0;
/*      */   public static final int AL_VOCAL_MORPHER_WAVEFORM_TRIANGLE = 1;
/*      */   public static final int AL_VOCAL_MORPHER_WAVEFORM_SAWTOOTH = 2;
/*      */   public static final int AL_VOCAL_MORPHER_MIN_WAVEFORM = 0;
/*      */   public static final int AL_VOCAL_MORPHER_MAX_WAVEFORM = 2;
/*      */   public static final int AL_VOCAL_MORPHER_DEFAULT_WAVEFORM = 0;
/*      */   public static final float AL_VOCAL_MORPHER_MIN_RATE = 0.0F;
/*      */   public static final float AL_VOCAL_MORPHER_MAX_RATE = 10.0F;
/*      */   public static final float AL_VOCAL_MORPHER_DEFAULT_RATE = 1.41F;
/*      */   public static final int AL_PITCH_SHIFTER_MIN_COARSE_TUNE = -12;
/*      */   public static final int AL_PITCH_SHIFTER_MAX_COARSE_TUNE = 12;
/*      */   public static final int AL_PITCH_SHIFTER_DEFAULT_COARSE_TUNE = 12;
/*      */   public static final int AL_PITCH_SHIFTER_MIN_FINE_TUNE = -50;
/*      */   public static final int AL_PITCH_SHIFTER_MAX_FINE_TUNE = 50;
/*      */   public static final int AL_PITCH_SHIFTER_DEFAULT_FINE_TUNE = 0;
/*      */   public static final float AL_RING_MODULATOR_MIN_FREQUENCY = 0.0F;
/*      */   public static final float AL_RING_MODULATOR_MAX_FREQUENCY = 8000.0F;
/*      */   public static final float AL_RING_MODULATOR_DEFAULT_FREQUENCY = 440.0F;
/*      */   public static final float AL_RING_MODULATOR_MIN_HIGHPASS_CUTOFF = 0.0F;
/*      */   public static final float AL_RING_MODULATOR_MAX_HIGHPASS_CUTOFF = 24000.0F;
/*      */   public static final float AL_RING_MODULATOR_DEFAULT_HIGHPASS_CUTOFF = 800.0F;
/*      */   public static final int AL_RING_MODULATOR_SINUSOID = 0;
/*      */   public static final int AL_RING_MODULATOR_SAWTOOTH = 1;
/*      */   public static final int AL_RING_MODULATOR_SQUARE = 2;
/*      */   public static final int AL_RING_MODULATOR_MIN_WAVEFORM = 0;
/*      */   public static final int AL_RING_MODULATOR_MAX_WAVEFORM = 2;
/*      */   public static final int AL_RING_MODULATOR_DEFAULT_WAVEFORM = 0;
/*      */   public static final float AL_AUTOWAH_MIN_ATTACK_TIME = 1.0E-4F;
/*      */   public static final float AL_AUTOWAH_MAX_ATTACK_TIME = 1.0F;
/*      */   public static final float AL_AUTOWAH_DEFAULT_ATTACK_TIME = 0.06F;
/*      */   public static final float AL_AUTOWAH_MIN_RELEASE_TIME = 1.0E-4F;
/*      */   public static final float AL_AUTOWAH_MAX_RELEASE_TIME = 1.0F;
/*      */   public static final float AL_AUTOWAH_DEFAULT_RELEASE_TIME = 0.06F;
/*      */   public static final float AL_AUTOWAH_MIN_RESONANCE = 2.0F;
/*      */   public static final float AL_AUTOWAH_MAX_RESONANCE = 1000.0F;
/*      */   public static final float AL_AUTOWAH_DEFAULT_RESONANCE = 1000.0F;
/*      */   public static final float AL_AUTOWAH_MIN_PEAK_GAIN = 3.0E-5F;
/*      */   public static final float AL_AUTOWAH_MAX_PEAK_GAIN = 31621.0F;
/*      */   public static final float AL_AUTOWAH_DEFAULT_PEAK_GAIN = 11.22F;
/*      */   public static final int AL_COMPRESSOR_MIN_ONOFF = 0;
/*      */   public static final int AL_COMPRESSOR_MAX_ONOFF = 1;
/*      */   public static final int AL_COMPRESSOR_DEFAULT_ONOFF = 1;
/*      */   public static final float AL_EQUALIZER_MIN_LOW_GAIN = 0.126F;
/*      */   public static final float AL_EQUALIZER_MAX_LOW_GAIN = 7.943F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_LOW_GAIN = 1.0F;
/*      */   public static final float AL_EQUALIZER_MIN_LOW_CUTOFF = 50.0F;
/*      */   public static final float AL_EQUALIZER_MAX_LOW_CUTOFF = 800.0F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_LOW_CUTOFF = 200.0F;
/*      */   public static final float AL_EQUALIZER_MIN_MID1_GAIN = 0.126F;
/*      */   public static final float AL_EQUALIZER_MAX_MID1_GAIN = 7.943F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_MID1_GAIN = 1.0F;
/*      */   public static final float AL_EQUALIZER_MIN_MID1_CENTER = 200.0F;
/*      */   public static final float AL_EQUALIZER_MAX_MID1_CENTER = 3000.0F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_MID1_CENTER = 500.0F;
/*      */   public static final float AL_EQUALIZER_MIN_MID1_WIDTH = 0.01F;
/*      */   public static final float AL_EQUALIZER_MAX_MID1_WIDTH = 1.0F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_MID1_WIDTH = 1.0F;
/*      */   public static final float AL_EQUALIZER_MIN_MID2_GAIN = 0.126F;
/*      */   public static final float AL_EQUALIZER_MAX_MID2_GAIN = 7.943F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_MID2_GAIN = 1.0F;
/*      */   public static final float AL_EQUALIZER_MIN_MID2_CENTER = 1000.0F;
/*      */   public static final float AL_EQUALIZER_MAX_MID2_CENTER = 8000.0F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_MID2_CENTER = 3000.0F;
/*      */   public static final float AL_EQUALIZER_MIN_MID2_WIDTH = 0.01F;
/*      */   public static final float AL_EQUALIZER_MAX_MID2_WIDTH = 1.0F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_MID2_WIDTH = 1.0F;
/*      */   public static final float AL_EQUALIZER_MIN_HIGH_GAIN = 0.126F;
/*      */   public static final float AL_EQUALIZER_MAX_HIGH_GAIN = 7.943F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_HIGH_GAIN = 1.0F;
/*      */   public static final float AL_EQUALIZER_MIN_HIGH_CUTOFF = 4000.0F;
/*      */   public static final float AL_EQUALIZER_MAX_HIGH_CUTOFF = 16000.0F;
/*      */   public static final float AL_EQUALIZER_DEFAULT_HIGH_CUTOFF = 6000.0F;
/*      */   public static final float AL_LOWPASS_MIN_GAIN = 0.0F;
/*      */   public static final float AL_LOWPASS_MAX_GAIN = 1.0F;
/*      */   public static final float AL_LOWPASS_DEFAULT_GAIN = 1.0F;
/*      */   public static final float AL_LOWPASS_MIN_GAINHF = 0.0F;
/*      */   public static final float AL_LOWPASS_MAX_GAINHF = 1.0F;
/*      */   public static final float AL_LOWPASS_DEFAULT_GAINHF = 1.0F;
/*      */   public static final float AL_HIGHPASS_MIN_GAIN = 0.0F;
/*      */   public static final float AL_HIGHPASS_MAX_GAIN = 1.0F;
/*      */   public static final float AL_HIGHPASS_DEFAULT_GAIN = 1.0F;
/*      */   public static final float AL_HIGHPASS_MIN_GAINLF = 0.0F;
/*      */   public static final float AL_HIGHPASS_MAX_GAINLF = 1.0F;
/*      */   public static final float AL_HIGHPASS_DEFAULT_GAINLF = 1.0F;
/*      */   public static final float AL_BANDPASS_MIN_GAIN = 0.0F;
/*      */   public static final float AL_BANDPASS_MAX_GAIN = 1.0F;
/*      */   public static final float AL_BANDPASS_DEFAULT_GAIN = 1.0F;
/*      */   public static final float AL_BANDPASS_MIN_GAINHF = 0.0F;
/*      */   public static final float AL_BANDPASS_MAX_GAINHF = 1.0F;
/*      */   public static final float AL_BANDPASS_DEFAULT_GAINHF = 1.0F;
/*      */   public static final float AL_BANDPASS_MIN_GAINLF = 0.0F;
/*      */   public static final float AL_BANDPASS_MAX_GAINLF = 1.0F;
/*      */   public static final float AL_BANDPASS_DEFAULT_GAINLF = 1.0F;
/*      */   
/*      */   protected EXTEfx() {
/*  649 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenEffects(int paramInt, long paramLong) {
/*  660 */     long l = (AL.getICD()).alGenEffects;
/*  661 */     if (Checks.CHECKS) {
/*  662 */       Checks.check(l);
/*      */     }
/*  664 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenEffects(@NativeType("ALuint *") IntBuffer paramIntBuffer) {
/*  674 */     nalGenEffects(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenEffects() {
/*      */     MemoryStack memoryStack;
/*  680 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  682 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  683 */       nalGenEffects(1, MemoryUtil.memAddress(intBuffer));
/*  684 */       return intBuffer.get(0);
/*      */     } finally {
/*  686 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteEffects(int paramInt, long paramLong) {
/*  698 */     long l = (AL.getICD()).alDeleteEffects;
/*  699 */     if (Checks.CHECKS) {
/*  700 */       Checks.check(l);
/*      */     }
/*  702 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteEffects(@NativeType("ALuint *") IntBuffer paramIntBuffer) {
/*  712 */     nalDeleteEffects(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteEffects(@NativeType("ALuint *") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  718 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  720 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/*  721 */       nalDeleteEffects(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/*  723 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsEffect(@NativeType("ALuint") int paramInt) {
/*  736 */     long l = (AL.getICD()).alIsEffect;
/*  737 */     if (Checks.CHECKS) {
/*  738 */       Checks.check(l);
/*      */     }
/*  740 */     return JNI.invokeZ(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffecti(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint") int paramInt3) {
/*  754 */     long l = (AL.getICD()).alEffecti;
/*  755 */     if (Checks.CHECKS) {
/*  756 */       Checks.check(l);
/*      */     }
/*  758 */     JNI.invokeV(paramInt1, paramInt2, paramInt3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalEffectiv(int paramInt1, int paramInt2, long paramLong) {
/*  765 */     long l = (AL.getICD()).alEffectiv;
/*  766 */     if (Checks.CHECKS) {
/*  767 */       Checks.check(l);
/*      */     }
/*  769 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint const *") IntBuffer paramIntBuffer) {
/*  781 */     if (Checks.CHECKS) {
/*  782 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  784 */     nalEffectiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat") float paramFloat) {
/*  798 */     long l = (AL.getICD()).alEffectf;
/*  799 */     if (Checks.CHECKS) {
/*  800 */       Checks.check(l);
/*      */     }
/*  802 */     JNI.invokeV(paramInt1, paramInt2, paramFloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalEffectfv(int paramInt1, int paramInt2, long paramLong) {
/*  809 */     long l = (AL.getICD()).alEffectfv;
/*  810 */     if (Checks.CHECKS) {
/*  811 */       Checks.check(l);
/*      */     }
/*  813 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat const *") FloatBuffer paramFloatBuffer) {
/*  825 */     if (Checks.CHECKS) {
/*  826 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  828 */     nalEffectfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetEffecti(int paramInt1, int paramInt2, long paramLong) {
/*  835 */     long l = (AL.getICD()).alGetEffecti;
/*  836 */     if (Checks.CHECKS) {
/*  837 */       Checks.check(l);
/*      */     }
/*  839 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffecti(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/*  851 */     if (Checks.CHECKS) {
/*  852 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  854 */     nalGetEffecti(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetEffecti(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  865 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  867 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  868 */       nalGetEffecti(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  869 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  871 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetEffectiv(int paramInt1, int paramInt2, long paramLong) {
/*  879 */     long l = (AL.getICD()).alGetEffectiv;
/*  880 */     if (Checks.CHECKS) {
/*  881 */       Checks.check(l);
/*      */     }
/*  883 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/*  895 */     if (Checks.CHECKS) {
/*  896 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  898 */     nalGetEffectiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetEffectf(int paramInt1, int paramInt2, long paramLong) {
/*  905 */     long l = (AL.getICD()).alGetEffectf;
/*  906 */     if (Checks.CHECKS) {
/*  907 */       Checks.check(l);
/*      */     }
/*  909 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/*  921 */     if (Checks.CHECKS) {
/*  922 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  924 */     nalGetEffectf(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetEffectf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  935 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  937 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  938 */       nalGetEffectf(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/*  939 */       return floatBuffer.get(0);
/*      */     } finally {
/*  941 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetEffectfv(int paramInt1, int paramInt2, long paramLong) {
/*  949 */     long l = (AL.getICD()).alGetEffectfv;
/*  950 */     if (Checks.CHECKS) {
/*  951 */       Checks.check(l);
/*      */     }
/*  953 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/*  965 */     if (Checks.CHECKS) {
/*  966 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  968 */     nalGetEffectfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenFilters(int paramInt, long paramLong) {
/*  979 */     long l = (AL.getICD()).alGenFilters;
/*  980 */     if (Checks.CHECKS) {
/*  981 */       Checks.check(l);
/*      */     }
/*  983 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenFilters(@NativeType("ALuint *") IntBuffer paramIntBuffer) {
/*  993 */     nalGenFilters(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenFilters() {
/*      */     MemoryStack memoryStack;
/*  999 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1001 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1002 */       nalGenFilters(1, MemoryUtil.memAddress(intBuffer));
/* 1003 */       return intBuffer.get(0);
/*      */     } finally {
/* 1005 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteFilters(int paramInt, long paramLong) {
/* 1017 */     long l = (AL.getICD()).alDeleteFilters;
/* 1018 */     if (Checks.CHECKS) {
/* 1019 */       Checks.check(l);
/*      */     }
/* 1021 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteFilters(@NativeType("ALuint *") IntBuffer paramIntBuffer) {
/* 1031 */     nalDeleteFilters(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteFilters(@NativeType("ALuint *") int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1037 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1039 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 1040 */       nalDeleteFilters(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 1042 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsFilter(@NativeType("ALuint") int paramInt) {
/* 1055 */     long l = (AL.getICD()).alIsFilter;
/* 1056 */     if (Checks.CHECKS) {
/* 1057 */       Checks.check(l);
/*      */     }
/* 1059 */     return JNI.invokeZ(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilteri(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint") int paramInt3) {
/* 1073 */     long l = (AL.getICD()).alFilteri;
/* 1074 */     if (Checks.CHECKS) {
/* 1075 */       Checks.check(l);
/*      */     }
/* 1077 */     JNI.invokeV(paramInt1, paramInt2, paramInt3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalFilteriv(int paramInt1, int paramInt2, long paramLong) {
/* 1084 */     long l = (AL.getICD()).alFilteriv;
/* 1085 */     if (Checks.CHECKS) {
/* 1086 */       Checks.check(l);
/*      */     }
/* 1088 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilteriv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint const *") IntBuffer paramIntBuffer) {
/* 1100 */     if (Checks.CHECKS) {
/* 1101 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1103 */     nalFilteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilterf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat") float paramFloat) {
/* 1117 */     long l = (AL.getICD()).alFilterf;
/* 1118 */     if (Checks.CHECKS) {
/* 1119 */       Checks.check(l);
/*      */     }
/* 1121 */     JNI.invokeV(paramInt1, paramInt2, paramFloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalFilterfv(int paramInt1, int paramInt2, long paramLong) {
/* 1128 */     long l = (AL.getICD()).alFilterfv;
/* 1129 */     if (Checks.CHECKS) {
/* 1130 */       Checks.check(l);
/*      */     }
/* 1132 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilterfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat const *") FloatBuffer paramFloatBuffer) {
/* 1144 */     if (Checks.CHECKS) {
/* 1145 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1147 */     nalFilterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFilteri(int paramInt1, int paramInt2, long paramLong) {
/* 1154 */     long l = (AL.getICD()).alGetFilteri;
/* 1155 */     if (Checks.CHECKS) {
/* 1156 */       Checks.check(l);
/*      */     }
/* 1158 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilteri(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/* 1170 */     if (Checks.CHECKS) {
/* 1171 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1173 */     nalGetFilteri(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetFilteri(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1184 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1186 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1187 */       nalGetFilteri(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1188 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1190 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFilteriv(int paramInt1, int paramInt2, long paramLong) {
/* 1198 */     long l = (AL.getICD()).alGetFilteriv;
/* 1199 */     if (Checks.CHECKS) {
/* 1200 */       Checks.check(l);
/*      */     }
/* 1202 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilteriv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/* 1214 */     if (Checks.CHECKS) {
/* 1215 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1217 */     nalGetFilteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFilterf(int paramInt1, int paramInt2, long paramLong) {
/* 1224 */     long l = (AL.getICD()).alGetFilterf;
/* 1225 */     if (Checks.CHECKS) {
/* 1226 */       Checks.check(l);
/*      */     }
/* 1228 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/* 1240 */     if (Checks.CHECKS) {
/* 1241 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1243 */     nalGetFilterf(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetFilterf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1254 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1256 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1257 */       nalGetFilterf(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 1258 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1260 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFilterfv(int paramInt1, int paramInt2, long paramLong) {
/* 1268 */     long l = (AL.getICD()).alGetFilterfv;
/* 1269 */     if (Checks.CHECKS) {
/* 1270 */       Checks.check(l);
/*      */     }
/* 1272 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/* 1284 */     if (Checks.CHECKS) {
/* 1285 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1287 */     nalGetFilterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenAuxiliaryEffectSlots(int paramInt, long paramLong) {
/* 1298 */     long l = (AL.getICD()).alGenAuxiliaryEffectSlots;
/* 1299 */     if (Checks.CHECKS) {
/* 1300 */       Checks.check(l);
/*      */     }
/* 1302 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenAuxiliaryEffectSlots(@NativeType("ALuint *") IntBuffer paramIntBuffer) {
/* 1312 */     nalGenAuxiliaryEffectSlots(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenAuxiliaryEffectSlots() {
/*      */     MemoryStack memoryStack;
/* 1318 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1320 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1321 */       nalGenAuxiliaryEffectSlots(1, MemoryUtil.memAddress(intBuffer));
/* 1322 */       return intBuffer.get(0);
/*      */     } finally {
/* 1324 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteAuxiliaryEffectSlots(int paramInt, long paramLong) {
/* 1336 */     long l = (AL.getICD()).alDeleteAuxiliaryEffectSlots;
/* 1337 */     if (Checks.CHECKS) {
/* 1338 */       Checks.check(l);
/*      */     }
/* 1340 */     JNI.invokePV(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteAuxiliaryEffectSlots(@NativeType("ALuint *") IntBuffer paramIntBuffer) {
/* 1350 */     nalDeleteAuxiliaryEffectSlots(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteAuxiliaryEffectSlots(@NativeType("ALuint *") int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1356 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1358 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 1359 */       nalDeleteAuxiliaryEffectSlots(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 1361 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsAuxiliaryEffectSlot(@NativeType("ALuint") int paramInt) {
/* 1374 */     long l = (AL.getICD()).alIsAuxiliaryEffectSlot;
/* 1375 */     if (Checks.CHECKS) {
/* 1376 */       Checks.check(l);
/*      */     }
/* 1378 */     return JNI.invokeZ(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSloti(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint") int paramInt3) {
/* 1392 */     long l = (AL.getICD()).alAuxiliaryEffectSloti;
/* 1393 */     if (Checks.CHECKS) {
/* 1394 */       Checks.check(l);
/*      */     }
/* 1396 */     JNI.invokeV(paramInt1, paramInt2, paramInt3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalAuxiliaryEffectSlotiv(int paramInt1, int paramInt2, long paramLong) {
/* 1403 */     long l = (AL.getICD()).alAuxiliaryEffectSlotiv;
/* 1404 */     if (Checks.CHECKS) {
/* 1405 */       Checks.check(l);
/*      */     }
/* 1407 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint const *") IntBuffer paramIntBuffer) {
/* 1419 */     if (Checks.CHECKS) {
/* 1420 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1422 */     nalAuxiliaryEffectSlotiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat") float paramFloat) {
/* 1436 */     long l = (AL.getICD()).alAuxiliaryEffectSlotf;
/* 1437 */     if (Checks.CHECKS) {
/* 1438 */       Checks.check(l);
/*      */     }
/* 1440 */     JNI.invokeV(paramInt1, paramInt2, paramFloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalAuxiliaryEffectSlotfv(int paramInt1, int paramInt2, long paramLong) {
/* 1447 */     long l = (AL.getICD()).alAuxiliaryEffectSlotfv;
/* 1448 */     if (Checks.CHECKS) {
/* 1449 */       Checks.check(l);
/*      */     }
/* 1451 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat const *") FloatBuffer paramFloatBuffer) {
/* 1463 */     if (Checks.CHECKS) {
/* 1464 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1466 */     nalAuxiliaryEffectSlotfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetAuxiliaryEffectSloti(int paramInt1, int paramInt2, long paramLong) {
/* 1473 */     long l = (AL.getICD()).alGetAuxiliaryEffectSloti;
/* 1474 */     if (Checks.CHECKS) {
/* 1475 */       Checks.check(l);
/*      */     }
/* 1477 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSloti(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/* 1489 */     if (Checks.CHECKS) {
/* 1490 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1492 */     nalGetAuxiliaryEffectSloti(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetAuxiliaryEffectSloti(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1503 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1505 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1506 */       nalGetAuxiliaryEffectSloti(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1507 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1509 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetAuxiliaryEffectSlotiv(int paramInt1, int paramInt2, long paramLong) {
/* 1517 */     long l = (AL.getICD()).alGetAuxiliaryEffectSlotiv;
/* 1518 */     if (Checks.CHECKS) {
/* 1519 */       Checks.check(l);
/*      */     }
/* 1521 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") IntBuffer paramIntBuffer) {
/* 1533 */     if (Checks.CHECKS) {
/* 1534 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1536 */     nalGetAuxiliaryEffectSlotiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetAuxiliaryEffectSlotf(int paramInt1, int paramInt2, long paramLong) {
/* 1543 */     long l = (AL.getICD()).alGetAuxiliaryEffectSlotf;
/* 1544 */     if (Checks.CHECKS) {
/* 1545 */       Checks.check(l);
/*      */     }
/* 1547 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/* 1559 */     if (Checks.CHECKS) {
/* 1560 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1562 */     nalGetAuxiliaryEffectSlotf(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetAuxiliaryEffectSlotf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1573 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1575 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1576 */       nalGetAuxiliaryEffectSlotf(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 1577 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1579 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetAuxiliaryEffectSlotfv(int paramInt1, int paramInt2, long paramLong) {
/* 1587 */     long l = (AL.getICD()).alGetAuxiliaryEffectSlotfv;
/* 1588 */     if (Checks.CHECKS) {
/* 1589 */       Checks.check(l);
/*      */     }
/* 1591 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") FloatBuffer paramFloatBuffer) {
/* 1603 */     if (Checks.CHECKS) {
/* 1604 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1606 */     nalGetAuxiliaryEffectSlotfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenEffects(@NativeType("ALuint *") int[] paramArrayOfint) {
/* 1612 */     long l = (AL.getICD()).alGenEffects;
/* 1613 */     if (Checks.CHECKS) {
/* 1614 */       Checks.check(l);
/*      */     }
/* 1616 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteEffects(@NativeType("ALuint *") int[] paramArrayOfint) {
/* 1622 */     long l = (AL.getICD()).alDeleteEffects;
/* 1623 */     if (Checks.CHECKS) {
/* 1624 */       Checks.check(l);
/*      */     }
/* 1626 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint const *") int[] paramArrayOfint) {
/* 1632 */     long l = (AL.getICD()).alEffectiv;
/* 1633 */     if (Checks.CHECKS) {
/* 1634 */       Checks.check(l);
/* 1635 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1637 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEffectfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat const *") float[] paramArrayOffloat) {
/* 1643 */     long l = (AL.getICD()).alEffectfv;
/* 1644 */     if (Checks.CHECKS) {
/* 1645 */       Checks.check(l);
/* 1646 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1648 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffecti(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") int[] paramArrayOfint) {
/* 1654 */     long l = (AL.getICD()).alGetEffecti;
/* 1655 */     if (Checks.CHECKS) {
/* 1656 */       Checks.check(l);
/* 1657 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1659 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") int[] paramArrayOfint) {
/* 1665 */     long l = (AL.getICD()).alGetEffectiv;
/* 1666 */     if (Checks.CHECKS) {
/* 1667 */       Checks.check(l);
/* 1668 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1670 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 1676 */     long l = (AL.getICD()).alGetEffectf;
/* 1677 */     if (Checks.CHECKS) {
/* 1678 */       Checks.check(l);
/* 1679 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1681 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetEffectfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 1687 */     long l = (AL.getICD()).alGetEffectfv;
/* 1688 */     if (Checks.CHECKS) {
/* 1689 */       Checks.check(l);
/* 1690 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1692 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenFilters(@NativeType("ALuint *") int[] paramArrayOfint) {
/* 1698 */     long l = (AL.getICD()).alGenFilters;
/* 1699 */     if (Checks.CHECKS) {
/* 1700 */       Checks.check(l);
/*      */     }
/* 1702 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteFilters(@NativeType("ALuint *") int[] paramArrayOfint) {
/* 1708 */     long l = (AL.getICD()).alDeleteFilters;
/* 1709 */     if (Checks.CHECKS) {
/* 1710 */       Checks.check(l);
/*      */     }
/* 1712 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilteriv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint const *") int[] paramArrayOfint) {
/* 1718 */     long l = (AL.getICD()).alFilteriv;
/* 1719 */     if (Checks.CHECKS) {
/* 1720 */       Checks.check(l);
/* 1721 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1723 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alFilterfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat const *") float[] paramArrayOffloat) {
/* 1729 */     long l = (AL.getICD()).alFilterfv;
/* 1730 */     if (Checks.CHECKS) {
/* 1731 */       Checks.check(l);
/* 1732 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1734 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilteri(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") int[] paramArrayOfint) {
/* 1740 */     long l = (AL.getICD()).alGetFilteri;
/* 1741 */     if (Checks.CHECKS) {
/* 1742 */       Checks.check(l);
/* 1743 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1745 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilteriv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") int[] paramArrayOfint) {
/* 1751 */     long l = (AL.getICD()).alGetFilteriv;
/* 1752 */     if (Checks.CHECKS) {
/* 1753 */       Checks.check(l);
/* 1754 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1756 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 1762 */     long l = (AL.getICD()).alGetFilterf;
/* 1763 */     if (Checks.CHECKS) {
/* 1764 */       Checks.check(l);
/* 1765 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1767 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFilterfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 1773 */     long l = (AL.getICD()).alGetFilterfv;
/* 1774 */     if (Checks.CHECKS) {
/* 1775 */       Checks.check(l);
/* 1776 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1778 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenAuxiliaryEffectSlots(@NativeType("ALuint *") int[] paramArrayOfint) {
/* 1784 */     long l = (AL.getICD()).alGenAuxiliaryEffectSlots;
/* 1785 */     if (Checks.CHECKS) {
/* 1786 */       Checks.check(l);
/*      */     }
/* 1788 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteAuxiliaryEffectSlots(@NativeType("ALuint *") int[] paramArrayOfint) {
/* 1794 */     long l = (AL.getICD()).alDeleteAuxiliaryEffectSlots;
/* 1795 */     if (Checks.CHECKS) {
/* 1796 */       Checks.check(l);
/*      */     }
/* 1798 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint const *") int[] paramArrayOfint) {
/* 1804 */     long l = (AL.getICD()).alAuxiliaryEffectSlotiv;
/* 1805 */     if (Checks.CHECKS) {
/* 1806 */       Checks.check(l);
/* 1807 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1809 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alAuxiliaryEffectSlotfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat const *") float[] paramArrayOffloat) {
/* 1815 */     long l = (AL.getICD()).alAuxiliaryEffectSlotfv;
/* 1816 */     if (Checks.CHECKS) {
/* 1817 */       Checks.check(l);
/* 1818 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1820 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSloti(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") int[] paramArrayOfint) {
/* 1826 */     long l = (AL.getICD()).alGetAuxiliaryEffectSloti;
/* 1827 */     if (Checks.CHECKS) {
/* 1828 */       Checks.check(l);
/* 1829 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1831 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotiv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALint *") int[] paramArrayOfint) {
/* 1837 */     long l = (AL.getICD()).alGetAuxiliaryEffectSlotiv;
/* 1838 */     if (Checks.CHECKS) {
/* 1839 */       Checks.check(l);
/* 1840 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1842 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotf(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 1848 */     long l = (AL.getICD()).alGetAuxiliaryEffectSlotf;
/* 1849 */     if (Checks.CHECKS) {
/* 1850 */       Checks.check(l);
/* 1851 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1853 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetAuxiliaryEffectSlotfv(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALfloat *") float[] paramArrayOffloat) {
/* 1859 */     long l = (AL.getICD()).alGetAuxiliaryEffectSlotfv;
/* 1860 */     if (Checks.CHECKS) {
/* 1861 */       Checks.check(l);
/* 1862 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1864 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\EXTEfx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */