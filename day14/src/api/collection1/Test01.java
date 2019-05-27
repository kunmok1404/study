package api.collection1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class Test01 {
	public static void main(String[] args) {
		
		// JCF(Java Collection Framework)
		// -�ڹ��� ��뷮 �����
		// - �迭�� ũ�Ⱑ ������ �ݸ� Collection �� ũ�Ⱑ ����
		// - ����ҿ� ���� ���� ������ ���� ����� �ٸ�
		
		// -Set�� LIst �� ���з��� ����
		
		// TreeSet�� ArrayList�� ��
		Collection<String> a = new TreeSet<>();
		Collection<String> b = new ArrayList<>();
		
		// �߰�
		a.add("����");		b.add("����");
		a.add("����");		b.add("����");
		a.add("�嵿��");	b.add("�嵿��");
		a.add("������");	b.add("������");
		a.add("����");		b.add("����");
		
		// ���
		System.out.println(a);
		System.out.println(b);
	}
}
