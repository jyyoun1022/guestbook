package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;

public interface GuestbookService {
    /**
     *  새로운 방명록을 등록하는 시나리오를 처리
     */
    Long register(GuestbookDTO dto);

    /**
     *  PageRequestDTO를 파라미터로, PageResultDTO 를 리턴 타입으로 사용하는
     *  getList를 설계하고, 엔티티 객체를 DTO객체로 변환하는 메서드를 정의
     */
    PageResultDTO<GuestbookDTO,Guestbook> getList(PageRequestDTO requestDTO);

    /**
     *  서비스계층에서 레포지토리로 가려면 Entity 객체를 사용해야 하므로 DTO를 Entity로 변환하는 메서드
     */
    default Guestbook dtoToEntity(GuestbookDTO dto){
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();

        return entity;
    }
    default GuestbookDTO entityToDto(Guestbook entity){
        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDates())
                .build();

        return dto;
    }
}
