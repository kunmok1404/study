package api.generic;

public class Test01 {
	public static void main(String[] args) {
		
		//Data d = new Data();
		//Data<Object> d = new Data<Object>();
		Data<Object> d = new Data<>();
		d.value = 10;
		
		Data<String> s = new Data<>();
		s.value = "hello";
		System.out.println(s.value);
		
		// int를 저장할 수 있는 data
		
	}
}
