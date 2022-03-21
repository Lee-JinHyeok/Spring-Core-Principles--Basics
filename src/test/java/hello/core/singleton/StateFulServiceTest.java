package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;


class StateFulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService stateFulService1 = applicationContext.getBean("stateFulService", StateFulService.class);
        StateFulService stateFulService2 = applicationContext.getBean("stateFulService", StateFulService.class);

        //ThreadA : A, 10000
        int userAPrice = stateFulService1.order("userA", 10000);

        //ThreadB : B, 20000
        int userBPrice = stateFulService2.order("userB", 20000);

        //ThreadA : 사용자 A 주문 금액 조회
        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);

        assertThat(userAPrice).isEqualTo(10000);
    }

    static class TestConfig{
        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }
}