package SpringBasic.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.plaf.nimbus.State;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        // Thread A : A 사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);

        // Thread B : 사용자 20000원 주문(중간에 끼어들어옴)
        int userBPrice = statefulService2.order("userB", 20000);

        // Thread A : 고객 A의 주문 금액 조회
        //int price = statefulService1.getPrice();
        // 10000원이 나오길 기대했는데 왜 20000원이 나와?
        // Instance가 똑같다.....
        // 같은 객체의 값이 변한다.....
        // 공유되는 필드가 있으면 그냥 spring bean은 Stateless로 개발해야한다 꼭 (아니면 망한다)

        Assertions.assertThat(userAPrice).isEqualTo(10000);
        /* 잘못하면 엄청난 난리가 난다.... */
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
