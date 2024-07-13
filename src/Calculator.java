import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> resultList;// private로 접근 못하게

    public Calculator() {
        this.resultList = new ArrayList<>();//Calculator calculator = new Calculator();가 실행되면 resultList 필드를 초기화
    }

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

    public ArrayList<Integer> getResultList() {//getter 사용
        return new ArrayList<>(resultList);
    }
    public void removeResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
        }
    }
    public ArrayList<Integer> inquiryResults() {
        return new ArrayList<>(resultList);
    }
}

