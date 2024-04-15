package com.djts.hosu.sample;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // spring을 띄우는 설정 & 로드
public class DITests {

    @Autowired // 빈으로 진짜 만들어졌으면 test코드에다가 자동으로 집어넣어줘. -> ! : Restaurant 객체를 주입
    Restaurant restaurant;
    // 설명
    //Spring이 해당 필드에 자동으로 Restaurant 객체를 주입함
    //Spring 컨테이너에서 Restaurant 객체가 생성 -> 이를 해당 필드에 자동으로 할당하여 사용할 수 있도록 해줌.

    @Autowired
    DataSource dataSource;

    @Test
    public void testCon() throws Exception{

        // 데이터소스가 나오는지 확인
        Connection con = dataSource.getConnection();
        System.out.println("데이터소스 확인");
        System.out.println(con);
        System.out.println("데이터소스 확인");

        con.close();
    }

    @Test
    public void testExist(){
        System.out.println("의존성주입 확인");
        System.out.println(restaurant); // restaurant 객체를 출력하는 역할
        System.out.println("의존성주입 확인");
        // Restaurant(chef=Chef()) -> restaurant이란 객체가 가진 정보를 알 수 있다
        // restaurant 객체는 Restaurant 클래스의 인스턴스이며, Chef 객체를 필드로 가지고 있다
        // Restaurant: 클래스 이름
        // (chef=Chef()): 객체 내의 필드와 해당 필드의 값
        //  chef 필드가 있고, 그 값으로 Chef()라는 객체가 할당되어 있다.
        // 즉,  Restaurant 객체가 생성될 때 Chef 객체가 필드로 주입되었고,
        //  Chef와 Restaurant 두 클래스는 Spring의 의존성 주입 메커니즘(Bean으로 등록)에 의해 자동으로 의존성 주입이 이루어진 것.

    }
}
