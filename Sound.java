import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

public class Sound implements Runnable{
	boolean[] keys;
	boolean active;
	int key;

	public Sound () {
		active = true;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public void generate(int key) {
		
		
		try {
			byte[] buf = new byte[1];
			float sampleRate = (float)44100;
			float a = 100; //peak amplitude
			double t = 0.2; //cycle rate
		    AudioFormat af = new AudioFormat(sampleRate, 8, 1, true, false );
		    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		    sdl.open();
		    sdl.start();
		    float note = (float) key / 20;
		    
		    while(active) {
			    for(int f = 0; f < sampleRate * t; f++) {
			        double phase = f * 2 * Math.PI * 440 * note / sampleRate;
			        // double phase = f * Math.pow(2.0, ((key-40)/12)) * 440;
			        if (phase > 2 * Math.PI) phase -= 2 * Math.PI;
	//		        buf[0] = sinWave(phase, a);
	//		        buf[0] = squareWave(phase, a);
	//		        buf[0] = sawtoothWave(phase, a);
			        buf[0] = sinWave(phase, a);
			        sdl.write(buf, 0, 1);
			    }
			    Thread.sleep(200);
		    }
		    sdl.drain();
		    sdl.stop();
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public byte sinWave(double phase, float a) {
		return (byte)(Math.sin(phase) * a);
	}
	
	public byte squareWave(double phase, float a) {
		return (byte)((phase < Math.PI) ? a : -a);
	}
	
	public byte sawtoothWave(double phase, float a) {
		return (byte)(a - a / Math.PI * phase);
	}
	
	public byte triangleWave(double phase, float a) {
		return (byte)((phase < Math.PI) ? -a + (2 * a / Math.PI) / phase :
										  3 * a - (2 * a / Math.PI) / phase);
	}
	
	public void release(int key) {

	}

	@Override
	public void run() {
		generate(key);
	}
	
	
	
}
