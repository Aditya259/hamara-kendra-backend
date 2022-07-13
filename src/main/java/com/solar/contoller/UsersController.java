package com.solar.contoller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solar.Model.Admins;
import com.solar.Model.BookingDetails;
import com.solar.Model.EmployeeDetails;
import com.solar.Model.Services;
import com.solar.Model.SubMenuDescription;
import com.solar.Model.SubMenuServices;
import com.solar.Model.ThirdLevelSubMenu;
import com.solar.repository.AdminRepo;
import com.solar.repository.BookingRepo;
import com.solar.repository.EmployeeDetailsRepo;
import com.solar.repository.ServicesRepository;
import com.solar.repository.SubMenuDescriptionRepository;
import com.solar.repository.SubMenuServicesRepository;
import com.solar.repository.ThirdLevelSubMenuRepo;
import com.solar.utils.Constants;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	AdminRepo adminRepo;

	@Autowired
	BookingRepo bookingRepo;

	@Autowired
	EmployeeDetailsRepo employeeDetailsRepo;
	
	@Autowired
	ServicesRepository servicesRepository;
		
	@Autowired
	SubMenuServicesRepository subMenuServicesRepository;
	
	@Autowired
	SubMenuDescriptionRepository subMenuDescriptionRepository;
	
	@Autowired
	ThirdLevelSubMenuRepo thirdLevelSubMenuRepo;
	
	
	@GetMapping("/getAllMenu")
	public ResponseEntity<Map> getAllMenu() {
		Map m = new HashMap();
		List<Services> listServices = servicesRepository.findAll();
		m.put(Constants.status, true);
		m.put(Constants.data, listServices);
		System.err.println(m.get(Constants.data));
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}
	
	@GetMapping("/getAllSubMenu")
	public ResponseEntity<Map> getAllSubMenu() {
		Map m = new HashMap();
		List<SubMenuServices> listServices = subMenuServicesRepository.findAll();
		m.put(Constants.status, true);
		m.put(Constants.data, listServices);
		System.err.println(m.get(Constants.data));
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}
	
	@GetMapping("/getAllSubMenuThirdLevel")
	public ResponseEntity<Map> getAllSubMenuThirdLevel() {
		Map m = new HashMap();
		List<ThirdLevelSubMenu> listServices = thirdLevelSubMenuRepo.findAll();
		m.put(Constants.status, true);
		m.put(Constants.data, listServices);
		System.err.println(m.get(Constants.data));
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllServices")
	public ResponseEntity<Map> getAllServices() {
		Map m = new HashMap();
		List<Services> listServices = servicesRepository.findAll();
		m.put(Constants.status, true);
		m.put(Constants.data, listServices);
		System.err.println(m.get(Constants.data));
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}
	
	@PostMapping("/otp")
	public ResponseEntity<Map> otp(@RequestBody Admins admins) {
		String otp = admins.getOtp();
		Map m = new HashMap();
		if (otp != null && !otp.isEmpty()) {
			if(otp.equals("123")) {
				m.put(Constants.status, true);
				m.put(Constants.message, Constants.OTPSuccess);
				return new ResponseEntity<Map>(m, HttpStatus.OK);
			}else {
				m.put(Constants.status, false);
				m.put(Constants.message, "Invalide OTP");
				return new ResponseEntity<Map>(m, HttpStatus.OK);
			}
		}
		return null;
	}

	// signup
	@PostMapping("/signup")
	public ResponseEntity<Map> signup(@RequestBody Admins admins) {
		System.err.println(admins);
		String user = admins.getUser();
		String pass = admins.getPass();
		String mobileNo = admins.getMobileNo();
		Map m = new HashMap();
		if (user != null && !user.isEmpty() && pass != null && !pass.isEmpty()
				|| mobileNo != null && !mobileNo.isEmpty()) {
			Admins a = null;
			Admins admin = new Admins();
			if (mobileNo != null && !mobileNo.isEmpty()) {
				admin.setMobileNo(mobileNo);
			}
			admin.setUser(user);
			admin.setPass(pass);
			admin.setDepartment("1");
			try {
				a = adminRepo.save(admin);
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error("User Not found!!!");
			}
			if (a != null && a.getPass().equals(pass)) {
				a.setStatus("success");
				m.put(Constants.status, true);
				m.put(Constants.message, Constants.SignUpSuccess);
				m.put(Constants.data, a);
				return new ResponseEntity<Map>(m, HttpStatus.OK);
			} else {
				admin.setStatus("Not success");
				m.put(Constants.status, false);
				m.put(Constants.message, "Invalide UserName and Password");
				m.put(Constants.data, admin);
				return new ResponseEntity<Map>(m, HttpStatus.OK);
			}

		}
		return null;

	}

	@PostMapping("/login")
	public ResponseEntity<Map> login(@RequestBody Admins admins,@RequestParam("liveOrLastLocation") String liveOrLastLocation) {
		System.err.println(admins);
		String user = admins.getUser();
		String pass = admins.getPass();
		String mobileNo = admins.getMobileNo();
		Map m = new HashMap();
		if (user != null && !user.isEmpty() && pass != null && !pass.isEmpty()) {
			Admins a = null;
			Admins admin = new Admins();
			try {
				a = adminRepo.findByuser(user);
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error("User Not found!!!");

			}
			if (a != null && a.getPass().equals(pass)) {
				System.err.println(admins.getLiveOrLastLocation());
				a.setLiveOrLastLocation(liveOrLastLocation);
				
				adminRepo.save(a);
				a.setStatus("success");
				m.put(Constants.status, true);
				m.put(Constants.message, Constants.LoginSuccess);
				m.put(Constants.data, a);
				m.put("otp", false);

				return new ResponseEntity<Map>(m, HttpStatus.OK);
			} else {
				admin.setStatus("Not success");
				m.put(Constants.status, false);
				m.put(Constants.message, "Invalide UserName and Password");
				m.put(Constants.data, admin);
				m.put("otp", false);

				return new ResponseEntity<Map>(m, HttpStatus.OK);
			}
		} else if (mobileNo != null && !mobileNo.isEmpty()) {
			Admins a = null;
			try {
				a = adminRepo.findBymobileNo(mobileNo);
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error("User Not found!!!");
			}
			if (a != null && a.getMobileNo().equals(mobileNo)) {
				//a.setStatus("success");
				m.put(Constants.status, true);
				m.put(Constants.message, Constants.LoginSuccess);
				m.put(Constants.data, a);
				m.put("otp", true);
				return new ResponseEntity<Map>(m, HttpStatus.OK);
			} else {
				//a.setStatus("Not success");
				m.put(Constants.status, false);
				m.put(Constants.message, "Invalid Mobile No.");
				m.put(Constants.data, a);
				m.put("otp", false);

				return new ResponseEntity<Map>(m, HttpStatus.OK);
			}
		}
		return null;
	}

	@PostMapping("/submitBookingDetails")
	public ResponseEntity<Map> submitBookingDetails(@RequestBody BookingDetails bookingDetails) {
		Map m = new HashMap();
		bookingDetails.setBookingId(getRandomNumberString());
		bookingRepo.save(bookingDetails);
		m.put(Constants.status, true);
		m.put(Constants.message, "Success");
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}
	
	@PostMapping("/submitDescDetails")
	public ResponseEntity<Map> submitDescDetails(@RequestBody SubMenuDescription subMenuDescription) {
		Map m = new HashMap();
		System.err.println("subMenuDescription = "+subMenuDescription);
		subMenuDescriptionRepository.save(subMenuDescription);
		m.put(Constants.status, true);
		m.put(Constants.message, "Success");
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}
	
	@GetMapping("/getAllServiceList")
	public ResponseEntity<Map> getAllServiceList(Model model) {
		Map m = new HashMap();
		List<String> listServices = new ArrayList<String>();
		List<SubMenuServices> subMenuService = subMenuServicesRepository.findAll();
		List<ThirdLevelSubMenu> thirdLevelMenu = thirdLevelSubMenuRepo.findAll();
		for(SubMenuServices s1: subMenuService) {
			listServices.add(s1.getName());
		}
		for(ThirdLevelSubMenu s2: thirdLevelMenu) {
			listServices.add(s2.getName());
		}
		
		
		m.put(Constants.status, true);
		m.put(Constants.message, "Success");
		m.put(Constants.data, listServices);
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}
	
	
	@GetMapping("/getliveOrLastLocation")
	public ResponseEntity<Map> getliveOrLastLocation(@RequestParam("role") String role,@RequestParam("userLoggedInName") String userLoggedInName) {
		Map m = new HashMap();
		List<Admins> listOfAdmins = adminRepo.findAll();
		if(role.equals("1")) {
		System.err.println("role"+role);
		System.err.println("userLoggedInName"+userLoggedInName);
		listOfAdmins = listOfAdmins.stream().filter(p->
				p.getLiveOrLastLocation()!=null
				&&
				!p.getLiveOrLastLocation().isEmpty()
				&&
				p.getName().equals(userLoggedInName)
				).collect(Collectors.toList());
		listOfAdmins.forEach(e->{
			e.setName(e.getName().toUpperCase());
		});
		}else {
			listOfAdmins = listOfAdmins.stream().filter(p->
			p.getLiveOrLastLocation()!=null
			&&
			!p.getLiveOrLastLocation().isEmpty()
					).collect(Collectors.toList());
			listOfAdmins.forEach(e->{
				e.setName(e.getName().toUpperCase());
			});
		}
		System.err.println(listOfAdmins);
		if (listOfAdmins != null && !listOfAdmins.isEmpty()) {
			System.err.println("listOfAdmins = "+listOfAdmins);
			m.put(Constants.status, true);
			m.put(Constants.message, "Success");
			m.put(Constants.data, listOfAdmins);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} else {
			m.put(Constants.status, false);
			m.put(Constants.message, "Not_Found");
			m.put(Constants.data, listOfAdmins);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		}

	}
	
	@GetMapping("/getUpCommingEvents")
	public ResponseEntity<Map> getUpCommingEvents(@RequestParam("loggedInName") String loggedInName,@RequestParam("loggedInRole") String loggedInRole) {
		System.err.println("loggedInName=>"+loggedInName);
		System.err.println("loggedInRole=>"+loggedInRole);
		Map m = new HashMap();
		List<BookingDetails> bookDetails = bookingRepo.findAll();
		if(loggedInRole.equals("1")) {
			System.err.println("role 1");
		bookDetails = bookDetails.stream().filter(p->
			p.getEmployeeName().equals(loggedInName)
			&& 
			p.getBookingStatus().equals("Pending")
		).collect(Collectors.toList());
		}else {
			System.err.println("role not 1");	
		}
		
		System.err.println("bookDetails upcomming = "+bookDetails);
		if (bookDetails != null && !bookDetails.isEmpty()) {
			m.put(Constants.status, true);
			m.put(Constants.message, "Success");
			m.put(Constants.data, bookDetails);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} else {
			m.put(Constants.status, false);
			m.put(Constants.message, "Not_Found");
			m.put(Constants.data, bookDetails);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		}
		
		
	}
	

	@GetMapping("/getAllBooking")
	public ResponseEntity<Map> getAllBooking() {
		Map m = new HashMap();
		List<BookingDetails> bookDetails = bookingRepo.findAll();
		if (bookDetails != null && !bookDetails.isEmpty()) {
			m.put(Constants.status, true);
			m.put(Constants.message, "Success");
			m.put(Constants.data, bookDetails);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} else {
			m.put(Constants.status, false);
			m.put(Constants.message, "Not_Found");
			m.put(Constants.data, bookDetails);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		}
	}

	@GetMapping("/getBookingById")
	public ResponseEntity<Map> getBookingById(@RequestParam("id") String id) {
		Map m = new HashMap();
		Optional<BookingDetails> bookDetails = bookingRepo.findById(Integer.parseInt(id));
		if (bookDetails != null && !bookDetails.isEmpty()) {
			m.put(Constants.status, true);
			m.put(Constants.message, "Success");
			m.put(Constants.data, bookDetails);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} else {
			m.put(Constants.status, false);
			m.put(Constants.message, "Not_Found");
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		}
	}

	@GetMapping("/getEmployeeById")
	public ResponseEntity<Map> getEmployeeById(@RequestParam("id") String id) {
		Map m = new HashMap();
		Optional<EmployeeDetails> employeeDetails = employeeDetailsRepo.findById(Integer.parseInt(id));
		if (employeeDetails != null && !employeeDetails.isEmpty()) {
			m.put(Constants.status, true);
			m.put(Constants.message, "Success");
			m.put(Constants.data, employeeDetails);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} else {
			m.put(Constants.status, false);
			m.put(Constants.message, "Not_Found");
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		}
	}

	@GetMapping("/getEmployeeName")
	public ResponseEntity<Map> getEmployeeName() {
		Map m = new HashMap();
		List<String> listOfEmpName = new ArrayList();
		List<EmployeeDetails> employeeDetails = employeeDetailsRepo.findAll();
		if (employeeDetails != null && !employeeDetails.isEmpty()) {
			for (EmployeeDetails empList : employeeDetails) {
				listOfEmpName.add(empList.getEmployeeName());
			}

			m.put(Constants.status, true);
			m.put(Constants.message, "Success");
			m.put(Constants.data, listOfEmpName);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} else {
			m.put(Constants.status, false);
			m.put(Constants.message, "Not_Found");
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		}
	}

	@PostMapping("/submitEmployeeDetails")
	public ResponseEntity<Map> submitEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
		Map m = new HashMap();
		employeeDetails.setEmployeeId(getRandomNumberString());
		EmployeeDetails savedEmp = employeeDetailsRepo.save(employeeDetails);
		if (savedEmp != null) {
			Admins admin = new Admins();
			admin.setName(savedEmp.getEmployeeName());
			admin.setUser(savedEmp.getEmployeeUserName());
			admin.setPass(savedEmp.getEmployeePassword());
			admin.setRole("1");
			adminRepo.save(admin);
		}
		m.put(Constants.status, true);
		m.put(Constants.message, "Success");
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<Map> getAllEmployee() {
		Map m = new HashMap();
		List<EmployeeDetails> employeeDetails = employeeDetailsRepo.findAll();
		if (employeeDetails != null && !employeeDetails.isEmpty()) {
			m.put(Constants.status, true);
			m.put(Constants.message, "Success");
			m.put(Constants.data, employeeDetails);
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		} else {
			m.put(Constants.status, false);
			m.put(Constants.message, "Not_Found");
			return new ResponseEntity<Map>(m, HttpStatus.OK);
		}
	}

	@GetMapping("/getLocation")
	public ResponseEntity<Map> getCurrentLocation(@RequestParam("lat") String lat, @RequestParam("lng") String lng)
			throws IOException {
		Map m = new HashMap();
		Map<String, String> respMap = new HashMap<String, String>();
		System.err.println(lng + lat);
		JSONObject jObj = getLocation(lng, lat);
		m.put(Constants.status, true);
		m.put(Constants.message, "Success");
		respMap.put("country", jObj.get("country").toString());
		respMap.put("city", jObj.get("city").toString());
		if(jObj.has("postcode")) {
		respMap.put("postcode", jObj.get("postcode").toString());
		}
		respMap.put("state", jObj.get("state").toString());
		respMap.put("country_code", jObj.get("country_code").toString());
		String str = jObj.get("subArea1").toString().replaceAll("\\[", "").replaceAll("\\]", "");
		str = str.replaceAll("^\"|\"$", "");
		respMap.put("subArea1", str);
		// System.err.println("respMap ="+respMap);
		m.put(Constants.data, respMap);
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}

	private JSONObject getLocation(String lng, String lat) throws IOException {
		JSONObject json = null;
		URL url = new URL("https://api.geoapify.com/v1/geocode/reverse?lat=" + lat + "&lon=" + lng
				+ "&apiKey=e368e9248544414fa646e3d12edf4064");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.setRequestProperty("Accept", "application/json");
		// System.err.println(http.getContent().toString());
		// System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		BufferedReader br = null;
		if (http.getResponseCode() == 200) {
			br = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String strCurrentLine;
			while ((strCurrentLine = br.readLine()) != null) {
				// System.out.println(strCurrentLine);
				json = new JSONObject(strCurrentLine);
				// System.out.println("json ="+json);
			}
		} else {
			br = new BufferedReader(new InputStreamReader(http.getErrorStream()));
			String strCurrentLine;
			while ((strCurrentLine = br.readLine()) != null) {
				// System.out.println(strCurrentLine);
			}
		}
		http.disconnect();
		// JSONObject jsonObj = (JSONObject) json.get("properties");
		// System.err.println("jsonObj ="+json);
		JSONArray features = json.getJSONArray("features");

		JSONObject jsonObj = ((JSONObject) features.get(0)).getJSONObject("properties");
		// System.err.println("jsonObj ="+jsonObj);
		String subArea = (String) jsonObj.get("formatted");
		// System.err.println("subArea ===>"+subArea);
		jsonObj.append("subArea1", subArea);
		return jsonObj;
	}

	public static String getRandomNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		// this will convert any number sequence into 6 character.
		return String.format("%06d", number);
	}
}
