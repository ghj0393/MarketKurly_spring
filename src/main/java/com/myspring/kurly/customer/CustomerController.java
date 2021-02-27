package com.myspring.kurly.customer;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.kurly.board.BoardDAO;
import com.myspring.kurly.board.BoardDTO;
import com.myspring.kurly.buy.BuyDAO;
import com.myspring.kurly.buy.BuyDTO;
import com.myspring.kurly.cart.CartDAO;
import com.myspring.kurly.cart.CartDTO;
import com.myspring.kurly.item.ItemDAO;
import com.myspring.kurly.item.ItemDTO;

@Controller
public class CustomerController {

	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	BuyDAO buyDAO;
	@Autowired
	BoardDAO boardDAO;
	
	@ModelAttribute("contextPath")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@RequestMapping(value = "/index.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String index(Model model) {
		
		/*
		 * type변수는 관리자와 사용자를 구분하기 위한 변수
		 * . 관리자	type = 0
		 * . 사용자 	type = 1
		 */
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "00_shopMain.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/join.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String join(Model model) {
		
		/*
		 * type변수는 관리자와 사용자를 구분하기 위한 변수
		 * . 관리자	type = 0
		 * . 사용자 	type = 1
		 */
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "18_join.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/checkDoubleId.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String checkDoubleId(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		
		int check = customerDAO.checkDoubleId(id);
		System.out.println("check = " + check);
		
		model.addAttribute("check", check);
		model.addAttribute("cont", "20_checkDoubleId.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/checkDoubleEmail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String checkDoubleEmail(HttpServletRequest request, Model model) {
		
		String email = request.getParameter("email");
		
		int check = customerDAO.checkDoubleEmail(email);
		System.out.println("check = " + check);
		
		model.addAttribute("check", check);
		model.addAttribute("cont", "21_checkDoubleEmail.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/joinPro.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinPro(CustomerDTO dto) {
		
		customerDAO.insertCustomer(dto);
		
		return "00_index";
	}
	
	@RequestMapping(value = "/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(Model model) {
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "22_login.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/loginPro.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginPro(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		int check = customerDAO.userCheck(id, pw);
		
		model.addAttribute("check", check);
		model.addAttribute("id", id);
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "23_loginPro.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/logout.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(Model model) {
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "24_logout.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/showAllItem.do")
	public String showAllItem(Model model) {
		
		ArrayList<ItemDTO> itemList = itemDAO.getAllItem();
		
		model.addAttribute("itemList", itemList);
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "25_showAllItem.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/showOneItem.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String showOneItem(HttpServletRequest request, Model model) {
		
		int item_num = Integer.parseInt(request.getParameter("item_num"));
		
		ItemDTO item = itemDAO.getOneItem(item_num);
		
		System.out.println("item = " + item);
		
		model.addAttribute("item_num", item_num);
		model.addAttribute("item", item);
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "26_showOneItem.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/showNewItem.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String showNewItem(Model model) {
		
		ArrayList<ItemDTO> itemList = itemDAO.getNewItem();
		
		model.addAttribute("itemList", itemList);
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "27_showNewItem.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/showBestItem.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String showBestItem(Model model) {
		
		ArrayList<ItemDTO> itemList = itemDAO.getBestItem();
		
		model.addAttribute("itemList", itemList);
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "28_showBestItem.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/showDiscountedItem.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String showDiscountedItem(Model model) {
		
		ArrayList<ItemDTO> itemList = itemDAO.getDiscountedItem();
		
		model.addAttribute("itemList", itemList);
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "29_showDiscountedItem.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/insertCart.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String insertCart(HttpServletRequest request, HttpSession session, Model model) {
		
		// 구매자, 아이템이름, 가격, 구매개수, 이미지
		// 구매자
		String buyer = (String)session.getAttribute("id");
		
		int item_number = Integer.parseInt(request.getParameter("item_number"));
		// 구매개수
		int buy_count = Integer.parseInt(request.getParameter("buy_count"));
		
		ItemDTO item = itemDAO.getOneItem(item_number);
		
		// 아이템이름, 가격, 이미지
		String item_name = item.getItem_name();
		int buy_price = item.getItem_price() - item.getItem_price()*item.getDiscount_rate()/100;
		String item_image = item.getItem_image();
		
		CartDTO dto = new CartDTO();
		dto.setBuyer(buyer);
		dto.setItem_name(item_name);
		dto.setBuy_price(buy_price);
		dto.setBuy_count(buy_count);
		dto.setItem_image(item_image);
		
		int check = cartDAO.insertCart(dto);
		
		model.addAttribute("check", check);
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "30_insertCart.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/cartInfo.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String cartInfo(HttpSession session, Model model) {
		
		String id = (String)session.getAttribute("id");
		
		int cnt = cartDAO.getItemCount(id);
		ArrayList<CartDTO> myCartList = cartDAO.getCartList(id);
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("myCartList", myCartList);
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "31_cartInfo.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/order.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String order(HttpSession session, HttpServletRequest request, Model model) {
		
		// id를 가져와서 카트리스트(결제할때 리스트 출력), id로 고객정보 가져오기(결제할때 정보창 필요)
		String id = (String)session.getAttribute("id");
		
		int total = Integer.parseInt(request.getParameter("total"));
		
		ArrayList<CartDTO> orderList = cartDAO.getCartList(id);
		CustomerDTO customer = customerDAO.getCustomerInfo(id);
		
		model.addAttribute("total", total);
		model.addAttribute("orderList", orderList);
		model.addAttribute("customer", customer);
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "32_order.jsp");
		
		return "00_index";
	}
	
	
	@RequestMapping(value = "/insertOrderList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String insertOrderList(HttpSession session, HttpServletRequest request, Model model) {
		
		String id = (String)session.getAttribute("id");
		
		int howpay_ = Integer.parseInt(request.getParameter("howpay"));
		String howpay = "";
		if(howpay_ == 1){
			howpay = "계좌이체";
		}else if(howpay_ == 2) {
			howpay = "신용카드";
		}
		// buyList에 저장하기 
		// 구매회원 정보
		CustomerDTO customerBean = customerDAO.getCustomerInfo(id);
		String customer_name = customerBean.getName();
		String address = customerBean.getAddress();
		
		// 로그인회원 장바구니 목록
		ArrayList<CartDTO> cartList = cartDAO.getCartList(id);
		
		// buy칼럼에 insert하기
		// item칼럼 판매수량 업데이트
		// id에 해당하는 카트리스트 목록 삭제하기
		for(int i=0; i<cartList.size(); i++) {
		
			CartDTO bean = cartList.get(i);
			
			int cart_number = bean.getCart_number();
			String item_name = bean.getItem_name();
			int buy_price = bean.getBuy_price();
			int buy_count = bean.getBuy_count();
			String item_image = bean.getItem_image();
			
			BuyDTO dto = new BuyDTO();
			dto.setCustomer_id(id);
			dto.setCustomer_name(customer_name);
			dto.setCart_number(cart_number);
			dto.setItem_name(item_name);
			dto.setBuy_price(buy_price);
			dto.setBuy_count(buy_count);
			dto.setItem_image(item_image);
			dto.setHowpay(howpay);
			dto.setAddress(address);
			// buy칼럼에 insert하기
		 	buyDAO.insertOrderList(dto);
		 	// item칼럼 판매수량 업데이트
		 	buyDAO.updateSold(item_name, buy_count);
		}
		// id에 해당하는 카트리스트 목록 삭제하기
		buyDAO.deleteCartList(id);
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "33_insertOrderList.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/deleteCart.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteCart(HttpServletRequest request, Model model) {
		
		int cart_number = Integer.parseInt(request.getParameter("cart_number"));

		cartDAO.deleteCart(cart_number);
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "34_deleteCart.jsp");
		
		return "00_index";
	}	
	
	@RequestMapping(value = "/checkMyOrderList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String checkMyOrderList(HttpSession session, Model model) {
		
		// session에 저장된 id값 가져오기
		String id = (String)session.getAttribute("id");
		
		// 해당id로 buy테이블을 뒤져서 해당id목록을 반환
		ArrayList<BuyDTO> buyList = buyDAO.getBuyList(id);
		int cnt = buyList.size();
		
		model.addAttribute("buyList", buyList);
		model.addAttribute("cnt", cnt);
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "35_myOrderList.jsp");
		
		return "00_index";
	}	
	
	@RequestMapping(value = "/showBoardListForCustomer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String showBoardListForCustomer(HttpServletRequest request, Model model) {
		//-----------------한 페이지에 보여줄 게시글 ---------------------
		int pageSize = 10;
		
		int curPageNum = 1;
		if(request.getParameter("curPageNum") != null) {
			curPageNum = Integer.parseInt(request.getParameter("curPageNum"));
		}
		// 전체 게시글 수
		int count = boardDAO.getAllBoardCount();
		
		int startRow = (curPageNum - 1) * pageSize;
		ArrayList<BoardDTO> boardList = boardDAO.getAllBoardList(startRow, pageSize);
		
		//-----------------게시글 페이지 클릭 구하기---------------------
		int number = count - startRow;
		
		int clickablePageSize = 5;
		// 전체 페이지 클릭 개수 구하기
		int pageCount = count / pageSize + (count % pageSize == 0?0:1);
		int startPage = 1;
		// 현재 페이지가 1~5이면 startPage 1로 만들기 6~10은 6으로 ...
		if(curPageNum % clickablePageSize != 0) {
			startPage = (curPageNum / clickablePageSize) * clickablePageSize + 1;
		}else {
			startPage = ((curPageNum / clickablePageSize)-1) * clickablePageSize + 1;
		}
		// startPage 보다 clickablePageSize만큼 크게만들기, ex)1-5, 6,10, 11-15
		int endPage = startPage + clickablePageSize - 1;
		// 페이지 클릭 개수가 딱 떨어지지 않을때 예외처리
		if(endPage > pageCount)
			endPage = pageCount;
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("curPageNum", curPageNum);
		model.addAttribute("count", count);
		model.addAttribute("boardList", boardList);
		model.addAttribute("number", number);
		
		model.addAttribute("clickablePageSize", clickablePageSize);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "36_showBoardListForCustomer.jsp");
		
		return "00_index";
	}	
	
	@RequestMapping(value = "/boardWriteForCustomer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardWriteForCustomer(Model model) {
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "37_boardWriteForCustomer.jsp");
		
		return "00_index";
	}		
	
	
	@RequestMapping(value = "/boardWriteForCustomerPro.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardWriteForCustomerPro(HttpSession session, HttpServletRequest request, Model model) {
		
		String id = (String)session.getAttribute("id");
		String pw = request.getParameter("pw");
		
		int check = customerDAO.userCheck(id, pw);
		
		if(check == 1) {
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardDTO dto = new BoardDTO();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setPw(pw);
			dto.setContent(content);
			
			boardDAO.insertBoard(dto);
		}
		
		model.addAttribute("check", check);
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "38_boardWriteForCustomerPro.jsp");
		
		return "00_index";
	}		
	
	@RequestMapping(value = "/showBoardContentForCustomer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String showBoardContentForCustomer(HttpServletRequest request, Model model) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDTO board = boardDAO.getOneBoard(num);
		
		model.addAttribute("board", board);
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "39_showBoardContent.jsp");
		
		return "00_index";
	}		
	
	@RequestMapping(value = "/boardUpdateForCustomer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardUpdateForCustomer(HttpSession session, HttpServletRequest request, Model model) {
		
		String id = (String)session.getAttribute("id");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDTO board = boardDAO.getOneBoard(num);
		
		model.addAttribute("board", board);
		
		if(id.equals("admin")) {
			model.addAttribute("type", 0);
		}else {
			model.addAttribute("type", 1);
		}
		
		model.addAttribute("cont", "40_boardUpdateForCustomer.jsp");
		
		return "00_index";
	}	
	
	@RequestMapping(value = "/boardUpdateForCustomerPro.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardUpdateForCustomerPro(HttpSession session, HttpServletRequest request, Model model) {
		
		String id = (String)session.getAttribute("id");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boardDAO.updateBoard(num, title, content);
		
		System.out.println("id = " + id);
		
		if(id.equals("admin")) {
			model.addAttribute("type", 0);
			return "redirect:/serviceCenter.do";
		}else {
			model.addAttribute("type", 1);
			model.addAttribute("cont", "41_boardUpdateForCustomerPro.jsp");
		}
		
		return "00_index";
	}	
	
	@RequestMapping(value = "/boardDeleteForCustomer.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardDeleteForCustomer(HttpServletRequest request, Model model) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDTO board = boardDAO.getOneBoardReply(num);
		
		// re_step == 1인경우는 게시글 원본인 경우
		if(board.getRe_step() == 1) {
			boardDAO.deleteBoardAll(board.getRef());
		}else {
			boardDAO.deleteBoard(num);
		}
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "42_boardDeleteForCustomer.jsp");
		
		return "00_index";
	}	
	
	@RequestMapping(value = "/searchItem.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String searchItem(HttpServletRequest request, Model model) {
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "43_searchItem.jsp");
		
		return "00_index";
	}	
	
	
	@RequestMapping(value = "/searchItemPro.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String searchItemPro(HttpServletRequest request, Model model) {
		
		String item_name = request.getParameter("item_name");
		
		ArrayList<ItemDTO> itemList = itemDAO.getSearchItem(item_name);
		
		model.addAttribute("itemList", itemList);
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "44_searchItemPro.jsp");
		
		return "00_index";
	}	
	
	@RequestMapping(value = "/findId.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String findId(HttpServletRequest request, Model model) {
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "45_findId.jsp");
		
		return "00_index";
	}
	
	
	@RequestMapping(value = "/findIdPro.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String findIdPro(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		String fId = customerDAO.findId(name, email);
		int check = 0;
		
		if(fId != null) {
			check = 1;
			model.addAttribute("fId", fId);
		}
		
		model.addAttribute("check", check);
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "46_findIdPro.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/findPw.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String findPw(HttpServletRequest request, Model model) {
		
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "47_findPw.jsp");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/findPwPro.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String findPwPro(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		System.out.println("name = " + name);
		System.out.println("id = " + id);
		System.out.println("email = " + email);
		
		String fPw = customerDAO.findPw(name, id, email);
		int check = 0;
		System.out.println("fPw = " + fPw);
		
		if(fPw != null) {
			check = 1;
			model.addAttribute("fPw", fPw);
		}
		
		model.addAttribute("check", check);
		model.addAttribute("type", 1);
		
		model.addAttribute("cont", "48_findPwPro.jsp");
		
		return "00_index";
	}
	
}















