import java.util.ArrayList;

public class Calculator {

    protected ArrayList<Double> resultList;//상속용

    public Calculator() {
        this.resultList = new ArrayList<>();//새로 초기화 하는 기능
    }

    public void addResult(Double result) {
        resultList.add(result);//계산결과 저장
    }

    public ArrayList<Double> getResultList() {//결과를 조회하는 기능
        return new ArrayList<>(resultList);
    }
    protected void removeResult() {// 앞에 있는걸 삭제하는기능
        if (!resultList.isEmpty()) {
            resultList.remove(0);
        }
    }
}
//    private ArrayList<Integer> resultList;// private로 접근 못하게
//    private ArrayList<Double> circleAreaList;//private로 접근 못하게
//
//    public static final double PI = Math.PI;// static, final 키워드에 대한 설명과 활용한 이유에 대해 주석으로 작성합니다.라고 해서
//    // 원주율은 절대 변하지 않는 상수이므로 final, static 은 여기의 모든 클래스가 원주율을 그대로 공유하니까
//
//    public Calculator() {
//        this.resultList = new ArrayList<>();//Calculator calculator = new Calculator();가 실행되면 resultList 필드를 초기화
//
//        // 원의 넓이 결과를 저장하는 ArrayList를 만들고 그것도 같이 초기화 시킨다
//        this.circleAreaList = new ArrayList<>();
//    }
//
//    public int calculate(int num1, int num2, char operator) throws IllegalArgumentException {
//        int result;
//        if (operator == '+') {
//            result = num1 + num2;
//        } else if (operator == '-') {
//            result = num1 - num2;
//        } else if (operator == '*') {
//            result = num1 * num2;
//        } else if (operator == '/') {
//            if (num2 == 0) {
//                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
//            }
//            result = num1 / num2;
//        } else {
//            throw new IllegalArgumentException("잘못된 연산자입니다.");
//        }
//        resultList.add(result);
//        return result;
//    }
//
//    public ArrayList<Integer> getResultList() {//getter 사용
//        return new ArrayList<>(resultList);
//    }//getter사용
//    public void removeResult() {
//        if (!resultList.isEmpty()) {
//            resultList.remove(0);
//        }
//    }// 맨 앞에꺼 제거기능
//
//    public ArrayList<Integer> inquiryResults() {
//        return new ArrayList<>(resultList);
//
//    }//결과를 계산기에 저장
//
//
//    public double calculateCircleArea(double radius) {
//        double area = PI * radius * radius;//원의 반지름을 매개변수로 받아 원의 넓이를 계산
//        circleAreaList.add(area);//원의 넓이를 저장
//        return area;
//    }
//
//    public ArrayList<Double> getCircleAreaList() {//getter사용
//        return new ArrayList<>(circleAreaList);
//    } // 위에서 저장된 원의 넓이 결과를 가져옴



