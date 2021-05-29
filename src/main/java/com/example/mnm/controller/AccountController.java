package com.example.mnm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mnm.domain.Account;
import com.example.mnm.service.MnmStoreFacade;

@Controller
public class AccountController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MnmStoreFacade store;
	public void setStore(MnmStoreFacade store) {
		this.store = store;
	}
	
	// 회원가입 폼으로 이동
	@RequestMapping(value="/joinForm.do")
	public String goJoinForm(@ModelAttribute("account") @Valid Account account, BindingResult bindingResult) {
		logger.info("[AcountController INFO] goJoinForm()");
		
		return "thyme/joinForm";
	}
	
	// 계정 추가 실행
	@RequestMapping("/join.do")
    private ModelAndView insertAccount(Account account, BindingResult result,
            RedirectAttributes redirect, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("[AcountController INFO] insertAccount()");
		logger.info("[AcountController INFO] joinForm 입력값");
		logger.info("[AcountController INFO] userid:" + account.getUserid());
		logger.info("[AcountController INFO] email:" + account.getEmail());
		logger.info("[AcountController INFO] name:" + account.getName());
		logger.info("[AcountController INFO] addr:" + account.getAddr());
		logger.info("[AcountController INFO] phone:" + account.getPhone());
		logger.info("[AcountController INFO] favcategory:" + account.getFavcategory());
		logger.info("[AcountController INFO] pwd:" + account.getPwd());
		
        store.insertAccount(account);
        
        return new ModelAndView("thyme/home");
    }
	
	// 로그인 폼으로 이동
	@RequestMapping(value="/loginForm.do")
	public String goLoginForm(@ModelAttribute("account") @Valid Account account, BindingResult bindingResult) {
		logger.info("[AcountController INFO] goLoginForm()");
		
		return "thyme/loginForm";
	}
	
	// 로그인 실행
	@RequestMapping(value="/login.do")
    public String login(HttpSession session, 
    					@RequestParam(value="userid") String userid, 
                        @RequestParam(value="pwd") String pwd) {
		logger.info("[AcountController INFO] login()");
		
		String returnURL = "";
		// 기존에 로그인 세션 존재하면 기존 세션 제거
        if ( session.getAttribute("userid") != null ){
            session.removeAttribute("account");
        }
        else {
        	Account account = store.getAccount(userid);
        	
        	if((store.getPwd(userid)).equals(pwd)) {
            	logger.info("[AcountController INFO] 로그인 성공");
            	account = store.getAccount(userid);
                session.setAttribute("account", account);
                returnURL = "redirect:/";
            } else{
            	logger.info("[AcountController INFO] 로그인 실패");
            	// 실패 오류 띄워주는거 추가하기
            	return "redirect:/loginForm.do";
            }
        }
		return returnURL;
    }

	// 로그아웃 실행
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) throws Exception {
		logger.info("[AcountController INFO] logout()");
		
		// 세션 비활성화
		session.removeAttribute("account");
		session.invalidate();

		return "redirect:/loginForm.do";
	}
	
	// 세션 체크용
	@RequestMapping("/sessionCheck.do")
	private ModelAndView sessionCheck(@ModelAttribute Account account,
			HttpServletRequest request) throws Exception {
		logger.info("[AcountController INFO] sessionCheck()");
		
		HttpSession session = request.getSession();
		Account curSession = (Account) session.getAttribute("account");
		if (curSession != null) {
			logger.info("[AcountController INFO] get session user name:" + curSession.getName());
		}
		
		return new ModelAndView("home");
	}
	
	// 마이페이지로 이동
	@RequestMapping(value="/mypage.do")
	public String goMyPage(@ModelAttribute("account") @Valid Account account, BindingResult bindingResult) {
		logger.info("[AcountController INFO] goMyPage()");
		
		return "thyme/mypage";
	}
	
	// 내 정보 페이지로 이동
	@RequestMapping(value="/myAccountInfo.do")
	public String goMyAccountInfo(@ModelAttribute("account") @Valid Account account, BindingResult bindingResult) {
		logger.info("[AcountController INFO] goMyAccountInfo()");
		
		return "thyme/myAccountInfo";
	}
	
	// 회원정보 수정
	@RequestMapping(value="/updateAccount.do")
    private ModelAndView updateAccount(Account account, BindingResult result,
            RedirectAttributes redirect, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("[AcountController INFO] updateAccount()");
		logger.info("[AcountController INFO] updateAccountForm 입력값");
		logger.info("[AcountController INFO] email:" + account.getEmail());
		logger.info("[AcountController INFO] addr:" + account.getAddr());
		logger.info("[AcountController INFO] phone:" + account.getPhone());
		logger.info("[AcountController INFO] favcategory:" + account.getFavcategory());
		logger.info("[AcountController INFO] pwd:" + account.getPwd());
		
        store.updateAccount(account);
        
        return new ModelAndView("thyme/home");
    }
	
}
