package ���ű�;

public class Logic2 {

	public static void main(String[] args) {
		/*boolean z = true, l = true, w = true;
		if (((z && !l) || (!z && l)) && ((w && !l) || (!w && l)) && (((w && (!z && !l)) || ((z || l) && !w)))) {

		}*/
		for (int i = 0; i < 8; i++) {
			boolean p[] = { false, false, false };
			//p[i] = true;
			
			if (((p[0] && !p[1]) || (!p[0] && p[1])) && ((p[2] && !p[1]) || (!p[2] && p[1]))
					&& (((p[2] && (!p[0] && !p[1])) || ((p[0] || p[1]) && !p[2])))) {
			}
		}

	}

}
