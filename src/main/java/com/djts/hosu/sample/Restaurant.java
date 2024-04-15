package com.djts.hosu.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component // SpringBoot는 이 Component라는 어노테이션만 붙여도 자동으로 Bean으로 자동으로 인식해줌 -> But, Spring은 직접 root-context에 설정을 해줘야 한다.
@ToString
@RequiredArgsConstructor // 자동 생성자 생성 # 방법 2 (요즘, 롬복으로 깔끔하게)
public class Restaurant {

    // Chef가 필요하다 -> 선언
    // Restaurant은 -> Chef 클래스를 필드로 가지고 있으며, 생성자 주입을 통해 Chef 객체를 받아옵
    private final Chef chef; // 필드 // 그런데 선언만 해서는 당연히 에러가 난다 -> ?

    // ? -> ! : 생성자 생성 (generate -> constructure 눌러서 해결 쉽게) # 방법 1(고전)
//    public Restaurant(Chef chef) {
//        this.chef = chef;
//    }
}
