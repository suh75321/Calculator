import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1;
        try {
            num1 = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            return;
        }

        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);// 사칙연산은 한글자니 char, 연산자는 operator를 써야한다.
        //charAt(0) 메서드는 문자열에서 첫 번째 문자를 추출하는 역할을 한다.사용자가 "+" 문자열을 입력하면 sc.next()는 "+" 문자열을 반환하고, charAt(0)은 이 문자열의 첫 번째 문자인 '+'를 추출하고 이렇게 추출된 문자는 char 타입으로 처리된다.


        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2;
        try {
            num2 = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            return;
        }//InputMismatchException으로 한 이유는 숫자를 안넣었을때 뜨는에러가 InputMismatch였기 때문이다.

        int result = 0;//==인 이유는 char을 쓰면 이퀄이 작동하지 않아 바꿀수밖에 없었다.
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");//이걸로 두번째 숫자가 0이면 나누기가 안되게 설정
                return;
            }
            result = num1 / num2;
        } else {
            System.out.println("잘못된 연산자입니다.");
            return;
        }

        System.out.println("결과: " + result);
    }
}