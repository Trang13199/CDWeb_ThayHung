package com.bookstore.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Sach;
import com.bookstore.entity.User;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;
import com.bookstore.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private CategoryService category;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public ModelAndView home(ModelMap model) {
		ModelAndView mav = new ModelAndView("home/index");
		model.addAttribute("listcategory", category.findAll());
		model.addAttribute("newBook", bookService.newBooks());
		model.addAttribute("saleBook", bookService.newBooks());
		return mav;
	}

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public ModelAndView shop(Model model) {
		ModelAndView mav = new ModelAndView("home/shop");
		model.addAttribute("listcategory", category.findAll());
		model.addAttribute("listAllBooks", bookService.findAll());
		return mav;
	}

	@RequestMapping(value = "/shop/{id}", method = RequestMethod.GET)
	public ModelAndView shop(Model model, @PathVariable(value = "id") int id) {
		ModelAndView mav = new ModelAndView("home/shop");
		model.addAttribute("listcategory", category.findAll());
		model.addAttribute("listAllBooks", bookService.findByCategory(id));
		return mav;
	}

	@RequestMapping(value = "/sale", method = RequestMethod.GET)
	public ModelAndView sale(Model model) {
		ModelAndView mav = new ModelAndView("home/shop");
//		model.addAttribute("listAllBooks", bookService.Sale());
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model) {
		ModelAndView mav = new ModelAndView("home/login");
		model.addAttribute("user", new User());
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User user, Model model, HttpSession session) {
		ModelAndView mav = null;
		if (userService.checkLogin(user.getEmail(), user.getPassword())) {
			session.setAttribute("email", user.getEmail());
			mav = new ModelAndView("home/index");
		} else {
			model.addAttribute("message", "Invalid ussename or password!");
			mav = new ModelAndView("home/login");
		}
		return mav;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("email");
		return "redirect:login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(Model model) {
		ModelAndView mav = new ModelAndView("home/signup");
		model.addAttribute("user", new User());
		return mav;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
		ModelAndView mav = null;
		if (result.hasErrors()) {
			return mav = new ModelAndView("home/signup");
		}
		userService.create(user);

		return mav = new ModelAndView("home/login");
	}

	@RequestMapping(value = "/my_account", method = RequestMethod.GET)
	public ModelAndView my_account(@RequestParam(value = "email", required = false) String email, Model model) {
		ModelAndView mav = new ModelAndView("home/my-account");
		model.addAttribute("user", userService.findByEmail(email));
		return mav;
	}

	@RequestMapping(value = "/my_account", method = RequestMethod.POST)
	public ModelAndView my_account(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
		ModelAndView mav = null;
		if (result.hasErrors()) {
			return mav = new ModelAndView("home/my-account");
		}
		userService.update(user);

		return mav = new ModelAndView("home/my-account");
	}

	@RequestMapping(value = "/shopping_cart", method = RequestMethod.GET)
	public ModelAndView shopping_cart() {
		ModelAndView mav = new ModelAndView("home/cart");
		return mav;
	}

	@RequestMapping(value = "/single_product", method = RequestMethod.GET)
	public ModelAndView single_product(Model model, @RequestParam(value = "ids", required = false) int ids) {
		ModelAndView mav = new ModelAndView("home/single-product");
		mav.addObject("books", bookService.findByID(ids));
		model.addAttribute("listBook", bookService.findSameCategory());
		return mav;
	}

	@RequestMapping(value = "/thanhtoan", method = RequestMethod.GET)
	public ModelAndView thanhtoan() {
		ModelAndView mav = new ModelAndView("home/thanhtoan");
		return mav;
	}

	@RequestMapping(value = "/wishlist", method = RequestMethod.GET)
	public ModelAndView wishlist() {
		ModelAndView mav = new ModelAndView("home/wishlist");
		return mav;
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView cart() {
		ModelAndView mav = new ModelAndView("home/cart");
		return mav;
	}
}