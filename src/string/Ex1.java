package string;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * StringBuilder & StringBuffer
		 * 
		 * - StringBuffer	: 문자열이 안전하게 변경되도록 보장 (O) (멀티쓰레드 적합)
		 * - StringBuilder	: 문자열이 안전하게 변경되도록 보장 (X) (싱글쓰레드 적합)
		 *   (멀티 쓰레드 프로그램이 아니라면 StringBuilder 속도가 좀더 빠름)
		 * */
		String javaStr = new String("Java");
		// System.identityHashCode() 인스턴스가 처음 생성되었을때 메모리 주소
		System.out.println("javaStr 문자열 주소: " + System.identityHashCode(javaStr));
		
		javaStr += " Programming";
		System.out.println("javaStr 문자열 주소: " + System.identityHashCode(javaStr));
		
		StringBuilder builder = new StringBuilder("Java");
		System.out.println("연산 전 builder 메모리 주소: " + System.identityHashCode(builder));
		builder.append(" and");
		System.out.println("연산 후 builder 메모리 주소: " + System.identityHashCode(builder));
		builder.append(" android");
		System.out.println("연산 후 builder 메모리 주소: " + System.identityHashCode(builder));
		builder.append(" programming is fun!!");
		System.out.println("연산 후 builder 메모리 주소: " + System.identityHashCode(builder));
		
		System.out.println("---------------------------------------------------");
		
		String str1 = "abc";		// abc
		String str2 = str1 + "de";	// abcde
		String str3 = "abc";		// abc
		String str4 = "a" + "bc";	// abc
		String str5 = "a";			
		String str6 = str5 + "bc";	// abc
		str5 += "bc";				// abc
		
		System.out.println("str1: " + System.identityHashCode(str1));
		System.out.println("str2: " + System.identityHashCode(str2));
		System.out.println("str3: " + System.identityHashCode(str3));
		System.out.println("str4: " + System.identityHashCode(str4));
		System.out.println("str5: " + System.identityHashCode(str5));
		System.out.println("str6: " + System.identityHashCode(str6));
		
		
		
		
		
		
		
		
		
		
		
	}

}
