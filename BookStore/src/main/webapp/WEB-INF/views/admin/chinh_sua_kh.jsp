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

	<div class="all-content-wrapper">
		<!-- Single pro tab start-->
		<div class="single-product-tab-area mg-b-30">
			<!-- Single pro tab review Start-->
			<div class="single-pro-review-area">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="review-tab-pro-inner">
								<ul id="myTab3" class="tab-review-design">
									<a>@ViewBag.error</a>
									<li class="active"><a href="#description"> <i
											class="icon nalika-edit" aria-hidden="true"> </i> Chỉnh sửa
											người dùng
									</a></li>
								</ul>
								<div id="myTabContent" class="tab-content custom-product-edit">
									<div class="product-tab-list tab-pane fade active in"
										id="description">
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<form method="post">
													<input type="text" hidden name="id" value="@Model.id">

													<div class="review-content-section">
														<div class="input-group mg-b-pro-edt">
															<span class="input-group-addon"> <i
																class="fa fa-usd" aria-hidden="true"> </i>
															</span> <input type="text" class="form-control" name="username"
																placeholder="UserName" value="@Model.userName">
														</div>
														<div class="input-group mg-b-pro-edt">
															<span class="input-group-addon"> <i
																class="icon nalika-user" aria-hidden="true"> </i>
															</span> <input type="text" class="form-control" name="email"
																placeholder="Email" value="@Model.email">
														</div>
														@*
														<div class="input-group mg-b-pro-edt">
															*@ @* <span class="input-group-addon"> *@ @* <i
																class="icon nalika-edit" * @ @* aria-hidden="true">
																	*@ @* </i> *@ @*
															</span> *@ @* <input type="password" name="password"
																class="form-control" * @ @* placeholder="Password"
																value="@Model.password" disabled> *@ @*
														</div>
														*@
														<div class="input-group mg-b-pro-edt">
															<span class="input-group-addon"> <i
																class="icon nalika-edit" aria-hidden="true"> </i>
															</span> <input type="text" name="phone" class="form-control"
																placeholder="Phone" value="@Model.phone">
														</div>
														<div class="input-group mg-b-pro-edt">
															<span class="input-group-addon"> <i
																class="fa fa-usd" aria-hidden="true"> </i>
															</span> <input type="text" class="form-control" name="address"
																placeholder="Address" value="@Model.address">
														</div>
														<div class="input-group mg-b-pro-edt">
															<span class="input-group-addon"> <i
																class="icon nalika-edit" aria-hidden="true"> </i>
															</span> <input type="text" class="form-control" name="gender"
																placeholder="Gender" value="@Model.gender">
														</div>
														<div class="input-group mg-b-pro-edt">
															<span class="input-group-addon"> <i
																class="fa fa-usd" aria-hidden="true"> </i>
															</span> <input type="text" class="form-control" name="level"
																placeholder="Level" value="@Model.level">
														</div>
													</div>
													<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
														<div class="text-center custom-pro-edt-ds">
															<button type="submit"
																class="btn btn-ctl-bt waves-effect waves-light">
																LƯU</button>
															<a href="@Url.Action("khach_hang", "Admin")">
																<button type="button"
																	class="btn btn-ctl-bt waves-effect waves-light">
																	HỦY</button>
															</a>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
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