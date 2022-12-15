package com.uwc.spring.UWC.Controller;

import org.springframework.stereotype.Controller;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uwc.spring.UWC.Dao.*;
import com.uwc.spring.UWC.Model.*;

@Controller
public class TaskController extends BaseController {

	private UserDao userDao = new UserDao();
	private TaskDao taskDao = new TaskDao();
	private McpDao mcpDao = new McpDao();

	@RequestMapping(value = { "/task_detail" }, method = RequestMethod.GET)
	public ModelAndView chooseDay(HttpServletRequest request, @RequestParam int i_day, @RequestParam int i_month,
			@RequestParam int i_year) {
		HttpSession session = request.getSession();
		String str = Integer.toString(i_year) + "-" + Integer.toString(i_month) + "-" + Integer.toString(i_day);
		Date date = Date.valueOf(str);
		User user = (User) session.getAttribute("currentUser");
		if (user.getPosition_user().equals("Back officer")) {
			_modelAndView.setViewName("user/back_officer");
			HashMap<String, List<Task>> all_task = new HashMap<String, List<Task>>();
			List<Mcp> all_mcp = mcpDao.getAllMcp();
			for (Mcp item : all_mcp) {
				all_task.put(item.getName(), taskDao.getByDayAndIdMcp(date, item.getId()));
			}
			_modelAndView.addObject("all_task", all_task);

		} else if(user.getPosition_user().equals("Collector")) {
			List<Task> listTask = taskDao.getByIdCollectorAndDay(user.getId_user(), date);
			List<Mcp> listMcp = taskDao.getMcpByIdCollectorAndDay(user.getId_user(), date);
			List<User> listJanitor = taskDao.getJanitorByIdCollectorAndDay(user.getId_user(), date);
			
			_modelAndView.setViewName("user/J&C_Detail");
			_modelAndView.addObject("all_task", listTask);
			_modelAndView.addObject("all_mcp", listMcp);
			_modelAndView.addObject("all_janitor", listJanitor);
			_modelAndView.addObject("collector", user);
		}else if(user.getPosition_user().equals("Janitor")) {
			
			String idCollector = taskDao.getIdCollectorByJaniAndDay(user.getId_user(), date);
			
			List<Task> listTask = taskDao.getByIdCollectorAndDay(idCollector, date);
			List<Mcp> listMcp = taskDao.getMcpByIdCollectorAndDay(idCollector, date);
			List<User> listJanitor = taskDao.getJanitorByIdCollectorAndDay(idCollector, date);

			_modelAndView.setViewName("user/J&C_Detail");
			_modelAndView.addObject("all_task", listTask);
			_modelAndView.addObject("all_mcp", listMcp);
			_modelAndView.addObject("all_janitor", listJanitor);
			_modelAndView.addObject("collector", userDao.getById(idCollector));
		}

		_modelAndView.addObject("i_day", i_day);
		_modelAndView.addObject("i_month", i_month);
		_modelAndView.addObject("i_year", i_year);
		return _modelAndView;
	}

	@RequestMapping(value = { "/deleteTask" }, method = RequestMethod.GET)
	public ModelAndView deleteTask(HttpServletRequest request, @RequestParam String idMcp, @RequestParam int i_day,
			@RequestParam int i_month, @RequestParam int i_year) {

		String str = Integer.toString(i_year) + "-" + Integer.toString(i_month) + "-" + Integer.toString(i_day);
		Date date = Date.valueOf(str);
		taskDao.deleteTaskByMcpAndDay(idMcp, date);
		_modelAndView.setViewName("user/index");
		return _modelAndView;
	}

	@RequestMapping(value = { "/assginTask_Collector" }, method = RequestMethod.GET)
	public ModelAndView assginTask_Collector(HttpServletRequest request, @RequestParam String nameMcp,
			@RequestParam int i_day, @RequestParam int i_month, @RequestParam int i_year) {

		_modelAndView.addObject("i_day", i_day);
		_modelAndView.addObject("i_month", i_month);
		_modelAndView.addObject("i_year", i_year);
		_modelAndView.addObject("mcp", mcpDao.getByName(nameMcp));
		_modelAndView.addObject("allCollector", userDao.getByPosition("Collector"));
		_modelAndView.setViewName("user/taskAssign");
		return _modelAndView;
	}

	@RequestMapping(value = { "/assginTask_Jani" }, method = RequestMethod.POST)
	public ModelAndView assginTask_Jani(HttpServletRequest request, @RequestParam String idCollector,
			@RequestParam String idMcp, @RequestParam int i_day, @RequestParam int i_month, @RequestParam int i_year) {
		String str = Integer.toString(i_year) + "-" + Integer.toString(i_month) + "-" + Integer.toString(i_day);
		Date date = Date.valueOf(str);

		User collectorChoose = userDao.getById(idCollector);
		List<User> allJaniWith = taskDao.getJanitorByIdCollectorAndDay(idCollector, date);
		if (allJaniWith.size() != 0) {
			for (User x : allJaniWith) {
				taskDao.addJaniToTask(idCollector, idMcp, x.getId_user(), date);
			}
		}

		_modelAndView.addObject("i_day", i_day);
		_modelAndView.addObject("i_month", i_month);
		_modelAndView.addObject("i_year", i_year);
		_modelAndView.addObject("collector", collectorChoose);
		_modelAndView.addObject("mcp", mcpDao.getById(idMcp));
		_modelAndView.addObject("allJaniWith", taskDao.getJanitorByIdCollectorAndDay(idCollector, date));
		_modelAndView.addObject("janiFree", taskDao.getJaniFreeInDay(date));
		_modelAndView.setViewName("user/taskAssignJani");
		return _modelAndView;
	}

	@RequestMapping(value = { "/addNewJaniToTask" }, method = RequestMethod.POST)
	public ModelAndView addNewJaniToTask(HttpServletRequest request, @RequestParam String idCollector,
			@RequestParam String idJanitor, @RequestParam int i_day, @RequestParam int i_month,
			@RequestParam int i_year, @RequestParam String idMcp) {
		String str = Integer.toString(i_year) + "-" + Integer.toString(i_month) + "-" + Integer.toString(i_day);
		Date date = Date.valueOf(str);

		List<Mcp> listMcp = new ArrayList<Mcp>();
		listMcp = taskDao.getMcpByIdCollectorAndDay(idCollector, date);

		if (listMcp.size() != 0) {
			for (Mcp x : listMcp) {
				taskDao.addJaniToTask(idCollector, x.getId(), idJanitor, date);
			}
		}
		else {
			taskDao.addJaniToTask(idCollector, idMcp, idJanitor, date);
		}
		
		_modelAndView.addObject("i_day", i_day);
		_modelAndView.addObject("i_month", i_month);
		_modelAndView.addObject("i_year", i_year);
		_modelAndView.addObject("collector", userDao.getById(idCollector));
		_modelAndView.addObject("allJaniWith", taskDao.getJanitorByIdCollectorAndDay(idCollector, date));
		_modelAndView.addObject("janiFree", taskDao.getJaniFreeInDay(date));
		_modelAndView.setViewName("user/taskAssignJani");
		return _modelAndView;
	}
	
	@RequestMapping(value = { "/updateTaskView" }, method = RequestMethod.GET)
	public ModelAndView updateTaskView(HttpServletRequest request, @RequestParam String idCollector, @RequestParam String idMcp, @RequestParam int i_day,
			@RequestParam int i_month, @RequestParam int i_year) {

		String str = Integer.toString(i_year) + "-" + Integer.toString(i_month) + "-" + Integer.toString(i_day);
		Date date = Date.valueOf(str);
		
		_modelAndView.addObject("i_day", i_day);
		_modelAndView.addObject("i_month", i_month);
		_modelAndView.addObject("i_year", i_year);
		_modelAndView.addObject("collector", userDao.getById(idCollector));
		_modelAndView.addObject("allJaniWith", taskDao.getJanitorByIdCollectorAndDay(idCollector, date));
		_modelAndView.addObject("janiFree", taskDao.getJaniFreeInDay(date));
		_modelAndView.setViewName("user/taskAssignJani");
		return _modelAndView;
	}
	
	@RequestMapping(value = { "/removeJani" }, method = RequestMethod.GET)
	public ModelAndView removeJani(HttpServletRequest request,@RequestParam String idJani, @RequestParam String idCollector, @RequestParam int i_day,
			@RequestParam int i_month, @RequestParam int i_year) {

		String str = Integer.toString(i_year) + "-" + Integer.toString(i_month) + "-" + Integer.toString(i_day);
		Date date = Date.valueOf(str);
		taskDao.removeJaniFormTask(idJani, date);
		_modelAndView.addObject("i_day", i_day);
		_modelAndView.addObject("i_month", i_month);
		_modelAndView.addObject("i_year", i_year);
		_modelAndView.addObject("collector", userDao.getById(idCollector));
		_modelAndView.addObject("allJaniWith", taskDao.getJanitorByIdCollectorAndDay(idCollector, date));
		_modelAndView.addObject("janiFree", taskDao.getJaniFreeInDay(date));
		_modelAndView.setViewName("user/taskAssignJani");
		return _modelAndView;
	}
	
}
