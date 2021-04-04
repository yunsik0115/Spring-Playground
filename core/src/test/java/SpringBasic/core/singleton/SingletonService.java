package SpringBasic.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    } // getInstance 메소드를 통해서만 조회 가능(항상 같은 인스턴스 반환)

    private SingletonService() {
    } // 추가 생성을 막아버림(new를 이용해서)

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}