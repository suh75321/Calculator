public class CircleCalculator extends Calculator { //이쪽이 반지름 담당
    public static final double PI = Math.PI;// static, final 키워드에 대한 설명과 활용한 이유에 대해 주석으로 작성합니다.라고 해서
//    // 원주율은 절대 변하지 않는 상수이므로 final, static 은 여기의 모든 클래스가 원주율을 그대로 공유하니까

    public double calculateCircleArea(double radius) {
        double area = PI * radius * radius;//원의 반지름을 매개변수로 받아 원의 넓이를 계산
        addResult(area);//원의 넓이를 저장
        return area;
    }
}
