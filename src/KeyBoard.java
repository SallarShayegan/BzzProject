
public class KeyBoard {

	private boolean activeKey[] = new boolean[46];
	
	public void activateKey(int key) {
		activeKey[key] = true;
	}

	public void deactivateKey(int key) {
		activeKey[key] = false;
	}

	public boolean isActive(int key) {
		return activeKey[key];
	}
	
	public int getKeyInteger(char c) {
		c = Character.toLowerCase(c);
		int code;
		switch(c) {
			case 'y':
				code = 1;
				break;
			case 'x':
				code = 2;
				break;
			case 'c':
				code = 3;
				break;
			case 'v':
				code = 4;
				break;
			case 'b':
				code = 5;
				break;
			case 'n':
				code = 6;
				break;
			case 'm':
				code = 7;
				break;
			case ',':
				code = 8;
				break;
			case '.':
				code = 9;
				break;
			case '-':
				code = 10;
				break;
			case 'a':
				code = 11;
				break;
			case 's':
				code = 12;
				break;
			case 'd':
				code = 13;
				break;
			case 'f':
				code = 14;
				break;
			case 'g':
				code = 15;
				break;
			case 'h':
				code = 16;
				break;
			case 'j':
				code = 17;
				break;
			case 'k':
				code = 18;
				break;
			case 'l':
				code = 19;
				break;
			case 'ö':
				code = 20;
				break;
			case 'ä':
				code = 21;
				break;
			case '#':
				code = 22;
				break;
			case 'q':
				code = 23;
				break;
			case 'w':
				code = 24;
				break;
			case 'e':
				code = 25;
				break;
			case 'r':
				code = 26;
				break;
			case 't':
				code = 27;
				break;
			case 'z':
				code = 28;
				break;
			case 'u':
				code = 29;
				break;
			case 'i':
				code = 30;
				break;
			case 'o':
				code = 31;
				break;
			case 'p':
				code = 32;
				break;
			case 'ü':
				code = 33;
				break;
			case '+':
				code = 34;
				break;
			case '1':
				code = 35;
				break;
			case '2':
				code = 36;
				break;
			case '3':
				code = 37;
				break;
			case '4':
				code = 38;
				break;
			case '5':
				code = 39;
				break;
			case '6':
				code = 40;
				break;
			case '7':
				code = 41;
				break;
			case '8':
				code = 42;
				break;
			case '9':
				code = 43;
				break;
			case '0':
				code = 44;
				break;
			case 'ß':
				code = 45;
				break;
			case '´':
				code = 46;
				break;
			default:
				code = 0;
		}
		return code;
	}
	
}
