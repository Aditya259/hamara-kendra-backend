<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.solar.Model.Services"%>
<%@ page import="com.solar.Model.SubMenuServices"%>
<jsp:include page="header.jsp" />
<div role="main" class="main">

	<jsp:include page="slider.jsp" />

	<section class="section bg-color-light border-0 m-0">
		<div class="container">
			<div class="row text-center text-md-start">

				<%
					List<Services> serviceList = (List<Services>) request.getAttribute("menuList");
					if(serviceList!=null){
					for(Services menu : serviceList){
					if(!menu.getName().equals("Other Services")){			            
				%>
				<div class="col-md-4 mb-4 mb-md-0 appear-animation"
					data-appear-animation="fadeInLeftShorter"
					data-appear-animation-delay="200">
						<a href="#">
					<div
						class="row align-items-center justify-content-center justify-content-md-start">
						<div class="col-4">
							<img class="img-fluid mb-4 mb-lg-0" src="<%=menu.getImageUrl() %>"
								alt="">
						</div>
						<div class="col-lg-8">
							<h2 class="font-weight-bold text-5 line-height-5 mb-1"><%=menu.getName() %></h2>
							<p class="mb-0"></p>
						</div>
					</div>
					</a>
				</div>
				
				<%
					}
					}
					}
				%>
			</div>
		</div>
	</section>
	<section
		class="section section-height-3 bg-color-grey-scale-1 m-0 border-0">
		<div class="container">
			<div class="row align-items-center justify-content-center">
				<div class="col-lg-6 pb-sm-4 pb-lg-0 pe-lg-5 mb-sm-5 mb-lg-0">
					<h2 class="text-color-dark font-weight-normal text-6 mb-2">
						Other <strong class="font-weight-extra-bold">Services</strong>
					</h2>
					<p class="lead pe-lg-5 me-lg-5">Other Services includes below servivces</p>
					<ul>
					<li>New Aadhar Card</li>
					<li>Aadhar Update</li>
					<li>New Passport</li>
					<li>Driving Licence</li>
					<li>Pancard Offiline</li>
					<li>PanCard Online</li>
					<li>New Voting Card</li>
					<li>New Ration Card</li>
					<li>Food Licence</li>
					<li>Gumasta</li>
					<li>Police Verification</li>
					<li>Smart Card</li>
					
					</ul>
					<a href="http://103.220.223.59/#/serviceSelection"
						class="btn btn-dark font-weight-semibold btn-px-4 btn-py-2 text-2">LOAD MORE</a>
				</div>
				<div
					class="col-sm-8 col-md-6 col-lg-4 offset-sm-4 offset-md-4 offset-lg-2 position-relative mt-sm-5"
					style="top: 1.7rem;">
					<img src="images/license-icon.jpg"
						class="img-fluid position-absolute d-none d-sm-block appear-animation"
						data-appear-animation="expandIn" data-appear-animation-delay="300"
						style="top: 10%; left: -50%;" alt="" /> <img
						src="images/poilice-verification.jpg"
						class="img-fluid position-absolute d-none d-sm-block appear-animation"
						data-appear-animation="expandIn" style="top: -33%; left: -29%;"
						alt="" /> <img src="images/smart-card.jpg"
						class="img-fluid position-relative appear-animation mb-2"
						data-appear-animation="expandIn" data-appear-animation-delay="600"
						alt="" />
				</div>
			</div>
		</div>
	</section>

	<div class="container">
		<div class="row py-5 my-5">
			<div
				class="col-md-6 order-2 order-md-1 text-center text-md-start appear-animation mt-2 pt-1"
				data-appear-animation="fadeInRightShorter">
				<div class="owl-carousel owl-theme nav-style-1 mb-0"
					data-plugin-options="{'responsive': {'576': {'items': 1}, '768': {'items': 1}, '992': {'items': 2}, '1200': {'items': 2}}, 'margin': 25, 'loop': true, 'nav': false, 'dots': false, 'autoplay': true, 'autoplayTimeout': 3000}">
					<div>
						<img class="img-fluid rounded-0 mb-4" src="images/aadar-800.png"
							alt="" />
						<h3 class="font-weight-bold text-color-dark text-4 mb-0">Apply For New Aadhar</h3>
					</div>
					<div>
						<img class="img-fluid rounded-0 mb-4" src="images/passport-800.jpg"
							alt="" />
						<h3 class="font-weight-bold text-color-dark text-4 mb-0">Apply For New Password</h3>
						<p class="text-2 mb-0">CEO</p>
					</div>
					<div>
						<img class="img-fluid rounded-0 mb-4" src="images/smartcard-800.jpg"
							alt="" />
						<h3 class="font-weight-bold text-color-dark text-4 mb-0">Apply For Smart Card</h3>
						<p class="text-2 mb-0">DEVELOPER</p>
					</div>
					<div>
						<img class="img-fluid rounded-0 mb-4" src="images/rto-800.jpg"
							alt="" />
						<h3 class="font-weight-bold text-color-dark text-4 mb-0">Apply For Licence</h3>
						<p class="text-2 mb-0">SEO ANALYST</p>
					</div>
					<div>
						<img class="img-fluid rounded-0 mb-4" src="images/pancard-800.jpg"
							alt="" />
						<h3 class="font-weight-bold text-color-dark text-4 mb-0">Apply For PanCard</h3>
						<p class="text-2 mb-0">DESIGNER</p>
					</div>
				</div>
			</div>
			<div
				class="col-md-6 order-1 order-md-2 text-center text-md-start mb-5 mb-md-0 appear-animation"
				data-appear-animation="fadeInRightShorter"
				data-appear-animation-delay="200">
				<h2 class="text-color-dark font-weight-normal text-6 mb-2">
					Apply For <strong class="font-weight-extra-bold">desired Service</strong>
				</h2>
				<p class="lead"><br><br><br><br><br><br><br></p>
				<a href="http://103.220.223.59/#/serviceSelection"
					class="btn btn-dark font-weight-semibold rounded-0 px-5 btn-py-2 text-2 p-relative bottom-3">Apply Now
					</a>
			</div>
		</div>
	</div>

	
</div>

<jsp:include page="footer.jsp" />
