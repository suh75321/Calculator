import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //jcf는 list, set, map이 있는데 list 사용
        ArrayList<Integer> resultList = new ArrayList<>();//이건 크기가 정해지지 않아서 맘대로 추가, 삭제 가능
//        int[] intArray = new int[10];
        // 배열의 마지막 인덱스를 저장하는 변수를 선언합니다.
        int index = 0;

        while (true) {//반복을 시작하기위해 추가
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




//            if (index < intArray.length) {//이걸로 인트어레이가 인덱스보다 많은지 검사
//                intArray[index] = result;//이 문장은 연산의 결과를 intArray의 index 위치에 저장 예를 들어, index가 0이면, result는 배열의 첫 번째 위치에 저장
//                index++;//저장하면 1증가
//                System.out.println("현재 저장된 결과의 수: " + index);//얼마나 저장했는지 보여줌
//            } else {
//                System.out.println("저장 공간이 차서 첫번째 결과값을 지우고 이번 결과 값을 넣었습니다.");//그냥 안내용
//
//                for (int i = 0; i < intArray.length - 1; i++) {
//                    intArray[i] = intArray[i + 1];//10개다 차면 -1하고 뒤에게 앞으로 한칸씩 이동
//                }
//                intArray[intArray.length - 1] = result;//마지막 배열에 현재 결과값 입력
//            }

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String text = sc.next();//밑에 있던걸 옮긴거뿐
            if (Objects.equals(text, "remove")) {
                if (!resultList.isEmpty()) {//결과가 비었는지 확인
                    resultList.remove(0);//차있으면 첫번째(0)를 삭제
                    System.out.println("첫번째 결과가 삭제되었습니다.");
                } else {
                    System.out.println("저장된 결과가 없습니다.");
                }
            } else {
                resultList.add(result);
                System.out.println("현재 저장된 결과의 수: " + resultList.size());
            }

            //반복의 끝의 시작
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            /* exit을 입력 받으면 반복 종료 */
            if (Objects.equals(text, "exit")) {
                break;// 반복의 끝
            }
        }
    }
}