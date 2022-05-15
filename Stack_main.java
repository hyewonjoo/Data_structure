package Stack;

public class main {

	public static void main(String[] args) {

		ArrayStack arrayStack = new ArrayStack(4);


		System.out.println(arrayStack.push("a"));
		System.out.println(arrayStack.push("b"));
		System.out.println(arrayStack.push("c"));
		System.out.println(arrayStack.push("d"));
		System.out.println("데이터를 성공적으로 삽입하였습니다.");
		// d
		// c
		// b
		// a

		System.out.printf("Pop된 데이터 %s\n", arrayStack.pop()); // d
		System.out.printf("Peak된 데이터 %s\n", arrayStack.peek()); // c


		System.out.printf("Pop된 데이터 %s\n", arrayStack.pop()); // c
		System.out.printf("Peak된 데이터 %s\n", arrayStack.peek()); // b


		System.out.println("데이터를 하나 삽입합니다.");
		System.out.println(arrayStack.push("e"));
		// e
		// b
		// a

		System.out.printf("Peak된 데이터 %s\n", arrayStack.peek()); // e

	}
}
