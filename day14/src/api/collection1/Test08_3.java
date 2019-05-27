package api.collection1;

public class Test08_3 {
	public static void main(String[] args) {
		
		// 한장 뽑는거 
		//System.out.println(CardGenerator.getCard());
		
		// 카드 여러장 뽑는거
		//System.out.println(CardGenerator.getCard());
		System.out.println(CardGenerator.getCard(10));
		System.out.println(CardGenerator.getCard(CardGenerator.All));
	}
}
