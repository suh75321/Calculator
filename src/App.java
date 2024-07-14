import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(); // 앱 실행시 새 계산기 생성

        //계산기가 아니라 그 자식들과 연결
        ArithmeticCalculator ac = new ArithmeticCalculator();
        CircleCalculator cc = new CircleCalculator();

        Scanner sc = new Scanner(System.in);

        // jcf는 list, set, map이 있는데 list 사용
        // ArrayList<Integer> resultList = new ArrayList<>(); // getter 사용으로 계산기와 연결되기에 이젠 이건 사용안함

        while (true) { // 반복을 시작하기위해 추가
            System.out.println("원하는 연산을 선택하세요: 1. 사칙연산, 2. 원의 넓이 계산");
            int choice = sc.nextInt();

            try { // 틀려도 종료되지 않기 위해 이거 전체를 try catch로 감싸기 그래서 하나씩 감싼것도 없앴다.
                if (choice == 1) {//사칙연산을 할지 원의 넓이를 정할지를 선택 가능한 숫자 입력 방식
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    int num1 = sc.nextInt();

                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char operator = sc.next().charAt(0); // 사칙연산은 한글자니 char, 연산자는 operator를 써야한다.

                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int num2 = sc.nextInt();

//                    int result = calculator.calculate(num1, num2, operator); // 계산기에 접속해 계산
                    double result = ac.calculate(num1, num2, operator);//더블로 바꾸고 계산기 대신 ac에 연결
                    System.out.println("결과: " + result);
                    ArrayList<Double> resultList = ac.getResultList(); // getter로 계산기와 연결
                    System.out.println("현재 저장된 결과의 수: " + resultList.size());

                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? 아니면 결과들을 보시겠습니까? (remove 입력 시 삭제, inquiry 입력시 결과 출력)");
                    String text = sc.next(); // 위에 안내문 수정


                    if (Objects.equals(text, "remove")) { // remove 중복 수정
                        ac.removeResult();// 계산기 대신 ac에 연결
//                        calculator.removeResult(); // calculator랑 연결해서 간결해짐
                        System.out.println("첫번째 결과가 삭제되었습니다.");


                    } else if (Objects.equals(text, "inquiry")) {
                        resultList = ac.getResultList();//계산기 대신 ac에 연결
//                        resultList = calculator.inquiryResults();//마찬가지로 calculator랑 연결해서 간결해짐
                        if (!resultList.isEmpty()) {
                            System.out.println("저장된 연산 결과:");
                            resultList.forEach(System.out::println);
                        } else {
                            System.out.println("저장된 결과가 없습니다.");
                        }
                    }
                } else if (choice == 2) {
                    System.out.print("원의 반지름을 입력하세요: ");
                    double radius = sc.nextDouble();//입력된 반지름을 radius에 저장
                    double area = cc.calculateCircleArea(radius);//계산기 대신 cc에 연결

//                    double area = calculator.calculateCircleArea(radius);//calculateCircleArea(radius) 메서드를 호출하여 원의 넓이를 계산하고,
                    // 그 결과를 area라는 변수에 저장
                    System.out.println("계산된 원의 넓이: " + area);//area를 호출

                    ArrayList<Double> circleAreaList = cc.getResultList();//계산기 대신 cc에 연결

//                    ArrayList<Double> circleAreaList = calculator.getCircleAreaList();//getter을 사용해서 넓이가 저장된 리스트를 가져옴
                    System.out.println("저장된 원의 넓이 값들: " + circleAreaList);//이걸로 inquiry없이 바로 전체 조회 가능
                }

                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String text = sc.next();
                if (Objects.equals(text, "exit")) {
                    break;
                }
            } catch(InputMismatchException e){
                System.out.println("잘못된 입력입니다. 숫자를 입력하거나 올바른 명령어를 입력해주세요.");
                sc.next(); // 이걸로 틀린거 입력시에도 다시 입력가능
            }
        }
    }
}


