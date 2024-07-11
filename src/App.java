import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 int 타입의 변수 num1에 저장합니다.

        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);// 사칙연산은 한글자니 char, 연산자는 operator를 써야한다.
        //charAt(0) 메서드는 문자열에서 첫 번째 문자를 추출하는 역할을 한다.사용자가 "+" 문자열을 입력하면 sc.next()는 "+" 문자열을 반환하고, charAt(0)은 이 문자열의 첫 번째 문자인 '+'를 추출하고 이렇게 추출된 문자는 char 타입으로 처리된다.

        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 int 타입의 변수 num2에 저장합니다.
    }
}
