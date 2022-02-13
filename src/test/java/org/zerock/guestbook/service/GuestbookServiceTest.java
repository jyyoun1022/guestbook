package org.zerock.guestbook.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;

@SpringBootTest
public class GuestbookServiceTest {

    @Autowired
    private GuestbookService guestbookService;

    @Test
    public void testResister(){
        GuestbookDTO guestbookDTO =GuestbookDTO.builder()
                .title("Sample title...")
                .content("Sample content...")
                .writer("user0")
                .build();

        System.out.println(guestbookService.register(guestbookDTO));

    }
    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<GuestbookDTO, Guestbook> result = guestbookService.getList(pageRequestDTO);

        System.out.println("PREV : "+ result.isPrev());
        System.out.println("NEXT : "+result.isNext());
        System.out.println("TOTAL : "+result.getTotalPage());

        System.out.println("=====================================");
        for (GuestbookDTO guestbookDTO : result.getDtoList()) {
            System.out.println(guestbookDTO);
        }
        System.out.println("======================================");
        result.getPageList().forEach(i -> System.out.println(i));


    }

    }

