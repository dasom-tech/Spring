package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
//@EnableWebMvc //4.3버전에서는 추가해야 @GetMapping, @PostMapping 정상동작 
public class UserController {

	//@RequestMapping("/login.do") // GET, POST 모두 처리
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	//@PostMapping((value = "/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println(">>> 로그인처리 - login()");
		
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
	
	/* @ModelAttribute : 모델(Model) 속성값으로 저장(속성명 별도 지정)
	 * 별도 지정 명칭 부여 안 하면 <데이터 타입>의 첫 글자 소문자로 작성된 명칭 사용
	 * @ModelAttribute("user") UserVO ---> 속성명 user 사용
	 * Command 객체가 기본 request 스코프에 저장 사용됨
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	//@GetMapping("/login.do")
	//public String loginView(UserVO vo) { //뷰에서 사용할 명칭 userVO 데이터 저장
	public String loginView(@ModelAttribute("user")UserVO vo) { //뷰에서 사용할 명칭 user 데이터 저장
		System.out.println(">>> 로그인 페이지로 이동 - loginView()");
		vo.setId("test");
		vo.setPassword("test");
		
		return "login.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리 - logout()");
		//1.세션 초기화(세션 객체 종료)
		session.invalidate();

		return "login.jsp";
	}

}
