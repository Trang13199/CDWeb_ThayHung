﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creat An Account || Witter Multipage Responsive Template</title>

</head>
<body>


	<!-- Start header section -->
	<jsp:directive.include file="header.jsp" />
	<!-- / header section -->

	<div class="container marketing"
		style="width: 80%; float: right; margin-right: 30px">
		<h1 style="color: red;">CHI TIẾT ĐƠN HÀNG</h1>
		<br /> @foreach (Order order in orders) {
		<div class="payment-order clearfix">
			<h3>
				Mã đơn hàng của bạn: <b>#@order.id</b>
			</h3>
			<p>
				Tên khách hàng: <b>@order.username</b>
			</p>
			<p>
				Số điện thoại: <b>@order.phone</b>
			</p>
			<p>
				Địa chỉ giao hàng: <b>@order.address</b>
			</p>
			<p>
				Ngày đặt: <i>@order.date</i>
			</p>
			<p>
				Số lượng: <b>@order.sum sản phẩm</b>
			</p>
			<p>
				Tổng tiền: <b>@order.total VNĐ</b>
			</p>
		</div>
		<br /> }
		<h4>Thông tin đơn hàng</h4>
		<table class="table table-bordered">
			<tr>
				<th>Hình</th>
				<th>Tên sản phẩm</th>
				<th>Số lượng</th>
				<th>Đơn giá</th>
			</tr>
			<tr>
				<td class="text-center"><img alt="" src="@item["
					image"]" width="70" height="60" /></td>
				<td>@item["name"]</td>
				<td>@item["quantity"]</td>
				<td>@item["price"] VNĐ</td>
			</tr>
		</table>
		<div class="clearfix col-md-12">
			<div class="button text-right">
				<a class="btn btn-default btn-danger" href="admin">Quay lại quản
					lý đơn hàng</a>
			</div>
		</div>
		<hr class="featurette-divider">
	</div>
	<!--FOOTER -->

	<jsp:directive.include file="footer.jsp" />

	<!-- END FOOTER -->
</body>
</html>