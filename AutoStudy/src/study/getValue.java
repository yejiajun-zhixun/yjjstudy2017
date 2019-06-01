package study;

public class getValue {
	public static int getValue(int i){
		int s=0;
		i=2;
		switch(i){
		case 1:
			s=s+i;
		case 2:
			s=s+i*2;
		case 3:
			s=s+i*3;
		}
		return s;
	}
}


