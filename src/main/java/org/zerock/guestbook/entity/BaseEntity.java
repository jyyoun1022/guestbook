package org.zerock.guestbook.entity;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
public  abstract class BaseEntity {

    @CreatedDate    //Entity가 생성되어 저장할때 시간을 자동 저장하는 에노테이션
    @Column(name = "regdate",updatable = false) // insertable=false, updatable=false는 일반적으로 엔티티에서 필드를 두 번 이상 맵핑해야 할 때 유용합니다.
    private LocalDateTime regDate;

    @LastModifiedDate   //조회한 Entity의 값을 변경할때 시간을 자동 저장하는 에노테이션
    @Column(name="moddate")
    private LocalDateTime modDates;
}
