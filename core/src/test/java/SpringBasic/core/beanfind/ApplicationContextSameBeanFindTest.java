package SpringBasic.core.beanfind;

import SpringBasic.core.AppConfig;
import SpringBasic.core.member.MemberRepository;
import SpringBasic.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
    @Test
    @DisplayName("타입으로 조회시 같은 타입 2개 이상 있을 경우, 중복 오류 발생")
    void findBeanByTypeDuplicate() {
        MemberRepository bean = ac.getBean(MemberRepository.class); // Type만 지정 -> 예외 터짐(No Unique Bean)
    }

    // 클래스 안의 설정파일 클래스 -> 그 클래스 내부에서만 쓰겠다를 의미.
    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }

    }
}
