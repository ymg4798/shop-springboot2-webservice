package com.shop.springboot.test.domain;

import com.shop.springboot.test.domain.TestEntity;
import com.shop.springboot.test.domain.TestEntityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
public class TestEntityTest {

    @Autowired
    TestEntityRepository testEntityRepository;

    @Test
    public void Entity_테스트() {

        //given
        String name = "양민규";
        String content = "내용";

        testEntityRepository.save(TestEntity.builder()
                .name(name)
                .content(content)
                .build());

        //when
        List<TestEntity> testEntityList = testEntityRepository.findAll();

        //then
        TestEntity testEntity = testEntityList.get(0);
        assertThat(testEntity.getName()).isEqualTo(name);
        assertThat(testEntity.getContent()).isEqualTo(content);
    }
}
