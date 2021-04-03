package SpringBasic.core.beanfind;

import SpringBasic.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { //iter + tab키 누르면 for문 자동 완성
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = "+ beanDefinitionName + "object = "+ bean);

        }

    }

            //Role ROLE_Application : 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈 정보
    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { //iter + tab키 누르면 for문 자동 완성
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // Beandefinition 객체 가져옴
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){ // 객체 속성 중 Role Application과 일치할 경우.
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = "+ beanDefinitionName + "object = "+ bean);
            }
        }
    }
}
