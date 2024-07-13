import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();// 계산기와 연결
        Scanner sc = new Scanner(System.in);

        //jcf는 list, set, map이 있는데 list 사용
//        ArrayList<Integer> resultList = new ArrayList<>(); getter 사용으로 계산기와 연결되기에 이젠 이건 사용안함
        int index = 0;

        while (true) {//반복을 시작하기위해 추가
            try {// 틀려도 종료되지 않기 위해 이거 전체를 try catch로 감싸기 그래서 하나씩 감싼것도 없앴다.
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);// 사칙연산은 한글자니 char, 연산자는 operator를 써야한다.
                //charAt(0) 메서드는 문자열에서 첫 번째 문자를 추출하는 역할을 한다.사용자가 "+" 문자열을 입력하면
                // sc.next()는 "+" 문자열을 반환하고, charAt(0)은 이 문자열의 첫 번째 문자인 '+'를 추출하고 이렇게 추출된
                // 문자는 char 타입으로 처리된다.

                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();

                int result = calculator.calculate(num1, num2, operator);// 계산기에 접속해 계산

                // 결과를 위로 옮긴 이유는, 밑으로 하니까 inquiry 입력시 최근걸 저장하기전에 출력을 해서 바로 전 결과물은 출력을 못해서 먼저 자장하도록 옮김
                System.out.println("결과: " + result);
                ArrayList<Integer> resultList = calculator.getResultList();//getter로 계산기와 연결
                System.out.println("현재 저장된 결과의 수: " + resultList.size());

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? 아니면 결과들을 보시겠습니까? (remove 입력 시 삭제, inquiry 입력시 결과 출력)");
                String text = sc.next();//위에 안내문 수정
                if (Objects.equals(text, "remove")) {
                    if (!resultList.isEmpty()) {//결과가 비었는지 확인
                        resultList.remove(0);//차있으면 첫번째(0)를 삭제
                        System.out.println("첫번째 결과가 삭제되었습니다.");
                    } else {
                        System.out.println("저장된 결과가 없습니다.");
                    }
                } else if (Objects.equals(text, "inquiry")) {//remove처럼 똑같이 입력 가능 비어있지 않으면 결과출력
                    if (!resultList.isEmpty()) {
                        System.out.println("저장된 연산 결과:");
                        resultList.forEach(System.out::println);//향상된 for인 foreach 사용
                    } else {
                        System.out.println("저장된 결과가 없습니다.");
                    }
                }

                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                text = sc.next();
                if (Objects.equals(text, "exit")) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하거나 올바른 명령어를 입력해주세요.");
                sc.next();// 이걸로 틀린거 입력시에도 다시 입력가능
            }
        }
    }
}