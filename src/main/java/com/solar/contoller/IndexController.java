package com.solar.contoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.solar.Model.Admins;
import com.solar.Model.Services;
import com.solar.Model.SubMenuDescription;
import com.solar.Model.SubMenuServices;
import com.solar.Model.ThirdLevelSubMenu;
import com.solar.repository.ServicesRepository;
import com.solar.repository.SubMenuDescriptionRepository;
import com.solar.repository.SubMenuServicesRepository;
import com.solar.repository.ThirdLevelSubMenuRepo;

@Controller
public class IndexController {
	
	@Autowired
	ServicesRepository servicesRepository;
	
	@Autowired
	SubMenuServicesRepository subMenuServicesRepository;
	
	@Autowired
	SubMenuDescriptionRepository subMenuDescriptionRepository;
	
	@Autowired
	ThirdLevelSubMenuRepo thirdLevelSubMenuRepo;
	
	@GetMapping("/")
    public String viewBooks(Model model) {
		List<Services> listServices = servicesRepository.findAll();
		List<SubMenuServices> subMenuService = subMenuServicesRepository.findAll();
		List<ThirdLevelSubMenu> thirdLevelMenu = thirdLevelSubMenuRepo.findAll();
		model.addAttribute("menuList", listServices);
		model.addAttribute("subMenuList", subMenuService);
		model.addAttribute("thirdLevelMenu", thirdLevelMenu);
        return "index";
    }
	
	@GetMapping("/service")
    public String aadhar(Model model,@RequestParam("id") String id,@RequestParam("type") String type) {
		System.err.println("id = "+ id);
		System.err.println("type = "+ type);
		boolean flagMenu;
		boolean flagSubMenu;
		boolean flagSubMenuThirdLevel;
		List<Services> listServices = servicesRepository.findAll();
		List<SubMenuServices> subMenuService = subMenuServicesRepository.findAll();
		List<ThirdLevelSubMenu> thirdLevelMenu = thirdLevelSubMenuRepo.findAll();
		List<SubMenuDescription> subDescFilteredList = new ArrayList<SubMenuDescription>();
		
		if(type.equals("1")) {
			Optional<SubMenuServices> subMenuById =  subMenuServicesRepository.findById(Integer.parseInt(id));
			int userId = subMenuById.get().getId();
			List<SubMenuDescription> subDesc = subMenuDescriptionRepository.findAll();
			for(SubMenuDescription subDes : subDesc) {
				if(userId == subDes.getSubServicesId()) {
					subDescFilteredList.add(subDes);
				}
			}
			model.addAttribute("menuList", listServices);
			model.addAttribute("subMenuList", subMenuService);
			model.addAttribute("subMenuById", subMenuById.get());
			model.addAttribute("formData", subDescFilteredList);
			model.addAttribute("thirdLevelMenu", thirdLevelMenu);
			return "about-me";
		}else if(type.equals("2")){
			Optional<ThirdLevelSubMenu> subMenuThirdLevelById =  thirdLevelSubMenuRepo.findById(Integer.parseInt(id));
			int userId = subMenuThirdLevelById.get().getId();
			List<SubMenuDescription> subDesc = subMenuDescriptionRepository.findAll();
			for(SubMenuDescription subDes : subDesc) {
				if(userId == subDes.getSubServicesThirdlevelId()) {
					subDescFilteredList.add(subDes);
				}
			}
			model.addAttribute("menuList", listServices);
			model.addAttribute("subMenuList", subMenuService);
			model.addAttribute("subMenuById", subMenuThirdLevelById.get());
			model.addAttribute("formData", subDescFilteredList);
			model.addAttribute("thirdLevelMenu", thirdLevelMenu);
	        return "about-me";
		}
		
				
		model.addAttribute("menuList", listServices);
		model.addAttribute("subMenuList", subMenuService);
		model.addAttribute("thirdLevelMenu", thirdLevelMenu);
		return "about-me";
    }
	
	@GetMapping("/insertUpdate")
	public String insertUpdate(Model model) {
		List<Services> listServices = servicesRepository.findAll();
		List<SubMenuServices> subMenuService = subMenuServicesRepository.findAll();
		List<ThirdLevelSubMenu> thirdLevelMenu = thirdLevelSubMenuRepo.findAll();
		model.addAttribute("thirdLevelMenu", thirdLevelMenu);
		model.addAttribute("subMenuList", subMenuService);
		model.addAttribute("menuList", listServices);

		return "insert";
	}
	
	
	
	
	
	@GetMapping("/insert")
    public void insert() {
		SubMenuDescription s = new SubMenuDescription();
		s.setId(1);
		s.setFirstDesc("<br>\r\n"
				+ "<b>Required document</b>\r\n"
				+ "<ul>\r\n"
				+ "<li>1. Aadhar Card</li>\r\n"
				+ "<li>2. Pan Card</li>\r\n"
				+ "<li>3. Voting Card</li>\r\n"
				+ "<li>4. Driving Licence</li>\r\n"
				+ "</ul>\r\n"
				+ "<br>\r\n"
				+ "<b>Learning Fee </b>\r\n"
				+ "<table>\r\n"
				+ "<tr>\r\n"
				+ "<td>  466 + 634 Service charges</td>\r\n"
				+ "</tr>\r\n"
				+ "</table>");
		s.setSubServicesId(3);
		s.setSubServicesThirdlevelId(4);
		
				subMenuDescriptionRepository.save(s);
    }

}
