<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop || Witter Multipage Responsive Template</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/JavaScript-autoComplete/1.0.4/auto-complete.min.js"></script>
</head>
<body>
	<!-- Start header section -->
	<jsp:directive.include file="header.jsp" />
	<!-- / header section -->



	<!-- Breadcrumbs Area Start -->
	<div class="breadcrumbs-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="breadcrumbs">
						<h2>Danh Mục Sách</h2>
						<ul class="breadcrumbs-list">
							<li><a title="Quay lại trang chủ"
								href="<%=request.getContextPath()%>">Trang chủ </a></li>
							<li>Sách</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumbs Area Start -->
	<!-- Shop Area Start -->
	<div class="shopping-area section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-12">
					<div class="shop-widget">
						<div class="shop-widget-top">
							<aside class="widget widget-categories">
								<h2 class="sidebar-title text-center">Danh mục</h2>
								<ul class="sidebar-menu">
									<li><a href="<%=request.getContextPath()%>/shop"> <i
											class="fa fa-angle-double-right"></i> Tất cả
									</a></li>
									<c:forEach items="${listcategory}" var="category">
										<li><a
											href="<%=request.getContextPath()%>/shop/${category.maTheLoai }">
												<i class="fa fa-angle-double-right"></i>
												${category.tenTheLoai}
										</a></li>

									</c:forEach>
								</ul>
							</aside>
							<aside class="widget shop-filter">
								<h2 class="sidebar-title text-center">Giá</h2>
								<div class="info-widget">
									<div class="price-filter">
										<div id="slider-range"></div>
										<div class="price-slider-amount">
											<input type="text" id="amount" name="price"
												placeholder="Add Your Price" />
											<div class="widget-buttom">
												<input type="button" value="Tìm Kiếm" onclick="search();" />
											</div>
										</div>
									</div>
								</div>
							</aside>
						</div>
					</div>
				</div>
				<div id="items" class="col-md-9 col-sm-9 col-xs-12">
					<div class="shop-tab-area">
						<div class="shop-tab-list">
							<div class="shop-tab-pill pull-left">
								<ul>
									<li class="active" id="left"><a data-toggle="pill"
										href="#home"><i class="fa fa-th"></i></a></li>
									<li><a data-toggle="pill" href="#menu1"><i
											class="fa fa-th-list"></i></a></li>
								</ul>
							</div>
							<div class="search-book">
								<form name="" class="form-inline">
									<input class="form-control mr-sm-2" type="text" name="tenSach"
										placeholder="Search" aria-label="Search" id="autoSearch" />
									<div id="search"
										style="visibility: visible; opacity: 1; transform: scaleY(1);"></div>
									<button class="btn btn-outline-success my-2 my-sm-0"
										type="button" onclick="search();">
										<i class="fas fa-search"></i>
									</button>
								</form>
							</div>
						</div>
						<div class="tab-content">

							<div class="row tab-pane fade in active" id="home">
								<div id="resuilts">
									<c:forEach items="${listSach }" var="books">
										<div class="shop-single-product-area">
											<div class="col-md-4 col-sm-6">
												<div class="single-banner">
													<div class="product-wrapper">
														<a
															href="<%=request.getContextPath()%>/single_product?ids=${books.maSach }"
															class="single-banner-image-wrapper"> <img alt=""
															src="${pageContext.request.contextPath}${books.hinhAnh}" />
														</a>
														<div class="product-description">
															<div class="functional-buttons">
																<a title="Thêm vào giỏ hàng"
																	href="<%=request.getContextPath()%>/cart/add/${books.maSach }">
																	<i class="fa fa-shopping-cart"></i>
																</a> <a href="<%=request.getContextPath()%>/wishlist"
																	title="Thêm vào danh sách yêu thích"> <i
																	class="far fa-heart"></i>
																</a> <a href="#" title="Xem nhanh" data-toggle="modal"
																	data-target="#productModal1"> <i
																	class="fas fa-compress-alt"></i>
																</a>
															</div>
														</div>
													</div>
													<c:if test="${books.khuyenMai > 10}">
														<div
															style="width: 15%; z-index: 999; position: absolute; top: 0; right: 0;">
															<img
																src="<%=request.getContextPath()%>/assets/img/sale.png"
																alt="" />
															<p
																style="font-size: 14px; position: absolute; left: 15%; top: 55%; transform: translate(0, -50%); color: white;">
																${books.khuyenMai }%</p>
														</div>




														<div class="banner-bottom text-center">
															<div class="banner-bottom-title" style="height: 40px;">
																<a href="#">${books.tenSach}</a>
															</div>
															<div style="color: #32b5f3;" class="price-2">
																${books.gia }.000 VND<span style="color: black;"
																	class="old-price">500.000đ</span>
															</div>
														</div>
													</c:if>
													<c:if test="${books.khuyenMai <= 10}">
														<div class="banner-bottom text-center">
															<div class="banner-bottom-title" style="height: 40px">
																<a href="">${books.tenSach} </a>
															</div>
															<div style="color: #32b5f3" class="price-2">
																${books.gia }.000 VND</div>
														</div>
													</c:if>
												</div>
											</div>

										</div>
									</c:forEach>

								</div>
							</div>

							<div id="menu1" class="tab-pane fade">

								<div id="single-product" class="row">
									<c:forEach items="${listSach }" var="books">
										<div class="single-shop-product">
											<div class="col-xs-12 col-sm-5 col-md-4">
												<div class="left-item">
													<a
														href="<%=request.getContextPath()%>/single_product?ids=${books.maSach }"
														title="Book Name"> <img
														src="<%=request.getContextPath()%>${books.hinhAnh}" alt="" />
													</a>
												</div>

												<div
													style="width: 15%; z-index: 999; position: absolute; top: 0; right: 0;">
													<img
														src="<%=request.getContextPath()%>/assets/img/sale.png"
														alt="" />
													<p
														style="font-size: 14px; position: absolute; left: 15%; top: 55%; transform: translate(0, -50%); color: white;">
														${books.khuyenMai }%</p>
												</div>

											</div>
											<div class="col-xs-12 col-sm-7 col-md-8">
												<div class="deal-product-content">
													<h4>
														<a
															href="<%=request.getContextPath()%>/single_product?ids=${books.maSach }"
															title="Book Name">${books.tenSach}</a>
													</h4>
													<div class="product-price">

														<span class="new-price">${books.gia }.000 VND</span> <span
															class="old-price">500.000đ</span> <span class="new-price"></span>

													</div>
													<p>Hay cực kỳ</p>
													<div class="availability">
														<span><a href="#">Mua Ngay</a></span>
													</div>
												</div>
											</div>
										</div>

									</c:forEach>
								</div>

							</div>

							<div>&nbsp</div>
							<!-- Phân trang -->
							<nav aria-label="Page navigation example">
								<div id="pagination">
									<c:forEach var="loop" begin="1" end="${totalPage}">
										<c:choose>
											<c:when test="${loop == 1}">
												<button class="paging-item active" type="button"
													name="currentPage">${loop}</button>
											</c:when>
											<c:otherwise>
												<button class="paging-item" type="button" id="phantrangid"
													name="currentPage">${loop}</button>
											</c:otherwise>

										</c:choose>

									</c:forEach>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$(".paging-item")
									.click(
											function() {
												/* 	var value = $(this).val(); */
												var sotrang = $(this).text();
												var spbatdau = (sotrang - 1) * 12;
												var result = "";
												console.log(sotrang);

												$
														.ajax({
															type : "GET",
															url : "${pageContext.request.contextPath}/shops",
															data : {
																'currentPage' : sotrang
															},
															dataType : "json",

															success : function(
																	msg) {
																for (var i = 0; i < msg.length; i++) {
																	result += '<div class="col-md-4 col-sm-6" >'
																	result += '<a href="${pageContext.request.contextPath}/single_product?ids='
																			+ msg[i].maSach
																			+ '"class="single-banner-image-wrapper"><img alt="" src = "${pageContext.request.contextPath}'+msg[i].hinhAnh+'"/></a>'
																	result += '<div class="banner-bottom text-center"'
																			+ '<div class="banner-bottom-title" style="height: 40px">'
																			+ '<a href="">'
																			+ msg[i].tenSach
																			+ ' </a>'
																			+ '</div>'
																			+ '</div>'
																			+ '</div>'

																}
																console
																		.log("Mess laf: "
																				+ result);
																/*	$("#search").html(result);*/

																$("#resuilts")
																		.html(
																				result);
															}
														});
											});
						});
	</script>





	<script type="text/javascript">
		function search() {
			$
					.ajax({
						type : "GET",
						url : "${pageContext.request.contextPath}/search",
						data : 'tenSach=' + $("#autoSearch").val(),
						success : function(res) {
							var result = "";
							result += "<ul>";
							$
									.each(
											res,
											function(k, v) {
												result += '<img	src="${pageContext.request.contextPath}'+v.hinhAnh+'" alt="" />'
														+ '<a href="${pageContext.request.contextPath}/single_product?ids='
														+ v.maSach
														+ '">'
														+ '<li class="list-group-item link-class">'
														+ v.tenSach
														+ '</li></a><br/>';
												/* for (var i = 0; i < v.length; i++) {
													result += v[i] + "/n";
												}
												console.log(result);
												 */});

							result += "</ul>";

							/* $('#result').html(result); */
							$('#search').html(result);
						},
						error : function(res) {
							alert("Error while request!");
						}

					});
		}
	</script>

	<!--FOOTER -->

	<jsp:directive.include file="footer.jsp" />

	<!-- END FOOTER -->
</body>

</html>