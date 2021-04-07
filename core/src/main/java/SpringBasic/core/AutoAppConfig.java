package SpringBasic.core;


import SpringBasic.core.member.MemberRepository;
import SpringBasic.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // basepackage = 탐색할 패키지의 시작 위치 지정
        // 기본값은 Autoconfig 해당 클래스가 위치한 패키지(basePackageClasses)
        // 기존에 등록한 AppConfig(TestConfig... etc)를 예외처리하기 위함.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
    //@Bean(name = "memoryMemberRepository") // 수동 등록 빈이 자동빈을 overriding함
    //MemberRepository memberRepository() {
    //    return new MemoryMemberRepository(); //MemberServiceImpl에서 Component와 중복
    //}
}
// 애매한 상황은 만들지 말자
// Spring Boot 부터는 바뀌었다. (자동 빈과 수동 빈 중복시 에러)