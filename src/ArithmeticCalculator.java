public class ArithmeticCalculator extends Calculator {
    //private을 통해 새로 추가한 개체들이 ArithmeticCalculator에만 접근 가능하게 하고
    private AddOperator addOperator;
    private SubtractOperator subtractOperator;
    private MultiplyOperator multiplyOperator;
    private DivideOperator divideOperator;

    public ArithmeticCalculator() {
        this.addOperator = new AddOperator();
        this.subtractOperator = new SubtractOperator();
        this.multiplyOperator = new MultiplyOperator();
        this.divideOperator = new DivideOperator();
    }//이제 ArithmeticCalculator 객체가 생성될 때마다 각 연산 클래스의 인스턴스도 함께 생성되어 초기화되도록 엮어놓는다.

    //원래는 if (operator == '+') {
    //            result = num1 + num2; 이런식으로 직접 계산했지만 이젠  result = addOperator.operate(num1, num2);이렇게 연결만함
    public double calculate(int num1, int num2, char operator) throws IllegalArgumentException {
        double result;
        if (operator == '+') {
            result = addOperator.operate(num1, num2);
        } else if (operator == '-') {
            result = subtractOperator.operate(num1, num2);
        } else if (operator == '*') {
            result = multiplyOperator.operate(num1, num2);
        } else if (operator == '/') {
            result = divideOperator.operate(num1, num2);
        } else {
            throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
        addResult(result);
        return result;
    }

}