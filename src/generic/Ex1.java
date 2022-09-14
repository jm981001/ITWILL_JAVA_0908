package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 제네릭 (Generic, 일반화)
		 * - 객체에서 사용할 데이터타입을 클래스 정의 시 미리 명시하지 않고
		 *   실제 객체 생성 시 데이터타입을 지정하여 사용하도록 하는 기법
		 *   => 객체를 생성할 때마다 각각 다른 데이터타입으로 사용 가능함
		 *   => 데이터타입을 지정 시 반드시 참조데이터타입만 지정 가능함 (기본형 사용 불가)
		 *      ex) int(X) -> Integer
		 * - 데이터를 저장하는 시점에서 미리 저장 데이터에 대한 타입을 판별 가능하므로
		 *   데이터 저장시점에서 안정성을 향상시키고,
		 *   데이터를 꺼내는 시점에서 지정된 데이터타입만 저장된다는 보장이 생기므로
		 *   별도의 판별이나 형번환 없이 해당 타입 그대로 사용 가능하게 된다!     
		 * - 주로, Collection API 들은 대부분 제내릭 타입으로 클래스가 설계되어 있음  
		 * - 만약, 제네릭 타입 지정을 생략하는 경우 모든 데이터타입은 Object로 고정됨   
		 * */
		
		// Collection Framework API의 객체들은 파라미터로 Object 타입을 주로 사용
		List list = new ArrayList();
		
		// Object 타입 파라미터를 갖는 add() 메서드는 어떤 데이터타입도 모두 추가 가능
		// 데이터를 추가하는 시점에서는 매우 편리함
		list.add(1);
		list.add("TWO");
		list.add(3.14);
		
		for(int i = 0; i < list.size(); i++) {
//			int data = list.get(i); // 컴파일 오류 발생! (Object 타입 리턴 시 int 타입에 저장 불가)
//			int data = (int)list.get(i); // 런타입 오류발생!
			// => 첫번째 데이터는 정수이므로 int형으로 변환 가능하지만,
			//    두번째 데이터는 문자열이므로 int형으로 변환이 불가능함
			
			// 모든 데이터타입을 구분없이 저장하기 위해서는 Object 타입 변수 필요함
			Object data = list.get(i); // 형변환이 불필요
//			System.out.println(data);
			// => 하나의 변수에 모든 타입을 저장 가능한 장점이 있지만
			//    저장된 데이터를 활용하여 작업을 수행하는 경우
			//    각 타입이 달라서 문제가 발생할 가능성이 있다!
			
			// 만약, 어떤 문제도 발생하지 않도록 각 데이터타입에 맞는 변수에 저장하려면
			// 데이터를 꺼낼 때 타입 판별을 통해 알맞은 타입으로 저장해야한다!
			// => instanceof 연산자를 사용하여 각 타입 판별 후 변수에 저장
			//    각 타입으로 저장할 때 Object -> 각 타입으로 강제형변환이 필수!
			if(data instanceof Integer) {
				
				int iData = (int)data;
				System.out.println(iData);
				
			} else if(data instanceof String) {
				
				String strData = (String)data;
				System.out.println(strData);
				
			} else if(data instanceof Double) {
				
				double dData = (double)data;
				System.out.println(dData);
				
			}
			
			// => Object 타입을 사용하여 데이터를 저장하는 경우
			//    저장 시점에서는 데이터 타입 구분이 필요없으므로 편리하지만
			//    실제 데이터를 사용하는 시점에서는 데이터타입이 달라서 문제가 발생할 수 있음
			// => 또한, 각 데이터타입 변수에 저장할 때는 추가적으로 형변환이 필요함
			
		}
		
		
		System.out.println("======================================================");
		
		// 제네릭 타입을 지정하여 Collection Framwork 객체들을 사용할 수 있다!
		// => 객체 생성 시점에서 저장될(사용될) 데이터 타입을 지정하면
		//    해당 데이터타입만 사용 가능하도록 변경됨
		// => 클래스명 뒤에 <> 기호를 명시하고, 기호 사이에 사용할 데이터타입을 지정
		//    단, 데이터타입은 반드시 참조형 데이터타입만 지정 가능! (기본형 사용 불가)
		
		List<Integer> list2 = new ArrayList<Integer>();
		
		list2.add(1);
//		list2.add("TWO");
//		list2.add(3.14);
		list2.add(2);
		list2.add(3);
		
		for(int i=0; i<list.size(); i++) {
			int data = list2.get(i);
			System.out.println(data);
		}
		
		for(int data : list2) {
			System.out.println(data);
		}
		
		System.out.println("---------------------------------");
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "홍길동");
//		map.put(2, 10);
//		map.put("강감찬", "빅마우스");
		
		
	}

}

