public class DivideOperator implements Operator{
    public double operate(int num1, int num2) throws IllegalArgumentException {
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return (double) num1 / num2;
    }
}
