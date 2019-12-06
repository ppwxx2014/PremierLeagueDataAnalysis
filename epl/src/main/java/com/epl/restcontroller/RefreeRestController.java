package com.epl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epl.service.interfaces.RefreeService;
import com.epl.vo.Page;
import com.epl.vo.Refree;

@RestController
public class RefreeRestController {
	@Autowired
	private RefreeService refreeService;
	// 심판출력
	@PostMapping("/addRefree")
	public int addRefree(Refree refree) {
		System.out.println("addRefree 입력실행");
		System.out.println("param refree :" + refree);

		int refree2 = refreeService.addRefree(refree);
		System.out.print(refree2 + "행 실행 완료");

		return refree2;
	}
	// 심판 리스트 출력
	@PostMapping("getRefreeList")
	public List<Refree> getRefreeList(){
		System.out.println("getRefreeList controller 폼 요청");
		List<Refree> list = refreeService.getRefreeList();
		return list;
	}
	// 페이지당 심판 리스트
	@PostMapping("/getRefreeListByPage")
	public List<Refree> getRefreeListByPage(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "searchWord", required = false) String searchWord){
		System.out.println("getRefreeListByPage controller 폼 요청");
		System.out.println("currentPage: " + currentPage); // 현 페이지수
		System.out.println("SearchWord: " + searchWord);
		
		int rowPerPage = 10; // 페이지당 보여줄 갯수 
		
		List<Refree> list = refreeService.getRefreeListByPage(currentPage, rowPerPage, searchWord);
		System.out.println("getRefreeListByPage controller list :" + list);
		
		return list;
	}
	// 심판 카운트
	@PostMapping("/getRefreeCount")
	public int getRefreeCount(@RequestParam(value = "searchWord", required = false) String searchWord) {
		Page page = new Page();
		page.setSearchWord(searchWord);
		int row = refreeService.getRefreeCount(page);
		return row;
	}
}
