package SpringBasic.core.autowired;

import SpringBasic.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {



    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {
        @Autowired(required = false)  //autowired(required=false) 자동 주입할 대상 없는 경우 수정자 메서드 자체가 호출이 안됨.
        public void setNoBean1(Member noBean1){ // 메서드 자체가 호출이 안되는 특징.
            System.out.println("noBean1 = " + noBean1);
        }
        @Autowired // org.springframework.lang.@nullable 자동 주입할 대상 없으면 NULL 주입
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired // Java 8 문법
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
