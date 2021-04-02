package SpringBasic.core;

import SpringBasic.core.member.Grade;
import SpringBasic.core.member.Member;
import SpringBasic.core.member.MemberService;
import SpringBasic.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();

        //Spring Bean을 사용하면 아래 5줄과 같아짐(공백포함)
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig의 클래스들 Bean 컨테이너에 모두 집어넣고 관리해주는 역할

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
