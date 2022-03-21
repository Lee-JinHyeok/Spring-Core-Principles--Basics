package hello.core.xml;

import hello.core.member.MemberService;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class XmlAppContext {

    @Test
    void xmlAppContext(){
        ApplicationContext applicationContext = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
