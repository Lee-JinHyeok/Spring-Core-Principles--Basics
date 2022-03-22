package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = applicationContext.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = applicationContext.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = applicationContext.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.memberRepository();
        MemberRepository memberRepository2 = orderService.memberRepository();

        System.out.println("memberService -> memberRepository1 = " + memberRepository1);
        System.out.println("orderService ->memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.memberRepository()).isSameAs(memberRepository);
        assertThat(orderService.memberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeepTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = applicationContext.getBean(AppConfig.class);

        System.out.println("appConfig = " + appConfig.getClass());

    }
}
