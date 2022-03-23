package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

class AutoWiredTest {

    @Test
    void AutoWiredOptionTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        @Autowired(required = false) //호출자체가 안된다.
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired //호출했는데 Member가 비엇으면 Null이라도 넣어준다.
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired //호출햇는데 Member가 비었으면 Optional.empty를 넣어준다.
        public void setNoBean(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
