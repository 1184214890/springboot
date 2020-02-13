package com.qst.controller;

import com.qst.bean.Department;
import com.qst.bean.Employee;
import com.qst.dao.DepartmentDao;
import com.qst.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
    //放在请求狱中
        model.addAttribute("emps",all);
        //会从templates中开始寻找
        return "emp/list";
    }

    //添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depas",departments);
        return "emp/add";
    }

    //员工添加功能
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println(employee);

        employeeDao.save(employee);
        //redirect: 表示重定向一个地址
        //forward: 表示转发到
        return "redirect:/emps";
    }

    //员工修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depas",departments);
        model.addAttribute("emp",employee);
        return "emp/add";
    }

    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:emps";
    }


    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
