package com.bookstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Sach;
import com.bookstore.entity.Theloaisach;
import com.bookstore.entity.User;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;
import com.bookstore.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private CategoryService category;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

//// TRANG CHU MAN HINH ADMIN
	@RequestMapping("/admin")
	public ModelAndView home(ModelMap model) {
		ModelAndView mav = new ModelAndView("admin/Index");
		return mav;
	}

/// DANH SACH SAN PHAM
	@RequestMapping("/admin/listProduct")
	public ModelAndView listProduct(ModelMap model) {
		ModelAndView mav = new ModelAndView("admin/danh_sach_sp");
		model.addAttribute("listAllBooks", bookService.findAll());
		return mav;
	}

//// XOA SAN PHAM THEO MA SACH
	@RequestMapping("/admin/deleteProduct/{maSach}")
	public String deleteProduct(ModelMap model, @PathVariable("maSach") long maSach) {
		bookService.delete(maSach);
		model.addAttribute("listAllBooks", bookService.findAll());
		return "admin/danh_sach_sp";
	}

/// THEM MOT SAN PHAM MOI
	@RequestMapping(value = "/admin/addProduct", method = RequestMethod.GET)
	public String addProduct(ModelMap model) {
		model.addAttribute("books", new Sach());
		model.addAttribute("listAllBooks", bookService.findAll());
		return "admin/them_sp";
	}

	/// THEM MOT SAN PHAM MOI
	@RequestMapping(value = "/admin/addProduct", method = RequestMethod.POST)
	public String addProduct(ModelMap model, @Valid @ModelAttribute("books") Sach sach, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/them_sp";
		}
		bookService.createBook(sach);
		model.addAttribute("listAllBooks", bookService.findAll());
		return "redirect:listProduct";
	}

/// DANH SACH LOAI SAN PHAM
	@RequestMapping("/admin/listProductType")
	public ModelAndView listProductType(ModelMap model) {
		ModelAndView mav = new ModelAndView("admin/ql_loai_sp");
		model.addAttribute("listcategory", category.findAll());
		return mav;
	}

/// XOA LOAI SAN PHAM THEO MA THE LOAI
	@RequestMapping("/admin/deleteType/{maTheLoai}")
	public String deleteType(ModelMap model, @PathVariable("maTheLoai") long maTheLoai) {
		category.delete(maTheLoai);
		model.addAttribute("listcategory", category.findAll());
		return "admin/ql_loai_sp";
	}

/// THEM LOAI SAN PHAM MOI
	@RequestMapping(value = "/admin/addType", method = RequestMethod.GET)
	public ModelAndView addType(ModelMap model) {
		ModelAndView mav = new ModelAndView("admin/them_loai_sp");
		model.addAttribute("category", new Theloaisach());
		model.addAttribute("listcategory", category.findAll());
		return mav;
	}

//// THEM LOAI SAN PHAM MOI
	@RequestMapping(value = "/admin/addType", method = RequestMethod.POST)
	public String addType(ModelMap model, @ModelAttribute("category") Theloaisach theloaisach, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/them_loai_sp";
		}
		category.create(theloaisach);
		model.addAttribute("listcategory", category.findAll());
		return "redirect:listProductType";
	}

/// DANH SACH CAC USER
	@RequestMapping("/admin/listCustomer")
	public ModelAndView listCustomer(ModelMap model) {
		ModelAndView mav = new ModelAndView("admin/khach_hang");
		model.addAttribute("listAllUser", userService.findAll());
		return mav;
	}

/// XOA TAI KHOAN THEO IDUSER
	@RequestMapping("/admin/deleteUser/{idUser}")
	public String deleteUser(ModelMap model, @PathVariable("idUser") long idUser) {
		userService.delete(idUser);
		model.addAttribute("listAllUser", userService.findAll());
		return "admin/khach_hang";
	}

// THEM MOI MOT TAI KHOAN
	@RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
	public ModelAndView addUser(ModelMap model) {
		ModelAndView mav = new ModelAndView("admin/them_khach_hang");
		model.addAttribute("user", new User());
		model.addAttribute("listAllUser", userService.findAll());
		return mav;
	}

// THEM MOI MOT TAI KHOAN
	@RequestMapping(value = "/admin/addUser", method = RequestMethod.POST)
	public String addUser(ModelMap model, @Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/them_khach_hang";
		}
		userService.create(user);
		model.addAttribute("listAllUser", userService.findAll());
		return "redirect:listCustomer";
	}

// DANH SACH DON HANG
	@RequestMapping("/admin/listOrder")
	public ModelAndView listOrder(ModelMap model) {
		ModelAndView mav = new ModelAndView("admin/QuanLyDonHang");
		return mav;
	}

//// CHINH SUA SAN PHAM THEM MA SACH
	@RequestMapping(value = "/admin/editProduct", method = RequestMethod.GET)
	public ModelAndView editProduct(ModelMap model) {
		ModelAndView mav = new ModelAndView("admin/chinh_sua_sp");
		return mav;
	}

/// CHINH SUA DON HANG
	@RequestMapping(value = "/admin/editOrder", method = RequestMethod.GET)
	public ModelAndView editOrder(ModelMap model) {
		ModelAndView mav = new ModelAndView("admin/chinh_sua_don_hang");
		return mav;
	}

// CHINH SUA LOAI SAN PHAM
	@RequestMapping(value = "/admin/editType", method = RequestMethod.GET)
	public ModelAndView editType(ModelMap model) {
		ModelAndView mav = new ModelAndView("admin/chỉnh_sua_loaiSP");
		return mav;
	}

// CHINH SUA TAI KHOAN
	@RequestMapping(value = "/admin/editCustomter", method = RequestMethod.GET)
	public ModelAndView editCustomter(ModelMap model) {
		ModelAndView mav = new ModelAndView("admin/chinh_sua_kh");
		return mav;
	}

}
