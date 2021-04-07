package SpringBasic.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor // 생성자 관련해서도 지원한다
@ToString
// 자세한건 롬복을 검색해서 알아보자!
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdf");

        System.out.println("hello Lombok = " + helloLombok);
        // 자동으로 생성자, 접근자 생성해 줌. (꿀이다)
    }
}
