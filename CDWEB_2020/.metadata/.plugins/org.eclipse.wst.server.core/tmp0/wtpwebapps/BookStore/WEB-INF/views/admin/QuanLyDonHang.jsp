﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>


	<!-- Start header section -->
	<jsp:directive.include file="header.jsp" />
	<!-- / header section -->


	<div class="all-content-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="product-status-wrap">
						<h4>Quản lý đơn hàng</h4>

						<table>
							<tr>
								<th>ID đơn hàng</th>
								<th>Tên khách hàng</th>
								<th>Số điện thoại</th>
								<th>Trạng thái</th>
								<th>Ngày đặt hàng</th>
								<th>Tổng tiền</th>
								<th>Thao tác</th>
							</tr>
							<c:forEach items="${listOrders }" var="order">
								<tr>
									<td><a
										href="<%=request.getContextPath()%>/admin/orderDetail/${order.receipt.receiptId }">${order.receipt.receiptId }</a></td>
									<td>${order.receipt.receiptName }</td>
									<td>${order.receipt.receiptPhone }</td>
									<td><c:if test="${order.receipt.receiptStatus == true}">
									Tiếp nhận đơn
									</c:if> <c:if test="${order.receipt.receiptStatus == false}">
									Đã giao
									</c:if></td>
									<td>${order.receipt.receiptDate }</td>
									<td>${order.receipt.total }00VNĐ</td>
									<td><a href="">
											<button data-toggle="tooltip" title="Detail"
												class="pd-setting-ed">Detail</button>
									</a> <a href=""><button data-toggle="tooltip" title="Edit"
												class="pd-setting-ed">
												<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
											</button> </a> <a onclick="return confirm('Bạn có chắc muốn xóa')"
										href="<%=request.getContextPath()%>/admin/deleteOrder/${order.receipt.receiptId }">
											<button data-toggle="tooltip" title="Trash"
												class="pd-setting-ed">
												<i class="fa fa-trash-o" aria-hidden="true"> </i>
											</button>
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--FOOTER -->

	<jsp:directive.include file="footer.jsp" />

	<!-- END FOOTER -->
</body>
</html>