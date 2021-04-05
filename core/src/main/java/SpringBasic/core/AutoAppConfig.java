package SpringBasic.core;


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
}
