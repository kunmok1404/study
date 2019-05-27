package api.util.etc;

import java.text.DecimalFormat;
import java.text.Format;

public class Test07 {
	public static void main(String[] args) {
		
		// 숫자 형식 제어 : DecimalFormat
		// 0 숫자가 있으면 찍고 없으면 0으로 찍고
		// #	숫자가 있으면 찍고 없으면 말고
		
		int n = 100;
		//DecimalFormat f = new DecimalFormat("");
		Format f = new DecimalFormat("000000");
		System.out.println(f.format(n));
		
		double v = 1234.56789;
		double a = 123456789;
		//Format f2 = new DecimalFormat("0000.00");
		//Format f2 = new DecimalFormat("####.##");
		//Format f2 = new DecimalFormat("#.00");
		Format f2 = new DecimalFormat("#,###.00");
		System.out.println(f2.format(v));
		System.out.println(f2.format(n));
		System.out.println(f2.format(a));
	}
}
