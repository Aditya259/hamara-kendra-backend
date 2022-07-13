<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.solar.Model.Services"%>
<%@ page import="com.solar.Model.SubMenuServices"%>
<%@ page import="com.solar.Model.ThirdLevelSubMenu"%>
<!DOCTYPE html>
<html>
<head>

<!-- Basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Hamara Kendra</title>

<meta name="keywords" content="HTML5 Template" />
<meta name="description" content="Porto - Responsive HTML5 Template">
<meta name="author" content="okler.net">

<!-- Favicon -->
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="apple-touch-icon" href="img/apple-touch-icon.png">

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1.0, shrink-to-fit=no">

<!-- Web Fonts  -->
<link id="googleFonts"
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800%7CShadows+Into+Light&display=swap"
	rel="stylesheet" type="text/css">

<!-- Vendor CSS -->
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="vendor/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="vendor/animate/animate.compat.css">
<link rel="stylesheet"
	href="vendor/simple-line-icons/css/simple-line-icons.min.css">
<link rel="stylesheet"
	href="vendor/owl.carousel/assets/owl.carousel.min.css">
<link rel="stylesheet"
	href="vendor/owl.carousel/assets/owl.theme.default.min.css">
<link rel="stylesheet"
	href="vendor/magnific-popup/magnific-popup.min.css">

<!-- Theme CSS -->
<link rel="stylesheet" href="css/theme.css">
<link rel="stylesheet" href="css/theme-elements.css">
<link rel="stylesheet" href="css/theme-blog.css">
<link rel="stylesheet" href="css/theme-shop.css">

<!-- Skin CSS -->
<link id="skinCSS" rel="stylesheet"
	href="css/skins/skin-corporate-3.css">

<!-- Theme Custom CSS -->
<link rel="stylesheet" href="css/custom.css">

<!-- Head Libs -->
<script src="vendor/modernizr/modernizr.min.js"></script>

</head>
<body data-plugin-page-transition>
	<div class="body">
		<header id="header"
			data-plugin-options="{'stickyEnabled': true, 'stickyEnableOnBoxed': true, 'stickyEnableOnMobile': true, 'stickyStartAt': 148, 'stickySetTop': '-148px', 'stickyChangeLogo': true}">
			<div
				class="header-body border-color-primary border-top-0 box-shadow-none">
				<div class="header-container container z-index-2">
					<div class="header-row py-2">
						<div class="header-column">
							<div class="header-row">
								<div class="header-logo header-logo-sticky-change">
									<a href="index.html"> <img
										class="header-logo-sticky opacity-0" alt="Porto" width="100"
										height="48" data-sticky-width="89" data-sticky-height="43"
										data-sticky-top="88" src="img/logo-flat-light.png"> <img
										class="header-logo-non-sticky opacity-0" alt="Porto"
										width="100" height="48" src="img/logo-hamara-kendra.png">
									</a>
								</div>
							</div>
						</div>
						<div class="header-column justify-content-end">
							<div class="header-row">
								<ul class="header-extra-info d-flex align-items-center">
									<li class="d-none d-sm-inline-flex">
										<div class="header-extra-info-icon">
											<i
												class="far fa-envelope text-color-primary text-4 position-relative bottom-2"></i>
										</div>
										<div class="header-extra-info-text">
											<label>SEND US AN EMAIL</label> <strong><a
												href="mailto:mail@example.com"
												class="text-decoration-none text-color-hover-primary">MAIL@EXAMPLE.COM</a></strong>
										</div>
									</li>
									<li>
										<div class="header-extra-info-icon">
											<i
												class="fab fa-whatsapp text-color-primary text-4 position-relative bottom-1"></i>
										</div>
										<div class="header-extra-info-text">
											<label>CALL US NOW</label> <strong><a
												href="tel:8001234567"
												class="text-decoration-none text-color-hover-primary">800-100-0000</a></strong>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="header-nav-bar bg-primary"
					data-sticky-header-style="{'minResolution': 991}"
					data-sticky-header-style-active="{'background-color': 'transparent'}"
					data-sticky-header-style-deactive="{'background-color': '#0088cc'}">
					<div class="container">
						<div class="header-row">
							<div class="header-column">
								<div class="header-row justify-content-end">
									<div
										class="header-nav header-nav-force-light-text justify-content-start py-2 py-lg-3"
										data-sticky-header-style="{'minResolution': 991}"
										data-sticky-header-style-active="{'margin-left': '135px'}"
										data-sticky-header-style-deactive="{'margin-left': '0'}">
										<div
											class="header-nav-main header-nav-main-effect-1 header-nav-main-sub-effect-1">
											<nav class="collapse">
												<ul class="nav nav-pills" id="mainNav">

													<li class="dropdown"><a
														class="dropdown-item dropdown-toggle" href="/">
															Home </a></li>
													<li class="dropdown"><a
														class="dropdown-item dropdown-toggle" href="#">
															Services </a>
														<ul class="dropdown-menu">
														<%
														List<Services> serviceList = (List<Services>) request.getAttribute("menuList");
														List<SubMenuServices> subMenuList = (List<SubMenuServices>) request.getAttribute("subMenuList");
														List<ThirdLevelSubMenu> thirdLevelMenu = (List<ThirdLevelSubMenu>) request.getAttribute("thirdLevelMenu");
											            if(serviceList!=null){
											            for(Services menu : serviceList){
											            
														%>
															<li class="dropdown-submenu"><a
																class="dropdown-item" href="#"><%=menu.getName()%></a> <%if(subMenuList!=null){  %>
																<ul class="dropdown-menu">
																	<% for(SubMenuServices subMenu : subMenuList){ %>
																	<%if(menu.getId() == subMenu.getServicesId()){%>
																	<%if(subMenu.getHref().equals("#") && thirdLevelMenu!=null){ %>
																	<li class="dropdown-submenu" >
																	<a class="dropdown-item"
																		href="<%=subMenu.getHref()%>?type=1&id=<%=subMenu.getId()%>"><%=subMenu.getName()%></a>
																		<ul class="dropdown-menu">
																		 <%for(ThirdLevelSubMenu thrdlevelMnu : thirdLevelMenu){ %>
																			<%if(subMenu.getServicesId() == thrdlevelMnu.getSubMenuServicesId()){%>
																			<li><a class="dropdown-item" href="<%=thrdlevelMnu.getHref()%>?type=2&id=<%=thrdlevelMnu.getId()%>"><%=thrdlevelMnu.getName() %></a></li>
																			
																		<%}
																		}
																		
																		%>
																		</ul>
																		
																		</li>
																	<%}else{
																		%>
																		<li><a class="dropdown-item" href="<%=subMenu.getHref()%>?type=1&id=<%=subMenu.getId()%>"><%=subMenu.getName() %></a></li>
																			
																		<%
																	}
																	}
																}
																%>
																</ul> <%} %></li>
															<%
														}
											            }
														%>
														</ul></li>

												</ul>
											</nav>
										</div>
										<button class="btn header-btn-collapse-nav my-2"
											data-bs-toggle="collapse"
											data-bs-target=".header-nav-main nav">
											<i class="fas fa-bars"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>