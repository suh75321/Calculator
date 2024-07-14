import java.util.HashMap;
import java.util.Map;

public class ArithmeticCalculator extends Calculator {
    private final Map<Character, Operator> operators;//final 키워드로 선언되어 있어 operators는 변하지 않음
    //연산자와 해당 연산을 수행하는 Operator를 매핑하는데 이제 새 연산을 추가할때, 해당 클래스를 만들고 Operator랑 연결하면 되서
    //기능을 쉽게 추가할 수 있으며, 소스 코드의 변경은 최소화되는데 그게 OCP

    public ArithmeticCalculator() {
        this.operators = new HashMap<>();
        this.operators.put('+', new AddOperator());
        this.operators.put('-', new SubtractOperator());
        this.operators.put('*', new MultiplyOperator());
        this.operators.put('/', new DivideOperator());
        this.operators.put('%', new ModOperator());
    }//this를 통해서 operator와 각 클래스랑 연결되고 HashMap이 키와 값으로 이뤄어진걸 연산자를 키로 해서 -를 입력했을때
    //SubtractOperator와 연결되어 두 값을 -하는식으로 쓰인다

    public double calculate(int num1, int num2, char operator) throws IllegalArgumentException {
        Operator op = operators.get(operator);
        if (op == null) {
            throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
        double result = op.operate(num1, num2);
        addResult(result);
        return result;// 입력이 들어오면 맵에서 입력된 연산자에 해당하는 객체를 찿고 연산자가 없다면, 즉 op가 null이라면
        //예외를, 있으면 연산을 수행하고, 그 결과를 result에 저장하고 addResult(result)를 호출하여 결과를 resultList에 추가
    }
}





//    //private을 통해 새로 추가한 개체들이 ArithmeticCalculator에만 접근 가능하게 하고
//    private AddOperator addOperator;
//    private SubtractOperator subtractOperator;
//    private MultiplyOperator multiplyOperator;
//    private DivideOperator divideOperator;
//
//    public ArithmeticCalculator() {
//        this.addOperator = new AddOperator();
//        this.subtractOperator = new SubtractOperator();
//        this.multiplyOperator = new MultiplyOperator();
//        this.divideOperator = new DivideOperator();
//    }//이제 ArithmeticCalculator 객체가 생성될 때마다 각 연산 클래스의 인스턴스도 함께 생성되어 초기화되도록 엮어놓는다.
//
//    //원래는 if (operator == '+') {
//    //            result = num1 + num2; 이런식으로 직접 계산했지만 이젠  result = addOperator.operate(num1, num2);이렇게 연결만함
//    public double calculate(int num1, int num2, char operator) throws IllegalArgumentException {
//        double result;
//        if (operator == '+') {
//            result = addOperator.operate(num1, num2);
//        } else if (operator == '-') {
//            result = subtractOperator.operate(num1, num2);
//        } else if (operator == '*') {
//            result = multiplyOperator.operate(num1, num2);
//        } else if (operator == '/') {
//            result = divideOperator.operate(num1, num2);
//        } else {
//            throw new IllegalArgumentException("잘못된 연산자입니다.");
//        }
//        addResult(result);
//        return result;
//    }
//}