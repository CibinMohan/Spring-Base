package com.controller;

import java.util.ArrayList;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.Employee;
import com.dao.Manager;
import com.dao.Restaurant;
import com.services.HotelManage;

import com.dao.Table;

import com.dao.Waiter;
import com.dao.interfaceDao;

@Controller
	@RequestMapping("man")
	public class ManagerController {

	HotelManage hotelManage;
	
		@RequestMapping(value = "/manager", method = RequestMethod.GET)
		public ModelAndView getName() {
			
			hotelManage = new HotelManage();
			ArrayList<Manager> managers = hotelManage.getManagers();
			ArrayList<Restaurant> res = hotelManage.getRestaurent();
			ArrayList<Waiter> waiters = hotelManage.getWaiters();
			ArrayList<String> str = new ArrayList<String>();
			interfaceDao user = new interfaceDao();
			ModelAndView mb = new ModelAndView();
			mb.addObject("user", user);
			mb.addObject("manager", managers);
			mb.addObject("restaurant", res);
			mb.setViewName("managerPage");
			//ModelAndView mb = new ModelAndView("managerPage", "restaurant", );
			return mb;
		}
		@RequestMapping(value = "/book", method = RequestMethod.POST)
		public String listName(@Valid interfaceDao user, BindingResult result, ModelMap map) {

			if (result.hasErrors()) {
				return "manage";
			} else {	
				hotelManage = new HotelManage();
				ArrayList<Table> table = hotelManage.retTables(user.getIdRes());
				ArrayList<Waiter> waiters = hotelManage.getWaiters();
				System.out.println(table);
				map.put( "user", user);
				map.put("userData", table);
				map.put("waiters", waiters);
				ModelAndView mb = new ModelAndView();
				mb.addObject("user", user);
				mb.addObject("waiters", waiters);
				mb.addObject("userData", table);
				mb.setViewName("tableadd");
				return "tableadd";
			}
		}
}

