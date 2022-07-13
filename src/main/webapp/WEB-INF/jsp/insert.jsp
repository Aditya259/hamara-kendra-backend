<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.solar.Model.Services"%>
<%@ page import="com.solar.Model.SubMenuServices"%>
<%@ page import="com.solar.Model.ThirdLevelSubMenu"%>
<html>
<head></head>
<body>
<% 
		List<Services> serviceList = (List<Services>) request.getAttribute("menuList");
		List<SubMenuServices> subMenuList = (List<SubMenuServices>) request.getAttribute("subMenuList");
		List<ThirdLevelSubMenu> thirdLevelMenu = (List<ThirdLevelSubMenu>) request.getAttribute("thirdLevelMenu"); 
%>
<form>
	<div>
		<select>
			<option>Select Menu</option>
				<%
				if (serviceList != null) {
					for (Services menu : serviceList) {
				%>
					<option><%=menu.getName() %></option>
				<%
					}
				}
				%>
		</select>
	</div>

	<div>
		<select>
			<option>Select SubMenu</option>
				<%
				if (subMenuList != null) {
					for (SubMenuServices subMenu : subMenuList) {
				%>
					<option><%=subMenu.getName() %></option>
				<%
					}
				}
				%>
		</select>
	</div>
	
	
	<div>
		<select>
			<option>Select Third Level SubMenu</option>
				<%
				if (thirdLevelMenu != null) {
					for (ThirdLevelSubMenu thirdLvlMenu : thirdLevelMenu) {
				%>
					<option><%=thirdLvlMenu.getName() %></option>
				<%
					}
				}
				%>
		</select>
	</div>
	
	
	
</form>



</body>
</html>