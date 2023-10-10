package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import vo.CustomerVo;


public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDAO customerDao;
       
    
    public CustomerListServlet() {
        super();
    }

   
    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println(">> init"); ///첫 호출
    	String driver = config.getInitParameter("driverClass");
    	String url = config.getInitParameter("dbUrl");
    	String username = config.getInitParameter("dbUsername");
    	String password = config.getInitParameter("dbPassword");
    	
    	customerDao = new CustomerDAO(driver, url, username, password);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>doGet");
		response.setContentType("text/html;charset=UTF-8");
		List<CustomerVo> customerList = customerDao.getCustomerList();
		request.setAttribute("customerList", customerList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerList.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println(">> destroy"); //없어질때 / customerdao의 connectionCLose() 
		customerDao.connectionCLose();
	}

}
