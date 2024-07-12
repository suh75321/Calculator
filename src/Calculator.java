import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> resultList = new ArrayList<>();

    public int calculate(int num1, int num2, char operator) throws IllegalArgumentException {
        int result;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            result = num1 / num2;
        } else {
            throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
        resultList.add(result);
        return result;
    }
    public ArrayList<Integer> getResultList() {
        return resultList;// 이게있어야 계산기가 결과를 저장할수있다.
    }

}

