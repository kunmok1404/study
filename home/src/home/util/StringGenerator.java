package home.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 문자열 생성 도우미
public class StringGenerator {
	public static String random(int size) {
		List<String> list = new ArrayList<>();
		for(char i='A'; i <= 'Z'; i++)	list.add(String.valueOf(i));
		for(char i='a'; i <= 'z'; i++)	list.add(String.valueOf(i));
		for(char i='0'; i <= '9'; i++)	list.add(String.valueOf(i));
		
		Random r = new Random();
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i < size; i++) {
			int index = r.nextInt(list.size());
			buffer.append(list.get(index));
		}
		String str = buffer.toString();
		return str;
	}
}
