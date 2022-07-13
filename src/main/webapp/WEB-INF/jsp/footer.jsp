<%@ page import="java.util.List"%>
<%@ page import="com.solar.Model.Services"%>
<%@ page import="com.solar.Model.SubMenuServices"%>
<footer id="footer" class="mt-0">
	<div class="container my-4">
		<div class="row py-5">
			<div class="col-md-6 col-lg-3 mb-5 mb-lg-0">
				<h5
					class="text-5 text-transform-none font-weight-semibold text-color-light mb-4">Main
					Office</h5>
				<p class="text-4 mb-0">Chadmari Nagar</p>
				<p class="text-4 mb-0">Near 4G Tower</p>
				<p class="text-4 mb-0">Bhandewadi Road Nagpur 440035, MH, IN</p>
			</div>
			<div class="col-md-6 col-lg-3 mb-5 mb-lg-0">
				<h5
					class="text-5 text-transform-none font-weight-semibold text-color-light mb-4">Branch
					Office</h5>
				<p class="text-4 mb-0">Aanand budh vihar</p>
				<p class="text-4 mb-0">Bhandewadi Pardi</p>
				<p class="text-4 mb-0">Nagpur 440035, MH, IN</p>
			</div>
			<div class="col-md-6 col-lg-3 mb-5 mb-lg-0">
				<h5
					class="text-5 text-transform-none font-weight-semibold text-color-light mb-4">Services</h5>
				<%
				List<Services> serviceList = (List<Services>) request.getAttribute("menuList");
				List<SubMenuServices> subMenuList = (List<SubMenuServices>) request.getAttribute("subMenuList");
				if (serviceList != null) {
					for (Services menu : serviceList) {
				%>
				<li class="dropdown-submenu"><alass ="dropdown-item" href="#"><%=menu.getName()%></a>
					<%
					if (subMenuList != null) {
					%>
					<ul class="dropdown-menu">
						<%
						for (SubMenuServices subMenu : subMenuList) {
						%>
						<%
						if (menu.getId() == subMenu.getServicesId()) {
						%>
						<p class="text-4 mb-0"><a class="dropdown-item"
							href="feature-headers-classic.html"><%=subMenu.getName()%></a></p>
						
						<%
						}
						}
						%>
					</ul>
					<%
					}
					%>
					</li>
				<%
				}
				}
				%>
			</div>
			<div class="col-md-6 col-lg-3">
				<h5
					class="text-5 text-transform-none font-weight-semibold text-color-light mb-4">Social
					Media</h5>
				<ul class="footer-social-icons social-icons m-0">
					<li class="social-icons-facebook"><a
						href="http://www.facebook.com/" target="_blank" title="Facebook"><i
							class="fab fa-facebook-f text-2"></i></a></li>
					<li class="social-icons-twitter"><a
						href="http://www.twitter.com/" target="_blank" title="Twitter"><i
							class="fab fa-twitter text-2"></i></a></li>
					<li class="social-icons-linkedin"><a
						href="http://www.linkedin.com/" target="_blank" title="Linkedin"><i
							class="fab fa-linkedin-in text-2"></i></a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="footer-copyright footer-copyright-style-2 pb-4">
			<div class="py-2">
				<div class="row py-4">
					<div
						class="col d-flex align-items-center justify-content-center mb-4 mb-lg-0">
						<p>© Copyright 2019, All Rights Reserved.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>
</div>

<!-- Vendor -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/jquery.appear/jquery.appear.min.js"></script>
<script src="vendor/jquery.easing/jquery.easing.min.js"></script>
<script src="vendor/jquery.cookie/jquery.cookie.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="vendor/jquery.validation/jquery.validate.min.js"></script>
<script src="vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
<script src="vendor/jquery.gmap/jquery.gmap.min.js"></script>
<script src="vendor/lazysizes/lazysizes.min.js"></script>
<script src="vendor/isotope/jquery.isotope.min.js"></script>
<script src="vendor/owl.carousel/owl.carousel.min.js"></script>
<script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
<script src="vendor/vide/jquery.vide.min.js"></script>
<script src="vendor/vivus/vivus.min.js"></script>

<!-- Theme Base, Components and Settings -->
<script src="js/theme.js"></script>

<!-- Current Page Vendor and Views -->
<script src="js/views/view.contact.js"></script>

<!-- Theme Custom -->
<script src="js/custom.js"></script>

<!-- Theme Initialization Files -->
<script src="js/theme.init.js"></script>

</body>
</html>